package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzabp {
    public int zza;
    @Nullable
    public String zzb;
    public int zzc;
    public int zzd;
    public int zze;
    public int zzf;
    public int zzg;

    public final boolean zza(int i4) {
        boolean zzm;
        int i5;
        int i6;
        int i7;
        int i8;
        String[] strArr;
        int[] iArr;
        int zzl;
        int[] iArr2;
        int[] iArr3;
        int i9;
        int[] iArr4;
        int[] iArr5;
        int i10;
        int[] iArr6;
        zzm = zzabq.zzm(i4);
        if (!zzm || (i5 = (i4 >>> 19) & 3) == 1 || (i6 = (i4 >>> 17) & 3) == 0 || (i7 = (i4 >>> 12) & 15) == 0 || i7 == 15 || (i8 = (i4 >>> 10) & 3) == 3) {
            return false;
        }
        this.zza = i5;
        strArr = zzabq.zza;
        this.zzb = strArr[3 - i6];
        iArr = zzabq.zzb;
        int i11 = iArr[i8];
        this.zzd = i11;
        int i12 = 2;
        if (i5 == 2) {
            i11 /= 2;
            this.zzd = i11;
        } else if (i5 == 0) {
            i11 /= 4;
            this.zzd = i11;
        }
        int i13 = (i4 >>> 9) & 1;
        zzl = zzabq.zzl(i5, i6);
        this.zzg = zzl;
        if (i6 == 3) {
            if (i5 == 3) {
                iArr6 = zzabq.zzc;
                i10 = iArr6[i7 - 1];
            } else {
                iArr5 = zzabq.zzd;
                i10 = iArr5[i7 - 1];
            }
            this.zzf = i10;
            this.zzc = (((i10 * 12) / i11) + i13) * 4;
        } else {
            int i14 = 144;
            if (i5 != 3) {
                iArr2 = zzabq.zzg;
                int i15 = iArr2[i7 - 1];
                this.zzf = i15;
                if (i6 == 1) {
                    i14 = 72;
                }
                this.zzc = ((i14 * i15) / i11) + i13;
            } else {
                if (i6 == 2) {
                    iArr4 = zzabq.zze;
                    i9 = iArr4[i7 - 1];
                } else {
                    iArr3 = zzabq.zzf;
                    i9 = iArr3[i7 - 1];
                }
                this.zzf = i9;
                this.zzc = ((i9 * 144) / i11) + i13;
            }
        }
        if (((i4 >> 6) & 3) == 3) {
            i12 = 1;
        }
        this.zze = i12;
        return true;
    }
}
