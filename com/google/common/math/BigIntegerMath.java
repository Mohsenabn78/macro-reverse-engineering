package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
/* loaded from: classes5.dex */
public final class BigIntegerMath {
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    static final BigInteger f28052a = new BigInteger("16a09e667f3bcc908b2fb1366ea957d3e3adec17512775099da2f590b0667322a", 16);

    /* renamed from: b  reason: collision with root package name */
    private static final double f28053b = Math.log(10.0d);

    /* renamed from: c  reason: collision with root package name */
    private static final double f28054c = Math.log(2.0d);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.common.math.BigIntegerMath$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f28055a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f28055a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28055a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f28055a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f28055a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f28055a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f28055a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f28055a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f28055a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    /* loaded from: classes5.dex */
    private static class BigIntegerToDoubleRounder extends ToDoubleRounder<BigInteger> {

        /* renamed from: a  reason: collision with root package name */
        static final BigIntegerToDoubleRounder f28056a = new BigIntegerToDoubleRounder();

        private BigIntegerToDoubleRounder() {
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.math.ToDoubleRounder
        /* renamed from: f */
        public BigInteger a(BigInteger bigInteger, BigInteger bigInteger2) {
            return bigInteger.subtract(bigInteger2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.math.ToDoubleRounder
        /* renamed from: g */
        public double c(BigInteger bigInteger) {
            return DoubleUtils.a(bigInteger);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.math.ToDoubleRounder
        /* renamed from: h */
        public int d(BigInteger bigInteger) {
            return bigInteger.signum();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.math.ToDoubleRounder
        /* renamed from: i */
        public BigInteger e(double d4, RoundingMode roundingMode) {
            return DoubleMath.roundToBigInteger(d4, roundingMode);
        }
    }

    private BigIntegerMath() {
    }

    @J2ktIncompatible
    @GwtIncompatible
    static boolean a(BigInteger bigInteger) {
        if (bigInteger.bitLength() <= 63) {
            return true;
        }
        return false;
    }

    static BigInteger b(List<BigInteger> list) {
        return c(list, 0, list.size());
    }

    public static BigInteger binomial(int i4, int i5) {
        boolean z3;
        int i6;
        MathPreconditions.e("n", i4);
        MathPreconditions.e("k", i5);
        int i7 = 1;
        if (i5 <= i4) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "k (%s) > n (%s)", i5, i4);
        if (i5 > (i4 >> 1)) {
            i5 = i4 - i5;
        }
        int[] iArr = LongMath.f28078e;
        if (i5 < iArr.length && i4 <= iArr[i5]) {
            return BigInteger.valueOf(LongMath.binomial(i4, i5));
        }
        BigInteger bigInteger = BigInteger.ONE;
        long j4 = i4;
        int log2 = LongMath.log2(j4, RoundingMode.CEILING);
        long j5 = 1;
        while (true) {
            int i8 = log2;
            while (i7 < i5) {
                i6 = i4 - i7;
                i7++;
                i8 += log2;
                if (i8 >= 63) {
                    break;
                }
                j4 *= i6;
                j5 *= i7;
            }
            return bigInteger.multiply(BigInteger.valueOf(j4)).divide(BigInteger.valueOf(j5));
            bigInteger = bigInteger.multiply(BigInteger.valueOf(j4)).divide(BigInteger.valueOf(j5));
            j4 = i6;
            j5 = i7;
        }
    }

    static BigInteger c(List<BigInteger> list, int i4, int i5) {
        int i6 = i5 - i4;
        if (i6 != 0) {
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 != 3) {
                        int i7 = (i5 + i4) >>> 1;
                        return c(list, i4, i7).multiply(c(list, i7, i5));
                    }
                    return list.get(i4).multiply(list.get(i4 + 1)).multiply(list.get(i4 + 2));
                }
                return list.get(i4).multiply(list.get(i4 + 1));
            }
            return list.get(i4);
        }
        return BigInteger.ONE;
    }

    public static BigInteger ceilingPowerOfTwo(BigInteger bigInteger) {
        return BigInteger.ZERO.setBit(log2(bigInteger, RoundingMode.CEILING));
    }

    @J2ktIncompatible
    @GwtIncompatible
    private static BigInteger d(BigInteger bigInteger) {
        return DoubleMath.roundToBigInteger(Math.sqrt(DoubleUtils.a(bigInteger)), RoundingMode.HALF_EVEN);
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static BigInteger divide(BigInteger bigInteger, BigInteger bigInteger2, RoundingMode roundingMode) {
        return new BigDecimal(bigInteger).divide(new BigDecimal(bigInteger2), 0, roundingMode).toBigIntegerExact();
    }

    @J2ktIncompatible
    @GwtIncompatible
    private static BigInteger e(BigInteger bigInteger) {
        BigInteger shiftLeft;
        int log2 = log2(bigInteger, RoundingMode.FLOOR);
        if (log2 < 1023) {
            shiftLeft = d(bigInteger);
        } else {
            int i4 = (log2 - 52) & (-2);
            shiftLeft = d(bigInteger.shiftRight(i4)).shiftLeft(i4 >> 1);
        }
        BigInteger shiftRight = shiftLeft.add(bigInteger.divide(shiftLeft)).shiftRight(1);
        if (shiftLeft.equals(shiftRight)) {
            return shiftLeft;
        }
        while (true) {
            BigInteger shiftRight2 = shiftRight.add(bigInteger.divide(shiftRight)).shiftRight(1);
            if (shiftRight2.compareTo(shiftRight) >= 0) {
                return shiftRight;
            }
            shiftRight = shiftRight2;
        }
    }

    public static BigInteger factorial(int i4) {
        MathPreconditions.e("n", i4);
        long[] jArr = LongMath.f28077d;
        if (i4 < jArr.length) {
            return BigInteger.valueOf(jArr[i4]);
        }
        ArrayList arrayList = new ArrayList(IntMath.divide(IntMath.log2(i4, RoundingMode.CEILING) * i4, 64, RoundingMode.CEILING));
        int length = jArr.length;
        long j4 = jArr[length - 1];
        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j4);
        long j5 = j4 >> numberOfTrailingZeros;
        int log2 = LongMath.log2(j5, RoundingMode.FLOOR) + 1;
        long j6 = length;
        int log22 = LongMath.log2(j6, RoundingMode.FLOOR) + 1;
        int i5 = 1 << (log22 - 1);
        while (j6 <= i4) {
            if ((i5 & j6) != 0) {
                i5 <<= 1;
                log22++;
            }
            int numberOfTrailingZeros2 = Long.numberOfTrailingZeros(j6);
            long j7 = j6 >> numberOfTrailingZeros2;
            numberOfTrailingZeros += numberOfTrailingZeros2;
            if ((log22 - numberOfTrailingZeros2) + log2 >= 64) {
                arrayList.add(BigInteger.valueOf(j5));
                j5 = 1;
            }
            j5 *= j7;
            log2 = LongMath.log2(j5, RoundingMode.FLOOR) + 1;
            j6++;
        }
        if (j5 > 1) {
            arrayList.add(BigInteger.valueOf(j5));
        }
        return b(arrayList).shiftLeft(numberOfTrailingZeros);
    }

    public static BigInteger floorPowerOfTwo(BigInteger bigInteger) {
        return BigInteger.ZERO.setBit(log2(bigInteger, RoundingMode.FLOOR));
    }

    public static boolean isPowerOfTwo(BigInteger bigInteger) {
        Preconditions.checkNotNull(bigInteger);
        if (bigInteger.signum() > 0 && bigInteger.getLowestSetBit() == bigInteger.bitLength() - 1) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @J2ktIncompatible
    @GwtIncompatible
    public static int log10(BigInteger bigInteger, RoundingMode roundingMode) {
        int i4;
        boolean z3;
        MathPreconditions.j("x", bigInteger);
        if (a(bigInteger)) {
            return LongMath.log10(bigInteger.longValue(), roundingMode);
        }
        int log2 = (int) ((log2(bigInteger, RoundingMode.FLOOR) * f28054c) / f28053b);
        BigInteger pow = BigInteger.TEN.pow(log2);
        int compareTo = pow.compareTo(bigInteger);
        if (compareTo > 0) {
            do {
                log2--;
                pow = pow.divide(BigInteger.TEN);
                i4 = pow.compareTo(bigInteger);
            } while (i4 > 0);
        } else {
            BigInteger multiply = BigInteger.TEN.multiply(pow);
            int i5 = compareTo;
            int compareTo2 = multiply.compareTo(bigInteger);
            while (compareTo2 <= 0) {
                log2++;
                BigInteger multiply2 = BigInteger.TEN.multiply(multiply);
                int compareTo3 = multiply2.compareTo(bigInteger);
                BigInteger bigInteger2 = multiply;
                multiply = multiply2;
                pow = bigInteger2;
                i5 = compareTo2;
                compareTo2 = compareTo3;
            }
            i4 = i5;
        }
        switch (AnonymousClass1.f28055a[roundingMode.ordinal()]) {
            case 1:
                if (i4 == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                MathPreconditions.k(z3);
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                if (!pow.equals(bigInteger)) {
                    return log2 + 1;
                }
                return log2;
            case 6:
            case 7:
            case 8:
                if (bigInteger.pow(2).compareTo(pow.pow(2).multiply(BigInteger.TEN)) > 0) {
                    return log2 + 1;
                }
                return log2;
            default:
                throw new AssertionError();
        }
        return log2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int log2(BigInteger bigInteger, RoundingMode roundingMode) {
        MathPreconditions.j("x", (BigInteger) Preconditions.checkNotNull(bigInteger));
        int bitLength = bigInteger.bitLength() - 1;
        switch (AnonymousClass1.f28055a[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.k(isPowerOfTwo(bigInteger));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                if (!isPowerOfTwo(bigInteger)) {
                    return bitLength + 1;
                }
                return bitLength;
            case 6:
            case 7:
            case 8:
                if (bitLength < 256) {
                    if (bigInteger.compareTo(f28052a.shiftRight(256 - bitLength)) <= 0) {
                        return bitLength;
                    }
                    return bitLength + 1;
                } else if (bigInteger.pow(2).bitLength() - 1 >= (bitLength * 2) + 1) {
                    return bitLength + 1;
                } else {
                    return bitLength;
                }
            default:
                throw new AssertionError();
        }
        return bitLength;
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static double roundToDouble(BigInteger bigInteger, RoundingMode roundingMode) {
        return BigIntegerToDoubleRounder.f28056a.b(bigInteger, roundingMode);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @J2ktIncompatible
    @GwtIncompatible
    public static BigInteger sqrt(BigInteger bigInteger, RoundingMode roundingMode) {
        boolean z3;
        MathPreconditions.g("x", bigInteger);
        if (a(bigInteger)) {
            return BigInteger.valueOf(LongMath.sqrt(bigInteger.longValue(), roundingMode));
        }
        BigInteger e4 = e(bigInteger);
        switch (AnonymousClass1.f28055a[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.k(e4.pow(2).equals(bigInteger));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                int intValue = e4.intValue();
                if (intValue * intValue == bigInteger.intValue() && e4.pow(2).equals(bigInteger)) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (!z3) {
                    return e4.add(BigInteger.ONE);
                }
                return e4;
            case 6:
            case 7:
            case 8:
                if (e4.pow(2).add(e4).compareTo(bigInteger) < 0) {
                    return e4.add(BigInteger.ONE);
                }
                return e4;
            default:
                throw new AssertionError();
        }
        return e4;
    }
}
