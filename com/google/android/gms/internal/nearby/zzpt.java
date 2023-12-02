package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "RangeDataNtfConfigParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzpt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzpt> CREATOR = new zzpu();
    @SafeParcelable.Field(getter = "getRangeDataNtfConfigType", id = 1)
    private int zza;
    @SafeParcelable.Field(getter = "getNtfProximityNearInCm", id = 2)
    private int zzb;
    @SafeParcelable.Field(getter = "getNtfProximityFarInCm", id = 3)
    private int zzc;

    private zzpt() {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzpt) {
            zzpt zzptVar = (zzpt) obj;
            if (Objects.equal(Integer.valueOf(this.zza), Integer.valueOf(zzptVar.zza)) && Objects.equal(Integer.valueOf(this.zzb), Integer.valueOf(zzptVar.zzb)) && Objects.equal(Integer.valueOf(this.zzc), Integer.valueOf(zzptVar.zzc))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Integer.valueOf(this.zzb), Integer.valueOf(this.zzc));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzpt(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) int i5, @SafeParcelable.Param(id = 3) int i6) {
        this.zza = i4;
        this.zzb = i5;
        this.zzc = i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzpt(zzps zzpsVar) {
    }
}
