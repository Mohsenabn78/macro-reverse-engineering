package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadt  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzadt implements zzabd {
    private static final String zza = "zzadt";
    @Nullable
    private String zzb;
    private zzam zzc;
    private boolean zzd = false;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabd
    public final /* bridge */ /* synthetic */ zzabd zza(String str) throws zzyt {
        zzam zzh;
        String zza2;
        zzacs zzacsVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = Strings.emptyToNull(jSONObject.optString("recaptchaKey"));
            if (jSONObject.has("recaptchaEnforcementState")) {
                JSONArray optJSONArray = jSONObject.optJSONArray("recaptchaEnforcementState");
                boolean z3 = false;
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    zzaj zzajVar = new zzaj();
                    for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i4);
                        if (jSONObject2 == null) {
                            zzacsVar = new zzacs(null, null);
                        } else {
                            zzacsVar = new zzacs(Strings.emptyToNull(jSONObject2.optString("provider")), Strings.emptyToNull(jSONObject2.optString("enforcementState")));
                        }
                        zzajVar.zzb(zzacsVar);
                    }
                    zzh = zzajVar.zzc();
                    this.zzc = zzh;
                    if (zzh != null && !zzh.isEmpty()) {
                        zza2 = ((zzaeb) zzh.get(0)).zza();
                        String zzb = ((zzaeb) zzh.get(0)).zzb();
                        if (zza2 != null && zzb != null && ((zza2.equals("ENFORCE") || zza2.equals("AUDIT")) && zzb.equals("EMAIL_PASSWORD_PROVIDER"))) {
                            z3 = true;
                        }
                    }
                    this.zzd = z3;
                }
                zzh = zzam.zzh(new ArrayList());
                this.zzc = zzh;
                if (zzh != null) {
                    zza2 = ((zzaeb) zzh.get(0)).zza();
                    String zzb2 = ((zzaeb) zzh.get(0)).zzb();
                    if (zza2 != null) {
                        z3 = true;
                    }
                }
                this.zzd = z3;
            }
            return this;
        } catch (NullPointerException | JSONException e4) {
            throw zzafg.zza(e4, zza, str);
        }
    }

    @Nullable
    public final String zzb() {
        return this.zzb;
    }

    public final boolean zzc() {
        return this.zzd;
    }
}
