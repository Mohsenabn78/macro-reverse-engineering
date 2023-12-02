package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@SafeParcelable.Class(creator = "StringToIntConverterEntryCreator")
/* loaded from: classes4.dex */
public final class zac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zac> CREATOR = new zae();
    @SafeParcelable.VersionField(id = 1)

    /* renamed from: a  reason: collision with root package name */
    final int f20645a;
    @SafeParcelable.Field(id = 2)

    /* renamed from: b  reason: collision with root package name */
    final String f20646b;
    @SafeParcelable.Field(id = 3)

    /* renamed from: c  reason: collision with root package name */
    final int f20647c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zac(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i5) {
        this.f20645a = i4;
        this.f20646b = str;
        this.f20647c = i5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f20645a);
        SafeParcelWriter.writeString(parcel, 2, this.f20646b, false);
        SafeParcelWriter.writeInt(parcel, 3, this.f20647c);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zac(String str, int i4) {
        this.f20645a = 1;
        this.f20646b = str;
        this.f20647c = i4;
    }
}
