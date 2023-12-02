package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbjy extends zzatq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbjy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
    }

    public final void zze(zzbjs zzbjsVar, zzbjx zzbjxVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzbjsVar);
        zzats.zzf(zza, zzbjxVar);
        zzbi(2, zza);
    }
}
