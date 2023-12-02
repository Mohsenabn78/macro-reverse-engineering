package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbpr extends zzatq implements zzbpt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbpr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.rtb.IRtbAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final com.google.android.gms.ads.internal.client.zzdq zze() throws RemoteException {
        Parcel zzbg = zzbg(5, zza());
        com.google.android.gms.ads.internal.client.zzdq zzb = com.google.android.gms.ads.internal.client.zzdp.zzb(zzbg.readStrongBinder());
        zzbg.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final zzbqh zzf() throws RemoteException {
        Parcel zzbg = zzbg(2, zza());
        zzbqh zzbqhVar = (zzbqh) zzats.zza(zzbg, zzbqh.CREATOR);
        zzbg.recycle();
        return zzbqhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final zzbqh zzg() throws RemoteException {
        Parcel zzbg = zzbg(3, zza());
        zzbqh zzbqhVar = (zzbqh) zzats.zza(zzbg, zzbqh.CREATOR);
        zzbg.recycle();
        return zzbqhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzh(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, com.google.android.gms.ads.internal.client.zzq zzqVar, zzbpw zzbpwVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zza.writeString(str);
        zzats.zzd(zza, bundle);
        zzats.zzd(zza, bundle2);
        zzats.zzd(zza, zzqVar);
        zzats.zzf(zza, zzbpwVar);
        zzbh(1, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzi(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbpe zzbpeVar, zzboc zzbocVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzats.zzd(zza, zzlVar);
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzf(zza, zzbpeVar);
        zzats.zzf(zza, zzbocVar);
        zzbh(23, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzj(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbph zzbphVar, zzboc zzbocVar, com.google.android.gms.ads.internal.client.zzq zzqVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzats.zzd(zza, zzlVar);
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzf(zza, zzbphVar);
        zzats.zzf(zza, zzbocVar);
        zzats.zzd(zza, zzqVar);
        zzbh(13, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzk(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbph zzbphVar, zzboc zzbocVar, com.google.android.gms.ads.internal.client.zzq zzqVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzats.zzd(zza, zzlVar);
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzf(zza, zzbphVar);
        zzats.zzf(zza, zzbocVar);
        zzats.zzd(zza, zzqVar);
        zzbh(21, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzl(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbpk zzbpkVar, zzboc zzbocVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzats.zzd(zza, zzlVar);
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzf(zza, zzbpkVar);
        zzats.zzf(zza, zzbocVar);
        zzbh(14, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzm(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbpn zzbpnVar, zzboc zzbocVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzats.zzd(zza, zzlVar);
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzf(zza, zzbpnVar);
        zzats.zzf(zza, zzbocVar);
        zzbh(18, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzn(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbpn zzbpnVar, zzboc zzbocVar, zzbef zzbefVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzats.zzd(zza, zzlVar);
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzf(zza, zzbpnVar);
        zzats.zzf(zza, zzbocVar);
        zzats.zzd(zza, zzbefVar);
        zzbh(22, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzo(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbpq zzbpqVar, zzboc zzbocVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzats.zzd(zza, zzlVar);
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzf(zza, zzbpqVar);
        zzats.zzf(zza, zzbocVar);
        zzbh(20, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzp(String str, String str2, com.google.android.gms.ads.internal.client.zzl zzlVar, IObjectWrapper iObjectWrapper, zzbpq zzbpqVar, zzboc zzbocVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzats.zzd(zza, zzlVar);
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzf(zza, zzbpqVar);
        zzats.zzf(zza, zzbocVar);
        zzbh(16, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final void zzq(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbh(19, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final boolean zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        Parcel zzbg = zzbg(24, zza);
        boolean zzg = zzats.zzg(zzbg);
        zzbg.recycle();
        return zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final boolean zzs(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        Parcel zzbg = zzbg(15, zza);
        boolean zzg = zzats.zzg(zzbg);
        zzbg.recycle();
        return zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbpt
    public final boolean zzt(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        Parcel zzbg = zzbg(17, zza);
        boolean zzg = zzats.zzg(zzbg);
        zzbg.recycle();
        return zzg;
    }
}
