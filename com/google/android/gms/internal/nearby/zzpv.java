package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "RangingCapabilitiesParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzpv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzpv> CREATOR = new zzpw();
    @SafeParcelable.Field(getter = "getSupportsDistance", id = 1)
    private boolean zza;
    @SafeParcelable.Field(getter = "getSupportsAzimuthalAngle", id = 2)
    private boolean zzb;
    @SafeParcelable.Field(getter = "getSupportsElevationAngle", id = 3)
    private boolean zzc;
    @SafeParcelable.Field(getter = "getStatusCode", id = 4)
    private int zzd;
    @SafeParcelable.Field(getter = "getMinRangingInterval", id = 5)
    private int zze;
    @SafeParcelable.Field(getter = "getSupportedChannels", id = 6)
    private int[] zzf;
    @SafeParcelable.Field(getter = "getSupportedConfigIds", id = 7)
    private int[] zzg;
    @SafeParcelable.Field(getter = "getMinSlotDuration", id = 8)
    private float zzh;
    @SafeParcelable.Field(getter = "getSupportedNtfConfigs", id = 9)
    private int[] zzi;

    private zzpv() {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzpv) {
            zzpv zzpvVar = (zzpv) obj;
            if (Objects.equal(Boolean.valueOf(this.zza), Boolean.valueOf(zzpvVar.zza)) && Objects.equal(Boolean.valueOf(this.zzb), Boolean.valueOf(zzpvVar.zzb)) && Objects.equal(Boolean.valueOf(this.zzc), Boolean.valueOf(zzpvVar.zzc)) && Objects.equal(Integer.valueOf(this.zzd), Integer.valueOf(zzpvVar.zzd)) && Objects.equal(Integer.valueOf(this.zze), Integer.valueOf(zzpvVar.zze)) && Arrays.equals(this.zzf, zzpvVar.zzf) && Arrays.equals(this.zzg, zzpvVar.zzg) && Objects.equal(Float.valueOf(this.zzh), Float.valueOf(zzpvVar.zzh)) && Arrays.equals(this.zzi, zzpvVar.zzi)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.zza), Boolean.valueOf(this.zzb), Boolean.valueOf(this.zzc), Integer.valueOf(this.zzd), Integer.valueOf(this.zze), Integer.valueOf(Arrays.hashCode(this.zzf)), Integer.valueOf(Arrays.hashCode(this.zzg)), Float.valueOf(this.zzh), Integer.valueOf(Arrays.hashCode(this.zzi)));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, this.zza);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzb);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeIntArray(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeIntArray(parcel, 7, this.zzg, false);
        SafeParcelWriter.writeFloat(parcel, 8, this.zzh);
        SafeParcelWriter.writeIntArray(parcel, 9, this.zzi, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final float zza() {
        return this.zzh;
    }

    public final int zzb() {
        return this.zze;
    }

    public final boolean zzc() {
        return this.zzb;
    }

    public final boolean zzd() {
        return this.zza;
    }

    public final boolean zze() {
        return this.zzc;
    }

    public final int[] zzf() {
        return this.zzf;
    }

    public final int[] zzg() {
        return this.zzg;
    }

    public final int[] zzh() {
        return this.zzi;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzpv(@SafeParcelable.Param(id = 1) boolean z3, @SafeParcelable.Param(id = 2) boolean z4, @SafeParcelable.Param(id = 3) boolean z5, @SafeParcelable.Param(id = 4) int i4, @SafeParcelable.Param(id = 5) int i5, @SafeParcelable.Param(id = 6) int[] iArr, @SafeParcelable.Param(id = 7) int[] iArr2, @SafeParcelable.Param(id = 8) float f4, @SafeParcelable.Param(id = 9) int[] iArr3) {
        this.zza = z3;
        this.zzb = z4;
        this.zzc = z5;
        this.zzd = i4;
        this.zze = i5;
        this.zzf = iArr;
        this.zzg = iArr2;
        this.zzh = f4;
        this.zzi = iArr3;
    }
}
