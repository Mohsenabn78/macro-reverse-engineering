package com.arlosoft.macrodroid.action.sms;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public class SMSMessage implements Parcelable, Comparable<SMSMessage> {
    public static final Parcelable.Creator<SMSMessage> CREATOR = new a();

    /* renamed from: g  reason: collision with root package name */
    private static int f4994g;

    /* renamed from: a  reason: collision with root package name */
    private final String f4995a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4996b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f4997c;

    /* renamed from: d  reason: collision with root package name */
    private final int f4998d;

    /* renamed from: e  reason: collision with root package name */
    private int f4999e;

    /* renamed from: f  reason: collision with root package name */
    private final int f5000f;

    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<SMSMessage> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public SMSMessage createFromParcel(Parcel parcel) {
            return new SMSMessage(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public SMSMessage[] newArray(int i4) {
            return new SMSMessage[i4];
        }
    }

    /* synthetic */ SMSMessage(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getMessage() {
        return this.f4996b;
    }

    public int getMsgId() {
        return this.f4998d;
    }

    public String getNumber() {
        return this.f4995a;
    }

    public int getSimId() {
        return this.f5000f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f4995a);
        parcel.writeString(this.f4996b);
        parcel.writeInt(this.f4998d);
        parcel.writeInt(this.f4999e);
        parcel.writeInt(!this.f4997c ? 1 : 0);
        parcel.writeInt(this.f5000f);
    }

    private SMSMessage(Parcel parcel) {
        this.f4995a = parcel.readString();
        this.f4996b = parcel.readString();
        this.f4998d = parcel.readInt();
        this.f4999e = parcel.readInt();
        this.f4997c = parcel.readInt() == 0;
        this.f5000f = parcel.readInt();
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull SMSMessage sMSMessage) {
        if (this.f4998d < sMSMessage.getMsgId()) {
            return -1;
        }
        return this.f4998d > sMSMessage.getMsgId() ? 1 : 0;
    }

    public SMSMessage(String str, String str2, boolean z3, int i4) {
        int i5 = f4994g + 1;
        f4994g = i5;
        this.f4998d = i5;
        this.f4995a = str;
        this.f4996b = str2;
        this.f4999e = 1;
        this.f4997c = z3;
        this.f5000f = i4;
    }
}
