package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import androidx.autofill.HintConstants;
import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafc  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzafc implements zzabc {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private boolean zzf;

    private zzafc() {
    }

    public static zzafc zzb(String str, String str2, boolean z3) {
        zzafc zzafcVar = new zzafc();
        zzafcVar.zzb = Preconditions.checkNotEmpty(str);
        zzafcVar.zzc = Preconditions.checkNotEmpty(str2);
        zzafcVar.zzf = z3;
        return zzafcVar;
    }

    public static zzafc zzc(String str, String str2, boolean z3) {
        zzafc zzafcVar = new zzafc();
        zzafcVar.zza = Preconditions.checkNotEmpty(str);
        zzafcVar.zzd = Preconditions.checkNotEmpty(str2);
        zzafcVar.zzf = z3;
        return zzafcVar;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabc
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (!TextUtils.isEmpty(this.zzd)) {
            jSONObject.put(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, this.zza);
            jSONObject.put("temporaryProof", this.zzd);
        } else {
            jSONObject.put("sessionInfo", this.zzb);
            jSONObject.put("code", this.zzc);
        }
        String str = this.zze;
        if (str != null) {
            jSONObject.put("idToken", str);
        }
        if (!this.zzf) {
            jSONObject.put("operation", 2);
        }
        return jSONObject.toString();
    }

    public final void zzd(String str) {
        this.zze = str;
    }
}
