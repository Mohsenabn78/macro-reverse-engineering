package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.nio.charset.Charset;
import java.util.Arrays;
import okio.Utf8;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfa {
    private static final zzfsh zza = zzfsh.zzo(zzfot.zza, zzfot.zzc, zzfot.zzf, zzfot.zzd, zzfot.zze);
    private byte[] zzb;
    private int zzc;
    private int zzd;

    public zzfa(byte[] bArr, int i4) {
        this.zzb = bArr;
        this.zzd = i4;
    }

    public final void zzA(zzez zzezVar, int i4) {
        zzB(zzezVar.zza, 0, i4);
        zzezVar.zzj(0);
    }

    public final void zzB(byte[] bArr, int i4, int i5) {
        System.arraycopy(this.zzb, this.zzc, bArr, i4, i5);
        this.zzc += i5;
    }

    public final void zzC(int i4) {
        byte[] bArr = this.zzb;
        if (bArr.length < i4) {
            bArr = new byte[i4];
        }
        zzD(bArr, i4);
    }

    public final void zzD(byte[] bArr, int i4) {
        this.zzb = bArr;
        this.zzd = i4;
        this.zzc = 0;
    }

    public final void zzE(int i4) {
        boolean z3 = false;
        if (i4 >= 0 && i4 <= this.zzb.length) {
            z3 = true;
        }
        zzdy.zzd(z3);
        this.zzd = i4;
    }

    public final void zzF(int i4) {
        boolean z3 = false;
        if (i4 >= 0 && i4 <= this.zzd) {
            z3 = true;
        }
        zzdy.zzd(z3);
        this.zzc = i4;
    }

    public final void zzG(int i4) {
        zzF(this.zzc + i4);
    }

    public final byte[] zzH() {
        return this.zzb;
    }

    public final int zza() {
        return this.zzd - this.zzc;
    }

    public final int zzb() {
        return this.zzb.length;
    }

    public final int zzc() {
        return this.zzc;
    }

    public final int zzd() {
        return this.zzd;
    }

    public final int zze() {
        byte[] bArr = this.zzb;
        int i4 = this.zzc;
        int i5 = i4 + 1;
        int i6 = i5 + 1;
        int i7 = i6 + 1;
        this.zzc = i7 + 1;
        return (bArr[i7] & 255) | ((bArr[i4] & 255) << 24) | ((bArr[i5] & 255) << 16) | ((bArr[i6] & 255) << 8);
    }

    public final int zzf() {
        byte[] bArr = this.zzb;
        int i4 = this.zzc;
        int i5 = i4 + 1;
        int i6 = i5 + 1;
        this.zzc = i6 + 1;
        return (bArr[i6] & 255) | (((bArr[i4] & 255) << 24) >> 8) | ((bArr[i5] & 255) << 8);
    }

    public final int zzg() {
        byte[] bArr = this.zzb;
        int i4 = this.zzc;
        int i5 = i4 + 1;
        int i6 = i5 + 1;
        int i7 = i6 + 1;
        this.zzc = i7 + 1;
        return ((bArr[i7] & 255) << 24) | (bArr[i4] & 255) | ((bArr[i5] & 255) << 8) | ((bArr[i6] & 255) << 16);
    }

    public final int zzh() {
        int zzg = zzg();
        if (zzg >= 0) {
            return zzg;
        }
        throw new IllegalStateException("Top bit not zero: " + zzg);
    }

    public final int zzi() {
        byte[] bArr = this.zzb;
        int i4 = this.zzc;
        int i5 = i4 + 1;
        this.zzc = i5 + 1;
        return ((bArr[i5] & 255) << 8) | (bArr[i4] & 255);
    }

    public final int zzj() {
        return (zzk() << 21) | (zzk() << 14) | (zzk() << 7) | zzk();
    }

    public final int zzk() {
        byte[] bArr = this.zzb;
        int i4 = this.zzc;
        this.zzc = i4 + 1;
        return bArr[i4] & 255;
    }

    public final int zzl() {
        byte[] bArr = this.zzb;
        int i4 = this.zzc;
        int i5 = i4 + 1;
        this.zzc = i5 + 1 + 2;
        return (bArr[i5] & 255) | ((bArr[i4] & 255) << 8);
    }

    public final int zzm() {
        byte[] bArr = this.zzb;
        int i4 = this.zzc;
        int i5 = i4 + 1;
        int i6 = i5 + 1;
        this.zzc = i6 + 1;
        return (bArr[i6] & 255) | ((bArr[i4] & 255) << 16) | ((bArr[i5] & 255) << 8);
    }

    public final int zzn() {
        int zze = zze();
        if (zze >= 0) {
            return zze;
        }
        throw new IllegalStateException("Top bit not zero: " + zze);
    }

    public final int zzo() {
        byte[] bArr = this.zzb;
        int i4 = this.zzc;
        int i5 = i4 + 1;
        this.zzc = i5 + 1;
        return (bArr[i5] & 255) | ((bArr[i4] & 255) << 8);
    }

    public final long zzp() {
        int i4;
        byte[] bArr = this.zzb;
        int i5 = this.zzc;
        int i6 = i5 + 1;
        long j4 = bArr[i5];
        int i7 = i6 + 1;
        long j5 = bArr[i6];
        int i8 = i7 + 1;
        long j6 = bArr[i7];
        int i9 = i8 + 1;
        long j7 = bArr[i8];
        int i10 = i9 + 1;
        long j8 = bArr[i9];
        int i11 = i10 + 1;
        long j9 = bArr[i10];
        long j10 = bArr[i11];
        this.zzc = i11 + 1 + 1;
        return ((bArr[i4] & 255) << 56) | ((j10 & 255) << 48) | (j4 & 255) | ((j5 & 255) << 8) | ((j6 & 255) << 16) | ((j7 & 255) << 24) | ((j8 & 255) << 32) | ((j9 & 255) << 40);
    }

    public final long zzq() {
        int i4;
        byte[] bArr = this.zzb;
        int i5 = this.zzc;
        int i6 = i5 + 1;
        long j4 = bArr[i5];
        int i7 = i6 + 1;
        long j5 = bArr[i6];
        long j6 = bArr[i7];
        this.zzc = i7 + 1 + 1;
        return ((bArr[i4] & 255) << 24) | (j4 & 255) | ((j5 & 255) << 8) | ((j6 & 255) << 16);
    }

    public final long zzr() {
        int i4;
        byte[] bArr = this.zzb;
        int i5 = this.zzc;
        int i6 = i5 + 1;
        long j4 = bArr[i5];
        int i7 = i6 + 1;
        long j5 = bArr[i6];
        int i8 = i7 + 1;
        long j6 = bArr[i7];
        int i9 = i8 + 1;
        long j7 = bArr[i8];
        int i10 = i9 + 1;
        long j8 = bArr[i9];
        int i11 = i10 + 1;
        long j9 = bArr[i10];
        long j10 = bArr[i11];
        this.zzc = i11 + 1 + 1;
        return (bArr[i4] & 255) | ((j4 & 255) << 56) | ((j5 & 255) << 48) | ((j6 & 255) << 40) | ((j7 & 255) << 32) | ((j8 & 255) << 24) | ((j9 & 255) << 16) | ((j10 & 255) << 8);
    }

    public final long zzs() {
        int i4;
        byte[] bArr = this.zzb;
        int i5 = this.zzc;
        int i6 = i5 + 1;
        long j4 = bArr[i5];
        int i7 = i6 + 1;
        long j5 = bArr[i6];
        long j6 = bArr[i7];
        this.zzc = i7 + 1 + 1;
        return (bArr[i4] & 255) | ((j4 & 255) << 24) | ((j5 & 255) << 16) | ((j6 & 255) << 8);
    }

    public final long zzt() {
        long zzr = zzr();
        if (zzr >= 0) {
            return zzr;
        }
        throw new IllegalStateException("Top bit not zero: " + zzr);
    }

    public final long zzu() {
        int i4;
        int i5;
        byte b4;
        int i6;
        long j4 = this.zzb[this.zzc];
        int i7 = 7;
        while (true) {
            i4 = 0;
            if (i7 < 0) {
                break;
            }
            if (((1 << i7) & j4) != 0) {
                i7--;
            } else if (i7 < 6) {
                j4 &= i6 - 1;
                i4 = 7 - i7;
            } else if (i7 == 7) {
                i4 = 1;
            }
        }
        if (i4 != 0) {
            for (i5 = 1; i5 < i4; i5++) {
                if ((this.zzb[this.zzc + i5] & 192) == 128) {
                    j4 = (j4 << 6) | (b4 & Utf8.REPLACEMENT_BYTE);
                } else {
                    throw new NumberFormatException("Invalid UTF-8 sequence continuation byte: " + j4);
                }
            }
            this.zzc += i4;
            return j4;
        }
        throw new NumberFormatException("Invalid UTF-8 sequence first byte: " + j4);
    }

    @Nullable
    public final String zzv(char c4) {
        int i4 = this.zzd;
        int i5 = this.zzc;
        if (i4 - i5 != 0) {
            while (i5 < this.zzd && this.zzb[i5] != 0) {
                i5++;
            }
            byte[] bArr = this.zzb;
            int i6 = this.zzc;
            String zzw = zzfj.zzw(bArr, i6, i5 - i6);
            this.zzc = i5;
            if (i5 < this.zzd) {
                this.zzc = i5 + 1;
            }
            return zzw;
        }
        return null;
    }

    public final String zzw(int i4) {
        int i5;
        if (i4 == 0) {
            return "";
        }
        int i6 = this.zzc;
        int i7 = (i6 + i4) - 1;
        if (i7 < this.zzd && this.zzb[i7] == 0) {
            i5 = i4 - 1;
        } else {
            i5 = i4;
        }
        String zzw = zzfj.zzw(this.zzb, i6, i5);
        this.zzc += i4;
        return zzw;
    }

    public final String zzx(int i4, Charset charset) {
        byte[] bArr = this.zzb;
        int i5 = this.zzc;
        String str = new String(bArr, i5, i4, charset);
        this.zzc = i5 + i4;
        return str;
    }

    public final short zzy() {
        byte[] bArr = this.zzb;
        int i4 = this.zzc;
        int i5 = i4 + 1;
        this.zzc = i5 + 1;
        return (short) ((bArr[i5] & 255) | ((bArr[i4] & 255) << 8));
    }

    public final void zzz(int i4) {
        byte[] bArr = this.zzb;
        if (i4 > bArr.length) {
            this.zzb = Arrays.copyOf(bArr, i4);
        }
    }

    public zzfa() {
        this.zzb = zzfj.zzf;
    }

    public zzfa(int i4) {
        this.zzb = new byte[i4];
        this.zzd = i4;
    }

    public zzfa(byte[] bArr) {
        this.zzb = bArr;
        this.zzd = bArr.length;
    }
}
