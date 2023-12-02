package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "OnDisconnectedParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzlb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzlb> CREATOR = new zzlc();
    @SafeParcelable.Field(getter = "getRemoteEndpointId", id = 1)
    private String zza;
    @SafeParcelable.Field(defaultValue = "0", getter = "getDeviceType", id = 2)
    private final int zzb;
    @Nullable
    @SafeParcelable.Field(getter = "getPresenceDevice", id = 3)
    private com.google.android.gms.nearby.presence.zzi zzc;
    @Nullable
    @SafeParcelable.Field(getter = "getConnectionsDevice", id = 4)
    private com.google.android.gms.nearby.connection.zzo zzd;

    private zzlb() {
        this.zzb = 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzlb) {
            zzlb zzlbVar = (zzlb) obj;
            if (Objects.equal(this.zza, zzlbVar.zza) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzlbVar.zzb)) && Objects.equal(this.zzc, zzlbVar.zzc) && Objects.equal(this.zzd, zzlbVar.zzd)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(this.zzb), this.zzc, this.zzd);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i4, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zza() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzlb(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) int i4, @Nullable @SafeParcelable.Param(id = 3) com.google.android.gms.nearby.presence.zzi zziVar, @Nullable @SafeParcelable.Param(id = 4) com.google.android.gms.nearby.connection.zzo zzoVar) {
        this.zza = str;
        this.zzb = i4;
        this.zzc = zziVar;
        this.zzd = zzoVar;
    }
}
