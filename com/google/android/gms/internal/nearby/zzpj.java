package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "IsAvailableParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzpj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzpj> CREATOR = new zzpk();
    @SafeParcelable.Field(getter = "getBooleanResultListenerAsBinder", id = 1, type = "android.os.IBinder")
    private zzoq zza;

    private zzpj() {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzpj) {
            return Objects.equal(this.zza, ((zzpj) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 1, this.zza.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzpj(@SafeParcelable.Param(id = 1) IBinder iBinder) {
        zzoq zzooVar;
        if (iBinder == null) {
            zzooVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.uwb.internal.IBooleanResultListener");
            zzooVar = queryLocalInterface instanceof zzoq ? (zzoq) queryLocalInterface : new zzoo(iBinder);
        }
        this.zza = zzooVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzpj(zzpi zzpiVar) {
    }
}
