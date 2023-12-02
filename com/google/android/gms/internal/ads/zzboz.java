package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzboz extends zzbob {
    private final Adapter zza;
    private final zzbvf zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzboz(Adapter adapter, zzbvf zzbvfVar) {
        this.zza = adapter;
        this.zzb = zzbvfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zze() throws RemoteException {
        zzbvf zzbvfVar = this.zzb;
        if (zzbvfVar != null) {
            zzbvfVar.zze(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzf() throws RemoteException {
        zzbvf zzbvfVar = this.zzb;
        if (zzbvfVar != null) {
            zzbvfVar.zzf(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzg(int i4) throws RemoteException {
        zzbvf zzbvfVar = this.zzb;
        if (zzbvfVar != null) {
            zzbvfVar.zzg(ObjectWrapper.wrap(this.zza), i4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzo() throws RemoteException {
        zzbvf zzbvfVar = this.zzb;
        if (zzbvfVar != null) {
            zzbvfVar.zzi(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzp() throws RemoteException {
        zzbvf zzbvfVar = this.zzb;
        if (zzbvfVar != null) {
            zzbvfVar.zzj(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzt(zzbvk zzbvkVar) throws RemoteException {
        zzbvf zzbvfVar = this.zzb;
        if (zzbvfVar != null) {
            zzbvfVar.zzm(ObjectWrapper.wrap(this.zza), new zzbvg(zzbvkVar.zzf(), zzbvkVar.zze()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzu() throws RemoteException {
        zzbvf zzbvfVar = this.zzb;
        if (zzbvfVar != null) {
            zzbvfVar.zzn(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzy() throws RemoteException {
        zzbvf zzbvfVar = this.zzb;
        if (zzbvfVar != null) {
            zzbvfVar.zzo(ObjectWrapper.wrap(this.zza));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzm() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzn() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzv() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzw() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzx() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzh(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzj(int i4) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzk(com.google.android.gms.ads.internal.client.zze zzeVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzl(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzs(zzbvg zzbvgVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzi(int i4, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzq(String str, String str2) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzr(zzbfl zzbflVar, String str) throws RemoteException {
    }
}
