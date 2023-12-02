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
import com.google.android.gms.nearby.connection.DiscoveryOptions;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "StartDiscoveryParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzmx extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzmx> CREATOR = new zzmy();
    @Nullable
    @SafeParcelable.Field(getter = "getResultListenerAsBinder", id = 1, type = "android.os.IBinder")
    private zzkk zza;
    @SafeParcelable.Field(getter = "getServiceId", id = 3)
    private String zzb;
    @SafeParcelable.Field(getter = "getDurationMillis", id = 4)
    private long zzc;
    @SafeParcelable.Field(getter = "getOptions", id = 5)
    private DiscoveryOptions zzd;
    @Nullable
    @SafeParcelable.Field(getter = "getDiscoveryListenerAsBinder", id = 6, type = "android.os.IBinder")
    private zzkd zze;
    @Nullable
    @SafeParcelable.Field(getter = "getCallbackAsBinder", id = 2, type = "android.os.IBinder")
    private zzka zzf;

    private zzmx() {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzmx) {
            zzmx zzmxVar = (zzmx) obj;
            if (Objects.equal(this.zza, zzmxVar.zza) && Objects.equal(this.zzf, zzmxVar.zzf) && Objects.equal(this.zzb, zzmxVar.zzb) && Objects.equal(Long.valueOf(this.zzc), Long.valueOf(zzmxVar.zzc)) && Objects.equal(this.zzd, zzmxVar.zzd) && Objects.equal(this.zze, zzmxVar.zze)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzf, this.zzb, Long.valueOf(this.zzc), this.zzd, this.zze);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        IBinder asBinder;
        IBinder asBinder2;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzkk zzkkVar = this.zza;
        IBinder iBinder = null;
        if (zzkkVar == null) {
            asBinder = null;
        } else {
            asBinder = zzkkVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 1, asBinder, false);
        zzka zzkaVar = this.zzf;
        if (zzkaVar == null) {
            asBinder2 = null;
        } else {
            asBinder2 = zzkaVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 2, asBinder2, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeLong(parcel, 4, this.zzc);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzd, i4, false);
        zzkd zzkdVar = this.zze;
        if (zzkdVar != null) {
            iBinder = zzkdVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 6, iBinder, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzmx(@Nullable @SafeParcelable.Param(id = 1) IBinder iBinder, @Nullable @SafeParcelable.Param(id = 2) IBinder iBinder2, @SafeParcelable.Param(id = 3) String str, @SafeParcelable.Param(id = 4) long j4, @SafeParcelable.Param(id = 5) DiscoveryOptions discoveryOptions, @Nullable @SafeParcelable.Param(id = 6) IBinder iBinder3) {
        zzkk zzkiVar;
        zzka zzkaVar;
        zzkd zzkdVar = null;
        if (iBinder == null) {
            zzkiVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IResultListener");
            zzkiVar = queryLocalInterface instanceof zzkk ? (zzkk) queryLocalInterface : new zzki(iBinder);
        }
        if (iBinder2 == null) {
            zzkaVar = null;
        } else {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IDiscoveryCallback");
            zzkaVar = queryLocalInterface2 instanceof zzka ? (zzka) queryLocalInterface2 : new zzka(iBinder2);
        }
        if (iBinder3 != null) {
            IInterface queryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.internal.connection.IDiscoveryListener");
            zzkdVar = queryLocalInterface3 instanceof zzkd ? (zzkd) queryLocalInterface3 : new zzkb(iBinder3);
        }
        this.zza = zzkiVar;
        this.zzf = zzkaVar;
        this.zzb = str;
        this.zzc = j4;
        this.zzd = discoveryOptions;
        this.zze = zzkdVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzmx(zzmw zzmwVar) {
    }
}
