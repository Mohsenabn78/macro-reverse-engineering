package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzacp {
    protected final zzabz zza;
    private final int zzb;
    private final int zzc;
    private final long zzd;
    private final int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private long[] zzk;
    private int[] zzl;

    public zzacp(int i4, int i5, long j4, int i6, zzabz zzabzVar) {
        int i7;
        int i8;
        i5 = i5 != 1 ? 2 : i5;
        this.zzd = j4;
        this.zze = i6;
        this.zza = zzabzVar;
        if (i5 == 2) {
            i7 = 1667497984;
        } else {
            i7 = 1651965952;
        }
        this.zzb = zzi(i4, i7);
        if (i5 == 2) {
            i8 = zzi(i4, 1650720768);
        } else {
            i8 = -1;
        }
        this.zzc = i8;
        this.zzk = new long[512];
        this.zzl = new int[512];
    }

    private static int zzi(int i4, int i5) {
        return (((i4 % 10) + 48) << 8) | ((i4 / 10) + 48) | i5;
    }

    private final long zzj(int i4) {
        return (this.zzd * i4) / this.zze;
    }

    private final zzabw zzk(int i4) {
        return new zzabw(this.zzl[i4] * zzj(1), this.zzk[i4]);
    }

    public final zzabt zza(long j4) {
        int zzj = (int) (j4 / zzj(1));
        int zzb = zzfj.zzb(this.zzl, zzj, true, true);
        if (this.zzl[zzb] == zzj) {
            zzabw zzk = zzk(zzb);
            return new zzabt(zzk, zzk);
        }
        zzabw zzk2 = zzk(zzb);
        int i4 = zzb + 1;
        if (i4 < this.zzk.length) {
            return new zzabt(zzk2, zzk(i4));
        }
        return new zzabt(zzk2, zzk2);
    }

    public final void zzb(long j4) {
        if (this.zzj == this.zzl.length) {
            long[] jArr = this.zzk;
            this.zzk = Arrays.copyOf(jArr, (jArr.length * 3) / 2);
            int[] iArr = this.zzl;
            this.zzl = Arrays.copyOf(iArr, (iArr.length * 3) / 2);
        }
        long[] jArr2 = this.zzk;
        int i4 = this.zzj;
        jArr2[i4] = j4;
        this.zzl[i4] = this.zzi;
        this.zzj = i4 + 1;
    }

    public final void zzc() {
        this.zzk = Arrays.copyOf(this.zzk, this.zzj);
        this.zzl = Arrays.copyOf(this.zzl, this.zzj);
    }

    public final void zzd() {
        this.zzi++;
    }

    public final void zze(int i4) {
        this.zzf = i4;
        this.zzg = i4;
    }

    public final void zzf(long j4) {
        if (this.zzj == 0) {
            this.zzh = 0;
            return;
        }
        this.zzh = this.zzl[zzfj.zzc(this.zzk, j4, true, true)];
    }

    public final boolean zzg(int i4) {
        if (this.zzb != i4 && this.zzc != i4) {
            return false;
        }
        return true;
    }

    public final boolean zzh(zzaax zzaaxVar) throws IOException {
        boolean z3;
        int i4;
        int i5 = this.zzg;
        int zze = i5 - this.zza.zze(zzaaxVar, i5, false);
        this.zzg = zze;
        if (zze == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            if (this.zzf > 0) {
                zzabz zzabzVar = this.zza;
                long zzj = zzj(this.zzh);
                int binarySearch = Arrays.binarySearch(this.zzl, this.zzh);
                int i6 = this.zzf;
                if (binarySearch >= 0) {
                    i4 = 1;
                } else {
                    i4 = 0;
                }
                zzabzVar.zzs(zzj, i4, i6, 0, null);
            }
            this.zzh++;
        }
        return z3;
    }
}
