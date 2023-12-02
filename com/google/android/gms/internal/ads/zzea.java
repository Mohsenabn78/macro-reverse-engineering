package com.google.android.gms.internal.ads;

import androidx.exifinterface.media.ExifInterface;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzea {
    public static final /* synthetic */ int zza = 0;
    private static final byte[] zzb = {0, 0, 0, 1};
    private static final String[] zzc = {"", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C"};

    public static String zza(int i4, int i5, int i6) {
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
    }

    public static String zzb(int i4, boolean z3, int i5, int i6, int[] iArr, int i7) {
        char c4;
        Object[] objArr = new Object[5];
        objArr[0] = zzc[i4];
        objArr[1] = Integer.valueOf(i5);
        objArr[2] = Integer.valueOf(i6);
        if (true != z3) {
            c4 = 'L';
        } else {
            c4 = 'H';
        }
        objArr[3] = Character.valueOf(c4);
        objArr[4] = Integer.valueOf(i7);
        StringBuilder sb = new StringBuilder(String.format(Locale.US, "hvc1.%s%d.%X.%c%d", objArr));
        int i8 = 6;
        while (i8 > 0) {
            int i9 = i8 - 1;
            if (iArr[i9] != 0) {
                break;
            }
            i8 = i9;
        }
        for (int i10 = 0; i10 < i8; i10++) {
            sb.append(String.format(".%02X", Integer.valueOf(iArr[i10])));
        }
        return sb.toString();
    }

    public static byte[] zzc(byte[] bArr, int i4, int i5) {
        byte[] bArr2 = new byte[i5 + 4];
        System.arraycopy(zzb, 0, bArr2, 0, 4);
        System.arraycopy(bArr, i4, bArr2, 4, i5);
        return bArr2;
    }
}
