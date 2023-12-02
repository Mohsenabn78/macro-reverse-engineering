package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeki implements zzfvy {
    final /* synthetic */ zzekb zza;
    final /* synthetic */ zzffy zzb;
    final /* synthetic */ zzffn zzc;
    final /* synthetic */ zzdfk zzd;
    final /* synthetic */ zzekj zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeki(zzekj zzekjVar, zzekb zzekbVar, zzffy zzffyVar, zzffn zzffnVar, zzdfk zzdfkVar) {
        this.zze = zzekjVar;
        this.zza = zzekbVar;
        this.zzb = zzffyVar;
        this.zzc = zzffnVar;
        this.zzd = zzdfkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zza(Throwable th) {
        zzcgu zzcguVar;
        zzfgb zzfgbVar;
        zzffy zzffyVar;
        final com.google.android.gms.ads.internal.client.zze zza = this.zzd.zza().zza(th);
        this.zzd.zzb().zza(zza);
        zzcguVar = this.zze.zzb;
        zzcguVar.zzA().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzekh
            @Override // java.lang.Runnable
            public final void run() {
                zzejz zzejzVar;
                zzeki zzekiVar = zzeki.this;
                com.google.android.gms.ads.internal.client.zze zzeVar = zza;
                zzejzVar = zzekiVar.zze.zzd;
                zzejzVar.zza().zza(zzeVar);
            }
        });
        zzfbc.zzb(zza.zza, th, "NativeAdLoader.onFailure");
        this.zza.zza();
        if (!((Boolean) zzbcy.zzc.zze()).booleanValue() || (zzffyVar = this.zzb) == null) {
            zzfgbVar = this.zze.zze;
            zzffn zzffnVar = this.zzc;
            zzffnVar.zza(zza);
            zzffnVar.zzg(th);
            zzffnVar.zzf(false);
            zzfgbVar.zzb(zzffnVar.zzl());
            return;
        }
        zzffyVar.zzc(zza);
        zzffn zzffnVar2 = this.zzc;
        zzffnVar2.zzg(th);
        zzffnVar2.zzf(false);
        zzffyVar.zza(zzffnVar2);
        zzffyVar.zzg();
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzejz zzejzVar;
        zzcgu zzcguVar;
        zzfgb zzfgbVar;
        zzffy zzffyVar;
        zzcrd zzcrdVar = (zzcrd) obj;
        synchronized (this.zze) {
            zzczl zzn = zzcrdVar.zzn();
            zzejzVar = this.zze.zzd;
            zzn.zza(zzejzVar.zzd());
            this.zza.zzb(zzcrdVar);
            zzcguVar = this.zze.zzb;
            zzcguVar.zzA().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzekg
                @Override // java.lang.Runnable
                public final void run() {
                    zzejz zzejzVar2;
                    zzejzVar2 = zzeki.this.zze.zzd;
                    zzejzVar2.zzb().zzn();
                }
            });
            if (!((Boolean) zzbcy.zzc.zze()).booleanValue() || (zzffyVar = this.zzb) == null) {
                zzfgbVar = this.zze.zze;
                zzffn zzffnVar = this.zzc;
                zzffnVar.zzb(zzcrdVar.zzp().zzb);
                zzffnVar.zzd(zzcrdVar.zzl().zzg());
                zzffnVar.zzf(true);
                zzfgbVar.zzb(zzffnVar.zzl());
            } else {
                zzffyVar.zzf(zzcrdVar.zzp().zzb);
                zzffyVar.zze(zzcrdVar.zzl().zzg());
                zzffn zzffnVar2 = this.zzc;
                zzffnVar2.zzf(true);
                zzffyVar.zza(zzffnVar2);
                zzffyVar.zzg();
            }
        }
    }
}
