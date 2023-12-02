package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public class MurmurHash3 {
    private MurmurHash3() {
    }

    @KeepForSdk
    public static int murmurhash3_x86_32(@NonNull byte[] bArr, int i4, int i5, int i6) {
        int i7 = (i5 & (-4)) + i4;
        while (i4 < i7) {
            int i8 = ((bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16) | (bArr[i4 + 3] << 24)) * (-862048943);
            int i9 = i6 ^ (((i8 << 15) | (i8 >>> 17)) * 461845907);
            i6 = (((i9 >>> 19) | (i9 << 13)) * 5) - 430675100;
            i4 += 4;
        }
        int i10 = i5 & 3;
        int i11 = 0;
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 == 3) {
                    i11 = (bArr[i7 + 2] & 255) << 16;
                }
                int i12 = i6 ^ i5;
                int i13 = (i12 ^ (i12 >>> 16)) * (-2048144789);
                int i14 = (i13 ^ (i13 >>> 13)) * (-1028477387);
                return i14 ^ (i14 >>> 16);
            }
            i11 |= (bArr[i7 + 1] & 255) << 8;
        }
        int i15 = ((bArr[i7] & 255) | i11) * (-862048943);
        i6 ^= ((i15 >>> 17) | (i15 << 15)) * 461845907;
        int i122 = i6 ^ i5;
        int i132 = (i122 ^ (i122 >>> 16)) * (-2048144789);
        int i142 = (i132 ^ (i132 >>> 13)) * (-1028477387);
        return i142 ^ (i142 >>> 16);
    }
}
