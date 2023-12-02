package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzkv  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzkv {
    private static final zzkv zza = new zzkv();
    private static final zzku zzb = new zzku(null);
    private final AtomicReference zzc = new AtomicReference();

    public static zzkv zza() {
        return zza;
    }

    public final zzoo zzb() {
        zzoo zzooVar = (zzoo) this.zzc.get();
        if (zzooVar == null) {
            return zzb;
        }
        return zzooVar;
    }
}
