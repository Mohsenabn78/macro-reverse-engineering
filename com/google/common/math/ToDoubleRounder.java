package com.google.common.math;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import java.lang.Comparable;
import java.lang.Number;
import java.math.RoundingMode;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes5.dex */
abstract class ToDoubleRounder<X extends Number & Comparable<X>> {

    /* renamed from: com.google.common.math.ToDoubleRounder$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f28098a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f28098a = iArr;
            try {
                iArr[RoundingMode.DOWN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28098a[RoundingMode.HALF_EVEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f28098a[RoundingMode.HALF_DOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f28098a[RoundingMode.HALF_UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f28098a[RoundingMode.FLOOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f28098a[RoundingMode.CEILING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f28098a[RoundingMode.UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f28098a[RoundingMode.UNNECESSARY.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    abstract X a(X x3, X x4);

    /* JADX INFO: Access modifiers changed from: package-private */
    public final double b(X x3, RoundingMode roundingMode) {
        X x4;
        double d4;
        boolean z3;
        Preconditions.checkNotNull(x3, "x");
        Preconditions.checkNotNull(roundingMode, "mode");
        double c4 = c(x3);
        if (Double.isInfinite(c4)) {
            switch (AnonymousClass1.f28098a[roundingMode.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    return d(x3) * Double.MAX_VALUE;
                case 5:
                    if (c4 != Double.POSITIVE_INFINITY) {
                        return Double.NEGATIVE_INFINITY;
                    }
                    return Double.MAX_VALUE;
                case 6:
                    if (c4 == Double.POSITIVE_INFINITY) {
                        return Double.POSITIVE_INFINITY;
                    }
                    return -1.7976931348623157E308d;
                case 7:
                    return c4;
                case 8:
                    throw new ArithmeticException(x3 + " cannot be represented precisely as a double");
            }
        }
        X e4 = e(c4, RoundingMode.UNNECESSARY);
        int compareTo = ((Comparable) x3).compareTo(e4);
        int[] iArr = AnonymousClass1.f28098a;
        switch (iArr[roundingMode.ordinal()]) {
            case 1:
                if (d(x3) >= 0) {
                    if (compareTo < 0) {
                        return DoubleUtils.f(c4);
                    }
                    return c4;
                } else if (compareTo > 0) {
                    return Math.nextUp(c4);
                } else {
                    return c4;
                }
            case 2:
            case 3:
            case 4:
                if (compareTo >= 0) {
                    d4 = Math.nextUp(c4);
                    if (d4 == Double.POSITIVE_INFINITY) {
                        return c4;
                    }
                    x4 = e(d4, RoundingMode.CEILING);
                } else {
                    double f4 = DoubleUtils.f(c4);
                    if (f4 == Double.NEGATIVE_INFINITY) {
                        return c4;
                    }
                    X e5 = e(f4, RoundingMode.FLOOR);
                    x4 = e4;
                    e4 = e5;
                    d4 = c4;
                    c4 = f4;
                }
                int compareTo2 = ((Comparable) a(x3, e4)).compareTo(a(x4, x3));
                if (compareTo2 < 0) {
                    return c4;
                }
                if (compareTo2 > 0) {
                    return d4;
                }
                int i4 = iArr[roundingMode.ordinal()];
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 == 4) {
                            if (d(x3) >= 0) {
                                return d4;
                            }
                            return c4;
                        }
                        throw new AssertionError("impossible");
                    } else if (d(x3) < 0) {
                        return d4;
                    } else {
                        return c4;
                    }
                } else if ((Double.doubleToRawLongBits(c4) & 1) != 0) {
                    return d4;
                } else {
                    return c4;
                }
            case 5:
                if (compareTo < 0) {
                    return DoubleUtils.f(c4);
                }
                return c4;
            case 6:
                if (compareTo > 0) {
                    return Math.nextUp(c4);
                }
                return c4;
            case 7:
                if (d(x3) >= 0) {
                    if (compareTo > 0) {
                        return Math.nextUp(c4);
                    }
                    return c4;
                } else if (compareTo < 0) {
                    return DoubleUtils.f(c4);
                } else {
                    return c4;
                }
            case 8:
                if (compareTo == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                MathPreconditions.k(z3);
                return c4;
            default:
                throw new AssertionError("impossible");
        }
    }

    abstract double c(X x3);

    abstract int d(X x3);

    abstract X e(double d4, RoundingMode roundingMode);
}
