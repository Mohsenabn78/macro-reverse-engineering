package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeyx implements zzfvy {
    final /* synthetic */ zzekb zza;
    final /* synthetic */ zzffy zzb;
    final /* synthetic */ zzffn zzc;
    final /* synthetic */ zzeyz zzd;
    final /* synthetic */ zzeza zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeyx(zzeza zzezaVar, zzekb zzekbVar, zzffy zzffyVar, zzffn zzffnVar, zzeyz zzeyzVar) {
        this.zze = zzezaVar;
        this.zza = zzekbVar;
        this.zzb = zzffyVar;
        this.zzc = zzffnVar;
        this.zzd = zzeyzVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zza(Throwable th) {
        zzexe zzexeVar;
        final com.google.android.gms.ads.internal.client.zze zza;
        zzeyq zzeyqVar;
        zzdmq zzk;
        zzfgb zzfgbVar;
        zzffy zzffyVar;
        Executor executor;
        zzexeVar = this.zze.zze;
        zzdmr zzdmrVar = (zzdmr) zzexeVar.zzd();
        if (zzdmrVar == null) {
            zza = zzfbi.zzb(th, null);
        } else {
            zza = zzdmrVar.zzb().zza(th);
        }
        synchronized (this.zze) {
            if (zzdmrVar == null) {
                zzeyqVar = this.zze.zzd;
                zzeyqVar.zza(zza);
                zzk = this.zze.zzk(this.zzd);
                zzk.zze().zzb().zzc().zzd();
            } else {
                zzdmrVar.zza().zza(zza);
                executor = this.zze.zzb;
                executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeyw
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzeyq zzeyqVar2;
                        zzeyx zzeyxVar = zzeyx.this;
                        com.google.android.gms.ads.internal.client.zze zzeVar = zza;
                        zzeyqVar2 = zzeyxVar.zze.zzd;
                        zzeyqVar2.zza(zzeVar);
                    }
                });
            }
            zzfbc.zzb(zza.zza, th, "RewardedAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbcy.zzc.zze()).booleanValue() || (zzffyVar = this.zzb) == null) {
                zzfgbVar = this.zze.zzg;
                zzffn zzffnVar = this.zzc;
                zzffnVar.zza(zza);
                zzffnVar.zzg(th);
                zzffnVar.zzf(false);
                zzfgbVar.zzb(zzffnVar.zzl());
            } else {
                zzffyVar.zzc(zza);
                zzffn zzffnVar2 = this.zzc;
                zzffnVar2.zzg(th);
                zzffnVar2.zzf(false);
                zzffyVar.zza(zzffnVar2);
                zzffyVar.zzg();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfvy
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzeyq zzeyqVar;
        Executor executor;
        final zzeyq zzeyqVar2;
        zzeyq zzeyqVar3;
        zzfgb zzfgbVar;
        zzffy zzffyVar;
        zzdmm zzdmmVar = (zzdmm) obj;
        synchronized (this.zze) {
            zzczl zzn = zzdmmVar.zzn();
            zzeyqVar = this.zze.zzd;
            zzn.zzd(zzeyqVar);
            this.zza.zzb(zzdmmVar);
            zzeza zzezaVar = this.zze;
            executor = zzezaVar.zzb;
            zzeyqVar2 = zzezaVar.zzd;
            zzeyqVar2.getClass();
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeyv
                @Override // java.lang.Runnable
                public final void run() {
                    zzeyq.this.zzn();
                }
            });
            zzeyqVar3 = this.zze.zzd;
            zzeyqVar3.onAdMetadataChanged();
            if (!((Boolean) zzbcy.zzc.zze()).booleanValue() || (zzffyVar = this.zzb) == null) {
                zzfgbVar = this.zze.zzg;
                zzffn zzffnVar = this.zzc;
                zzffnVar.zzb(zzdmmVar.zzp().zzb);
                zzffnVar.zzd(zzdmmVar.zzl().zzg());
                zzffnVar.zzf(true);
                zzfgbVar.zzb(zzffnVar.zzl());
            } else {
                zzffyVar.zzf(zzdmmVar.zzp().zzb);
                zzffyVar.zze(zzdmmVar.zzl().zzg());
                zzffn zzffnVar2 = this.zzc;
                zzffnVar2.zzf(true);
                zzffyVar.zza(zzffnVar2);
                zzffyVar.zzg();
            }
        }
    }
}
