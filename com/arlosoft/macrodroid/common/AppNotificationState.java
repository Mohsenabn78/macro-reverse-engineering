package com.arlosoft.macrodroid.common;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class AppNotificationState implements Parcelable {
    public static final Parcelable.Creator<AppNotificationState> CREATOR = new a();
    public static final int STATE_DISABLE = 2;
    public static final int STATE_ENABLE = 1;
    public static final int STATE_NO_CHANGE = 0;

    /* renamed from: a  reason: collision with root package name */
    private final String f9845a;

    /* renamed from: b  reason: collision with root package name */
    private final String f9846b;

    /* renamed from: c  reason: collision with root package name */
    private int f9847c;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<AppNotificationState> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AppNotificationState createFromParcel(Parcel parcel) {
            return new AppNotificationState(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AppNotificationState[] newArray(int i4) {
            return new AppNotificationState[i4];
        }
    }

    /* synthetic */ AppNotificationState(Parcel parcel, a aVar) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAppName() {
        return this.f9846b;
    }

    public int getAppNotificationState() {
        return this.f9847c;
    }

    public String getPackageName() {
        return this.f9845a;
    }

    public void setAppNotificationState(int i4) {
        this.f9847c = i4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f9845a);
        parcel.writeString(this.f9846b);
        parcel.writeInt(this.f9847c);
    }

    public AppNotificationState(String str, String str2, int i4) {
        this.f9845a = str;
        this.f9846b = str2;
        this.f9847c = i4;
    }

    private AppNotificationState(Parcel parcel) {
        this.f9845a = parcel.readString();
        this.f9846b = parcel.readString();
        this.f9847c = parcel.readInt();
    }
}
