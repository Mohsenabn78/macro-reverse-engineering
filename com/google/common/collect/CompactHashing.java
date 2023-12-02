package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Objects;
import java.util.Arrays;
import javax.annotation.CheckForNull;
import kotlin.UShort;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
final class CompactHashing {
    private CompactHashing() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object a(int i4) {
        if (i4 >= 2 && i4 <= 1073741824 && Integer.highestOneBit(i4) == i4) {
            if (i4 <= 256) {
                return new byte[i4];
            }
            if (i4 <= 65536) {
                return new short[i4];
            }
            return new int[i4];
        }
        throw new IllegalArgumentException("must be power of 2 between 2^1 and 2^30: " + i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(int i4, int i5) {
        return i4 & (~i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(int i4, int i5) {
        return i4 & i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(int i4, int i5, int i6) {
        return (i4 & (~i6)) | (i5 & i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int e(int i4) {
        int i5;
        if (i4 < 32) {
            i5 = 4;
        } else {
            i5 = 2;
        }
        return i5 * (i4 + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(@CheckForNull Object obj, @CheckForNull Object obj2, int i4, Object obj3, int[] iArr, Object[] objArr, @CheckForNull Object[] objArr2) {
        int i5;
        int i6;
        int d4 = Hashing.d(obj);
        int i7 = d4 & i4;
        int h4 = h(obj3, i7);
        if (h4 == 0) {
            return -1;
        }
        int b4 = b(d4, i4);
        int i8 = -1;
        while (true) {
            i5 = h4 - 1;
            i6 = iArr[i5];
            if (b(i6, i4) != b4 || !Objects.equal(obj, objArr[i5]) || (objArr2 != null && !Objects.equal(obj2, objArr2[i5]))) {
                int c4 = c(i6, i4);
                if (c4 == 0) {
                    return -1;
                }
                i8 = i5;
                h4 = c4;
            }
        }
        int c5 = c(i6, i4);
        if (i8 == -1) {
            i(obj3, i7, c5);
        } else {
            iArr[i8] = d(iArr[i8], c5, i4);
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(Object obj) {
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int h(Object obj, int i4) {
        if (obj instanceof byte[]) {
            return ((byte[]) obj)[i4] & 255;
        }
        if (obj instanceof short[]) {
            return ((short[]) obj)[i4] & UShort.MAX_VALUE;
        }
        return ((int[]) obj)[i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(Object obj, int i4, int i5) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i4] = (byte) i5;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i4] = (short) i5;
        } else {
            ((int[]) obj)[i4] = i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int j(int i4) {
        return Math.max(4, Hashing.a(i4 + 1, 1.0d));
    }
}
