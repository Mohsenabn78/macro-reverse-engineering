package com.google.android.gms.internal.places;

import com.google.common.base.Ascii;

/* loaded from: classes4.dex */
final class zzeb extends zzec {
    @Override // com.google.android.gms.internal.places.zzec
    final int zzc(int i4, byte[] bArr, int i5, int i6) {
        int zzg;
        int zzg2;
        while (i5 < i6 && bArr[i5] >= 0) {
            i5++;
        }
        if (i5 >= i6) {
            return 0;
        }
        while (i5 < i6) {
            int i7 = i5 + 1;
            byte b4 = bArr[i5];
            if (b4 < 0) {
                if (b4 < -32) {
                    if (i7 >= i6) {
                        return b4;
                    }
                    if (b4 >= -62) {
                        i5 = i7 + 1;
                        if (bArr[i7] > -65) {
                        }
                    }
                    return -1;
                } else if (b4 >= -16) {
                    if (i7 >= i6 - 2) {
                        zzg2 = zzea.zzg(bArr, i7, i6);
                        return zzg2;
                    }
                    int i8 = i7 + 1;
                    byte b5 = bArr[i7];
                    if (b5 <= -65 && (((b4 << Ascii.FS) + (b5 + 112)) >> 30) == 0) {
                        int i9 = i8 + 1;
                        if (bArr[i8] <= -65) {
                            i7 = i9 + 1;
                            if (bArr[i9] > -65) {
                            }
                        }
                    }
                    return -1;
                } else if (i7 >= i6 - 1) {
                    zzg = zzea.zzg(bArr, i7, i6);
                    return zzg;
                } else {
                    int i10 = i7 + 1;
                    byte b6 = bArr[i7];
                    if (b6 <= -65 && ((b4 != -32 || b6 >= -96) && (b4 != -19 || b6 < -96))) {
                        i5 = i10 + 1;
                        if (bArr[i10] > -65) {
                        }
                    }
                    return -1;
                }
            }
            i5 = i7;
        }
        return 0;
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
                byte b4 = bArr[i4];
                zze3 = zzdz.zze(b4);
                if (!zze3) {
                    break;
                }
                i4++;
                zzdz.zzb(b4, cArr, i7);
                i7++;
            }
            int i8 = i7;
            while (i4 < i6) {
                int i9 = i4 + 1;
                byte b5 = bArr[i4];
                zze = zzdz.zze(b5);
                if (!zze) {
                    zzf = zzdz.zzf(b5);
                    if (!zzf) {
                        zzg = zzdz.zzg(b5);
                        if (zzg) {
                            if (i9 < i6 - 1) {
                                int i10 = i9 + 1;
                                zzdz.zzb(b5, bArr[i9], bArr[i10], cArr, i8);
                                i4 = i10 + 1;
                                i8++;
                            } else {
                                throw zzbk.zzbu();
                            }
                        } else if (i9 < i6 - 2) {
                            int i11 = i9 + 1;
                            byte b6 = bArr[i9];
                            int i12 = i11 + 1;
                            zzdz.zzb(b5, b6, bArr[i11], bArr[i12], cArr, i8);
                            i4 = i12 + 1;
                            i8 = i8 + 1 + 1;
                        } else {
                            throw zzbk.zzbu();
                        }
                    } else if (i9 < i6) {
                        zzdz.zzb(b5, bArr[i9], cArr, i8);
                        i4 = i9 + 1;
                        i8++;
                    } else {
                        throw zzbk.zzbu();
                    }
                } else {
                    int i13 = i8 + 1;
                    zzdz.zzb(b5, cArr, i8);
                    while (i9 < i6) {
                        byte b7 = bArr[i9];
                        zze2 = zzdz.zze(b7);
                        if (!zze2) {
                            break;
                        }
                        i9++;
                        zzdz.zzb(b7, cArr, i13);
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
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
        return r10 + r0;
     */
    @Override // com.google.android.gms.internal.places.zzec
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzc(java.lang.CharSequence r8, byte[] r9, int r10, int r11) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzeb.zzc(java.lang.CharSequence, byte[], int, int):int");
    }
}
