package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "BleFilterCreator")
/* loaded from: classes4.dex */
public final class zznf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zznf> CREATOR = new zzng();
    @SafeParcelable.VersionField(getter = "getVersionCode", id = 1)
    private final int zza;
    @Nullable
    @SafeParcelable.Field(getter = "getServiceUuid", id = 4)
    private final ParcelUuid zzb;
    @Nullable
    @SafeParcelable.Field(getter = "getServiceUuidMask", id = 5)
    private final ParcelUuid zzc;
    @Nullable
    @SafeParcelable.Field(getter = "getServiceDataUuid", id = 6)
    private final ParcelUuid zzd;
    @Nullable
    @SafeParcelable.Field(getter = "getServiceData", id = 7)
    private final byte[] zze;
    @Nullable
    @SafeParcelable.Field(getter = "getServiceDataMask", id = 8)
    private final byte[] zzf;
    @SafeParcelable.Field(getter = "getManufacturerId", id = 9)
    private final int zzg;
    @Nullable
    @SafeParcelable.Field(getter = "getManufacturerData", id = 10)
    private final byte[] zzh;
    @Nullable
    @SafeParcelable.Field(getter = "getManufacturerDataMask", id = 11)
    private final byte[] zzi;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zznf(@SafeParcelable.Param(id = 1) int i4, @Nullable @SafeParcelable.Param(id = 4) ParcelUuid parcelUuid, @Nullable @SafeParcelable.Param(id = 5) ParcelUuid parcelUuid2, @Nullable @SafeParcelable.Param(id = 6) ParcelUuid parcelUuid3, @Nullable @SafeParcelable.Param(id = 7) byte[] bArr, @Nullable @SafeParcelable.Param(id = 8) byte[] bArr2, @SafeParcelable.Param(id = 9) int i5, @Nullable @SafeParcelable.Param(id = 10) byte[] bArr3, @Nullable @SafeParcelable.Param(id = 11) byte[] bArr4) {
        this.zza = i4;
        this.zzb = parcelUuid;
        this.zzc = parcelUuid2;
        this.zzd = parcelUuid3;
        this.zze = bArr;
        this.zzf = bArr2;
        this.zzg = i5;
        this.zzh = bArr3;
        this.zzi = bArr4;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zznf.class == obj.getClass()) {
            zznf zznfVar = (zznf) obj;
            if (this.zzg == zznfVar.zzg && Arrays.equals(this.zzh, zznfVar.zzh) && Arrays.equals(this.zzi, zznfVar.zzi) && Objects.equal(this.zzd, zznfVar.zzd) && Arrays.equals(this.zze, zznfVar.zze) && Arrays.equals(this.zzf, zznfVar.zzf) && Objects.equal(this.zzb, zznfVar.zzb) && Objects.equal(this.zzc, zznfVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zzg), Integer.valueOf(Arrays.hashCode(this.zzh)), Integer.valueOf(Arrays.hashCode(this.zzi)), this.zzd, Integer.valueOf(Arrays.hashCode(this.zze)), Integer.valueOf(Arrays.hashCode(this.zzf)), this.zzb, this.zzc);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzb, i4, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzc, i4, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzd, i4, false);
        SafeParcelWriter.writeByteArray(parcel, 7, this.zze, false);
        SafeParcelWriter.writeByteArray(parcel, 8, this.zzf, false);
        SafeParcelWriter.writeInt(parcel, 9, this.zzg);
        SafeParcelWriter.writeByteArray(parcel, 10, this.zzh, false);
        SafeParcelWriter.writeByteArray(parcel, 11, this.zzi, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
