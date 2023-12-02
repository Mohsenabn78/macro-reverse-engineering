package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbnx extends zzatq implements zzbnz {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbnx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.mediation.client.IMediationAdapter");
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final void zzA(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzboc zzbocVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzd(zza, zzlVar);
        zza.writeString(str);
        zzats.zzf(zza, zzbocVar);
        zzbh(28, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final void zzB(com.google.android.gms.ads.internal.client.zzl zzlVar, String str, String str2) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final void zzC(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzboc zzbocVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzd(zza, zzlVar);
        zza.writeString(str);
        zzats.zzf(zza, zzbocVar);
        zzbh(32, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final void zzD(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzbh(21, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final void zzE() throws RemoteException {
        zzbh(8, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final void zzF() throws RemoteException {
        zzbh(9, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final void zzG(boolean z3) throws RemoteException {
        Parcel zza = zza();
        int i4 = zzats.zza;
        zza.writeInt(z3 ? 1 : 0);
        zzbh(25, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final void zzH(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzbh(39, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final void zzI() throws RemoteException {
        zzbh(4, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final void zzJ(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzbh(37, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final void zzK(IObjectWrapper iObjectWrapper) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzbh(30, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final void zzL() throws RemoteException {
        zzbh(12, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final boolean zzM() throws RemoteException {
        Parcel zzbg = zzbg(22, zza());
        boolean zzg = zzats.zzg(zzbg);
        zzbg.recycle();
        return zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final boolean zzN() throws RemoteException {
        Parcel zzbg = zzbg(13, zza());
        boolean zzg = zzats.zzg(zzbg);
        zzbg.recycle();
        return zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final zzboh zzO() throws RemoteException {
        zzboh zzbohVar;
        Parcel zzbg = zzbg(15, zza());
        IBinder readStrongBinder = zzbg.readStrongBinder();
        if (readStrongBinder == null) {
            zzbohVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeAppInstallAdMapper");
            if (queryLocalInterface instanceof zzboh) {
                zzbohVar = (zzboh) queryLocalInterface;
            } else {
                zzbohVar = new zzboh(readStrongBinder);
            }
        }
        zzbg.recycle();
        return zzbohVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final zzboi zzP() throws RemoteException {
        zzboi zzboiVar;
        Parcel zzbg = zzbg(16, zza());
        IBinder readStrongBinder = zzbg.readStrongBinder();
        if (readStrongBinder == null) {
            zzboiVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.INativeContentAdMapper");
            if (queryLocalInterface instanceof zzboi) {
                zzboiVar = (zzboi) queryLocalInterface;
            } else {
                zzboiVar = new zzboi(readStrongBinder);
            }
        }
        zzbg.recycle();
        return zzboiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final Bundle zze() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final Bundle zzf() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final Bundle zzg() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final com.google.android.gms.ads.internal.client.zzdq zzh() throws RemoteException {
        Parcel zzbg = zzbg(26, zza());
        com.google.android.gms.ads.internal.client.zzdq zzb = com.google.android.gms.ads.internal.client.zzdp.zzb(zzbg.readStrongBinder());
        zzbg.recycle();
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final zzbfl zzi() throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final zzbof zzj() throws RemoteException {
        zzbof zzbodVar;
        Parcel zzbg = zzbg(36, zza());
        IBinder readStrongBinder = zzbg.readStrongBinder();
        if (readStrongBinder == null) {
            zzbodVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IMediationInterscrollerAd");
            if (queryLocalInterface instanceof zzbof) {
                zzbodVar = (zzbof) queryLocalInterface;
            } else {
                zzbodVar = new zzbod(readStrongBinder);
            }
        }
        zzbg.recycle();
        return zzbodVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final zzbol zzk() throws RemoteException {
        zzbol zzbojVar;
        Parcel zzbg = zzbg(27, zza());
        IBinder readStrongBinder = zzbg.readStrongBinder();
        if (readStrongBinder == null) {
            zzbojVar = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.ads.internal.mediation.client.IUnifiedNativeAdMapper");
            if (queryLocalInterface instanceof zzbol) {
                zzbojVar = (zzbol) queryLocalInterface;
            } else {
                zzbojVar = new zzboj(readStrongBinder);
            }
        }
        zzbg.recycle();
        return zzbojVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final zzbqh zzl() throws RemoteException {
        Parcel zzbg = zzbg(33, zza());
        zzbqh zzbqhVar = (zzbqh) zzats.zza(zzbg, zzbqh.CREATOR);
        zzbg.recycle();
        return zzbqhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final zzbqh zzm() throws RemoteException {
        Parcel zzbg = zzbg(34, zza());
        zzbqh zzbqhVar = (zzbqh) zzats.zza(zzbg, zzbqh.CREATOR);
        zzbg.recycle();
        return zzbqhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final IObjectWrapper zzn() throws RemoteException {
        Parcel zzbg = zzbg(2, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzbg.readStrongBinder());
        zzbg.recycle();
        return asInterface;
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final void zzo() throws RemoteException {
        zzbh(5, zza());
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final void zzp(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzbvf zzbvfVar, String str2) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzd(zza, zzlVar);
        zza.writeString(null);
        zzats.zzf(zza, zzbvfVar);
        zza.writeString(str2);
        zzbh(10, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final void zzq(IObjectWrapper iObjectWrapper, zzbkj zzbkjVar, List list) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzf(zza, zzbkjVar);
        zza.writeTypedList(list);
        zzbh(31, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final void zzr(IObjectWrapper iObjectWrapper, zzbvf zzbvfVar, List list) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzf(zza, zzbvfVar);
        zza.writeStringList(list);
        zzbh(23, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final void zzs(com.google.android.gms.ads.internal.client.zzl zzlVar, String str) throws RemoteException {
        Parcel zza = zza();
        zzats.zzd(zza, zzlVar);
        zza.writeString(str);
        zzbh(11, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final void zzt(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzboc zzbocVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzd(zza, zzlVar);
        zza.writeString(str);
        zzats.zzf(zza, zzbocVar);
        zzbh(38, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final void zzu(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzq zzqVar, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzboc zzbocVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final void zzv(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzq zzqVar, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, String str2, zzboc zzbocVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzd(zza, zzqVar);
        zzats.zzd(zza, zzlVar);
        zza.writeString(str);
        zza.writeString(str2);
        zzats.zzf(zza, zzbocVar);
        zzbh(6, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final void zzw(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzq zzqVar, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, String str2, zzboc zzbocVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzd(zza, zzqVar);
        zzats.zzd(zza, zzlVar);
        zza.writeString(str);
        zza.writeString(str2);
        zzats.zzf(zza, zzbocVar);
        zzbh(35, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final void zzx(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzboc zzbocVar) throws RemoteException {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final void zzy(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, String str2, zzboc zzbocVar) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzd(zza, zzlVar);
        zza.writeString(str);
        zza.writeString(str2);
        zzats.zzf(zza, zzbocVar);
        zzbh(7, zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbnz
    public final void zzz(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzl zzlVar, String str, String str2, zzboc zzbocVar, zzbef zzbefVar, List list) throws RemoteException {
        Parcel zza = zza();
        zzats.zzf(zza, iObjectWrapper);
        zzats.zzd(zza, zzlVar);
        zza.writeString(str);
        zza.writeString(str2);
        zzats.zzf(zza, zzbocVar);
        zzats.zzd(zza, zzbefVar);
        zza.writeStringList(list);
        zzbh(14, zza);
    }
}
