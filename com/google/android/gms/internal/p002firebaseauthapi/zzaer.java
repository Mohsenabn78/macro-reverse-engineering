package com.google.android.gms.internal.p002firebaseauthapi;

import android.util.Log;
import androidx.annotation.Nullable;
import java.text.ParseException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaer  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzaer extends zzael {
    private static final String zza = "zzaer";
    @Nullable
    private String zzb;
    @Nullable
    private String zzc;
    private int zzd;
    @Nullable
    private String zze;
    private int zzf;
    private long zzg;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzael, com.google.android.gms.internal.p002firebaseauthapi.zzabd
    public final /* bridge */ /* synthetic */ zzabd zza(String str) throws zzyt {
        zzg(str);
        return this;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzael
    public final /* bridge */ /* synthetic */ zzael zzb(String str) throws zzyt {
        zzg(str);
        return this;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzael
    @Nullable
    public final String zzc() {
        return this.zzb;
    }

    public final int zzd() {
        return this.zzf;
    }

    public final int zze() {
        return this.zzd;
    }

    public final long zzf() {
        return this.zzg;
    }

    public final zzaer zzg(String str) throws zzyt {
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("totpSessionInfo");
            if (optJSONObject != null) {
                this.zzc = zzac.zza(optJSONObject.optString("sharedSecretKey"));
                this.zzd = optJSONObject.optInt("verificationCodeLength");
                this.zze = zzac.zza(optJSONObject.optString("hashingAlgorithm"));
                this.zzf = optJSONObject.optInt("periodSec");
                this.zzb = zzac.zza(optJSONObject.optString("sessionInfo"));
                String optString = optJSONObject.optString("finalizeEnrollmentTime");
                try {
                    zzajm zzb = zzakh.zzb(optString);
                    zzakh.zza(zzb);
                    this.zzg = zzb.zzb();
                } catch (ParseException unused) {
                    String str2 = zza;
                    Log.e(str2, "Failed to parse timestamp: " + optString);
                }
            }
            return this;
        } catch (NullPointerException | JSONException e4) {
            throw zzafg.zza(e4, zza, str);
        }
    }

    @Nullable
    public final String zzh() {
        return this.zze;
    }

    @Nullable
    public final String zzi() {
        return this.zzc;
    }
}
