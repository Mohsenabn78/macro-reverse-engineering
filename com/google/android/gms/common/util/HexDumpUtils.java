package com.google.android.gms.common.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@KeepForSdk
/* loaded from: classes4.dex */
public final class HexDumpUtils {
    @Nullable
    @KeepForSdk
    public static String dump(@NonNull byte[] bArr, int i4, int i5, boolean z3) {
        int length;
        int i6;
        if (bArr != null && (length = bArr.length) != 0 && i4 >= 0 && i5 > 0 && i4 + i5 <= length) {
            if (z3) {
                i6 = 75;
            } else {
                i6 = 57;
            }
            StringBuilder sb = new StringBuilder(i6 * ((i5 + 15) / 16));
            int i7 = i5;
            int i8 = 0;
            int i9 = 0;
            while (i7 > 0) {
                if (i8 == 0) {
                    if (i5 < 65536) {
                        sb.append(String.format("%04X:", Integer.valueOf(i4)));
                    } else {
                        sb.append(String.format("%08X:", Integer.valueOf(i4)));
                    }
                    i9 = i4;
                } else if (i8 == 8) {
                    sb.append(" -");
                }
                sb.append(String.format(" %02X", Integer.valueOf(bArr[i4] & 255)));
                i7--;
                i8++;
                if (z3 && (i8 == 16 || i7 == 0)) {
                    int i10 = 16 - i8;
                    if (i10 > 0) {
                        for (int i11 = 0; i11 < i10; i11++) {
                            sb.append("   ");
                        }
                    }
                    if (i10 >= 8) {
                        sb.append("  ");
                    }
                    sb.append("  ");
                    for (int i12 = 0; i12 < i8; i12++) {
                        char c4 = (char) bArr[i9 + i12];
                        if (c4 < ' ' || c4 > '~') {
                            c4 = '.';
                        }
                        sb.append(c4);
                    }
                }
                if (i8 == 16 || i7 == 0) {
                    sb.append('\n');
                    i8 = 0;
                }
                i4++;
            }
            return sb.toString();
        }
        return null;
    }
}
