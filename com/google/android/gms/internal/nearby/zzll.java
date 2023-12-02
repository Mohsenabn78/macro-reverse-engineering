package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.connection.PayloadTransferUpdate;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "OnPayloadTransferUpdateParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzll extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzll> CREATOR = new zzlm();
    @SafeParcelable.Field(getter = "getRemoteEndpointId", id = 1)
    private String zza;
    @SafeParcelable.Field(getter = "getUpdate", id = 2)
    private PayloadTransferUpdate zzb;
    @SafeParcelable.Field(defaultValue = "0", getter = "getDeviceType", id = 3)
    private final int zzc;
    @Nullable
    @SafeParcelable.Field(getter = "getPresenceDevice", id = 4)
    private com.google.android.gms.nearby.presence.zzi zzd;
    @Nullable
    @SafeParcelable.Field(getter = "getConnectionsDevice", id = 5)
    private com.google.android.gms.nearby.connection.zzo zze;

    private zzll() {
        this.zzc = 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzll) {
            zzll zzllVar = (zzll) obj;
            if (Objects.equal(this.zza, zzllVar.zza) && Objects.equal(this.zzb, zzllVar.zzb) && Objects.equal(Integer.valueOf(this.zzc), Integer.valueOf(zzllVar.zzc)) && Objects.equal(this.zzd, zzllVar.zzd) && Objects.equal(this.zze, zzllVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, Integer.valueOf(this.zzc), this.zzd, this.zze);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i4, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i4, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final PayloadTransferUpdate zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzll(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) PayloadTransferUpdate payloadTransferUpdate, @SafeParcelable.Param(id = 3) int i4, @Nullable @SafeParcelable.Param(id = 4) com.google.android.gms.nearby.presence.zzi zziVar, @Nullable @SafeParcelable.Param(id = 5) com.google.android.gms.nearby.connection.zzo zzoVar) {
        this.zza = str;
        this.zzb = payloadTransferUpdate;
        this.zzc = i4;
        this.zzd = zziVar;
        this.zze = zzoVar;
    }
}
