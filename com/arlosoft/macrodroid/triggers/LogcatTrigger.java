package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.helper.HelperCommandsKt;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logcat.LogcatMessage;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.root.RootToolsHelper;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.activities.LogcatConfigActivity;
import com.arlosoft.macrodroid.triggers.info.LogcatTriggerInfo;
import com.arlosoft.macrodroid.utils.WildCardHelper;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Charsets;
import kotlin.text.StringsKt___StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LogcatTrigger.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class LogcatTrigger extends Trigger implements SupportsMagicText {
    public static final int BUFFER_CRASH = 4;
    public static final int BUFFER_EVENTS = 32;
    public static final int BUFFER_KERNEL = 8;
    public static final int BUFFER_MAIN = 1;
    public static final int BUFFER_RADIO = 16;
    public static final int BUFFER_SYSTEM = 2;
    public static final boolean ENABLE_DIAGNOSTIC_MODE = false;
    private static int diagnosticsLineCount;
    @Nullable
    private static InputStream inputStream;
    @Nullable
    private static Job logcatJob;
    private static int triggerCount;
    @NotNull
    private String component;
    private boolean ignoreCase;
    @NotNull
    private String textToMatch;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<LogcatTrigger> CREATOR = new Parcelable.Creator<LogcatTrigger>() { // from class: com.arlosoft.macrodroid.triggers.LogcatTrigger$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public LogcatTrigger createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new LogcatTrigger(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public LogcatTrigger[] newArray(int i4) {
            return new LogcatTrigger[i4];
        }
    };
    private static boolean streamClosed = true;

    /* compiled from: LogcatTrigger.kt */
    @SourceDebugExtension({"SMAP\nLogcatTrigger.kt\nKotlin\n*S Kotlin\n*F\n+ 1 LogcatTrigger.kt\ncom/arlosoft/macrodroid/triggers/LogcatTrigger$enableTrigger$1\n+ 2 ReadWrite.kt\nkotlin/io/TextStreamsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,270:1\n52#2:271\n1#3:272\n1313#4,2:273\n*S KotlinDebug\n*F\n+ 1 LogcatTrigger.kt\ncom/arlosoft/macrodroid/triggers/LogcatTrigger$enableTrigger$1\n*L\n142#1:271\n142#1:272\n143#1:273,2\n*E\n"})
    /* loaded from: classes3.dex */
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        Object L$1;
        int label;

        a(Continuation<? super a> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new a(continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v11, types: [java.io.Closeable] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            BufferedReader bufferedReader;
            Iterator<String> it;
            BufferedReader bufferedReader2;
            coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
            int i4 = this.label;
            try {
            } catch (Exception e4) {
                if (!LogcatTrigger.streamClosed) {
                    SystemLog.logError("Failed to initialise logcat listener: " + e4);
                }
            }
            if (i4 != 0) {
                if (i4 == 1) {
                    it = (Iterator) this.L$1;
                    ?? r32 = (Closeable) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    bufferedReader2 = r32;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } else {
                ResultKt.throwOnFailure(obj);
                Long macroGuid = LogcatTrigger.this.getMacroGuid();
                Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
                SystemLog.logInfo(">>>>> Starting Logcat monitor", macroGuid.longValue());
                String bufferStringFromEnabledBuffers = LogcatTrigger.Companion.getBufferStringFromEnabledBuffers(Settings.getLogcatEnabledBuffers(LogcatTrigger.this.getContext()));
                Runtime runtime = Runtime.getRuntime();
                runtime.exec("logcat -c -b " + bufferStringFromEnabledBuffers).waitFor();
                Runtime runtime2 = Runtime.getRuntime();
                LogcatTrigger.inputStream = runtime2.exec("logcat -v tag -b " + bufferStringFromEnabledBuffers).getInputStream();
                InputStream inputStream = LogcatTrigger.inputStream;
                if (inputStream != null) {
                    InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charsets.UTF_8);
                    if (inputStreamReader instanceof BufferedReader) {
                        bufferedReader = (BufferedReader) inputStreamReader;
                    } else {
                        bufferedReader = new BufferedReader(inputStreamReader, 8192);
                    }
                    it = TextStreamsKt.lineSequence(bufferedReader).iterator();
                    bufferedReader2 = bufferedReader;
                }
                return Unit.INSTANCE;
            }
            while (it.hasNext()) {
                Companion companion = LogcatTrigger.Companion;
                this.L$0 = bufferedReader2;
                this.L$1 = it;
                this.label = 1;
                if (companion.a(it.next(), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(bufferedReader2, null);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public /* synthetic */ LogcatTrigger(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean M(String str) {
        boolean z3;
        if (this.component.length() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            return true;
        }
        return WildCardHelper.matches(str, WildCardHelper.getContainsPattern(MagicText.replaceMagicText(getContext(), this.component, null, this.m_macro), this.ignoreCase), false, this.ignoreCase);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean N(String str) {
        boolean z3;
        if (this.textToMatch.length() == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            return false;
        }
        return WildCardHelper.matches(str, WildCardHelper.getContainsPattern(MagicText.replaceMagicText(getContext(), this.textToMatch, null, this.m_macro), this.ignoreCase), false, this.ignoreCase);
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    protected void disableTrigger() {
        int i4 = triggerCount - 1;
        triggerCount = i4;
        if (i4 == 0) {
            try {
                streamClosed = true;
                InputStream inputStream2 = inputStream;
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                Job job = logcatJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                logcatJob = null;
                inputStream = null;
                Long macroGuid = getMacroGuid();
                Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
                SystemLog.logInfo("<<<<<< Closing Logcat monitor", macroGuid.longValue());
            } catch (Exception e4) {
                FirebaseCrashlytics.getInstance().recordException(e4);
                Long macroGuid2 = getMacroGuid();
                Intrinsics.checkNotNullExpressionValue(macroGuid2, "macroGuid");
                SystemLog.logError("Closing logcat monitor failed: " + e4, macroGuid2.longValue());
            }
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    protected void enableTrigger() {
        Job e4;
        if (triggerCount == 0) {
            streamClosed = false;
            if (ContextCompat.checkSelfPermission(getContext(), "android.permission.READ_LOGS") != 0 && RootToolsHelper.isAccessGiven()) {
                Util.runAsRoot(new String[]{"pm grant com.arlosoft.macrodroid android.permission.READ_LOGS"});
            }
            Job job = logcatJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            e4 = kotlinx.coroutines.e.e(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new a(null), 2, null);
            logcatJob = e4;
        }
        triggerCount++;
    }

    @NotNull
    public final String getComponentName() {
        return this.component;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        String str = this.component;
        String str2 = this.textToMatch;
        return "[" + str + "] " + str2;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return LogcatTriggerInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    @NotNull
    public String[] getPossibleMagicText() {
        return new String[]{this.textToMatch, this.component};
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    @Nullable
    public TriggerContextInfo getTestTriggerContentInfo() {
        return TriggerContextInfo.createUsbTriggerContextInfo(this, "test product name", "test manufacturer name", "999");
    }

    @NotNull
    public final String getTextToMatch() {
        return this.textToMatch;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(@Nullable Activity activity, int i4, int i5, @Nullable Intent intent) {
        if (i4 == 1) {
            if (i5 == -1) {
                Intrinsics.checkNotNull(intent);
                LogcatMessage logcatMessage = (LogcatMessage) intent.getParcelableExtra(LogcatConfigActivity.EXTRA_LOGCAT_MESSAGE);
                Settings.setLogcatEnabledBuffers(getContext(), intent.getIntExtra("enabled_buffers", 0));
                Intrinsics.checkNotNull(logcatMessage);
                this.textToMatch = logcatMessage.getMessage();
                this.component = logcatMessage.getComponent();
                this.ignoreCase = intent.getBooleanExtra(LogcatConfigActivity.EXTRA_IGNORE_CASE, false);
                itemComplete();
                return;
            }
            handleItemCancel();
            return;
        }
        super.handleActivityResult(activity, i4, i5, intent);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void onItemSelected() {
        LogcatConfigActivity.Companion companion = LogcatConfigActivity.Companion;
        Activity activity = getActivity();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        Macro macro = getMacro();
        Intrinsics.checkNotNullExpressionValue(macro, "macro");
        companion.launchActivity(activity, macro, this, null, Settings.getLogcatEnabledBuffers(getContext()), this.ignoreCase);
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(@NotNull String[] magicText) {
        Intrinsics.checkNotNullParameter(magicText, "magicText");
        if (magicText.length == 2) {
            this.textToMatch = magicText[0];
            this.component = magicText[1];
            return;
        }
        FirebaseCrashlytics firebaseCrashlytics = FirebaseCrashlytics.getInstance();
        String str = this.m_classType;
        firebaseCrashlytics.recordException(new RuntimeException("SetPossibleMagicText incorrect array length (" + str + ")"));
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeString(this.textToMatch);
        out.writeString(this.component);
        out.writeInt(this.ignoreCase ? 1 : 0);
    }

    public LogcatTrigger(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public LogcatTrigger() {
        this.textToMatch = "";
        this.component = "*";
        this.ignoreCase = true;
    }

    private LogcatTrigger(Parcel parcel) {
        super(parcel);
        this.textToMatch = "";
        this.component = "*";
        this.ignoreCase = true;
        String readString = parcel.readString();
        this.textToMatch = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.component = readString2 != null ? readString2 : "";
        this.ignoreCase = parcel.readInt() != 0;
    }

    /* compiled from: LogcatTrigger.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: LogcatTrigger.kt */
        /* loaded from: classes3.dex */
        public static final class a extends ContinuationImpl {
            int label;
            /* synthetic */ Object result;

            a(Continuation<? super a> continuation) {
                super(continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.result = obj;
                this.label |= Integer.MIN_VALUE;
                return Companion.this.a(null, this);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: LogcatTrigger.kt */
        /* loaded from: classes3.dex */
        public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<Macro> $macrosToInvoke;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            b(List<Macro> list, Continuation<? super b> continuation) {
                super(2, continuation);
                this.$macrosToInvoke = list;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @NotNull
            public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                return new b(this.$macrosToInvoke, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    for (Macro macro : this.$macrosToInvoke) {
                        macro.invokeActions(macro.getTriggerContextInfo());
                    }
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            @Override // kotlin.jvm.functions.Function2
            @Nullable
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Can't wrap try/catch for region: R(8:1|(2:3|(6:5|6|7|(1:(1:10)(2:14|15))(6:16|17|(4:20|(2:21|(3:23|(3:31|32|(3:34|35|(3:37|38|39)(1:41))(1:42))|43))|40|18)|48|49|(1:51))|11|12))|53|6|7|(0)(0)|11|12) */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0032  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object a(java.lang.String r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
            /*
                r11 = this;
                boolean r0 = r13 instanceof com.arlosoft.macrodroid.triggers.LogcatTrigger.Companion.a
                if (r0 == 0) goto L13
                r0 = r13
                com.arlosoft.macrodroid.triggers.LogcatTrigger$Companion$a r0 = (com.arlosoft.macrodroid.triggers.LogcatTrigger.Companion.a) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.arlosoft.macrodroid.triggers.LogcatTrigger$Companion$a r0 = new com.arlosoft.macrodroid.triggers.LogcatTrigger$Companion$a
                r0.<init>(r13)
            L18:
                java.lang.Object r13 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L32
                if (r2 != r3) goto L2a
                kotlin.ResultKt.throwOnFailure(r13)     // Catch: java.lang.Exception -> Ld6
                goto Ld6
            L2a:
                java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
                r12.<init>(r13)
                throw r12
            L32:
                kotlin.ResultKt.throwOnFailure(r13)
                java.util.ArrayList r13 = new java.util.ArrayList
                r13.<init>()
                java.lang.String r5 = ":"
                r6 = 0
                r7 = 0
                r8 = 6
                r9 = 0
                r4 = r12
                int r2 = kotlin.text.StringsKt.indexOf$default(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> Ld6
                r4 = 2
                java.lang.String r2 = r12.substring(r4, r2)     // Catch: java.lang.Exception -> Ld6
                java.lang.String r4 = "this as java.lang.String…ing(startIndex, endIndex)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)     // Catch: java.lang.Exception -> Ld6
                int r4 = r2.length()     // Catch: java.lang.Exception -> Ld6
                int r4 = r4 + 4
                java.lang.String r4 = r12.substring(r4)     // Catch: java.lang.Exception -> Ld6
                java.lang.String r5 = "this as java.lang.String).substring(startIndex)"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)     // Catch: java.lang.Exception -> Ld6
                com.arlosoft.macrodroid.macro.MacroStore r5 = com.arlosoft.macrodroid.macro.MacroStore.getInstance()     // Catch: java.lang.Exception -> Ld6
                java.util.List r5 = r5.getEnabledMacros()     // Catch: java.lang.Exception -> Ld6
                java.util.Iterator r5 = r5.iterator()     // Catch: java.lang.Exception -> Ld6
            L6a:
                boolean r6 = r5.hasNext()     // Catch: java.lang.Exception -> Ld6
                if (r6 == 0) goto Lc3
                java.lang.Object r6 = r5.next()     // Catch: java.lang.Exception -> Ld6
                com.arlosoft.macrodroid.macro.Macro r6 = (com.arlosoft.macrodroid.macro.Macro) r6     // Catch: java.lang.Exception -> Ld6
                java.util.ArrayList r7 = r6.getTriggerListWithAwaitingActions()     // Catch: java.lang.Exception -> Ld6
                java.util.Iterator r7 = r7.iterator()     // Catch: java.lang.Exception -> Ld6
            L7e:
                boolean r8 = r7.hasNext()     // Catch: java.lang.Exception -> Ld6
                if (r8 == 0) goto L6a
                java.lang.Object r8 = r7.next()     // Catch: java.lang.Exception -> Ld6
                com.arlosoft.macrodroid.triggers.Trigger r8 = (com.arlosoft.macrodroid.triggers.Trigger) r8     // Catch: java.lang.Exception -> Ld6
                boolean r9 = r8 instanceof com.arlosoft.macrodroid.triggers.LogcatTrigger     // Catch: java.lang.Exception -> Ld6
                if (r9 == 0) goto L7e
                r9 = r8
                com.arlosoft.macrodroid.triggers.LogcatTrigger r9 = (com.arlosoft.macrodroid.triggers.LogcatTrigger) r9     // Catch: java.lang.Exception -> Ld6
                boolean r9 = com.arlosoft.macrodroid.triggers.LogcatTrigger.access$matchesText(r9, r4)     // Catch: java.lang.Exception -> Ld6
                if (r9 == 0) goto L7e
                r9 = r8
                com.arlosoft.macrodroid.triggers.LogcatTrigger r9 = (com.arlosoft.macrodroid.triggers.LogcatTrigger) r9     // Catch: java.lang.Exception -> Ld6
                boolean r9 = com.arlosoft.macrodroid.triggers.LogcatTrigger.access$matchesComponent(r9, r2)     // Catch: java.lang.Exception -> Ld6
                if (r9 == 0) goto L7e
                com.arlosoft.macrodroid.triggers.TriggerContextInfo r9 = com.arlosoft.macrodroid.triggers.TriggerContextInfo.createLogcatTriggerContextInfo(r8, r12)     // Catch: java.lang.Exception -> Ld6
                boolean r10 = r8.constraintsMet(r9)     // Catch: java.lang.Exception -> Ld6
                if (r10 == 0) goto L7e
                r6.setTriggerThatInvoked(r8)     // Catch: java.lang.Exception -> Ld6
                r6.setTriggerContextInfo(r9)     // Catch: java.lang.Exception -> Ld6
                com.arlosoft.macrodroid.triggers.TriggerContextInfo r7 = r6.getTriggerContextInfo()     // Catch: java.lang.Exception -> Ld6
                boolean r7 = r6.canInvoke(r7)     // Catch: java.lang.Exception -> Ld6
                if (r7 == 0) goto L6a
                java.lang.String r7 = "macro"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r7)     // Catch: java.lang.Exception -> Ld6
                r13.add(r6)     // Catch: java.lang.Exception -> Ld6
                goto L6a
            Lc3:
                kotlinx.coroutines.MainCoroutineDispatcher r12 = kotlinx.coroutines.Dispatchers.getMain()     // Catch: java.lang.Exception -> Ld6
                com.arlosoft.macrodroid.triggers.LogcatTrigger$Companion$b r2 = new com.arlosoft.macrodroid.triggers.LogcatTrigger$Companion$b     // Catch: java.lang.Exception -> Ld6
                r4 = 0
                r2.<init>(r13, r4)     // Catch: java.lang.Exception -> Ld6
                r0.label = r3     // Catch: java.lang.Exception -> Ld6
                java.lang.Object r12 = kotlinx.coroutines.BuildersKt.withContext(r12, r2, r0)     // Catch: java.lang.Exception -> Ld6
                if (r12 != r1) goto Ld6
                return r1
            Ld6:
                kotlin.Unit r12 = kotlin.Unit.INSTANCE
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.triggers.LogcatTrigger.Companion.a(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
        }

        @NotNull
        public final String getBufferStringFromEnabledBuffers(int i4) {
            boolean z3;
            String dropLast;
            StringBuffer stringBuffer = new StringBuffer();
            if (isBufferEnabled(i4, 1)) {
                stringBuffer.append("main");
                stringBuffer.append(",");
            }
            if (isBufferEnabled(i4, 2)) {
                stringBuffer.append(HelperCommandsKt.HELPER_SETTING_TYPE_SYSTEM);
                stringBuffer.append(",");
            }
            if (isBufferEnabled(i4, 4)) {
                stringBuffer.append(AppMeasurement.CRASH_ORIGIN);
                stringBuffer.append(",");
            }
            if (isBufferEnabled(i4, 8)) {
                stringBuffer.append("kernel");
                stringBuffer.append(",");
            }
            if (isBufferEnabled(i4, 16)) {
                stringBuffer.append("radio");
                stringBuffer.append(",");
            }
            if (isBufferEnabled(i4, 32)) {
                stringBuffer.append("events");
                stringBuffer.append(",");
            }
            if (stringBuffer.length() > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                String stringBuffer2 = stringBuffer.toString();
                Intrinsics.checkNotNullExpressionValue(stringBuffer2, "stringBuffer.toString()");
                dropLast = StringsKt___StringsKt.dropLast(stringBuffer2, 1);
                return dropLast;
            }
            return "";
        }

        public final boolean isBufferEnabled(int i4, int i5) {
            if ((i4 & i5) == i5) {
                return true;
            }
            return false;
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }
}
