package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzor extends zza {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzor(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.uwb.internal.INearbyUwbService");
    }

    public final void zzd(zznw zznwVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zznwVar);
        zzv(1008, zza);
    }

    public final void zze(zzny zznyVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zznyVar);
        zzv(1007, zza);
    }

    public final void zzf(zzoe zzoeVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzoeVar);
        zzv(1004, zza);
    }

    public final void zzg(zzoi zzoiVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzoiVar);
        zzv(1003, zza);
    }

    public final void zzh(zzom zzomVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzomVar);
        zzv(1002, zza);
    }

    public final void zzi(zzpj zzpjVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzpjVar);
        zzv(1001, zza);
    }

    public final void zzj(zzqh zzqhVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzqhVar);
        zzv(1009, zza);
    }

    public final void zzk(zzql zzqlVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzqlVar);
        zzv(1005, zza);
    }

    public final void zzl(zzqp zzqpVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzqpVar);
        zzv(1006, zza);
    }
}
