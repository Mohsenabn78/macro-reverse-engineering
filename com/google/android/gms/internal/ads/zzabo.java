package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzabo implements zzabv {
    private final long[] zza;
    private final long[] zzb;
    private final long zzc;
    private final boolean zzd;

    public zzabo(long[] jArr, long[] jArr2, long j4) {
        boolean z3;
        boolean z4;
        int length = jArr.length;
        int length2 = jArr2.length;
        if (length == length2) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzdy.zzd(z3);
        if (length2 > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        this.zzd = z4;
        if (z4 && jArr2[0] > 0) {
            int i4 = length2 + 1;
            long[] jArr3 = new long[i4];
            this.zza = jArr3;
            long[] jArr4 = new long[i4];
            this.zzb = jArr4;
            System.arraycopy(jArr, 0, jArr3, 1, length2);
            System.arraycopy(jArr2, 0, jArr4, 1, length2);
        } else {
            this.zza = jArr;
            this.zzb = jArr2;
        }
        this.zzc = j4;
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final long zze() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final zzabt zzg(long j4) {
        if (!this.zzd) {
            zzabw zzabwVar = zzabw.zza;
            return new zzabt(zzabwVar, zzabwVar);
        }
        int zzc = zzfj.zzc(this.zzb, j4, true, true);
        zzabw zzabwVar2 = new zzabw(this.zzb[zzc], this.zza[zzc]);
        if (zzabwVar2.zzb != j4) {
            long[] jArr = this.zzb;
            if (zzc != jArr.length - 1) {
                int i4 = zzc + 1;
                return new zzabt(zzabwVar2, new zzabw(jArr[i4], this.zza[i4]));
            }
        }
        return new zzabt(zzabwVar2, zzabwVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzabv
    public final boolean zzh() {
        return this.zzd;
    }
}
