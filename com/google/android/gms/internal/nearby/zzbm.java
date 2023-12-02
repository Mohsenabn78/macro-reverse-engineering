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
@SafeParcelable.Class(creator = "GetExposureInformationParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzbm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbm> CREATOR = new zzbn();
    @SafeParcelable.Field(getter = "getExposureInformationListCallbackAsBinder", id = 2, type = "android.os.IBinder")
    private zzdb zza;
    @SafeParcelable.Field(getter = "getToken", id = 3)
    private String zzb;
    @Nullable
    @SafeParcelable.Field(getter = "getExposureInformationResultListenerAsBinder", id = 1, type = "android.os.IBinder")
    private zzdc zzc;

    private zzbm() {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzbm) {
            zzbm zzbmVar = (zzbm) obj;
            if (Objects.equal(this.zzc, zzbmVar.zzc) && Objects.equal(this.zza, zzbmVar.zza) && Objects.equal(this.zzb, zzbmVar.zzb)) {
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
        zzdc zzdcVar = this.zzc;
        if (zzdcVar == null) {
            asBinder = null;
        } else {
            asBinder = zzdcVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 1, asBinder, false);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zza.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzbm(@Nullable @SafeParcelable.Param(id = 1) IBinder iBinder, @SafeParcelable.Param(id = 2) IBinder iBinder2, @SafeParcelable.Param(id = 3) String str) {
        zzdc zzdcVar;
        zzdb zzdbVar = null;
        if (iBinder == null) {
            zzdcVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IExposureInformationResultListener");
            zzdcVar = queryLocalInterface instanceof zzdc ? (zzdc) queryLocalInterface : new zzdc(iBinder);
        }
        if (iBinder2 != null) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IExposureInformationListCallback");
            zzdbVar = queryLocalInterface2 instanceof zzdb ? (zzdb) queryLocalInterface2 : new zzcz(iBinder2);
        }
        this.zzc = zzdcVar;
        this.zza = zzdbVar;
        this.zzb = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbm(zzbl zzblVar) {
    }
}
