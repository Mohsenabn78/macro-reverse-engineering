package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcmh {
    private final Map zza;
    private final Map zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcmh(Map map, Map map2) {
        this.zza = map;
        this.zzb = map2;
    }

    public final void zza(zzezz zzezzVar) throws Exception {
        for (zzezx zzezxVar : zzezzVar.zzb.zzc) {
            if (this.zza.containsKey(zzezxVar.zza)) {
                ((zzcmk) this.zza.get(zzezxVar.zza)).zza(zzezxVar.zzb);
            } else if (this.zzb.containsKey(zzezxVar.zza)) {
                zzcmj zzcmjVar = (zzcmj) this.zzb.get(zzezxVar.zza);
                JSONObject jSONObject = zzezxVar.zzb;
                HashMap hashMap = new HashMap();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String optString = jSONObject.optString(next);
                    if (optString != null) {
                        hashMap.put(next, optString);
                    }
                }
                zzcmjVar.zza(hashMap);
            }
        }
    }
}
