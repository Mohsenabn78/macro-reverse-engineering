package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "OnEndpointLostParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzlh extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzlh> CREATOR = new zzli();
    @SafeParcelable.Field(getter = "getEndpointId", id = 1)
    private String zza;
    @SafeParcelable.Field(defaultValue = "0", getter = "getDeviceType", id = 2)
    private final int zzb;
    @Nullable
    @SafeParcelable.Field(getter = "getConnectionsDevice", id = 3)
    private com.google.android.gms.nearby.connection.zzo zzc;

    private zzlh() {
        this.zzb = 0;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzlh) {
            zzlh zzlhVar = (zzlh) obj;
            if (Objects.equal(this.zza, zzlhVar.zza) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzlhVar.zzb)) && Objects.equal(this.zzc, zzlhVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(this.zzb), this.zzc);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final String zza() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzlh(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) int i4, @Nullable @SafeParcelable.Param(id = 3) com.google.android.gms.nearby.connection.zzo zzoVar) {
        this.zza = str;
        this.zzb = i4;
        this.zzc = zzoVar;
    }
}
