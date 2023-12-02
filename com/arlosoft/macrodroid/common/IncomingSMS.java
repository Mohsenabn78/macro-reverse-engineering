package com.arlosoft.macrodroid.common;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class IncomingSMS implements Parcelable {
    public static final Parcelable.Creator<IncomingSMS> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f9866a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9867b;

    /* renamed from: c  reason: collision with root package name */
    private final String f9868c;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<IncomingSMS> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public IncomingSMS createFromParcel(Parcel parcel) {
            return new IncomingSMS(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public IncomingSMS[] newArray(int i4) {
            return new IncomingSMS[i4];
        }
    }

    /* synthetic */ IncomingSMS(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getContactName() {
        return this.f9866a;
    }

    public String getFromNumber() {
        return this.f9868c;
    }

    public String getMessage() {
        return this.f9867b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f9866a);
        parcel.writeString(this.f9867b);
        parcel.writeString(this.f9868c);
    }

    public IncomingSMS(String str, String str2, String str3) {
        this.f9866a = str;
        this.f9867b = str2;
        this.f9868c = str3;
    }

    private IncomingSMS(Parcel parcel) {
        this.f9866a = parcel.readString();
        this.f9867b = parcel.readString();
        this.f9868c = parcel.readString();
    }
}
