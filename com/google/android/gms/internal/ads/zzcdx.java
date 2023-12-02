package com.google.android.gms.internal.ads;

import androidx.annotation.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcdx implements zzkk {
    private final zzxp zzb = new zzxp(true, 65536);
    private long zzc = 15000000;
    private long zzd = 30000000;
    private long zze = 2500000;
    private long zzf = 5000000;
    private int zzg;
    private boolean zzh;

    @Override // com.google.android.gms.internal.ads.zzkk
    public final long zza() {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzkk
    public final void zzb() {
        zzj(false);
    }

    @Override // com.google.android.gms.internal.ads.zzkk
    public final void zzc() {
        zzj(true);
    }

    @Override // com.google.android.gms.internal.ads.zzkk
    public final void zzd() {
        zzj(true);
    }

    @Override // com.google.android.gms.internal.ads.zzkk
    public final /* synthetic */ void zze(zzcw zzcwVar, zzbw zzbwVar, zzli[] zzliVarArr, zzvn zzvnVar, zzxa[] zzxaVarArr) {
        int i4;
        int i5 = 0;
        this.zzg = 0;
        while (true) {
            int length = zzliVarArr.length;
            if (i5 < 2) {
                if (zzxaVarArr[i5] != null) {
                    int i6 = this.zzg;
                    if (zzliVarArr[i5].zzb() != 1) {
                        i4 = 131072000;
                    } else {
                        i4 = 13107200;
                    }
                    this.zzg = i6 + i4;
                }
                i5++;
            } else {
                this.zzb.zzf(this.zzg);
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
        char c4;
        boolean z3 = true;
        if (j5 > this.zzd) {
            c4 = 0;
        } else if (j5 < this.zzc) {
            c4 = 2;
        } else {
            c4 = 1;
        }
        int zza = this.zzb.zza();
        int i4 = this.zzg;
        if (c4 != 2 && (c4 != 1 || !this.zzh || zza >= i4)) {
            z3 = false;
        }
        this.zzh = z3;
        return z3;
    }

    @Override // com.google.android.gms.internal.ads.zzkk
    public final /* synthetic */ boolean zzh(zzcw zzcwVar, zzbw zzbwVar, long j4, float f4, boolean z3, long j5) {
        long j6;
        if (z3) {
            j6 = this.zzf;
        } else {
            j6 = this.zze;
        }
        if (j6 > 0 && j4 < j6) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzkk
    public final zzxp zzi() {
        return this.zzb;
    }

    @VisibleForTesting
    final void zzj(boolean z3) {
        this.zzg = 0;
        this.zzh = false;
        if (z3) {
            this.zzb.zze();
        }
    }

    public final synchronized void zzk(int i4) {
        this.zze = i4 * 1000;
    }

    public final synchronized void zzl(int i4) {
        this.zzf = i4 * 1000;
    }

    public final synchronized void zzm(int i4) {
        this.zzd = i4 * 1000;
    }

    public final synchronized void zzn(int i4) {
        this.zzc = i4 * 1000;
    }
}
