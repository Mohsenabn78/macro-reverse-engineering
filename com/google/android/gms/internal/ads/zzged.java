package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzged {
    private static final zzged zza = new zzged();
    private static final zzgec zzb = new zzgec(null);
    private final AtomicReference zzc = new AtomicReference();

    public static zzged zza() {
        return zza;
    }

    public final zzghp zzb() {
        zzghp zzghpVar = (zzghp) this.zzc.get();
        if (zzghpVar == null) {
            return zzb;
        }
        return zzghpVar;
    }
}
