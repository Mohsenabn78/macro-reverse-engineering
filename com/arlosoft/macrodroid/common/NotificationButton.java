package com.arlosoft.macrodroid.common;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class NotificationButton implements Parcelable {
    public static final Parcelable.Creator<NotificationButton> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final int f9992a;

    /* renamed from: b  reason: collision with root package name */
    private String f9993b;

    /* renamed from: c  reason: collision with root package name */
    private String f9994c;

    /* renamed from: d  reason: collision with root package name */
    private int f9995d;

    /* renamed from: e  reason: collision with root package name */
    private Uri f9996e;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<NotificationButton> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public NotificationButton createFromParcel(Parcel parcel) {
            return new NotificationButton(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public NotificationButton[] newArray(int i4) {
            return new NotificationButton[i4];
        }
    }

    /* synthetic */ NotificationButton(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getId() {
        return this.f9992a;
    }

    public int getImageResourceId() {
        return this.f9995d;
    }

    public String getImageResourceName() {
        return this.f9993b;
    }

    public String getImageResourcePackage() {
        return this.f9994c;
    }

    public Uri getImageUri() {
        return this.f9996e;
    }

    public void setImageResourceId(int i4) {
        this.f9995d = i4;
    }

    public void setImageResourceName(String str) {
        this.f9993b = str;
    }

    public void setImageResourcePackage(String str) {
        this.f9994c = str;
    }

    public void setImageUri(Uri uri) {
        this.f9996e = uri;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeInt(this.f9992a);
        parcel.writeString(this.f9993b);
        parcel.writeString(this.f9994c);
        parcel.writeInt(this.f9995d);
        parcel.writeString(this.f9996e.toString());
    }

    public NotificationButton(int i4, String str, String str2, int i5, Uri uri) {
        this.f9992a = i4;
        this.f9993b = str;
        this.f9994c = str2;
        this.f9995d = i5;
        this.f9996e = uri;
    }

    private NotificationButton(Parcel parcel) {
        this.f9992a = parcel.readInt();
        this.f9993b = parcel.readString();
        this.f9994c = parcel.readString();
        this.f9995d = parcel.readInt();
        this.f9996e = Uri.parse(parcel.readString());
    }
}
