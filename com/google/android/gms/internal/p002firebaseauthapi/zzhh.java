package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.common.base.Ascii;
import java.util.Arrays;
import javax.mail.UIDFolder;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzhh  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzhh {
    public static byte[] zza(byte[] bArr, byte[] bArr2) {
        long zzb = zzb(bArr, 0, 0);
        long zzb2 = zzb(bArr, 3, 2) & 67108611;
        long zzb3 = zzb(bArr, 6, 4) & 67092735;
        long zzb4 = zzb(bArr, 9, 6) & 66076671;
        long zzb5 = zzb(bArr, 12, 8) & 1048575;
        int i4 = 17;
        byte[] bArr3 = new byte[17];
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        int i5 = 0;
        while (true) {
            int length = bArr2.length;
            if (i5 < length) {
                int min = Math.min(16, length - i5);
                System.arraycopy(bArr2, i5, bArr3, 0, min);
                bArr3[min] = 1;
                if (min != 16) {
                    Arrays.fill(bArr3, min + 1, i4, (byte) 0);
                }
                long j9 = zzb5 * 5;
                long j10 = zzb4 * 5;
                long j11 = zzb3 * 5;
                long zzb6 = j8 + zzb(bArr3, 0, 0);
                long zzb7 = j5 + zzb(bArr3, 3, 2);
                long zzb8 = j4 + zzb(bArr3, 6, 4);
                long zzb9 = j6 + zzb(bArr3, 9, 6);
                long zzb10 = j7 + (zzb(bArr3, 12, 8) | (bArr3[16] << Ascii.CAN));
                long j12 = zzb7 * zzb;
                long j13 = zzb7 * zzb2;
                long j14 = zzb7 * zzb3;
                long j15 = zzb9 * zzb;
                long j16 = zzb7 * zzb4;
                long j17 = zzb10 * zzb;
                long j18 = (zzb6 * zzb) + (zzb7 * j9) + (zzb8 * j10) + (zzb9 * j11) + (zzb2 * 5 * zzb10);
                long j19 = (zzb6 * zzb2) + j12 + (zzb8 * j9) + (zzb9 * j10) + (j11 * zzb10) + (j18 >> 26);
                long j20 = (zzb6 * zzb3) + j13 + (zzb8 * zzb) + (zzb9 * j9) + (j10 * zzb10) + (j19 >> 26);
                long j21 = (zzb6 * zzb4) + j14 + (zzb8 * zzb2) + j15 + (zzb10 * j9) + (j20 >> 26);
                long j22 = (zzb6 * zzb5) + j16 + (zzb8 * zzb3) + (zzb9 * zzb2) + j17 + (j21 >> 26);
                long j23 = (j18 & 67108863) + ((j22 >> 26) * 5);
                j5 = (j19 & 67108863) + (j23 >> 26);
                i5 += 16;
                j4 = j20 & 67108863;
                j6 = j21 & 67108863;
                j7 = j22 & 67108863;
                i4 = 17;
                j8 = j23 & 67108863;
            } else {
                long j24 = j4 + (j5 >> 26);
                long j25 = j24 & 67108863;
                long j26 = j6 + (j24 >> 26);
                long j27 = j26 & 67108863;
                long j28 = j7 + (j26 >> 26);
                long j29 = j28 & 67108863;
                long j30 = j8 + ((j28 >> 26) * 5);
                long j31 = j30 & 67108863;
                long j32 = j31 + 5;
                long j33 = (j5 & 67108863) + (j30 >> 26);
                long j34 = j33 + (j32 >> 26);
                long j35 = (j34 >> 26) + j25;
                long j36 = j27 + (j35 >> 26);
                long j37 = (j29 + (j36 >> 26)) - 67108864;
                long j38 = j37 >> 63;
                long j39 = ~j38;
                long j40 = (j33 & j38) | (j34 & 67108863 & j39);
                long j41 = (j25 & j38) | (j35 & 67108863 & j39);
                long j42 = (j27 & j38) | (j36 & 67108863 & j39);
                long j43 = (j29 & j38) | (j37 & j39);
                long zzc = (((j38 & j31) | (j32 & 67108863 & j39) | (j40 << 26)) & UIDFolder.MAXUID) + zzc(bArr, 16);
                long zzc2 = (((j40 >> 6) | (j41 << 20)) & UIDFolder.MAXUID) + zzc(bArr, 20);
                long zzc3 = (((j41 >> 12) | (j42 << 14)) & UIDFolder.MAXUID) + zzc(bArr, 24);
                long zzc4 = (((j42 >> 18) | (j43 << 8)) & UIDFolder.MAXUID) + zzc(bArr, 28);
                byte[] bArr4 = new byte[16];
                zzd(bArr4, zzc & UIDFolder.MAXUID, 0);
                long j44 = zzc2 + (zzc >> 32);
                zzd(bArr4, j44 & UIDFolder.MAXUID, 4);
                long j45 = zzc3 + (j44 >> 32);
                zzd(bArr4, j45 & UIDFolder.MAXUID, 8);
                zzd(bArr4, (zzc4 + (j45 >> 32)) & UIDFolder.MAXUID, 12);
                return bArr4;
            }
        }
    }

    private static long zzb(byte[] bArr, int i4, int i5) {
        return (zzc(bArr, i4) >> i5) & 67108863;
    }

    private static long zzc(byte[] bArr, int i4) {
        int i5 = (bArr[i4 + 1] & 255) << 8;
        return (((bArr[i4 + 3] & 255) << 24) | i5 | (bArr[i4] & 255) | ((bArr[i4 + 2] & 255) << 16)) & UIDFolder.MAXUID;
    }

    private static void zzd(byte[] bArr, long j4, int i4) {
        for (int i5 = 0; i5 < 4; i5++) {
            bArr[i4 + i5] = (byte) (255 & j4);
            j4 >>= 8;
        }
    }
}
