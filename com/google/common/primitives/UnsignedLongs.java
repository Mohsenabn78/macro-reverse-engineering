package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes5.dex */
public final class UnsignedLongs {
    public static final long MAX_VALUE = -1;

    /* loaded from: classes5.dex */
    enum LexicographicalComparator implements Comparator<long[]> {
        INSTANCE;

        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(long[] jArr, long[] jArr2) {
            int min = Math.min(jArr.length, jArr2.length);
            for (int i4 = 0; i4 < min; i4++) {
                long j4 = jArr[i4];
                long j5 = jArr2[i4];
                if (j4 != j5) {
                    return UnsignedLongs.compare(j4, j5);
                }
            }
            return jArr.length - jArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedLongs.lexicographicalComparator()";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class ParseOverflowDetection {

        /* renamed from: a  reason: collision with root package name */
        static final long[] f28195a = new long[37];

        /* renamed from: b  reason: collision with root package name */
        static final int[] f28196b = new int[37];

        /* renamed from: c  reason: collision with root package name */
        static final int[] f28197c = new int[37];

        static {
            BigInteger bigInteger = new BigInteger("10000000000000000", 16);
            for (int i4 = 2; i4 <= 36; i4++) {
                long j4 = i4;
                f28195a[i4] = UnsignedLongs.divide(-1L, j4);
                f28196b[i4] = (int) UnsignedLongs.remainder(-1L, j4);
                f28197c[i4] = bigInteger.toString(i4).length() - 1;
            }
        }

        private ParseOverflowDetection() {
        }

        static boolean a(long j4, int i4, int i5) {
            if (j4 < 0) {
                return true;
            }
            long j5 = f28195a[i5];
            if (j4 < j5) {
                return false;
            }
            if (j4 > j5 || i4 > f28196b[i5]) {
                return true;
            }
            return false;
        }
    }

    private UnsignedLongs() {
    }

    private static long a(long j4) {
        return j4 ^ Long.MIN_VALUE;
    }

    public static int compare(long j4, long j5) {
        return Longs.compare(a(j4), a(j5));
    }

    @CanIgnoreReturnValue
    public static long decode(String str) {
        ParseRequest a4 = ParseRequest.a(str);
        try {
            return parseUnsignedLong(a4.f28173a, a4.f28174b);
        } catch (NumberFormatException e4) {
            NumberFormatException numberFormatException = new NumberFormatException("Error parsing value: " + str);
            numberFormatException.initCause(e4);
            throw numberFormatException;
        }
    }

    public static long divide(long j4, long j5) {
        if (j5 < 0) {
            if (compare(j4, j5) < 0) {
                return 0L;
            }
            return 1L;
        } else if (j4 >= 0) {
            return j4 / j5;
        } else {
            int i4 = 1;
            long j6 = ((j4 >>> 1) / j5) << 1;
            if (compare(j4 - (j6 * j5), j5) < 0) {
                i4 = 0;
            }
            return j6 + i4;
        }
    }

    public static String join(String str, long... jArr) {
        Preconditions.checkNotNull(str);
        if (jArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(jArr.length * 5);
        sb.append(toString(jArr[0]));
        for (int i4 = 1; i4 < jArr.length; i4++) {
            sb.append(str);
            sb.append(toString(jArr[i4]));
        }
        return sb.toString();
    }

    public static Comparator<long[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static long max(long... jArr) {
        boolean z3;
        if (jArr.length > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        long a4 = a(jArr[0]);
        for (int i4 = 1; i4 < jArr.length; i4++) {
            long a5 = a(jArr[i4]);
            if (a5 > a4) {
                a4 = a5;
            }
        }
        return a(a4);
    }

    public static long min(long... jArr) {
        boolean z3;
        if (jArr.length > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        long a4 = a(jArr[0]);
        for (int i4 = 1; i4 < jArr.length; i4++) {
            long a5 = a(jArr[i4]);
            if (a5 < a4) {
                a4 = a5;
            }
        }
        return a(a4);
    }

    @CanIgnoreReturnValue
    public static long parseUnsignedLong(String str) {
        return parseUnsignedLong(str, 10);
    }

    public static long remainder(long j4, long j5) {
        if (j5 < 0) {
            if (compare(j4, j5) < 0) {
                return j4;
            }
            return j4 - j5;
        } else if (j4 >= 0) {
            return j4 % j5;
        } else {
            long j6 = j4 - ((((j4 >>> 1) / j5) << 1) * j5);
            if (compare(j6, j5) < 0) {
                j5 = 0;
            }
            return j6 - j5;
        }
    }

    public static void sort(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        sort(jArr, 0, jArr.length);
    }

    public static void sortDescending(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        sortDescending(jArr, 0, jArr.length);
    }

    public static String toString(long j4) {
        return toString(j4, 10);
    }

    @CanIgnoreReturnValue
    public static long parseUnsignedLong(String str, int i4) {
        Preconditions.checkNotNull(str);
        if (str.length() != 0) {
            if (i4 >= 2 && i4 <= 36) {
                int i5 = ParseOverflowDetection.f28197c[i4] - 1;
                long j4 = 0;
                for (int i6 = 0; i6 < str.length(); i6++) {
                    int digit = Character.digit(str.charAt(i6), i4);
                    if (digit != -1) {
                        if (i6 > i5 && ParseOverflowDetection.a(j4, digit, i4)) {
                            throw new NumberFormatException("Too large for unsigned long: " + str);
                        }
                        j4 = (j4 * i4) + digit;
                    } else {
                        throw new NumberFormatException(str);
                    }
                }
                return j4;
            }
            throw new NumberFormatException("illegal radix: " + i4);
        }
        throw new NumberFormatException("empty string");
    }

    public static String toString(long j4, int i4) {
        long divide;
        Preconditions.checkArgument(i4 >= 2 && i4 <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", i4);
        int i5 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
        if (i5 == 0) {
            return "0";
        }
        if (i5 > 0) {
            return Long.toString(j4, i4);
        }
        int i6 = 64;
        char[] cArr = new char[64];
        int i7 = i4 - 1;
        if ((i4 & i7) == 0) {
            int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i4);
            do {
                i6--;
                cArr[i6] = Character.forDigit(((int) j4) & i7, i4);
                j4 >>>= numberOfTrailingZeros;
            } while (j4 != 0);
        } else {
            if ((i4 & 1) == 0) {
                divide = (j4 >>> 1) / (i4 >>> 1);
            } else {
                divide = divide(j4, i4);
            }
            long j5 = i4;
            int i8 = 63;
            cArr[63] = Character.forDigit((int) (j4 - (divide * j5)), i4);
            while (divide > 0) {
                i8--;
                cArr[i8] = Character.forDigit((int) (divide % j5), i4);
                divide /= j5;
            }
            i6 = i8;
        }
        return new String(cArr, i6, 64 - i6);
    }

    public static void sort(long[] jArr, int i4, int i5) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i4, i5, jArr.length);
        for (int i6 = i4; i6 < i5; i6++) {
            jArr[i6] = a(jArr[i6]);
        }
        Arrays.sort(jArr, i4, i5);
        while (i4 < i5) {
            jArr[i4] = a(jArr[i4]);
            i4++;
        }
    }

    public static void sortDescending(long[] jArr, int i4, int i5) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i4, i5, jArr.length);
        for (int i6 = i4; i6 < i5; i6++) {
            jArr[i6] = Long.MAX_VALUE ^ jArr[i6];
        }
        Arrays.sort(jArr, i4, i5);
        while (i4 < i5) {
            jArr[i4] = jArr[i4] ^ Long.MAX_VALUE;
            i4++;
        }
    }
}
