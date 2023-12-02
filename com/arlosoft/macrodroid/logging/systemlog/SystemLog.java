package com.arlosoft.macrodroid.logging.systemlog;

import androidx.compose.runtime.internal.StabilityInferred;
import com.android.dx.io.Opcodes;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.database.room.LogFlag;
import com.arlosoft.macrodroid.database.room.LogLevel;
import com.arlosoft.macrodroid.database.room.SystemLogEntry;
import com.arlosoft.macrodroid.database.room.SystemLogEntryDao;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.SystemLogTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.utils.WildCardHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.ThreadPoolDispatcherKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SystemLog.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class SystemLog {
    @NotNull
    public static final SystemLog INSTANCE = new SystemLog();
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private static final ArrayDeque<Long> f12680a = new ArrayDeque<>(10);
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private static final CoroutineScope f12681b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getIO()));
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private static final ExecutorCoroutineDispatcher f12682c = ThreadPoolDispatcherKt.newSingleThreadContext("databaseDispatcher");
    public static final int $stable = 8;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemLog.kt */
    /* loaded from: classes3.dex */
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ SystemLogEntry $logEntry;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(SystemLogEntry systemLogEntry, Continuation<? super a> continuation) {
            super(2, continuation);
            this.$logEntry = systemLogEntry;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(this.$logEntry, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            try {
                if (i4 != 0) {
                    if (i4 == 1) {
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    MacroDroidApplication.Companion companion = MacroDroidApplication.Companion;
                    int systemLogMaxLength = Settings.getSystemLogMaxLength(companion.getInstance());
                    SystemLogEntryDao systemLogEntryDao = companion.getInstance().getRoomDatabase().systemLogEntryDao();
                    SystemLogEntry systemLogEntry = this.$logEntry;
                    this.label = 1;
                    if (systemLogEntryDao.addLogEntryAndDeleteOld(systemLogEntry, systemLogMaxLength, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } catch (Exception unused) {
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    private SystemLog() {
    }

    private final void a(String str, long j4) {
        String regexPattern;
        ArrayList arrayList = new ArrayList();
        if (!MacroStore.isInstanceAvailable()) {
            return;
        }
        for (Macro macro : MacroStore.getInstance().getAllCompletedMacros()) {
            if (macro.getGUID() != j4) {
                Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Trigger next = it.next();
                        if (next instanceof SystemLogTrigger) {
                            SystemLogTrigger systemLogTrigger = (SystemLogTrigger) next;
                            String text = systemLogTrigger.getText();
                            if (systemLogTrigger.isContains()) {
                                regexPattern = WildCardHelper.getRegexContainsPattern(text, systemLogTrigger.isEnableRegex(), systemLogTrigger.isIgnoreCase());
                            } else {
                                regexPattern = WildCardHelper.getRegexPattern(text, systemLogTrigger.isEnableRegex(), systemLogTrigger.isIgnoreCase());
                            }
                            if (WildCardHelper.matches(str, regexPattern, systemLogTrigger.isEnableRegex(), systemLogTrigger.isIgnoreCase())) {
                                if (next.constraintsMet()) {
                                    long currentTimeMillis = System.currentTimeMillis();
                                    ArrayDeque<Long> arrayDeque = f12680a;
                                    if (arrayDeque.size() == 10) {
                                        long longValue = arrayDeque.removeFirst().longValue();
                                        arrayDeque.addLast(Long.valueOf(currentTimeMillis));
                                        if (currentTimeMillis - longValue < 2000) {
                                            logErrorDontTrigger("Preventing infinite loop: Not triggering System Log Trigger", j4);
                                        }
                                    } else {
                                        arrayDeque.addLast(Long.valueOf(currentTimeMillis));
                                    }
                                    macro.setTriggerThatInvoked(next);
                                    if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                        arrayList.add(macro);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Macro macro2 = (Macro) it2.next();
            macro2.invokeActionsPreventInfiniteLoop(macro2.getTriggerContextInfo());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0086 A[Catch: Exception -> 0x00b8, TryCatch #0 {Exception -> 0x00b8, blocks: (B:18:0x006f, B:22:0x007a, B:24:0x0080, B:26:0x0086, B:29:0x008e, B:35:0x00b4, B:32:0x0095), top: B:40:0x006f, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x008b  */
    @kotlinx.coroutines.DelicateCoroutinesApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void b(com.arlosoft.macrodroid.database.room.LogLevel r23, java.lang.String r24, long r25, java.lang.String r27, java.lang.String r28, java.lang.String r29, com.arlosoft.macrodroid.database.room.LogFlag r30, java.lang.Boolean r31) {
        /*
            r22 = this;
            r0 = r24
            r14 = r25
            boolean r1 = com.arlosoft.macrodroid.macro.MacroStore.isInstanceAvailable()
            if (r1 == 0) goto L1e
            com.arlosoft.macrodroid.macro.MacroStore r1 = com.arlosoft.macrodroid.macro.MacroStore.getInstance()
            boolean r1 = r1.isExtra(r14)
            if (r1 == 0) goto L1e
            com.arlosoft.macrodroid.database.room.LogLevel r1 = com.arlosoft.macrodroid.database.room.LogLevel.ERROR
            r2 = r23
            if (r2 == r1) goto L20
            com.arlosoft.macrodroid.database.room.LogLevel r1 = com.arlosoft.macrodroid.database.room.LogLevel.DEBUG
            r12 = r1
            goto L21
        L1e:
            r2 = r23
        L20:
            r12 = r2
        L21:
            com.arlosoft.macrodroid.database.room.SystemLogEntry r13 = new com.arlosoft.macrodroid.database.room.SystemLogEntry
            long r3 = java.lang.System.currentTimeMillis()
            r1 = 3000(0xbb8, float:4.204E-42)
            java.lang.String r5 = kotlin.text.StringsKt.take(r0, r1)
            r16 = 0
            r18 = 256(0x100, float:3.59E-43)
            r19 = 0
            r1 = r13
            r2 = r12
            r6 = r25
            r8 = r27
            r9 = r28
            r10 = r29
            r11 = r30
            r20 = r12
            r21 = r13
            r12 = r16
            r14 = r18
            r15 = r19
            r1.<init>(r2, r3, r5, r6, r8, r9, r10, r11, r12, r14, r15)
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            r2 = r31
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r1)
            if (r1 != 0) goto L69
            com.arlosoft.macrodroid.database.room.LogLevel r1 = com.arlosoft.macrodroid.database.room.LogLevel.DEBUG
            r2 = r20
            if (r2 == r1) goto L64
            r1 = r22
            r3 = r25
            r1.a(r0, r3)
            goto L6f
        L64:
            r1 = r22
            r3 = r25
            goto L6f
        L69:
            r1 = r22
            r3 = r25
            r2 = r20
        L6f:
            com.arlosoft.macrodroid.database.room.LogLevel r0 = com.arlosoft.macrodroid.database.room.LogLevel.ERROR     // Catch: java.lang.Exception -> Lb8
            r5 = 0
            if (r2 == r0) goto L95
            r6 = 0
            int r0 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r0 == 0) goto L95
            boolean r0 = com.arlosoft.macrodroid.macro.MacroStore.isInstanceAvailable()     // Catch: java.lang.Exception -> Lb8
            if (r0 == 0) goto L95
            com.arlosoft.macrodroid.macro.MacroStore r0 = com.arlosoft.macrodroid.macro.MacroStore.getInstanceIfAvailable()     // Catch: java.lang.Exception -> Lb8
            if (r0 == 0) goto L8b
            com.arlosoft.macrodroid.macro.Macro r0 = r0.getMacroByGUID(r3)     // Catch: java.lang.Exception -> Lb8
            goto L8c
        L8b:
            r0 = r5
        L8c:
            if (r0 == 0) goto L95
            boolean r0 = r0.isExcludedFromLog()     // Catch: java.lang.Exception -> Lb8
            if (r0 == 0) goto L95
            return
        L95:
            kotlinx.coroutines.CoroutineScope r0 = com.arlosoft.macrodroid.logging.systemlog.SystemLog.f12681b     // Catch: java.lang.Exception -> Lb3
            kotlinx.coroutines.ExecutorCoroutineDispatcher r2 = com.arlosoft.macrodroid.logging.systemlog.SystemLog.f12682c     // Catch: java.lang.Exception -> Lb3
            r3 = 0
            com.arlosoft.macrodroid.logging.systemlog.SystemLog$a r4 = new com.arlosoft.macrodroid.logging.systemlog.SystemLog$a     // Catch: java.lang.Exception -> Lb3
            r6 = r21
            r4.<init>(r6, r5)     // Catch: java.lang.Exception -> Lb3
            r5 = 2
            r6 = 0
            r23 = r0
            r24 = r2
            r25 = r3
            r26 = r4
            r27 = r5
            r28 = r6
            kotlinx.coroutines.BuildersKt.launch$default(r23, r24, r25, r26, r27, r28)     // Catch: java.lang.Exception -> Lb3
            goto Lbc
        Lb3:
            r0 = move-exception
            com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger.logHandledException(r0)     // Catch: java.lang.Exception -> Lb8
            goto Lbc
        Lb8:
            r0 = move-exception
            com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger.logHandledException(r0)
        Lbc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.logging.systemlog.SystemLog.b(com.arlosoft.macrodroid.database.room.LogLevel, java.lang.String, long, java.lang.String, java.lang.String, java.lang.String, com.arlosoft.macrodroid.database.room.LogFlag, java.lang.Boolean):void");
    }

    static /* synthetic */ void c(SystemLog systemLog, LogLevel logLevel, String str, long j4, String str2, String str3, String str4, LogFlag logFlag, Boolean bool, int i4, Object obj) {
        long j5;
        String str5;
        String str6;
        String str7;
        LogFlag logFlag2;
        Boolean bool2;
        if ((i4 & 4) != 0) {
            j5 = 0;
        } else {
            j5 = j4;
        }
        if ((i4 & 8) != 0) {
            str5 = null;
        } else {
            str5 = str2;
        }
        if ((i4 & 16) != 0) {
            str6 = null;
        } else {
            str6 = str3;
        }
        if ((i4 & 32) != 0) {
            str7 = null;
        } else {
            str7 = str4;
        }
        if ((i4 & 64) != 0) {
            logFlag2 = LogFlag.NONE;
        } else {
            logFlag2 = logFlag;
        }
        if ((i4 & 128) != 0) {
            bool2 = Boolean.FALSE;
        } else {
            bool2 = bool;
        }
        systemLog.b(logLevel, str, j5, str5, str6, str7, logFlag2, bool2);
    }

    @JvmStatic
    public static final void log(@NotNull LogLevel logLevel, @NotNull String logText) {
        Intrinsics.checkNotNullParameter(logLevel, "logLevel");
        Intrinsics.checkNotNullParameter(logText, "logText");
        c(INSTANCE, logLevel, logText, 0L, null, null, null, null, null, 240, null);
    }

    @JvmStatic
    public static final void logAction(@NotNull String actionName, long j4) {
        Intrinsics.checkNotNullParameter(actionName, "actionName");
        c(INSTANCE, LogLevel.INFO, actionName, j4, null, null, null, LogFlag.ACTION, null, 184, null);
    }

    public static /* synthetic */ void logAction$default(String str, long j4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            j4 = 0;
        }
        logAction(str, j4);
    }

    @JvmStatic
    public static final void logConstraint(@NotNull String logText, long j4) {
        Intrinsics.checkNotNullParameter(logText, "logText");
        c(INSTANCE, LogLevel.INFO, logText, j4, null, null, null, LogFlag.CONSTRAINT, null, 184, null);
    }

    public static /* synthetic */ void logConstraint$default(String str, long j4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            j4 = 0;
        }
        logConstraint(str, j4);
    }

    @JvmStatic
    public static final void logDebug(@NotNull String logText) {
        Intrinsics.checkNotNullParameter(logText, "logText");
        c(INSTANCE, LogLevel.DEBUG, logText, 0L, null, null, null, null, null, 240, null);
    }

    public static /* synthetic */ void logDebug$default(String str, long j4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            j4 = 0;
        }
        logDebug(str, j4);
    }

    @JvmStatic
    public static final void logDebugBuildOnly(@NotNull String logText, long j4, @Nullable String str) {
        Intrinsics.checkNotNullParameter(logText, "logText");
    }

    public static /* synthetic */ void logDebugBuildOnly$default(String str, long j4, String str2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            j4 = 0;
        }
        if ((i4 & 4) != 0) {
            str2 = null;
        }
        logDebugBuildOnly(str, j4, str2);
    }

    @JvmStatic
    public static final void logError(@NotNull String logText) {
        Intrinsics.checkNotNullParameter(logText, "logText");
        c(INSTANCE, LogLevel.ERROR, logText, 0L, null, null, null, null, null, 240, null);
    }

    public static /* synthetic */ void logError$default(String str, long j4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            j4 = 0;
        }
        logError(str, j4);
    }

    @JvmStatic
    public static final void logErrorDontTrigger(@NotNull String logText) {
        Intrinsics.checkNotNullParameter(logText, "logText");
        c(INSTANCE, LogLevel.ERROR, logText, 0L, null, null, null, null, Boolean.TRUE, 112, null);
    }

    @JvmStatic
    public static final void logInfo(@NotNull String logText) {
        Intrinsics.checkNotNullParameter(logText, "logText");
        c(INSTANCE, LogLevel.INFO, logText, 0L, null, null, null, null, null, 240, null);
    }

    public static /* synthetic */ void logInfo$default(String str, long j4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            j4 = 0;
        }
        logInfo(str, j4);
    }

    @JvmStatic
    public static final void logInfoDontTrigger(@NotNull String logText) {
        Intrinsics.checkNotNullParameter(logText, "logText");
        c(INSTANCE, LogLevel.INFO, logText, 0L, null, null, null, null, Boolean.TRUE, 112, null);
    }

    @JvmStatic
    public static final void logTestAction(@NotNull String actionName, long j4) {
        Intrinsics.checkNotNullParameter(actionName, "actionName");
        SystemLog systemLog = INSTANCE;
        LogLevel logLevel = LogLevel.INFO;
        c(systemLog, logLevel, "Testing: " + actionName, j4, null, null, null, LogFlag.ACTION, null, 184, null);
    }

    public static /* synthetic */ void logTestAction$default(String str, long j4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            j4 = 0;
        }
        logTestAction(str, j4);
    }

    @JvmStatic
    public static final void logTriggerFired(@NotNull String triggerName, long j4) {
        Intrinsics.checkNotNullParameter(triggerName, "triggerName");
        c(INSTANCE, LogLevel.INFO, triggerName, j4, null, null, null, LogFlag.TRIGGER, null, 184, null);
    }

    public static /* synthetic */ void logTriggerFired$default(String str, long j4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            j4 = 0;
        }
        logTriggerFired(str, j4);
    }

    @JvmStatic
    public static final void logVariableChange(@NotNull String variableName, @NotNull String oldValue, @NotNull String newValue, long j4, boolean z3) {
        LogFlag logFlag;
        Intrinsics.checkNotNullParameter(variableName, "variableName");
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
        Intrinsics.checkNotNullParameter(newValue, "newValue");
        LogLevel logLevel = LogLevel.INFO;
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = MacroDroidApplication.Companion.getInstance().getString(R.string.system_log_variable_updated_from_to);
        Intrinsics.checkNotNullExpressionValue(string, "MacroDroidApplication.in…variable_updated_from_to)");
        String format = String.format(string, Arrays.copyOf(new Object[]{oldValue, newValue}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        if (z3) {
            logFlag = LogFlag.LOCAL_VARIABLE;
        } else {
            logFlag = LogFlag.GLOBAL_VARIABLE;
        }
        c(INSTANCE, logLevel, format, j4, variableName, null, null, logFlag, null, 160, null);
    }

    @JvmStatic
    public static final void logVerbose(@NotNull String logText) {
        Intrinsics.checkNotNullParameter(logText, "logText");
        c(INSTANCE, LogLevel.VERBOSE, logText, 0L, null, null, null, null, null, 240, null);
    }

    public static /* synthetic */ void logVerbose$default(String str, long j4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            j4 = 0;
        }
        logVerbose(str, j4);
    }

    @JvmStatic
    public static final void logVerboseDontTrigger(@NotNull String logText) {
        Intrinsics.checkNotNullParameter(logText, "logText");
        c(INSTANCE, LogLevel.VERBOSE, logText, 0L, null, null, null, null, Boolean.TRUE, 112, null);
    }

    @JvmStatic
    public static final void logWarning(@NotNull String logText) {
        Intrinsics.checkNotNullParameter(logText, "logText");
        c(INSTANCE, LogLevel.WARNING, logText, 0L, null, null, null, null, null, 240, null);
    }

    public static /* synthetic */ void logWarning$default(String str, long j4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            j4 = 0;
        }
        logWarning(str, j4);
    }

    @NotNull
    public final ExecutorCoroutineDispatcher getDatabaseDispatcher() {
        return f12682c;
    }

    @JvmStatic
    public static final void logDebug(@NotNull String logText, long j4) {
        Intrinsics.checkNotNullParameter(logText, "logText");
        c(INSTANCE, LogLevel.DEBUG, logText, j4, null, null, null, null, null, 240, null);
    }

    public static /* synthetic */ void logDebug$default(String str, long j4, String str2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            j4 = 0;
        }
        if ((i4 & 4) != 0) {
            str2 = null;
        }
        logDebug(str, j4, str2);
    }

    @JvmStatic
    public static final void logError(@NotNull String logText, long j4) {
        Intrinsics.checkNotNullParameter(logText, "logText");
        c(INSTANCE, LogLevel.ERROR, logText, j4, null, null, null, null, null, 240, null);
    }

    public static /* synthetic */ void logError$default(String str, String str2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            str2 = null;
        }
        logError(str, str2);
    }

    @JvmStatic
    public static final void logErrorDontTrigger(@NotNull String logText, long j4) {
        Intrinsics.checkNotNullParameter(logText, "logText");
        c(INSTANCE, LogLevel.ERROR, logText, j4, null, null, null, null, Boolean.TRUE, 112, null);
    }

    @JvmStatic
    public static final void logInfo(@NotNull String logText, long j4) {
        Intrinsics.checkNotNullParameter(logText, "logText");
        c(INSTANCE, LogLevel.INFO, logText, j4, null, null, null, null, null, 240, null);
    }

    public static /* synthetic */ void logInfo$default(String str, long j4, String str2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            j4 = 0;
        }
        if ((i4 & 4) != 0) {
            str2 = null;
        }
        logInfo(str, j4, str2);
    }

    @JvmStatic
    public static final void logVerbose(@NotNull String logText, long j4) {
        Intrinsics.checkNotNullParameter(logText, "logText");
        c(INSTANCE, LogLevel.VERBOSE, logText, j4, null, null, null, null, null, 240, null);
    }

    public static /* synthetic */ void logVerbose$default(String str, long j4, String str2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            j4 = 0;
        }
        if ((i4 & 4) != 0) {
            str2 = null;
        }
        logVerbose(str, j4, str2);
    }

    @JvmStatic
    public static final void logWarning(@NotNull String logText, long j4) {
        Intrinsics.checkNotNullParameter(logText, "logText");
        c(INSTANCE, LogLevel.WARNING, logText, j4, null, null, null, null, null, 240, null);
    }

    public static /* synthetic */ void logWarning$default(String str, long j4, String str2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            j4 = 0;
        }
        if ((i4 & 4) != 0) {
            str2 = null;
        }
        logWarning(str, j4, str2);
    }

    @JvmStatic
    public static final void logDebug(@NotNull String logText, long j4, @Nullable String str) {
        Intrinsics.checkNotNullParameter(logText, "logText");
        c(INSTANCE, LogLevel.DEBUG, logText, j4, null, str, null, null, null, 232, null);
    }

    @JvmStatic
    public static final void logError(@NotNull String logText, @Nullable String str) {
        Intrinsics.checkNotNullParameter(logText, "logText");
        c(INSTANCE, LogLevel.ERROR, logText, 0L, null, null, str, null, null, Opcodes.ADD_INT_LIT16, null);
    }

    public static /* synthetic */ void logError$default(String str, long j4, String str2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            j4 = 0;
        }
        if ((i4 & 4) != 0) {
            str2 = null;
        }
        logError(str, j4, str2);
    }

    @JvmStatic
    public static final void logInfo(@NotNull String logText, long j4, @Nullable String str) {
        Intrinsics.checkNotNullParameter(logText, "logText");
        c(INSTANCE, LogLevel.INFO, logText, j4, null, str, null, null, null, 232, null);
    }

    @JvmStatic
    public static final void logVerbose(@NotNull String logText, long j4, @Nullable String str) {
        Intrinsics.checkNotNullParameter(logText, "logText");
        c(INSTANCE, LogLevel.VERBOSE, logText, j4, null, str, null, null, null, 232, null);
    }

    @JvmStatic
    public static final void logWarning(@NotNull String logText, long j4, @Nullable String str) {
        Intrinsics.checkNotNullParameter(logText, "logText");
        c(INSTANCE, LogLevel.WARNING, logText, j4, null, str, null, null, null, 232, null);
    }

    @JvmStatic
    public static final void logError(@NotNull String logText, long j4, @Nullable String str) {
        Intrinsics.checkNotNullParameter(logText, "logText");
        c(INSTANCE, LogLevel.ERROR, logText, j4, null, null, str, null, null, Opcodes.ADD_INT_LIT16, null);
    }

    public static /* synthetic */ void logError$default(String str, long j4, String str2, String str3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            j4 = 0;
        }
        if ((i4 & 4) != 0) {
            str2 = null;
        }
        if ((i4 & 8) != 0) {
            str3 = null;
        }
        logError(str, j4, str2, str3);
    }

    @JvmStatic
    public static final void logError(@NotNull String logText, long j4, @Nullable String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(logText, "logText");
        c(INSTANCE, LogLevel.ERROR, logText, j4, null, str, str2, null, null, 200, null);
    }
}
