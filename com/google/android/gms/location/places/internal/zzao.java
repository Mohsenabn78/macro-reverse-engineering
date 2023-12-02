package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "BusinessHoursIntervalCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzao extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzao> CREATOR = new zzg();
    @SafeParcelable.Field(id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final int f21106a;
    @SafeParcelable.Field(id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final int f21107b;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzao(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) int i5) {
        this.f21106a = i4;
        this.f21107b = i5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f21106a);
        SafeParcelWriter.writeInt(parcel, 2, this.f21107b);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
