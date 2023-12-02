package com.google.android.gms.internal.ads;

import com.google.android.gms.nearby.uwb.RangingPosition;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzgoi extends zzgom {
    private final Iterable zze;
    private final Iterator zzf;
    private ByteBuffer zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private long zzo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzgoi(Iterable iterable, int i4, boolean z3, zzgoh zzgohVar) {
        super(null);
        this.zzj = Integer.MAX_VALUE;
        this.zzh = i4;
        this.zze = iterable;
        this.zzf = iterable.iterator();
        this.zzl = 0;
        if (i4 == 0) {
            this.zzg = zzgpw.zze;
            this.zzm = 0L;
            this.zzn = 0L;
            this.zzo = 0L;
            return;
        }
        zzN();
    }

    private final int zzJ() {
        return (int) (((this.zzh - this.zzl) - this.zzm) + this.zzn);
    }

    private final void zzK() throws zzgpy {
        if (this.zzf.hasNext()) {
            zzN();
            return;
        }
        throw zzgpy.zzj();
    }

    private final void zzL(byte[] bArr, int i4, int i5) throws IOException {
        if (i5 <= zzJ()) {
            int i6 = i5;
            while (i6 > 0) {
                if (this.zzo - this.zzm == 0) {
                    zzK();
                }
                int min = Math.min(i6, (int) (this.zzo - this.zzm));
                long j4 = min;
                zzgsq.zzo(this.zzm, bArr, i5 - i6, j4);
                i6 -= min;
                this.zzm += j4;
            }
        } else if (i5 <= 0) {
        } else {
            throw zzgpy.zzj();
        }
    }

    private final void zzM() {
        int i4 = this.zzh + this.zzi;
        this.zzh = i4;
        int i5 = this.zzj;
        if (i4 > i5) {
            int i6 = i4 - i5;
            this.zzi = i6;
            this.zzh = i4 - i6;
            return;
        }
        this.zzi = 0;
    }

    private final void zzN() {
        ByteBuffer byteBuffer = (ByteBuffer) this.zzf.next();
        this.zzg = byteBuffer;
        this.zzl += (int) (this.zzm - this.zzn);
        long position = byteBuffer.position();
        this.zzm = position;
        this.zzn = position;
        this.zzo = this.zzg.limit();
        long zze = zzgsq.zze(this.zzg);
        this.zzm += zze;
        this.zzn += zze;
        this.zzo += zze;
    }

    @Override // com.google.android.gms.internal.ads.zzgom
    public final void zzA(int i4) {
        this.zzj = i4;
        zzM();
    }

    public final void zzB(int i4) throws IOException {
        if (i4 >= 0) {
            if (i4 <= ((this.zzh - this.zzl) - this.zzm) + this.zzn) {
                while (i4 > 0) {
                    if (this.zzo - this.zzm == 0) {
                        zzK();
                    }
                    int min = Math.min(i4, (int) (this.zzo - this.zzm));
                    i4 -= min;
                    this.zzm += min;
                }
                return;
            }
        }
        if (i4 < 0) {
            throw zzgpy.zzf();
        }
        throw zzgpy.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzgom
    public final boolean zzC() throws IOException {
        if ((this.zzl + this.zzm) - this.zzn == this.zzh) {
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
        for (int i6 = 0; i6 < 10; i6++) {
            if (zza() >= 0) {
                return true;
            }
        }
        throw zzgpy.zze();
    }

    public final byte zza() throws IOException {
        if (this.zzo - this.zzm == 0) {
            zzK();
        }
        long j4 = this.zzm;
        this.zzm = 1 + j4;
        return zzgsq.zza(j4);
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
        return (int) ((this.zzl + this.zzm) - this.zzn);
    }

    @Override // com.google.android.gms.internal.ads.zzgom
    public final int zze(int i4) throws zzgpy {
        if (i4 >= 0) {
            int zzd = i4 + zzd();
            int i5 = this.zzj;
            if (zzd <= i5) {
                this.zzj = zzd;
                zzM();
                return i5;
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
        long j4 = this.zzo;
        long j5 = this.zzm;
        if (j4 - j5 >= 4) {
            this.zzm = 4 + j5;
            return (zzgsq.zza(j5) & 255) | ((zzgsq.zza(1 + j5) & 255) << 8) | ((zzgsq.zza(2 + j5) & 255) << 16) | ((zzgsq.zza(j5 + 3) & 255) << 24);
        }
        return (zza() & 255) | ((zza() & 255) << 8) | ((zza() & 255) << 16) | ((zza() & 255) << 24);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x0087, code lost:
        if (com.google.android.gms.internal.ads.zzgsq.zza(r4) >= 0) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzj() throws java.io.IOException {
        /*
            r10 = this;
            long r0 = r10.zzm
            long r2 = r10.zzo
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 != 0) goto La
            goto L8c
        La:
            r2 = 1
            long r4 = r0 + r2
            byte r0 = com.google.android.gms.internal.ads.zzgsq.zza(r0)
            if (r0 < 0) goto L1a
            long r4 = r10.zzm
            long r4 = r4 + r2
            r10.zzm = r4
            return r0
        L1a:
            long r6 = r10.zzo
            long r8 = r10.zzm
            long r6 = r6 - r8
            r8 = 10
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 < 0) goto L8c
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgsq.zza(r4)
            int r1 = r1 << 7
            r0 = r0 ^ r1
            if (r0 >= 0) goto L33
            r0 = r0 ^ (-128(0xffffffffffffff80, float:NaN))
            goto L89
        L33:
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgsq.zza(r6)
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L42
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L40:
            r6 = r4
            goto L89
        L42:
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgsq.zza(r4)
            int r1 = r1 << 21
            r0 = r0 ^ r1
            if (r0 >= 0) goto L52
            r1 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r1
            goto L89
        L52:
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgsq.zza(r6)
            int r6 = r1 << 28
            r0 = r0 ^ r6
            r6 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r6
            if (r1 >= 0) goto L40
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgsq.zza(r4)
            if (r1 >= 0) goto L89
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgsq.zza(r6)
            if (r1 >= 0) goto L40
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgsq.zza(r4)
            if (r1 >= 0) goto L89
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgsq.zza(r6)
            if (r1 >= 0) goto L40
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgsq.zza(r4)
            if (r1 < 0) goto L8c
        L89:
            r10.zzm = r6
            return r0
        L8c:
            long r0 = r10.zzs()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgoi.zzj():int");
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
            this.zzk = 0;
            return 0;
        }
        int zzj = zzj();
        this.zzk = zzj;
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
        long j4 = this.zzo;
        long j5 = this.zzm;
        if (j4 - j5 >= 8) {
            this.zzm = 8 + j5;
            long zza = (zzgsq.zza(3 + j5) & 255) << 24;
            return (zzgsq.zza(j5) & 255) | ((zzgsq.zza(1 + j5) & 255) << 8) | ((zzgsq.zza(j5 + 2) & 255) << 16) | zza | ((zzgsq.zza(j5 + 4) & 255) << 32) | ((zzgsq.zza(5 + j5) & 255) << 40) | ((zzgsq.zza(j5 + 6) & 255) << 48) | ((zzgsq.zza(j5 + 7) & 255) << 56);
        }
        long zza2 = (zza() & 255) << 32;
        long zza3 = (zza() & 255) << 40;
        return (zza() & 255) | ((zza() & 255) << 8) | ((zza() & 255) << 16) | ((zza() & 255) << 24) | zza2 | zza3 | ((zza() & 255) << 48) | ((zza() & 255) << 56);
    }

    public final long zzr() throws IOException {
        long zza;
        long j4;
        long j5;
        int i4;
        long j6 = this.zzm;
        if (this.zzo != j6) {
            long j7 = j6 + 1;
            byte zza2 = zzgsq.zza(j6);
            if (zza2 >= 0) {
                this.zzm++;
                return zza2;
            } else if (this.zzo - this.zzm >= 10) {
                long j8 = j7 + 1;
                int zza3 = zza2 ^ (zzgsq.zza(j7) << 7);
                if (zza3 < 0) {
                    i4 = zza3 ^ RangingPosition.RSSI_UNKNOWN;
                } else {
                    long j9 = j8 + 1;
                    int zza4 = zza3 ^ (zzgsq.zza(j8) << Ascii.SO);
                    if (zza4 >= 0) {
                        zza = zza4 ^ 16256;
                    } else {
                        j8 = j9 + 1;
                        int zza5 = zza4 ^ (zzgsq.zza(j9) << Ascii.NAK);
                        if (zza5 < 0) {
                            i4 = zza5 ^ (-2080896);
                        } else {
                            j9 = j8 + 1;
                            long zza6 = zza5 ^ (zzgsq.zza(j8) << 28);
                            if (zza6 >= 0) {
                                j5 = 266354560;
                            } else {
                                long j10 = j9 + 1;
                                long zza7 = zza6 ^ (zzgsq.zza(j9) << 35);
                                if (zza7 < 0) {
                                    j4 = -34093383808L;
                                } else {
                                    j9 = j10 + 1;
                                    zza6 = zza7 ^ (zzgsq.zza(j10) << 42);
                                    if (zza6 >= 0) {
                                        j5 = 4363953127296L;
                                    } else {
                                        j10 = j9 + 1;
                                        zza7 = zza6 ^ (zzgsq.zza(j9) << 49);
                                        if (zza7 < 0) {
                                            j4 = -558586000294016L;
                                        } else {
                                            j9 = j10 + 1;
                                            zza = (zza7 ^ (zzgsq.zza(j10) << 56)) ^ 71499008037633920L;
                                            if (zza < 0) {
                                                long j11 = 1 + j9;
                                                if (zzgsq.zza(j9) >= 0) {
                                                    j8 = j11;
                                                    this.zzm = j8;
                                                    return zza;
                                                }
                                            }
                                        }
                                    }
                                }
                                zza = zza7 ^ j4;
                                j8 = j10;
                                this.zzm = j8;
                                return zza;
                            }
                            zza = zza6 ^ j5;
                        }
                    }
                    j8 = j9;
                    this.zzm = j8;
                    return zza;
                }
                zza = i4;
                this.zzm = j8;
                return zza;
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
        if (zzj > 0) {
            long j4 = this.zzo;
            long j5 = this.zzm;
            long j6 = zzj;
            if (j6 <= j4 - j5) {
                byte[] bArr = new byte[zzj];
                zzgsq.zzo(j5, bArr, 0L, j6);
                this.zzm += j6;
                return new zzgoa(bArr);
            }
        }
        if (zzj > 0 && zzj <= zzJ()) {
            byte[] bArr2 = new byte[zzj];
            zzL(bArr2, 0, zzj);
            return new zzgoa(bArr2);
        } else if (zzj == 0) {
            return zzgoe.zzb;
        } else {
            if (zzj < 0) {
                throw zzgpy.zzf();
            }
            throw zzgpy.zzj();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgom
    public final String zzx() throws IOException {
        int zzj = zzj();
        if (zzj > 0) {
            long j4 = this.zzo;
            long j5 = this.zzm;
            long j6 = zzj;
            if (j6 <= j4 - j5) {
                byte[] bArr = new byte[zzj];
                zzgsq.zzo(j5, bArr, 0L, j6);
                String str = new String(bArr, zzgpw.zzb);
                this.zzm += j6;
                return str;
            }
        }
        if (zzj > 0 && zzj <= zzJ()) {
            byte[] bArr2 = new byte[zzj];
            zzL(bArr2, 0, zzj);
            return new String(bArr2, zzgpw.zzb);
        } else if (zzj == 0) {
            return "";
        } else {
            if (zzj < 0) {
                throw zzgpy.zzf();
            }
            throw zzgpy.zzj();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgom
    public final String zzy() throws IOException {
        int zzj = zzj();
        if (zzj > 0) {
            long j4 = this.zzo;
            long j5 = this.zzm;
            long j6 = zzj;
            if (j6 <= j4 - j5) {
                String zzg = zzgsv.zzg(this.zzg, (int) (j5 - this.zzn), zzj);
                this.zzm += j6;
                return zzg;
            }
        }
        if (zzj >= 0 && zzj <= zzJ()) {
            byte[] bArr = new byte[zzj];
            zzL(bArr, 0, zzj);
            return zzgsv.zzh(bArr, 0, zzj);
        } else if (zzj == 0) {
            return "";
        } else {
            if (zzj <= 0) {
                throw zzgpy.zzf();
            }
            throw zzgpy.zzj();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgom
    public final void zzz(int i4) throws zzgpy {
        if (this.zzk == i4) {
            return;
        }
        throw zzgpy.zzb();
    }
}
