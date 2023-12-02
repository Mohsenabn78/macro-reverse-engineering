package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.autofill.HintConstants;
import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaea  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzaea {
    private final List zza;

    public zzaea() {
        this.zza = new ArrayList();
    }

    public static zzaea zza(JSONArray jSONArray) throws JSONException {
        zzadz zzadzVar;
        if (jSONArray != null && jSONArray.length() != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i4);
                if (jSONObject == null) {
                    zzadzVar = new zzadz();
                } else {
                    zzadzVar = new zzadz(Strings.emptyToNull(jSONObject.optString("federatedId", null)), Strings.emptyToNull(jSONObject.optString("displayName", null)), Strings.emptyToNull(jSONObject.optString("photoUrl", null)), Strings.emptyToNull(jSONObject.optString("providerId", null)), null, Strings.emptyToNull(jSONObject.optString(HintConstants.AUTOFILL_HINT_PHONE_NUMBER, null)), Strings.emptyToNull(jSONObject.optString("email", null)));
                }
                arrayList.add(zzadzVar);
            }
            return new zzaea(arrayList);
        }
        return new zzaea(new ArrayList());
    }

    public static zzaea zzb(zzaea zzaeaVar) {
        List list = zzaeaVar.zza;
        zzaea zzaeaVar2 = new zzaea();
        if (list != null) {
            zzaeaVar2.zza.addAll(list);
        }
        return zzaeaVar2;
    }

    public final List zzc() {
        return this.zza;
    }

    public zzaea(List list) {
        if (!list.isEmpty()) {
            this.zza = Collections.unmodifiableList(list);
        } else {
            this.zza = Collections.emptyList();
        }
    }
}
