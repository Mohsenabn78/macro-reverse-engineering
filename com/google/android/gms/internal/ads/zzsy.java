package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzsy implements zzvh {
    protected final zzvh[] zza;

    public zzsy(zzvh[] zzvhVarArr) {
        this.zza = zzvhVarArr;
    }

    @Override // com.google.android.gms.internal.ads.zzvh
    public final long zzb() {
        long j4 = Long.MAX_VALUE;
        for (zzvh zzvhVar : this.zza) {
            long zzb = zzvhVar.zzb();
            if (zzb != Long.MIN_VALUE) {
                j4 = Math.min(j4, zzb);
            }
        }
        if (j4 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j4;
    }

    @Override // com.google.android.gms.internal.ads.zzvh
    public final long zzc() {
        long j4 = Long.MAX_VALUE;
        for (zzvh zzvhVar : this.zza) {
            long zzc = zzvhVar.zzc();
            if (zzc != Long.MIN_VALUE) {
                j4 = Math.min(j4, zzc);
            }
        }
        if (j4 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j4;
    }

    @Override // com.google.android.gms.internal.ads.zzvh
    public final void zzm(long j4) {
        for (zzvh zzvhVar : this.zza) {
            zzvhVar.zzm(j4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzvh
    public final boolean zzo(long j4) {
        zzvh[] zzvhVarArr;
        boolean z3;
        boolean z4;
        boolean z5 = false;
        do {
            long zzc = zzc();
            if (zzc == Long.MIN_VALUE) {
                break;
            }
            z3 = false;
            for (zzvh zzvhVar : this.zza) {
                long zzc2 = zzvhVar.zzc();
                if (zzc2 != Long.MIN_VALUE && zzc2 <= j4) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (zzc2 == zzc || z4) {
                    z3 |= zzvhVar.zzo(j4);
                }
            }
            z5 |= z3;
        } while (z3);
        return z5;
    }

    @Override // com.google.android.gms.internal.ads.zzvh
    public final boolean zzp() {
        for (zzvh zzvhVar : this.zza) {
            if (zzvhVar.zzp()) {
                return true;
            }
        }
        return false;
    }
}
