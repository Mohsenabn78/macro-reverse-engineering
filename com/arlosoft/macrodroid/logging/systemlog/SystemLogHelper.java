package com.arlosoft.macrodroid.logging.systemlog;

import android.content.Context;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.database.room.LogFlag;
import com.arlosoft.macrodroid.database.room.LogLevel;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.database.room.SystemLogEntry;
import com.arlosoft.macrodroid.logging.LogActivity;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SystemLogHelper.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nSystemLogHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SystemLogHelper.kt\ncom/arlosoft/macrodroid/logging/systemlog/SystemLogHelper\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,139:1\n1855#2,2:140\n1855#2,2:142\n*S KotlinDebug\n*F\n+ 1 SystemLogHelper.kt\ncom/arlosoft/macrodroid/logging/systemlog/SystemLogHelper\n*L\n36#1:140,2\n64#1:142,2\n*E\n"})
/* loaded from: classes3.dex */
public final class SystemLogHelper {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Context f12708a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final MacroDroidRoomDatabase f12709b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final SimpleDateFormat f12710c;

    /* compiled from: SystemLogHelper.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[LogFlag.values().length];
            try {
                iArr[LogFlag.TRIGGER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LogFlag.ACTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LogFlag.CONSTRAINT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LogFlag.LOCAL_VARIABLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[LogFlag.GLOBAL_VARIABLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[LogLevel.values().length];
            try {
                iArr2[LogLevel.VERBOSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[LogLevel.WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[LogLevel.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[LogLevel.DEBUG.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemLogHelper.kt */
    /* loaded from: classes3.dex */
    public static final class a extends ContinuationImpl {
        Object L$0;
        Object L$1;
        boolean Z$0;
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
            return SystemLogHelper.this.createHtmlLogFile(false, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SystemLogHelper.kt */
    /* loaded from: classes3.dex */
    public static final class b extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        b(Continuation<? super b> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SystemLogHelper.this.createLogFile(null, this);
        }
    }

    @Inject
    public SystemLogHelper(@ApplicationContext @NotNull Context context, @NotNull MacroDroidRoomDatabase roomDatabase) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(roomDatabase, "roomDatabase");
        this.f12708a = context;
        this.f12709b = roomDatabase;
        this.f12710c = new SimpleDateFormat("dd-MM-yy HH:mm:ss.SSS", Locale.getDefault());
    }

    private final String a(LogFlag logFlag) {
        int i4 = WhenMappings.$EnumSwitchMapping$0[logFlag.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                return "";
            }
            return LogActivity.ACTION_RUN_TEXT_NEW;
        }
        return LogActivity.TRIGGER_FIRED_TEXT_NEW;
    }

    private final String b(SystemLogEntry systemLogEntry, boolean z3) {
        if (systemLogEntry.getMacroId() != 0) {
            Macro macroByGUID = MacroStore.getInstance().getMacroByGUID(systemLogEntry.getMacroId());
            if (macroByGUID != null) {
                if (z3) {
                    String e4 = e(ContextCompat.getColor(this.f12708a, R.color.log_text_macro_name));
                    String name = macroByGUID.getName();
                    return " <font color=\"" + e4 + "\"><u>" + name + "</u></font>";
                }
                String name2 = macroByGUID.getName();
                return " (" + name2 + ")";
            }
            return "";
        } else if (systemLogEntry.getWebLink() != null) {
            if (z3) {
                String webLink = systemLogEntry.getWebLink();
                String webLink2 = systemLogEntry.getWebLink();
                return " (<a href=\"" + webLink + "\">" + webLink2 + "</a>)";
            }
            String webLink3 = systemLogEntry.getWebLink();
            return " (" + webLink3 + ")";
        } else {
            return "";
        }
    }

    private final int c(SystemLogEntry systemLogEntry) {
        int i4 = WhenMappings.$EnumSwitchMapping$0[systemLogEntry.getFlag().ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4 && i4 != 5) {
                        return d(systemLogEntry);
                    }
                    return ContextCompat.getColor(this.f12708a, R.color.log_variable);
                }
                return ContextCompat.getColor(this.f12708a, R.color.log_text_action_constraint_fail);
            }
            return ContextCompat.getColor(this.f12708a, R.color.log_text_action);
        }
        return ContextCompat.getColor(this.f12708a, R.color.log_text_trigger);
    }

    private final int d(SystemLogEntry systemLogEntry) {
        int i4 = WhenMappings.$EnumSwitchMapping$1[systemLogEntry.getLogLevel().ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        return ContextCompat.getColor(this.f12708a, R.color.default_text_color);
                    }
                    return ContextCompat.getColor(this.f12708a, R.color.log_debug);
                }
                return ContextCompat.getColor(this.f12708a, R.color.log_text_error);
            }
            return ContextCompat.getColor(this.f12708a, R.color.log_text_warning);
        }
        return ContextCompat.getColor(this.f12708a, R.color.log_detailed);
    }

    private final String e(int i4) {
        return String.format("#%06X", Integer.valueOf(i4 & 16777215));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ff A[Catch: Exception -> 0x01cc, TryCatch #0 {Exception -> 0x01cc, blocks: (B:12:0x0032, B:21:0x0071, B:25:0x007a, B:26:0x00f9, B:28:0x00ff, B:30:0x0163, B:36:0x016f, B:37:0x0179, B:39:0x018d, B:43:0x0196, B:44:0x01a0, B:45:0x01ae, B:17:0x0041), top: B:50:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x016f A[Catch: Exception -> 0x01cc, TryCatch #0 {Exception -> 0x01cc, blocks: (B:12:0x0032, B:21:0x0071, B:25:0x007a, B:26:0x00f9, B:28:0x00ff, B:30:0x0163, B:36:0x016f, B:37:0x0179, B:39:0x018d, B:43:0x0196, B:44:0x01a0, B:45:0x01ae, B:17:0x0041), top: B:50:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0196 A[Catch: Exception -> 0x01cc, TryCatch #0 {Exception -> 0x01cc, blocks: (B:12:0x0032, B:21:0x0071, B:25:0x007a, B:26:0x00f9, B:28:0x00ff, B:30:0x0163, B:36:0x016f, B:37:0x0179, B:39:0x018d, B:43:0x0196, B:44:0x01a0, B:45:0x01ae, B:17:0x0041), top: B:50:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x01a0 A[SYNTHETIC] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object createHtmlLogFile(boolean r11, @org.jetbrains.annotations.NotNull com.arlosoft.macrodroid.database.room.LogLevel r12, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.String> r13) {
        /*
            Method dump skipped, instructions count: 491
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.logging.systemlog.SystemLogHelper.createHtmlLogFile(boolean, com.arlosoft.macrodroid.database.room.LogLevel, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0088 A[Catch: Exception -> 0x00df, LOOP:0: B:22:0x0082->B:24:0x0088, LOOP_END, TryCatch #0 {Exception -> 0x00df, blocks: (B:12:0x002e, B:21:0x006b, B:22:0x0082, B:24:0x0088, B:25:0x00db, B:17:0x003d), top: B:30:0x0022 }] */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object createLogFile(@org.jetbrains.annotations.NotNull com.arlosoft.macrodroid.database.room.LogLevel r10, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super java.lang.String> r11) {
        /*
            Method dump skipped, instructions count: 254
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.logging.systemlog.SystemLogHelper.createLogFile(com.arlosoft.macrodroid.database.room.LogLevel, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
