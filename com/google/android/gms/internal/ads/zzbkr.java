package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
@ParametersAreNonnullByDefault
@SafeParcelable.Class(creator = "InstreamAdConfigurationParcelCreator")
/* loaded from: classes4.dex */
public final class zzbkr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbkr> CREATOR = new zzbks();
    @SafeParcelable.VersionField(id = 1000)
    public final int zza;
    @SafeParcelable.Field(id = 1)
    public final int zzb;
    @SafeParcelable.Field(id = 2)
    public final String zzc;
    @SafeParcelable.Field(id = 3)
    public final int zzd;

    @SafeParcelable.Constructor
    public zzbkr(@SafeParcelable.Param(id = 1000) int i4, @SafeParcelable.Param(id = 1) int i5, @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) int i6) {
        this.zza = i4;
        this.zzb = i5;
        this.zzc = str;
        this.zzd = i6;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzb);
        SafeParcelWriter.writeString(parcel, 2, this.zzc, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzd);
        SafeParcelWriter.writeInt(parcel, 1000, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
