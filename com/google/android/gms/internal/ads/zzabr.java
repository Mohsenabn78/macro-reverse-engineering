package com.google.android.gms.internal.ads;

import androidx.compose.animation.core.AnimationKt;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;
import okio.Utf8;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzabr {
    public static int zza(ByteBuffer byteBuffer) {
        byte b4;
        int i4 = byteBuffer.get(26) + Ascii.ESC;
        byte b5 = byteBuffer.get(i4);
        if (byteBuffer.limit() > 1) {
            b4 = byteBuffer.get(i4 + 1);
        } else {
            b4 = 0;
        }
        return (int) ((zze(b5, b4) * 48000) / AnimationKt.MillisToNanos);
    }

    public static int zzb(ByteBuffer byteBuffer) {
        byte b4 = 0;
        byte b5 = byteBuffer.get(0);
        if (byteBuffer.limit() > 1) {
            b4 = byteBuffer.get(1);
        }
        return (int) ((zze(b5, b4) * 48000) / AnimationKt.MillisToNanos);
    }

    public static long zzc(byte[] bArr) {
        byte b4 = 0;
        byte b5 = bArr[0];
        if (bArr.length > 1) {
            b4 = bArr[1];
        }
        return zze(b5, b4);
    }

    public static List zzd(byte[] bArr) {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(bArr);
        arrayList.add(zzg(zzf(((bArr[11] & 255) << 8) | (bArr[10] & 255))));
        arrayList.add(zzg(zzf(3840L)));
        return arrayList;
    }

    private static long zze(byte b4, byte b5) {
        int i4;
        int i5;
        int i6 = b4 & 255;
        int i7 = i6 & 3;
        if (i7 != 0) {
            i4 = 2;
            if (i7 != 1 && i7 != 2) {
                i4 = b5 & Utf8.REPLACEMENT_BYTE;
            }
        } else {
            i4 = 1;
        }
        int i8 = i6 >> 3;
        int i9 = i8 & 3;
        if (i8 >= 16) {
            i5 = 2500 << i9;
        } else if (i8 >= 12) {
            i5 = 10000 << (i9 & 1);
        } else if (i9 == 3) {
            i5 = 60000;
        } else {
            i5 = 10000 << i9;
        }
        return i4 * i5;
    }

    private static long zzf(long j4) {
        return (j4 * 1000000000) / 48000;
    }

    private static byte[] zzg(long j4) {
        return ByteBuffer.allocate(8).order(ByteOrder.nativeOrder()).putLong(j4).array();
    }
}
