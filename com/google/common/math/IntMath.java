package com.google.common.math;

import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import kotlin.time.DurationKt;

@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
/* loaded from: classes5.dex */
public final class IntMath {
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    static final byte[] f28060a = {9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};
    @VisibleForTesting

    /* renamed from: b  reason: collision with root package name */
    static final int[] f28061b = {1, 10, 100, 1000, 10000, AndroidComposeViewAccessibilityDelegateCompat.ParcelSafeTextLength, DurationKt.NANOS_IN_MILLIS, 10000000, 100000000, 1000000000};
    @VisibleForTesting

    /* renamed from: c  reason: collision with root package name */
    static final int[] f28062c = {3, 31, TypedValues.AttributesType.TYPE_PATH_ROTATE, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f28063d = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};
    @VisibleForTesting

    /* renamed from: e  reason: collision with root package name */
    static int[] f28064e = {Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.common.math.IntMath$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f28065a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f28065a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28065a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f28065a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f28065a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f28065a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f28065a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f28065a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f28065a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private IntMath() {
    }

    @VisibleForTesting
    static int a(int i4, int i5) {
        return (~(~(i4 - i5))) >>> 31;
    }

    private static int b(int i4) {
        byte b4 = f28060a[Integer.numberOfLeadingZeros(i4)];
        return b4 - a(i4, f28061b[b4]);
    }

    public static int binomial(int i4, int i5) {
        boolean z3;
        MathPreconditions.e("n", i4);
        MathPreconditions.e("k", i5);
        int i6 = 0;
        if (i5 <= i4) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "k (%s) > n (%s)", i5, i4);
        if (i5 > (i4 >> 1)) {
            i5 = i4 - i5;
        }
        int[] iArr = f28064e;
        if (i5 < iArr.length && i4 <= iArr[i5]) {
            if (i5 == 0) {
                return 1;
            }
            if (i5 != 1) {
                long j4 = 1;
                while (i6 < i5) {
                    i6++;
                    j4 = (j4 * (i4 - i6)) / i6;
                }
                return (int) j4;
            }
            return i4;
        }
        return Integer.MAX_VALUE;
    }

    private static int c(int i4) {
        return (int) Math.sqrt(i4);
    }

    public static int ceilingPowerOfTwo(int i4) {
        MathPreconditions.h("x", i4);
        if (i4 <= 1073741824) {
            return 1 << (-Integer.numberOfLeadingZeros(i4 - 1));
        }
        throw new ArithmeticException("ceilingPowerOfTwo(" + i4 + ") not representable as an int");
    }

    public static int checkedAdd(int i4, int i5) {
        boolean z3;
        long j4 = i4 + i5;
        int i6 = (int) j4;
        if (j4 == i6) {
            z3 = true;
        } else {
            z3 = false;
        }
        MathPreconditions.b(z3, "checkedAdd", i4, i5);
        return i6;
    }

    public static int checkedMultiply(int i4, int i5) {
        boolean z3;
        long j4 = i4 * i5;
        int i6 = (int) j4;
        if (j4 == i6) {
            z3 = true;
        } else {
            z3 = false;
        }
        MathPreconditions.b(z3, "checkedMultiply", i4, i5);
        return i6;
    }

    public static int checkedPow(int i4, int i5) {
        boolean z3;
        boolean z4;
        MathPreconditions.e("exponent", i5);
        boolean z5 = false;
        if (i4 != -2) {
            if (i4 != -1) {
                if (i4 != 0) {
                    if (i4 == 1) {
                        return 1;
                    }
                    if (i4 != 2) {
                        int i6 = 1;
                        while (i5 != 0) {
                            if (i5 != 1) {
                                if ((i5 & 1) != 0) {
                                    i6 = checkedMultiply(i6, i4);
                                }
                                i5 >>= 1;
                                if (i5 > 0) {
                                    if (-46340 <= i4) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    if (i4 <= 46340) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                    MathPreconditions.b(z3 & z4, "checkedPow", i4, i5);
                                    i4 *= i4;
                                }
                            } else {
                                return checkedMultiply(i6, i4);
                            }
                        }
                        return i6;
                    }
                    if (i5 < 31) {
                        z5 = true;
                    }
                    MathPreconditions.b(z5, "checkedPow", i4, i5);
                    return 1 << i5;
                } else if (i5 != 0) {
                    return 0;
                } else {
                    return 1;
                }
            } else if ((i5 & 1) != 0) {
                return -1;
            } else {
                return 1;
            }
        }
        if (i5 < 32) {
            z5 = true;
        }
        MathPreconditions.b(z5, "checkedPow", i4, i5);
        if ((i5 & 1) == 0) {
            return 1 << i5;
        }
        return (-1) << i5;
    }

    public static int checkedSubtract(int i4, int i5) {
        boolean z3;
        long j4 = i4 - i5;
        int i6 = (int) j4;
        if (j4 == i6) {
            z3 = true;
        } else {
            z3 = false;
        }
        MathPreconditions.b(z3, "checkedSubtract", i4, i5);
        return i6;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0044, code lost:
        if ((r6 & r7) != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0047, code lost:
        if (r1 > 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004a, code lost:
        if (r5 > 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004d, code lost:
        if (r5 < 0) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int divide(int r5, int r6, java.math.RoundingMode r7) {
        /*
            com.google.common.base.Preconditions.checkNotNull(r7)
            if (r6 == 0) goto L5c
            int r0 = r5 / r6
            int r1 = r6 * r0
            int r1 = r5 - r1
            if (r1 != 0) goto Le
            return r0
        Le:
            r5 = r5 ^ r6
            int r5 = r5 >> 31
            r2 = 1
            r5 = r5 | r2
            int[] r3 = com.google.common.math.IntMath.AnonymousClass1.f28065a
            int r4 = r7.ordinal()
            r3 = r3[r4]
            r4 = 0
            switch(r3) {
                case 1: goto L50;
                case 2: goto L57;
                case 3: goto L4d;
                case 4: goto L58;
                case 5: goto L4a;
                case 6: goto L25;
                case 7: goto L25;
                case 8: goto L25;
                default: goto L1f;
            }
        L1f:
            java.lang.AssertionError r5 = new java.lang.AssertionError
            r5.<init>()
            throw r5
        L25:
            int r1 = java.lang.Math.abs(r1)
            int r6 = java.lang.Math.abs(r6)
            int r6 = r6 - r1
            int r1 = r1 - r6
            if (r1 != 0) goto L47
            java.math.RoundingMode r6 = java.math.RoundingMode.HALF_UP
            if (r7 == r6) goto L58
            java.math.RoundingMode r6 = java.math.RoundingMode.HALF_EVEN
            if (r7 != r6) goto L3b
            r6 = 1
            goto L3c
        L3b:
            r6 = 0
        L3c:
            r7 = r0 & 1
            if (r7 == 0) goto L42
            r7 = 1
            goto L43
        L42:
            r7 = 0
        L43:
            r6 = r6 & r7
            if (r6 == 0) goto L57
            goto L58
        L47:
            if (r1 <= 0) goto L57
            goto L58
        L4a:
            if (r5 <= 0) goto L57
            goto L58
        L4d:
            if (r5 >= 0) goto L57
            goto L58
        L50:
            if (r1 != 0) goto L53
            goto L54
        L53:
            r2 = 0
        L54:
            com.google.common.math.MathPreconditions.k(r2)
        L57:
            r2 = 0
        L58:
            if (r2 == 0) goto L5b
            int r0 = r0 + r5
        L5b:
            return r0
        L5c:
            java.lang.ArithmeticException r5 = new java.lang.ArithmeticException
            java.lang.String r6 = "/ by zero"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.IntMath.divide(int, int, java.math.RoundingMode):int");
    }

    public static int factorial(int i4) {
        MathPreconditions.e("n", i4);
        int[] iArr = f28063d;
        if (i4 < iArr.length) {
            return iArr[i4];
        }
        return Integer.MAX_VALUE;
    }

    public static int floorPowerOfTwo(int i4) {
        MathPreconditions.h("x", i4);
        return Integer.highestOneBit(i4);
    }

    public static int gcd(int i4, int i5) {
        MathPreconditions.e("a", i4);
        MathPreconditions.e("b", i5);
        if (i4 == 0) {
            return i5;
        }
        if (i5 == 0) {
            return i4;
        }
        int numberOfTrailingZeros = Integer.numberOfTrailingZeros(i4);
        int i6 = i4 >> numberOfTrailingZeros;
        int numberOfTrailingZeros2 = Integer.numberOfTrailingZeros(i5);
        int i7 = i5 >> numberOfTrailingZeros2;
        while (i6 != i7) {
            int i8 = i6 - i7;
            int i9 = (i8 >> 31) & i8;
            int i10 = (i8 - i9) - i9;
            i7 += i9;
            i6 = i10 >> Integer.numberOfTrailingZeros(i10);
        }
        return i6 << Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
    }

    public static boolean isPowerOfTwo(int i4) {
        boolean z3;
        boolean z4 = false;
        if (i4 > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if ((i4 & (i4 - 1)) == 0) {
            z4 = true;
        }
        return z3 & z4;
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static boolean isPrime(int i4) {
        return LongMath.isPrime(i4);
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static int log10(int i4, RoundingMode roundingMode) {
        boolean z3;
        int a4;
        MathPreconditions.h("x", i4);
        int b4 = b(i4);
        int i5 = f28061b[b4];
        switch (AnonymousClass1.f28065a[roundingMode.ordinal()]) {
            case 1:
                if (i4 == i5) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                MathPreconditions.k(z3);
                return b4;
            case 2:
            case 3:
                return b4;
            case 4:
            case 5:
                a4 = a(i5, i4);
                return b4 + a4;
            case 6:
            case 7:
            case 8:
                a4 = a(f28062c[b4], i4);
                return b4 + a4;
            default:
                throw new AssertionError();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int log2(int i4, RoundingMode roundingMode) {
        MathPreconditions.h("x", i4);
        switch (AnonymousClass1.f28065a[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.k(isPowerOfTwo(i4));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 32 - Integer.numberOfLeadingZeros(i4 - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Integer.numberOfLeadingZeros(i4);
                return (31 - numberOfLeadingZeros) + a((-1257966797) >>> numberOfLeadingZeros, i4);
            default:
                throw new AssertionError();
        }
        return 31 - Integer.numberOfLeadingZeros(i4);
    }

    public static int mean(int i4, int i5) {
        return (i4 & i5) + ((i4 ^ i5) >> 1);
    }

    public static int mod(int i4, int i5) {
        if (i5 > 0) {
            int i6 = i4 % i5;
            if (i6 < 0) {
                return i6 + i5;
            }
            return i6;
        }
        throw new ArithmeticException("Modulus " + i5 + " must be > 0");
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static int pow(int i4, int i5) {
        int i6;
        MathPreconditions.e("exponent", i5);
        if (i4 != -2) {
            if (i4 != -1) {
                if (i4 != 0) {
                    if (i4 == 1) {
                        return 1;
                    }
                    if (i4 != 2) {
                        int i7 = 1;
                        while (i5 != 0) {
                            if (i5 != 1) {
                                if ((i5 & 1) == 0) {
                                    i6 = 1;
                                } else {
                                    i6 = i4;
                                }
                                i7 *= i6;
                                i4 *= i4;
                                i5 >>= 1;
                            } else {
                                return i4 * i7;
                            }
                        }
                        return i7;
                    } else if (i5 >= 32) {
                        return 0;
                    } else {
                        return 1 << i5;
                    }
                } else if (i5 != 0) {
                    return 0;
                } else {
                    return 1;
                }
            } else if ((i5 & 1) == 0) {
                return 1;
            } else {
                return -1;
            }
        } else if (i5 >= 32) {
            return 0;
        } else {
            if ((i5 & 1) == 0) {
                return 1 << i5;
            }
            return -(1 << i5);
        }
    }

    public static int saturatedAdd(int i4, int i5) {
        return Ints.saturatedCast(i4 + i5);
    }

    public static int saturatedMultiply(int i4, int i5) {
        return Ints.saturatedCast(i4 * i5);
    }

    public static int saturatedPow(int i4, int i5) {
        boolean z3;
        boolean z4;
        MathPreconditions.e("exponent", i5);
        if (i4 != -2) {
            if (i4 != -1) {
                if (i4 != 0) {
                    if (i4 == 1) {
                        return 1;
                    }
                    if (i4 != 2) {
                        int i6 = ((i4 >>> 31) & i5 & 1) + Integer.MAX_VALUE;
                        int i7 = 1;
                        while (i5 != 0) {
                            if (i5 != 1) {
                                if ((i5 & 1) != 0) {
                                    i7 = saturatedMultiply(i7, i4);
                                }
                                i5 >>= 1;
                                if (i5 > 0) {
                                    if (-46340 > i4) {
                                        z3 = true;
                                    } else {
                                        z3 = false;
                                    }
                                    if (i4 > 46340) {
                                        z4 = true;
                                    } else {
                                        z4 = false;
                                    }
                                    if (z3 | z4) {
                                        return i6;
                                    }
                                    i4 *= i4;
                                }
                            } else {
                                return saturatedMultiply(i7, i4);
                            }
                        }
                        return i7;
                    } else if (i5 >= 31) {
                        return Integer.MAX_VALUE;
                    } else {
                        return 1 << i5;
                    }
                } else if (i5 == 0) {
                    return 1;
                } else {
                    return 0;
                }
            } else if ((i5 & 1) != 0) {
                return -1;
            } else {
                return 1;
            }
        } else if (i5 >= 32) {
            return (i5 & 1) + Integer.MAX_VALUE;
        } else {
            if ((i5 & 1) == 0) {
                return 1 << i5;
            }
            return (-1) << i5;
        }
    }

    public static int saturatedSubtract(int i4, int i5) {
        return Ints.saturatedCast(i4 - i5);
    }

    @GwtIncompatible
    public static int sqrt(int i4, RoundingMode roundingMode) {
        boolean z3;
        int a4;
        MathPreconditions.e("x", i4);
        int c4 = c(i4);
        switch (AnonymousClass1.f28065a[roundingMode.ordinal()]) {
            case 1:
                if (c4 * c4 == i4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                MathPreconditions.k(z3);
                return c4;
            case 2:
            case 3:
                return c4;
            case 4:
            case 5:
                a4 = a(c4 * c4, i4);
                return c4 + a4;
            case 6:
            case 7:
            case 8:
                a4 = a((c4 * c4) + c4, i4);
                return c4 + a4;
            default:
                throw new AssertionError();
        }
    }
}
