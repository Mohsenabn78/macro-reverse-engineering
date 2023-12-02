package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzghi {
    public static byte[] zza(byte[] bArr) {
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
