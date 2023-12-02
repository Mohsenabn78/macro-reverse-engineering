package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzboa extends zzatq implements zzboc {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzboa(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapterListener");
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zze() throws RemoteException {
        zzbh(1, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzf() throws RemoteException {
        zzbh(2, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzg(int i4) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i4);
        zzbh(3, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzh(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzeVar);
        zzbh(23, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzi(int i4, String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeInt(i4);
        zza.writeString(str);
        zzbh(22, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzj(int i4) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzk(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzeVar);
        zzbh(24, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzl(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzbh(21, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzm() throws RemoteException {
        zzbh(8, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzn() throws RemoteException {
        zzbh(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzo() throws RemoteException {
        zzbh(6, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzp() throws RemoteException {
        zzbh(5, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzq(String str, String str2) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbh(9, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzr(zzbfl zzbflVar, String str) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbflVar);
        zza.writeString(str);
        zzbh(10, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzs(zzbvg zzbvgVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzt(zzbvk zzbvkVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, zzbvkVar);
        zzbh(16, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzu() throws RemoteException {
        zzbh(18, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzv() throws RemoteException {
        zzbh(11, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzw() throws RemoteException {
        zzbh(15, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzx() throws RemoteException {
        zzbh(20, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzy() throws RemoteException {
        zzbh(13, zza());
    }
}
