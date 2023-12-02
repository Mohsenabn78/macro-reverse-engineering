package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfnr extends zzatq implements zzfnt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfnr(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.lmd.protocol.ILmdOverlayService");
    }

    @Override // com.google.android.gms.internal.ads.zzfnt
    public final void zze(Bundle bundle, zzfnv zzfnvVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, bundle);
        zzats.zzf(zza, zzfnvVar);
        zzbi(2, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzfnt
    public final void zzf(String str, Bundle bundle, zzfnv zzfnvVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzats.zzd(zza, bundle);
        zzats.zzf(zza, zzfnvVar);
        zzbi(1, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzfnt
    public final void zzg(Bundle bundle, zzfnv zzfnvVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, bundle);
        zzats.zzf(zza, zzfnvVar);
        zzbi(3, zza);
    }
}
