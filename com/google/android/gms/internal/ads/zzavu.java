package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzavu extends zzatq implements zzavw {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzavu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.appopen.client.IAppOpenAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzavw
    public final void zzb(int i4) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i4);
        zzbh(2, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzavw
    public final void zzc(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzeVar);
        zzbh(3, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzavw
    public final void zzd(zzavt zzavtVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzavtVar);
        zzbh(1, zza);
    }
}
