package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaae {
    private final long zza;
    private final long zzb;
    private final long zzc;
    private long zzd = 0;
    private long zze;
    private long zzf;
    private long zzg;
    private long zzh;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzaae(long j4, long j5, long j6, long j7, long j8, long j9, long j10) {
        this.zza = j4;
        this.zzb = j5;
        this.zze = j7;
        this.zzf = j8;
        this.zzg = j9;
        this.zzc = j10;
        this.zzh = zzf(j5, 0L, j7, j8, j9, j10);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static long zzf(long j4, long j5, long j6, long j7, long j8, long j9) {
        if (j7 + 1 >= j8 || 1 + j5 >= j6) {
            return j7;
        }
        long j10 = ((float) (j4 - j5)) * (((float) (j8 - j7)) / ((float) (j6 - j5)));
        return Math.max(j7, Math.min(((j7 + j10) - j9) - (j10 / 20), j8 - 1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzg(zzaae zzaaeVar, long j4, long j5) {
        zzaaeVar.zze = j4;
        zzaaeVar.zzg = j5;
        zzaaeVar.zzi();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzh(zzaae zzaaeVar, long j4, long j5) {
        zzaaeVar.zzd = j4;
        zzaaeVar.zzf = j5;
        zzaaeVar.zzi();
    }

    private final void zzi() {
        this.zzh = zzf(this.zzb, this.zzd, this.zze, this.zzf, this.zzg, this.zzc);
    }
}
