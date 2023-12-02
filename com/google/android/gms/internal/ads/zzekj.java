package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzekj implements zzekc {
    private final zzfag zza;
    private final zzcgu zzb;
    private final Context zzc;
    private final zzejz zzd;
    private final zzfgb zze;
    @Nullable
    private zzcrr zzf;

    public zzekj(zzcgu zzcguVar, Context context, zzejz zzejzVar, zzfag zzfagVar) {
        this.zzb = zzcguVar;
        this.zzc = context;
        this.zzd = zzejzVar;
        this.zza = zzfagVar;
        this.zze = zzcguVar.zzy();
        zzfagVar.zzu(zzejzVar.zzd());
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final boolean zza() {
        zzcrr zzcrrVar = this.zzf;
        if (zzcrrVar != null && zzcrrVar.zzf()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final boolean zzb(com.google.android.gms.ads.internal.client.zzl zzlVar, String str, zzeka zzekaVar, zzekb zzekbVar) throws RemoteException {
        zzffy zzffyVar;
        com.google.android.gms.ads.internal.zzt.zzp();
        if (com.google.android.gms.ads.internal.util.zzs.zzD(this.zzc) && zzlVar.zzs == null) {
            zzbzr.zzg("Failed to load the ad because app ID is missing.");
            this.zzb.zzA().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzeke
                @Override // java.lang.Runnable
                public final void run() {
                    zzekj.this.zzf();
                }
            });
            return false;
        } else if (str == null) {
            zzbzr.zzg("Ad unit ID should not be null for NativeAdLoader.");
            this.zzb.zzA().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzekf
                @Override // java.lang.Runnable
                public final void run() {
                    zzekj.this.zzg();
                }
            });
            return false;
        } else {
            zzfbc.zza(this.zzc, zzlVar.zzf);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziu)).booleanValue() && zzlVar.zzf) {
                this.zzb.zzj().zzm(true);
            }
            int i4 = ((zzekd) zzekaVar).zza;
            zzfag zzfagVar = this.zza;
            zzfagVar.zzE(zzlVar);
            zzfagVar.zzz(i4);
            zzfai zzG = zzfagVar.zzG();
            zzffn zzb = zzffm.zzb(this.zzc, zzffx.zzf(zzG), 8, zzlVar);
            com.google.android.gms.ads.internal.client.zzcb zzcbVar = zzG.zzn;
            if (zzcbVar != null) {
                this.zzd.zzd().zzi(zzcbVar);
            }
            zzdfj zzg = this.zzb.zzg();
            zzcuo zzcuoVar = new zzcuo();
            zzcuoVar.zze(this.zzc);
            zzcuoVar.zzi(zzG);
            zzg.zzf(zzcuoVar.zzj());
            zzdar zzdarVar = new zzdar();
            zzdarVar.zzk(this.zzd.zzd(), this.zzb.zzA());
            zzg.zze(zzdarVar.zzn());
            zzg.zzd(this.zzd.zzc());
            zzg.zzc(new zzcoy(null));
            zzdfk zzg2 = zzg.zzg();
            if (((Boolean) zzbcy.zzc.zze()).booleanValue()) {
                zzffy zzf = zzg2.zzf();
                zzf.zzh(8);
                zzf.zzb(zzlVar.zzp);
                zzffyVar = zzf;
            } else {
                zzffyVar = null;
            }
            this.zzb.zzw().zzc(1);
            zzfwn zzfwnVar = zzcae.zza;
            zzgwm.zzb(zzfwnVar);
            ScheduledExecutorService zzB = this.zzb.zzB();
            zzcsk zza = zzg2.zza();
            zzcrr zzcrrVar = new zzcrr(zzfwnVar, zzB, zza.zzi(zza.zzj()));
            this.zzf = zzcrrVar;
            zzcrrVar.zze(new zzeki(this, zzekbVar, zzffyVar, zzb, zzg2));
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzf() {
        this.zzd.zza().zza(zzfbi.zzd(4, null, null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzg() {
        this.zzd.zza().zza(zzfbi.zzd(6, null, null));
    }
}
