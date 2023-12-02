package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@ShowFirstParty
@SafeParcelable.Class(creator = "UwbRangingDataCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzz> CREATOR = new zzaa();
    @SafeParcelable.Field(getter = "getRawDistance", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private int f22257a;
    @SafeParcelable.Field(getter = "getRawAngleOfArrivalAzimuth", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private int f22258b;
    @SafeParcelable.Field(getter = "getRawAngleOfArrivalPolar", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private int f22259c;
    @SafeParcelable.Field(getter = "getIsValidAngleOfArrivalData", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private boolean f22260d;

    private zzz() {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzz) {
            zzz zzzVar = (zzz) obj;
            if (Objects.equal(Integer.valueOf(this.f22257a), Integer.valueOf(zzzVar.f22257a)) && Objects.equal(Integer.valueOf(this.f22258b), Integer.valueOf(zzzVar.f22258b)) && Objects.equal(Integer.valueOf(this.f22259c), Integer.valueOf(zzzVar.f22259c)) && Objects.equal(Boolean.valueOf(this.f22260d), Boolean.valueOf(zzzVar.f22260d))) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f22257a), Integer.valueOf(this.f22258b), Integer.valueOf(this.f22259c), Boolean.valueOf(this.f22260d));
    }

    public final String toString() {
        int i4 = this.f22257a;
        int i5 = this.f22258b;
        int i6 = this.f22259c;
        boolean z3 = this.f22260d;
        return "UwbRangingData{rawDistance=" + i4 + ", rawAngleOfArrivalAzimuth=" + i5 + ", rawAngleOfArrivalPolar=" + i6 + ", isValidAngleOfArrivalData=" + z3 + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f22257a);
        SafeParcelWriter.writeInt(parcel, 2, this.f22258b);
        SafeParcelWriter.writeInt(parcel, 3, this.f22259c);
        SafeParcelWriter.writeBoolean(parcel, 4, this.f22260d);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzz(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) int i5, @SafeParcelable.Param(id = 3) int i6, @SafeParcelable.Param(id = 4) boolean z3) {
        this.f22257a = i4;
        this.f22258b = i5;
        this.f22259c = i6;
        this.f22260d = z3;
    }
}
