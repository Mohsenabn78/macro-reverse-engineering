package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.telephony.TelephonyManager;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.Contact;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.triggers.info.CallEndedTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.CallEndedTriggerReceiver;
import com.arlosoft.macrodroid.triggers.receivers.IncomingCallMonitor;
import com.arlosoft.macrodroid.triggers.receivers.OutgoingCallMonitor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class CallEndedTrigger extends CallBasedTrigger {
    public static final Parcelable.Creator<CallEndedTrigger> CREATOR = new a();
    private static final String PHONE_STATE_ACTION = "android.intent.action.PHONE_STATE";
    private static CallEndedTriggerReceiver s_endCallTriggerReceiver;
    private static IncomingCallMonitor s_incomingCallMonitor;
    private static OutgoingCallMonitor s_outgoingCallMonitor;
    private static int s_triggerCounter;
    private List<Contact> m_contactList;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<CallEndedTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CallEndedTrigger createFromParcel(Parcel parcel) {
            return new CallEndedTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public CallEndedTrigger[] newArray(int i4) {
            return new CallEndedTrigger[i4];
        }
    }

    /* synthetic */ CallEndedTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e0() {
        Binder.clearCallingIdentity();
        try {
            ((TelephonyManager) getContext().getSystemService("phone")).listen(s_incomingCallMonitor, 32);
        } catch (SecurityException unused) {
            PermissionsHelper.showNeedsPermission(getContext(), "android.permission.READ_PHONE_STATE", SelectableItem.r(R.string.trigger_call_ended), true, false);
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.CallBasedTrigger, com.arlosoft.macrodroid.common.SelectableItem
    public void anonymizeForTemplate() {
        super.anonymizeForTemplate();
        ArrayList arrayList = new ArrayList();
        for (Contact contact : this.m_contactList) {
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
        this.m_contactList = arrayList;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            try {
                if (s_outgoingCallMonitor != null) {
                    getContext().unregisterReceiver(s_outgoingCallMonitor);
                }
                if (s_incomingCallMonitor != null) {
                    try {
                        ((TelephonyManager) getContext().getSystemService("phone")).listen(s_incomingCallMonitor, 0);
                    } catch (SecurityException unused) {
                        PermissionsHelper.showNeedsPermission(getContext(), "android.permission.READ_PHONE_STATE", SelectableItem.r(R.string.trigger_call_ended), true, false);
                    }
                }
                MacroDroidApplication.getInstance().unregisterReceiver(s_endCallTriggerReceiver);
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
            s_endCallTriggerReceiver = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            s_endCallTriggerReceiver = new CallEndedTriggerReceiver();
            if (s_outgoingCallMonitor == null) {
                s_outgoingCallMonitor = new OutgoingCallMonitor();
            }
            if (s_incomingCallMonitor == null) {
                s_incomingCallMonitor = new IncomingCallMonitor();
            }
            IntentFilter intentFilter = new IntentFilter(PHONE_STATE_ACTION);
            intentFilter.setPriority(Integer.MAX_VALUE);
            MacroDroidApplication.getInstance().registerReceiver(s_endCallTriggerReceiver, intentFilter);
            getContext().registerReceiver(s_outgoingCallMonitor, new IntentFilter("android.intent.action.NEW_OUTGOING_CALL"));
            new Handler(getContext().getMainLooper()).post(new Runnable() { // from class: com.arlosoft.macrodroid.triggers.x1
                @Override // java.lang.Runnable
                public final void run() {
                    CallEndedTrigger.this.e0();
                }
            });
        }
        s_triggerCounter++;
    }

    @Override // com.arlosoft.macrodroid.triggers.CallBasedTrigger
    Contact getContact() {
        return null;
    }

    @Override // com.arlosoft.macrodroid.triggers.CallBasedTrigger
    public List<Contact> getContactList() {
        if (this.m_contactList == null) {
            this.m_contactList = new ArrayList();
        }
        return this.m_contactList;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return CallEndedTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        return new String[]{"android.permission.READ_PHONE_STATE", "android.permission.READ_CONTACTS", "android.permission.READ_CALL_LOG"};
    }

    public void setDefaultContactAnyNumber() {
        ArrayList arrayList = new ArrayList();
        this.m_contactList = arrayList;
        arrayList.add(new Contact(Util.ANY_NUMBER_ID, Util.getAnyNumberString(), Util.ANY_NUMBER_ID));
    }

    @Override // com.arlosoft.macrodroid.triggers.CallBasedTrigger, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        Contact[] contactArr = new Contact[this.m_contactList.size()];
        this.m_contactList.toArray(contactArr);
        parcel.writeParcelableArray(contactArr, i4);
    }

    public CallEndedTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public CallEndedTrigger() {
        this.m_contactList = new ArrayList();
    }

    private CallEndedTrigger(Parcel parcel) {
        super(parcel);
        this.m_contactList = new ArrayList();
        Parcelable[] readParcelableArray = parcel.readParcelableArray(Contact.class.getClassLoader());
        if (readParcelableArray != null) {
            ArrayList arrayList = new ArrayList();
            this.m_contactList = arrayList;
            Collections.addAll(arrayList, (Contact[]) Arrays.copyOf(readParcelableArray, readParcelableArray.length, Contact[].class));
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.CallBasedTrigger
    void setContact(Contact contact) {
    }
}
