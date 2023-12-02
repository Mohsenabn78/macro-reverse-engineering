package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacv  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzacv implements zzabd {
    private static final String zza = "zzacv";
    private String zzb;
    private String zzc;
    private zzaes zzd = new zzaes(null);
    private List zze;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabd
    public final /* bridge */ /* synthetic */ zzabd zza(String str) throws zzyt {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = jSONObject.optString("authUri", null);
            jSONObject.optBoolean("registered", false);
            this.zzc = jSONObject.optString("providerId", null);
            jSONObject.optBoolean("forExistingProvider", false);
            if (jSONObject.has("allProviders")) {
                this.zzd = new zzaes(1, zzafg.zzb(jSONObject.optJSONArray("allProviders")));
            } else {
                this.zzd = new zzaes(null);
            }
            this.zze = zzafg.zzb(jSONObject.optJSONArray("signinMethods"));
            return this;
        } catch (NullPointerException | JSONException e4) {
            throw zzafg.zza(e4, zza, str);
        }
    }

    @Nullable
    public final List zzb() {
        return this.zze;
    }
}
