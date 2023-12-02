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
@SafeParcelable.Class(creator = "GetStatusParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzcc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcc> CREATOR = new zzcd();
    @SafeParcelable.Field(getter = "getLongCallbackAsBinder", id = 1, type = "android.os.IBinder")
    private zzdp zza;

    private zzcc() {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzcc) {
            return Objects.equal(this.zza, ((zzcc) obj).zza);
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
    public zzcc(@SafeParcelable.Param(id = 1) IBinder iBinder) {
        zzdp zzdnVar;
        if (iBinder == null) {
            zzdnVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.ILongCallback");
            zzdnVar = queryLocalInterface instanceof zzdp ? (zzdp) queryLocalInterface : new zzdn(iBinder);
        }
        this.zza = zzdnVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzcc(zzcb zzcbVar) {
    }
}
