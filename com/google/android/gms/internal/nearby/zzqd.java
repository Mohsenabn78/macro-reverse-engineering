package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.uwb.RangingPosition;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "RangingPositionParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzqd extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzqd> CREATOR = new zzqe();
    @SafeParcelable.Field(getter = "getDistance", id = 1)
    private zzpx zza;
    @SafeParcelable.Field(getter = "getAzimuth", id = 2)
    private zzpx zzb;
    @SafeParcelable.Field(getter = "getElevation", id = 3)
    private zzpx zzc;
    @SafeParcelable.Field(getter = "getElapsedRealtimeNanos", id = 4)
    private long zzd;
    @SafeParcelable.Field(defaultValue = "-128", getter = "getRssi", id = 5)
    private final int zze;
    @Nullable
    @SafeParcelable.Field(getter = "getDlTdoaMeasurement", id = 6)
    private zzoa zzf;

    private zzqd() {
        this.zze = RangingPosition.RSSI_UNKNOWN;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzqd) {
            zzqd zzqdVar = (zzqd) obj;
            if (Objects.equal(this.zza, zzqdVar.zza) && Objects.equal(this.zzb, zzqdVar.zzb) && Objects.equal(this.zzc, zzqdVar.zzc) && Objects.equal(Long.valueOf(this.zzd), Long.valueOf(zzqdVar.zzd)) && Objects.equal(Integer.valueOf(this.zze), Integer.valueOf(zzqdVar.zze)) && Objects.equal(this.zzf, zzqdVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, Long.valueOf(this.zzd), Integer.valueOf(this.zze), this.zzf);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i4, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i4, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i4, false);
        SafeParcelWriter.writeLong(parcel, 4, this.zzd);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zza() {
        return this.zze;
    }

    public final long zzb() {
        return this.zzd;
    }

    public final zzpx zzc() {
        return this.zzb;
    }

    public final zzpx zzd() {
        return this.zza;
    }

    public final zzpx zze() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzqd(@SafeParcelable.Param(id = 1) zzpx zzpxVar, @SafeParcelable.Param(id = 2) zzpx zzpxVar2, @SafeParcelable.Param(id = 3) zzpx zzpxVar3, @SafeParcelable.Param(id = 4) long j4, @SafeParcelable.Param(id = 5) int i4, @Nullable @SafeParcelable.Param(id = 6) zzoa zzoaVar) {
        this.zza = zzpxVar;
        this.zzb = zzpxVar2;
        this.zzc = zzpxVar3;
        this.zzd = j4;
        this.zze = i4;
        this.zzf = zzoaVar;
    }
}
