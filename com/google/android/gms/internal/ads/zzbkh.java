package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbkh extends zzatq implements zzbkj {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbkh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.initialization.IAdapterInitializationCallback");
    }

    @Override // com.google.android.gms.internal.ads.zzbkj
    public final void zze(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbh(3, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbkj
    public final void zzf() throws RemoteException {
        zzbh(2, zza());
    }
}
