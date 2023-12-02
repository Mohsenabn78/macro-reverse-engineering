package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaep  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzaep extends zzael {
    private static final String zza = "zzaep";
    @Nullable
    private String zzb;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzael, com.google.android.gms.internal.p002firebaseauthapi.zzabd
    public final /* bridge */ /* synthetic */ zzabd zza(String str) throws zzyt {
        zzd(str);
        return this;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzael
    public final /* bridge */ /* synthetic */ zzael zzb(String str) throws zzyt {
        zzd(str);
        return this;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzael
    @Nullable
    public final String zzc() {
        return this.zzb;
    }

    public final zzaep zzd(String str) throws zzyt {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("phoneSessionInfo");
            if (optJSONObject != null) {
                this.zzb = zzac.zza(optJSONObject.optString("sessionInfo"));
            }
            return this;
        } catch (NullPointerException | JSONException e4) {
            throw zzafg.zza(e4, zza, str);
        }
    }
}
