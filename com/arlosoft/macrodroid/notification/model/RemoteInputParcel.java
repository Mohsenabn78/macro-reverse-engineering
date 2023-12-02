package com.arlosoft.macrodroid.notification.model;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.RemoteInput;

/* loaded from: classes3.dex */
public class RemoteInputParcel implements Parcelable {
    public static final Parcelable.Creator CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private String f13019a;

    /* renamed from: b  reason: collision with root package name */
    private String f13020b;

    /* renamed from: c  reason: collision with root package name */
    private String[] f13021c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f13022d;

    /* renamed from: e  reason: collision with root package name */
    private Bundle f13023e;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public RemoteInputParcel createFromParcel(Parcel parcel) {
            return new RemoteInputParcel(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public RemoteInputParcel[] newArray(int i4) {
            return new RemoteInputParcel[i4];
        }
    }

    public RemoteInputParcel(RemoteInput remoteInput) {
        this.f13021c = new String[0];
        this.f13019a = remoteInput.getLabel().toString();
        this.f13020b = remoteInput.getResultKey();
        charSequenceToStringArray(remoteInput.getChoices());
        this.f13022d = remoteInput.getAllowFreeFormInput();
        this.f13023e = remoteInput.getExtras();
    }

    public void charSequenceToStringArray(CharSequence[] charSequenceArr) {
        if (charSequenceArr != null) {
            int length = charSequenceArr.length;
            this.f13021c = new String[charSequenceArr.length];
            for (int i4 = 0; i4 < length; i4++) {
                this.f13021c[i4] = charSequenceArr[i4].toString();
            }
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CharSequence[] getChoices() {
        return this.f13021c;
    }

    public Bundle getExtras() {
        return this.f13023e;
    }

    public String getLabel() {
        return this.f13019a;
    }

    public String getResultKey() {
        return this.f13020b;
    }

    public boolean isAllowFreeFormInput() {
        return this.f13022d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f13019a);
        parcel.writeString(this.f13020b);
        parcel.writeStringArray(this.f13021c);
        parcel.writeByte(this.f13022d ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.f13023e, i4);
    }

    public RemoteInputParcel(Parcel parcel) {
        this.f13021c = new String[0];
        this.f13019a = parcel.readString();
        this.f13020b = parcel.readString();
        this.f13021c = parcel.createStringArray();
        this.f13022d = parcel.readByte() != 0;
        this.f13023e = (Bundle) parcel.readParcelable(Bundle.class.getClassLoader());
    }
}
