package com.google.cloud.datastore.core.number;

/* loaded from: classes5.dex */
public final class NumberComparisonHelper {
    public static final double LONG_EXCLUSIVE_UPPER_BOUND_AS_DOUBLE = 9.223372036854776E18d;
    public static final double LONG_INCLUSIVE_LOWER_BOUND_AS_DOUBLE = -9.223372036854776E18d;
    public static final long MAX_SAFE_LONG = 9007199254740992L;
    public static final long MIN_SAFE_LONG = -9007199254740992L;

    private NumberComparisonHelper() {
    }

    public static int compareLongs(long j4, long j5) {
        int i4 = (j4 > j5 ? 1 : (j4 == j5 ? 0 : -1));
        if (i4 < 0) {
            return -1;
        }
        if (i4 > 0) {
            return 1;
        }
        return 0;
    }

    public static int firestoreCompareDoubleWithLong(double d4, long j4) {
        if (Double.isNaN(d4) || d4 < -9.223372036854776E18d) {
            return -1;
        }
        if (d4 >= 9.223372036854776E18d) {
            return 1;
        }
        int compareLongs = compareLongs((long) d4, j4);
        if (compareLongs != 0) {
            return compareLongs;
        }
        return firestoreCompareDoubles(d4, j4);
    }

    public static int firestoreCompareDoubles(double d4, double d5) {
        if (d4 < d5) {
            return -1;
        }
        int i4 = (d4 > d5 ? 1 : (d4 == d5 ? 0 : -1));
        if (i4 > 0) {
            return 1;
        }
        if (i4 == 0) {
            return 0;
        }
        if (!Double.isNaN(d5)) {
            return -1;
        }
        if (!Double.isNaN(d4)) {
            return 1;
        }
        return 0;
    }
}
