package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzahf {
    public final zzahc zza;
    public final int zzb;
    public final long[] zzc;
    public final int[] zzd;
    public final int zze;
    public final long[] zzf;
    public final int[] zzg;
    public final long zzh;

    public zzahf(zzahc zzahcVar, long[] jArr, int[] iArr, int i4, long[] jArr2, int[] iArr2, long j4) {
        boolean z3;
        boolean z4;
        int length = iArr.length;
        int length2 = jArr2.length;
        if (length == length2) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzdy.zzd(z3);
        int length3 = jArr.length;
        if (length3 == length2) {
            z4 = true;
        } else {
            z4 = false;
        }
        zzdy.zzd(z4);
        int length4 = iArr2.length;
        zzdy.zzd(length4 == length2);
        this.zza = zzahcVar;
        this.zzc = jArr;
        this.zzd = iArr;
        this.zze = i4;
        this.zzf = jArr2;
        this.zzg = iArr2;
        this.zzh = j4;
        this.zzb = length3;
        if (length4 > 0) {
            int i5 = length4 - 1;
            iArr2[i5] = iArr2[i5] | 536870912;
        }
    }

    public final int zza(long j4) {
        for (int zzc = zzfj.zzc(this.zzf, j4, true, false); zzc >= 0; zzc--) {
            if ((this.zzg[zzc] & 1) != 0) {
                return zzc;
            }
        }
        return -1;
    }

    public final int zzb(long j4) {
        for (int zza = zzfj.zza(this.zzf, j4, true, false); zza < this.zzf.length; zza++) {
            if ((this.zzg[zza] & 1) != 0) {
                return zza;
            }
        }
        return -1;
    }
}
