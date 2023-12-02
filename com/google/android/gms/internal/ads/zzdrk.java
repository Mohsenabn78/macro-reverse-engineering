package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdrk extends com.google.android.gms.ads.internal.client.zzbg {
    final /* synthetic */ zzdre zza;
    final /* synthetic */ zzdrl zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdrk(zzdrl zzdrlVar, zzdre zzdreVar) {
        this.zzb = zzdrlVar;
        this.zza = zzdreVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zzc() throws RemoteException {
        long j4;
        zzdre zzdreVar = this.zza;
        j4 = this.zzb.zza;
        zzdreVar.zzb(j4);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zzd() throws RemoteException {
        long j4;
        zzdre zzdreVar = this.zza;
        j4 = this.zzb.zza;
        zzdreVar.zzc(j4);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zze(int i4) throws RemoteException {
        long j4;
        zzdre zzdreVar = this.zza;
        j4 = this.zzb.zza;
        zzdreVar.zzd(j4, i4);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zzf(com.google.android.gms.ads.internal.client.zze zzeVar) throws RemoteException {
        long j4;
        zzdre zzdreVar = this.zza;
        j4 = this.zzb.zza;
        zzdreVar.zzd(j4, zzeVar.zza);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zzi() throws RemoteException {
        long j4;
        zzdre zzdreVar = this.zza;
        j4 = this.zzb.zza;
        zzdreVar.zze(j4);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zzj() throws RemoteException {
        long j4;
        zzdre zzdreVar = this.zza;
        j4 = this.zzb.zza;
        zzdreVar.zzg(j4);
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zzg() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zzh() {
    }

    @Override // com.google.android.gms.ads.internal.client.zzbh
    public final void zzk() {
    }
}
