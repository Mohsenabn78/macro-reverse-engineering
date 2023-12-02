package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "RangingMeasurementParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzpx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzpx> CREATOR = new zzpy();
    @SafeParcelable.Field(getter = "getConfidence", id = 1)
    private int zza;
    @SafeParcelable.Field(getter = "getValue", id = 2)
    private float zzb;

    private zzpx() {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzpx) {
            zzpx zzpxVar = (zzpx) obj;
            if (Objects.equal(Integer.valueOf(this.zza), Integer.valueOf(zzpxVar.zza)) && Objects.equal(Float.valueOf(this.zzb), Float.valueOf(zzpxVar.zzb))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Float.valueOf(this.zzb));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeFloat(parcel, 2, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final float zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzpx(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) float f4) {
        this.zza = i4;
        this.zzb = f4;
    }
}
