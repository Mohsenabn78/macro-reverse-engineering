package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbkv extends zzatq implements zzbkx {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbkv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.instream.client.IInstreamAdCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbkx
    public final void zze(int i4) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i4);
        zzbh(2, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbkx
    public final void zzf() throws RemoteException {
        zzbh(1, zza());
    }
}
