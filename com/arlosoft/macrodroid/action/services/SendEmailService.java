package com.arlosoft.macrodroid.action.services;

import android.content.Context;
import android.content.Intent;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.action.email.GMailOauthSender;
import com.arlosoft.macrodroid.action.email.withpassword.GMailSender;
import com.arlosoft.macrodroid.action.outputservices.TwitterOutput;
import com.arlosoft.macrodroid.action.services.UploadService;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.logging.systemlog.SystemLogHelper;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableValue;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.inject.Inject;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.e;
import org.jetbrains.anko.AsyncKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SendEmailService.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class SendEmailService extends UploadService {
    @NotNull
    public static final String EXTRA_ATTACH_LOG = "AttachLog";
    @NotNull
    public static final String EXTRA_ATTACH_USER_LOG = "AttachUserLog";
    @NotNull
    public static final String EXTRA_EMAIL_BODY = "Body";
    @NotNull
    public static final String EXTRA_SUBJECT = "Subject";

    /* renamed from: l  reason: collision with root package name */
    private long f4894l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f4895m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f4896n;

    /* renamed from: o  reason: collision with root package name */
    private int f4897o;

    /* renamed from: p  reason: collision with root package name */
    private Stack<Integer> f4898p;
    @Nullable

    /* renamed from: q  reason: collision with root package name */
    private TriggerContextInfo f4899q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f4900r;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    private ResumeMacroInfo f4901s;
    @Inject
    public SystemLogHelper systemLogHelper;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    private transient MacroDroidVariable f4902t;
    @Nullable

    /* renamed from: u  reason: collision with root package name */
    private transient DictionaryKeys f4903u;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @NotNull

    /* renamed from: v  reason: collision with root package name */
    private static String f4893v = "UploadLocationService";

    /* compiled from: SendEmailService.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SendEmailService.kt */
    /* loaded from: classes2.dex */
    static final class a extends Lambda implements Function1<Context, Unit> {
        final /* synthetic */ Macro $macro;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(Macro macro) {
            super(1);
            this.$macro = macro;
        }

        public final void a(@NotNull Context runOnUiThread) {
            Stack<Integer> stack;
            List<String> list;
            Intrinsics.checkNotNullParameter(runOnUiThread, "$this$runOnUiThread");
            if (SendEmailService.this.f4902t != null) {
                Macro macro = this.$macro;
                MacroDroidVariable macroDroidVariable = SendEmailService.this.f4902t;
                DictionaryKeys dictionaryKeys = SendEmailService.this.f4903u;
                if (dictionaryKeys != null) {
                    list = dictionaryKeys.getKeys();
                } else {
                    list = null;
                }
                macro.variableUpdate(macroDroidVariable, new VariableValue.BooleanValue(false, list));
            }
            Macro macro2 = this.$macro;
            ArrayList<Action> actions = macro2.getActions();
            int i4 = SendEmailService.this.f4897o;
            TriggerContextInfo triggerContextInfo = SendEmailService.this.f4899q;
            boolean z3 = SendEmailService.this.f4900r;
            Stack<Integer> stack2 = SendEmailService.this.f4898p;
            if (stack2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("skipEndifIndexStack");
                stack = null;
            } else {
                stack = stack2;
            }
            macro2.invokeActions(actions, i4, triggerContextInfo, z3, stack, SendEmailService.this.f4901s);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Context context) {
            a(context);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: SendEmailService.kt */
    /* loaded from: classes2.dex */
    static final class b extends Lambda implements Function1<Context, Unit> {
        final /* synthetic */ Macro $macro;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(Macro macro) {
            super(1);
            this.$macro = macro;
        }

        public final void a(@NotNull Context runOnUiThread) {
            List<String> list;
            Intrinsics.checkNotNullParameter(runOnUiThread, "$this$runOnUiThread");
            if (SendEmailService.this.f4902t != null) {
                Macro macro = this.$macro;
                MacroDroidVariable macroDroidVariable = SendEmailService.this.f4902t;
                DictionaryKeys dictionaryKeys = SendEmailService.this.f4903u;
                if (dictionaryKeys != null) {
                    list = dictionaryKeys.getKeys();
                } else {
                    list = null;
                }
                macro.variableUpdate(macroDroidVariable, new VariableValue.BooleanValue(true, list));
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Context context) {
            a(context);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: SendEmailService.kt */
    /* loaded from: classes2.dex */
    static final class c extends Lambda implements Function1<Context, Unit> {
        final /* synthetic */ Macro $macro;
        final /* synthetic */ SendEmailService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(Macro macro, SendEmailService sendEmailService) {
            super(1);
            this.$macro = macro;
            this.this$0 = sendEmailService;
        }

        public final void a(@NotNull Context runOnUiThread) {
            Intrinsics.checkNotNullParameter(runOnUiThread, "$this$runOnUiThread");
            Macro macro = this.$macro;
            ArrayList<Action> actions = macro.getActions();
            int i4 = this.this$0.f4897o;
            TriggerContextInfo triggerContextInfo = this.this$0.f4899q;
            boolean z3 = this.this$0.f4900r;
            Stack<Integer> stack = this.this$0.f4898p;
            if (stack == null) {
                Intrinsics.throwUninitializedPropertyAccessException("skipEndifIndexStack");
                stack = null;
            }
            macro.invokeActions(actions, i4, triggerContextInfo, z3, stack, this.this$0.f4901s);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Context context) {
            a(context);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: SendEmailService.kt */
    /* loaded from: classes2.dex */
    static final class d extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Intent $intent;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ SendEmailService this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Intent intent, SendEmailService sendEmailService, Continuation<? super d> continuation) {
            super(2, continuation);
            this.$intent = intent;
            this.this$0 = sendEmailService;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new d(this.$intent, this.this$0, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x0170  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0180  */
        /* JADX WARN: Removed duplicated region for block: B:50:0x0194 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @org.jetbrains.annotations.Nullable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r13) {
            /*
                Method dump skipped, instructions count: 470
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.services.SendEmailService.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((d) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public SendEmailService() {
        MacroDroidApplication.Companion.getAppComponentInstance().inject(this);
    }

    @Override // com.arlosoft.macrodroid.action.services.UploadService
    @NotNull
    protected String g() {
        return "preferences:send_email_notify_failure";
    }

    @NotNull
    public final SystemLogHelper getSystemLogHelper() {
        SystemLogHelper systemLogHelper = this.systemLogHelper;
        if (systemLogHelper != null) {
            return systemLogHelper;
        }
        Intrinsics.throwUninitializedPropertyAccessException("systemLogHelper");
        return null;
    }

    @Override // com.arlosoft.macrodroid.action.services.UploadService
    @NotNull
    protected String h() {
        return "preferences:send_email_notify_success";
    }

    @Override // com.arlosoft.macrodroid.action.services.UploadService
    @NotNull
    protected String i() {
        return "preferences:send_email_retry_period";
    }

    @Override // com.arlosoft.macrodroid.action.services.UploadService
    protected void j() {
        if (!this.f4896n && this.f4895m) {
            Macro macroByGUID = MacroStore.getInstance().getMacroByGUID(this.f4894l);
            if (macroByGUID == null) {
                SystemLog.logError("Could not find macro in Select Mode Actions");
            } else {
                AsyncKt.runOnUiThread(this, new a(macroByGUID));
            }
        }
    }

    @Override // com.arlosoft.macrodroid.action.services.UploadService
    protected void k() {
        Macro macroByGUID = MacroStore.getInstance().getMacroByGUID(this.f4894l);
        AsyncKt.runOnUiThread(this, new b(macroByGUID));
        if (!this.f4896n && this.f4895m) {
            if (macroByGUID == null) {
                SystemLog.logError("Could not find macro in Select Mode Actions");
            } else {
                AsyncKt.runOnUiThread(this, new c(macroByGUID, this));
            }
        }
    }

    @Override // com.arlosoft.macrodroid.action.services.UploadService, android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f4938b = UploadService.UPLOAD_EMAIL;
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int i4, int i5) {
        if (intent == null) {
            return 2;
        }
        e.e(GlobalScope.INSTANCE, null, null, new d(intent, this, null), 3, null);
        return 2;
    }

    @Override // com.arlosoft.macrodroid.action.services.UploadService
    @NotNull
    protected TwitterOutput.TwitterStatus q(@NotNull Context context, @NotNull UploadService.QueueItem queueItem) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(queueItem, "queueItem");
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Called uploadToTwitter from SendEmailService"));
        Object obj = queueItem.item;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        TwitterOutput.TwitterStatus uploadMessage = TwitterOutput.uploadMessage(context, (String) obj);
        Intrinsics.checkNotNullExpressionValue(uploadMessage, "uploadMessage(context, queueItem.item as String)");
        return uploadMessage;
    }

    @Override // com.arlosoft.macrodroid.action.services.UploadService
    protected void s(@NotNull Context context, @NotNull UploadService.QueueItem queueItem, @NotNull String emailFrom) throws Exception {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(queueItem, "queueItem");
        Intrinsics.checkNotNullParameter(emailFrom, "emailFrom");
        GMailSender gMailSender = new GMailSender(emailFrom, Settings.getEmailPassword(context));
        if (queueItem.attachFile == null) {
            UploadService.QueueItem queueItem2 = this.f4937a;
            String str = queueItem2.subject;
            Object obj = queueItem2.item;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            gMailSender.sendMail(str, (String) obj, emailFrom, this.f4937a.email);
        } else if (queueItem.attachFileName == null) {
            UploadService.QueueItem queueItem3 = this.f4937a;
            String str2 = queueItem3.subject;
            Object obj2 = queueItem3.item;
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            gMailSender.sendMail(str2, (String) obj2, emailFrom, this.f4937a.email, queueItem.attachFile);
        } else {
            UploadService.QueueItem queueItem4 = this.f4937a;
            String str3 = queueItem4.subject;
            Object obj3 = queueItem4.item;
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
            String str4 = (String) obj3;
            UploadService.QueueItem queueItem5 = this.f4937a;
            gMailSender.sendMail(str3, str4, emailFrom, queueItem5.email, queueItem.attachFile, queueItem5.attachFileName);
        }
    }

    public final void setSystemLogHelper(@NotNull SystemLogHelper systemLogHelper) {
        Intrinsics.checkNotNullParameter(systemLogHelper, "<set-?>");
        this.systemLogHelper = systemLogHelper;
    }

    @Override // com.arlosoft.macrodroid.action.services.UploadService
    protected void u(@NotNull Context context, @NotNull UploadService.QueueItem queueItem, @NotNull String emailFrom, @NotNull String token) throws Exception {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(queueItem, "queueItem");
        Intrinsics.checkNotNullParameter(emailFrom, "emailFrom");
        Intrinsics.checkNotNullParameter(token, "token");
        GMailOauthSender gMailOauthSender = new GMailOauthSender();
        String str = queueItem.attachFileName;
        StringBuilder sb = new StringBuilder();
        sb.append("++++ CALLING UPLOAD VIA EMAIL OAUTH: ");
        sb.append(str);
        if (queueItem.attachFile == null) {
            UploadService.QueueItem queueItem2 = this.f4937a;
            String str2 = queueItem2.subject;
            Object obj = queueItem2.item;
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
            gMailOauthSender.sendMail(context, str2, (String) obj, emailFrom, token, this.f4937a.email);
        } else if (queueItem.attachFileName == null) {
            UploadService.QueueItem queueItem3 = this.f4937a;
            String str3 = queueItem3.subject;
            Object obj2 = queueItem3.item;
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
            gMailOauthSender.sendMail(context, str3, (String) obj2, emailFrom, token, this.f4937a.email, queueItem.attachFile);
        } else {
            UploadService.QueueItem queueItem4 = this.f4937a;
            String str4 = queueItem4.subject;
            Object obj3 = queueItem4.item;
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
            String str5 = (String) obj3;
            UploadService.QueueItem queueItem5 = this.f4937a;
            gMailOauthSender.sendMail(context, str4, str5, emailFrom, token, queueItem5.email, queueItem.attachFile, queueItem5.attachFileName);
        }
    }
}
