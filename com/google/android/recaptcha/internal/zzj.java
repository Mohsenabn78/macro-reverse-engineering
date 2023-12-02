package com.google.android.recaptcha.internal;

import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzj {
    @NotNull
    public static final zzj zza = new zzj();
    @NotNull
    private static final ConcurrentHashMap zzb = new ConcurrentHashMap();

    private zzj() {
    }

    public static final void zza(int i4, long j4) {
        ConcurrentHashMap concurrentHashMap = zzb;
        Integer valueOf = Integer.valueOf(i4);
        Object obj = concurrentHashMap.get(valueOf);
        if (obj == null) {
            obj = new zzi();
        }
        zzi zziVar = (zzi) obj;
        zziVar.zzg(zziVar.zzb() + 1);
        zziVar.zzf(zziVar.zzd() + j4);
        zziVar.zze(Math.max(j4, zziVar.zzc()));
        concurrentHashMap.put(valueOf, zziVar);
    }
}
