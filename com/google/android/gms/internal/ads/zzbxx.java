package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzbxx {
    @GuardedBy("ScionComponent.class")
    @VisibleForTesting
    static zzbxx zza;

    public static synchronized zzbxx zzd(Context context) {
        synchronized (zzbxx.class) {
            zzbxx zzbxxVar = zza;
            if (zzbxxVar != null) {
                return zzbxxVar;
            }
            Context applicationContext = context.getApplicationContext();
            zzbbm.zza(applicationContext);
            com.google.android.gms.ads.internal.util.zzg zzh = com.google.android.gms.ads.internal.zzt.zzo().zzh();
            zzh.zzr(applicationContext);
            zzbxb zzbxbVar = new zzbxb(null);
            zzbxbVar.zzb(applicationContext);
            zzbxbVar.zzc(com.google.android.gms.ads.internal.zzt.zzB());
            zzbxbVar.zza(zzh);
            zzbxbVar.zzd(com.google.android.gms.ads.internal.zzt.zzn());
            zzbxx zze = zzbxbVar.zze();
            zza = zze;
            zze.zza().zza();
            zza.zzb().zzc();
            zzbyb zzc = zza.zzc();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzar)).booleanValue()) {
                HashMap hashMap = new HashMap();
                try {
                    JSONObject jSONObject = new JSONObject((String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzat));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        HashSet hashSet = new HashSet();
                        JSONArray optJSONArray = jSONObject.optJSONArray(next);
                        if (optJSONArray != null) {
                            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                                String optString = optJSONArray.optString(i4);
                                if (optString != null) {
                                    hashSet.add(optString);
                                }
                            }
                            hashMap.put(next, hashSet);
                        }
                    }
                    for (String str : hashMap.keySet()) {
                        zzc.zzc(str);
                    }
                    zzc.zzd(new zzbxz(zzc, hashMap));
                } catch (JSONException e4) {
                    zzbzr.zzf("Failed to parse listening list", e4);
                }
            }
            return zza;
        }
    }

    abstract zzbwu zza();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract zzbwy zzb();

    abstract zzbyb zzc();
}
