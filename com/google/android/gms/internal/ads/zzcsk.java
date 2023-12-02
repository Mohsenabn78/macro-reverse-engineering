package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcsk {
    private final zzdvg zza;
    private final zzfai zzb;
    private final zzfel zzc;
    private final zzcmh zzd;
    private final zzefw zze;
    private final zzdal zzf;
    @Nullable
    private zzezz zzg;
    private final zzdwl zzh;
    private final zzcuk zzi;
    private final Executor zzj;
    private final zzdvx zzk;
    private final zzech zzl;
    private final zzdxb zzm;
    private final zzdxi zzn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcsk(zzdvg zzdvgVar, zzfai zzfaiVar, zzfel zzfelVar, zzcmh zzcmhVar, zzefw zzefwVar, zzdal zzdalVar, @Nullable zzezz zzezzVar, zzdwl zzdwlVar, zzcuk zzcukVar, Executor executor, zzdvx zzdvxVar, zzech zzechVar, zzdxb zzdxbVar, zzdxi zzdxiVar) {
        this.zza = zzdvgVar;
        this.zzb = zzfaiVar;
        this.zzc = zzfelVar;
        this.zzd = zzcmhVar;
        this.zze = zzefwVar;
        this.zzf = zzdalVar;
        this.zzg = zzezzVar;
        this.zzh = zzdwlVar;
        this.zzi = zzcukVar;
        this.zzj = executor;
        this.zzk = zzdvxVar;
        this.zzl = zzechVar;
        this.zzm = zzdxbVar;
        this.zzn = zzdxiVar;
    }

    public final com.google.android.gms.ads.internal.client.zze zza(Throwable th) {
        return zzfbi.zzb(th, this.zzl);
    }

    public final zzdal zzc() {
        return this.zzf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzezz zzd(zzezz zzezzVar) throws Exception {
        this.zzd.zza(zzezzVar);
        return zzezzVar;
    }

    public final zzfwm zze(final zzfcb zzfcbVar) {
        zzfdq zza = this.zzc.zzb(zzfef.GET_CACHE_KEY, this.zzi.zzc()).zzf(new zzfvj() { // from class: com.google.android.gms.internal.ads.zzcsh
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj) {
                return zzcsk.this.zzf(zzfcbVar, (zzbue) obj);
            }
        }).zza();
        zzfwc.zzq(zza, new zzcsi(this), this.zzj);
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzf(zzfcb zzfcbVar, zzbue zzbueVar) throws Exception {
        zzbueVar.zzi = zzfcbVar;
        return this.zzh.zza(zzbueVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzg(zzfwm zzfwmVar, zzfwm zzfwmVar2, zzfwm zzfwmVar3) throws Exception {
        return this.zzn.zzc((zzbue) zzfwmVar.get(), (JSONObject) zzfwmVar2.get(), (zzbuh) zzfwmVar3.get());
    }

    public final zzfwm zzh(zzbue zzbueVar) {
        zzfdq zza = this.zzc.zzb(zzfef.NOTIFY_CACHE_HIT, this.zzh.zzg(zzbueVar)).zza();
        zzfwc.zzq(zza, new zzcsj(this), this.zzj);
        return zza;
    }

    public final zzfwm zzi(zzfwm zzfwmVar) {
        zzfec zzf = this.zzc.zzb(zzfef.RENDERER, zzfwmVar).zze(new zzfdo() { // from class: com.google.android.gms.internal.ads.zzcsg
            @Override // com.google.android.gms.internal.ads.zzfdo
            public final Object zza(Object obj) {
                zzezz zzezzVar = (zzezz) obj;
                zzcsk.this.zzd(zzezzVar);
                return zzezzVar;
            }
        }).zzf(this.zze);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfl)).booleanValue()) {
            zzf = zzf.zzi(((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfm)).intValue(), TimeUnit.SECONDS);
        }
        return zzf.zza();
    }

    public final zzfwm zzj() {
        com.google.android.gms.ads.internal.client.zzl zzlVar = this.zzb.zzd;
        if (zzlVar.zzx == null && zzlVar.zzs == null) {
            return zzk(this.zzi.zzc());
        }
        zzfel zzfelVar = this.zzc;
        return zzfdv.zzc(this.zza.zza(), zzfef.PRELOADED_LOADER, zzfelVar).zza();
    }

    public final zzfwm zzk(final zzfwm zzfwmVar) {
        zzezz zzezzVar = this.zzg;
        if (zzezzVar != null) {
            return zzfdv.zzc(zzfwc.zzh(zzezzVar), zzfef.SERVER_TRANSACTION, this.zzc).zza();
        }
        com.google.android.gms.ads.internal.zzt.zzc().zzj();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzjT)).booleanValue() && !((Boolean) zzbdk.zzb.zze()).booleanValue()) {
            final zzdxb zzdxbVar = this.zzm;
            final zzfwm zzm = zzfwc.zzm(zzfwmVar, new zzfvj() { // from class: com.google.android.gms.internal.ads.zzcsb
                @Override // com.google.android.gms.internal.ads.zzfvj
                public final zzfwm zza(Object obj) {
                    return zzdxb.this.zza((zzbue) obj);
                }
            }, this.zzj);
            zzfec zzb = this.zzc.zzb(zzfef.BUILD_URL, zzm);
            final zzdwl zzdwlVar = this.zzh;
            final zzfdq zza = zzb.zzf(new zzfvj() { // from class: com.google.android.gms.internal.ads.zzcsc
                @Override // com.google.android.gms.internal.ads.zzfvj
                public final zzfwm zza(Object obj) {
                    return zzdwl.this.zzb((JSONObject) obj);
                }
            }).zza();
            return this.zzc.zza(zzfef.SERVER_TRANSACTION, zzfwmVar, zzm, zza).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzcsd
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return zzcsk.this.zzg(zzfwmVar, zzm, zza);
                }
            }).zzf(new zzfvj() { // from class: com.google.android.gms.internal.ads.zzcse
                @Override // com.google.android.gms.internal.ads.zzfvj
                public final zzfwm zza(Object obj) {
                    return (zzfwm) obj;
                }
            }).zza();
        }
        zzfec zzb2 = this.zzc.zzb(zzfef.SERVER_TRANSACTION, zzfwmVar);
        final zzdvx zzdvxVar = this.zzk;
        return zzb2.zzf(new zzfvj() { // from class: com.google.android.gms.internal.ads.zzcsf
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj) {
                return zzdvx.this.zzb((zzbue) obj);
            }
        }).zza();
    }

    public final void zzl(zzezz zzezzVar) {
        this.zzg = zzezzVar;
    }
}
