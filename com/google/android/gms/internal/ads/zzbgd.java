package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbgd extends zzatq implements zzbgf {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbgd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnUnifiedNativeAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbgf
    public final void zze(zzbgo zzbgoVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbgoVar);
        zzbh(1, zza);
    }
}
