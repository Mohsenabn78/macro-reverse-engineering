package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdyz {
    private final zzbup zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzdyz(zzbup zzbupVar) {
        this.zza = zzbupVar;
    }

    public static void zza(Map map, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        JSONObject optJSONObject = jSONObject.optJSONObject("pii");
        if (optJSONObject != null) {
            if (!TextUtils.isEmpty(optJSONObject.optString("doritos", ""))) {
                map.put("x-afma-drt-cookie", optJSONObject.optString("doritos", ""));
            }
            if (!TextUtils.isEmpty(optJSONObject.optString("doritos_v2", ""))) {
                map.put("x-afma-drt-v2-cookie", optJSONObject.optString("doritos_v2", ""));
                return;
            }
            return;
        }
        com.google.android.gms.ads.internal.util.zze.zza("DSID signal does not exist.");
    }

    public final void zzb() {
        zzcah.zza(this.zza.zza(), "persistFlags");
    }
}
