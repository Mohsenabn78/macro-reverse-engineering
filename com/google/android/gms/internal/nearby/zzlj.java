package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "OnPayloadReceivedParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzlj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzlj> CREATOR = new zzlk();
    @SafeParcelable.Field(getter = "getRemoteEndpointId", id = 1)
    private String zza;
    @SafeParcelable.Field(getter = "getPayload", id = 2)
    private zzmc zzb;
    @SafeParcelable.Field(getter = "getIsReliable", id = 3)
    private boolean zzc;
    @SafeParcelable.Field(defaultValue = "0", getter = "getDeviceType", id = 4)
    private final int zzd;
    @Nullable
    @SafeParcelable.Field(getter = "getPresenceDevice", id = 5)
    private com.google.android.gms.nearby.presence.zzi zze;
    @Nullable
    @SafeParcelable.Field(getter = "getConnectionsDevice", id = 6)
    private com.google.android.gms.nearby.connection.zzo zzf;

    private zzlj() {
        this.zzd = 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzlj) {
            zzlj zzljVar = (zzlj) obj;
            if (Objects.equal(this.zza, zzljVar.zza) && Objects.equal(this.zzb, zzljVar.zzb) && Objects.equal(Boolean.valueOf(this.zzc), Boolean.valueOf(zzljVar.zzc)) && Objects.equal(Integer.valueOf(this.zzd), Integer.valueOf(zzljVar.zzd)) && Objects.equal(this.zze, zzljVar.zze) && Objects.equal(this.zzf, zzljVar.zzf)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Boolean.valueOf(this.zzc), Integer.valueOf(this.zzd), this.zze, this.zzf);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i4, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i4, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzmc zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }

    public final boolean zzc() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzlj(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) zzmc zzmcVar, @SafeParcelable.Param(id = 3) boolean z3, @SafeParcelable.Param(id = 4) int i4, @Nullable @SafeParcelable.Param(id = 5) com.google.android.gms.nearby.presence.zzi zziVar, @Nullable @SafeParcelable.Param(id = 6) com.google.android.gms.nearby.connection.zzo zzoVar) {
        this.zza = str;
        this.zzb = zzmcVar;
        this.zzc = z3;
        this.zzd = i4;
        this.zze = zziVar;
        this.zzf = zzoVar;
    }
}
