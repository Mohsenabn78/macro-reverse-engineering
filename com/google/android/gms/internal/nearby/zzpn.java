package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "OnRangingResultParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzpn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzpn> CREATOR = new zzpo();
    @SafeParcelable.Field(getter = "getDevice", id = 1)
    private zzry zza;
    @SafeParcelable.Field(getter = "getPosition", id = 2)
    private zzqd zzb;

    private zzpn() {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzpn) {
            zzpn zzpnVar = (zzpn) obj;
            if (Objects.equal(this.zza, zzpnVar.zza) && Objects.equal(this.zzb, zzpnVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i4, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzqd zza() {
        return this.zzb;
    }

    public final zzry zzb() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzpn(@SafeParcelable.Param(id = 1) zzry zzryVar, @SafeParcelable.Param(id = 2) zzqd zzqdVar) {
        this.zza = zzryVar;
        this.zzb = zzqdVar;
    }
}
