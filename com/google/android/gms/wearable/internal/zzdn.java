package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
@SafeParcelable.Class(creator = "GetAllCapabilitiesResponseCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class zzdn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdn> CREATOR = new zzdo();
    @SafeParcelable.Field(id = 2)
    public final int zza;
    @VisibleForTesting
    @SafeParcelable.Field(id = 3)
    public final List zzb;

    @SafeParcelable.Constructor
    public zzdn(@SafeParcelable.Param(id = 2) int i4, @SafeParcelable.Param(id = 3) List list) {
        this.zza = i4;
        this.zzb = list;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zza);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
