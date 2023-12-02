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
@SafeParcelable.Class(creator = "RangingParametersParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzqb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzqb> CREATOR = new zzqc();
    @SafeParcelable.Field(getter = "getUwbConfigId", id = 1)
    private int zza;
    @SafeParcelable.Field(getter = "getSessionId", id = 2)
    private int zzb;
    @SafeParcelable.Field(getter = "getSessionKeyInfo", id = 3)
    private byte[] zzc;
    @SafeParcelable.Field(getter = "getComplexChannel", id = 4)
    private zzqy zzd;
    @SafeParcelable.Field(getter = "getRangingUpdateRate", id = 5)
    private int zze;
    @SafeParcelable.Field(getter = "getPeerDevices", id = 6)
    private zzry[] zzf;
    @SafeParcelable.Field(getter = "getSubSessionId", id = 7)
    private int zzg;
    @SafeParcelable.Field(getter = "getSubSessionKeyInfo", id = 8)
    private byte[] zzh;
    @SafeParcelable.Field(getter = "getLocalDevice", id = 9)
    private zzry zzi;
    @SafeParcelable.Field(getter = "getRangeDataNtfConfig", id = 10)
    private zzpt zzj;

    private zzqb() {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzqb) {
            zzqb zzqbVar = (zzqb) obj;
            if (Objects.equal(Integer.valueOf(this.zza), Integer.valueOf(zzqbVar.zza)) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzqbVar.zzb)) && Arrays.equals(this.zzc, zzqbVar.zzc) && Objects.equal(this.zzd, zzqbVar.zzd) && Objects.equal(Integer.valueOf(this.zze), Integer.valueOf(zzqbVar.zze)) && Arrays.equals(this.zzf, zzqbVar.zzf) && Objects.equal(Integer.valueOf(this.zzg), Integer.valueOf(zzqbVar.zzg)) && Arrays.equals(this.zzh, zzqbVar.zzh) && Objects.equal(this.zzi, zzqbVar.zzi) && Objects.equal(this.zzj, zzqbVar.zzj)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(Arrays.hashCode(this.zzc)), this.zzd, Integer.valueOf(this.zze), Integer.valueOf(Arrays.hashCode(this.zzf)), Integer.valueOf(this.zzg), Integer.valueOf(Arrays.hashCode(this.zzh)), this.zzi, this.zzj);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i4, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeTypedArray(parcel, 6, this.zzf, i4, false);
        SafeParcelWriter.writeInt(parcel, 7, this.zzg);
        SafeParcelWriter.writeByteArray(parcel, 8, this.zzh, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzi, i4, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzj, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzqb(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) int i5, @SafeParcelable.Param(id = 3) byte[] bArr, @SafeParcelable.Param(id = 4) zzqy zzqyVar, @SafeParcelable.Param(id = 5) int i6, @SafeParcelable.Param(id = 6) zzry[] zzryVarArr, @SafeParcelable.Param(id = 7) int i7, @SafeParcelable.Param(id = 8) byte[] bArr2, @SafeParcelable.Param(id = 9) zzry zzryVar, @SafeParcelable.Param(id = 10) zzpt zzptVar) {
        this.zza = i4;
        this.zzb = i5;
        this.zzc = bArr;
        this.zzd = zzqyVar;
        this.zze = i6;
        this.zzf = zzryVarArr;
        this.zzg = i7;
        this.zzh = bArr2;
        this.zzi = zzryVar;
        this.zzj = zzptVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzqb(zzqa zzqaVar) {
    }
}
