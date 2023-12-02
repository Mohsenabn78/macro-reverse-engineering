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
@SafeParcelable.Class(creator = "OnConnectionInitiatedParamsCreator")
/* loaded from: classes4.dex */
public final class zzkt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzkt> CREATOR = new zzku();
    @SafeParcelable.Field(getter = "getRemoteEndpointId", id = 1)
    private String zza;
    @SafeParcelable.Field(getter = "getRemoteEndpointName", id = 2)
    private String zzb;
    @SafeParcelable.Field(getter = "getAuthenticationToken", id = 3)
    private String zzc;
    @SafeParcelable.Field(getter = "getIsIncomingConnection", id = 4)
    private boolean zzd;
    @Nullable
    @SafeParcelable.Field(getter = "getHandshakeData", id = 5)
    private byte[] zze;
    @SafeParcelable.Field(getter = "getRawAuthenticationToken", id = 6)
    private byte[] zzf;
    @SafeParcelable.Field(getter = "getRemoteEndpointInfo", id = 7)
    private byte[] zzg;
    @SafeParcelable.Field(getter = "getIsConnectionVerified", id = 8)
    private boolean zzh;
    @SafeParcelable.Field(defaultValue = "0", getter = "getDeviceType", id = 9)
    private final int zzi;
    @Nullable
    @SafeParcelable.Field(getter = "getPresenceDevice", id = 10)
    private com.google.android.gms.nearby.presence.zzi zzj;
    @Nullable
    @SafeParcelable.Field(getter = "getConnectionsDevice", id = 11)
    private com.google.android.gms.nearby.connection.zzo zzk;
    @SafeParcelable.Field(defaultValue = "0", getter = "getAuthenticationResult", id = 12)
    private final int zzl;

    private zzkt() {
        this.zzi = 0;
        this.zzl = 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzkt) {
            zzkt zzktVar = (zzkt) obj;
            if (Objects.equal(this.zza, zzktVar.zza) && Objects.equal(this.zzb, zzktVar.zzb) && Objects.equal(this.zzc, zzktVar.zzc) && Objects.equal(Boolean.valueOf(this.zzd), Boolean.valueOf(zzktVar.zzd)) && Arrays.equals(this.zze, zzktVar.zze) && Arrays.equals(this.zzf, zzktVar.zzf) && Arrays.equals(this.zzg, zzktVar.zzg) && Objects.equal(Boolean.valueOf(this.zzh), Boolean.valueOf(zzktVar.zzh)) && Objects.equal(Integer.valueOf(this.zzi), Integer.valueOf(zzktVar.zzi)) && Objects.equal(this.zzj, zzktVar.zzj) && Objects.equal(this.zzk, zzktVar.zzk) && Objects.equal(Integer.valueOf(this.zzl), Integer.valueOf(zzktVar.zzl))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc, Boolean.valueOf(this.zzd), Integer.valueOf(Arrays.hashCode(this.zze)), Integer.valueOf(Arrays.hashCode(this.zzf)), Integer.valueOf(Arrays.hashCode(this.zzg)), Boolean.valueOf(this.zzh), Integer.valueOf(this.zzi), this.zzj, this.zzk, Integer.valueOf(this.zzl));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeByteArray(parcel, 5, this.zze, false);
        SafeParcelWriter.writeByteArray(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeByteArray(parcel, 7, this.zzg, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzh);
        SafeParcelWriter.writeInt(parcel, 9, this.zzi);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzj, i4, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzk, i4, false);
        SafeParcelWriter.writeInt(parcel, 12, this.zzl);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zza() {
        return this.zzl;
    }

    public final String zzb() {
        return this.zzc;
    }

    public final String zzc() {
        return this.zza;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final boolean zze() {
        return this.zzh;
    }

    public final boolean zzf() {
        return this.zzd;
    }

    public final byte[] zzg() {
        return this.zzf;
    }

    public final byte[] zzh() {
        return this.zzg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzkt(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String str2, @SafeParcelable.Param(id = 3) String str3, @SafeParcelable.Param(id = 4) boolean z3, @Nullable @SafeParcelable.Param(id = 5) byte[] bArr, @SafeParcelable.Param(id = 6) byte[] bArr2, @SafeParcelable.Param(id = 7) byte[] bArr3, @SafeParcelable.Param(id = 8) boolean z4, @SafeParcelable.Param(id = 9) int i4, @Nullable @SafeParcelable.Param(id = 10) com.google.android.gms.nearby.presence.zzi zziVar, @Nullable @SafeParcelable.Param(id = 11) com.google.android.gms.nearby.connection.zzo zzoVar, @SafeParcelable.Param(id = 12) int i5) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = z3;
        this.zze = bArr;
        this.zzf = bArr2;
        this.zzg = bArr3;
        this.zzh = z4;
        this.zzi = i4;
        this.zzj = zziVar;
        this.zzk = zzoVar;
        this.zzl = i5;
    }
}
