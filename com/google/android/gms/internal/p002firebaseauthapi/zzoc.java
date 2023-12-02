package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Arrays;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzoc  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzoc {
    public static byte[] zza(byte[] bArr) {
        int length = bArr.length;
        if (length < 16) {
            byte[] copyOf = Arrays.copyOf(bArr, 16);
            copyOf[length] = Byte.MIN_VALUE;
            return copyOf;
        }
        throw new IllegalArgumentException("x must be smaller than a block.");
    }

    public static byte[] zzb(byte[] bArr) {
        if (bArr.length == 16) {
            byte[] bArr2 = new byte[16];
            for (int i4 = 0; i4 < 16; i4++) {
                byte b4 = bArr[i4];
                byte b5 = (byte) ((b4 + b4) & 254);
                bArr2[i4] = b5;
                if (i4 < 15) {
                    bArr2[i4] = (byte) (((bArr[i4 + 1] >> 7) & 1) | b5);
                }
            }
            bArr2[15] = (byte) (((byte) ((bArr[0] >> 7) & 135)) ^ bArr2[15]);
            return bArr2;
        }
        throw new IllegalArgumentException("value must be a block.");
    }
}
