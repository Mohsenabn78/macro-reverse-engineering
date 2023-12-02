package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzghn {
    public static final zzghn zza = new zzghl().zza();
    private final Map zzb;

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzghn)) {
            return false;
        }
        return this.zzb.equals(((zzghn) obj).zzb);
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
