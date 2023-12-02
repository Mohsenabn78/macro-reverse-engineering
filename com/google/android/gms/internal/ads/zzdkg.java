package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdkg {
    private final Executor zza;
    private final zzdkb zzb;

    public zzdkg(Executor executor, zzdkb zzdkbVar) {
        this.zza = executor;
        this.zzb = zzdkbVar;
    }

    public final zzfwm zza(JSONObject jSONObject, String str) {
        zzfwm zzh;
        JSONArray optJSONArray = jSONObject.optJSONArray("custom_assets");
        if (optJSONArray == null) {
            return zzfwc.zzh(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i4 = 0; i4 < length; i4++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i4);
            if (optJSONObject == null) {
                zzh = zzfwc.zzh(null);
            } else {
                final String optString = optJSONObject.optString("name");
                if (optString == null) {
                    zzh = zzfwc.zzh(null);
                } else {
                    String optString2 = optJSONObject.optString("type");
                    if ("string".equals(optString2)) {
                        zzh = zzfwc.zzh(new zzdkf(optString, optJSONObject.optString("string_value")));
                    } else if ("image".equals(optString2)) {
                        zzh = zzfwc.zzl(this.zzb.zze(optJSONObject, "image_value"), new zzfov() { // from class: com.google.android.gms.internal.ads.zzdkd
                            @Override // com.google.android.gms.internal.ads.zzfov
                            public final Object apply(Object obj) {
                                return new zzdkf(optString, (zzbed) obj);
                            }
                        }, this.zza);
                    } else {
                        zzh = zzfwc.zzh(null);
                    }
                }
            }
            arrayList.add(zzh);
        }
        return zzfwc.zzl(zzfwc.zzd(arrayList), new zzfov() { // from class: com.google.android.gms.internal.ads.zzdke
            @Override // com.google.android.gms.internal.ads.zzfov
            public final Object apply(Object obj) {
                ArrayList arrayList2 = new ArrayList();
                for (zzdkf zzdkfVar : (List) obj) {
                    if (zzdkfVar != null) {
                        arrayList2.add(zzdkfVar);
                    }
                }
                return arrayList2;
            }
        }, this.zza);
    }
}
