package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.core.os.EnvironmentCompat;
import com.arlosoft.macrodroid.helper.HelperCommandsKt;
import java.io.StringReader;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdvg {
    private final zzcgu zza;
    private final Context zzb;
    private final zzbzx zzc;
    private final zzfai zzd;
    private final Executor zze;
    private final String zzf;
    private final zzffy zzg;
    private final zzfau zzh;
    private final zzdpv zzi;

    public zzdvg(zzcgu zzcguVar, Context context, zzbzx zzbzxVar, zzfai zzfaiVar, Executor executor, String str, zzffy zzffyVar, zzdpv zzdpvVar) {
        this.zza = zzcguVar;
        this.zzb = context;
        this.zzc = zzbzxVar;
        this.zzd = zzfaiVar;
        this.zze = executor;
        this.zzf = str;
        this.zzg = zzffyVar;
        this.zzh = zzcguVar.zzv();
        this.zzi = zzdpvVar;
    }

    private final zzfwm zzc(final String str, final String str2) {
        zzffn zza = zzffm.zza(this.zzb, 11);
        zza.zzh();
        zzbmz zza2 = com.google.android.gms.ads.internal.zzt.zzf().zza(this.zzb, this.zzc, this.zza.zzy());
        zzbmt zzbmtVar = zzbmw.zza;
        final zzbmp zza3 = zza2.zza("google.afma.response.normalize", zzbmtVar, zzbmtVar);
        zzfwm zzm = zzfwc.zzm(zzfwc.zzm(zzfwc.zzm(zzfwc.zzh(""), new zzfvj() { // from class: com.google.android.gms.internal.ads.zzdvd
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj) {
                String str3 = str;
                String str4 = str2;
                String str5 = (String) obj;
                JSONObject jSONObject = new JSONObject();
                JSONObject jSONObject2 = new JSONObject();
                JSONObject jSONObject3 = new JSONObject();
                try {
                    jSONObject3.put("headers", new JSONObject());
                    jSONObject3.put("body", str3);
                    jSONObject2.put("base_url", "");
                    jSONObject2.put("signals", new JSONObject(str4));
                    jSONObject.put("request", jSONObject2);
                    jSONObject.put("response", jSONObject3);
                    jSONObject.put("flags", new JSONObject());
                    return zzfwc.zzh(jSONObject);
                } catch (JSONException e4) {
                    throw new JSONException("Preloaded loader: ".concat(String.valueOf(e4.getCause())));
                }
            }
        }, this.zze), new zzfvj() { // from class: com.google.android.gms.internal.ads.zzdve
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj) {
                return zzbmp.this.zzb((JSONObject) obj);
            }
        }, this.zze), new zzfvj() { // from class: com.google.android.gms.internal.ads.zzdvf
            @Override // com.google.android.gms.internal.ads.zzfvj
            public final zzfwm zza(Object obj) {
                return zzdvg.this.zzb((JSONObject) obj);
            }
        }, this.zze);
        zzffx.zza(zzm, this.zzg, zza);
        return zzm;
    }

    private final String zzd(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONArray jSONArray = jSONObject.getJSONArray("ad_types");
            if (jSONArray != null && EnvironmentCompat.MEDIA_UNKNOWN.equals(jSONArray.getString(0))) {
                jSONObject.put("ad_types", new JSONArray().put(this.zzf));
            }
            return jSONObject.toString();
        } catch (JSONException e4) {
            zzbzr.zzj("Failed to update the ad types for rendering. ".concat(e4.toString()));
            return str;
        }
    }

    private static final String zze(String str) {
        try {
            return new JSONObject(str).optString(HelperCommandsKt.HELPER_COMMAND_REQUEST_ID, "");
        } catch (JSONException unused) {
            return "";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.ads.zzfwm zza() {
        /*
            Method dump skipped, instructions count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdvg.zza():com.google.android.gms.internal.ads.zzfwm");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzb(JSONObject jSONObject) throws Exception {
        return zzfwc.zzh(new zzezz(new zzezw(this.zzd), zzezy.zza(new StringReader(jSONObject.toString()))));
    }
}
