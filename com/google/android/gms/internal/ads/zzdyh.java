package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdyh extends zzbtp {
    private final Context zza;
    private final zzfwn zzb;
    private final zzdyz zzc;
    private final zzcmg zzd;
    private final ArrayDeque zze;
    private final zzfgb zzf;
    private final zzbuq zzg;
    private final zzdyw zzh;

    public zzdyh(Context context, zzfwn zzfwnVar, zzbuq zzbuqVar, zzcmg zzcmgVar, zzdyz zzdyzVar, ArrayDeque arrayDeque, zzdyw zzdywVar, zzfgb zzfgbVar) {
        zzbbm.zza(context);
        this.zza = context;
        this.zzb = zzfwnVar;
        this.zzg = zzbuqVar;
        this.zzc = zzdyzVar;
        this.zzd = zzcmgVar;
        this.zze = arrayDeque;
        this.zzh = zzdywVar;
        this.zzf = zzfgbVar;
    }

    @Nullable
    private final synchronized zzdye zzk(String str) {
        Iterator it = this.zze.iterator();
        while (it.hasNext()) {
            zzdye zzdyeVar = (zzdye) it.next();
            if (zzdyeVar.zzc.equals(str)) {
                it.remove();
                return zzdyeVar;
            }
        }
        return null;
    }

    private static zzfwm zzl(zzfwm zzfwmVar, zzfel zzfelVar, zzbmz zzbmzVar, zzffy zzffyVar, zzffn zzffnVar) {
        zzbmp zza = zzbmzVar.zza("AFMA_getAdDictionary", zzbmw.zza, new zzbmr() { // from class: com.google.android.gms.internal.ads.zzdxy
            @Override // com.google.android.gms.internal.ads.zzbmr
            public final Object zza(JSONObject jSONObject) {
                return new zzbuh(jSONObject);
            }
        });
        zzffx.zzd(zzfwmVar, zzffnVar);
        zzfdq zza2 = zzfelVar.zzb(zzfef.BUILD_URL, zzfwmVar).zzf(zza).zza();
        zzffx.zzc(zza2, zzffyVar, zzffnVar);
        return zza2;
    }

    private static zzfwm zzm(zzbue zzbueVar, zzfel zzfelVar, final zzerq zzerqVar) {
        zzfvj zzfvjVar = new zzfvj() { // from class: com.google.android.gms.internal.ads.zzdxs
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj) {
                return zzerq.this.zzb().zza(com.google.android.gms.ads.internal.client.zzay.zzb().zzh((Bundle) obj));
            }
        };
        return zzfelVar.zzb(zzfef.GMS_SIGNALS, zzfwc.zzh(zzbueVar.zza)).zzf(zzfvjVar).zze(new zzfdo() { // from class: com.google.android.gms.internal.ads.zzdxt
            @Override // com.google.android.gms.internal.ads.zzfdo
            public final Object zza(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                com.google.android.gms.ads.internal.util.zze.zza("Ad request signals:");
                com.google.android.gms.ads.internal.util.zze.zza(jSONObject.toString(2));
                return jSONObject;
            }
        }).zza();
    }

    private final synchronized void zzn(zzdye zzdyeVar) {
        zzo();
        this.zze.addLast(zzdyeVar);
    }

    private final synchronized void zzo() {
        int intValue = ((Long) zzbdl.zzc.zze()).intValue();
        while (this.zze.size() >= intValue) {
            this.zze.removeFirst();
        }
    }

    private final void zzp(zzfwm zzfwmVar, zzbua zzbuaVar) {
        zzfwc.zzq(zzfwc.zzm(zzfwmVar, new zzfvj() { // from class: com.google.android.gms.internal.ads.zzdyb
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj) {
                return zzfwc.zzh(zzfbh.zza((InputStream) obj));
            }
        }, zzcae.zza), new zzdyd(this, zzbuaVar), zzcae.zzf);
    }

    public final zzfwm zzb(final zzbue zzbueVar, int i4) {
        if (!((Boolean) zzbdl.zza.zze()).booleanValue()) {
            return zzfwc.zzg(new Exception("Split request is disabled."));
        }
        zzfcb zzfcbVar = zzbueVar.zzi;
        if (zzfcbVar == null) {
            return zzfwc.zzg(new Exception("Pool configuration missing from request."));
        }
        if (zzfcbVar.zzc != 0 && zzfcbVar.zzd != 0) {
            zzbmz zzb = com.google.android.gms.ads.internal.zzt.zzf().zzb(this.zza, zzbzx.zza(), this.zzf);
            zzerq zzp = this.zzd.zzp(zzbueVar, i4);
            zzfel zzc = zzp.zzc();
            final zzfwm zzm = zzm(zzbueVar, zzc, zzp);
            zzffy zzd = zzp.zzd();
            final zzffn zza = zzffm.zza(this.zza, 9);
            final zzfwm zzl = zzl(zzm, zzc, zzb, zzd, zza);
            return zzc.zza(zzfef.GET_URL_AND_CACHE_KEY, zzm, zzl).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdxx
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return zzdyh.this.zzj(zzl, zzm, zzbueVar, zza);
                }
            }).zza();
        }
        return zzfwc.zzg(new Exception("Caching is disabled."));
    }

    public final zzfwm zzc(zzbue zzbueVar, int i4) {
        zzdye zzk;
        zzffn zzffnVar;
        zzfdq zza;
        zzbmz zzb = com.google.android.gms.ads.internal.zzt.zzf().zzb(this.zza, zzbzx.zza(), this.zzf);
        zzerq zzp = this.zzd.zzp(zzbueVar, i4);
        zzbmp zza2 = zzb.zza("google.afma.response.normalize", zzdyg.zza, zzbmw.zzb);
        if (!((Boolean) zzbdl.zza.zze()).booleanValue()) {
            String str = zzbueVar.zzj;
            zzk = null;
            if (str != null && !str.isEmpty()) {
                com.google.android.gms.ads.internal.util.zze.zza("Request contained a PoolKey but split request is disabled.");
            }
        } else {
            zzk = zzk(zzbueVar.zzh);
            if (zzk == null) {
                com.google.android.gms.ads.internal.util.zze.zza("Request contained a PoolKey but no matching parameters were found.");
            }
        }
        if (zzk == null) {
            zzffnVar = zzffm.zza(this.zza, 9);
        } else {
            zzffnVar = zzk.zze;
        }
        zzffy zzd = zzp.zzd();
        zzd.zzd(zzbueVar.zza.getStringArrayList("ad_types"));
        zzdyy zzdyyVar = new zzdyy(zzbueVar.zzg, zzd, zzffnVar);
        zzdyv zzdyvVar = new zzdyv(this.zza, zzbueVar.zzb.zza, this.zzg, i4);
        zzfel zzc = zzp.zzc();
        zzffn zza3 = zzffm.zza(this.zza, 11);
        if (zzk == null) {
            final zzfwm zzm = zzm(zzbueVar, zzc, zzp);
            final zzfwm zzl = zzl(zzm, zzc, zzb, zzd, zzffnVar);
            zzffn zza4 = zzffm.zza(this.zza, 10);
            final zzfdq zza5 = zzc.zza(zzfef.HTTP, zzl, zzm).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdxv
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new zzdyx((JSONObject) zzfwm.this.get(), (zzbuh) zzl.get());
                }
            }).zze(zzdyyVar).zze(new zzfft(zza4)).zze(zzdyvVar).zza();
            zzffx.zza(zza5, zzd, zza4);
            zzffx.zzd(zza5, zza3);
            zza = zzc.zza(zzfef.PRE_PROCESS, zzm, zzl, zza5).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdxw
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return new zzdyg((zzdyu) zzfwm.this.get(), (JSONObject) zzm.get(), (zzbuh) zzl.get());
                }
            }).zzf(zza2).zza();
        } else {
            zzdyx zzdyxVar = new zzdyx(zzk.zzb, zzk.zza);
            zzffn zza6 = zzffm.zza(this.zza, 10);
            final zzfdq zza7 = zzc.zzb(zzfef.HTTP, zzfwc.zzh(zzdyxVar)).zze(zzdyyVar).zze(new zzfft(zza6)).zze(zzdyvVar).zza();
            zzffx.zza(zza7, zzd, zza6);
            final zzfwm zzh = zzfwc.zzh(zzk);
            zzffx.zzd(zza7, zza3);
            zza = zzc.zza(zzfef.PRE_PROCESS, zza7, zzh).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdya
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    zzfwm zzfwmVar = zzfwm.this;
                    zzfwm zzfwmVar2 = zzh;
                    return new zzdyg((zzdyu) zzfwmVar.get(), ((zzdye) zzfwmVar2.get()).zzb, ((zzdye) zzfwmVar2.get()).zza);
                }
            }).zzf(zza2).zza();
        }
        zzffx.zza(zza, zzd, zza3);
        return zza;
    }

    public final zzfwm zzd(zzbue zzbueVar, int i4) {
        zzbmz zzb = com.google.android.gms.ads.internal.zzt.zzf().zzb(this.zza, zzbzx.zza(), this.zzf);
        if (!((Boolean) zzbdq.zza.zze()).booleanValue()) {
            return zzfwc.zzg(new Exception("Signal collection disabled."));
        }
        zzerq zzp = this.zzd.zzp(zzbueVar, i4);
        final zzerb zza = zzp.zza();
        zzbmp zza2 = zzb.zza("google.afma.request.getSignals", zzbmw.zza, zzbmw.zzb);
        zzffn zza3 = zzffm.zza(this.zza, 22);
        zzfdq zza4 = zzp.zzc().zzb(zzfef.GET_SIGNALS, zzfwc.zzh(zzbueVar.zza)).zze(new zzfft(zza3)).zzf(new zzfvj() { // from class: com.google.android.gms.internal.ads.zzdxz
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj) {
                return zzerb.this.zza(com.google.android.gms.ads.internal.client.zzay.zzb().zzh((Bundle) obj));
            }
        }).zzb(zzfef.JS_SIGNALS).zzf(zza2).zza();
        zzffy zzd = zzp.zzd();
        zzd.zzd(zzbueVar.zza.getStringArrayList("ad_types"));
        zzffx.zzb(zza4, zzd, zza3);
        if (((Boolean) zzbdf.zze.zze()).booleanValue()) {
            zzdyz zzdyzVar = this.zzc;
            zzdyzVar.getClass();
            zza4.zzc(new zzdxu(zzdyzVar), this.zzb);
        }
        return zza4;
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zze(zzbue zzbueVar, zzbua zzbuaVar) {
        zzp(zzb(zzbueVar, Binder.getCallingUid()), zzbuaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzf(zzbue zzbueVar, zzbua zzbuaVar) {
        zzp(zzd(zzbueVar, Binder.getCallingUid()), zzbuaVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzg(zzbue zzbueVar, zzbua zzbuaVar) {
        zzfwm zzc = zzc(zzbueVar, Binder.getCallingUid());
        zzp(zzc, zzbuaVar);
        if (((Boolean) zzbdf.zzc.zze()).booleanValue()) {
            zzdyz zzdyzVar = this.zzc;
            zzdyzVar.getClass();
            zzc.zzc(new zzdxu(zzdyzVar), this.zzb);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbtq
    public final void zzh(String str, zzbua zzbuaVar) {
        zzp(zzi(str), zzbuaVar);
    }

    public final zzfwm zzi(String str) {
        if (!((Boolean) zzbdl.zza.zze()).booleanValue()) {
            return zzfwc.zzg(new Exception("Split request is disabled."));
        }
        zzdyc zzdycVar = new zzdyc(this);
        if (zzk(str) == null) {
            return zzfwc.zzg(new Exception("URL to be removed not found for cache key: ".concat(String.valueOf(str))));
        }
        return zzfwc.zzh(zzdycVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ InputStream zzj(zzfwm zzfwmVar, zzfwm zzfwmVar2, zzbue zzbueVar, zzffn zzffnVar) throws Exception {
        String zzc = ((zzbuh) zzfwmVar.get()).zzc();
        String str = zzbueVar.zzh;
        zzn(new zzdye((zzbuh) zzfwmVar.get(), (JSONObject) zzfwmVar2.get(), str, zzc, zzffnVar));
        return new ByteArrayInputStream(zzc.getBytes(zzfot.zzc));
    }
}
