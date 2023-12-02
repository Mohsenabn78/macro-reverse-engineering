package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzom  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzom {
    public static final zzom zza = new zzok().zza();
    private final Map zzb;

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzom)) {
            return false;
        }
        return this.zzb.equals(((zzom) obj).zzb);
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final String toString() {
        return this.zzb.toString();
    }

    public final Map zza() {
        return this.zzb;
    }
}
