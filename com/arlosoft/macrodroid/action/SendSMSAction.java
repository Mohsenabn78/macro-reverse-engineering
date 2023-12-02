package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.SendSMSActionInfo;
import com.arlosoft.macrodroid.action.sms.SMSActivity;
import com.arlosoft.macrodroid.action.sms.SMSOutputService2;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.Contact;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.interfaces.SupportsMagicText;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.IncomingCallTrigger;
import com.arlosoft.macrodroid.triggers.IncomingSMSTrigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;

/* loaded from: classes2.dex */
public class SendSMSAction extends Action implements SupportsMagicText {
    public static final Parcelable.Creator<SendSMSAction> CREATOR = new a();
    private static final int SMS_ACTIVITY_REQUEST = 499;
    private boolean m_addToMessageLog;
    private Contact m_contact;
    private String m_messageContent;
    private String m_number;
    private boolean m_prePopulate;
    private int m_simId;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SendSMSAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SendSMSAction createFromParcel(Parcel parcel) {
            return new SendSMSAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SendSMSAction[] newArray(int i4) {
            return new SendSMSAction[i4];
        }
    }

    /* synthetic */ SendSMSAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void anonymizeForTemplate() {
        super.anonymizeForTemplate();
        String str = this.m_number;
        if (str == null || (!str.startsWith("[") && !this.m_number.startsWith("{"))) {
            this.m_number = "01234987654";
            this.m_contact = new Contact(Contact.HARDWIRED_NUMBER_CONTACT_ID, Contact.getHardwiredContactName(), Contact.HARDWIRED_NUMBER_CONTACT_ID);
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getConfiguredName() {
        if (this.m_prePopulate) {
            return SelectableItem.r(R.string.action_send_sms_pre_populate);
        }
        return getName();
    }

    public Contact getContact() {
        return this.m_contact;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        Contact contact = this.m_contact;
        if (contact != null) {
            if (contact.getId().equals(Contact.HARDWIRED_NUMBER_CONTACT_ID)) {
                return this.m_number + ": " + this.m_messageContent;
            }
            return "[" + this.m_contact.getName() + "]: " + this.m_messageContent;
        }
        return "[" + SelectableItem.r(R.string.invalid_contact) + ": " + this.m_messageContent + "]";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return SendSMSActionInfo.getInstance();
    }

    public String getMessageContent() {
        return this.m_messageContent;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        if (Build.VERSION.SDK_INT >= 31) {
            return new String[]{"android.permission.SEND_SMS", "android.permission.READ_CONTACTS", "android.permission.READ_PHONE_STATE"};
        }
        return new String[]{"android.permission.SEND_SMS", "android.permission.READ_CONTACTS", "android.permission.READ_PHONE_STATE"};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissionsOnImport() {
        return new String[]{"android.permission.READ_CONTACTS"};
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public String[] getPossibleMagicText() {
        return new String[]{this.m_number, this.m_messageContent};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getSystemLogEntryName(TriggerContextInfo triggerContextInfo) {
        return getName() + " '" + g(this.m_messageContent, triggerContextInfo) + "'";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleActivityResult(Activity activity, int i4, int i5, Intent intent) {
        setActivity(activity);
        if (i4 == SMS_ACTIVITY_REQUEST && i5 == -1) {
            this.m_contact = (Contact) intent.getExtras().getParcelable(SMSActivity.CONTACT_EXTRA);
            this.m_messageContent = intent.getExtras().getString(SMSActivity.MESSAGE_EXTRA);
            this.m_addToMessageLog = intent.getExtras().getBoolean(SMSActivity.ADD_TO_MESSAGE_LOG_EXTRA);
            this.m_prePopulate = intent.getExtras().getBoolean(SMSActivity.PRE_POPULATE_EXTRA);
            this.m_number = intent.getExtras().getString(SMSActivity.NUMBER);
            this.m_simId = intent.getExtras().getInt(Constants.SIM_ID);
            itemComplete();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleItemSelected() {
        String str;
        Activity activity = getActivity();
        Intent intent = new Intent(activity, SMSActivity.class);
        intent.putParcelableArrayListExtra("Trigger", this.m_macro.getTriggerList());
        intent.putExtra("Message", this.m_messageContent);
        intent.putExtra("Destination", this.m_contact);
        intent.putExtra(SMSActivity.ADD_TO_MESSAGE_LOG_EXTRA, this.m_addToMessageLog);
        intent.putExtra(SMSActivity.PRE_POPULATE_EXTRA, this.m_prePopulate);
        intent.putExtra(Constants.SIM_ID, this.m_simId);
        intent.putExtra("Macro", getMacro());
        String str2 = this.m_number;
        if (str2 == null) {
            Contact contact = this.m_contact;
            if (contact != null) {
                str = Util.getPreferredNumberForContact(activity, contact);
            } else {
                str = null;
            }
            intent.putExtra(SMSActivity.NUMBER, str);
        } else {
            intent.putExtra(SMSActivity.NUMBER, str2);
        }
        activity.startActivityForResult(intent, SMS_ACTIVITY_REQUEST);
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        String str;
        String str2;
        Contact contact = this.m_contact;
        if (this.m_number != null) {
            str = MagicText.replaceMagicText(getContext(), this.m_number, triggerContextInfo, false, getMacro());
            if (str == null || str.equals(MagicText.INCOMING_SMS_NUMBER)) {
                SystemLog.logError("No number available to send SMS to - [sms_number] must be set by the trigger", getMacroGuid().longValue());
                return;
            }
        } else {
            if (contact.getId().equals(Contact.INCOMING_CONTACT_ID)) {
                if (triggerContextInfo != null) {
                    if (triggerContextInfo.getIncomingSMSData() != null) {
                        str2 = triggerContextInfo.getIncomingSMSData().getFromNumber();
                    } else if (triggerContextInfo.getTextData() != null) {
                        str2 = triggerContextInfo.getTextData();
                    } else if (triggerContextInfo.getContactData() != null) {
                        str2 = triggerContextInfo.getContactData().getNumber();
                    } else {
                        str2 = "";
                    }
                    contact.setNumber(str2);
                } else {
                    FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SendSMSAction: contextInfo is null in ShareLocationAction"));
                }
            }
            str = null;
        }
        String str3 = str;
        String g4 = g(this.m_messageContent, triggerContextInfo);
        if (this.m_prePopulate) {
            if (str3 == null) {
                if (contact.getNumber() != null) {
                    str3 = contact.getNumber();
                } else {
                    str3 = Util.getPreferredNumberForContact(getContext(), contact);
                }
            }
            Intent intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + str3));
            intent.putExtra("sms_body", g4);
            intent.addFlags(268435456);
            getContext().startActivity(intent);
            return;
        }
        SMSOutputService2.sendMessage(getContext(), g4, contact, str3, this.m_addToMessageLog, 1, this.m_simId);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        Contact contact = this.m_contact;
        if (contact == null) {
            return false;
        }
        if (contact.getName() == null) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SendSMSAction: he contact name is null? The id is: " + this.m_contact.getId() + " The number is: " + this.m_contact.getNumber()));
            return false;
        } else if ((this.m_contact.getId().equals(Contact.INCOMING_CONTACT_ID) && !this.m_macro.hasOnlyTrigger(IncomingSMSTrigger.class) && !this.m_macro.hasOnlyTrigger(IncomingCallTrigger.class)) || this.m_contact.getId() == null || this.m_contact.getId().equals(Contact.SELECT_CONTACT_ID)) {
            return false;
        } else {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        return null;
    }

    public void setContact(Contact contact) {
        this.m_contact = contact;
    }

    public void setMessage(String str) {
        this.m_messageContent = str;
    }

    @Override // com.arlosoft.macrodroid.interfaces.SupportsMagicText
    public void setPossibleMagicText(String[] strArr) {
        if (strArr.length == 2) {
            this.m_number = strArr[0];
            this.m_messageContent = strArr[1];
            return;
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SetPossibleMagicText incorrect array length (" + this.m_classType + ")"));
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeParcelable(this.m_contact, i4);
        parcel.writeString(this.m_messageContent);
        parcel.writeInt(!this.m_addToMessageLog ? 1 : 0);
        parcel.writeString(this.m_number);
        parcel.writeInt(!this.m_prePopulate ? 1 : 0);
        parcel.writeInt(this.m_simId);
    }

    public SendSMSAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public SendSMSAction() {
    }

    private SendSMSAction(Parcel parcel) {
        super(parcel);
        this.m_contact = (Contact) parcel.readParcelable(Contact.class.getClassLoader());
        this.m_messageContent = parcel.readString();
        this.m_addToMessageLog = parcel.readInt() == 0;
        this.m_number = parcel.readString();
        this.m_prePopulate = parcel.readInt() == 0;
        this.m_simId = parcel.readInt();
    }
}
