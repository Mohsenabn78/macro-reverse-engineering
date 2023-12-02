package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdlx {
    private final com.google.android.gms.ads.internal.zza zzb;
    private final zzcfl zzc;
    private final Context zzd;
    private final zzdqa zze;
    private final zzfev zzf;
    private final Executor zzg;
    private final zzaqs zzh;
    private final zzbzx zzi;
    private final zzeba zzk;
    private final zzfgr zzl;
    private final zzebl zzm;
    private zzfwm zzn;
    private final zzdlk zza = new zzdlk();
    private final zzbix zzj = new zzbix();

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdlx(zzdlu zzdluVar) {
        this.zzd = zzdlu.zza(zzdluVar);
        this.zzg = zzdlu.zzk(zzdluVar);
        this.zzh = zzdlu.zzb(zzdluVar);
        this.zzi = zzdlu.zzd(zzdluVar);
        this.zzb = zzdlu.zzc(zzdluVar);
        this.zzc = zzdlu.zze(zzdluVar);
        this.zzk = zzdlu.zzg(zzdluVar);
        this.zzl = zzdlu.zzj(zzdluVar);
        this.zze = zzdlu.zzf(zzdluVar);
        this.zzf = zzdlu.zzi(zzdluVar);
        this.zzm = zzdlu.zzh(zzdluVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzcez zza(zzcez zzcezVar) {
        zzcezVar.zzad("/result", this.zzj);
        zzcgm zzN = zzcezVar.zzN();
        zzdlk zzdlkVar = this.zza;
        zzN.zzM(null, zzdlkVar, zzdlkVar, zzdlkVar, zzdlkVar, false, null, new com.google.android.gms.ads.internal.zzb(this.zzd, null, null), null, null, this.zzk, this.zzl, this.zze, this.zzf, null, null, null, null);
        return zzcezVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzc(String str, JSONObject jSONObject, zzcez zzcezVar) throws Exception {
        return this.zzj.zzb(zzcezVar, str, jSONObject);
    }

    public final synchronized zzfwm zzd(final String str, final JSONObject jSONObject) {
        zzfwm zzfwmVar = this.zzn;
        if (zzfwmVar == null) {
            return zzfwc.zzh(null);
        }
        return zzfwc.zzm(zzfwmVar, new zzfvj() { // from class: com.google.android.gms.internal.ads.zzdll
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj) {
                return zzdlx.this.zzc(str, jSONObject, (zzcez) obj);
            }
        }, this.zzg);
    }

    public final synchronized void zze(zzezn zzeznVar, zzezq zzezqVar) {
        zzfwm zzfwmVar = this.zzn;
        if (zzfwmVar == null) {
            return;
        }
        zzfwc.zzq(zzfwmVar, new zzdlr(this, zzeznVar, zzezqVar), this.zzg);
    }

    public final synchronized void zzf() {
        zzfwm zzfwmVar = this.zzn;
        if (zzfwmVar == null) {
            return;
        }
        zzfwc.zzq(zzfwmVar, new zzdln(this), this.zzg);
        this.zzn = null;
    }

    public final synchronized void zzg(String str, Map map) {
        zzfwm zzfwmVar = this.zzn;
        if (zzfwmVar == null) {
            return;
        }
        zzfwc.zzq(zzfwmVar, new zzdlq(this, "sendMessageToNativeJs", map), this.zzg);
    }

    public final synchronized void zzh() {
        final Context context = this.zzd;
        final zzbzx zzbzxVar = this.zzi;
        final String str = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzdu);
        final zzaqs zzaqsVar = this.zzh;
        final com.google.android.gms.ads.internal.zza zzaVar = this.zzb;
        final zzebl zzeblVar = this.zzm;
        zzfwm zzl = zzfwc.zzl(zzfwc.zzk(new zzfvi() { // from class: com.google.android.gms.internal.ads.zzcfi
            @Override // com.google.android.gms.internal.ads.zzfvi
            public final zzfwm zza() {
                Context context2 = context;
                zzaqs zzaqsVar2 = zzaqsVar;
                zzbzx zzbzxVar2 = zzbzxVar;
                com.google.android.gms.ads.internal.zza zzaVar2 = zzaVar;
                zzebl zzeblVar2 = zzeblVar;
                String str2 = str;
                com.google.android.gms.ads.internal.zzt.zzz();
                zzcez zza = zzcfl.zza(context2, zzcgo.zza(), "", false, false, zzaqsVar2, null, zzbzxVar2, null, null, zzaVar2, zzawz.zza(), null, null, zzeblVar2);
                final zzcai zza2 = zzcai.zza(zza);
                zza.zzN().zzA(new zzcgk() { // from class: com.google.android.gms.internal.ads.zzcfj
                    @Override // com.google.android.gms.internal.ads.zzcgk
                    public final void zza(boolean z3) {
                        zzcai.this.zzb();
                    }
                });
                zza.loadUrl(str2);
                return zza2;
            }
        }, zzcae.zze), new zzfov() { // from class: com.google.android.gms.internal.ads.zzdlm
            @Override // com.google.android.gms.internal.ads.zzfov
            public final Object apply(Object obj) {
                zzcez zzcezVar = (zzcez) obj;
                zzdlx.this.zza(zzcezVar);
                return zzcezVar;
            }
        }, this.zzg);
        this.zzn = zzl;
        zzcah.zza(zzl, "NativeJavascriptExecutor.initializeEngine");
    }

    public final synchronized void zzi(String str, zzbij zzbijVar) {
        zzfwm zzfwmVar = this.zzn;
        if (zzfwmVar == null) {
            return;
        }
        zzfwc.zzq(zzfwmVar, new zzdlo(this, str, zzbijVar), this.zzg);
    }

    public final void zzj(WeakReference weakReference, String str, zzbij zzbijVar) {
        zzi(str, new zzdlw(this, weakReference, str, zzbijVar, null));
    }

    public final synchronized void zzk(String str, zzbij zzbijVar) {
        zzfwm zzfwmVar = this.zzn;
        if (zzfwmVar == null) {
            return;
        }
        zzfwc.zzq(zzfwmVar, new zzdlp(this, str, zzbijVar), this.zzg);
    }
}
