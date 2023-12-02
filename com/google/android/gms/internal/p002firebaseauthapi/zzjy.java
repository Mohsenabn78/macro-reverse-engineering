package com.google.android.gms.internal.p002firebaseauthapi;

import com.facebook.stetho.dumpapp.Framer;
import com.google.common.base.Ascii;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import org.objenesis.instantiator.util.ClassDefinitionUtils;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzjy  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzjy {
    static final byte[][] zza = {new byte[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, new byte[]{-32, -21, 122, 124, 59, 65, -72, -82, 22, 86, -29, -6, -15, -97, -60, 106, -38, 9, -115, -21, -100, Framer.STDERR_FRAME_PREFIX, ClassDefinitionUtils.OPS_return, -3, -122, 98, 5, 22, Framer.STDIN_REQUEST_FRAME_PREFIX, 73, -72, 0}, new byte[]{Framer.STDIN_REQUEST_FRAME_PREFIX, -100, -107, -68, -93, 80, -116, 36, ClassDefinitionUtils.OPS_return, -48, ClassDefinitionUtils.OPS_return, 85, -100, -125, -17, 91, 4, 68, 92, -60, 88, Ascii.FS, -114, -122, -40, 34, 78, -35, -48, -97, 17, 87}, new byte[]{-20, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}, new byte[]{-19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}, new byte[]{-18, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, Byte.MAX_VALUE}};

    public static void zza(long[] jArr, byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        int i4 = 32;
        if (bArr2.length == 32) {
            byte[] copyOf = Arrays.copyOf(bArr2, 32);
            copyOf[31] = (byte) (copyOf[31] & Byte.MAX_VALUE);
            int i5 = 0;
            for (int i6 = 0; i6 < 7; i6++) {
                byte[][] bArr3 = zza;
                if (MessageDigest.isEqual(bArr3[i6], copyOf)) {
                    throw new InvalidKeyException("Banned public key: ".concat(zzvy.zza(bArr3[i6])));
                }
            }
            long[] zzk = zzka.zzk(copyOf);
            long[] jArr2 = new long[19];
            long[] jArr3 = new long[19];
            jArr3[0] = 1;
            long[] jArr4 = new long[19];
            jArr4[0] = 1;
            long[] jArr5 = new long[19];
            long[] jArr6 = new long[19];
            long[] jArr7 = new long[19];
            jArr7[0] = 1;
            long[] jArr8 = new long[19];
            long[] jArr9 = new long[19];
            jArr9[0] = 1;
            int i7 = 10;
            System.arraycopy(zzk, 0, jArr2, 0, 10);
            int i8 = 0;
            while (i8 < i4) {
                int i9 = bArr[(32 - i8) - 1] & 255;
                while (i5 < 8) {
                    int i10 = (i9 >> (7 - i5)) & 1;
                    zzb(jArr4, jArr2, i10);
                    zzb(jArr5, jArr3, i10);
                    long[] copyOf2 = Arrays.copyOf(jArr4, i7);
                    int i11 = i9;
                    long[] jArr10 = new long[19];
                    long[] jArr11 = new long[19];
                    int i12 = i8;
                    long[] jArr12 = new long[19];
                    int i13 = i5;
                    long[] jArr13 = new long[19];
                    long[] jArr14 = new long[19];
                    long[] jArr15 = jArr9;
                    long[] jArr16 = new long[19];
                    long[] jArr17 = new long[19];
                    zzka.zzi(jArr4, jArr4, jArr5);
                    zzka.zzh(jArr5, copyOf2, jArr5);
                    long[] copyOf3 = Arrays.copyOf(jArr2, 10);
                    zzka.zzi(jArr2, jArr2, jArr3);
                    zzka.zzh(jArr3, copyOf3, jArr3);
                    zzka.zzb(jArr13, jArr2, jArr5);
                    zzka.zzb(jArr14, jArr4, jArr3);
                    zzka.zze(jArr13);
                    zzka.zzd(jArr13);
                    zzka.zze(jArr14);
                    zzka.zzd(jArr14);
                    long[] jArr18 = jArr2;
                    System.arraycopy(jArr13, 0, copyOf3, 0, 10);
                    zzka.zzi(jArr13, jArr13, jArr14);
                    zzka.zzh(jArr14, copyOf3, jArr14);
                    zzka.zzg(jArr17, jArr13);
                    zzka.zzg(jArr16, jArr14);
                    zzka.zzb(jArr14, jArr16, zzk);
                    zzka.zze(jArr14);
                    zzka.zzd(jArr14);
                    System.arraycopy(jArr17, 0, jArr6, 0, 10);
                    System.arraycopy(jArr14, 0, jArr7, 0, 10);
                    zzka.zzg(jArr11, jArr4);
                    zzka.zzg(jArr12, jArr5);
                    zzka.zzb(jArr8, jArr11, jArr12);
                    zzka.zze(jArr8);
                    zzka.zzd(jArr8);
                    zzka.zzh(jArr12, jArr11, jArr12);
                    Arrays.fill(jArr10, 10, 18, 0L);
                    zzka.zzf(jArr10, jArr12, 121665L);
                    zzka.zzd(jArr10);
                    zzka.zzi(jArr10, jArr10, jArr11);
                    zzka.zzb(jArr15, jArr12, jArr10);
                    zzka.zze(jArr15);
                    zzka.zzd(jArr15);
                    zzb(jArr8, jArr6, i10);
                    zzb(jArr15, jArr7, i10);
                    i5 = i13 + 1;
                    jArr2 = jArr6;
                    i9 = i11;
                    i8 = i12;
                    jArr6 = jArr18;
                    i7 = 10;
                    long[] jArr19 = jArr7;
                    jArr7 = jArr3;
                    jArr3 = jArr19;
                    long[] jArr20 = jArr8;
                    jArr8 = jArr4;
                    jArr4 = jArr20;
                    jArr9 = jArr5;
                    jArr5 = jArr15;
                }
                i8++;
                i4 = 32;
                i5 = 0;
                i7 = 10;
            }
            long[] jArr21 = new long[10];
            long[] jArr22 = new long[10];
            long[] jArr23 = new long[10];
            long[] jArr24 = new long[10];
            long[] jArr25 = new long[10];
            long[] jArr26 = new long[10];
            long[] jArr27 = new long[10];
            long[] jArr28 = new long[10];
            long[] jArr29 = new long[10];
            long[] jArr30 = new long[10];
            long[] jArr31 = jArr2;
            long[] jArr32 = new long[10];
            zzka.zzg(jArr22, jArr5);
            zzka.zzg(jArr32, jArr22);
            zzka.zzg(jArr30, jArr32);
            zzka.zza(jArr23, jArr30, jArr5);
            zzka.zza(jArr24, jArr23, jArr22);
            zzka.zzg(jArr30, jArr24);
            zzka.zza(jArr25, jArr30, jArr23);
            zzka.zzg(jArr30, jArr25);
            zzka.zzg(jArr32, jArr30);
            zzka.zzg(jArr30, jArr32);
            zzka.zzg(jArr32, jArr30);
            zzka.zzg(jArr30, jArr32);
            zzka.zza(jArr26, jArr30, jArr25);
            zzka.zzg(jArr30, jArr26);
            zzka.zzg(jArr32, jArr30);
            for (int i14 = 2; i14 < 10; i14 += 2) {
                zzka.zzg(jArr30, jArr32);
                zzka.zzg(jArr32, jArr30);
            }
            zzka.zza(jArr27, jArr32, jArr26);
            zzka.zzg(jArr30, jArr27);
            zzka.zzg(jArr32, jArr30);
            for (int i15 = 2; i15 < 20; i15 += 2) {
                zzka.zzg(jArr30, jArr32);
                zzka.zzg(jArr32, jArr30);
            }
            zzka.zza(jArr30, jArr32, jArr27);
            zzka.zzg(jArr32, jArr30);
            zzka.zzg(jArr30, jArr32);
            for (int i16 = 2; i16 < 10; i16 += 2) {
                zzka.zzg(jArr32, jArr30);
                zzka.zzg(jArr30, jArr32);
            }
            zzka.zza(jArr28, jArr30, jArr26);
            zzka.zzg(jArr30, jArr28);
            zzka.zzg(jArr32, jArr30);
            for (int i17 = 2; i17 < 50; i17 += 2) {
                zzka.zzg(jArr30, jArr32);
                zzka.zzg(jArr32, jArr30);
            }
            zzka.zza(jArr29, jArr32, jArr28);
            zzka.zzg(jArr32, jArr29);
            zzka.zzg(jArr30, jArr32);
            for (int i18 = 2; i18 < 100; i18 += 2) {
                zzka.zzg(jArr32, jArr30);
                zzka.zzg(jArr30, jArr32);
            }
            zzka.zza(jArr32, jArr30, jArr29);
            zzka.zzg(jArr30, jArr32);
            zzka.zzg(jArr32, jArr30);
            for (int i19 = 2; i19 < 50; i19 += 2) {
                zzka.zzg(jArr30, jArr32);
                zzka.zzg(jArr32, jArr30);
            }
            zzka.zza(jArr30, jArr32, jArr28);
            zzka.zzg(jArr32, jArr30);
            zzka.zzg(jArr30, jArr32);
            zzka.zzg(jArr32, jArr30);
            zzka.zzg(jArr30, jArr32);
            zzka.zzg(jArr32, jArr30);
            zzka.zza(jArr21, jArr32, jArr24);
            zzka.zza(jArr, jArr4, jArr21);
            long[] jArr33 = new long[10];
            long[] jArr34 = new long[10];
            long[] jArr35 = new long[11];
            long[] jArr36 = new long[11];
            long[] jArr37 = new long[11];
            zzka.zza(jArr33, zzk, jArr);
            zzka.zzi(jArr34, zzk, jArr);
            long[] jArr38 = new long[10];
            jArr38[0] = 486662;
            zzka.zzi(jArr36, jArr34, jArr38);
            zzka.zza(jArr36, jArr36, jArr3);
            zzka.zzi(jArr36, jArr36, jArr31);
            zzka.zza(jArr36, jArr36, jArr33);
            zzka.zza(jArr36, jArr36, jArr31);
            zzka.zzf(jArr35, jArr36, 4L);
            zzka.zzd(jArr35);
            zzka.zza(jArr36, jArr33, jArr3);
            zzka.zzh(jArr36, jArr36, jArr3);
            zzka.zza(jArr37, jArr34, jArr31);
            zzka.zzi(jArr36, jArr36, jArr37);
            zzka.zzg(jArr36, jArr36);
            if (MessageDigest.isEqual(zzka.zzj(jArr35), zzka.zzj(jArr36))) {
                return;
            }
            throw new IllegalStateException("Arithmetic error in curve multiplication with the public key: ".concat(zzvy.zza(bArr2)));
        }
        throw new InvalidKeyException("Public key length is not 32-byte");
    }

    static void zzb(long[] jArr, long[] jArr2, int i4) {
        for (int i5 = 0; i5 < 10; i5++) {
            int i6 = (int) jArr[i5];
            int i7 = (-i4) & (((int) jArr2[i5]) ^ i6);
            jArr[i5] = i6 ^ i7;
            jArr2[i5] = i7 ^ ((int) jArr2[i5]);
        }
    }
}
