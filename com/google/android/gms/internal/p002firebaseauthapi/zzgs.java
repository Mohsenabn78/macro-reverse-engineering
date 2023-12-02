package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzgs  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzgs extends zzcx {
    private final zzgr zza;

    private zzgs(zzgr zzgrVar) {
        this.zza = zzgrVar;
    }

    public static zzgs zzb(zzgr zzgrVar) {
        return new zzgs(zzgrVar);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgs) || ((zzgs) obj).zza != this.zza) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzgs.class, this.zza});
    }

    public final String toString() {
        String obj = this.zza.toString();
        return "XChaCha20Poly1305 Parameters (variant: " + obj + ")";
    }

    public final zzgr zza() {
        return this.zza;
    }
}
