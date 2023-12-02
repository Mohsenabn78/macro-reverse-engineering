package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzez {
    public byte[] zza;
    private int zzb;
    private int zzc;
    private int zzd;

    public zzez(byte[] bArr, int i4) {
        this.zza = bArr;
        this.zzd = i4;
    }

    private final void zzo() {
        int i4;
        int i5 = this.zzb;
        boolean z3 = false;
        if (i5 >= 0 && (i5 < (i4 = this.zzd) || (i5 == i4 && this.zzc == 0))) {
            z3 = true;
        }
        zzdy.zzf(z3);
    }

    public final int zza() {
        return ((this.zzd - this.zzb) * 8) - this.zzc;
    }

    public final int zzb() {
        boolean z3;
        if (this.zzc == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzdy.zzf(z3);
        return this.zzb;
    }

    public final int zzc() {
        return (this.zzb * 8) + this.zzc;
    }

    public final int zzd(int i4) {
        int i5;
        if (i4 == 0) {
            return 0;
        }
        this.zzc += i4;
        int i6 = 0;
        while (true) {
            i5 = this.zzc;
            if (i5 <= 8) {
                break;
            }
            int i7 = i5 - 8;
            this.zzc = i7;
            byte[] bArr = this.zza;
            int i8 = this.zzb;
            this.zzb = i8 + 1;
            i6 |= (bArr[i8] & 255) << i7;
        }
        byte[] bArr2 = this.zza;
        int i9 = this.zzb;
        int i10 = i6 | ((bArr2[i9] & 255) >> (8 - i5));
        int i11 = 32 - i4;
        if (i5 == 8) {
            this.zzc = 0;
            this.zzb = i9 + 1;
        }
        int i12 = ((-1) >>> i11) & i10;
        zzo();
        return i12;
    }

    public final void zze() {
        if (this.zzc == 0) {
            return;
        }
        this.zzc = 0;
        this.zzb++;
        zzo();
    }

    public final void zzf(int i4, int i5) {
        int i6;
        int min = Math.min(8 - this.zzc, 14);
        int i7 = this.zzc;
        int i8 = (8 - i7) - min;
        byte[] bArr = this.zza;
        int i9 = this.zzb;
        byte b4 = (byte) (((65280 >> i7) | ((1 << i8) - 1)) & bArr[i9]);
        bArr[i9] = b4;
        int i10 = 14 - min;
        int i11 = i4 & 16383;
        bArr[i9] = (byte) (b4 | ((i11 >>> i10) << i8));
        int i12 = i9 + 1;
        while (i10 > 8) {
            i10 -= 8;
            this.zza[i12] = (byte) (i11 >>> i10);
            i12++;
        }
        byte[] bArr2 = this.zza;
        byte b5 = (byte) (bArr2[i12] & ((1 << i6) - 1));
        bArr2[i12] = b5;
        bArr2[i12] = (byte) (((i11 & ((1 << i10) - 1)) << (8 - i10)) | b5);
        zzl(14);
        zzo();
    }

    public final void zzg(byte[] bArr, int i4, int i5) {
        int i6;
        int i7 = 0;
        while (true) {
            i6 = i5 >> 3;
            if (i7 >= i6) {
                break;
            }
            byte[] bArr2 = this.zza;
            int i8 = this.zzb;
            int i9 = i8 + 1;
            this.zzb = i9;
            byte b4 = bArr2[i8];
            int i10 = this.zzc;
            byte b5 = (byte) (b4 << i10);
            bArr[i7] = b5;
            bArr[i7] = (byte) (((bArr2[i9] & 255) >> (8 - i10)) | b5);
            i7++;
        }
        int i11 = i5 & 7;
        if (i11 == 0) {
            return;
        }
        byte b6 = (byte) (bArr[i6] & (255 >> i11));
        bArr[i6] = b6;
        int i12 = this.zzc;
        if (i12 + i11 > 8) {
            byte[] bArr3 = this.zza;
            int i13 = this.zzb;
            this.zzb = i13 + 1;
            b6 = (byte) (b6 | ((bArr3[i13] & 255) << i12));
            bArr[i6] = b6;
            i12 -= 8;
        }
        int i14 = i12 + i11;
        this.zzc = i14;
        byte[] bArr4 = this.zza;
        int i15 = this.zzb;
        bArr[i6] = (byte) (((byte) (((255 & bArr4[i15]) >> (8 - i14)) << (8 - i11))) | b6);
        if (i14 == 8) {
            this.zzc = 0;
            this.zzb = i15 + 1;
        }
        zzo();
    }

    public final void zzh(zzfa zzfaVar) {
        zzi(zzfaVar.zzH(), zzfaVar.zzd());
        zzj(zzfaVar.zzc() * 8);
    }

    public final void zzi(byte[] bArr, int i4) {
        this.zza = bArr;
        this.zzb = 0;
        this.zzc = 0;
        this.zzd = i4;
    }

    public final void zzj(int i4) {
        int i5 = i4 / 8;
        this.zzb = i5;
        this.zzc = i4 - (i5 * 8);
        zzo();
    }

    public final void zzk() {
        int i4 = this.zzc + 1;
        this.zzc = i4;
        if (i4 == 8) {
            this.zzc = 0;
            this.zzb++;
        }
        zzo();
    }

    public final void zzl(int i4) {
        int i5 = i4 / 8;
        int i6 = this.zzb + i5;
        this.zzb = i6;
        int i7 = this.zzc + (i4 - (i5 * 8));
        this.zzc = i7;
        if (i7 > 7) {
            this.zzb = i6 + 1;
            this.zzc = i7 - 8;
        }
        zzo();
    }

    public final void zzm(int i4) {
        boolean z3;
        if (this.zzc == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzdy.zzf(z3);
        this.zzb += i4;
        zzo();
    }

    public final boolean zzn() {
        int i4 = this.zza[this.zzb] & (128 >> this.zzc);
        zzk();
        if (i4 != 0) {
            return true;
        }
        return false;
    }

    public zzez() {
        this.zza = zzfj.zzf;
    }
}
