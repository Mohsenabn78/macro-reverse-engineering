package com.google.android.gms.internal.ads;

import com.google.android.gms.nearby.uwb.RangingPosition;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzgok extends zzgom {
    private final InputStream zze;
    private final byte[] zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgok(InputStream inputStream, int i4, zzgoj zzgojVar) {
        super(null);
        this.zzl = Integer.MAX_VALUE;
        byte[] bArr = zzgpw.zzd;
        this.zze = inputStream;
        this.zzf = new byte[4096];
        this.zzg = 0;
        this.zzi = 0;
        this.zzk = 0;
    }

    private final List zzJ(int i4) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i4 > 0) {
            int min = Math.min(i4, 4096);
            byte[] bArr = new byte[min];
            int i5 = 0;
            while (i5 < min) {
                int read = this.zze.read(bArr, i5, min - i5);
                if (read != -1) {
                    this.zzk += read;
                    i5 += read;
                } else {
                    throw zzgpy.zzj();
                }
            }
            i4 -= min;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzK() {
        int i4 = this.zzg + this.zzh;
        this.zzg = i4;
        int i5 = this.zzk + i4;
        int i6 = this.zzl;
        if (i5 > i6) {
            int i7 = i5 - i6;
            this.zzh = i7;
            this.zzg = i4 - i7;
            return;
        }
        this.zzh = 0;
    }

    private final void zzL(int i4) throws IOException {
        if (!zzM(i4)) {
            if (i4 > (Integer.MAX_VALUE - this.zzk) - this.zzi) {
                throw zzgpy.zzi();
            }
            throw zzgpy.zzj();
        }
    }

    private final boolean zzM(int i4) throws IOException {
        int i5 = this.zzi;
        int i6 = i5 + i4;
        int i7 = this.zzg;
        if (i6 > i7) {
            int i8 = this.zzk;
            if (i4 > (Integer.MAX_VALUE - i8) - i5 || i8 + i5 + i4 > this.zzl) {
                return false;
            }
            if (i5 > 0) {
                if (i7 > i5) {
                    byte[] bArr = this.zzf;
                    System.arraycopy(bArr, i5, bArr, 0, i7 - i5);
                }
                i8 = this.zzk + i5;
                this.zzk = i8;
                i7 = this.zzg - i5;
                this.zzg = i7;
                this.zzi = 0;
            }
            try {
                int read = this.zze.read(this.zzf, i7, Math.min(4096 - i7, (Integer.MAX_VALUE - i8) - i7));
                if (read != 0 && read >= -1 && read <= 4096) {
                    if (read <= 0) {
                        return false;
                    }
                    this.zzg += read;
                    zzK();
                    if (this.zzg >= i4) {
                        return true;
                    }
                    return zzM(i4);
                }
                throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
            } catch (zzgpy e4) {
                e4.zzk();
                throw e4;
            }
        }
        throw new IllegalStateException("refillBuffer() called when " + i4 + " bytes were already available in buffer");
    }

    private final byte[] zzN(int i4, boolean z3) throws IOException {
        byte[] zzO = zzO(i4);
        if (zzO != null) {
            return zzO;
        }
        int i5 = this.zzi;
        int i6 = this.zzg;
        int i7 = i6 - i5;
        this.zzk += i6;
        this.zzi = 0;
        this.zzg = 0;
        List<byte[]> zzJ = zzJ(i4 - i7);
        byte[] bArr = new byte[i4];
        System.arraycopy(this.zzf, i5, bArr, 0, i7);
        for (byte[] bArr2 : zzJ) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i7, length);
            i7 += length;
        }
        return bArr;
    }

    private final byte[] zzO(int i4) throws IOException {
        if (i4 == 0) {
            return zzgpw.zzd;
        }
        if (i4 >= 0) {
            int i5 = this.zzk;
            int i6 = this.zzi;
            int i7 = i5 + i6 + i4;
            if ((-2147483647) + i7 <= 0) {
                int i8 = this.zzl;
                if (i7 <= i8) {
                    int i9 = this.zzg - i6;
                    int i10 = i4 - i9;
                    if (i10 >= 4096) {
                        try {
                            if (i10 > this.zze.available()) {
                                return null;
                            }
                        } catch (zzgpy e4) {
                            e4.zzk();
                            throw e4;
                        }
                    }
                    byte[] bArr = new byte[i4];
                    System.arraycopy(this.zzf, this.zzi, bArr, 0, i9);
                    this.zzk += this.zzg;
                    this.zzi = 0;
                    this.zzg = 0;
                    while (i9 < i4) {
                        try {
                            int read = this.zze.read(bArr, i9, i4 - i9);
                            if (read != -1) {
                                this.zzk += read;
                                i9 += read;
                            } else {
                                throw zzgpy.zzj();
                            }
                        } catch (zzgpy e5) {
                            e5.zzk();
                            throw e5;
                        }
                    }
                    return bArr;
                }
                zzB((i8 - i5) - i6);
                throw zzgpy.zzj();
            }
            throw zzgpy.zzi();
        }
        throw zzgpy.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzgom
    public final void zzA(int i4) {
        this.zzl = i4;
        zzK();
    }

    public final void zzB(int i4) throws IOException {
        int i5 = this.zzg;
        int i6 = this.zzi;
        int i7 = i5 - i6;
        if (i4 <= i7 && i4 >= 0) {
            this.zzi = i6 + i4;
        } else if (i4 >= 0) {
            int i8 = this.zzk;
            int i9 = i8 + i6;
            int i10 = this.zzl;
            if (i9 + i4 <= i10) {
                this.zzk = i9;
                this.zzg = 0;
                this.zzi = 0;
                while (i7 < i4) {
                    try {
                        long j4 = i4 - i7;
                        try {
                            long skip = this.zze.skip(j4);
                            int i11 = (skip > 0L ? 1 : (skip == 0L ? 0 : -1));
                            if (i11 >= 0 && skip <= j4) {
                                if (i11 == 0) {
                                    break;
                                }
                                i7 += (int) skip;
                            } else {
                                throw new IllegalStateException(String.valueOf(this.zze.getClass()) + "#skip returned invalid result: " + skip + "\nThe InputStream implementation is buggy.");
                            }
                        } catch (zzgpy e4) {
                            e4.zzk();
                            throw e4;
                        }
                    } finally {
                        this.zzk += i7;
                        zzK();
                    }
                }
                if (i7 < i4) {
                    int i12 = this.zzg;
                    int i13 = i12 - this.zzi;
                    this.zzi = i12;
                    zzL(1);
                    while (true) {
                        int i14 = i4 - i13;
                        int i15 = this.zzg;
                        if (i14 > i15) {
                            i13 += i15;
                            this.zzi = i15;
                            zzL(1);
                        } else {
                            this.zzi = i14;
                            return;
                        }
                    }
                }
            } else {
                zzB((i10 - i8) - i6);
                throw zzgpy.zzj();
            }
        } else {
            throw zzgpy.zzf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgom
    public final boolean zzC() throws IOException {
        if (this.zzi == this.zzg && !zzM(1)) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzgom
    public final boolean zzD() throws IOException {
        if (zzr() != 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzgom
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
                        throw zzgpy.zza();
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
        if (this.zzg - this.zzi >= 10) {
            while (i6 < 10) {
                byte[] bArr = this.zzf;
                int i7 = this.zzi;
                this.zzi = i7 + 1;
                if (bArr[i7] < 0) {
                    i6++;
                }
            }
            throw zzgpy.zze();
        }
        while (i6 < 10) {
            if (zza() < 0) {
                i6++;
            }
        }
        throw zzgpy.zze();
        return true;
    }

    public final byte zza() throws IOException {
        if (this.zzi == this.zzg) {
            zzL(1);
        }
        byte[] bArr = this.zzf;
        int i4 = this.zzi;
        this.zzi = i4 + 1;
        return bArr[i4];
    }

    @Override // com.google.android.gms.internal.ads.zzgom
    public final double zzb() throws IOException {
        return Double.longBitsToDouble(zzq());
    }

    @Override // com.google.android.gms.internal.ads.zzgom
    public final float zzc() throws IOException {
        return Float.intBitsToFloat(zzi());
    }

    @Override // com.google.android.gms.internal.ads.zzgom
    public final int zzd() {
        return this.zzk + this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzgom
    public final int zze(int i4) throws zzgpy {
        if (i4 >= 0) {
            int i5 = this.zzk + this.zzi;
            int i6 = this.zzl;
            int i7 = i4 + i5;
            if (i7 <= i6) {
                this.zzl = i7;
                zzK();
                return i6;
            }
            throw zzgpy.zzj();
        }
        throw zzgpy.zzf();
    }

    @Override // com.google.android.gms.internal.ads.zzgom
    public final int zzf() throws IOException {
        return zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzgom
    public final int zzg() throws IOException {
        return zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzgom
    public final int zzh() throws IOException {
        return zzj();
    }

    public final int zzi() throws IOException {
        int i4 = this.zzi;
        if (this.zzg - i4 < 4) {
            zzL(4);
            i4 = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i4 + 4;
        int i5 = (bArr[i4 + 1] & 255) << 8;
        return ((bArr[i4 + 3] & 255) << 24) | i5 | (bArr[i4] & 255) | ((bArr[i4 + 2] & 255) << 16);
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
            int r0 = r5.zzi
            int r1 = r5.zzg
            if (r1 != r0) goto L7
            goto L6d
        L7:
            byte[] r2 = r5.zzf
            int r3 = r0 + 1
            r0 = r2[r0]
            if (r0 < 0) goto L12
            r5.zzi = r3
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
            r5.zzi = r1
            return r0
        L6d:
            long r0 = r5.zzs()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgok.zzj():int");
    }

    @Override // com.google.android.gms.internal.ads.zzgom
    public final int zzk() throws IOException {
        return zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzgom
    public final int zzl() throws IOException {
        return zzgom.zzF(zzj());
    }

    @Override // com.google.android.gms.internal.ads.zzgom
    public final int zzm() throws IOException {
        if (zzC()) {
            this.zzj = 0;
            return 0;
        }
        int zzj = zzj();
        this.zzj = zzj;
        if ((zzj >>> 3) != 0) {
            return zzj;
        }
        throw zzgpy.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzgom
    public final int zzn() throws IOException {
        return zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzgom
    public final long zzo() throws IOException {
        return zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzgom
    public final long zzp() throws IOException {
        return zzr();
    }

    public final long zzq() throws IOException {
        int i4 = this.zzi;
        if (this.zzg - i4 < 8) {
            zzL(8);
            i4 = this.zzi;
        }
        byte[] bArr = this.zzf;
        this.zzi = i4 + 8;
        long j4 = bArr[i4 + 2];
        long j5 = bArr[i4 + 3];
        return ((bArr[i4 + 7] & 255) << 56) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((j4 & 255) << 16) | ((j5 & 255) << 24) | ((bArr[i4 + 4] & 255) << 32) | ((bArr[i4 + 5] & 255) << 40) | ((bArr[i4 + 6] & 255) << 48);
    }

    public final long zzr() throws IOException {
        long j4;
        long j5;
        long j6;
        long j7;
        int i4;
        int i5 = this.zzi;
        int i6 = this.zzg;
        if (i6 != i5) {
            byte[] bArr = this.zzf;
            int i7 = i5 + 1;
            byte b4 = bArr[i5];
            if (b4 >= 0) {
                this.zzi = i7;
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
                                                    this.zzi = i8;
                                                    return j5;
                                                }
                                            }
                                        }
                                    }
                                }
                                j5 = j6 ^ j9;
                                i8 = i13;
                                this.zzi = i8;
                                return j5;
                            }
                            j4 = j8 ^ j7;
                        }
                    }
                    i8 = i10;
                    j5 = j4;
                    this.zzi = i8;
                    return j5;
                }
                j5 = i4;
                this.zzi = i8;
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
        throw zzgpy.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzgom
    public final long zzt() throws IOException {
        return zzq();
    }

    @Override // com.google.android.gms.internal.ads.zzgom
    public final long zzu() throws IOException {
        return zzgom.zzG(zzr());
    }

    @Override // com.google.android.gms.internal.ads.zzgom
    public final long zzv() throws IOException {
        return zzr();
    }

    @Override // com.google.android.gms.internal.ads.zzgom
    public final zzgoe zzw() throws IOException {
        int zzj = zzj();
        int i4 = this.zzg;
        int i5 = this.zzi;
        if (zzj <= i4 - i5 && zzj > 0) {
            zzgoe zzv = zzgoe.zzv(this.zzf, i5, zzj);
            this.zzi += zzj;
            return zzv;
        } else if (zzj != 0) {
            byte[] zzO = zzO(zzj);
            if (zzO != null) {
                return zzgoe.zzv(zzO, 0, zzO.length);
            }
            int i6 = this.zzi;
            int i7 = this.zzg;
            int i8 = i7 - i6;
            this.zzk += i7;
            this.zzi = 0;
            this.zzg = 0;
            List<byte[]> zzJ = zzJ(zzj - i8);
            byte[] bArr = new byte[zzj];
            System.arraycopy(this.zzf, i6, bArr, 0, i8);
            for (byte[] bArr2 : zzJ) {
                int length = bArr2.length;
                System.arraycopy(bArr2, 0, bArr, i8, length);
                i8 += length;
            }
            return new zzgoa(bArr);
        } else {
            return zzgoe.zzb;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgom
    public final String zzx() throws IOException {
        int zzj = zzj();
        if (zzj > 0) {
            int i4 = this.zzg;
            int i5 = this.zzi;
            if (zzj <= i4 - i5) {
                String str = new String(this.zzf, i5, zzj, zzgpw.zzb);
                this.zzi += zzj;
                return str;
            }
        }
        if (zzj == 0) {
            return "";
        }
        if (zzj <= this.zzg) {
            zzL(zzj);
            String str2 = new String(this.zzf, this.zzi, zzj, zzgpw.zzb);
            this.zzi += zzj;
            return str2;
        }
        return new String(zzN(zzj, false), zzgpw.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzgom
    public final String zzy() throws IOException {
        byte[] zzN;
        int zzj = zzj();
        int i4 = this.zzi;
        int i5 = this.zzg;
        if (zzj <= i5 - i4 && zzj > 0) {
            zzN = this.zzf;
            this.zzi = i4 + zzj;
        } else if (zzj == 0) {
            return "";
        } else {
            i4 = 0;
            if (zzj <= i5) {
                zzL(zzj);
                zzN = this.zzf;
                this.zzi = zzj;
            } else {
                zzN = zzN(zzj, false);
            }
        }
        return zzgsv.zzh(zzN, i4, zzj);
    }

    @Override // com.google.android.gms.internal.ads.zzgom
    public final void zzz(int i4) throws zzgpy {
        if (this.zzj == i4) {
            return;
        }
        throw zzgpy.zzb();
    }
}
