package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "OnBandwidthChangedParamsCreator")
/* loaded from: classes4.dex */
public final class zzkr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzkr> CREATOR = new zzks();
    @SafeParcelable.Field(getter = "getRemoteEndpointId", id = 1)
    private String zza;
    @SafeParcelable.Field(getter = "getQuality", id = 2)
    private int zzb;
    @SafeParcelable.Field(defaultValue = "0", getter = "getMedium", id = 3)
    private final int zzc;
    @SafeParcelable.Field(defaultValue = "0", getter = "getDeviceType", id = 4)
    private final int zzd;
    @Nullable
    @SafeParcelable.Field(getter = "getPresenceDevice", id = 5)
    private com.google.android.gms.nearby.presence.zzi zze;
    @Nullable
    @SafeParcelable.Field(getter = "getConnectionsDevice", id = 6)
    private com.google.android.gms.nearby.connection.zzo zzf;

    private zzkr() {
        this.zzc = 0;
        this.zzd = 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzkr) {
            zzkr zzkrVar = (zzkr) obj;
            if (Objects.equal(this.zza, zzkrVar.zza) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzkrVar.zzb)) && Objects.equal(Integer.valueOf(this.zzc), Integer.valueOf(zzkrVar.zzc)) && Objects.equal(Integer.valueOf(this.zzd), Integer.valueOf(zzkrVar.zzd)) && Objects.equal(this.zze, zzkrVar.zze) && Objects.equal(this.zzf, zzkrVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(this.zzb), Integer.valueOf(this.zzc), Integer.valueOf(this.zzd), this.zze, this.zzf);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i4, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zza() {
        return this.zzc;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final String zzc() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzkr(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) int i4, @SafeParcelable.Param(id = 3) int i5, @SafeParcelable.Param(id = 4) int i6, @Nullable @SafeParcelable.Param(id = 5) com.google.android.gms.nearby.presence.zzi zziVar, @Nullable @SafeParcelable.Param(id = 6) com.google.android.gms.nearby.connection.zzo zzoVar) {
        this.zza = str;
        this.zzb = i4;
        this.zzc = i5;
        this.zzd = i6;
        this.zze = zziVar;
        this.zzf = zzoVar;
    }
}
