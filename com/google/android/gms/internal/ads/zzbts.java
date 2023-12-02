package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbts extends zzatq implements zzbtu {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbts(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdsService");
    }

    @Override // com.google.android.gms.internal.ads.zzbtu
    public final void zze(zzbtm zzbtmVar, zzbtx zzbtxVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzbtmVar);
        zzats.zzf(zza, zzbtxVar);
        zzbh(3, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtu
    public final void zzf(zzbti zzbtiVar, zzbtx zzbtxVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzbtiVar);
        zzats.zzf(zza, zzbtxVar);
        zzbh(1, zza);
    }
}
