package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzlm {
    public static final zzlm zza;
    public static final zzlm zzb;
    public static final zzlm zzc;
    public static final zzlm zzd;
    public static final zzlm zze;
    public final long zzf;
    public final long zzg;

    static {
        zzlm zzlmVar = new zzlm(0L, 0L);
        zza = zzlmVar;
        zzb = new zzlm(Long.MAX_VALUE, Long.MAX_VALUE);
        zzc = new zzlm(Long.MAX_VALUE, 0L);
        zzd = new zzlm(0L, Long.MAX_VALUE);
        zze = zzlmVar;
    }

    public zzlm(long j4, long j5) {
        boolean z3;
        if (j4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzdy.zzd(z3);
        zzdy.zzd(j5 >= 0);
        this.zzf = j4;
        this.zzg = j5;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzlm.class == obj.getClass()) {
            zzlm zzlmVar = (zzlm) obj;
            if (this.zzf == zzlmVar.zzf && this.zzg == zzlmVar.zzg) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((int) this.zzf) * 31) + ((int) this.zzg);
    }
}
