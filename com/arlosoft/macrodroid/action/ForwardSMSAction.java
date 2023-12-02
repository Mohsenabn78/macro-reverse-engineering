package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.util.Log;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.ForwardSMSActionInfo;
import com.arlosoft.macrodroid.action.sms.SMSOutputService2;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.Contact;
import com.arlosoft.macrodroid.common.IncomingSMS;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.IncomingSMSTrigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public class ForwardSMSAction extends Action {
    public static final Parcelable.Creator<ForwardSMSAction> CREATOR = new a();
    private Contact m_contact;
    private transient List<Contact> m_contactsList;
    private int m_simId;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<ForwardSMSAction> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ForwardSMSAction createFromParcel(Parcel parcel) {
            return new ForwardSMSAction(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ForwardSMSAction[] newArray(int i4) {
            return new ForwardSMSAction[i4];
        }
    }

    /* synthetic */ ForwardSMSAction(Parcel parcel, a aVar) {
        this(parcel);
    }

    @RequiresApi(api = 22)
    private void P(final List<SubscriptionInfo> list) {
        int simSlotIndex;
        CharSequence displayName;
        CharSequence carrierName;
        int subscriptionId;
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        int i5 = 0;
        for (SubscriptionInfo subscriptionInfo : list) {
            StringBuilder sb = new StringBuilder();
            simSlotIndex = subscriptionInfo.getSimSlotIndex();
            sb.append(simSlotIndex + 1);
            sb.append(" : ");
            displayName = subscriptionInfo.getDisplayName();
            sb.append((Object) displayName);
            sb.append(" - ");
            carrierName = subscriptionInfo.getCarrierName();
            sb.append((Object) carrierName);
            arrayList.add(sb.toString());
            subscriptionId = subscriptionInfo.getSubscriptionId();
            if (subscriptionId == this.m_simId) {
                i4 = i5;
            }
            i5++;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
        builder.setTitle(R.string.sim_card);
        builder.setSingleChoiceItems((String[]) arrayList.toArray(new String[0]), i4, (DialogInterface.OnClickListener) null);
        builder.setNegativeButton(17039360, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.a8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                ForwardSMSAction.this.Q(dialogInterface, i6);
            }
        });
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.action.b8
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i6) {
                ForwardSMSAction.this.R(list, dialogInterface, i6);
            }
        });
        AlertDialog create = builder.create();
        create.show();
        create.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.arlosoft.macrodroid.action.c8
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                ForwardSMSAction.this.S(dialogInterface);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q(DialogInterface dialogInterface, int i4) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void R(List list, DialogInterface dialogInterface, int i4) {
        int subscriptionId;
        subscriptionId = ((SubscriptionInfo) list.get(((AlertDialog) dialogInterface).getListView().getCheckedItemPosition())).getSubscriptionId();
        this.m_simId = subscriptionId;
        itemComplete();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(DialogInterface dialogInterface) {
        handleOptionsDialogCancelled();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        try {
            this.m_contact = this.m_contactsList.get(i4);
        } catch (IndexOutOfBoundsException unused) {
            Log.w(this.m_classType, "No contacts on device");
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void anonymizeForTemplate() {
        super.anonymizeForTemplate();
        this.m_contact = null;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean checkOnImport() {
        boolean z3 = false;
        if (this.m_contact == null) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("ForwardSMSActon: Contact was null in checkOnImport"));
            return false;
        }
        List<Contact> contacts = Util.getContacts(getContext(), false);
        if (contacts.size() <= 0) {
            return true;
        }
        Iterator<Contact> it = contacts.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Contact next = it.next();
            if (next.getName().equals(this.m_contact.getName())) {
                this.m_contact = next;
                z3 = true;
                break;
            }
        }
        if (!z3) {
            this.m_contact = new Contact(Contact.SELECT_CONTACT_ID, Contact.getSelectContactString(), Contact.SELECT_CONTACT_ID);
        }
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        List<Contact> contacts = Util.getContacts(getActivity(), true);
        if (this.m_contact != null) {
            for (int i4 = 0; i4 < contacts.size(); i4++) {
                if (contacts.get(i4).getName().equals(this.m_contact.getName())) {
                    return i4;
                }
            }
        }
        return 0;
    }

    public Contact getContact() {
        return this.m_contact;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getExtendedDetail() {
        if (this.m_contact != null) {
            return "[" + this.m_contact.getName() + "]";
        }
        return "[" + getContext().getString(R.string.invalid_contact) + "]";
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return ForwardSMSActionInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        return new String[]{"android.permission.SEND_SMS"};
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissionsOnImport() {
        return new String[]{"android.permission.READ_CONTACTS", "android.permission.READ_PHONE_STATE"};
    }

    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(TriggerContextInfo triggerContextInfo) {
        Contact contact = this.m_contact;
        IncomingSMS incomingSMSData = triggerContextInfo.getIncomingSMSData();
        if (incomingSMSData != null) {
            SMSOutputService2.sendMessage(getContext(), incomingSMSData.getMessage(), contact, null, false, 1, this.m_simId);
            return;
        }
        ToastCompat.makeText(getContext().getApplicationContext(), (int) R.string.macro_test_failed, 0).show();
        FirebaseAnalyticsEventLogger.log("Forward SMS action - incoming SMS is null");
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean isValid() {
        Contact contact = this.m_contact;
        if (contact == null) {
            return false;
        }
        if (contact.getName() == null) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SendSMSAction: The contact name is null? The id is: " + this.m_contact.getId() + " The number is: " + this.m_contact.getNumber()));
            return false;
        } else if (this.m_contact.getId() == null || this.m_contact.getId().equals(Contact.SELECT_CONTACT_ID)) {
            return false;
        } else {
            return this.m_macro.hasOnlyTrigger(IncomingSMSTrigger.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] o() {
        List<Contact> contacts = Util.getContacts(getActivity(), true);
        this.m_contactsList = contacts;
        contacts.size();
        try {
            Contact[] contactArr = new Contact[this.m_contactsList.size()];
            this.m_contactsList.toArray(contactArr);
            int size = this.m_contactsList.size();
            String[] strArr = new String[size];
            for (int i4 = 0; i4 < size; i4++) {
                strArr[i4] = contactArr[i4].getName();
            }
            return strArr;
        } catch (IndexOutOfBoundsException unused) {
            return new String[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String p() {
        return getContext().getString(R.string.select_contact);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        List<SubscriptionInfo> activeSubscriptionInfoList;
        if (this.m_contact == null) {
            this.m_contact = this.m_contactsList.get(0);
        }
        if (Build.VERSION.SDK_INT >= 22) {
            try {
                activeSubscriptionInfoList = ((SubscriptionManager) getContext().getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoList();
                if (activeSubscriptionInfoList != null && activeSubscriptionInfoList.size() > 1) {
                    P(activeSubscriptionInfoList);
                    return;
                }
                itemComplete();
                return;
            } catch (SecurityException unused) {
                itemComplete();
                return;
            }
        }
        itemComplete();
    }

    public void setContact(Contact contact) {
        this.m_contact = contact;
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeParcelable(this.m_contact, i4);
        parcel.writeInt(this.m_simId);
    }

    public ForwardSMSAction(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public ForwardSMSAction() {
    }

    private ForwardSMSAction(Parcel parcel) {
        super(parcel);
        this.m_contact = (Contact) parcel.readParcelable(Contact.class.getClassLoader());
        this.m_simId = parcel.readInt();
    }
}
