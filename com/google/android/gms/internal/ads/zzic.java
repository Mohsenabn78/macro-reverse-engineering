package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzic {
    private final long zza;
    private final long zzb;
    private long zzc = -9223372036854775807L;
    private long zzd = -9223372036854775807L;
    private long zzf = -9223372036854775807L;
    private long zzg = -9223372036854775807L;
    private float zzj = 0.97f;
    private float zzi = 1.03f;
    private float zzk = 1.0f;
    private long zzl = -9223372036854775807L;
    private long zze = -9223372036854775807L;
    private long zzh = -9223372036854775807L;
    private long zzm = -9223372036854775807L;
    private long zzn = -9223372036854775807L;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzic(float f4, float f5, long j4, float f6, long j5, long j6, float f7, zzib zzibVar) {
        this.zza = j5;
        this.zzb = j6;
    }

    private static long zzf(long j4, long j5, float f4) {
        return (((float) j4) * 0.999f) + (((float) j5) * 9.999871E-4f);
    }

    private final void zzg() {
        long j4 = this.zzc;
        if (j4 != -9223372036854775807L) {
            long j5 = this.zzd;
            if (j5 != -9223372036854775807L) {
                j4 = j5;
            }
            long j6 = this.zzf;
            if (j6 != -9223372036854775807L && j4 < j6) {
                j4 = j6;
            }
            long j7 = this.zzg;
            if (j7 != -9223372036854775807L && j4 > j7) {
                j4 = j7;
            }
        } else {
            j4 = -9223372036854775807L;
        }
        if (this.zze == j4) {
            return;
        }
        this.zze = j4;
        this.zzh = j4;
        this.zzm = -9223372036854775807L;
        this.zzn = -9223372036854775807L;
        this.zzl = -9223372036854775807L;
    }

    public final float zza(long j4, long j5) {
        if (this.zzc == -9223372036854775807L) {
            return 1.0f;
        }
        long j6 = j4 - j5;
        long j7 = this.zzm;
        if (j7 == -9223372036854775807L) {
            this.zzm = j6;
            this.zzn = 0L;
        } else {
            long max = Math.max(j6, zzf(j7, j6, 0.999f));
            this.zzm = max;
            this.zzn = zzf(this.zzn, Math.abs(j6 - max), 0.999f);
        }
        if (this.zzl != -9223372036854775807L && SystemClock.elapsedRealtime() - this.zzl < 1000) {
            return this.zzk;
        }
        this.zzl = SystemClock.elapsedRealtime();
        long j8 = this.zzm + (this.zzn * 3);
        if (this.zzh > j8) {
            float zzo = (float) zzfj.zzo(1000L);
            long[] jArr = {j8, this.zze, this.zzh - (((this.zzk - 1.0f) * zzo) + ((this.zzi - 1.0f) * zzo))};
            for (int i4 = 1; i4 < 3; i4++) {
                long j9 = jArr[i4];
                if (j9 > j8) {
                    j8 = j9;
                }
            }
            this.zzh = j8;
        } else {
            j8 = Math.max(this.zzh, Math.min(j4 - (Math.max(0.0f, this.zzk - 1.0f) / 1.0E-7f), j8));
            this.zzh = j8;
            long j10 = this.zzg;
            if (j10 != -9223372036854775807L && j8 > j10) {
                this.zzh = j10;
                j8 = j10;
            }
        }
        long j11 = j4 - j8;
        if (Math.abs(j11) < this.zza) {
            this.zzk = 1.0f;
            return 1.0f;
        }
        float max2 = Math.max(this.zzj, Math.min((((float) j11) * 1.0E-7f) + 1.0f, this.zzi));
        this.zzk = max2;
        return max2;
    }

    public final long zzb() {
        return this.zzh;
    }

    public final void zzc() {
        long j4 = this.zzh;
        if (j4 == -9223372036854775807L) {
            return;
        }
        long j5 = j4 + this.zzb;
        this.zzh = j5;
        long j6 = this.zzg;
        if (j6 != -9223372036854775807L && j5 > j6) {
            this.zzh = j6;
        }
        this.zzl = -9223372036854775807L;
    }

    public final void zzd(zzbf zzbfVar) {
        long j4 = zzbfVar.zzc;
        this.zzc = zzfj.zzo(-9223372036854775807L);
        this.zzf = zzfj.zzo(-9223372036854775807L);
        this.zzg = zzfj.zzo(-9223372036854775807L);
        this.zzj = 0.97f;
        this.zzi = 1.03f;
        zzg();
    }

    public final void zze(long j4) {
        this.zzd = j4;
        zzg();
    }
}
