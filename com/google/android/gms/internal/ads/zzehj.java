package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.AdError;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public class zzehj extends zzbob {
    private final zzcve zza;
    private final zzdcs zzb;
    private final zzcvy zzc;
    private final zzcwn zzd;
    private final zzcws zze;
    private final zzdaa zzf;
    private final zzcxm zzg;
    private final zzddk zzh;
    private final zzczw zzi;
    private final zzcvt zzj;

    public zzehj(zzcve zzcveVar, zzdcs zzdcsVar, zzcvy zzcvyVar, zzcwn zzcwnVar, zzcws zzcwsVar, zzdaa zzdaaVar, zzcxm zzcxmVar, zzddk zzddkVar, zzczw zzczwVar, zzcvt zzcvtVar) {
        this.zza = zzcveVar;
        this.zzb = zzdcsVar;
        this.zzc = zzcvyVar;
        this.zzd = zzcwnVar;
        this.zze = zzcwsVar;
        this.zzf = zzdaaVar;
        this.zzg = zzcxmVar;
        this.zzh = zzddkVar;
        this.zzi = zzczwVar;
        this.zzj = zzcvtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zze() {
        this.zza.onAdClicked();
        this.zzb.zzr();
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzf() {
        this.zzg.zzf(4);
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    @Deprecated
    public final void zzj(int i4) throws RemoteException {
        zzk(new com.google.android.gms.ads.internal.client.zze(i4, "", AdError.UNDEFINED_DOMAIN, null, null));
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzk(com.google.android.gms.ads.internal.client.zze zzeVar) {
        this.zzj.zza(zzfbi.zzc(8, zzeVar));
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzl(String str) {
        zzk(new com.google.android.gms.ads.internal.client.zze(0, str, AdError.UNDEFINED_DOMAIN, null, null));
    }

    public void zzm() {
        this.zzc.zza();
        this.zzi.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzn() {
        this.zzd.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzo() {
        this.zze.zzn();
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzp() {
        this.zzg.zzb();
        this.zzi.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzq(String str, String str2) {
        this.zzf.zzbz(str, str2);
    }

    public void zzv() {
        this.zzh.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzw() {
        this.zzh.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzx() throws RemoteException {
        this.zzh.zzc();
    }

    public void zzy() {
        this.zzh.zzd();
    }

    public void zzu() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzg(int i4) {
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzh(com.google.android.gms.ads.internal.client.zze zzeVar) {
    }

    public void zzs(zzbvg zzbvgVar) {
    }

    public void zzt(zzbvk zzbvkVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzi(int i4, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzboc
    public final void zzr(zzbfl zzbflVar, String str) {
    }
}
