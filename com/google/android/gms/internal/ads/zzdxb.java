package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.mlkit.nl.translate.TranslateLanguage;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdxb {
    private final zzfwn zza;
    private final zzdww zzb;
    private final zzfel zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdxb(zzfwn zzfwnVar, zzdww zzdwwVar, zzfel zzfelVar) {
        this.zza = zzfwnVar;
        this.zzb = zzdwwVar;
        this.zzc = zzfelVar;
    }

    public final zzfwm zza(final zzbue zzbueVar) {
        zzfec zzb = this.zzc.zzb(zzfef.GMS_SIGNALS, zzfwc.zzl(zzfwc.zzh(null), new zzfov() { // from class: com.google.android.gms.internal.ads.zzdwy
            @Override // com.google.android.gms.internal.ads.zzfov
            public final Object apply(Object obj) {
                zzbue zzbueVar2 = zzbue.this;
                return new zzbti(zzbueVar2.zzc, zzbueVar2.zzd, zzbueVar2.zzf, zzfpw.zzc(zzbueVar2.zza.getString(TranslateLanguage.MALAY)), -1, zzbueVar2.zzh, zzbueVar2.zze, zzbueVar2.zzk, zzbueVar2.zzl);
            }
        }, this.zza));
        final zzdww zzdwwVar = this.zzb;
        return zzfwc.zzl(zzb.zzf(new zzfvj() { // from class: com.google.android.gms.internal.ads.zzdwz
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj) {
                return zzdww.this.zzb((zzbti) obj);
            }
        }).zza(), new zzfov() { // from class: com.google.android.gms.internal.ads.zzdxa
            @Override // com.google.android.gms.internal.ads.zzfov
            public final Object apply(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                Bundle bundle = zzbueVar.zza;
                if (bundle != null) {
                    try {
                        JSONObject zzh = com.google.android.gms.ads.internal.client.zzay.zzb().zzh(bundle);
                        try {
                            com.google.android.gms.ads.internal.client.zzay.zzb().zzk(jSONObject, zzh);
                            return jSONObject;
                        } catch (JSONException unused) {
                            return zzh;
                        }
                    } catch (JSONException unused2) {
                        return jSONObject;
                    }
                }
                return jSONObject;
            }
        }, this.zza);
    }
}
