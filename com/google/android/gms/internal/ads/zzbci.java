package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbci extends zzatq implements zzbck {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbci(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.customrenderedad.client.IOnCustomRenderedAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbck
    public final void zze(zzbch zzbchVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbchVar);
        zzbh(1, zza);
    }
}
