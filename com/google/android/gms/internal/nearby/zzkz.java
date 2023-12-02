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
@SafeParcelable.Class(creator = "OnConnectionResultParamsCreator")
/* loaded from: classes4.dex */
public final class zzkz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzkz> CREATOR = new zzla();
    @SafeParcelable.Field(getter = "getRemoteEndpointId", id = 1)
    private String zza;
    @SafeParcelable.Field(getter = "getStatusCode", id = 2)
    private int zzb;
    @Nullable
    @SafeParcelable.Field(getter = "getHandshakeData", id = 3)
    private byte[] zzc;
    @SafeParcelable.Field(defaultValue = "0", getter = "getDeviceType", id = 4)
    private final int zzd;
    @Nullable
    @SafeParcelable.Field(getter = "getPresenceDevice", id = 5)
    private com.google.android.gms.nearby.presence.zzi zze;
    @Nullable
    @SafeParcelable.Field(getter = "getConnectionsDevice", id = 6)
    private com.google.android.gms.nearby.connection.zzo zzf;

    private zzkz() {
        this.zzd = 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzkz) {
            zzkz zzkzVar = (zzkz) obj;
            if (Objects.equal(this.zza, zzkzVar.zza) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzkzVar.zzb)) && Arrays.equals(this.zzc, zzkzVar.zzc) && Objects.equal(Integer.valueOf(this.zzd), Integer.valueOf(zzkzVar.zzd)) && Objects.equal(this.zze, zzkzVar.zze) && Objects.equal(this.zzf, zzkzVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(this.zzb), Integer.valueOf(Arrays.hashCode(this.zzc)), Integer.valueOf(this.zzd), this.zze, this.zzf);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeByteArray(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i4, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzkz(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) int i4, @Nullable @SafeParcelable.Param(id = 3) byte[] bArr, @SafeParcelable.Param(id = 4) int i5, @Nullable @SafeParcelable.Param(id = 5) com.google.android.gms.nearby.presence.zzi zziVar, @Nullable @SafeParcelable.Param(id = 6) com.google.android.gms.nearby.connection.zzo zzoVar) {
        this.zza = str;
        this.zzb = i4;
        this.zzc = bArr;
        this.zzd = i5;
        this.zze = zziVar;
        this.zzf = zzoVar;
    }
}
