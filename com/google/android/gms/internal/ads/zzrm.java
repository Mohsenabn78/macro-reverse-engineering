package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzrm {
    private int zza = 0;
    private int zzb = -1;
    private int zzc = 0;
    private int[] zzd;
    private int zze;

    public zzrm() {
        int[] iArr = new int[16];
        this.zzd = iArr;
        this.zze = iArr.length - 1;
    }

    public final int zza() {
        int i4 = this.zzc;
        if (i4 != 0) {
            int[] iArr = this.zzd;
            int i5 = this.zza;
            int i6 = iArr[i5];
            this.zza = (i5 + 1) & this.zze;
            this.zzc = i4 - 1;
            return i6;
        }
        throw new NoSuchElementException();
    }

    public final void zzb(int i4) {
        int i5 = this.zzc;
        int[] iArr = this.zzd;
        int length = iArr.length;
        if (i5 == length) {
            int i6 = length + length;
            if (i6 >= 0) {
                int[] iArr2 = new int[i6];
                int i7 = this.zza;
                int i8 = length - i7;
                System.arraycopy(iArr, i7, iArr2, 0, i8);
                System.arraycopy(this.zzd, 0, iArr2, i8, i7);
                this.zza = 0;
                this.zzb = this.zzc - 1;
                this.zzd = iArr2;
                this.zze = iArr2.length - 1;
                iArr = iArr2;
            } else {
                throw new IllegalStateException();
            }
        }
        int i9 = (this.zzb + 1) & this.zze;
        this.zzb = i9;
        iArr[i9] = i4;
        this.zzc++;
    }

    public final void zzc() {
        this.zza = 0;
        this.zzb = -1;
        this.zzc = 0;
    }

    public final boolean zzd() {
        if (this.zzc == 0) {
            return true;
        }
        return false;
    }
}
