package com.arlosoft.macrodroid.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;

/* loaded from: classes3.dex */
public class Contact implements Parcelable {
    public static final Parcelable.Creator<Contact> CREATOR = new a();
    public static final String HARDWIRED_NUMBER_CONTACT_ID = "Hardwired_Number";
    public static final String INCOMING_CONTACT_ID = "Incoming_Contact";
    public static final String LAST_NUMBER_CALLED_CONTACT_ID = "Last_Number_Called";
    public static final String SELECT_CONTACT_ID = "Select_Contact";
    private final String m_id;
    private final String m_lookupKey;
    private final String m_name;
    private String m_number;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<Contact> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Contact createFromParcel(Parcel parcel) {
            return new Contact(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public Contact[] newArray(int i4) {
            return new Contact[i4];
        }
    }

    /* synthetic */ Contact(Parcel parcel, a aVar) {
        this(parcel);
    }

    public static String getHardwiredContactName() {
        return "[" + MacroDroidApplication.getInstance().getString(R.string.select_number) + "]";
    }

    public static String getIncomingCallNumContactName() {
        return MacroDroidApplication.getInstance().getString(R.string.select_incoming_call_num);
    }

    public static String getIncomingSmsContactName() {
        return MacroDroidApplication.getInstance().getString(R.string.select_incoming_sms_num);
    }

    public static String getLastNumberCalledContactName() {
        return MacroDroidApplication.getInstance().getString(R.string.last_number_called);
    }

    public static String getSelectContactString() {
        return "[" + MacroDroidApplication.getInstance().getString(R.string.select_contact) + "]";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Contact)) {
            return false;
        }
        Contact contact = (Contact) obj;
        if (this.m_name.equals(contact.getName()) && this.m_id.equals(contact.getId()) && this.m_lookupKey.equals(contact.getLookupKey())) {
            return true;
        }
        return false;
    }

    public String getId() {
        return this.m_id;
    }

    public String getLookupKey() {
        return this.m_lookupKey;
    }

    public String getName() {
        return this.m_name;
    }

    public String getNumber() {
        return this.m_number;
    }

    public void setNumber(String str) {
        this.m_number = str;
    }

    public String toString() {
        return this.m_name;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.m_name);
        parcel.writeString(this.m_id);
        parcel.writeString(this.m_number);
        parcel.writeString(this.m_lookupKey);
    }

    public Contact(String str, String str2, String str3) {
        this.m_id = str;
        this.m_name = str2;
        this.m_lookupKey = str3;
    }

    public Contact(String str, String str2, String str3, String str4) {
        this.m_id = str;
        this.m_name = str2;
        this.m_lookupKey = str3;
        this.m_number = str4;
    }

    private Contact(Parcel parcel) {
        this.m_name = parcel.readString();
        this.m_id = parcel.readString();
        this.m_number = parcel.readString();
        this.m_lookupKey = parcel.readString();
    }
}
