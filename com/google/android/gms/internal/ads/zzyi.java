package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzyi {
    private long zza;
    private long zzb;
    private long zzc;
    private long zzd;
    private long zze;
    private long zzf;
    private final boolean[] zzg = new boolean[15];
    private int zzh;

    public final long zza() {
        long j4 = this.zze;
        if (j4 == 0) {
            return 0L;
        }
        return this.zzf / j4;
    }

    public final long zzb() {
        return this.zzf;
    }

    public final void zzc(long j4) {
        long j5 = this.zzd;
        if (j5 == 0) {
            this.zza = j4;
        } else if (j5 == 1) {
            long j6 = j4 - this.zza;
            this.zzb = j6;
            this.zzf = j6;
            this.zze = 1L;
        } else {
            long j7 = j4 - this.zzc;
            int i4 = (int) (j5 % 15);
            if (Math.abs(j7 - this.zzb) <= AnimationKt.MillisToNanos) {
                this.zze++;
                this.zzf += j7;
                boolean[] zArr = this.zzg;
                if (zArr[i4]) {
                    zArr[i4] = false;
                    this.zzh--;
                }
            } else {
                boolean[] zArr2 = this.zzg;
                if (!zArr2[i4]) {
                    zArr2[i4] = true;
                    this.zzh++;
                }
            }
        }
        this.zzd++;
        this.zzc = j4;
    }

    public final void zzd() {
        this.zzd = 0L;
        this.zze = 0L;
        this.zzf = 0L;
        this.zzh = 0;
        Arrays.fill(this.zzg, false);
    }

    public final boolean zze() {
        long j4 = this.zzd;
        if (j4 == 0) {
            return false;
        }
        return this.zzg[(int) ((j4 - 1) % 15)];
    }

    public final boolean zzf() {
        if (this.zzd > 15 && this.zzh == 0) {
            return true;
        }
        return false;
    }
}
