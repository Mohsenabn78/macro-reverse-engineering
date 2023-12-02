package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbvv extends zzatq {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbvv(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAdSkuListener");
    }

    public final void zze(zzbvk zzbvkVar, String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbvkVar);
        zza.writeString(str);
        zza.writeString(str2);
        zzbh(2, zza);
    }
}
