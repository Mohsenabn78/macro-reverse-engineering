package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SubstringEntityCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzb> CREATOR = new zzav();
    @SafeParcelable.Field(id = 1)

    /* renamed from: a  reason: collision with root package name */
    final int f21123a;
    @SafeParcelable.Field(id = 2)

    /* renamed from: b  reason: collision with root package name */
    final int f21124b;

    @SafeParcelable.Constructor
    public zzb(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) int i5) {
        this.f21123a = i4;
        this.f21124b = i5;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzb)) {
            return false;
        }
        zzb zzbVar = (zzb) obj;
        if (Objects.equal(Integer.valueOf(this.f21123a), Integer.valueOf(zzbVar.f21123a)) && Objects.equal(Integer.valueOf(this.f21124b), Integer.valueOf(zzbVar.f21124b))) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f21123a), Integer.valueOf(this.f21124b));
    }

    public final String toString() {
        return Objects.toStringHelper(this).add(TypedValues.CycleType.S_WAVE_OFFSET, Integer.valueOf(this.f21123a)).add("length", Integer.valueOf(this.f21124b)).toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f21123a);
        SafeParcelWriter.writeInt(parcel, 2, this.f21124b);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
