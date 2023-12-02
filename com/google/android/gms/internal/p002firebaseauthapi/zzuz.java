package com.google.android.gms.internal.p002firebaseauthapi;

import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzuz  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzuz {
    public static final void zza(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i4) {
        if (i4 >= 0 && byteBuffer2.remaining() >= i4 && byteBuffer3.remaining() >= i4 && byteBuffer.remaining() >= i4) {
            for (int i5 = 0; i5 < i4; i5++) {
                byteBuffer.put((byte) (byteBuffer2.get() ^ byteBuffer3.get()));
            }
            return;
        }
        throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
    }

    public static byte[] zzb(byte[]... bArr) throws GeneralSecurityException {
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (i4 < bArr.length) {
                int length = bArr[i4].length;
                if (i5 <= Integer.MAX_VALUE - length) {
                    i5 += length;
                    i4++;
                } else {
                    throw new GeneralSecurityException("exceeded size limit");
                }
            } else {
                byte[] bArr2 = new byte[i5];
                int i6 = 0;
                for (byte[] bArr3 : bArr) {
                    int length2 = bArr3.length;
                    System.arraycopy(bArr3, 0, bArr2, i6, length2);
                    i6 += length2;
                }
                return bArr2;
            }
        }
    }

    public static final byte[] zzc(byte[] bArr, byte[] bArr2) {
        int length = bArr.length;
        if (length == bArr2.length) {
            return zzd(bArr, 0, bArr2, 0, length);
        }
        throw new IllegalArgumentException("The lengths of x and y should match.");
    }

    public static final byte[] zzd(byte[] bArr, int i4, byte[] bArr2, int i5, int i6) {
        if (bArr.length - i6 >= i4 && bArr2.length - i6 >= i5) {
            byte[] bArr3 = new byte[i6];
            for (int i7 = 0; i7 < i6; i7++) {
                bArr3[i7] = (byte) (bArr[i7 + i4] ^ bArr2[i7 + i5]);
            }
            return bArr3;
        }
        throw new IllegalArgumentException("That combination of buffers, offsets and length to xor result in out-of-bond accesses.");
    }
}
