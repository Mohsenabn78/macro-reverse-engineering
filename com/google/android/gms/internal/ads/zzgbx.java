package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgbx extends zzfyu {
    private final zzgbw zza;

    private zzgbx(zzgbw zzgbwVar) {
        this.zza = zzgbwVar;
    }

    public static zzgbx zzb(zzgbw zzgbwVar) {
        return new zzgbx(zzgbwVar);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgbx) || ((zzgbx) obj).zza != this.zza) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzgbx.class, this.zza});
    }

    public final String toString() {
        String obj = this.zza.toString();
        return "ChaCha20Poly1305 Parameters (variant: " + obj + ")";
    }

    public final zzgbw zza() {
        return this.zza;
    }
}
