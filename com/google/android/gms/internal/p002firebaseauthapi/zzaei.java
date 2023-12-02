package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaei  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzaei implements zzabc {
    private String zza;
    private String zzb;
    @Nullable
    private final String zzc;
    @Nullable
    private String zzd;

    public zzaei(@Nullable String str) {
        this.zzc = str;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabc
    public final String zza() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String str = this.zza;
        if (str != null) {
            jSONObject.put("email", str);
        }
        String str2 = this.zzb;
        if (str2 != null) {
            jSONObject.put("password", str2);
        }
        String str3 = this.zzc;
        if (str3 != null) {
            jSONObject.put("tenantId", str3);
        }
        String str4 = this.zzd;
        if (str4 != null) {
            zzafg.zzd(jSONObject, "captchaResponse", str4);
        } else {
            zzafg.zzc(jSONObject);
        }
        return jSONObject.toString();
    }

    public zzaei(String str, String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = Preconditions.checkNotEmpty(str2);
        this.zzc = str4;
        this.zzd = str5;
    }
}
