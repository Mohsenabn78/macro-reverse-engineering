package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.common.Contact;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.OutgoingCallTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.OutgoingCallTriggerReceiver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class OutgoingCallTrigger extends CallBasedTrigger {
    public static final Parcelable.Creator<OutgoingCallTrigger> CREATOR = new a();
    private static OutgoingCallTriggerReceiver s_outgoingCallTriggerReceiver;
    private static int s_triggerCounter;
    private Contact m_outgoingCallTo;
    private List<Contact> m_outgoingCallToList;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<OutgoingCallTrigger> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public OutgoingCallTrigger createFromParcel(Parcel parcel) {
            return new OutgoingCallTrigger(parcel, (a) null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public OutgoingCallTrigger[] newArray(int i4) {
            return new OutgoingCallTrigger[i4];
        }
    }

    /* synthetic */ OutgoingCallTrigger(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = s_triggerCounter - 1;
        s_triggerCounter = i4;
        if (i4 == 0) {
            getContext().unregisterReceiver(s_outgoingCallTriggerReceiver);
            s_outgoingCallTriggerReceiver = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (s_triggerCounter == 0) {
            s_outgoingCallTriggerReceiver = new OutgoingCallTriggerReceiver();
            getContext().registerReceiver(s_outgoingCallTriggerReceiver, new IntentFilter("android.intent.action.NEW_OUTGOING_CALL"));
        }
        s_triggerCounter++;
    }

    @Override // com.arlosoft.macrodroid.triggers.CallBasedTrigger
    protected Contact getContact() {
        return this.m_outgoingCallTo;
    }

    @Override // com.arlosoft.macrodroid.triggers.CallBasedTrigger
    public List<Contact> getContactList() {
        if (this.m_outgoingCallTo != null) {
            ArrayList arrayList = new ArrayList();
            this.m_outgoingCallToList = arrayList;
            arrayList.add(this.m_outgoingCallTo);
        }
        return this.m_outgoingCallToList;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public SelectableItemInfo getInfo() {
        return OutgoingCallTriggerInfo.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getPermissions() {
        return new String[]{"android.permission.PROCESS_OUTGOING_CALLS"};
    }

    public void setConfigureContact() {
        this.m_outgoingCallTo = new Contact(Contact.SELECT_CONTACT_ID, Contact.getSelectContactString(), Contact.SELECT_CONTACT_ID);
    }

    @Override // com.arlosoft.macrodroid.triggers.CallBasedTrigger
    protected void setContact(Contact contact) {
        this.m_outgoingCallTo = contact;
    }

    @Override // com.arlosoft.macrodroid.triggers.CallBasedTrigger, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeParcelable(this.m_outgoingCallTo, i4);
        Contact[] contactArr = new Contact[this.m_outgoingCallToList.size()];
        this.m_outgoingCallToList.toArray(contactArr);
        parcel.writeParcelableArray(contactArr, i4);
    }

    public OutgoingCallTrigger(Activity activity, Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public OutgoingCallTrigger() {
        this.m_outgoingCallToList = new ArrayList();
    }

    private OutgoingCallTrigger(Parcel parcel) {
        super(parcel);
        this.m_outgoingCallToList = new ArrayList();
        this.m_outgoingCallTo = (Contact) parcel.readParcelable(Contact.class.getClassLoader());
        Parcelable[] readParcelableArray = parcel.readParcelableArray(Contact.class.getClassLoader());
        if (readParcelableArray != null) {
            ArrayList arrayList = new ArrayList();
            this.m_outgoingCallToList = arrayList;
            Collections.addAll(arrayList, (Contact[]) Arrays.copyOf(readParcelableArray, readParcelableArray.length, Contact[].class));
        }
    }
}
