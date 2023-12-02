package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbto extends zzatq implements zzbtq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbto(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zze(zzbue zzbueVar, zzbua zzbuaVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzbueVar);
        zzats.zzf(zza, zzbuaVar);
        zzbh(6, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzf(zzbue zzbueVar, zzbua zzbuaVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzbueVar);
        zzats.zzf(zza, zzbuaVar);
        zzbh(5, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzg(zzbue zzbueVar, zzbua zzbuaVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzbueVar);
        zzats.zzf(zza, zzbuaVar);
        zzbh(4, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzh(String str, zzbua zzbuaVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzats.zzf(zza, zzbuaVar);
        zzbh(7, zza);
    }
}
