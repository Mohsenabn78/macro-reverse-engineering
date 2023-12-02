package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbjk extends zzatq implements zzbjm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbjk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.h5.client.IH5AdsManagerCreator");
    }

    @Override // com.google.android.gms.internal.ads.zzbjm
    public final zzbjj zze(IObjectWrapper iObjectWrapper, zzbnw zzbnwVar, int i4, zzbjg zzbjgVar) throws RemoteException {
        zzbjj zzbjhVar;
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzf(zza, zzbnwVar);
        zza.writeInt(ModuleDescriptor.MODULE_VERSION);
        zzats.zzf(zza, zzbjgVar);
        Parcel zzbg = zzbg(1, zza);
        IBinder readStrongBinder = zzbg.readStrongBinder();
        if (readStrongBinder == null) {
            zzbjhVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.h5.client.IH5AdsManager");
            if (queryLocalInterface instanceof zzbjj) {
                zzbjhVar = (zzbjj) queryLocalInterface;
            } else {
                zzbjhVar = new zzbjh(readStrongBinder);
            }
        }
        zzbg.recycle();
        return zzbjhVar;
    }
}
