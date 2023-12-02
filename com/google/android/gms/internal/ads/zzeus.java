package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeus implements zzfvy {
    final /* synthetic */ zzekb zza;
    final /* synthetic */ zzffy zzb;
    final /* synthetic */ zzffn zzc;
    final /* synthetic */ zzeuu zzd;
    final /* synthetic */ zzeuv zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeus(zzeuv zzeuvVar, zzekb zzekbVar, zzffy zzffyVar, zzffn zzffnVar, zzeuu zzeuuVar) {
        this.zze = zzeuvVar;
        this.zza = zzekbVar;
        this.zzb = zzffyVar;
        this.zzc = zzffnVar;
        this.zzd = zzeuuVar;
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.Object, com.google.android.gms.internal.ads.zzcun] */
    @Override // com.google.android.gms.internal.ads.zzfvy
    public final void zza(Throwable th) {
        zzexe zzexeVar;
        final com.google.android.gms.ads.internal.client.zze zza;
        zzevl zzevlVar;
        zzcum zzm;
        zzfgb zzfgbVar;
        zzffy zzffyVar;
        Executor executor;
        zzexeVar = this.zze.zze;
        zzcol zzcolVar = (zzcol) zzexeVar.zzd();
        if (zzcolVar == null) {
            zza = zzfbi.zzb(th, null);
        } else {
            zza = zzcolVar.zzb().zza(th);
        }
        synchronized (this.zze) {
            this.zze.zzj = null;
            if (zzcolVar == null) {
                zzevlVar = this.zze.zzd;
                zzevlVar.zza(zza);
                zzm = this.zze.zzm(this.zzd);
                zzm.zzh().zzb().zzc().zzd();
            } else {
                zzcolVar.zzc().zza(zza);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzhK)).booleanValue()) {
                    executor = this.zze.zzc;
                    executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeur
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzevl zzevlVar2;
                            zzeus zzeusVar = zzeus.this;
                            com.google.android.gms.ads.internal.client.zze zzeVar = zza;
                            zzevlVar2 = zzeusVar.zze.zzd;
                            zzevlVar2.zza(zzeVar);
                        }
                    });
                }
            }
            zzfbc.zzb(zza.zza, th, "AppOpenAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbcy.zzc.zze()).booleanValue() || (zzffyVar = this.zzb) == null) {
                zzfgbVar = this.zze.zzh;
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
        zzfgb zzfgbVar;
        zzffy zzffyVar;
        zzevl zzevlVar;
        zzcrd zzcrdVar = (zzcrd) obj;
        synchronized (this.zze) {
            this.zze.zzj = null;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzhK)).booleanValue()) {
                zzczl zzn = zzcrdVar.zzn();
                zzevlVar = this.zze.zzd;
                zzn.zzb(zzevlVar);
            }
            this.zza.zzb(zzcrdVar);
            if (!((Boolean) zzbcy.zzc.zze()).booleanValue() || (zzffyVar = this.zzb) == null) {
                zzfgbVar = this.zze.zzh;
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
