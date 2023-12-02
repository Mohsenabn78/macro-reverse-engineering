package com.google.android.gms.internal.play_billing;

import com.google.common.base.Ascii;

/* compiled from: com.android.billingclient:billing@@5.2.0 */
/* loaded from: classes4.dex */
final class zzet extends zzes {
    @Override // com.google.android.gms.internal.play_billing.zzes
    final int zza(int i4, byte[] bArr, int i5, int i6) {
        while (i5 < i6 && bArr[i5] >= 0) {
            i5++;
        }
        if (i5 >= i6) {
            return 0;
        }
        while (i5 < i6) {
            int i7 = i5 + 1;
            byte b4 = bArr[i5];
            if (b4 < 0) {
                if (b4 < -32) {
                    if (i7 >= i6) {
                        return b4;
                    }
                    if (b4 >= -62) {
                        i5 = i7 + 1;
                        if (bArr[i7] > -65) {
                        }
                    }
                    return -1;
                }
                if (b4 < -16) {
                    if (i7 >= i6 - 1) {
                        return zzev.zza(bArr, i7, i6);
                    }
                    int i8 = i7 + 1;
                    byte b5 = bArr[i7];
                    if (b5 <= -65 && ((b4 != -32 || b5 >= -96) && (b4 != -19 || b5 < -96))) {
                        i5 = i8 + 1;
                        if (bArr[i8] > -65) {
                        }
                    }
                } else if (i7 >= i6 - 2) {
                    return zzev.zza(bArr, i7, i6);
                } else {
                    int i9 = i7 + 1;
                    byte b6 = bArr[i7];
                    if (b6 <= -65 && (((b4 << Ascii.FS) + (b6 + 112)) >> 30) == 0) {
                        int i10 = i9 + 1;
                        if (bArr[i9] <= -65) {
                            i7 = i10 + 1;
                            if (bArr[i10] > -65) {
                            }
                        }
                    }
                }
                return -1;
            }
            i5 = i7;
        }
        return 0;
    }
}
