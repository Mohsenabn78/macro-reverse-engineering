package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "OnRangingSuspendedParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzpp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzpp> CREATOR = new zzpq();
    @SafeParcelable.Field(getter = "getDevice", id = 1)
    private zzry zza;
    @SafeParcelable.Field(getter = "getReason", id = 2)
    private int zzb;

    private zzpp() {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzpp) {
            zzpp zzppVar = (zzpp) obj;
            if (Objects.equal(this.zza, zzppVar.zza) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzppVar.zzb))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(this.zzb));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i4, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzry zzb() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzpp(@SafeParcelable.Param(id = 1) zzry zzryVar, @SafeParcelable.Param(id = 2) int i4) {
        this.zza = zzryVar;
        this.zzb = i4;
    }
}
