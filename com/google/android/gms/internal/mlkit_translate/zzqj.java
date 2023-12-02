package com.google.android.gms.internal.mlkit_translate;

import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzqj {
    private JSONObject zza = new JSONObject();
    private Date zzb = zzqk.zzb();
    private JSONArray zzc = new JSONArray();

    private zzqj() {
    }

    public final zzqj zza(JSONObject jSONObject) {
        try {
            this.zza = new JSONObject(jSONObject.toString());
        } catch (JSONException unused) {
        }
        return this;
    }

    public final zzqj zzb(JSONArray jSONArray) {
        try {
            this.zzc = new JSONArray(jSONArray.toString());
        } catch (JSONException unused) {
        }
        return this;
    }

    public final zzqj zzc(Date date) {
        this.zzb = date;
        return this;
    }

    public final zzqk zzd() throws JSONException {
        return new zzqk(this.zza, this.zzb, this.zzc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzqj(zzqi zzqiVar) {
    }
}
