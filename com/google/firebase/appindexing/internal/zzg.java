package com.google.firebase.appindexing.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
@SafeParcelable.Class(creator = "CallStatusCreator")
/* loaded from: classes5.dex */
public final class zzg extends AbstractSafeParcelable {
    @SafeParcelable.Field(id = 1)
    public final int zzd;
    public static final zzg zza = new zzg(1);
    public static final zzg zzb = new zzg(2);
    public static final zzg zzc = new zzg(3);
    public static final Parcelable.Creator<zzg> CREATOR = new zzh();

    @SafeParcelable.Constructor
    public zzg(@SafeParcelable.Param(id = 1) int i4) {
        this.zzd = i4;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
