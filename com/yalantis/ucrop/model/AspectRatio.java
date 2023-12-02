package com.yalantis.ucrop.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* loaded from: classes6.dex */
public class AspectRatio implements Parcelable {
    public static final Parcelable.Creator<AspectRatio> CREATOR = new a();
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final String f38431a;

    /* renamed from: b  reason: collision with root package name */
    private final float f38432b;

    /* renamed from: c  reason: collision with root package name */
    private final float f38433c;

    /* loaded from: classes6.dex */
    static class a implements Parcelable.Creator<AspectRatio> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AspectRatio createFromParcel(Parcel parcel) {
            return new AspectRatio(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public AspectRatio[] newArray(int i4) {
            return new AspectRatio[i4];
        }
    }

    public AspectRatio(@Nullable String str, float f4, float f5) {
        this.f38431a = str;
        this.f38432b = f4;
        this.f38433c = f5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public String getAspectRatioTitle() {
        return this.f38431a;
    }

    public float getAspectRatioX() {
        return this.f38432b;
    }

    public float getAspectRatioY() {
        return this.f38433c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        parcel.writeString(this.f38431a);
        parcel.writeFloat(this.f38432b);
        parcel.writeFloat(this.f38433c);
    }

    protected AspectRatio(Parcel parcel) {
        this.f38431a = parcel.readString();
        this.f38432b = parcel.readFloat();
        this.f38433c = parcel.readFloat();
    }
}
