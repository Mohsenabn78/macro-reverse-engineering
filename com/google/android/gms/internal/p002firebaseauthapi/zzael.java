package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzael  reason: invalid package */
/* loaded from: classes4.dex */
public class zzael implements zzabd {
    private static final String zza = "zzael";

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabd
    /* renamed from: zzb */
    public zzael zza(String str) throws zzyt {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optJSONObject("phoneSessionInfo") != null) {
                zzaep zzaepVar = new zzaep();
                zzaepVar.zzd(str);
                return zzaepVar;
            } else if (jSONObject.optJSONObject("totpSessionInfo") != null) {
                zzaer zzaerVar = new zzaer();
                zzaerVar.zzg(str);
                return zzaerVar;
            } else {
                throw new IllegalArgumentException("Missing phoneSessionInfo or totpSessionInfo.");
            }
        } catch (NullPointerException | JSONException e4) {
            throw zzafg.zza(e4, zza, str);
        }
    }

    @Nullable
    public String zzc() {
        return null;
    }
}
