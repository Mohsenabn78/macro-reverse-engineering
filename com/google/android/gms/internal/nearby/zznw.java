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
@SafeParcelable.Class(creator = "AddControleeParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zznw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zznw> CREATOR = new zznx();
    @Nullable
    @SafeParcelable.Field(getter = "getResultListenerAsBinder", id = 1, type = "android.os.IBinder")
    private zzpa zza;
    @SafeParcelable.Field(getter = "getAddress", id = 2)
    private zzqt zzb;

    private zznw() {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zznw) {
            zznw zznwVar = (zznw) obj;
            if (Objects.equal(this.zza, zznwVar.zza) && Objects.equal(this.zzb, zznwVar.zzb)) {
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
        IBinder asBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzpa zzpaVar = this.zza;
        if (zzpaVar == null) {
            asBinder = null;
        } else {
            asBinder = zzpaVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 1, asBinder, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zznw(@SafeParcelable.Param(id = 1) IBinder iBinder, @SafeParcelable.Param(id = 2) zzqt zzqtVar) {
        zzpa zzoyVar;
        if (iBinder == null) {
            zzoyVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.uwb.internal.IResultListener");
            zzoyVar = queryLocalInterface instanceof zzpa ? (zzpa) queryLocalInterface : new zzoy(iBinder);
        }
        this.zza = zzoyVar;
        this.zzb = zzqtVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zznw(zznv zznvVar) {
    }
}
