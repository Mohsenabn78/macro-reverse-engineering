package com.google.android.gms.internal.icing;

import com.google.common.base.Ascii;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
final class zzfp extends zzfo {
    @Override // com.google.android.gms.internal.icing.zzfo
    final int zzb(int i4, byte[] bArr, int i5, int i6) {
        int i7 = 0;
        while (i7 < i6 && bArr[i7] >= 0) {
            i7++;
        }
        if (i7 >= i6) {
            return 0;
        }
        while (i7 < i6) {
            int i8 = i7 + 1;
            byte b4 = bArr[i7];
            if (b4 < 0) {
                if (b4 < -32) {
                    if (i8 < i6) {
                        if (b4 >= -62) {
                            i7 = i8 + 1;
                            if (bArr[i8] > -65) {
                            }
                        }
                        return -1;
                    }
                    return b4;
                }
                if (b4 < -16) {
                    if (i8 >= i6 - 1) {
                        return zzfr.zze(bArr, i8, i6);
                    }
                    int i9 = i8 + 1;
                    byte b5 = bArr[i8];
                    if (b5 <= -65 && ((b4 != -32 || b5 >= -96) && (b4 != -19 || b5 < -96))) {
                        i7 = i9 + 1;
                        if (bArr[i9] > -65) {
                        }
                    }
                } else if (i8 >= i6 - 2) {
                    return zzfr.zze(bArr, i8, i6);
                } else {
                    int i10 = i8 + 1;
                    byte b6 = bArr[i8];
                    if (b6 <= -65 && (((b4 << Ascii.FS) + (b6 + 112)) >> 30) == 0) {
                        int i11 = i10 + 1;
                        if (bArr[i10] <= -65) {
                            i8 = i11 + 1;
                            if (bArr[i11] > -65) {
                            }
                        }
                    }
                }
                return -1;
            }
            i7 = i8;
        }
        return 0;
    }
}
