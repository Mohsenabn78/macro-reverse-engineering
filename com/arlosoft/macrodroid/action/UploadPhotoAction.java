package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AlertDialog;
import co.nedim.maildroidx.MaildroidX;
import co.nedim.maildroidx.MaildroidXType;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.email.EmailActivity;
import com.arlosoft.macrodroid.action.info.UploadPhotoActionInfo;
import com.arlosoft.macrodroid.action.outputservices.TwitterOutput;
import com.arlosoft.macrodroid.action.services.UploadPhotoService;
import com.arlosoft.macrodroid.action.services.UploadService;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.data.SmtpServerConfig;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.GmailHelper;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;

/* loaded from: classes2.dex */
public class UploadPhotoAction extends Action implements TwitterOutput.TwitterAuthListener, SupportsMagicText {
    private static final int EMAIL_ACTIVITY_REQUEST = 18434;
    private String emailBody;
    private String emailFrom;
    private String emailSubject;
    private String m_email;
    private final transient GmailHelper m_gmailHelper;
    private String m_option;
    private boolean useSmtpEmail;
    private static final String VIA_INTENT = SelectableItem.r(R.string.action_upload_photo_via_intent);
    public static final Parcelable.Creator<UploadPhotoAction> CREATOR = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class a implements MaildroidX.onCompleteCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f2741a;

        a(String str) {
            this.f2741a = str;
        }

        @Override // co.nedim.maildroidx.MaildroidX.onCompleteCallback
        public long getTimeout() {
            return 15000L;
        }

        @Override // co.nedim.maildroidx.MaildroidX.onCompleteCallback
        public void onFail(String str) {
            SystemLog.logError("Failed to send photo to: " + this.f2741a + ": " + str.replace("\n", ". "), UploadPhotoAction.this.getMacroGuid().longValue());
            if (Settings.getEmailNotifyFailure(UploadPhotoAction.this.getContext())) {
                Util.displayNotification(UploadPhotoAction.this.getContext(), SelectableItem.r(R.string.action_upload_photo), String.format(SelectableItem.r(R.string.email_failed_to_x), this.f2741a), false);
            }
        }

        @Override // co.nedim.maildroidx.MaildroidX.onCompleteCallback
        public void onSuccess() {
            SystemLog.logInfo("Photo sent to: " + this.f2741a);
            if (Settings.getEmailNotifySuccess(UploadPhotoAction.this.getContext())) {
                Util.displayNotification(UploadPhotoAction.this.getContext(), SelectableItem.r(R.string.action_upload_photo), String.format(SelectableItem.r(R.string.email_sent_to_x), this.f2741a), false);
            }
        }
    }

    /* loaded from: classes2.dex */
    class b implements Parcelable.Creator<UploadPhotoAction> {
        b() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public UploadPhotoAction createFromParcel(Parcel parcel) {
            return new UploadPhotoAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public UploadPhotoAction[] newArray(int i4) {
            return new UploadPhotoAction[i4];
        }
    }

    /* synthetic */ UploadPhotoAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    private void T() {
        GoogleAccountCredential credentials = this.m_gmailHelper.getCredentials();
        Activity activity = getActivity();
        if (credentials.getSelectedAccountName() == null) {
            this.m_gmailHelper.chooseAccount(credentials, activity);
        } else {
            e0();
        }
    }

    private void U() {
        e0();
    }

    private String[] V() {
        return new String[]{SelectableItem.r(R.string.gmail_account), SelectableItem.r(R.string.smtp_server)};
    }

    private String W() {
        String str = this.emailSubject;
        if (str != null) {
            return str;
        }
        return SelectableItem.r(R.string.sharing_photo_default_email_subject);
    }

    private String[] X() {
        return new String[]{UploadService.UPLOAD_TWITTER, UploadService.UPLOAD_EMAIL, VIA_INTENT};
    }

    private String[] Y() {
        return new String[]{UploadService.UPLOAD_TWITTER, SelectableItem.r(R.string.send_via_email), VIA_INTENT};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(DialogInterface dialogInterface, int i4) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(DialogInterface dialogInterface, int i4) {
        if (((AlertDialog) dialogInterface).getListView().getCheckedItemPosition() == 0) {
            this.useSmtpEmail = false;
            T();
            return;
        }
        this.useSmtpEmail = true;
        U();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0(DialogInterface dialogInterface) {
        handleOptionsDialogCancelled();
    }

    private void c0(String str, String str2, String str3, String str4) {
        SmtpServerConfig smtpServerConfig = Settings.getSmtpServerConfig(getContext());
        if (!smtpServerConfig.isValid()) {
            SystemLog.logError("Failed to share photo via email to: " + this.m_email + ". SMTP Configuration is invalid", getMacroGuid().longValue());
            return;
        }
        String lastPhotoPath = Util.getLastPhotoPath(getContext());
        if (lastPhotoPath == null) {
            SystemLog.logError("Failed to share photo via email to: " + this.m_email + ". No photo found.", getMacroGuid().longValue());
            return;
        }
        MaildroidX.Builder builder = new MaildroidX.Builder().smtp(smtpServerConfig.getServerAddress()).smtpUsername(smtpServerConfig.getUsername()).smtpPassword(smtpServerConfig.getPassword()).port(smtpServerConfig.getServerPort()).isStartTLSEnabled(smtpServerConfig.getStartTlsEnabled()).type(MaildroidXType.PLAIN).to(str2);
        if (str == null) {
            str = "";
        }
        builder.from(str).subject(str3).body(str4).attachment(lastPhotoPath).onCompleteCallback(new a(str2)).mail();
    }

    private void d0() {
        Uri lastPhoto = Util.getLastPhoto(getContext());
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/jpg");
        intent.putExtra("android.intent.extra.STREAM", lastPhoto);
        getContext().startActivity(Intent.createChooser(intent, SelectableItem.r(R.string.action_upload_photo_share_last)).addFlags(268435456));
    }

    private void e0() {
        Activity activity = getActivity();
        Intent intent = new Intent(activity, EmailActivity.class);
        intent.putParcelableArrayListExtra("Trigger", this.m_macro.getTriggerList());
        intent.putExtra("From", this.emailFrom);
        intent.putExtra(EmailActivity.ADDRESS_EXTRA, this.m_email);
        intent.putExtra("Subject", W());
        intent.putExtra("Body", this.emailBody);
        intent.putExtra(EmailActivity.SMTP_MODE_EXTRA, this.useSmtpEmail);
        intent.putExtra("Macro", getMacro());
        intent.putExtra(EmailActivity.SENDING_ATTACHMENT_EXTRA, true);
        activity.startActivityForResult(intent, EMAIL_ACTIVITY_REQUEST);
    }

    private void f0() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(p());
        builder.setSingleChoiceItems(V(), this.useSmtpEmail ? 1 : 0, (DialogInterface.OnClickListener) null);
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.ut
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                UploadPhotoAction.this.Z(dialogInterface, i4);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.vt
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                UploadPhotoAction.this.a0(dialogInterface, i4);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.wt
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                UploadPhotoAction.this.b0(dialogInterface);
            }
        });
    }

    private String[] getOptions() {
        return new String[]{UploadService.UPLOAD_FACEBOOK, UploadService.UPLOAD_TWITTER, UploadService.UPLOAD_EMAIL, VIA_INTENT};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.m_option = X()[i4];
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        String[] options = getOptions();
        if (this.m_option != null) {
            for (int i4 = 1; i4 < options.length; i4++) {
                if (this.m_option.equals(options[i4])) {
                    return i4 - 1;
                }
            }
        } else {
            this.m_option = UploadService.UPLOAD_EMAIL;
        }
        return 1;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getEditModeWarning() {
        if (!isValid()) {
            return SelectableItem.r(R.string.action_set_bluetooth_invalid);
        }
        return null;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        String str = this.m_option;
        if (str != null) {
            if (str.equals(UploadService.UPLOAD_EMAIL)) {
                return SelectableItem.r(R.string.send_via_email) + ": " + this.m_email;
            }
            return this.m_option;
        }
        return SelectableItem.r(R.string.action_upload_photo_select_site);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return UploadPhotoActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        if (Build.VERSION.SDK_INT >= 33) {
            return new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.GET_ACCOUNTS"};
        }
        return new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.GET_ACCOUNTS"};
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.m_email, this.emailSubject, this.emailBody};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        setActivity(activity);
        if (i5 == -1 && intent != null) {
            if (i4 == 1000) {
                if (this.m_gmailHelper.handleActivityResult(i4, i5, intent)) {
                    e0();
                }
            } else if (i4 == EMAIL_ACTIVITY_REQUEST) {
                this.emailFrom = intent.getExtras().getString("From");
                this.m_email = intent.getExtras().getString(EmailActivity.ADDRESS_EXTRA);
                this.emailBody = intent.getExtras().getString("Body");
                this.emailSubject = intent.getExtras().getString("Subject");
                itemComplete();
            }
        }
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        if (this.m_option.equals(VIA_INTENT)) {
            d0();
            return;
        }
        String replaceMagicText = MagicText.replaceMagicText(getContext(), this.m_email, triggerContextInfo, getMacro());
        String replaceMagicText2 = MagicText.replaceMagicText(getContext(), W(), triggerContextInfo, getMacro());
        Context context = getContext();
        String str = this.emailBody;
        if (str == null) {
            str = "";
        }
        String replaceMagicText3 = MagicText.replaceMagicText(context, str, triggerContextInfo, getMacro());
        if (this.m_option.equals(UploadService.UPLOAD_EMAIL) && this.useSmtpEmail) {
            MagicText.replaceMagicText(getContext(), this.emailFrom, triggerContextInfo, getMacro());
            c0(this.emailFrom, replaceMagicText, replaceMagicText2, replaceMagicText3);
            return;
        }
        Intent intent = new Intent(getContext(), UploadPhotoService.class);
        intent.putExtra(UploadService.EXTRA_UPLOAD_SITE, this.m_option);
        if (this.m_option.equals(UploadService.UPLOAD_EMAIL)) {
            intent.putExtra(UploadService.EXTRA_UPLOAD_EMAIL_ADDRESS, MagicText.replaceMagicText(getContext().getApplicationContext(), replaceMagicText, triggerContextInfo, getMacro()));
            intent.putExtra("Subject", replaceMagicText2);
            intent.putExtra("Body", replaceMagicText3);
        }
        getContext().startService(intent);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        if ((this.m_option.equals(UploadService.UPLOAD_EMAIL) && !this.useSmtpEmail && (this.m_gmailHelper.getCredentials() == null || this.m_gmailHelper.getCredentials().getSelectedAccountName() == null)) || this.m_option == null) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return Y();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        Activity activity = getActivity();
        String str = this.m_option;
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case 67066748:
                if (str.equals(UploadService.UPLOAD_EMAIL)) {
                    c4 = 0;
                    break;
                }
                break;
            case 561774310:
                if (str.equals(UploadService.UPLOAD_FACEBOOK)) {
                    c4 = 1;
                    break;
                }
                break;
            case 748307027:
                if (str.equals(UploadService.UPLOAD_TWITTER)) {
                    c4 = 2;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                f0();
                return;
            case 1:
                if (Settings.getFacebookAuthToken(getContext()) != null) {
                    itemComplete();
                    return;
                }
                return;
            case 2:
                if (!TwitterOutput.isTwitterAccountConfigured(activity)) {
                    TwitterOutput.setupTwitter(activity, this);
                    return;
                } else {
                    itemComplete();
                    return;
                }
            default:
                itemComplete();
                return;
        }
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 3) {
            this.m_email = strArr[0];
            this.emailSubject = strArr[1];
            this.emailBody = strArr[2];
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + this.m_classType + ")"));
    }

    @Override // com.arlosoft.macrodroid.action.outputservices.TwitterOutput.TwitterAuthListener
    public void twitterAuthOK() {
        itemComplete();
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeString(this.m_option);
        parcel.writeString(this.m_email);
        parcel.writeString(this.emailSubject);
        parcel.writeString(this.emailBody);
        parcel.writeString(this.emailFrom);
        parcel.writeInt(this.useSmtpEmail ? 1 : 0);
    }

    public UploadPhotoAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public UploadPhotoAction() {
        this.m_option = UploadService.UPLOAD_EMAIL;
        this.m_gmailHelper = GmailHelper.getInstance(getContext().getApplicationContext());
    }

    private UploadPhotoAction(Parcel parcel) {
        super(parcel);
        this.m_option = UploadService.UPLOAD_EMAIL;
        this.m_gmailHelper = GmailHelper.getInstance(getContext().getApplicationContext());
        this.m_option = parcel.readString();
        this.m_email = parcel.readString();
        this.emailSubject = parcel.readString();
        this.emailBody = parcel.readString();
        this.emailFrom = parcel.readString();
        this.useSmtpEmail = parcel.readInt() != 0;
    }
}
