package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import dev.skomlach.biometric.compat.engine.internal.iris.samsung.SamsungIrisUnlockModule;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzke extends zza {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzke(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.nearby.internal.connection.INearbyConnectionService");
    }

    public final void zzd(zzfj zzfjVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzfjVar);
        zzu(2006, zza);
    }

    public final void zze(zzfn zzfnVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzfnVar);
        zzu(2012, zza);
    }

    public final void zzf(zzfp zzfpVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzfpVar);
        zzu(2011, zza);
    }

    public final void zzg(zzjm zzjmVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzjmVar);
        zzu(2009, zza);
    }

    public final void zzh(zzmh zzmhVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzmhVar);
        zzu(2007, zza);
    }

    public final void zzi(zzml zzmlVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzmlVar);
        zzu(SamsungIrisUnlockModule.IRIS_REQUEST_IR_PREVIEW_ENABLE, zza);
    }

    public final void zzj(zzmp zzmpVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzmpVar);
        zzu(2008, zza);
    }

    public final void zzk(zzmt zzmtVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzmtVar);
        zzu(2001, zza);
    }

    public final void zzl(zzmx zzmxVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzmxVar);
        zzu(2003, zza);
    }

    public final void zzm(zzmz zzmzVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzmzVar);
        zzu(2002, zza);
    }

    public final void zzn(zznb zznbVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zznbVar);
        zzu(2010, zza);
    }

    public final void zzo(zznd zzndVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzndVar);
        zzu(SamsungIrisUnlockModule.IRIS_REQUEST_FACTORY_TEST_CAMERA_VERSION, zza);
    }
}
