package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.google.android.gms.common.util.Strings;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafb  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzafb implements zzabd {
    private static final String zza = "zzafb";
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private String zzg;
    private long zzh;
    private List zzi;
    private String zzj;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabd
    public final /* bridge */ /* synthetic */ zzabd zza(String str) throws zzyt {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.emptyToNull(jSONObject.optString("localId", null));
            this.zzc = Strings.emptyToNull(jSONObject.optString("email", null));
            this.zzd = Strings.emptyToNull(jSONObject.optString("displayName", null));
            this.zze = Strings.emptyToNull(jSONObject.optString("idToken", null));
            this.zzf = Strings.emptyToNull(jSONObject.optString("photoUrl", null));
            this.zzg = Strings.emptyToNull(jSONObject.optString("refreshToken", null));
            this.zzh = jSONObject.optLong("expiresIn", 0L);
            this.zzi = zzady.zzg(jSONObject.optJSONArray("mfaInfo"));
            this.zzj = jSONObject.optString("mfaPendingCredential", null);
            return this;
        } catch (NullPointerException | JSONException e4) {
            throw zzafg.zza(e4, zza, str);
        }
    }

    public final long zzb() {
        return this.zzh;
    }

    @NonNull
    public final String zzc() {
        return this.zze;
    }

    public final String zzd() {
        return this.zzj;
    }

    @NonNull
    public final String zze() {
        return this.zzg;
    }

    public final List zzf() {
        return this.zzi;
    }

    public final boolean zzg() {
        if (!TextUtils.isEmpty(this.zzj)) {
            return true;
        }
        return false;
    }
}
