package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzexq implements zzekc {
    private final Context zza;
    private final Executor zzb;
    private final zzcgu zzc;
    private final zzejm zzd;
    private final zzeyq zze;
    @Nullable
    private zzbck zzf;
    private final zzfgb zzg;
    private final zzfag zzh;
    private zzfwm zzi;

    public zzexq(Context context, Executor executor, zzcgu zzcguVar, zzejm zzejmVar, zzeyq zzeyqVar, zzfag zzfagVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcguVar;
        this.zzd = zzejmVar;
        this.zzh = zzfagVar;
        this.zze = zzeyqVar;
        this.zzg = zzcguVar.zzy();
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final boolean zza() {
        zzfwm zzfwmVar = this.zzi;
        if (zzfwmVar != null && !zzfwmVar.isDone()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final boolean zzb(com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzeka zzekaVar, zzekb zzekbVar) {
        zzdeo zzf;
        zzffy zzffyVar;
        if (str == null) {
            zzbzr.zzg("Ad unit ID should not be null for interstitial ad.");
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzexk
                @Override // java.lang.Runnable
                public final void run() {
                    zzexq.this.zzh();
                }
            });
            return false;
        } else if (zza()) {
            return false;
        } else {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziu)).booleanValue() && zzlVar.zzf) {
                this.zzc.zzj().zzm(true);
            }
            com.google.android.gms.ads.internal.client.zzq zzqVar = ((zzexj) zzekaVar).zza;
            zzfag zzfagVar = this.zzh;
            zzfagVar.zzs(str);
            zzfagVar.zzr(zzqVar);
            zzfagVar.zzE(zzlVar);
            zzfai zzG = zzfagVar.zzG();
            zzffn zzb = zzffm.zzb(this.zza, zzffx.zzf(zzG), 4, zzlVar);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzhL)).booleanValue()) {
                zzden zzf2 = this.zzc.zzf();
                zzcuo zzcuoVar = new zzcuo();
                zzcuoVar.zze(this.zza);
                zzcuoVar.zzi(zzG);
                zzf2.zze(zzcuoVar.zzj());
                zzdar zzdarVar = new zzdar();
                zzdarVar.zzj(this.zzd, this.zzb);
                zzdarVar.zzk(this.zzd, this.zzb);
                zzf2.zzd(zzdarVar.zzn());
                zzf2.zzc(new zzehv(this.zzf));
                zzf = zzf2.zzf();
            } else {
                zzdar zzdarVar2 = new zzdar();
                zzeyq zzeyqVar = this.zze;
                if (zzeyqVar != null) {
                    zzdarVar2.zze(zzeyqVar, this.zzb);
                    zzdarVar2.zzf(this.zze, this.zzb);
                    zzdarVar2.zzb(this.zze, this.zzb);
                }
                zzden zzf3 = this.zzc.zzf();
                zzcuo zzcuoVar2 = new zzcuo();
                zzcuoVar2.zze(this.zza);
                zzcuoVar2.zzi(zzG);
                zzf3.zze(zzcuoVar2.zzj());
                zzdarVar2.zzj(this.zzd, this.zzb);
                zzdarVar2.zze(this.zzd, this.zzb);
                zzdarVar2.zzf(this.zzd, this.zzb);
                zzdarVar2.zzb(this.zzd, this.zzb);
                zzdarVar2.zza(this.zzd, this.zzb);
                zzdarVar2.zzl(this.zzd, this.zzb);
                zzdarVar2.zzk(this.zzd, this.zzb);
                zzdarVar2.zzi(this.zzd, this.zzb);
                zzdarVar2.zzc(this.zzd, this.zzb);
                zzf3.zzd(zzdarVar2.zzn());
                zzf3.zzc(new zzehv(this.zzf));
                zzf = zzf3.zzf();
            }
            zzdeo zzdeoVar = zzf;
            if (((Boolean) zzbcy.zzc.zze()).booleanValue()) {
                zzffy zzf4 = zzdeoVar.zzf();
                zzf4.zzh(4);
                zzf4.zzb(zzlVar.zzp);
                zzffyVar = zzf4;
            } else {
                zzffyVar = null;
            }
            zzcsk zza = zzdeoVar.zza();
            zzfwm zzi = zza.zzi(zza.zzj());
            this.zzi = zzi;
            zzfwc.zzq(zzi, new zzexp(this, zzekbVar, zzffyVar, zzb, zzdeoVar), this.zzb);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzh() {
        this.zzd.zza(zzfbi.zzd(6, null, null));
    }

    public final void zzi(zzbck zzbckVar) {
        this.zzf = zzbckVar;
    }
}
