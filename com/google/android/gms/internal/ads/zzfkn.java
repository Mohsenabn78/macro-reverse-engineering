package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfkn extends zzatq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfkn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    public final zzfkl zze(zzfkj zzfkjVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzfkjVar);
        Parcel zzbg = zzbg(1, zza);
        zzfkl zzfklVar = (zzfkl) zzats.zza(zzbg, zzfkl.CREATOR);
        zzbg.recycle();
        return zzfklVar;
    }

    public final zzfku zzf(zzfks zzfksVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzfksVar);
        Parcel zzbg = zzbg(3, zza);
        zzfku zzfkuVar = (zzfku) zzats.zza(zzbg, zzfku.CREATOR);
        zzbg.recycle();
        return zzfkuVar;
    }

    public final void zzg(zzfkg zzfkgVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzfkgVar);
        zzbh(2, zza);
    }
}
