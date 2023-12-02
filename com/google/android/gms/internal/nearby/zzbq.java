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
@SafeParcelable.Class(creator = "GetExposureSummaryParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzbq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbq> CREATOR = new zzbr();
    @SafeParcelable.Field(getter = "getExposureSummaryCallbackAsBinder", id = 2, type = "android.os.IBinder")
    private zzdf zza;
    @SafeParcelable.Field(getter = "getToken", id = 3)
    private String zzb;
    @Nullable
    @SafeParcelable.Field(getter = "getExposureSummaryResultListenerAsBinder", id = 1, type = "android.os.IBinder")
    private zzdg zzc;

    private zzbq() {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzbq) {
            zzbq zzbqVar = (zzbq) obj;
            if (Objects.equal(this.zzc, zzbqVar.zzc) && Objects.equal(this.zza, zzbqVar.zza) && Objects.equal(this.zzb, zzbqVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzc, this.zza, this.zzb);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        IBinder asBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzdg zzdgVar = this.zzc;
        if (zzdgVar == null) {
            asBinder = null;
        } else {
            asBinder = zzdgVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 1, asBinder, false);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zza.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzbq(@Nullable @SafeParcelable.Param(id = 1) IBinder iBinder, @SafeParcelable.Param(id = 2) IBinder iBinder2, @SafeParcelable.Param(id = 3) String str) {
        zzdg zzdgVar;
        zzdf zzdfVar = null;
        if (iBinder == null) {
            zzdgVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IExposureSummaryResultListener");
            zzdgVar = queryLocalInterface instanceof zzdg ? (zzdg) queryLocalInterface : new zzdg(iBinder);
        }
        if (iBinder2 != null) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IExposureSummaryCallback");
            zzdfVar = queryLocalInterface2 instanceof zzdf ? (zzdf) queryLocalInterface2 : new zzdd(iBinder2);
        }
        this.zzc = zzdgVar;
        this.zza = zzdfVar;
        this.zzb = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbq(zzbp zzbpVar) {
    }
}
