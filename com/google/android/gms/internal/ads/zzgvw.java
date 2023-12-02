package com.google.android.gms.internal.ads;

import org.objenesis.strategy.PlatformDescription;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzgvw {
    public static zzgvw zzb(Class cls) {
        if (System.getProperty("java.vm.name").equalsIgnoreCase(PlatformDescription.DALVIK)) {
            return new zzgvr(cls.getSimpleName());
        }
        return new zzgvt(cls.getSimpleName());
    }

    public abstract void zza(String str);
}
