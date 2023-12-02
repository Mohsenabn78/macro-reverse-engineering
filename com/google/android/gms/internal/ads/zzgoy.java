package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgoy {
    static final zzgoy zza = new zzgoy(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private static volatile zzgoy zzd;
    private final Map zze;

    zzgoy() {
        this.zze = new HashMap();
    }

    public static zzgoy zza() {
        return zza;
    }

    public static zzgoy zzb() {
        zzgoy zzgoyVar = zzd;
        if (zzgoyVar != null) {
            return zzgoyVar;
        }
        synchronized (zzgoy.class) {
            zzgoy zzgoyVar2 = zzd;
            if (zzgoyVar2 != null) {
                return zzgoyVar2;
            }
            zzgoy zzb2 = zzgpg.zzb(zzgoy.class);
            zzd = zzb2;
            return zzb2;
        }
    }

    public final zzgpk zzc(zzgqw zzgqwVar, int i4) {
        return (zzgpk) this.zze.get(new zzgox(zzgqwVar, i4));
    }

    zzgoy(boolean z3) {
        this.zze = Collections.emptyMap();
    }
}
