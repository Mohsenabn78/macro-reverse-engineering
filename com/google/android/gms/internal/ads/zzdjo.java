package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdjo {
    private final zzfwn zza;
    private final zzdkb zzb;
    private final zzdkg zzc;

    public zzdjo(zzfwn zzfwnVar, zzdkb zzdkbVar, zzdkg zzdkgVar) {
        this.zza = zzfwnVar;
        this.zzb = zzdkbVar;
        this.zzc = zzdkgVar;
    }

    public final zzfwm zza(final zzezz zzezzVar, final zzezn zzeznVar, final JSONObject jSONObject) {
        zzfwm zzm;
        final zzfwm zzb = this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzdjm
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String str;
                zzezz zzezzVar2 = zzezzVar;
                zzezn zzeznVar2 = zzeznVar;
                JSONObject jSONObject2 = jSONObject;
                zzdha zzdhaVar = new zzdha();
                zzdhaVar.zzY(jSONObject2.optInt("template_id", -1));
                zzdhaVar.zzJ(jSONObject2.optString("custom_template_id"));
                JSONObject optJSONObject = jSONObject2.optJSONObject("omid_settings");
                if (optJSONObject != null) {
                    str = optJSONObject.optString("omid_partner_name");
                } else {
                    str = null;
                }
                zzdhaVar.zzU(str);
                zzfai zzfaiVar = zzezzVar2.zza.zza;
                if (zzfaiVar.zzg.contains(Integer.toString(zzdhaVar.zzc()))) {
                    if (zzdhaVar.zzc() == 3) {
                        if (zzdhaVar.zzz() != null) {
                            if (!zzfaiVar.zzh.contains(zzdhaVar.zzz())) {
                                throw new zzefu(1, "Unexpected custom template id in the response.");
                            }
                        } else {
                            throw new zzefu(1, "No custom template id for custom template ad response.");
                        }
                    }
                    zzdhaVar.zzW(jSONObject2.optDouble("rating", -1.0d));
                    String optString = jSONObject2.optString("headline", null);
                    if (zzeznVar2.zzN) {
                        com.google.android.gms.ads.internal.zzt.zzp();
                        optString = com.google.android.gms.ads.internal.util.zzs.zzu() + " : " + optString;
                    }
                    zzdhaVar.zzX("headline", optString);
                    zzdhaVar.zzX("body", jSONObject2.optString("body", null));
                    zzdhaVar.zzX("call_to_action", jSONObject2.optString("call_to_action", null));
                    zzdhaVar.zzX("store", jSONObject2.optString("store", null));
                    zzdhaVar.zzX(FirebaseAnalytics.Param.PRICE, jSONObject2.optString(FirebaseAnalytics.Param.PRICE, null));
                    zzdhaVar.zzX("advertiser", jSONObject2.optString("advertiser", null));
                    return zzdhaVar;
                }
                throw new zzefu(1, "Invalid template ID: " + zzdhaVar.zzc());
            }
        });
        final zzfwm zzf = this.zzb.zzf(jSONObject, "images");
        final zzfwm zzg = this.zzb.zzg(jSONObject, "images", zzeznVar, zzezzVar.zzb.zzb);
        final zzfwm zze = this.zzb.zze(jSONObject, "secondary_image");
        final zzfwm zze2 = this.zzb.zze(jSONObject, "app_icon");
        final zzfwm zzd = this.zzb.zzd(jSONObject, "attribution");
        final zzfwm zzh = this.zzb.zzh(jSONObject, zzeznVar, zzezzVar.zzb.zzb);
        final zzfwm zza = this.zzc.zza(jSONObject, "custom_assets");
        final zzdkb zzdkbVar = this.zzb;
        if (!jSONObject.optBoolean("enable_omid")) {
            zzm = zzfwc.zzh(null);
        } else {
            JSONObject optJSONObject = jSONObject.optJSONObject("omid_settings");
            if (optJSONObject == null) {
                zzm = zzfwc.zzh(null);
            } else {
                final String optString = optJSONObject.optString("omid_html");
                if (TextUtils.isEmpty(optString)) {
                    zzm = zzfwc.zzh(null);
                } else {
                    zzm = zzfwc.zzm(zzfwc.zzh(null), new zzfvj() { // from class: com.google.android.gms.internal.ads.zzdjq
                        @Override // com.google.android.gms.internal.ads.zzfvj
                        public final zzfwm zza(Object obj) {
                            return zzdkb.this.zzc(optString, obj);
                        }
                    }, zzcae.zze);
                }
            }
        }
        final zzfwm zzfwmVar = zzm;
        ArrayList arrayList = new ArrayList();
        arrayList.add(zzb);
        arrayList.add(zzf);
        arrayList.add(zzg);
        arrayList.add(zze);
        arrayList.add(zze2);
        arrayList.add(zzd);
        arrayList.add(zzh);
        arrayList.add(zza);
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzeS)).booleanValue()) {
            arrayList.add(zzfwmVar);
        }
        return zzfwc.zza(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzdjn
            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzfwm zzfwmVar2 = zzb;
                zzfwm zzfwmVar3 = zzf;
                zzfwm zzfwmVar4 = zze2;
                zzfwm zzfwmVar5 = zze;
                zzfwm zzfwmVar6 = zzd;
                JSONObject jSONObject2 = jSONObject;
                zzfwm zzfwmVar7 = zzh;
                zzfwm zzfwmVar8 = zzg;
                zzfwm zzfwmVar9 = zzfwmVar;
                zzfwm zzfwmVar10 = zza;
                zzdha zzdhaVar = (zzdha) zzfwmVar2.get();
                zzdhaVar.zzO((List) zzfwmVar3.get());
                zzdhaVar.zzL((zzber) zzfwmVar4.get());
                zzdhaVar.zzP((zzber) zzfwmVar5.get());
                zzdhaVar.zzI((zzbej) zzfwmVar6.get());
                zzdhaVar.zzR(zzdkb.zzj(jSONObject2));
                zzdhaVar.zzK(zzdkb.zzi(jSONObject2));
                zzcez zzcezVar = (zzcez) zzfwmVar7.get();
                if (zzcezVar != null) {
                    zzdhaVar.zzab(zzcezVar);
                    zzdhaVar.zzaa(zzcezVar.zzF());
                    zzdhaVar.zzZ(zzcezVar.zzq());
                }
                zzcez zzcezVar2 = (zzcez) zzfwmVar8.get();
                if (zzcezVar2 != null) {
                    zzdhaVar.zzN(zzcezVar2);
                    zzdhaVar.zzac(zzcezVar2.zzF());
                }
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzeS)).booleanValue()) {
                    zzdhaVar.zzT(zzfwmVar9);
                } else {
                    zzcez zzcezVar3 = (zzcez) zzfwmVar9.get();
                    if (zzcezVar3 != null) {
                        zzdhaVar.zzS(zzcezVar3);
                    }
                }
                for (zzdkf zzdkfVar : (List) zzfwmVar10.get()) {
                    if (zzdkfVar.zza != 1) {
                        zzdhaVar.zzM(zzdkfVar.zzb, zzdkfVar.zzd);
                    } else {
                        zzdhaVar.zzX(zzdkfVar.zzb, zzdkfVar.zzc);
                    }
                }
                return zzdhaVar;
            }
        }, this.zza);
    }
}
