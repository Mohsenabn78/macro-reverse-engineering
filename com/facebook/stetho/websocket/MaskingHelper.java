package com.facebook.stetho.websocket;

/* loaded from: classes3.dex */
class MaskingHelper {
    MaskingHelper() {
    }

    public static void unmask(byte[] bArr, byte[] bArr2, int i4, int i5) {
        int i6 = 0;
        while (true) {
            int i7 = i5 - 1;
            if (i5 > 0) {
                bArr2[i4] = (byte) (bArr[i6 % bArr.length] ^ bArr2[i4]);
                i4++;
                i5 = i7;
                i6++;
            } else {
                return;
            }
        }
    }
}
