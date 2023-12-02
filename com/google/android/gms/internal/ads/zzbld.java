package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final /* synthetic */ class zzbld {
    public static void zza(zzble zzbleVar, String str, Map map) {
        try {
            zzbleVar.zze(str, com.google.android.gms.ads.internal.client.zzay.zzb().zzi(map));
        } catch (JSONException unused) {
            zzbzr.zzj("Could not convert parameters to JSON.");
        }
    }

    public static void zzb(zzble zzbleVar, String str, JSONObject jSONObject) {
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("',");
        sb.append(jSONObject2);
        sb.append(");");
        zzbzr.zze("Dispatching AFMA event: ".concat(sb.toString()));
        zzbleVar.zza(sb.toString());
    }

    public static void zzc(zzble zzbleVar, String str, String str2) {
        zzbleVar.zza(str + "(" + str2 + ");");
    }

    public static void zzd(zzble zzbleVar, String str, JSONObject jSONObject) {
        zzbleVar.zzb(str, jSONObject.toString());
    }
}
