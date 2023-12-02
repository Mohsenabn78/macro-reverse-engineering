package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbeh extends zzatq implements zzbej {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbeh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.formats.client.IAttributionInfo");
    }

    @Override // com.google.android.gms.internal.ads.zzbej
    public final String zzg() throws RemoteException {
        Parcel zzbg = zzbg(2, zza());
        String readString = zzbg.readString();
        zzbg.recycle();
        return readString;
    }

    @Override // com.google.android.gms.internal.ads.zzbej
    public final List zzh() throws RemoteException {
        Parcel zzbg = zzbg(3, zza());
        ArrayList zzb = zzats.zzb(zzbg);
        zzbg.recycle();
        return zzb;
    }
}
