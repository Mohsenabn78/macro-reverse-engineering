package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbky extends zzatq implements zzbla {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbky(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAdLoadCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbla
    public final void zze(int i4) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i4);
        zzbh(2, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbla
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzeVar);
        zzbh(3, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbla
    public final void zzg(zzbku zzbkuVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbkuVar);
        zzbh(1, zza);
    }
}
