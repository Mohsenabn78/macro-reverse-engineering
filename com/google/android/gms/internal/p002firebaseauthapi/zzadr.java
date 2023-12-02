package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzadr  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzadr implements zzabd {
    private static final String zza = "zzadr";
    private List zzb;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabd
    public final /* bridge */ /* synthetic */ zzabd zza(String str) throws zzyt {
        zzb(str);
        return this;
    }

    public final zzadr zzb(String str) throws zzyt {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.zzb = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONArray("authorizedDomains");
            if (optJSONArray != null) {
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    this.zzb.add(optJSONArray.getString(i4));
                }
            }
            return this;
        } catch (JSONException e4) {
            throw zzafg.zza(e4, zza, str);
        }
    }

    public final List zzc() {
        return this.zzb;
    }
}
