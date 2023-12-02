package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzegk implements zzece {
    private final Map zza = new HashMap();
    private final zzdnv zzb;

    public zzegk(zzdnv zzdnvVar) {
        this.zzb = zzdnvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzece
    @Nullable
    public final zzecf zza(String str, JSONObject jSONObject) throws zzfan {
        zzecf zzecfVar;
        synchronized (this) {
            zzecfVar = (zzecf) this.zza.get(str);
            if (zzecfVar == null) {
                zzecfVar = new zzecf(this.zzb.zzc(str, jSONObject), new zzedz(), str);
                this.zza.put(str, zzecfVar);
            }
        }
        return zzecfVar;
    }
}
