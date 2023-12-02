package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.NonNull;
import com.google.android.gms.common.util.Strings;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaej  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzaej implements zzabd {
    private static final String zza = "zzaej";
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private long zzf;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabd
    public final /* bridge */ /* synthetic */ zzabd zza(String str) throws zzyt {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.emptyToNull(jSONObject.optString("idToken", null));
            this.zzc = Strings.emptyToNull(jSONObject.optString("displayName", null));
            this.zzd = Strings.emptyToNull(jSONObject.optString("email", null));
            this.zze = Strings.emptyToNull(jSONObject.optString("refreshToken", null));
            this.zzf = jSONObject.optLong("expiresIn", 0L);
            return this;
        } catch (NullPointerException | JSONException e4) {
            throw zzafg.zza(e4, zza, str);
        }
    }

    public final long zzb() {
        return this.zzf;
    }

    public final String zzc() {
        return this.zzb;
    }

    @NonNull
    public final String zzd() {
        return this.zze;
    }
}
