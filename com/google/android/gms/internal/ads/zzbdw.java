package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbdw {
    private static final AtomicReference zzb = new AtomicReference();
    private static final AtomicReference zzc = new AtomicReference();
    static final AtomicBoolean zza = new AtomicBoolean();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzbdu zza() {
        return (zzbdu) zzb.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzbdv zzb() {
        return (zzbdv) zzc.get();
    }

    public static void zzc(zzbdu zzbduVar) {
        zzb.set(zzbduVar);
    }
}
