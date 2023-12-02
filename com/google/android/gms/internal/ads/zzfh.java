package com.google.android.gms.internal.ads;

import androidx.annotation.GuardedBy;
import androidx.compose.animation.core.AnimationKt;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfh {
    @GuardedBy("this")
    private long zza;
    @GuardedBy("this")
    private long zzb;
    @GuardedBy("this")
    private long zzc;
    private final ThreadLocal zzd = new ThreadLocal();

    public zzfh(long j4) {
        zzf(0L);
    }

    public final synchronized long zza(long j4) {
        if (this.zzb == -9223372036854775807L) {
            long j5 = this.zza;
            if (j5 == 9223372036854775806L) {
                Long l4 = (Long) this.zzd.get();
                l4.getClass();
                j5 = l4.longValue();
            }
            this.zzb = j5 - j4;
            notifyAll();
        }
        this.zzc = j4;
        return j4 + this.zzb;
    }

    public final synchronized long zzb(long j4) {
        if (j4 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j5 = this.zzc;
        if (j5 != -9223372036854775807L) {
            long j6 = (j5 * 90000) / AnimationKt.MillisToNanos;
            long j7 = (4294967296L + j6) / 8589934592L;
            long j8 = (((-1) + j7) * 8589934592L) + j4;
            j4 += j7 * 8589934592L;
            if (Math.abs(j8 - j6) < Math.abs(j4 - j6)) {
                j4 = j8;
            }
        }
        return zza((j4 * AnimationKt.MillisToNanos) / 90000);
    }

    public final synchronized long zzc() {
        long j4 = this.zza;
        if (j4 != Long.MAX_VALUE && j4 != 9223372036854775806L) {
            return j4;
        }
        return -9223372036854775807L;
    }

    public final synchronized long zzd() {
        long zzc;
        long j4 = this.zzc;
        if (j4 != -9223372036854775807L) {
            zzc = j4 + this.zzb;
        } else {
            zzc = zzc();
        }
        return zzc;
    }

    public final synchronized long zze() {
        return this.zzb;
    }

    public final synchronized void zzf(long j4) {
        long j5;
        this.zza = j4;
        if (j4 == Long.MAX_VALUE) {
            j5 = 0;
        } else {
            j5 = -9223372036854775807L;
        }
        this.zzb = j5;
        this.zzc = -9223372036854775807L;
    }
}
