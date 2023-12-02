package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzga  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzga extends zzcx {
    private final zzfz zza;

    private zzga(zzfz zzfzVar) {
        this.zza = zzfzVar;
    }

    public static zzga zzb(zzfz zzfzVar) {
        return new zzga(zzfzVar);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzga) || ((zzga) obj).zza != this.zza) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzga.class, this.zza});
    }

    public final String toString() {
        String obj = this.zza.toString();
        return "ChaCha20Poly1305 Parameters (variant: " + obj + ")";
    }

    public final zzfz zza() {
        return this.zza;
    }
}
