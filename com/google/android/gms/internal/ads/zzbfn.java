package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbfn extends zzatq implements zzbfp {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbfn(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnAppInstallAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbfp
    public final void zze(zzbfg zzbfgVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbfgVar);
        zzbh(1, zza);
    }
}
