package com.google.android.gms.internal.ads;

import com.facebook.stetho.dumpapp.Framer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzgcv {
    private static final int[] zza = zzd(new byte[]{101, Framer.EXIT_FRAME_PREFIX, 112, 97, 110, 100, 32, 51, Framer.STDERR_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, 98, 121, 116, 101, 32, 107});

    static void zza(int[] iArr, int i4, int i5, int i6, int i7) {
        int i8 = iArr[i4] + iArr[i5];
        iArr[i4] = i8;
        int i9 = i8 ^ iArr[i7];
        int i10 = (i9 >>> (-16)) | (i9 << 16);
        iArr[i7] = i10;
        int i11 = iArr[i6] + i10;
        iArr[i6] = i11;
        int i12 = iArr[i5] ^ i11;
        int i13 = (i12 >>> (-12)) | (i12 << 12);
        iArr[i5] = i13;
        int i14 = iArr[i4] + i13;
        iArr[i4] = i14;
        int i15 = iArr[i7] ^ i14;
        int i16 = (i15 >>> (-8)) | (i15 << 8);
        iArr[i7] = i16;
        int i17 = iArr[i6] + i16;
        iArr[i6] = i17;
        int i18 = iArr[i5] ^ i17;
        iArr[i5] = (i18 >>> (-7)) | (i18 << 7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(int[] iArr, int[] iArr2) {
        int[] iArr3 = zza;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, iArr3.length, 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzc(int[] iArr) {
        for (int i4 = 0; i4 < 10; i4++) {
            zza(iArr, 0, 4, 8, 12);
            zza(iArr, 1, 5, 9, 13);
            zza(iArr, 2, 6, 10, 14);
            zza(iArr, 3, 7, 11, 15);
            zza(iArr, 0, 5, 10, 15);
            zza(iArr, 1, 6, 11, 12);
            zza(iArr, 2, 7, 8, 13);
            zza(iArr, 3, 4, 9, 14);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int[] zzd(byte[] bArr) {
        IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        return iArr;
    }
}
