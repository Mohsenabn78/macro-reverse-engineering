package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdyy implements zzfdo {
    private static final Pattern zza = Pattern.compile("([^;]+=[^;]+)(;\\s|$)", 2);
    private final String zzb;
    private final zzffn zzc;
    private final zzffy zzd;

    public zzdyy(String str, zzffy zzffyVar, zzffn zzffnVar) {
        this.zzb = str;
        this.zzd = zzffyVar;
        this.zzc = zzffnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfdo
    public final /* bridge */ /* synthetic */ Object zza(Object obj) throws Exception {
        JSONObject jSONObject;
        zzbuh zzbuhVar;
        zzdtx zzdtxVar;
        zzbuh zzbuhVar2;
        zzbuh zzbuhVar3;
        zzbuh zzbuhVar4;
        zzbuh zzbuhVar5;
        zzbuh zzbuhVar6;
        zzbuh zzbuhVar7;
        zzbuh zzbuhVar8;
        JSONObject jSONObject2;
        String str;
        zzdyx zzdyxVar = (zzdyx) obj;
        jSONObject = zzdyxVar.zza;
        int optInt = jSONObject.optInt("http_timeout_millis", 60000);
        zzbuhVar = zzdyxVar.zzb;
        String str2 = "";
        if (zzbuhVar.zza() == -2) {
            HashMap hashMap = new HashMap();
            zzbuhVar2 = zzdyxVar.zzb;
            if (zzbuhVar2.zzh() && !TextUtils.isEmpty(this.zzb)) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzaL)).booleanValue()) {
                    String str3 = this.zzb;
                    if (TextUtils.isEmpty(str3)) {
                        str = "";
                    } else {
                        Matcher matcher = zza.matcher(str3);
                        str = "";
                        while (matcher.find()) {
                            String group = matcher.group(1);
                            if (group != null) {
                                Locale locale = Locale.ROOT;
                                if (group.toLowerCase(locale).startsWith("id=") || group.toLowerCase(locale).startsWith("ide=")) {
                                    if (!TextUtils.isEmpty(str)) {
                                        str = str.concat("; ");
                                    }
                                    str = str.concat(group);
                                }
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(str)) {
                        hashMap.put("Cookie", str);
                    }
                } else {
                    hashMap.put("Cookie", this.zzb);
                }
            }
            zzbuhVar3 = zzdyxVar.zzb;
            if (zzbuhVar3.zzi()) {
                jSONObject2 = zzdyxVar.zza;
                zzdyz.zza(hashMap, jSONObject2);
            }
            zzbuhVar4 = zzdyxVar.zzb;
            if (zzbuhVar4 != null) {
                zzbuhVar7 = zzdyxVar.zzb;
                if (!TextUtils.isEmpty(zzbuhVar7.zzd())) {
                    zzbuhVar8 = zzdyxVar.zzb;
                    str2 = zzbuhVar8.zzd();
                }
            }
            zzffy zzffyVar = this.zzd;
            zzffn zzffnVar = this.zzc;
            zzffnVar.zzf(true);
            zzffyVar.zza(zzffnVar);
            zzbuhVar5 = zzdyxVar.zzb;
            String zze = zzbuhVar5.zze();
            byte[] bytes = str2.getBytes(zzfot.zzc);
            zzbuhVar6 = zzdyxVar.zzb;
            return new zzdyt(zze, optInt, hashMap, bytes, "", zzbuhVar6.zzi());
        }
        if (zzbuhVar.zza() == 1) {
            if (zzbuhVar.zzf() != null) {
                str2 = TextUtils.join(", ", zzbuhVar.zzf());
                zzbzr.zzg(str2);
            }
            zzdtxVar = new zzdtx(2, "Error building request URL: ".concat(String.valueOf(str2)));
        } else {
            zzdtxVar = new zzdtx(1);
        }
        zzffy zzffyVar2 = this.zzd;
        zzffn zzffnVar2 = this.zzc;
        zzffnVar2.zzg(zzdtxVar);
        zzffnVar2.zzf(false);
        zzffyVar2.zza(zzffnVar2);
        throw zzdtxVar;
    }
}
