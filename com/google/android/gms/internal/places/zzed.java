package com.google.android.gms.internal.places;

import org.jetbrains.anko.DimensionsKt;

/* loaded from: classes4.dex */
final class zzed extends zzec {
    private static int zzb(byte[] bArr, int i4, long j4, int i5) {
        int zzao;
        int zzs;
        int zzd;
        if (i5 == 0) {
            zzao = zzea.zzao(i4);
            return zzao;
        } else if (i5 == 1) {
            zzs = zzea.zzs(i4, zzdy.zzb(bArr, j4));
            return zzs;
        } else if (i5 == 2) {
            zzd = zzea.zzd(i4, zzdy.zzb(bArr, j4), zzdy.zzb(bArr, j4 + 1));
            return zzd;
        } else {
            throw new AssertionError();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0061, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00b6, code lost:
        return -1;
     */
    @Override // com.google.android.gms.internal.places.zzec
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final int zzc(int r16, byte[] r17, int r18, int r19) {
        /*
            Method dump skipped, instructions count: 217
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzed.zzc(int, byte[], int, int):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.places.zzec
    public final String zzh(byte[] bArr, int i4, int i5) throws zzbk {
        boolean zze;
        boolean zze2;
        boolean zzf;
        boolean zzg;
        boolean zze3;
        if ((i4 | i5 | ((bArr.length - i4) - i5)) >= 0) {
            int i6 = i4 + i5;
            char[] cArr = new char[i5];
            int i7 = 0;
            while (i4 < i6) {
                byte zzb = zzdy.zzb(bArr, i4);
                zze3 = zzdz.zze(zzb);
                if (!zze3) {
                    break;
                }
                i4++;
                zzdz.zzb(zzb, cArr, i7);
                i7++;
            }
            int i8 = i7;
            while (i4 < i6) {
                int i9 = i4 + 1;
                byte zzb2 = zzdy.zzb(bArr, i4);
                zze = zzdz.zze(zzb2);
                if (!zze) {
                    zzf = zzdz.zzf(zzb2);
                    if (!zzf) {
                        zzg = zzdz.zzg(zzb2);
                        if (zzg) {
                            if (i9 < i6 - 1) {
                                int i10 = i9 + 1;
                                zzdz.zzb(zzb2, zzdy.zzb(bArr, i9), zzdy.zzb(bArr, i10), cArr, i8);
                                i4 = i10 + 1;
                                i8++;
                            } else {
                                throw zzbk.zzbu();
                            }
                        } else if (i9 < i6 - 2) {
                            int i11 = i9 + 1;
                            int i12 = i11 + 1;
                            zzdz.zzb(zzb2, zzdy.zzb(bArr, i9), zzdy.zzb(bArr, i11), zzdy.zzb(bArr, i12), cArr, i8);
                            i4 = i12 + 1;
                            i8 = i8 + 1 + 1;
                        } else {
                            throw zzbk.zzbu();
                        }
                    } else if (i9 < i6) {
                        zzdz.zzb(zzb2, zzdy.zzb(bArr, i9), cArr, i8);
                        i4 = i9 + 1;
                        i8++;
                    } else {
                        throw zzbk.zzbu();
                    }
                } else {
                    int i13 = i8 + 1;
                    zzdz.zzb(zzb2, cArr, i8);
                    while (i9 < i6) {
                        byte zzb3 = zzdy.zzb(bArr, i9);
                        zze2 = zzdz.zze(zzb3);
                        if (!zze2) {
                            break;
                        }
                        i9++;
                        zzdz.zzb(zzb3, cArr, i13);
                        i13++;
                    }
                    i4 = i9;
                    i8 = i13;
                }
            }
            return new String(cArr, 0, i8);
        }
        throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(bArr.length), Integer.valueOf(i4), Integer.valueOf(i5)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.places.zzec
    public final int zzc(CharSequence charSequence, byte[] bArr, int i4, int i5) {
        char c4;
        long j4;
        long j5;
        long j6;
        int i6;
        char charAt;
        long j7 = i4;
        long j8 = i5 + j7;
        int length = charSequence.length();
        if (length > i5 || bArr.length - i5 < i4) {
            char charAt2 = charSequence.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(charAt2);
            sb.append(" at index ");
            sb.append(i4 + i5);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i7 = 0;
        while (true) {
            c4 = 128;
            j4 = 1;
            if (i7 >= length || (charAt = charSequence.charAt(i7)) >= 128) {
                break;
            }
            zzdy.zzb(bArr, j7, (byte) charAt);
            i7++;
            j7 = 1 + j7;
        }
        if (i7 == length) {
            return (int) j7;
        }
        while (i7 < length) {
            char charAt3 = charSequence.charAt(i7);
            if (charAt3 >= c4 || j7 >= j8) {
                if (charAt3 < 2048 && j7 <= j8 - 2) {
                    long j9 = j7 + j4;
                    zzdy.zzb(bArr, j7, (byte) ((charAt3 >>> 6) | 960));
                    zzdy.zzb(bArr, j9, (byte) ((charAt3 & '?') | 128));
                    j5 = j9 + j4;
                    j6 = j4;
                } else if ((charAt3 >= 55296 && 57343 >= charAt3) || j7 > j8 - 3) {
                    if (j7 <= j8 - 4) {
                        int i8 = i7 + 1;
                        if (i8 != length) {
                            char charAt4 = charSequence.charAt(i8);
                            if (Character.isSurrogatePair(charAt3, charAt4)) {
                                int codePoint = Character.toCodePoint(charAt3, charAt4);
                                long j10 = j7 + 1;
                                zzdy.zzb(bArr, j7, (byte) ((codePoint >>> 18) | 240));
                                long j11 = j10 + 1;
                                zzdy.zzb(bArr, j10, (byte) (((codePoint >>> 12) & 63) | 128));
                                long j12 = j11 + 1;
                                zzdy.zzb(bArr, j11, (byte) (((codePoint >>> 6) & 63) | 128));
                                j6 = 1;
                                j5 = j12 + 1;
                                zzdy.zzb(bArr, j12, (byte) ((codePoint & 63) | 128));
                                i7 = i8;
                            } else {
                                i7 = i8;
                            }
                        }
                        throw new zzee(i7 - 1, length);
                    } else if (55296 <= charAt3 && charAt3 <= 57343 && ((i6 = i7 + 1) == length || !Character.isSurrogatePair(charAt3, charSequence.charAt(i6)))) {
                        throw new zzee(i7, length);
                    } else {
                        StringBuilder sb2 = new StringBuilder(46);
                        sb2.append("Failed writing ");
                        sb2.append(charAt3);
                        sb2.append(" at index ");
                        sb2.append(j7);
                        throw new ArrayIndexOutOfBoundsException(sb2.toString());
                    }
                } else {
                    long j13 = j7 + j4;
                    zzdy.zzb(bArr, j7, (byte) ((charAt3 >>> '\f') | DimensionsKt.XXHDPI));
                    long j14 = j13 + j4;
                    zzdy.zzb(bArr, j13, (byte) (((charAt3 >>> 6) & 63) | 128));
                    zzdy.zzb(bArr, j14, (byte) ((charAt3 & '?') | 128));
                    j5 = j14 + 1;
                    j6 = 1;
                }
                i7++;
                c4 = 128;
                long j15 = j6;
                j7 = j5;
                j4 = j15;
            } else {
                long j16 = j7 + j4;
                zzdy.zzb(bArr, j7, (byte) charAt3);
                j6 = j4;
                j5 = j16;
            }
            i7++;
            c4 = 128;
            long j152 = j6;
            j7 = j5;
            j4 = j152;
        }
        return (int) j7;
    }
}
