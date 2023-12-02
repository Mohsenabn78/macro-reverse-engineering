package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.BleSignal;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "BleSignalImplCreator")
/* loaded from: classes4.dex */
public final class zza extends AbstractSafeParcelable implements BleSignal {
    public static final Parcelable.Creator<zza> CREATOR = new zzb();
    @SafeParcelable.VersionField(id = 1)

    /* renamed from: a  reason: collision with root package name */
    final int f22418a;
    @SafeParcelable.Field(id = 2)

    /* renamed from: b  reason: collision with root package name */
    final int f22419b;
    @SafeParcelable.Field(id = 3)

    /* renamed from: c  reason: collision with root package name */
    final int f22420c;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zza(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) int i5, @SafeParcelable.Param(id = 3) int i6) {
        this.f22418a = i4;
        this.f22419b = i5;
        this.f22420c = (i6 <= -169 || i6 >= 87) ? Integer.MIN_VALUE : Integer.MIN_VALUE;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleSignal)) {
            return false;
        }
        BleSignal bleSignal = (BleSignal) obj;
        if (this.f22419b != bleSignal.getRssi() || this.f22420c != bleSignal.getTxPower()) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.nearby.messages.BleSignal
    public final int getRssi() {
        return this.f22419b;
    }

    @Override // com.google.android.gms.nearby.messages.BleSignal
    public final int getTxPower() {
        return this.f22420c;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f22419b), Integer.valueOf(this.f22420c));
    }

    public final String toString() {
        int i4 = this.f22419b;
        int i5 = this.f22420c;
        return "BleSignal{rssi=" + i4 + ", txPower=" + i5 + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f22418a);
        SafeParcelWriter.writeInt(parcel, 2, this.f22419b);
        SafeParcelWriter.writeInt(parcel, 3, this.f22420c);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
