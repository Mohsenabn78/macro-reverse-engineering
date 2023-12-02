package com.google.android.play.core.appupdate.internal;

import android.os.Bundle;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.play:app-update@@2.0.1 */
/* loaded from: classes5.dex */
public final class zzi {

    /* renamed from: a  reason: collision with root package name */
    private static final Set f25175a = new HashSet(Arrays.asList("app_update", "review"));

    /* renamed from: b  reason: collision with root package name */
    private static final Set f25176b = new HashSet(Arrays.asList("native", "unity"));

    /* renamed from: c  reason: collision with root package name */
    private static final Map f25177c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private static final zzm f25178d = new zzm("PlayCoreVersion");

    public static Bundle zza(String str) {
        Bundle bundle = new Bundle();
        Map zzb = zzb("app_update");
        bundle.putInt("playcore_version_code", ((Integer) zzb.get("java")).intValue());
        if (zzb.containsKey("native")) {
            bundle.putInt("playcore_native_version", ((Integer) zzb.get("native")).intValue());
        }
        if (zzb.containsKey("unity")) {
            bundle.putInt("playcore_unity_version", ((Integer) zzb.get("unity")).intValue());
        }
        return bundle;
    }

    public static synchronized Map zzb(String str) {
        Map map;
        synchronized (zzi.class) {
            Map map2 = f25177c;
            if (!map2.containsKey("app_update")) {
                HashMap hashMap = new HashMap();
                hashMap.put("java", 11004);
                map2.put("app_update", hashMap);
            }
            map = (Map) map2.get("app_update");
        }
        return map;
    }
}
