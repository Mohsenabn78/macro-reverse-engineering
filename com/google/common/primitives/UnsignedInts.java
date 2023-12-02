package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Comparator;
import javax.mail.UIDFolder;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes5.dex */
public final class UnsignedInts {

    /* loaded from: classes5.dex */
    enum LexicographicalComparator implements Comparator<int[]> {
        INSTANCE;

        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(int[] iArr, int[] iArr2) {
            int min = Math.min(iArr.length, iArr2.length);
            for (int i4 = 0; i4 < min; i4++) {
                int i5 = iArr[i4];
                int i6 = iArr2[i4];
                if (i5 != i6) {
                    return UnsignedInts.compare(i5, i6);
                }
            }
            return iArr.length - iArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "UnsignedInts.lexicographicalComparator()";
        }
    }

    private UnsignedInts() {
    }

    static int a(int i4) {
        return i4 ^ Integer.MIN_VALUE;
    }

    public static int checkedCast(long j4) {
        boolean z3;
        if ((j4 >> 32) == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "out of range: %s", j4);
        return (int) j4;
    }

    public static int compare(int i4, int i5) {
        return Ints.compare(a(i4), a(i5));
    }

    @CanIgnoreReturnValue
    public static int decode(String str) {
        ParseRequest a4 = ParseRequest.a(str);
        try {
            return parseUnsignedInt(a4.f28173a, a4.f28174b);
        } catch (NumberFormatException e4) {
            NumberFormatException numberFormatException = new NumberFormatException("Error parsing value: " + str);
            numberFormatException.initCause(e4);
            throw numberFormatException;
        }
    }

    public static int divide(int i4, int i5) {
        return (int) (toLong(i4) / toLong(i5));
    }

    public static String join(String str, int... iArr) {
        Preconditions.checkNotNull(str);
        if (iArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(iArr.length * 5);
        sb.append(toString(iArr[0]));
        for (int i4 = 1; i4 < iArr.length; i4++) {
            sb.append(str);
            sb.append(toString(iArr[i4]));
        }
        return sb.toString();
    }

    public static Comparator<int[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static int max(int... iArr) {
        boolean z3;
        if (iArr.length > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        int a4 = a(iArr[0]);
        for (int i4 = 1; i4 < iArr.length; i4++) {
            int a5 = a(iArr[i4]);
            if (a5 > a4) {
                a4 = a5;
            }
        }
        return a(a4);
    }

    public static int min(int... iArr) {
        boolean z3;
        if (iArr.length > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        int a4 = a(iArr[0]);
        for (int i4 = 1; i4 < iArr.length; i4++) {
            int a5 = a(iArr[i4]);
            if (a5 < a4) {
                a4 = a5;
            }
        }
        return a(a4);
    }

    @CanIgnoreReturnValue
    public static int parseUnsignedInt(String str) {
        return parseUnsignedInt(str, 10);
    }

    public static int remainder(int i4, int i5) {
        return (int) (toLong(i4) % toLong(i5));
    }

    public static int saturatedCast(long j4) {
        if (j4 <= 0) {
            return 0;
        }
        if (j4 >= 4294967296L) {
            return -1;
        }
        return (int) j4;
    }

    public static void sort(int[] iArr) {
        Preconditions.checkNotNull(iArr);
        sort(iArr, 0, iArr.length);
    }

    public static void sortDescending(int[] iArr) {
        Preconditions.checkNotNull(iArr);
        sortDescending(iArr, 0, iArr.length);
    }

    public static long toLong(int i4) {
        return i4 & UIDFolder.MAXUID;
    }

    public static String toString(int i4) {
        return toString(i4, 10);
    }

    @CanIgnoreReturnValue
    public static int parseUnsignedInt(String str, int i4) {
        Preconditions.checkNotNull(str);
        long parseLong = Long.parseLong(str, i4);
        if ((UIDFolder.MAXUID & parseLong) == parseLong) {
            return (int) parseLong;
        }
        throw new NumberFormatException("Input " + str + " in base " + i4 + " is not in the range of an unsigned integer");
    }

    public static String toString(int i4, int i5) {
        return Long.toString(i4 & UIDFolder.MAXUID, i5);
    }

    public static void sort(int[] iArr, int i4, int i5) {
        Preconditions.checkNotNull(iArr);
        Preconditions.checkPositionIndexes(i4, i5, iArr.length);
        for (int i6 = i4; i6 < i5; i6++) {
            iArr[i6] = a(iArr[i6]);
        }
        Arrays.sort(iArr, i4, i5);
        while (i4 < i5) {
            iArr[i4] = a(iArr[i4]);
            i4++;
        }
    }

    public static void sortDescending(int[] iArr, int i4, int i5) {
        Preconditions.checkNotNull(iArr);
        Preconditions.checkPositionIndexes(i4, i5, iArr.length);
        for (int i6 = i4; i6 < i5; i6++) {
            iArr[i6] = Integer.MAX_VALUE ^ iArr[i6];
        }
        Arrays.sort(iArr, i4, i5);
        while (i4 < i5) {
            iArr[i4] = iArr[i4] ^ Integer.MAX_VALUE;
            i4++;
        }
    }
}
