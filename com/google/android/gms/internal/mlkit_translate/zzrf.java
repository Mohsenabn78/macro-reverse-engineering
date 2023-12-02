package com.google.android.gms.internal.mlkit_translate;

import androidx.annotation.Nullable;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzrf {
    @Nullable
    private static zzrf zza;

    private zzrf() {
    }

    public static synchronized zzrf zza() {
        zzrf zzrfVar;
        synchronized (zzrf.class) {
            if (zza == null) {
                zza = new zzrf();
            }
            zzrfVar = zza;
        }
        return zzrfVar;
    }

    public static final boolean zzb() {
        return zzre.zza("mlkit-dev-profiling");
    }
}
