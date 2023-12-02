package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgcp extends zzfyu {
    private final zzgco zza;

    private zzgcp(zzgco zzgcoVar) {
        this.zza = zzgcoVar;
    }

    public static zzgcp zzb(zzgco zzgcoVar) {
        return new zzgcp(zzgcoVar);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgcp) || ((zzgcp) obj).zza != this.zza) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{zzgcp.class, this.zza});
    }

    public final String toString() {
        String obj = this.zza.toString();
        return "XChaCha20Poly1305 Parameters (variant: " + obj + ")";
    }

    public final zzgco zza() {
        return this.zza;
    }
}
