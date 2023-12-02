package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeza implements zzekc {
    private final Context zza;
    private final Executor zzb;
    private final zzcgu zzc;
    private final zzeyq zzd;
    private final zzexe zze;
    private final zzfaa zzf;
    private final zzfgb zzg;
    private final zzfag zzh;
    private zzfwm zzi;

    public zzeza(Context context, Executor executor, zzcgu zzcguVar, zzexe zzexeVar, zzeyq zzeyqVar, zzfag zzfagVar, zzfaa zzfaaVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcguVar;
        this.zze = zzexeVar;
        this.zzd = zzeyqVar;
        this.zzh = zzfagVar;
        this.zzf = zzfaaVar;
        this.zzg = zzcguVar.zzy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzdmq zzk(zzexc zzexcVar) {
        zzdmq zzh = this.zzc.zzh();
        zzcuo zzcuoVar = new zzcuo();
        zzcuoVar.zze(this.zza);
        zzcuoVar.zzi(((zzeyz) zzexcVar).zza);
        zzcuoVar.zzh(this.zzf);
        zzh.zzd(zzcuoVar.zzj());
        zzh.zzc(new zzdar().zzn());
        return zzh;
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final boolean zza() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final boolean zzb(com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzeka zzekaVar, zzekb zzekbVar) throws RemoteException {
        zzffy zzffyVar;
        zzbvb zzbvbVar = new zzbvb(zzlVar, str);
        if (zzbvbVar.zzb == null) {
            zzbzr.zzg("Ad unit ID should not be null for rewarded video ad.");
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeyt
                @Override // java.lang.Runnable
                public final void run() {
                    zzeza.this.zzi();
                }
            });
            return false;
        }
        zzfwm zzfwmVar = this.zzi;
        if (zzfwmVar != null && !zzfwmVar.isDone()) {
            return false;
        }
        if (((Boolean) zzbcy.zzc.zze()).booleanValue()) {
            zzexe zzexeVar = this.zze;
            if (zzexeVar.zzd() != null) {
                zzffy zzh = ((zzdmr) zzexeVar.zzd()).zzh();
                zzh.zzh(5);
                zzh.zzb(zzbvbVar.zza.zzp);
                zzffyVar = zzh;
                zzfbc.zza(this.zza, zzbvbVar.zza.zzf);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziu)).booleanValue() && zzbvbVar.zza.zzf) {
                    this.zzc.zzj().zzm(true);
                }
                zzfag zzfagVar = this.zzh;
                zzfagVar.zzs(zzbvbVar.zzb);
                zzfagVar.zzr(com.google.android.gms.ads.internal.client.zzq.zzd());
                zzfagVar.zzE(zzbvbVar.zza);
                zzfai zzG = zzfagVar.zzG();
                zzffn zzb = zzffm.zzb(this.zza, zzffx.zzf(zzG), 5, zzbvbVar.zza);
                zzeyz zzeyzVar = new zzeyz(null);
                zzeyzVar.zza = zzG;
                zzfwm zzc = this.zze.zzc(new zzexf(zzeyzVar, null), new zzexd() { // from class: com.google.android.gms.internal.ads.zzeyu
                    @Override // com.google.android.gms.internal.ads.zzexd
                    public final zzcum zza(zzexc zzexcVar) {
                        zzdmq zzk;
                        zzk = zzeza.this.zzk(zzexcVar);
                        return zzk;
                    }
                }, null);
                this.zzi = zzc;
                zzfwc.zzq(zzc, new zzeyx(this, zzekbVar, zzffyVar, zzb, zzeyzVar), this.zzb);
                return true;
            }
        }
        zzffyVar = null;
        zzfbc.zza(this.zza, zzbvbVar.zza.zzf);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziu)).booleanValue()) {
            this.zzc.zzj().zzm(true);
        }
        zzfag zzfagVar2 = this.zzh;
        zzfagVar2.zzs(zzbvbVar.zzb);
        zzfagVar2.zzr(com.google.android.gms.ads.internal.client.zzq.zzd());
        zzfagVar2.zzE(zzbvbVar.zza);
        zzfai zzG2 = zzfagVar2.zzG();
        zzffn zzb2 = zzffm.zzb(this.zza, zzffx.zzf(zzG2), 5, zzbvbVar.zza);
        zzeyz zzeyzVar2 = new zzeyz(null);
        zzeyzVar2.zza = zzG2;
        zzfwm zzc2 = this.zze.zzc(new zzexf(zzeyzVar2, null), new zzexd() { // from class: com.google.android.gms.internal.ads.zzeyu
            @Override // com.google.android.gms.internal.ads.zzexd
            public final zzcum zza(zzexc zzexcVar) {
                zzdmq zzk;
                zzk = zzeza.this.zzk(zzexcVar);
                return zzk;
            }
        }, null);
        this.zzi = zzc2;
        zzfwc.zzq(zzc2, new zzeyx(this, zzekbVar, zzffyVar, zzb2, zzeyzVar2), this.zzb);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzi() {
        this.zzd.zza(zzfbi.zzd(6, null, null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzj(int i4) {
        this.zzh.zzo().zza(i4);
    }
}
