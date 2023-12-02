package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzevz implements zzekc {
    private final Context zza;
    private final Executor zzb;
    private final zzcgu zzc;
    private final zzejm zzd;
    private final zzejq zze;
    private final ViewGroup zzf;
    @Nullable
    private zzbck zzg;
    private final zzcxv zzh;
    private final zzfgb zzi;
    private final zzdac zzj;
    private final zzfag zzk;
    private zzfwm zzl;

    public zzevz(Context context, Executor executor, com.google.android.gms.ads.internal.client.zzq zzqVar, zzcgu zzcguVar, zzejm zzejmVar, zzejq zzejqVar, zzfag zzfagVar, zzdac zzdacVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcguVar;
        this.zzd = zzejmVar;
        this.zze = zzejqVar;
        this.zzk = zzfagVar;
        this.zzh = zzcguVar.zze();
        this.zzi = zzcguVar.zzy();
        this.zzf = new FrameLayout(context);
        this.zzj = zzdacVar;
        zzfagVar.zzr(zzqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final boolean zza() {
        zzfwm zzfwmVar = this.zzl;
        if (zzfwmVar != null && !zzfwmVar.isDone()) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzekc
    public final boolean zzb(com.google.android.gms.ads.internal.client.zzl zzlVar, String str, @Nullable zzeka zzekaVar, zzekb zzekbVar) throws RemoteException {
        zzcpy zzk;
        zzffy zzffyVar;
        if (str == null) {
            zzbzr.zzg("Ad unit ID should not be null for banner ad.");
            this.zzb.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzevv
                @Override // java.lang.Runnable
                public final void run() {
                    zzevz.this.zzm();
                }
            });
            return false;
        } else if (zza()) {
            return false;
        } else {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zziu)).booleanValue() && zzlVar.zzf) {
                this.zzc.zzj().zzm(true);
            }
            zzfag zzfagVar = this.zzk;
            zzfagVar.zzs(str);
            zzfagVar.zzE(zzlVar);
            zzfai zzG = zzfagVar.zzG();
            zzffn zzb = zzffm.zzb(this.zza, zzffx.zzf(zzG), 3, zzlVar);
            if (((Boolean) zzbdk.zzd.zze()).booleanValue() && this.zzk.zzg().zzk) {
                zzejm zzejmVar = this.zzd;
                if (zzejmVar != null) {
                    zzejmVar.zza(zzfbi.zzd(7, null, null));
                }
                return false;
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzhJ)).booleanValue()) {
                zzcpx zzd = this.zzc.zzd();
                zzcuo zzcuoVar = new zzcuo();
                zzcuoVar.zze(this.zza);
                zzcuoVar.zzi(zzG);
                zzd.zzi(zzcuoVar.zzj());
                zzdar zzdarVar = new zzdar();
                zzdarVar.zzj(this.zzd, this.zzb);
                zzdarVar.zzk(this.zzd, this.zzb);
                zzd.zzf(zzdarVar.zzn());
                zzd.zze(new zzehv(this.zzg));
                zzd.zzd(new zzdff(zzdhl.zza, null));
                zzd.zzg(new zzcqv(this.zzh, this.zzj));
                zzd.zzc(new zzcoy(this.zzf));
                zzk = zzd.zzk();
            } else {
                zzcpx zzd2 = this.zzc.zzd();
                zzcuo zzcuoVar2 = new zzcuo();
                zzcuoVar2.zze(this.zza);
                zzcuoVar2.zzi(zzG);
                zzd2.zzi(zzcuoVar2.zzj());
                zzdar zzdarVar2 = new zzdar();
                zzdarVar2.zzj(this.zzd, this.zzb);
                zzdarVar2.zza(this.zzd, this.zzb);
                zzdarVar2.zza(this.zze, this.zzb);
                zzdarVar2.zzl(this.zzd, this.zzb);
                zzdarVar2.zzd(this.zzd, this.zzb);
                zzdarVar2.zze(this.zzd, this.zzb);
                zzdarVar2.zzf(this.zzd, this.zzb);
                zzdarVar2.zzb(this.zzd, this.zzb);
                zzdarVar2.zzk(this.zzd, this.zzb);
                zzdarVar2.zzi(this.zzd, this.zzb);
                zzd2.zzf(zzdarVar2.zzn());
                zzd2.zze(new zzehv(this.zzg));
                zzd2.zzd(new zzdff(zzdhl.zza, null));
                zzd2.zzg(new zzcqv(this.zzh, this.zzj));
                zzd2.zzc(new zzcoy(this.zzf));
                zzk = zzd2.zzk();
            }
            zzcpy zzcpyVar = zzk;
            if (((Boolean) zzbcy.zzc.zze()).booleanValue()) {
                zzffy zzj = zzcpyVar.zzj();
                zzj.zzh(3);
                zzj.zzb(zzlVar.zzp);
                zzffyVar = zzj;
            } else {
                zzffyVar = null;
            }
            zzcsk zzd3 = zzcpyVar.zzd();
            zzfwm zzi = zzd3.zzi(zzd3.zzj());
            this.zzl = zzi;
            zzfwc.zzq(zzi, new zzevy(this, zzekbVar, zzffyVar, zzb, zzcpyVar), this.zzb);
            return true;
        }
    }

    public final ViewGroup zzd() {
        return this.zzf;
    }

    public final zzfag zzi() {
        return this.zzk;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzm() {
        this.zzd.zza(zzfbi.zzd(6, null, null));
    }

    public final void zzn() {
        this.zzh.zzd(this.zzj.zzc());
    }

    public final void zzo(com.google.android.gms.ads.internal.client.zzbe zzbeVar) {
        this.zze.zza(zzbeVar);
    }

    public final void zzp(zzcxw zzcxwVar) {
        this.zzh.zzm(zzcxwVar, this.zzb);
    }

    public final void zzq(zzbck zzbckVar) {
        this.zzg = zzbckVar;
    }

    public final boolean zzr() {
        ViewParent parent = this.zzf.getParent();
        if (!(parent instanceof View)) {
            return false;
        }
        View view = (View) parent;
        com.google.android.gms.ads.internal.zzt.zzp();
        return com.google.android.gms.ads.internal.util.zzs.zzS(view, view.getContext());
    }
}
