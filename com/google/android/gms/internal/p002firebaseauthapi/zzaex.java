package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Strings;
import com.google.firebase.auth.zze;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaex  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzaex implements zzabd {
    private static final String zza = "zzaex";
    private boolean zzb;
    private String zzc;
    private String zzd;
    private long zze;
    private String zzf;
    private String zzg;
    private String zzh;
    private String zzi;
    private String zzj;
    private String zzk;
    private boolean zzl;
    private String zzm;
    private String zzn;
    private String zzo;
    private String zzp;
    private String zzq;
    private String zzr;
    private List zzs;
    private String zzt;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabd
    public final /* bridge */ /* synthetic */ zzabd zza(String str) throws zzyt {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = jSONObject.optBoolean("needConfirmation", false);
            jSONObject.optBoolean("needEmail", false);
            this.zzc = Strings.emptyToNull(jSONObject.optString("idToken", null));
            this.zzd = Strings.emptyToNull(jSONObject.optString("refreshToken", null));
            this.zze = jSONObject.optLong("expiresIn", 0L);
            this.zzf = Strings.emptyToNull(jSONObject.optString("localId", null));
            this.zzg = Strings.emptyToNull(jSONObject.optString("email", null));
            this.zzh = Strings.emptyToNull(jSONObject.optString("displayName", null));
            this.zzi = Strings.emptyToNull(jSONObject.optString("photoUrl", null));
            this.zzj = Strings.emptyToNull(jSONObject.optString("providerId", null));
            this.zzk = Strings.emptyToNull(jSONObject.optString("rawUserInfo", null));
            this.zzl = jSONObject.optBoolean("isNewUser", false);
            this.zzm = jSONObject.optString("oauthAccessToken", null);
            this.zzn = jSONObject.optString("oauthIdToken", null);
            this.zzp = Strings.emptyToNull(jSONObject.optString("errorMessage", null));
            this.zzq = Strings.emptyToNull(jSONObject.optString("pendingToken", null));
            this.zzr = Strings.emptyToNull(jSONObject.optString("tenantId", null));
            this.zzs = zzady.zzg(jSONObject.optJSONArray("mfaInfo"));
            this.zzt = Strings.emptyToNull(jSONObject.optString("mfaPendingCredential", null));
            this.zzo = Strings.emptyToNull(jSONObject.optString("oauthTokenSecret", null));
            return this;
        } catch (NullPointerException | JSONException e4) {
            throw zzafg.zza(e4, zza, str);
        }
    }

    public final long zzb() {
        return this.zze;
    }

    @Nullable
    public final zze zzc() {
        if (TextUtils.isEmpty(this.zzm) && TextUtils.isEmpty(this.zzn)) {
            return null;
        }
        return zze.zzc(this.zzj, this.zzn, this.zzm, this.zzq, this.zzo);
    }

    public final String zzd() {
        return this.zzg;
    }

    public final String zze() {
        return this.zzp;
    }

    public final String zzf() {
        return this.zzc;
    }

    public final String zzg() {
        return this.zzt;
    }

    public final String zzh() {
        return this.zzj;
    }

    public final String zzi() {
        return this.zzk;
    }

    @Nullable
    public final String zzj() {
        return this.zzd;
    }

    @Nullable
    public final String zzk() {
        return this.zzr;
    }

    public final List zzl() {
        return this.zzs;
    }

    public final boolean zzm() {
        if (!TextUtils.isEmpty(this.zzt)) {
            return true;
        }
        return false;
    }

    public final boolean zzn() {
        return this.zzb;
    }

    public final boolean zzo() {
        return this.zzl;
    }

    public final boolean zzp() {
        if (!this.zzb && TextUtils.isEmpty(this.zzp)) {
            return false;
        }
        return true;
    }
}
