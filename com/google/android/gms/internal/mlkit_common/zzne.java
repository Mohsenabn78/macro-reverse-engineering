package com.google.android.gms.internal.mlkit_common;

import androidx.annotation.Nullable;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes4.dex */
public final class zzne {
    @Nullable
    private static zzne zza;

    private zzne() {
    }

    public static synchronized zzne zza() {
        zzne zzneVar;
        synchronized (zzne.class) {
            if (zza == null) {
                zza = new zzne();
            }
            zzneVar = zza;
        }
        return zzneVar;
    }

    public static void zzb() {
        zznd.zza();
    }
}
