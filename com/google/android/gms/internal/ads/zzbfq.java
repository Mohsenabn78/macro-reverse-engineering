package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbfq extends zzatq implements zzbfs {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbfq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnContentAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbfs
    public final void zze(zzbfi zzbfiVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbfiVar);
        zzbh(1, zza);
    }
}
