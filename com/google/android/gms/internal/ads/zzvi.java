package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Random;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzvi {
    private final Random zza;
    private final int[] zzb;
    private final int[] zzc;

    public zzvi(int i4) {
        this(0, new Random());
    }

    public final int zza() {
        int[] iArr = this.zzb;
        if (iArr.length > 0) {
            return iArr[0];
        }
        return -1;
    }

    public final int zzb() {
        int[] iArr = this.zzb;
        int length = iArr.length;
        if (length <= 0) {
            return -1;
        }
        return iArr[length - 1];
    }

    public final int zzc() {
        return this.zzb.length;
    }

    public final int zzd(int i4) {
        int i5 = this.zzc[i4] + 1;
        int[] iArr = this.zzb;
        if (i5 < iArr.length) {
            return iArr[i5];
        }
        return -1;
    }

    public final int zze(int i4) {
        int i5 = this.zzc[i4] - 1;
        if (i5 < 0) {
            return -1;
        }
        return this.zzb[i5];
    }

    public final zzvi zzf() {
        return new zzvi(0, new Random(this.zza.nextLong()));
    }

    public final zzvi zzg(int i4, int i5) {
        int[] iArr = new int[i5];
        int[] iArr2 = new int[i5];
        int i6 = 0;
        int i7 = 0;
        while (i7 < i5) {
            iArr[i7] = this.zza.nextInt(this.zzb.length + 1);
            int i8 = i7 + 1;
            int nextInt = this.zza.nextInt(i8);
            iArr2[i7] = iArr2[nextInt];
            iArr2[nextInt] = i7;
            i7 = i8;
        }
        Arrays.sort(iArr);
        int[] iArr3 = new int[this.zzb.length + i5];
        int i9 = 0;
        int i10 = 0;
        while (true) {
            int[] iArr4 = this.zzb;
            if (i6 < iArr4.length + i5) {
                if (i9 < i5 && i10 == iArr[i9]) {
                    iArr3[i6] = iArr2[i9];
                    i9++;
                } else {
                    int i11 = i10 + 1;
                    int i12 = iArr4[i10];
                    iArr3[i6] = i12;
                    if (i12 >= 0) {
                        iArr3[i6] = i12 + i5;
                    }
                    i10 = i11;
                }
                i6++;
            } else {
                return new zzvi(iArr3, new Random(this.zza.nextLong()));
            }
        }
    }

    public final zzvi zzh(int i4, int i5) {
        int[] iArr = new int[this.zzb.length - i5];
        int i6 = 0;
        int i7 = 0;
        while (true) {
            int[] iArr2 = this.zzb;
            if (i6 < iArr2.length) {
                int i8 = iArr2[i6];
                if (i8 >= 0 && i8 < i5) {
                    i7++;
                } else {
                    int i9 = i6 - i7;
                    if (i8 >= 0) {
                        i8 -= i5;
                    }
                    iArr[i9] = i8;
                }
                i6++;
            } else {
                return new zzvi(iArr, new Random(this.zza.nextLong()));
            }
        }
    }

    private zzvi(int i4, Random random) {
        this(new int[0], random);
    }

    private zzvi(int[] iArr, Random random) {
        this.zzb = iArr;
        this.zza = random;
        this.zzc = new int[iArr.length];
        for (int i4 = 0; i4 < iArr.length; i4++) {
            this.zzc[iArr[i4]] = i4;
        }
    }
}
