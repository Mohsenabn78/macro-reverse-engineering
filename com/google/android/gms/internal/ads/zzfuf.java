package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfuf {
    private static final OutputStream zza = new zzfue();

    public static byte[] zza(InputStream inputStream) throws IOException {
        int i4;
        inputStream.getClass();
        ArrayDeque arrayDeque = new ArrayDeque(20);
        int highestOneBit = Integer.highestOneBit(0);
        int min = Math.min(8192, Math.max(128, highestOneBit + highestOneBit));
        int i5 = 0;
        while (i5 < 2147483639) {
            int min2 = Math.min(min, 2147483639 - i5);
            byte[] bArr = new byte[min2];
            arrayDeque.add(bArr);
            int i6 = 0;
            while (i6 < min2) {
                int read = inputStream.read(bArr, i6, min2 - i6);
                if (read == -1) {
                    return zzb(arrayDeque, i5);
                }
                i6 += read;
                i5 += read;
            }
            if (min < 4096) {
                i4 = 4;
            } else {
                i4 = 2;
            }
            min = zzfuk.zzc(min * i4);
        }
        if (inputStream.read() == -1) {
            return zzb(arrayDeque, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    private static byte[] zzb(Queue queue, int i4) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] bArr = (byte[]) queue.remove();
        int length = bArr.length;
        if (length == i4) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, i4);
        int i5 = i4 - length;
        while (i5 > 0) {
            byte[] bArr2 = (byte[]) queue.remove();
            int min = Math.min(i5, bArr2.length);
            System.arraycopy(bArr2, 0, copyOf, i4 - i5, min);
            i5 -= min;
        }
        return copyOf;
    }
}
