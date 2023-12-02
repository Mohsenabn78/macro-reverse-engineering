package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbyg extends zzatq implements zzbyi {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbyg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.signals.ISignalGenerator");
    }

    @Override // com.google.android.gms.internal.ads.zzbyi
    public final void zze(IObjectWrapper iObjectWrapper, zzbym zzbymVar, zzbyf zzbyfVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzd(zza, zzbymVar);
        zzats.zzf(zza, zzbyfVar);
        zzbh(1, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbyi
    public final void zzf(zzbsr zzbsrVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzbsrVar);
        zzbh(7, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbyi
    public final void zzg(List list, IObjectWrapper iObjectWrapper, zzbsi zzbsiVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzf(zza, zzbsiVar);
        zzbh(10, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbyi
    public final void zzh(List list, IObjectWrapper iObjectWrapper, zzbsi zzbsiVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzf(zza, zzbsiVar);
        zzbh(9, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbyi
    public final void zzi(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzbh(8, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbyi
    public final void zzj(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzbh(2, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbyi
    public final void zzk(List list, IObjectWrapper iObjectWrapper, zzbsi zzbsiVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzf(zza, zzbsiVar);
        zzbh(6, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbyi
    public final void zzl(List list, IObjectWrapper iObjectWrapper, zzbsi zzbsiVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeTypedList(list);
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzf(zza, zzbsiVar);
        zzbh(5, zza);
    }
}
