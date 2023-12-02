package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.email.EmailActivity;
import com.arlosoft.macrodroid.action.email.api.EmailApi;
import com.arlosoft.macrodroid.action.info.SendEmailActionInfo;
import com.arlosoft.macrodroid.action.services.SendEmailService;
import com.arlosoft.macrodroid.action.services.UploadService;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.data.SmtpServerConfig;
import com.arlosoft.macrodroid.interfaces.BlockingAction;
import com.arlosoft.macrodroid.interfaces.HasVariable;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.logging.systemlog.SystemLogHelper;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.GmailHelper;
import com.arlosoft.macrodroid.variables.DictionaryKeys;
import com.arlosoft.macrodroid.variables.VariableHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import java.util.List;
import java.util.Stack;
import javax.inject.Inject;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SendEmailAction.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class SendEmailAction extends Action implements SupportsMagicText, BlockingAction, HasVariable {
    private static final int EMAIL_ACTIVITY_REQUEST = 18434;
    private static final int SEND_OPTION_GMAIL = 0;
    private static final int SEND_OPTION_SMTP = 1;
    private boolean blockNextAction;
    @Inject
    public transient EmailApi emailApi;
    private boolean m_attachLog;
    private boolean m_attachUserLog;
    @NotNull
    private String m_body;
    @NotNull
    private String m_emailAddress;
    @NotNull
    private String m_fromEmailAddress;
    @Nullable
    private transient GmailHelper m_gmailHelper;
    @NotNull
    private String m_subject;
    private int sendOption;
    @Inject
    public transient SystemLogHelper systemLogHelper;
    private boolean useHtml;
    @Nullable
    private DictionaryKeys varDictionaryKeys;
    @Nullable
    private MacroDroidVariable variable;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SendEmailAction> CREATOR = new Parcelable.Creator<SendEmailAction>() { // from class: com.arlosoft.macrodroid.action.SendEmailAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SendEmailAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SendEmailAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SendEmailAction[] newArray(int i4) {
            return new SendEmailAction[i4];
        }
    };

    public /* synthetic */ SendEmailAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final void M() {
        GmailHelper gmailHelper = this.m_gmailHelper;
        Intrinsics.checkNotNull(gmailHelper);
        GoogleAccountCredential credentials = gmailHelper.getCredentials();
        if (credentials.getSelectedAccountName() == null) {
            GmailHelper gmailHelper2 = this.m_gmailHelper;
            Intrinsics.checkNotNull(gmailHelper2);
            gmailHelper2.chooseAccount(credentials, getActivity());
            return;
        }
        S(false);
    }

    private final void N() {
        S(true);
    }

    private final String[] O() {
        String r4 = SelectableItem.r(R.string.gmail_account);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.gmail_account)");
        String r5 = SelectableItem.r(R.string.smtp_server);
        Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.smtp_server)");
        return new String[]{r4, r5};
    }

    private final void P(String str, String str2, String str3, TriggerContextInfo triggerContextInfo, int i4, boolean z3, Stack<Integer> stack, ResumeMacroInfo resumeMacroInfo, boolean z4) {
        Intent intent = new Intent(getContext(), SendEmailService.class);
        intent.putExtra("Subject", str3);
        intent.putExtra("Body", str2);
        intent.putExtra(UploadService.EXTRA_UPLOAD_EMAIL_ADDRESS, str);
        intent.putExtra(SendEmailService.EXTRA_ATTACH_LOG, this.m_attachLog);
        intent.putExtra("AttachUserLog", this.m_attachUserLog);
        Long macroGuid = getMacroGuid();
        Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
        intent.putExtra(Constants.EXTRA_MACRO_GUID, macroGuid.longValue());
        intent.putExtra(Constants.EXTRA_BLOCK_NEXT_ACTION, this.blockNextAction);
        intent.putExtra(Constants.EXTRA_TRIGGER_CONTEXT_INFO, triggerContextInfo);
        intent.putExtra(Constants.EXTRA_NEXT_ACTION_INDEX, i4);
        intent.putExtra(Constants.EXTRA_SKIP_TO_ENDIF_INDEX, stack);
        intent.putExtra(Constants.EXTRA_FORCE_IF_NOT_ENABLED, z3);
        intent.putExtra(Constants.EXTRA_RESUME_MACRO_INFO, resumeMacroInfo);
        intent.putExtra("Variable", this.variable);
        intent.putExtra("dictionary_keys", this.varDictionaryKeys);
        intent.putExtra(Constants.EXTRA_IS_TEST, z4);
        getContext().startService(intent);
    }

    private final void Q(String str, String str2, String str3, String str4, boolean z3, TriggerContextInfo triggerContextInfo, int i4, boolean z4, Stack<Integer> stack, ResumeMacroInfo resumeMacroInfo, boolean z5) {
        SmtpServerConfig smtpServerConfig = Settings.getSmtpServerConfig(getContext());
        if (smtpServerConfig.isValid()) {
            kotlinx.coroutines.e.e(GlobalScope.INSTANCE, null, null, new SendEmailAction$sendEmailViaSmtp$1(smtpServerConfig, z3, str2, str, str4, str3, this, triggerContextInfo, z5, i4, z4, stack, resumeMacroInfo, null), 3, null);
            return;
        }
        Long macroGuid = getMacroGuid();
        Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
        SystemLog.logError("Failed to send email to: " + str2 + ". SMTP Configuration is invalid", macroGuid.longValue());
        R(false, triggerContextInfo);
        if (!z5 && this.blockNextAction) {
            getMacro().invokeActions(getMacro().getActions(), i4, triggerContextInfo, z4, stack, resumeMacroInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R(boolean z3, TriggerContextInfo triggerContextInfo) {
        String str;
        List<String> emptyList;
        MacroDroidVariable macroDroidVariable = this.variable;
        if (macroDroidVariable == null) {
            return;
        }
        String str2 = null;
        if (macroDroidVariable != null) {
            str = macroDroidVariable.getName();
        } else {
            str = null;
        }
        MacroDroidVariable variableByName = getVariableByName(str);
        if (variableByName == null) {
            MacroDroidVariable macroDroidVariable2 = this.variable;
            if (macroDroidVariable2 != null) {
                str2 = macroDroidVariable2.getName();
            }
            Long macroGuid = getMacroGuid();
            Intrinsics.checkNotNullExpressionValue(macroGuid, "macroGuid");
            SystemLog.logError("Send email action result variable not found " + str2, macroGuid.longValue());
            return;
        }
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        DictionaryKeys dictionaryKeys = this.varDictionaryKeys;
        if (dictionaryKeys == null || (emptyList = dictionaryKeys.getKeys()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        variableUpdate(variableByName, new VariableValue.BooleanValue(z3, VariableHelper.applyMagicTextToDictionaryKeys(context, emptyList, triggerContextInfo, getMacro())));
    }

    private final void S(boolean z3) {
        Activity activity = getActivity();
        Intent intent = new Intent(activity, EmailActivity.class);
        intent.putParcelableArrayListExtra("Trigger", this.m_macro.getTriggerList());
        intent.putExtra("From", this.m_fromEmailAddress);
        intent.putExtra(EmailActivity.ADDRESS_EXTRA, this.m_emailAddress);
        intent.putExtra("Subject", this.m_subject);
        intent.putExtra("Body", this.m_body);
        intent.putExtra(EmailActivity.ATTACH_SYSTEM_LOG_EXTRA, this.m_attachLog);
        intent.putExtra("AttachUserLog", this.m_attachUserLog);
        intent.putExtra(EmailActivity.SMTP_MODE_EXTRA, z3);
        intent.putExtra(EmailActivity.HTML_MODE_ENABLED_EXTRA, this.useHtml);
        intent.putExtra("selectable_item", this);
        intent.putExtra("Macro", getMacro());
        intent.putExtra("Variable", this.variable);
        intent.putExtra("dictionary_keys", this.varDictionaryKeys);
        intent.putExtra(EmailActivity.EXTRA_BLOCK_NEXT_ACTIONS, this.blockNextAction);
        activity.startActivityForResult(intent, EMAIL_ACTIVITY_REQUEST);
    }

    private final void init() {
        MacroDroidApplication.Companion.getAppComponentInstance().inject(this);
        this.m_gmailHelper = GmailHelper.getInstance(getContext().getApplicationContext());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.sendOption = i4;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void anonymizeForTemplate() {
        boolean startsWith$default;
        boolean startsWith$default2;
        boolean startsWith$default3;
        boolean startsWith$default4;
        super.anonymizeForTemplate();
        startsWith$default = kotlin.text.m.startsWith$default(this.m_emailAddress, "[v=", false, 2, null);
        if (!startsWith$default) {
            startsWith$default2 = kotlin.text.m.startsWith$default(this.m_emailAddress, "[lv=", false, 2, null);
            if (!startsWith$default2) {
                startsWith$default3 = kotlin.text.m.startsWith$default(this.m_emailAddress, "{v=", false, 2, null);
                if (!startsWith$default3) {
                    startsWith$default4 = kotlin.text.m.startsWith$default(this.m_emailAddress, "{lv=", false, 2, null);
                    if (!startsWith$default4) {
                        this.m_emailAddress = "example@email.com";
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.sendOption;
    }

    @NotNull
    public final EmailApi getEmailApi() {
        EmailApi emailApi = this.emailApi;
        if (emailApi != null) {
            return emailApi;
        }
        Intrinsics.throwUninitializedPropertyAccessException("emailApi");
        return null;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        if (this.m_emailAddress != null) {
            String r4 = SelectableItem.r(R.string.action_send_email_to);
            String str = this.m_emailAddress;
            return r4 + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + str;
        }
        return "";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        SelectableItemInfo sendEmailActionInfo = SendEmailActionInfo.getInstance();
        Intrinsics.checkNotNullExpressionValue(sendEmailActionInfo, "getInstance()");
        return sendEmailActionInfo;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String[] getPermissions() {
        return new String[]{"android.permission.GET_ACCOUNTS"};
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    @NotNull
    public String[] getPossibleMagicText() {
        return new String[]{this.m_emailAddress, this.m_body, this.m_subject};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getSystemLogEntryName(@NotNull TriggerContextInfo triggerContextInfo) {
        Intrinsics.checkNotNullParameter(triggerContextInfo, "triggerContextInfo");
        String name = getName();
        String g4 = g(this.m_subject, triggerContextInfo);
        String g5 = g(this.m_body, triggerContextInfo);
        return name + ": " + g4 + " / " + g5;
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

    @Override // com.arlosoft.macrodroid.interfaces.HasVariable
    @Nullable
    public MacroDroidVariable getVariable() {
        return this.variable;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(@NotNull Activity activity, int i4, int i5, @Nullable Intent intent) {
        String str;
        String str2;
        String str3;
        String str4;
        boolean z3;
        boolean z4;
        boolean z5;
        MacroDroidVariable macroDroidVariable;
        Intrinsics.checkNotNullParameter(activity, "activity");
        setActivity(activity);
        if (i5 == -1 && intent != null) {
            boolean z6 = false;
            if (i4 != 1000) {
                if (i4 == EMAIL_ACTIVITY_REQUEST) {
                    Bundle extras = intent.getExtras();
                    DictionaryKeys dictionaryKeys = null;
                    if (extras != null) {
                        str = extras.getString("From");
                    } else {
                        str = null;
                    }
                    String str5 = "";
                    if (str == null) {
                        str = "";
                    }
                    this.m_fromEmailAddress = str;
                    Bundle extras2 = intent.getExtras();
                    if (extras2 != null) {
                        str2 = extras2.getString(EmailActivity.ADDRESS_EXTRA);
                    } else {
                        str2 = null;
                    }
                    if (str2 == null) {
                        str2 = "";
                    }
                    this.m_emailAddress = str2;
                    Bundle extras3 = intent.getExtras();
                    if (extras3 != null) {
                        str3 = extras3.getString("Body");
                    } else {
                        str3 = null;
                    }
                    if (str3 == null) {
                        str3 = "";
                    }
                    this.m_body = str3;
                    Bundle extras4 = intent.getExtras();
                    if (extras4 != null) {
                        str4 = extras4.getString("Subject");
                    } else {
                        str4 = null;
                    }
                    if (str4 != null) {
                        str5 = str4;
                    }
                    this.m_subject = str5;
                    Bundle extras5 = intent.getExtras();
                    if (extras5 != null) {
                        z3 = extras5.getBoolean(EmailActivity.ATTACH_SYSTEM_LOG_EXTRA);
                    } else {
                        z3 = false;
                    }
                    this.m_attachLog = z3;
                    Bundle extras6 = intent.getExtras();
                    if (extras6 != null) {
                        z4 = extras6.getBoolean("AttachUserLog");
                    } else {
                        z4 = false;
                    }
                    this.m_attachUserLog = z4;
                    Bundle extras7 = intent.getExtras();
                    if (extras7 != null) {
                        z5 = extras7.getBoolean(EmailActivity.HTML_MODE_ENABLED_EXTRA);
                    } else {
                        z5 = false;
                    }
                    this.useHtml = z5;
                    Bundle extras8 = intent.getExtras();
                    if (extras8 != null) {
                        macroDroidVariable = (MacroDroidVariable) extras8.getParcelable("Variable");
                    } else {
                        macroDroidVariable = null;
                    }
                    this.variable = macroDroidVariable;
                    Bundle extras9 = intent.getExtras();
                    if (extras9 != null) {
                        dictionaryKeys = (DictionaryKeys) extras9.getParcelable("dictionary_keys");
                    }
                    this.varDictionaryKeys = dictionaryKeys;
                    Bundle extras10 = intent.getExtras();
                    if (extras10 != null) {
                        z6 = extras10.getBoolean(EmailActivity.EXTRA_BLOCK_NEXT_ACTIONS);
                    }
                    this.blockNextAction = z6;
                    MacroDroidVariable macroDroidVariable2 = this.variable;
                    if (macroDroidVariable2 != null && getVariableByName(macroDroidVariable2.getName()) == null) {
                        addVariable(macroDroidVariable2);
                    }
                    itemComplete();
                    return;
                }
                return;
            }
            GmailHelper gmailHelper = this.m_gmailHelper;
            Intrinsics.checkNotNull(gmailHelper);
            if (gmailHelper.handleActivityResult(i4, i5, intent)) {
                S(false);
            }
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String[] o() {
        return O();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        int i4 = this.sendOption;
        if (i4 == 0) {
            M();
        } else if (i4 == 1) {
            N();
        }
    }

    public final void setEmailApi(@NotNull EmailApi emailApi) {
        Intrinsics.checkNotNullParameter(emailApi, "<set-?>");
        this.emailApi = emailApi;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(@NotNull String[] magicText) {
        Intrinsics.checkNotNullParameter(magicText, "magicText");
        if (magicText.length == 3) {
            this.m_emailAddress = magicText[0];
            this.m_body = magicText[1];
            this.m_subject = magicText[2];
            return;
        }
        String str = this.m_classType;
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + str + ")"));
    }

    public final void setSystemLogHelper(@NotNull SystemLogHelper systemLogHelper) {
        Intrinsics.checkNotNullParameter(systemLogHelper, "<set-?>");
        this.systemLogHelper = systemLogHelper;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeString(this.m_fromEmailAddress);
        out.writeString(this.m_emailAddress);
        out.writeString(this.m_subject);
        out.writeString(this.m_body);
        out.writeInt(this.m_attachLog ? 1 : 0);
        out.writeInt(this.m_attachUserLog ? 1 : 0);
        out.writeInt(this.sendOption);
        out.writeInt(this.useHtml ? 1 : 0);
        out.writeInt(this.blockNextAction ? 1 : 0);
        out.writeParcelable(this.variable, i4);
        out.writeParcelable(this.varDictionaryKeys, i4);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SendEmailAction(@Nullable Activity activity, @NotNull Macro macro) {
        this();
        Intrinsics.checkNotNullParameter(macro, "macro");
        setActivity(activity);
        this.m_macro = macro;
    }

    @Override // com.arlosoft.macrodroid.interfaces.BlockingAction
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo, int i4, boolean z3, @NotNull Stack<Integer> skipEndifIndexStack, @Nullable ResumeMacroInfo resumeMacroInfo, boolean z4) {
        Intrinsics.checkNotNullParameter(skipEndifIndexStack, "skipEndifIndexStack");
        String fromEmailAddress = MagicText.replaceMagicText(getContext(), this.m_fromEmailAddress, triggerContextInfo, getMacro());
        String emailAddress = MagicText.replaceMagicText(getContext(), this.m_emailAddress, triggerContextInfo, getMacro());
        String bodyWithCorrectNeWLines = g(this.m_body, triggerContextInfo);
        String subject = g(this.m_subject, triggerContextInfo);
        int i5 = this.sendOption;
        if (i5 == 0) {
            Intrinsics.checkNotNullExpressionValue(emailAddress, "emailAddress");
            Intrinsics.checkNotNullExpressionValue(bodyWithCorrectNeWLines, "bodyWithCorrectNeWLines");
            Intrinsics.checkNotNullExpressionValue(subject, "subject");
            P(emailAddress, bodyWithCorrectNeWLines, subject, triggerContextInfo, i4, z3, skipEndifIndexStack, resumeMacroInfo, z4);
        } else if (i5 == 1) {
            Intrinsics.checkNotNullExpressionValue(fromEmailAddress, "fromEmailAddress");
            Intrinsics.checkNotNullExpressionValue(emailAddress, "emailAddress");
            Intrinsics.checkNotNullExpressionValue(bodyWithCorrectNeWLines, "bodyWithCorrectNeWLines");
            Intrinsics.checkNotNullExpressionValue(subject, "subject");
            Q(fromEmailAddress, emailAddress, bodyWithCorrectNeWLines, subject, this.useHtml, triggerContextInfo, i4, z3, skipEndifIndexStack, resumeMacroInfo, z4);
        }
        if (z4 || this.blockNextAction) {
            return;
        }
        getMacro().invokeActions(getMacro().getActions(), i4, triggerContextInfo, z3, skipEndifIndexStack, resumeMacroInfo);
    }

    private SendEmailAction() {
        this.m_fromEmailAddress = "";
        this.m_emailAddress = "";
        this.m_subject = "";
        this.m_body = "";
        init();
    }

    private SendEmailAction(Parcel parcel) {
        super(parcel);
        this.m_fromEmailAddress = "";
        this.m_emailAddress = "";
        this.m_subject = "";
        this.m_body = "";
        init();
        String readString = parcel.readString();
        this.m_fromEmailAddress = readString == null ? "" : readString;
        String readString2 = parcel.readString();
        this.m_emailAddress = readString2 == null ? "" : readString2;
        String readString3 = parcel.readString();
        this.m_subject = readString3 == null ? "" : readString3;
        String readString4 = parcel.readString();
        this.m_body = readString4 != null ? readString4 : "";
        this.m_attachLog = parcel.readInt() != 0;
        this.m_attachUserLog = parcel.readInt() != 0;
        this.sendOption = parcel.readInt();
        this.useHtml = parcel.readInt() != 0;
        this.blockNextAction = parcel.readInt() != 0;
        this.variable = (MacroDroidVariable) parcel.readParcelable(MacroDroidVariable.class.getClassLoader());
        this.varDictionaryKeys = (DictionaryKeys) parcel.readParcelable(DictionaryKeys.class.getClassLoader());
    }

    /* compiled from: SendEmailAction.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }
}
