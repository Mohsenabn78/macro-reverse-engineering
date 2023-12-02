package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzs extends com.google.android.gms.internal.nearby.zza {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.messages.internal.INearbyMessagesService");
    }

    public final void zzd(zzh zzhVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.nearby.zzc.zzd(zza, zzhVar);
        zzv(7, zza);
    }

    public final void zze(zzj zzjVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.nearby.zzc.zzd(zza, zzjVar);
        zzv(9, zza);
    }

    public final void zzf(zzbz zzbzVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.nearby.zzc.zzd(zza, zzbzVar);
        zzv(1, zza);
    }

    public final void zzg(zzcb zzcbVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.nearby.zzc.zzd(zza, zzcbVar);
        zzv(8, zza);
    }

    public final void zzh(SubscribeRequest subscribeRequest) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.nearby.zzc.zzd(zza, subscribeRequest);
        zzv(3, zza);
    }

    public final void zzi(zzce zzceVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.nearby.zzc.zzd(zza, zzceVar);
        zzv(2, zza);
    }

    public final void zzj(zzcg zzcgVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.nearby.zzc.zzd(zza, zzcgVar);
        zzv(4, zza);
    }
}
