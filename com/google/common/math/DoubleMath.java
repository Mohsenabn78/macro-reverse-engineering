package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Iterator;

@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
/* loaded from: classes5.dex */
public final class DoubleMath {

    /* renamed from: a  reason: collision with root package name */
    private static final double f28057a = Math.log(2.0d);
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    static final double[] f28058b = {1.0d, 2.0922789888E13d, 2.631308369336935E35d, 1.2413915592536073E61d, 1.2688693218588417E89d, 7.156945704626381E118d, 9.916779348709496E149d, 1.974506857221074E182d, 3.856204823625804E215d, 5.5502938327393044E249d, 4.7147236359920616E284d};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.common.math.DoubleMath$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f28059a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f28059a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28059a[RoundingMode.FLOOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f28059a[RoundingMode.CEILING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f28059a[RoundingMode.DOWN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f28059a[RoundingMode.UP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f28059a[RoundingMode.HALF_EVEN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f28059a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f28059a[RoundingMode.HALF_DOWN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private DoubleMath() {
    }

    @CanIgnoreReturnValue
    @J2ktIncompatible
    @GwtIncompatible
    private static double a(double d4) {
        Preconditions.checkArgument(DoubleUtils.d(d4));
        return d4;
    }

    @J2ktIncompatible
    @GwtIncompatible
    static double b(double d4, RoundingMode roundingMode) {
        int i4;
        if (DoubleUtils.d(d4)) {
            switch (AnonymousClass1.f28059a[roundingMode.ordinal()]) {
                case 1:
                    MathPreconditions.k(isMathematicalInteger(d4));
                    return d4;
                case 2:
                    if (d4 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && !isMathematicalInteger(d4)) {
                        return ((long) d4) - 1;
                    }
                    return d4;
                case 3:
                    if (d4 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && !isMathematicalInteger(d4)) {
                        return ((long) d4) + 1;
                    }
                    return d4;
                case 4:
                    return d4;
                case 5:
                    if (isMathematicalInteger(d4)) {
                        return d4;
                    }
                    long j4 = (long) d4;
                    if (d4 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                        i4 = 1;
                    } else {
                        i4 = -1;
                    }
                    return j4 + i4;
                case 6:
                    return Math.rint(d4);
                case 7:
                    double rint = Math.rint(d4);
                    if (Math.abs(d4 - rint) == 0.5d) {
                        return d4 + Math.copySign(0.5d, d4);
                    }
                    return rint;
                case 8:
                    double rint2 = Math.rint(d4);
                    if (Math.abs(d4 - rint2) == 0.5d) {
                        return d4;
                    }
                    return rint2;
                default:
                    throw new AssertionError();
            }
        }
        throw new ArithmeticException("input is infinite or NaN");
    }

    public static double factorial(int i4) {
        MathPreconditions.e("n", i4);
        if (i4 > 170) {
            return Double.POSITIVE_INFINITY;
        }
        double d4 = 1.0d;
        for (int i5 = (i4 & (-16)) + 1; i5 <= i4; i5++) {
            d4 *= i5;
        }
        return d4 * f28058b[i4 >> 4];
    }

    public static int fuzzyCompare(double d4, double d5, double d6) {
        if (fuzzyEquals(d4, d5, d6)) {
            return 0;
        }
        if (d4 < d5) {
            return -1;
        }
        if (d4 > d5) {
            return 1;
        }
        return Booleans.compare(Double.isNaN(d4), Double.isNaN(d5));
    }

    public static boolean fuzzyEquals(double d4, double d5, double d6) {
        MathPreconditions.d("tolerance", d6);
        if (Math.copySign(d4 - d5, 1.0d) > d6 && d4 != d5 && (!Double.isNaN(d4) || !Double.isNaN(d5))) {
            return false;
        }
        return true;
    }

    @GwtIncompatible
    public static boolean isMathematicalInteger(double d4) {
        if (DoubleUtils.d(d4) && (d4 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || 52 - Long.numberOfTrailingZeros(DoubleUtils.c(d4)) <= Math.getExponent(d4))) {
            return true;
        }
        return false;
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static boolean isPowerOfTwo(double d4) {
        if (d4 <= FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE || !DoubleUtils.d(d4)) {
            return false;
        }
        long c4 = DoubleUtils.c(d4);
        if ((c4 & (c4 - 1)) != 0) {
            return false;
        }
        return true;
    }

    public static double log2(double d4) {
        return Math.log(d4) / f28057a;
    }

    @J2ktIncompatible
    @GwtIncompatible
    @Deprecated
    public static double mean(double... dArr) {
        Preconditions.checkArgument(dArr.length > 0, "Cannot take mean of 0 values");
        double a4 = a(dArr[0]);
        long j4 = 1;
        for (int i4 = 1; i4 < dArr.length; i4++) {
            a(dArr[i4]);
            j4++;
            a4 += (dArr[i4] - a4) / j4;
        }
        return a4;
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static BigInteger roundToBigInteger(double d4, RoundingMode roundingMode) {
        boolean z3;
        double b4 = b(d4, roundingMode);
        boolean z4 = true;
        if ((-9.223372036854776E18d) - b4 < 1.0d) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (b4 >= 9.223372036854776E18d) {
            z4 = false;
        }
        if (z4 & z3) {
            return BigInteger.valueOf((long) b4);
        }
        BigInteger shiftLeft = BigInteger.valueOf(DoubleUtils.c(b4)).shiftLeft(Math.getExponent(b4) - 52);
        if (b4 < FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return shiftLeft.negate();
        }
        return shiftLeft;
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static int roundToInt(double d4, RoundingMode roundingMode) {
        boolean z3;
        double b4 = b(d4, roundingMode);
        boolean z4 = true;
        if (b4 > -2.147483649E9d) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (b4 >= 2.147483648E9d) {
            z4 = false;
        }
        MathPreconditions.a(z3 & z4, d4, roundingMode);
        return (int) b4;
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static long roundToLong(double d4, RoundingMode roundingMode) {
        boolean z3;
        double b4 = b(d4, roundingMode);
        boolean z4 = true;
        if ((-9.223372036854776E18d) - b4 < 1.0d) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (b4 >= 9.223372036854776E18d) {
            z4 = false;
        }
        MathPreconditions.a(z3 & z4, d4, roundingMode);
        return (long) b4;
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static int log2(double d4, RoundingMode roundingMode) {
        boolean isPowerOfTwo;
        Preconditions.checkArgument(d4 > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE && DoubleUtils.d(d4), "x must be positive and finite");
        int exponent = Math.getExponent(d4);
        if (!DoubleUtils.e(d4)) {
            return log2(d4 * 4.503599627370496E15d, roundingMode) - 52;
        }
        switch (AnonymousClass1.f28059a[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.k(isPowerOfTwo(d4));
                break;
            case 2:
                break;
            case 3:
                r2 = !isPowerOfTwo(d4);
                break;
            case 4:
                r2 = exponent < 0;
                isPowerOfTwo = isPowerOfTwo(d4);
                r2 &= !isPowerOfTwo;
                break;
            case 5:
                r2 = exponent >= 0;
                isPowerOfTwo = isPowerOfTwo(d4);
                r2 &= !isPowerOfTwo;
                break;
            case 6:
            case 7:
            case 8:
                double g4 = DoubleUtils.g(d4);
                if (g4 * g4 > 2.0d) {
                    r2 = true;
                    break;
                }
                break;
            default:
                throw new AssertionError();
        }
        return r2 ? exponent + 1 : exponent;
    }

    @Deprecated
    public static double mean(int... iArr) {
        Preconditions.checkArgument(iArr.length > 0, "Cannot take mean of 0 values");
        long j4 = 0;
        for (int i4 : iArr) {
            j4 += i4;
        }
        return j4 / iArr.length;
    }

    @Deprecated
    public static double mean(long... jArr) {
        Preconditions.checkArgument(jArr.length > 0, "Cannot take mean of 0 values");
        double d4 = jArr[0];
        long j4 = 1;
        for (int i4 = 1; i4 < jArr.length; i4++) {
            j4++;
            d4 += (jArr[i4] - d4) / j4;
        }
        return d4;
    }

    @J2ktIncompatible
    @GwtIncompatible
    @Deprecated
    public static double mean(Iterable<? extends Number> iterable) {
        return mean(iterable.iterator());
    }

    @J2ktIncompatible
    @GwtIncompatible
    @Deprecated
    public static double mean(Iterator<? extends Number> it) {
        Preconditions.checkArgument(it.hasNext(), "Cannot take mean of 0 values");
        double a4 = a(it.next().doubleValue());
        long j4 = 1;
        while (it.hasNext()) {
            j4++;
            a4 += (a(it.next().doubleValue()) - a4) / j4;
        }
        return a4;
    }
}
