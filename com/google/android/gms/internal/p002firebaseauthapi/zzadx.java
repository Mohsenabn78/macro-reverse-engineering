package com.google.android.gms.internal.p002firebaseauthapi;

import android.util.Log;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadx  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzadx {
    private String zza;
    private String zzb;
    private String zzc;
    private Long zzd;
    private Long zze;

    public static zzadx zza(String str) throws UnsupportedEncodingException {
        try {
            zzadx zzadxVar = new zzadx();
            JSONObject jSONObject = new JSONObject(str);
            zzadxVar.zza = jSONObject.optString("iss");
            zzadxVar.zzb = jSONObject.optString("aud");
            zzadxVar.zzc = jSONObject.optString("sub");
            zzadxVar.zzd = Long.valueOf(jSONObject.optLong("iat"));
            zzadxVar.zze = Long.valueOf(jSONObject.optLong("exp"));
            jSONObject.optBoolean("is_anonymous");
            return zzadxVar;
        } catch (JSONException e4) {
            if (Log.isLoggable("JwtToken", 3)) {
                "Failed to read JwtToken from JSONObject. ".concat(e4.toString());
            }
            throw new UnsupportedEncodingException("Failed to read JwtToken from JSONObject. ".concat(e4.toString()));
        }
    }

    public final Long zzb() {
        return this.zze;
    }

    public final Long zzc() {
        return this.zzd;
    }
}
