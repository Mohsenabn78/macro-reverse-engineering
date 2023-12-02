package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbdz extends zzatq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbdz(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.flags.IFlagRetrieverSupplierProxy");
    }

    public final void zze(zzbtd zzbtdVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbtdVar);
        zzbh(1, zza);
    }
}
