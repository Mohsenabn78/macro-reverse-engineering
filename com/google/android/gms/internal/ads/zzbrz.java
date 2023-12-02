package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbrz {
    public final boolean zza;
    public final String zzb;

    public zzbrz(boolean z3, String str) {
        this.zza = z3;
        this.zzb = str;
    }

    @Nullable
    public static zzbrz zza(JSONObject jSONObject) {
        return new zzbrz(jSONObject.optBoolean("enable_prewarming", false), jSONObject.optString("prefetch_url", ""));
    }
}
