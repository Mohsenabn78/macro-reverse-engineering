package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.common.base.Ascii;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
@SafeParcelable.Class(creator = "AmsEntityUpdateParcelableCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class zzi extends AbstractSafeParcelable implements com.google.android.gms.wearable.zza {
    public static final Parcelable.Creator<zzi> CREATOR = new zzj();
    @SafeParcelable.Field(getter = "getEntityId", id = 2)

    /* renamed from: a  reason: collision with root package name */
    private final byte f22800a;
    @SafeParcelable.Field(getter = "getAttributeId", id = 3)

    /* renamed from: b  reason: collision with root package name */
    private final byte f22801b;
    @SafeParcelable.Field(getter = "getValue", id = 4)

    /* renamed from: c  reason: collision with root package name */
    private final String f22802c;

    @SafeParcelable.Constructor
    public zzi(@SafeParcelable.Param(id = 2) byte b4, @SafeParcelable.Param(id = 3) byte b5, @SafeParcelable.Param(id = 4) String str) {
        this.f22800a = b4;
        this.f22801b = b5;
        this.f22802c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || zzi.class != obj.getClass()) {
            return false;
        }
        zzi zziVar = (zzi) obj;
        if (this.f22800a == zziVar.f22800a && this.f22801b == zziVar.f22801b && this.f22802c.equals(zziVar.f22802c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f22800a + Ascii.US) * 31) + this.f22801b) * 31) + this.f22802c.hashCode();
    }

    public final String toString() {
        byte b4 = this.f22800a;
        byte b5 = this.f22801b;
        String str = this.f22802c;
        return "AmsEntityUpdateParcelable{, mEntityId=" + ((int) b4) + ", mAttributeId=" + ((int) b5) + ", mValue='" + str + "'}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByte(parcel, 2, this.f22800a);
        SafeParcelWriter.writeByte(parcel, 3, this.f22801b);
        SafeParcelWriter.writeString(parcel, 4, this.f22802c, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
