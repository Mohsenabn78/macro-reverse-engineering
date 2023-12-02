package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.math.BigInteger;
import java.math.RoundingMode;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes5.dex */
final class MathPreconditions {
    private MathPreconditions() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z3, double d4, RoundingMode roundingMode) {
        if (z3) {
            return;
        }
        throw new ArithmeticException("rounded value is out of range for input " + d4 + " and rounding mode " + roundingMode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(boolean z3, String str, int i4, int i5) {
        if (z3) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + "(" + i4 + ", " + i5 + ")");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(boolean z3, String str, long j4, long j5) {
        if (z3) {
            return;
        }
        throw new ArithmeticException("overflow: " + str + "(" + j4 + ", " + j5 + ")");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public static double d(String str, double d4) {
        if (d4 >= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return d4;
        }
        throw new IllegalArgumentException(str + " (" + d4 + ") must be >= 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public static int e(String str, int i4) {
        if (i4 >= 0) {
            return i4;
        }
        throw new IllegalArgumentException(str + " (" + i4 + ") must be >= 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public static long f(String str, long j4) {
        if (j4 >= 0) {
            return j4;
        }
        throw new IllegalArgumentException(str + " (" + j4 + ") must be >= 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public static BigInteger g(String str, BigInteger bigInteger) {
        if (bigInteger.signum() >= 0) {
            return bigInteger;
        }
        throw new IllegalArgumentException(str + " (" + bigInteger + ") must be >= 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public static int h(String str, int i4) {
        if (i4 > 0) {
            return i4;
        }
        throw new IllegalArgumentException(str + " (" + i4 + ") must be > 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public static long i(String str, long j4) {
        if (j4 > 0) {
            return j4;
        }
        throw new IllegalArgumentException(str + " (" + j4 + ") must be > 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public static BigInteger j(String str, BigInteger bigInteger) {
        if (bigInteger.signum() > 0) {
            return bigInteger;
        }
        throw new IllegalArgumentException(str + " (" + bigInteger + ") must be > 0");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void k(boolean z3) {
        if (z3) {
            return;
        }
        throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
    }
}
