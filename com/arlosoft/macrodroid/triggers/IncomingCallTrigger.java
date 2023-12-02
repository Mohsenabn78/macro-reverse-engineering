package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.os.Binder;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.telephony.TelephonyManager;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.Contact;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.triggers.info.IncomingCallTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.IncomingCallTriggerReceiver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class IncomingCallTrigger extends CallBasedTrigger {
    public static final Parcelable.Creator<IncomingCallTrigger> CREATOR = new a();
    private static IncomingCallTriggerReceiver sIncomingCallTriggerReceiver;
    private static int s_triggerCounter;
    private Contact m_incomingCallFrom;
    private List<Contact> m_incomingCallFromList;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<IncomingCallTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public IncomingCallTrigger createFromParcel(Parcel parcel) {
            return new IncomingCallTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public IncomingCallTrigger[] newArray(int i4) {
            return new IncomingCallTrigger[i4];
        }
    }

    /* synthetic */ IncomingCallTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f0() {
        sIncomingCallTriggerReceiver = new IncomingCallTriggerReceiver();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0() {
        Binder.clearCallingIdentity();
        try {
            ((TelephonyManager) getContext().getSystemService("phone")).listen(sIncomingCallTriggerReceiver, 32);
        } catch (SecurityException unused) {
            PermissionsHelper.showNeedsPermission(getContext(), "android.permission.READ_PHONE_STATE", SelectableItem.r(R.string.trigger_incoming_call), true, false);
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.CallBasedTrigger, com.arlosoft.macrodroid.common.SelectableItem
    public void anonymizeForTemplate() {
        super.anonymizeForTemplate();
        this.m_incomingCallFrom = null;
        ArrayList arrayList = new ArrayList();
        for (Contact contact : this.m_incomingCallFromList) {
            if (contact.getId().equals(Util.ANY_CONTACT_ID)) {
                arrayList.add(0, new Contact(Util.ANY_CONTACT_ID, Util.getAnyContactString(), Util.ANY_CONTACT_ID));
            } else if (contact.getId().equals(Util.ANY_NUMBER_ID)) {
                arrayList.add(0, new Contact(Util.ANY_NUMBER_ID, Util.getAnyNumberString(), Util.ANY_NUMBER_ID));
            } else if (contact.getId().equals(Util.NON_CONTACT_ID)) {
                arrayList.add(0, new Contact(Util.NON_CONTACT_ID, Util.getNonContactString(), Util.NON_CONTACT_ID));
            } else if (contact.getId().equals(Util.UNKNOWN_CALLER_ID)) {
                arrayList.add(0, new Contact(Util.UNKNOWN_CALLER_ID, Util.getUnkownCallerString(), Util.UNKNOWN_CALLER_ID));
            }
        }
        this.m_incomingCallFromList = arrayList;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0 && sIncomingCallTriggerReceiver != null) {
            try {
                ((TelephonyManager) getContext().getSystemService("phone")).listen(sIncomingCallTriggerReceiver, 0);
            } catch (SecurityException unused) {
                PermissionsHelper.showNeedsPermission(getContext(), "android.permission.READ_PHONE_STATE", SelectableItem.r(R.string.trigger_incoming_call), true, false);
            }
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (sIncomingCallTriggerReceiver == null) {
            try {
                sIncomingCallTriggerReceiver = new IncomingCallTriggerReceiver();
            } catch (Exception unused) {
                new Handler(getContext().getMainLooper()).post(new Runnable() { // from class: com.arlosoft.macrodroid.triggers.o3
                    @Override // java.lang.Runnable
                    public final void run() {
                        IncomingCallTrigger.f0();
                    }
                });
            }
        }
        if (s_triggerCounter == 0) {
            new Handler(getContext().getMainLooper()).post(new Runnable() { // from class: com.arlosoft.macrodroid.triggers.p3
                @Override // java.lang.Runnable
                public final void run() {
                    IncomingCallTrigger.this.g0();
                }
            });
        }
        s_triggerCounter++;
    }

    @Override // com.arlosoft.macrodroid.triggers.CallBasedTrigger
    protected Contact getContact() {
        return this.m_incomingCallFrom;
    }

    @Override // com.arlosoft.macrodroid.triggers.CallBasedTrigger
    public List<Contact> getContactList() {
        if (this.m_incomingCallFrom != null) {
            ArrayList arrayList = new ArrayList();
            this.m_incomingCallFromList = arrayList;
            arrayList.add(this.m_incomingCallFrom);
        }
        return this.m_incomingCallFromList;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return IncomingCallTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        return new String[]{"android.permission.READ_PHONE_STATE", "android.permission.READ_CONTACTS", "android.permission.READ_CALL_LOG"};
    }

    @Override // com.arlosoft.macrodroid.triggers.CallBasedTrigger
    protected void setContact(Contact contact) {
        this.m_incomingCallFrom = contact;
    }

    public void setDefaultContactAnyNumber() {
        ArrayList arrayList = new ArrayList();
        this.m_incomingCallFromList = arrayList;
        arrayList.add(new Contact(Util.ANY_NUMBER_ID, Util.getAnyNumberString(), Util.ANY_NUMBER_ID));
    }

    @Override // com.arlosoft.macrodroid.triggers.CallBasedTrigger, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeParcelable(this.m_incomingCallFrom, i4);
        Contact[] contactArr = new Contact[this.m_incomingCallFromList.size()];
        this.m_incomingCallFromList.toArray(contactArr);
        parcel.writeParcelableArray(contactArr, i4);
    }

    public IncomingCallTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public IncomingCallTrigger() {
        this.m_incomingCallFromList = new ArrayList();
    }

    private IncomingCallTrigger(Parcel parcel) {
        super(parcel);
        this.m_incomingCallFromList = new ArrayList();
        this.m_incomingCallFrom = (Contact) parcel.readParcelable(Contact.class.getClassLoader());
        Parcelable[] readParcelableArray = parcel.readParcelableArray(Contact.class.getClassLoader());
        if (readParcelableArray != null) {
            ArrayList arrayList = new ArrayList();
            this.m_incomingCallFromList = arrayList;
            Collections.addAll(arrayList, (Contact[]) Arrays.copyOf(readParcelableArray, readParcelableArray.length, Contact[].class));
        }
    }
}
