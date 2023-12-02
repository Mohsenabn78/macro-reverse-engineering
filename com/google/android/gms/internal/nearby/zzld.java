package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "OnEndpointDistanceChangedParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzld extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzld> CREATOR = new zzle();
    @SafeParcelable.Field(getter = "getEndpointId", id = 1)
    private String zza;
    @SafeParcelable.Field(getter = "getDistance", id = 2)
    private int zzb;
    @Nullable
    @SafeParcelable.Field(getter = "getUwbRangingData", id = 3)
    private com.google.android.gms.nearby.connection.zzz zzc;
    @SafeParcelable.Field(defaultValue = "0", getter = "getDeviceType", id = 4)
    private final int zzd;
    @Nullable
    @SafeParcelable.Field(getter = "getConnectionsDevice", id = 5)
    private com.google.android.gms.nearby.connection.zzo zze;

    private zzld() {
        this.zzd = 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzld) {
            zzld zzldVar = (zzld) obj;
            if (Objects.equal(this.zza, zzldVar.zza) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzldVar.zzb)) && Objects.equal(this.zzc, zzldVar.zzc) && Objects.equal(Integer.valueOf(this.zzd), Integer.valueOf(zzldVar.zzd)) && Objects.equal(this.zze, zzldVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(this.zzb), this.zzc, Integer.valueOf(this.zzd), this.zze);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i4, false);
        SafeParcelWriter.writeInt(parcel, 4, this.zzd);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zza() {
        return this.zzb;
    }

    @Nullable
    public final com.google.android.gms.nearby.connection.zzz zzb() {
        return this.zzc;
    }

    public final String zzc() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzld(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) int i4, @Nullable @SafeParcelable.Param(id = 3) com.google.android.gms.nearby.connection.zzz zzzVar, @SafeParcelable.Param(id = 4) int i5, @Nullable @SafeParcelable.Param(id = 5) com.google.android.gms.nearby.connection.zzo zzoVar) {
        this.zza = str;
        this.zzb = i4;
        this.zzc = zzzVar;
        this.zzd = i5;
        this.zze = zzoVar;
    }
}
