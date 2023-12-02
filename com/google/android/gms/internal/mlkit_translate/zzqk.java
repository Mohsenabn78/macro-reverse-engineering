package com.google.android.gms.internal.mlkit_translate;

import androidx.annotation.VisibleForTesting;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzqk {
    private static final Date zza = new Date(0);
    private final JSONObject zzb;
    private final JSONObject zzc;
    private final Date zzd;
    private final JSONArray zze;

    @VisibleForTesting
    public zzqk(JSONObject jSONObject, Date date, JSONArray jSONArray) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("configs_key", jSONObject);
        jSONObject2.put("fetch_time_key", date.getTime());
        jSONObject2.put("abt_experiments_key", jSONArray);
        this.zzc = jSONObject;
        this.zzd = date;
        this.zze = jSONArray;
        this.zzb = jSONObject2;
    }

    public static zzqj zza() {
        return new zzqj(null);
    }

    public static /* bridge */ /* synthetic */ Date zzb() {
        return zza;
    }

    public final String toString() {
        return this.zzb.toString();
    }

    public final Date zzc() {
        return this.zzd;
    }

    public final JSONObject zzd() {
        return this.zzc;
    }
}
