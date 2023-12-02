package com.google.android.recaptcha.internal;

import com.google.android.gms.nearby.uwb.RangingPosition;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzfb extends zzff {
    private final byte[] zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzfb(byte[] bArr, int i4, int i5, boolean z3, zzfa zzfaVar) {
        super(null);
        this.zzj = Integer.MAX_VALUE;
        this.zze = bArr;
        this.zzf = 0;
        this.zzh = 0;
    }

    private final void zzI() {
        int i4 = this.zzf + this.zzg;
        this.zzf = i4;
        int i5 = this.zzj;
        if (i4 > i5) {
            int i6 = i4 - i5;
            this.zzg = i6;
            this.zzf = i4 - i6;
            return;
        }
        this.zzg = 0;
    }

    @Override // com.google.android.recaptcha.internal.zzff
    public final void zzA(int i4) {
        this.zzj = i4;
        zzI();
    }

    public final void zzB(int i4) throws IOException {
        if (i4 >= 0) {
            int i5 = this.zzf;
            int i6 = this.zzh;
            if (i4 <= i5 - i6) {
                this.zzh = i6 + i4;
                return;
            }
        }
        if (i4 < 0) {
            throw zzgy.zzf();
        }
        throw zzgy.zzj();
    }

    @Override // com.google.android.recaptcha.internal.zzff
    public final boolean zzC() throws IOException {
        if (this.zzh == this.zzf) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.recaptcha.internal.zzff
    public final boolean zzD() throws IOException {
        if (zzr() != 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.recaptcha.internal.zzff
    public final boolean zzE(int i4) throws IOException {
        int zzm;
        int i5 = i4 & 7;
        int i6 = 0;
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        if (i5 == 4) {
                            return false;
                        }
                        if (i5 == 5) {
                            zzB(4);
                            return true;
                        }
                        throw zzgy.zza();
                    }
                    do {
                        zzm = zzm();
                        if (zzm == 0) {
                            break;
                        }
                    } while (zzE(zzm));
                    zzz(((i4 >>> 3) << 3) | 4);
                    return true;
                }
                zzB(zzj());
                return true;
            }
            zzB(8);
            return true;
        }
        if (this.zzf - this.zzh >= 10) {
            while (i6 < 10) {
                byte[] bArr = this.zze;
                int i7 = this.zzh;
                this.zzh = i7 + 1;
                if (bArr[i7] < 0) {
                    i6++;
                }
            }
            throw zzgy.zze();
        }
        while (i6 < 10) {
            if (zza() < 0) {
                i6++;
            }
        }
        throw zzgy.zze();
        return true;
    }

    public final byte zza() throws IOException {
        int i4 = this.zzh;
        if (i4 != this.zzf) {
            byte[] bArr = this.zze;
            this.zzh = i4 + 1;
            return bArr[i4];
        }
        throw zzgy.zzj();
    }

    @Override // com.google.android.recaptcha.internal.zzff
    public final double zzb() throws IOException {
        return Double.longBitsToDouble(zzq());
    }

    @Override // com.google.android.recaptcha.internal.zzff
    public final float zzc() throws IOException {
        return Float.intBitsToFloat(zzi());
    }

    @Override // com.google.android.recaptcha.internal.zzff
    public final int zzd() {
        return this.zzh;
    }

    @Override // com.google.android.recaptcha.internal.zzff
    public final int zze(int i4) throws zzgy {
        if (i4 >= 0) {
            int i5 = i4 + this.zzh;
            if (i5 >= 0) {
                int i6 = this.zzj;
                if (i5 <= i6) {
                    this.zzj = i5;
                    zzI();
                    return i6;
                }
                throw zzgy.zzj();
            }
            throw zzgy.zzg();
        }
        throw zzgy.zzf();
    }

    @Override // com.google.android.recaptcha.internal.zzff
    public final int zzf() throws IOException {
        return zzj();
    }

    @Override // com.google.android.recaptcha.internal.zzff
    public final int zzg() throws IOException {
        return zzi();
    }

    @Override // com.google.android.recaptcha.internal.zzff
    public final int zzh() throws IOException {
        return zzj();
    }

    public final int zzi() throws IOException {
        int i4 = this.zzh;
        if (this.zzf - i4 >= 4) {
            byte[] bArr = this.zze;
            this.zzh = i4 + 4;
            int i5 = (bArr[i4 + 1] & 255) << 8;
            return ((bArr[i4 + 3] & 255) << 24) | i5 | (bArr[i4] & 255) | ((bArr[i4 + 2] & 255) << 16);
        }
        throw zzgy.zzj();
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
        if (r2[r3] < 0) goto L34;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzj() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.zzh
            int r1 = r5.zzf
            if (r1 != r0) goto L7
            goto L6d
        L7:
            byte[] r2 = r5.zze
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L12
            r5.zzh = r3
            return r0
        L12:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L6d
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L23
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
            goto L6a
        L23:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L30
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L2e:
            r1 = r3
            goto L6a
        L30:
            int r1 = r3 + 1
            r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L3e
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L6a
        L3e:
            int r3 = r1 + 1
            r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L2e
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L6a
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2e
            int r1 = r3 + 1
            r3 = r2[r3]
            if (r3 >= 0) goto L6a
            int r3 = r1 + 1
            r1 = r2[r1]
            if (r1 >= 0) goto L2e
            int r1 = r3 + 1
            r2 = r2[r3]
            if (r2 >= 0) goto L6a
            goto L6d
        L6a:
            r5.zzh = r1
            return r0
        L6d:
            long r0 = r5.zzs()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzfb.zzj():int");
    }

    @Override // com.google.android.recaptcha.internal.zzff
    public final int zzk() throws IOException {
        return zzi();
    }

    @Override // com.google.android.recaptcha.internal.zzff
    public final int zzl() throws IOException {
        return zzff.zzF(zzj());
    }

    @Override // com.google.android.recaptcha.internal.zzff
    public final int zzm() throws IOException {
        if (zzC()) {
            this.zzi = 0;
            return 0;
        }
        int zzj = zzj();
        this.zzi = zzj;
        if ((zzj >>> 3) != 0) {
            return zzj;
        }
        throw zzgy.zzc();
    }

    @Override // com.google.android.recaptcha.internal.zzff
    public final int zzn() throws IOException {
        return zzj();
    }

    @Override // com.google.android.recaptcha.internal.zzff
    public final long zzo() throws IOException {
        return zzq();
    }

    @Override // com.google.android.recaptcha.internal.zzff
    public final long zzp() throws IOException {
        return zzr();
    }

    public final long zzq() throws IOException {
        int i4 = this.zzh;
        if (this.zzf - i4 >= 8) {
            byte[] bArr = this.zze;
            this.zzh = i4 + 8;
            long j4 = bArr[i4 + 2];
            long j5 = bArr[i4 + 3];
            return ((bArr[i4 + 7] & 255) << 56) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((j4 & 255) << 16) | ((j5 & 255) << 24) | ((bArr[i4 + 4] & 255) << 32) | ((bArr[i4 + 5] & 255) << 40) | ((bArr[i4 + 6] & 255) << 48);
        }
        throw zzgy.zzj();
    }

    public final long zzr() throws IOException {
        long j4;
        long j5;
        long j6;
        long j7;
        int i4;
        int i5 = this.zzh;
        int i6 = this.zzf;
        if (i6 != i5) {
            byte[] bArr = this.zze;
            int i7 = i5 + 1;
            byte b4 = bArr[i5];
            if (b4 >= 0) {
                this.zzh = i7;
                return b4;
            } else if (i6 - i7 >= 9) {
                int i8 = i7 + 1;
                int i9 = b4 ^ (bArr[i7] << 7);
                if (i9 < 0) {
                    i4 = i9 ^ RangingPosition.RSSI_UNKNOWN;
                } else {
                    int i10 = i8 + 1;
                    int i11 = i9 ^ (bArr[i8] << Ascii.SO);
                    if (i11 >= 0) {
                        j4 = i11 ^ 16256;
                    } else {
                        i8 = i10 + 1;
                        int i12 = i11 ^ (bArr[i10] << Ascii.NAK);
                        if (i12 < 0) {
                            i4 = i12 ^ (-2080896);
                        } else {
                            i10 = i8 + 1;
                            long j8 = i12 ^ (bArr[i8] << 28);
                            if (j8 >= 0) {
                                j7 = 266354560;
                            } else {
                                int i13 = i10 + 1;
                                long j9 = j8 ^ (bArr[i10] << 35);
                                if (j9 < 0) {
                                    j6 = -34093383808L;
                                } else {
                                    i10 = i13 + 1;
                                    j8 = j9 ^ (bArr[i13] << 42);
                                    if (j8 >= 0) {
                                        j7 = 4363953127296L;
                                    } else {
                                        i13 = i10 + 1;
                                        j9 = j8 ^ (bArr[i10] << 49);
                                        if (j9 < 0) {
                                            j6 = -558586000294016L;
                                        } else {
                                            i10 = i13 + 1;
                                            j4 = (j9 ^ (bArr[i13] << 56)) ^ 71499008037633920L;
                                            if (j4 < 0) {
                                                i13 = i10 + 1;
                                                if (bArr[i10] >= 0) {
                                                    j5 = j4;
                                                    i8 = i13;
                                                    this.zzh = i8;
                                                    return j5;
                                                }
                                            }
                                        }
                                    }
                                }
                                j5 = j6 ^ j9;
                                i8 = i13;
                                this.zzh = i8;
                                return j5;
                            }
                            j4 = j8 ^ j7;
                        }
                    }
                    i8 = i10;
                    j5 = j4;
                    this.zzh = i8;
                    return j5;
                }
                j5 = i4;
                this.zzh = i8;
                return j5;
            }
        }
        return zzs();
    }

    final long zzs() throws IOException {
        long j4 = 0;
        for (int i4 = 0; i4 < 64; i4 += 7) {
            byte zza = zza();
            j4 |= (zza & Byte.MAX_VALUE) << i4;
            if ((zza & 128) == 0) {
                return j4;
            }
        }
        throw zzgy.zze();
    }

    @Override // com.google.android.recaptcha.internal.zzff
    public final long zzt() throws IOException {
        return zzq();
    }

    @Override // com.google.android.recaptcha.internal.zzff
    public final long zzu() throws IOException {
        return zzff.zzG(zzr());
    }

    @Override // com.google.android.recaptcha.internal.zzff
    public final long zzv() throws IOException {
        return zzr();
    }

    @Override // com.google.android.recaptcha.internal.zzff
    public final zzez zzw() throws IOException {
        int zzj = zzj();
        if (zzj > 0) {
            int i4 = this.zzf;
            int i5 = this.zzh;
            if (zzj <= i4 - i5) {
                zzez zzm = zzez.zzm(this.zze, i5, zzj);
                this.zzh += zzj;
                return zzm;
            }
        }
        if (zzj != 0) {
            if (zzj > 0) {
                int i6 = this.zzf;
                int i7 = this.zzh;
                if (zzj <= i6 - i7) {
                    int i8 = zzj + i7;
                    this.zzh = i8;
                    return new zzew(Arrays.copyOfRange(this.zze, i7, i8));
                }
            }
            if (zzj <= 0) {
                throw zzgy.zzf();
            }
            throw zzgy.zzj();
        }
        return zzez.zzb;
    }

    @Override // com.google.android.recaptcha.internal.zzff
    public final String zzx() throws IOException {
        int zzj = zzj();
        if (zzj > 0) {
            int i4 = this.zzf;
            int i5 = this.zzh;
            if (zzj <= i4 - i5) {
                String str = new String(this.zze, i5, zzj, zzgw.zzb);
                this.zzh += zzj;
                return str;
            }
        }
        if (zzj == 0) {
            return "";
        }
        if (zzj < 0) {
            throw zzgy.zzf();
        }
        throw zzgy.zzj();
    }

    @Override // com.google.android.recaptcha.internal.zzff
    public final String zzy() throws IOException {
        int zzj = zzj();
        if (zzj > 0) {
            int i4 = this.zzf;
            int i5 = this.zzh;
            if (zzj <= i4 - i5) {
                String zzd = zzju.zzd(this.zze, i5, zzj);
                this.zzh += zzj;
                return zzd;
            }
        }
        if (zzj == 0) {
            return "";
        }
        if (zzj <= 0) {
            throw zzgy.zzf();
        }
        throw zzgy.zzj();
    }

    @Override // com.google.android.recaptcha.internal.zzff
    public final void zzz(int i4) throws zzgy {
        if (this.zzi == i4) {
            return;
        }
        throw zzgy.zzb();
    }
}
