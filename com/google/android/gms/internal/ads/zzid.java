package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzid implements zzkk {
    private final zzxp zzb;
    private final long zzc;
    private final long zzd;
    private final long zze;
    private final long zzf;
    private final long zzg;
    private int zzh;
    private boolean zzi;

    public zzid() {
        zzxp zzxpVar = new zzxp(true, 65536);
        zzj(2500, 0, "bufferForPlaybackMs", "0");
        zzj(5000, 0, "bufferForPlaybackAfterRebufferMs", "0");
        zzj(50000, 2500, "minBufferMs", "bufferForPlaybackMs");
        zzj(50000, 5000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        zzj(50000, 50000, "maxBufferMs", "minBufferMs");
        zzj(0, 0, "backBufferDurationMs", "0");
        this.zzb = zzxpVar;
        this.zzc = zzfj.zzo(50000L);
        this.zzd = zzfj.zzo(50000L);
        this.zze = zzfj.zzo(2500L);
        this.zzf = zzfj.zzo(5000L);
        this.zzh = 13107200;
        this.zzg = zzfj.zzo(0L);
    }

    private static void zzj(int i4, int i5, String str, String str2) {
        boolean z3;
        String str3 = str + " cannot be less than " + str2;
        if (i4 >= i5) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzdy.zze(z3, str3);
    }

    private final void zzk(boolean z3) {
        this.zzh = 13107200;
        this.zzi = false;
        if (z3) {
            this.zzb.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkk
    public final long zza() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzkk
    public final void zzb() {
        zzk(false);
    }

    @Override // com.google.android.gms.internal.ads.zzkk
    public final void zzc() {
        zzk(true);
    }

    @Override // com.google.android.gms.internal.ads.zzkk
    public final void zzd() {
        zzk(true);
    }

    @Override // com.google.android.gms.internal.ads.zzkk
    public final void zze(zzcw zzcwVar, zzbw zzbwVar, zzli[] zzliVarArr, zzvn zzvnVar, zzxa[] zzxaVarArr) {
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int length = zzliVarArr.length;
            int i6 = 13107200;
            if (i4 < 2) {
                if (zzxaVarArr[i4] != null) {
                    if (zzliVarArr[i4].zzb() != 1) {
                        i6 = 131072000;
                    }
                    i5 += i6;
                }
                i4++;
            } else {
                int max = Math.max(13107200, i5);
                this.zzh = max;
                this.zzb.zzf(max);
                return;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzkk
    public final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzkk
    public final boolean zzg(long j4, long j5, float f4) {
        int zza = this.zzb.zza();
        int i4 = (f4 > 1.0f ? 1 : (f4 == 1.0f ? 0 : -1));
        int i5 = this.zzh;
        long j6 = this.zzc;
        if (i4 > 0) {
            j6 = Math.min(zzfj.zzm(j6, f4), this.zzd);
        }
        boolean z3 = false;
        if (j5 < Math.max(j6, 500000L)) {
            if (zza < i5) {
                z3 = true;
            }
            this.zzi = z3;
            if (!z3 && j5 < 500000) {
                zzer.zzf("DefaultLoadControl", "Target buffer size reached with less than 500ms of buffered media data.");
            }
        } else if (j5 >= this.zzd || zza >= i5) {
            this.zzi = false;
        }
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzkk
    public final boolean zzh(zzcw zzcwVar, zzbw zzbwVar, long j4, float f4, boolean z3, long j5) {
        long j6;
        long zzn = zzfj.zzn(j4, f4);
        if (z3) {
            j6 = this.zzf;
        } else {
            j6 = this.zze;
        }
        if (j5 != -9223372036854775807L) {
            j6 = Math.min(j5 / 2, j6);
        }
        if (j6 > 0 && zzn < j6 && this.zzb.zza() < this.zzh) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzkk
    public final zzxp zzi() {
        return this.zzb;
    }
}
