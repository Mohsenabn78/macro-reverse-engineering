package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public class zzaal implements zzabv {
    private final long zza;
    private final long zzb;
    private final int zzc;
    private final long zzd;
    private final int zze;
    private final long zzf;

    public zzaal(long j4, long j5, int i4, int i5, boolean z3) {
        long zzb;
        this.zza = j4;
        this.zzb = j5;
        this.zzc = i5 == -1 ? 1 : i5;
        this.zze = i4;
        if (j4 == -1) {
            this.zzd = -1L;
            zzb = -9223372036854775807L;
        } else {
            this.zzd = j4 - j5;
            zzb = zzb(j4, j5, i4);
        }
        this.zzf = zzb;
    }

    private static long zzb(long j4, long j5, int i4) {
        return (Math.max(0L, j4 - j5) * 8000000) / i4;
    }

    public final long zza(long j4) {
        return zzb(j4, this.zzb, this.zze);
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final long zze() {
        return this.zzf;
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final zzabt zzg(long j4) {
        long j5 = this.zzd;
        int i4 = (j5 > (-1L) ? 1 : (j5 == (-1L) ? 0 : -1));
        if (i4 != 0) {
            long j6 = this.zzc;
            long j7 = (((this.zze * j4) / 8000000) / j6) * j6;
            if (i4 != 0) {
                j7 = Math.min(j7, j5 - j6);
            }
            long max = this.zzb + Math.max(j7, 0L);
            long zza = zza(max);
            zzabw zzabwVar = new zzabw(zza, max);
            if (this.zzd != -1 && zza < j4) {
                long j8 = max + this.zzc;
                if (j8 < this.zza) {
                    return new zzabt(zzabwVar, new zzabw(zza(j8), j8));
                }
            }
            return new zzabt(zzabwVar, zzabwVar);
        }
        zzabw zzabwVar2 = new zzabw(0L, this.zzb);
        return new zzabt(zzabwVar2, zzabwVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final boolean zzh() {
        if (this.zzd == -1) {
            return false;
        }
        return true;
    }
}
