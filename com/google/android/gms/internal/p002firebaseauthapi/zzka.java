package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzka  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzka {
    private static final int[] zza = {0, 3, 6, 9, 12, 16, 19, 22, 25, 28};
    private static final int[] zzb = {0, 2, 3, 5, 6, 0, 1, 3, 4, 6};
    private static final int[] zzc = {67108863, 33554431};
    private static final int[] zzd = {26, 25};

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(long[] jArr, long[] jArr2, long[] jArr3) {
        long[] jArr4 = new long[19];
        zzb(jArr4, jArr2, jArr3);
        zzc(jArr4, jArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(long[] jArr, long[] jArr2, long[] jArr3) {
        jArr[0] = jArr2[0] * jArr3[0];
        long j4 = jArr2[0];
        long j5 = jArr2[1];
        long j6 = jArr3[0];
        jArr[1] = (jArr3[1] * j4) + (j5 * j6);
        long j7 = jArr2[1];
        long j8 = jArr3[1];
        jArr[2] = ((j7 + j7) * j8) + (jArr3[2] * j4) + (jArr2[2] * j6);
        long j9 = jArr3[2];
        long j10 = jArr2[2];
        jArr[3] = (j7 * j9) + (j10 * j8) + (jArr3[3] * j4) + (jArr2[3] * j6);
        long j11 = jArr3[3];
        long j12 = jArr2[3];
        long j13 = (j7 * j11) + (j12 * j8);
        jArr[4] = (j10 * j9) + j13 + j13 + (jArr3[4] * j4) + (jArr2[4] * j6);
        long j14 = jArr3[4];
        long j15 = jArr2[4];
        jArr[5] = (j10 * j11) + (j12 * j9) + (j7 * j14) + (j15 * j8) + (jArr3[5] * j4) + (jArr2[5] * j6);
        long j16 = jArr3[5];
        long j17 = jArr2[5];
        long j18 = (j12 * j11) + (j7 * j16) + (j17 * j8);
        jArr[6] = j18 + j18 + (j10 * j14) + (j15 * j9) + (jArr3[6] * j4) + (jArr2[6] * j6);
        long j19 = jArr3[6];
        long j20 = jArr2[6];
        jArr[7] = (j12 * j14) + (j15 * j11) + (j10 * j16) + (j17 * j9) + (j7 * j19) + (j20 * j8) + (jArr3[7] * j4) + (jArr2[7] * j6);
        long j21 = jArr3[7];
        long j22 = jArr2[7];
        long j23 = (j12 * j16) + (j17 * j11) + (j7 * j21) + (j22 * j8);
        jArr[8] = (j15 * j14) + j23 + j23 + (j10 * j19) + (j20 * j9) + (jArr3[8] * j4) + (jArr2[8] * j6);
        long j24 = jArr3[8];
        long j25 = jArr2[8];
        jArr[9] = (j15 * j16) + (j17 * j14) + (j12 * j19) + (j20 * j11) + (j10 * j21) + (j22 * j9) + (j7 * j24) + (j25 * j8) + (j4 * jArr3[9]) + (jArr2[9] * j6);
        long j26 = jArr3[9];
        long j27 = jArr2[9];
        long j28 = (j17 * j16) + (j12 * j21) + (j22 * j11) + (j7 * j26) + (j8 * j27);
        jArr[10] = j28 + j28 + (j15 * j19) + (j20 * j14) + (j10 * j24) + (j25 * j9);
        jArr[11] = (j17 * j19) + (j20 * j16) + (j15 * j21) + (j22 * j14) + (j12 * j24) + (j25 * j11) + (j10 * j26) + (j9 * j27);
        long j29 = (j17 * j21) + (j22 * j16) + (j12 * j26) + (j11 * j27);
        jArr[12] = (j20 * j19) + j29 + j29 + (j15 * j24) + (j25 * j14);
        jArr[13] = (j20 * j21) + (j22 * j19) + (j17 * j24) + (j25 * j16) + (j15 * j26) + (j14 * j27);
        long j30 = (j22 * j21) + (j17 * j26) + (j16 * j27);
        jArr[14] = j30 + j30 + (j20 * j24) + (j25 * j19);
        jArr[15] = (j22 * j24) + (j25 * j21) + (j20 * j26) + (j19 * j27);
        long j31 = (j22 * j26) + (j21 * j27);
        jArr[16] = (j25 * j24) + j31 + j31;
        jArr[17] = (j25 * j26) + (j24 * j27);
        jArr[18] = (j27 + j27) * j26;
    }

    static void zzc(long[] jArr, long[] jArr2) {
        zze(jArr);
        zzd(jArr);
        System.arraycopy(jArr, 0, jArr2, 0, 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzd(long[] jArr) {
        jArr[10] = 0;
        int i4 = 0;
        while (i4 < 10) {
            long j4 = jArr[i4];
            long j5 = j4 / 67108864;
            jArr[i4] = j4 - (j5 << 26);
            int i5 = i4 + 1;
            long j6 = jArr[i5] + j5;
            jArr[i5] = j6;
            long j7 = j6 / 33554432;
            jArr[i5] = j6 - (j7 << 25);
            i4 += 2;
            jArr[i4] = jArr[i4] + j7;
        }
        long j8 = jArr[0];
        long j9 = jArr[10];
        long j10 = j8 + (j9 << 4);
        jArr[0] = j10;
        long j11 = j10 + j9 + j9;
        jArr[0] = j11;
        long j12 = j11 + j9;
        jArr[0] = j12;
        jArr[10] = 0;
        long j13 = j12 / 67108864;
        jArr[0] = j12 - (j13 << 26);
        jArr[1] = jArr[1] + j13;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zze(long[] jArr) {
        long j4 = jArr[8];
        long j5 = jArr[18];
        long j6 = j4 + (j5 << 4);
        jArr[8] = j6;
        long j7 = j6 + j5 + j5;
        jArr[8] = j7;
        jArr[8] = j7 + j5;
        long j8 = jArr[7];
        long j9 = jArr[17];
        long j10 = j8 + (j9 << 4);
        jArr[7] = j10;
        long j11 = j10 + j9 + j9;
        jArr[7] = j11;
        jArr[7] = j11 + j9;
        long j12 = jArr[6];
        long j13 = jArr[16];
        long j14 = j12 + (j13 << 4);
        jArr[6] = j14;
        long j15 = j14 + j13 + j13;
        jArr[6] = j15;
        jArr[6] = j15 + j13;
        long j16 = jArr[5];
        long j17 = jArr[15];
        long j18 = j16 + (j17 << 4);
        jArr[5] = j18;
        long j19 = j18 + j17 + j17;
        jArr[5] = j19;
        jArr[5] = j19 + j17;
        long j20 = jArr[4];
        long j21 = jArr[14];
        long j22 = j20 + (j21 << 4);
        jArr[4] = j22;
        long j23 = j22 + j21 + j21;
        jArr[4] = j23;
        jArr[4] = j23 + j21;
        long j24 = jArr[3];
        long j25 = jArr[13];
        long j26 = j24 + (j25 << 4);
        jArr[3] = j26;
        long j27 = j26 + j25 + j25;
        jArr[3] = j27;
        jArr[3] = j27 + j25;
        long j28 = jArr[2];
        long j29 = jArr[12];
        long j30 = j28 + (j29 << 4);
        jArr[2] = j30;
        long j31 = j30 + j29 + j29;
        jArr[2] = j31;
        jArr[2] = j31 + j29;
        long j32 = jArr[1];
        long j33 = jArr[11];
        long j34 = j32 + (j33 << 4);
        jArr[1] = j34;
        long j35 = j34 + j33 + j33;
        jArr[1] = j35;
        jArr[1] = j35 + j33;
        long j36 = jArr[0];
        long j37 = jArr[10];
        long j38 = j36 + (j37 << 4);
        jArr[0] = j38;
        long j39 = j38 + j37 + j37;
        jArr[0] = j39;
        jArr[0] = j39 + j37;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzf(long[] jArr, long[] jArr2, long j4) {
        for (int i4 = 0; i4 < 10; i4++) {
            jArr[i4] = jArr2[i4] * j4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzg(long[] jArr, long[] jArr2) {
        long j4 = jArr2[0];
        long j5 = jArr2[0];
        long j6 = jArr2[1];
        long j7 = (j6 * j6) + (jArr2[2] * j5);
        long j8 = jArr2[2];
        long j9 = (j6 * j8) + (jArr2[3] * j5);
        long j10 = jArr2[3];
        long j11 = (j8 * j8) + (j6 * 4 * j10);
        long j12 = jArr2[4];
        long j13 = (j8 * j10) + (j6 * j12) + (jArr2[5] * j5);
        long j14 = jArr2[5];
        long j15 = (j10 * j10) + (j8 * j12) + (jArr2[6] * j5) + ((j6 + j6) * j14);
        long j16 = jArr2[6];
        long j17 = (j10 * j12) + (j8 * j14) + (j6 * j16) + (jArr2[7] * j5);
        long j18 = jArr2[7];
        long j19 = (j6 * j18) + (j10 * j14);
        long j20 = (j8 * j16) + (jArr2[8] * j5) + j19 + j19;
        long j21 = jArr2[8];
        long j22 = (j12 * j14) + (j10 * j16) + (j8 * j18) + (j6 * j21) + (j5 * jArr2[9]);
        long j23 = jArr2[9];
        long j24 = (j10 * j18) + (j6 * j23);
        long j25 = (j14 * j14) + (j12 * j16) + (j8 * j21) + j24 + j24;
        long j26 = (j14 * j16) + (j12 * j18) + (j10 * j21) + (j8 * j23);
        long j27 = (j14 * j18) + (j10 * j23);
        long j28 = (j12 * j21) + j27 + j27;
        long j29 = (j16 * j18) + (j14 * j21) + (j12 * j23);
        long j30 = (j18 * j18) + (j16 * j21) + ((j14 + j14) * j23);
        long j31 = (j18 * j21) + (j16 * j23);
        zzc(new long[]{j4 * j4, (j5 + j5) * jArr2[1], j7 + j7, j9 + j9, j11 + ((j5 + j5) * jArr2[4]), j13 + j13, j15 + j15, j17 + j17, (j12 * j12) + j20 + j20, j22 + j22, j25 + j25, j26 + j26, (j16 * j16) + j28 + j28, j29 + j29, j30 + j30, j31 + j31, (j21 * j21) + (j18 * 4 * j23), (j21 + j21) * j23, (j23 + j23) * j23}, jArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzh(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i4 = 0; i4 < 10; i4++) {
            jArr[i4] = jArr2[i4] - jArr3[i4];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzi(long[] jArr, long[] jArr2, long[] jArr3) {
        for (int i4 = 0; i4 < 10; i4++) {
            jArr[i4] = jArr2[i4] + jArr3[i4];
        }
    }

    public static byte[] zzj(long[] jArr) {
        int i4;
        int i5;
        long j4;
        long j5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        long[] copyOf = Arrays.copyOf(jArr, 10);
        int i13 = 0;
        while (true) {
            if (i13 >= 2) {
                break;
            }
            int i14 = 0;
            while (i14 < 9) {
                long j6 = copyOf[i14];
                copyOf[i14] = j6 + (i12 << i11);
                i14++;
                copyOf[i14] = copyOf[i14] - (-((int) (((j6 >> 31) & j6) >> zzd[i14 & 1])));
            }
            long j7 = copyOf[9];
            copyOf[9] = j7 + (i10 << 25);
            copyOf[0] = copyOf[0] - ((-((int) (((j7 >> 31) & j7) >> 25))) * 19);
            i13++;
        }
        long j8 = copyOf[0];
        copyOf[0] = j8 + (i5 << 26);
        copyOf[1] = copyOf[1] - (-((int) (((j8 >> 31) & j8) >> 26)));
        int i15 = 0;
        for (i4 = 2; i15 < i4; i4 = 2) {
            int i16 = 0;
            while (i16 < 9) {
                long j9 = copyOf[i16];
                long j10 = j9 >> zzd[i16 & 1];
                copyOf[i16] = j9 & zzc[i9];
                i16++;
                copyOf[i16] = copyOf[i16] + ((int) j10);
            }
            i15++;
        }
        copyOf[9] = copyOf[9] & 33554431;
        copyOf[0] = copyOf[0] + (((int) (j4 >> 25)) * 19);
        int i17 = ~((((int) j5) - 67108845) >> 31);
        for (int i18 = 1; i18 < 10; i18++) {
            int i19 = ~(zzc[i18 & 1] ^ ((int) copyOf[i18]));
            int i20 = i19 & (i19 << 16);
            int i21 = i20 & (i20 << 8);
            int i22 = i21 & (i21 << 4);
            int i23 = i22 & (i22 << 2);
            i17 &= (i23 & (i23 + i23)) >> 31;
        }
        copyOf[0] = copyOf[0] - (67108845 & i17);
        long j11 = 33554431 & i17;
        copyOf[1] = copyOf[1] - j11;
        for (int i24 = 2; i24 < 10; i24 += 2) {
            copyOf[i24] = copyOf[i24] - (67108863 & i17);
            int i25 = i24 + 1;
            copyOf[i25] = copyOf[i25] - j11;
        }
        for (int i26 = 0; i26 < 10; i26++) {
            copyOf[i26] = copyOf[i26] << zzb[i26];
        }
        byte[] bArr = new byte[32];
        for (int i27 = 0; i27 < 10; i27++) {
            int i28 = zza[i27];
            long j12 = copyOf[i27];
            bArr[i28] = (byte) (bArr[i28] | (j12 & 255));
            bArr[i28 + 1] = (byte) (bArr[i6] | ((j12 >> 8) & 255));
            bArr[i28 + 2] = (byte) (bArr[i7] | ((j12 >> 16) & 255));
            bArr[i28 + 3] = (byte) (bArr[i8] | ((j12 >> 24) & 255));
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long[] zzk(byte[] bArr) {
        long[] jArr = new long[10];
        for (int i4 = 0; i4 < 10; i4++) {
            int i5 = zza[i4];
            jArr[i4] = (((((bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8)) | ((bArr[i5 + 2] & 255) << 16)) | ((bArr[i5 + 3] & 255) << 24)) >> zzb[i4]) & zzc[i4 & 1];
        }
        return jArr;
    }
}
