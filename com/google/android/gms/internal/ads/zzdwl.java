package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdwl {
    private final zzfwn zza;
    private final zzdvr zzb;
    private final zzgvy zzc;
    private final zzfgb zzd;
    private final Context zze;
    private final zzbzx zzf;

    public zzdwl(zzfwn zzfwnVar, zzdvr zzdvrVar, zzgvy zzgvyVar, zzfgb zzfgbVar, Context context, zzbzx zzbzxVar) {
        this.zza = zzfwnVar;
        this.zzb = zzdvrVar;
        this.zzc = zzgvyVar;
        this.zzd = zzfgbVar;
        this.zze = context;
        this.zzf = zzbzxVar;
    }

    private final zzfwm zzh(final zzbue zzbueVar, zzdwk zzdwkVar, final zzdwk zzdwkVar2, final zzfvj zzfvjVar) {
        zzfwm zzf;
        String str = zzbueVar.zzd;
        com.google.android.gms.ads.internal.zzt.zzp();
        if (com.google.android.gms.ads.internal.util.zzs.zzy(str)) {
            zzf = zzfwc.zzg(new zzdwa(1));
        } else {
            zzf = zzfwc.zzf(zzdwkVar.zza(zzbueVar), ExecutionException.class, new zzfvj() { // from class: com.google.android.gms.internal.ads.zzdwb
                @Override // com.google.android.gms.internal.ads.zzfvj
                public final zzfwm zza(Object obj) {
                    Throwable th = (ExecutionException) obj;
                    if (th.getCause() != null) {
                        th = th.getCause();
                    }
                    return zzfwc.zzg(th);
                }
            }, this.zza);
        }
        return zzfwc.zzf(zzfwc.zzm(zzfvt.zzv(zzf), zzfvjVar, this.zza), zzdwa.class, new zzfvj() { // from class: com.google.android.gms.internal.ads.zzdwj
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj) {
                return zzdwl.this.zzc(zzdwkVar2, zzbueVar, zzfvjVar, (zzdwa) obj);
            }
        }, this.zza);
    }

    public final zzfwm zza(final zzbue zzbueVar) {
        zzfvj zzfvjVar = new zzfvj() { // from class: com.google.android.gms.internal.ads.zzdwg
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj) {
                zzbue zzbueVar2 = zzbue.this;
                zzbueVar2.zzj = new String(zzfuf.zza((InputStream) obj), zzfot.zzc);
                return zzfwc.zzh(zzbueVar2);
            }
        };
        final zzdvr zzdvrVar = this.zzb;
        return zzh(zzbueVar, new zzdwk() { // from class: com.google.android.gms.internal.ads.zzdwh
            @Override // com.google.android.gms.internal.ads.zzdwk
            public final zzfwm zza(zzbue zzbueVar2) {
                return zzdvr.this.zzb(zzbueVar2);
            }
        }, new zzdwk() { // from class: com.google.android.gms.internal.ads.zzdwi
            @Override // com.google.android.gms.internal.ads.zzdwk
            public final zzfwm zza(zzbue zzbueVar2) {
                return zzdwl.this.zzd(zzbueVar2);
            }
        }, zzfvjVar);
    }

    public final zzfwm zzb(JSONObject jSONObject) {
        return zzfwc.zzm(zzfvt.zzv(zzfwc.zzh(jSONObject)), com.google.android.gms.ads.internal.zzt.zzf().zza(this.zze, this.zzf, this.zzd).zza("AFMA_getAdDictionary", zzbmw.zza, new zzbmr() { // from class: com.google.android.gms.internal.ads.zzdwf
            @Override // com.google.android.gms.internal.ads.zzbmr
            public final Object zza(JSONObject jSONObject2) {
                return new zzbuh(jSONObject2);
            }
        }), this.zza);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzc(zzdwk zzdwkVar, zzbue zzbueVar, zzfvj zzfvjVar, zzdwa zzdwaVar) throws Exception {
        return zzfwc.zzm(zzdwkVar.zza(zzbueVar), zzfvjVar, this.zza);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzd(zzbue zzbueVar) {
        return ((zzdyh) this.zzc.zzb()).zzb(zzbueVar, Binder.getCallingUid());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zze(zzbue zzbueVar) {
        return this.zzb.zzc(zzbueVar.zzh);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzf(zzbue zzbueVar) {
        return ((zzdyh) this.zzc.zzb()).zzi(zzbueVar.zzh);
    }

    public final zzfwm zzg(zzbue zzbueVar) {
        return zzh(zzbueVar, new zzdwk() { // from class: com.google.android.gms.internal.ads.zzdwd
            @Override // com.google.android.gms.internal.ads.zzdwk
            public final zzfwm zza(zzbue zzbueVar2) {
                return zzdwl.this.zze(zzbueVar2);
            }
        }, new zzdwk() { // from class: com.google.android.gms.internal.ads.zzdwe
            @Override // com.google.android.gms.internal.ads.zzdwk
            public final zzfwm zza(zzbue zzbueVar2) {
                return zzdwl.this.zzf(zzbueVar2);
            }
        }, new zzfvj() { // from class: com.google.android.gms.internal.ads.zzdwc
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj) {
                InputStream inputStream = (InputStream) obj;
                return zzfwc.zzh(null);
            }
        });
    }
}
