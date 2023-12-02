package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.autofill.HintConstants;
import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadk  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzadk implements zzabd {
    private static final String zza = "zzadk";
    private zzadm zzb;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabd
    public final /* bridge */ /* synthetic */ zzabd zza(String str) throws zzyt {
        zzadm zzadmVar;
        int i4;
        zzadl zzadlVar;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("users")) {
                this.zzb = new zzadm();
            } else {
                JSONArray optJSONArray = jSONObject.optJSONArray("users");
                if (optJSONArray != null && optJSONArray.length() != 0) {
                    ArrayList arrayList = new ArrayList(optJSONArray.length());
                    boolean z3 = false;
                    int i5 = 0;
                    while (i5 < optJSONArray.length()) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i5);
                        if (jSONObject2 == null) {
                            zzadlVar = new zzadl();
                            i4 = i5;
                        } else {
                            i4 = i5;
                            zzadlVar = new zzadl(Strings.emptyToNull(jSONObject2.optString("localId", null)), Strings.emptyToNull(jSONObject2.optString("email", null)), jSONObject2.optBoolean("emailVerified", z3), Strings.emptyToNull(jSONObject2.optString("displayName", null)), Strings.emptyToNull(jSONObject2.optString("photoUrl", null)), zzaea.zza(jSONObject2.optJSONArray("providerUserInfo")), Strings.emptyToNull(jSONObject2.optString("rawPassword", null)), Strings.emptyToNull(jSONObject2.optString(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, null)), jSONObject2.optLong("createdAt", 0L), jSONObject2.optLong("lastLoginAt", 0L), false, null, zzady.zzg(jSONObject2.optJSONArray("mfaInfo")));
                        }
                        arrayList.add(zzadlVar);
                        i5 = i4 + 1;
                        z3 = false;
                    }
                    zzadmVar = new zzadm(arrayList);
                    this.zzb = zzadmVar;
                }
                zzadmVar = new zzadm(new ArrayList());
                this.zzb = zzadmVar;
            }
            return this;
        } catch (NullPointerException | JSONException e4) {
            throw zzafg.zza(e4, zza, str);
        }
    }

    public final List zzb() {
        return this.zzb.zza();
    }
}
