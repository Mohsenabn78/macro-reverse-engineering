package com.arlosoft.macrodroid.action;

import android.content.Context;
import co.nedim.maildroidx.MaildroidX;
import co.nedim.maildroidx.MaildroidXType;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.data.SmtpServerConfig;
import com.arlosoft.macrodroid.database.room.LogLevel;
import com.arlosoft.macrodroid.logging.LogActivity;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.logging.systemlog.SystemLogHelper;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.Arrays;
import java.util.Stack;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SendEmailAction.kt */
/* loaded from: classes2.dex */
public final class SendEmailAction$sendEmailViaSmtp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $body;
    final /* synthetic */ TriggerContextInfo $contextInfo;
    final /* synthetic */ boolean $forceEvenIfNotEnabled;
    final /* synthetic */ String $fromEmailAddress;
    final /* synthetic */ boolean $isTest;
    final /* synthetic */ int $nextAction;
    final /* synthetic */ ResumeMacroInfo $resumeMacroInfo;
    final /* synthetic */ SmtpServerConfig $serverConfig;
    final /* synthetic */ Stack<Integer> $skipEndifIndexStack;
    final /* synthetic */ String $subject;
    final /* synthetic */ String $toEmailAddress;
    final /* synthetic */ boolean $useHtml;
    Object L$0;
    int label;
    final /* synthetic */ SendEmailAction this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SendEmailAction$sendEmailViaSmtp$1(SmtpServerConfig smtpServerConfig, boolean z3, String str, String str2, String str3, String str4, SendEmailAction sendEmailAction, TriggerContextInfo triggerContextInfo, boolean z4, int i4, boolean z5, Stack<Integer> stack, ResumeMacroInfo resumeMacroInfo, Continuation<? super SendEmailAction$sendEmailViaSmtp$1> continuation) {
        super(2, continuation);
        this.$serverConfig = smtpServerConfig;
        this.$useHtml = z3;
        this.$toEmailAddress = str;
        this.$fromEmailAddress = str2;
        this.$subject = str3;
        this.$body = str4;
        this.this$0 = sendEmailAction;
        this.$contextInfo = triggerContextInfo;
        this.$isTest = z4;
        this.$nextAction = i4;
        this.$forceEvenIfNotEnabled = z5;
        this.$skipEndifIndexStack = stack;
        this.$resumeMacroInfo = resumeMacroInfo;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new SendEmailAction$sendEmailViaSmtp$1(this.$serverConfig, this.$useHtml, this.$toEmailAddress, this.$fromEmailAddress, this.$subject, this.$body, this.this$0, this.$contextInfo, this.$isTest, this.$nextAction, this.$forceEvenIfNotEnabled, this.$skipEndifIndexStack, this.$resumeMacroInfo, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        boolean z3;
        MaildroidXType maildroidXType;
        MaildroidX.Builder onCompleteCallback;
        boolean z4;
        boolean z5;
        MaildroidX.Builder builder;
        coroutine_suspended = kotlin.coroutines.intrinsics.a.getCOROUTINE_SUSPENDED();
        int i4 = this.label;
        try {
        } catch (Throwable th) {
            SystemLog.logError("Failed to send email via SMTP: " + th);
            this.this$0.R(false, this.$contextInfo);
            if (!this.$isTest) {
                z3 = this.this$0.blockNextAction;
                if (z3) {
                    this.this$0.getMacro().invokeActions(this.this$0.getMacro().getActions(), this.$nextAction, this.$contextInfo, this.$forceEvenIfNotEnabled, this.$skipEndifIndexStack, this.$resumeMacroInfo);
                }
            }
        }
        if (i4 != 0) {
            if (i4 == 1) {
                builder = (MaildroidX.Builder) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            MaildroidX.Builder isStartTLSEnabled = new MaildroidX.Builder().smtp(this.$serverConfig.getServerAddress()).smtpUsername(this.$serverConfig.getUsername()).smtpPassword(this.$serverConfig.getPassword()).port(this.$serverConfig.getServerPort()).isStartTLSEnabled(this.$serverConfig.getStartTlsEnabled());
            if (this.$useHtml) {
                maildroidXType = MaildroidXType.HTML;
            } else {
                maildroidXType = MaildroidXType.PLAIN;
            }
            MaildroidX.Builder body = isStartTLSEnabled.type(maildroidXType).to(this.$toEmailAddress).from(this.$fromEmailAddress).subject(this.$subject).body(this.$body);
            final String str = this.$toEmailAddress;
            final SendEmailAction sendEmailAction = this.this$0;
            final TriggerContextInfo triggerContextInfo = this.$contextInfo;
            final boolean z6 = this.$isTest;
            final int i5 = this.$nextAction;
            final boolean z7 = this.$forceEvenIfNotEnabled;
            final Stack<Integer> stack = this.$skipEndifIndexStack;
            final ResumeMacroInfo resumeMacroInfo = this.$resumeMacroInfo;
            onCompleteCallback = body.onCompleteCallback(new MaildroidX.onCompleteCallback() { // from class: com.arlosoft.macrodroid.action.SendEmailAction$sendEmailViaSmtp$1$builder$1
                @Override // co.nedim.maildroidx.MaildroidX.onCompleteCallback
                public long getTimeout() {
                    return 10000L;
                }

                @Override // co.nedim.maildroidx.MaildroidX.onCompleteCallback
                public void onFail(@NotNull String errorString) {
                    String replace$default;
                    boolean z8;
                    String r4;
                    String r5;
                    Intrinsics.checkNotNullParameter(errorString, "errorString");
                    String str2 = str;
                    replace$default = kotlin.text.m.replace$default(errorString, "\n", ". ", false, 4, (Object) null);
                    String str3 = "Failed to send email to: " + str2 + ": " + replace$default;
                    Long macroGuid = sendEmailAction.getMacroGuid();
                    Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
                    SystemLog.logError(str3, macroGuid.longValue());
                    if (Settings.getEmailNotifyFailure(sendEmailAction.getContext())) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        r4 = SelectableItem.r(R.string.email_failed_to_x);
                        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.email_failed_to_x)");
                        String format = String.format(r4, Arrays.copyOf(new Object[]{str}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                        Context context = sendEmailAction.getContext();
                        r5 = SelectableItem.r(R.string.send_email);
                        Util.displayNotification(context, r5, format, false);
                    }
                    sendEmailAction.R(false, triggerContextInfo);
                    if (!z6) {
                        z8 = sendEmailAction.blockNextAction;
                        if (z8) {
                            sendEmailAction.getMacro().invokeActions(sendEmailAction.getMacro().getActions(), i5, triggerContextInfo, z7, stack, resumeMacroInfo);
                        }
                    }
                }

                @Override // co.nedim.maildroidx.MaildroidX.onCompleteCallback
                public void onSuccess() {
                    boolean z8;
                    String r4;
                    String r5;
                    Long macroGuid = sendEmailAction.getMacroGuid();
                    Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
                    SystemLog.logInfo("Email sent to: " + str, macroGuid.longValue());
                    if (Settings.getEmailNotifySuccess(sendEmailAction.getContext())) {
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        r4 = SelectableItem.r(R.string.email_sent_to_x);
                        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.email_sent_to_x)");
                        String format = String.format(r4, Arrays.copyOf(new Object[]{str}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                        Context context = sendEmailAction.getContext();
                        r5 = SelectableItem.r(R.string.send_email);
                        Util.displayNotification(context, r5, format, false);
                    }
                    sendEmailAction.R(true, triggerContextInfo);
                    if (!z6) {
                        z8 = sendEmailAction.blockNextAction;
                        if (z8) {
                            sendEmailAction.getMacro().invokeActions(sendEmailAction.getMacro().getActions(), i5, triggerContextInfo, z7, stack, resumeMacroInfo);
                        }
                    }
                }
            });
            z4 = this.this$0.m_attachLog;
            if (!z4) {
                z5 = this.this$0.m_attachUserLog;
                if (z5) {
                    String constructUserLogOutput = LogActivity.constructUserLogOutput(this.this$0.getContext());
                    if (constructUserLogOutput != null) {
                        onCompleteCallback.attachment(constructUserLogOutput);
                    } else {
                        Long macroGuid = this.this$0.getMacroGuid();
                        Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
                        SystemLog.logError("Could not attach user log, as user log is empty", macroGuid.longValue());
                    }
                }
                onCompleteCallback.mail();
                return Unit.INSTANCE;
            }
            SystemLogHelper systemLogHelper = this.this$0.getSystemLogHelper();
            LogLevel logLevel = LogLevel.VERBOSE;
            this.L$0 = onCompleteCallback;
            this.label = 1;
            Object createLogFile = systemLogHelper.createLogFile(logLevel, this);
            if (createLogFile == coroutine_suspended) {
                return coroutine_suspended;
            }
            builder = onCompleteCallback;
            obj = createLogFile;
        }
        String str2 = (String) obj;
        if (str2 != null) {
            builder.attachment(str2);
        }
        onCompleteCallback = builder;
        onCompleteCallback.mail();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object mo1invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SendEmailAction$sendEmailViaSmtp$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
