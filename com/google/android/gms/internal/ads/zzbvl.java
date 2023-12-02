package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbvl extends zzatq implements zzbvn {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbvl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.rewarded.client.IRewardedAd");
    }

    @Override // com.google.android.gms.internal.ads.zzbvn
    public final Bundle zzb() throws RemoteException {
        Parcel zzbg = zzbg(9, zza());
        Bundle bundle = (Bundle) zzats.zza(zzbg, Bundle.CREATOR);
        zzbg.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzbvn
    public final com.google.android.gms.ads.internal.client.zzdn zzc() throws RemoteException {
        Parcel zzbg = zzbg(12, zza());
        com.google.android.gms.ads.internal.client.zzdn zzb = com.google.android.gms.ads.internal.client.zzdm.zzb(zzbg.readStrongBinder());
        zzbg.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbvn
    public final zzbvk zzd() throws RemoteException {
        zzbvk zzbviVar;
        Parcel zzbg = zzbg(11, zza());
        IBinder readStrongBinder = zzbg.readStrongBinder();
        if (readStrongBinder == null) {
            zzbviVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.rewarded.client.IRewardItem");
            if (queryLocalInterface instanceof zzbvk) {
                zzbviVar = (zzbvk) queryLocalInterface;
            } else {
                zzbviVar = new zzbvi(readStrongBinder);
            }
        }
        zzbg.recycle();
        return zzbviVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbvn
    public final String zze() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbvn
    public final void zzf(com.google.android.gms.ads.internal.client.zzl zzlVar, zzbvu zzbvuVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzlVar);
        zzats.zzf(zza, zzbvuVar);
        zzbh(1, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvn
    public final void zzg(com.google.android.gms.ads.internal.client.zzl zzlVar, zzbvu zzbvuVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzlVar);
        zzats.zzf(zza, zzbvuVar);
        zzbh(14, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvn
    public final void zzh(boolean z3) throws RemoteException {
        Parcel zza = zza();
        int i4 = zzats.zza;
        zza.writeInt(z3 ? 1 : 0);
        zzbh(15, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvn
    public final void zzi(com.google.android.gms.ads.internal.client.zzdd zzddVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzddVar);
        zzbh(8, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvn
    public final void zzj(com.google.android.gms.ads.internal.client.zzdg zzdgVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzdgVar);
        zzbh(13, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvn
    public final void zzk(zzbvq zzbvqVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbvqVar);
        zzbh(2, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvn
    public final void zzl(zzbwb zzbwbVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzbwbVar);
        zzbh(7, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvn
    public final void zzm(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzbh(5, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbvn
    public final void zzn(IObjectWrapper iObjectWrapper, boolean z3) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbvn
    public final boolean zzo() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbvn
    public final void zzp(zzbvv zzbvvVar) throws RemoteException {
        throw null;
    }
}
