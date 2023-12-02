package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfv {
    private byte[] zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    public zzfv(byte[] bArr, int i4, int i5) {
        this.zza = bArr;
        this.zzc = i4;
        this.zzb = i5;
        zzh();
    }

    private final int zzg() {
        int i4 = 0;
        int i5 = 0;
        while (!zzf()) {
            i5++;
        }
        int i6 = 1 << i5;
        if (i5 > 0) {
            i4 = zza(i5);
        }
        return (i6 - 1) + i4;
    }

    private final void zzh() {
        int i4;
        int i5 = this.zzc;
        boolean z3 = false;
        if (i5 >= 0 && (i5 < (i4 = this.zzb) || (i5 == i4 && this.zzd == 0))) {
            z3 = true;
        }
        zzdy.zzf(z3);
    }

    private final boolean zzi(int i4) {
        if (i4 >= 2 && i4 < this.zzb) {
            byte[] bArr = this.zza;
            if (bArr[i4] == 3 && bArr[i4 - 2] == 0 && bArr[i4 - 1] == 0) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int zza(int i4) {
        int i5;
        int i6;
        this.zzd += i4;
        int i7 = 0;
        while (true) {
            i5 = this.zzd;
            i6 = 2;
            if (i5 <= 8) {
                break;
            }
            int i8 = i5 - 8;
            this.zzd = i8;
            byte[] bArr = this.zza;
            int i9 = this.zzc;
            i7 |= (bArr[i9] & 255) << i8;
            if (true != zzi(i9 + 1)) {
                i6 = 1;
            }
            this.zzc = i9 + i6;
        }
        byte[] bArr2 = this.zza;
        int i10 = this.zzc;
        int i11 = i7 | ((bArr2[i10] & 255) >> (8 - i5));
        int i12 = 32 - i4;
        if (i5 == 8) {
            this.zzd = 0;
            if (true != zzi(i10 + 1)) {
                i6 = 1;
            }
            this.zzc = i10 + i6;
        }
        int i13 = ((-1) >>> i12) & i11;
        zzh();
        return i13;
    }

    public final int zzb() {
        int zzg = zzg();
        int i4 = zzg % 2;
        int i5 = 1;
        int i6 = zzg + 1;
        if (i4 == 0) {
            i5 = -1;
        }
        return i5 * (i6 / 2);
    }

    public final int zzc() {
        return zzg();
    }

    public final void zzd() {
        int i4 = 1;
        int i5 = this.zzd + 1;
        this.zzd = i5;
        if (i5 == 8) {
            this.zzd = 0;
            int i6 = this.zzc;
            if (true == zzi(i6 + 1)) {
                i4 = 2;
            }
            this.zzc = i6 + i4;
        }
        zzh();
    }

    public final void zze(int i4) {
        int i5 = this.zzc;
        int i6 = i4 / 8;
        int i7 = i5 + i6;
        this.zzc = i7;
        int i8 = this.zzd + (i4 - (i6 * 8));
        this.zzd = i8;
        if (i8 > 7) {
            this.zzc = i7 + 1;
            this.zzd = i8 - 8;
        }
        while (true) {
            i5++;
            if (i5 <= this.zzc) {
                if (zzi(i5)) {
                    this.zzc++;
                    i5 += 2;
                }
            } else {
                zzh();
                return;
            }
        }
    }

    public final boolean zzf() {
        int i4 = this.zza[this.zzc] & (128 >> this.zzd);
        zzd();
        if (i4 != 0) {
            return true;
        }
        return false;
    }
}
