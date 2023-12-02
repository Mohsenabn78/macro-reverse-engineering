package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfu {
    public static final byte[] zza = {0, 0, 0, 1};
    public static final float[] zzb = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    private static final Object zzc = new Object();
    private static int[] zzd = new int[10];

    public static int zza(byte[] bArr, int i4, int i5, boolean[] zArr) {
        boolean z3;
        boolean z4;
        boolean z5;
        int i6 = i5 - i4;
        boolean z6 = false;
        if (i6 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        zzdy.zzf(z3);
        if (i6 == 0) {
            return i5;
        }
        if (zArr[0]) {
            zzf(zArr);
            return i4 - 3;
        } else if (i6 > 1 && zArr[1] && bArr[i4] == 1) {
            zzf(zArr);
            return i4 - 2;
        } else if (i6 > 2 && zArr[2] && bArr[i4] == 0 && bArr[i4 + 1] == 1) {
            zzf(zArr);
            return i4 - 1;
        } else {
            int i7 = i5 - 1;
            int i8 = i4 + 2;
            while (i8 < i7) {
                byte b4 = bArr[i8];
                if ((b4 & 254) == 0) {
                    int i9 = i8 - 2;
                    if (bArr[i9] == 0 && bArr[i8 - 1] == 0 && b4 == 1) {
                        zzf(zArr);
                        return i9;
                    }
                    i8 = i9;
                }
                i8 += 3;
            }
            if (i6 <= 2 ? i6 != 2 ? !zArr[1] || bArr[i7] != 1 : !zArr[2] || bArr[i5 - 2] != 0 || bArr[i7] != 1 : bArr[i5 - 3] != 0 || bArr[i5 - 2] != 0 || bArr[i7] != 1) {
                z4 = false;
            } else {
                z4 = true;
            }
            zArr[0] = z4;
            if (i6 <= 1 ? !(!zArr[2] || bArr[i7] != 0) : !(bArr[i5 - 2] != 0 || bArr[i7] != 0)) {
                z5 = true;
            } else {
                z5 = false;
            }
            zArr[1] = z5;
            if (bArr[i7] == 0) {
                z6 = true;
            }
            zArr[2] = z6;
            return i5;
        }
    }

    public static int zzb(byte[] bArr, int i4) {
        int i5;
        synchronized (zzc) {
            int i6 = 0;
            int i7 = 0;
            while (i6 < i4) {
                while (true) {
                    try {
                        if (i6 < i4 - 2) {
                            if (bArr[i6] == 0 && bArr[i6 + 1] == 0 && bArr[i6 + 2] == 3) {
                                break;
                            }
                            i6++;
                        } else {
                            i6 = i4;
                            break;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (i6 < i4) {
                    int[] iArr = zzd;
                    int length = iArr.length;
                    if (length <= i7) {
                        zzd = Arrays.copyOf(iArr, length + length);
                    }
                    zzd[i7] = i6;
                    i6 += 3;
                    i7++;
                }
            }
            i5 = i4 - i7;
            int i8 = 0;
            int i9 = 0;
            for (int i10 = 0; i10 < i7; i10++) {
                int i11 = zzd[i10] - i8;
                System.arraycopy(bArr, i8, bArr, i9, i11);
                int i12 = i9 + i11;
                int i13 = i12 + 1;
                bArr[i12] = 0;
                i9 = i13 + 1;
                bArr[i13] = 0;
                i8 += i11 + 3;
            }
            System.arraycopy(bArr, i8, bArr, i9, i5 - i9);
        }
        return i5;
    }

    /* JADX WARN: Removed duplicated region for block: B:168:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzfr zzc(byte[] r35, int r36, int r37) {
        /*
            Method dump skipped, instructions count: 858
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfu.zzc(byte[], int, int):com.google.android.gms.internal.ads.zzfr");
    }

    public static zzfs zzd(byte[] bArr, int i4, int i5) {
        zzfv zzfvVar = new zzfv(bArr, 4, i5);
        int zzc2 = zzfvVar.zzc();
        int zzc3 = zzfvVar.zzc();
        zzfvVar.zzd();
        return new zzfs(zzc2, zzc3, zzfvVar.zzf());
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x019f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzft zze(byte[] r24, int r25, int r26) {
        /*
            Method dump skipped, instructions count: 488
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfu.zze(byte[], int, int):com.google.android.gms.internal.ads.zzft");
    }

    public static void zzf(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }
}
