package com.google.android.gms.internal.icing;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
public final class zzcp {
    static final zzcp zza = new zzcp(true);
    private static volatile boolean zzb = false;
    private static volatile zzcp zzc;
    private final Map zzd;

    zzcp() {
        this.zzd = new HashMap();
    }

    public static zzcp zza() {
        zzcp zzcpVar = zzc;
        if (zzcpVar == null) {
            synchronized (zzcp.class) {
                zzcpVar = zzc;
                if (zzcpVar == null) {
                    zzcpVar = zza;
                    zzc = zzcpVar;
                }
            }
        }
        return zzcpVar;
    }

    zzcp(boolean z3) {
        this.zzd = Collections.emptyMap();
    }
}
