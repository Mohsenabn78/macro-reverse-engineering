package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagq  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzagq {
    static final zzagq zza = new zzagq(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private final Map zzd;

    zzagq() {
        this.zzd = new HashMap();
    }

    public static zzagq zza() {
        return zza;
    }

    public final zzahb zzb(zzaii zzaiiVar, int i4) {
        return (zzahb) this.zzd.get(new zzagp(zzaiiVar, i4));
    }

    zzagq(boolean z3) {
        this.zzd = Collections.emptyMap();
    }
}
