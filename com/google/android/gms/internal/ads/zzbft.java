package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbft extends zzatq implements zzbfv {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbft(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomClickListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbfv
    public final void zze(zzbfl zzbflVar, String str) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbflVar);
        zza.writeString(str);
        zzbh(1, zza);
    }
}
