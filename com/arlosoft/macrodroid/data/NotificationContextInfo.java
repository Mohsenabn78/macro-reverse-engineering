package com.arlosoft.macrodroid.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class NotificationContextInfo implements Parcelable {
    public static final Parcelable.Creator<NotificationContextInfo> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f10702a;

    /* renamed from: b  reason: collision with root package name */
    private String f10703b;

    /* renamed from: c  reason: collision with root package name */
    private final String f10704c;

    /* renamed from: d  reason: collision with root package name */
    private final String f10705d;

    /* renamed from: e  reason: collision with root package name */
    private String f10706e;

    /* renamed from: f  reason: collision with root package name */
    private String f10707f;

    /* renamed from: g  reason: collision with root package name */
    private String f10708g;

    /* renamed from: h  reason: collision with root package name */
    private String f10709h;

    /* renamed from: i  reason: collision with root package name */
    private String f10710i;

    /* renamed from: j  reason: collision with root package name */
    private String f10711j;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<NotificationContextInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public NotificationContextInfo createFromParcel(Parcel parcel) {
            return new NotificationContextInfo(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public NotificationContextInfo[] newArray(int i4) {
            return new NotificationContextInfo[i4];
        }
    }

    /* synthetic */ NotificationContextInfo(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getActionTitles() {
        return this.f10709h;
    }

    public String getApplicationName() {
        return this.f10704c;
    }

    public String getApplicationPackage() {
        return this.f10705d;
    }

    public String getBigText() {
        return this.f10707f;
    }

    public String getKey() {
        return this.f10711j;
    }

    public String getNotificationText() {
        return this.f10702a;
    }

    public String getNotificationTitle() {
        return this.f10703b;
    }

    public String getSubText() {
        return this.f10710i;
    }

    public String getTextLines() {
        return this.f10708g;
    }

    public String getTickerText() {
        return this.f10706e;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f10702a);
        parcel.writeString(this.f10703b);
        parcel.writeString(this.f10704c);
        parcel.writeString(this.f10705d);
        parcel.writeString(this.f10706e);
        parcel.writeString(this.f10707f);
        parcel.writeString(this.f10708g);
        parcel.writeString(this.f10709h);
        parcel.writeString(this.f10710i);
        parcel.writeString(this.f10711j);
    }

    public NotificationContextInfo(String str, String str2, String str3, String str4) {
        this.f10702a = str;
        this.f10704c = str2;
        this.f10705d = str3;
        this.f10711j = str4;
    }

    public NotificationContextInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10) {
        this.f10702a = str;
        this.f10704c = str2;
        this.f10705d = str3;
        this.f10703b = str4;
        this.f10706e = str5;
        this.f10707f = str6;
        this.f10708g = str7;
        this.f10709h = str8;
        this.f10710i = str9;
        this.f10711j = str10;
    }

    private NotificationContextInfo(Parcel parcel) {
        this.f10702a = parcel.readString();
        this.f10703b = parcel.readString();
        this.f10704c = parcel.readString();
        this.f10705d = parcel.readString();
        this.f10706e = parcel.readString();
        this.f10707f = parcel.readString();
        this.f10708g = parcel.readString();
        this.f10709h = parcel.readString();
        this.f10710i = parcel.readString();
        this.f10711j = parcel.readString();
    }
}
