package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Comparator;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes5.dex */
public final class SignedBytes {
    public static final byte MAX_POWER_OF_TWO = 64;

    /* loaded from: classes5.dex */
    private enum LexicographicalComparator implements Comparator<byte[]> {
        INSTANCE;

        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(byte[] bArr, byte[] bArr2) {
            int min = Math.min(bArr.length, bArr2.length);
            for (int i4 = 0; i4 < min; i4++) {
                int compare = SignedBytes.compare(bArr[i4], bArr2[i4]);
                if (compare != 0) {
                    return compare;
                }
            }
            return bArr.length - bArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "SignedBytes.lexicographicalComparator()";
        }
    }

    private SignedBytes() {
    }

    public static byte checkedCast(long j4) {
        boolean z3;
        byte b4 = (byte) j4;
        if (b4 == j4) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Out of range: %s", j4);
        return b4;
    }

    public static int compare(byte b4, byte b5) {
        return b4 - b5;
    }

    public static String join(String str, byte... bArr) {
        Preconditions.checkNotNull(str);
        if (bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(bArr.length * 5);
        sb.append((int) bArr[0]);
        for (int i4 = 1; i4 < bArr.length; i4++) {
            sb.append(str);
            sb.append((int) bArr[i4]);
        }
        return sb.toString();
    }

    public static Comparator<byte[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static byte max(byte... bArr) {
        boolean z3;
        if (bArr.length > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        byte b4 = bArr[0];
        for (int i4 = 1; i4 < bArr.length; i4++) {
            byte b5 = bArr[i4];
            if (b5 > b4) {
                b4 = b5;
            }
        }
        return b4;
    }

    public static byte min(byte... bArr) {
        boolean z3;
        if (bArr.length > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        byte b4 = bArr[0];
        for (int i4 = 1; i4 < bArr.length; i4++) {
            byte b5 = bArr[i4];
            if (b5 < b4) {
                b4 = b5;
            }
        }
        return b4;
    }

    public static byte saturatedCast(long j4) {
        if (j4 > 127) {
            return Byte.MAX_VALUE;
        }
        if (j4 < -128) {
            return Byte.MIN_VALUE;
        }
        return (byte) j4;
    }

    public static void sortDescending(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        sortDescending(bArr, 0, bArr.length);
    }

    public static void sortDescending(byte[] bArr, int i4, int i5) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkPositionIndexes(i4, i5, bArr.length);
        Arrays.sort(bArr, i4, i5);
        Bytes.reverse(bArr, i4, i5);
    }
}
