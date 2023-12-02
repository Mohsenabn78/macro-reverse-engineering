package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbfw extends zzatq implements zzbfy {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbfw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IOnCustomTemplateAdLoadedListener");
    }

    @Override // com.google.android.gms.internal.ads.zzbfy
    public final void zze(zzbfl zzbflVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbflVar);
        zzbh(1, zza);
    }
}
