package com.google.common.math;

import androidx.compose.animation.core.AnimationKt;
import com.android.dx.io.Opcodes;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Ascii;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import com.google.common.primitives.UnsignedLongs;
import java.math.RoundingMode;
import javax.mail.UIDFolder;
import okhttp3.internal.connection.RealConnection;
import org.apache.http.HttpStatus;

@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
/* loaded from: classes5.dex */
public final class LongMath {
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    static final byte[] f28074a = {19, Ascii.DC2, Ascii.DC2, Ascii.DC2, Ascii.DC2, 17, 17, 17, Ascii.DLE, Ascii.DLE, Ascii.DLE, Ascii.SI, Ascii.SI, Ascii.SI, Ascii.SI, Ascii.SO, Ascii.SO, Ascii.SO, Ascii.CR, Ascii.CR, Ascii.CR, Ascii.FF, Ascii.FF, Ascii.FF, Ascii.FF, Ascii.VT, Ascii.VT, Ascii.VT, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0};
    @VisibleForTesting
    @J2ktIncompatible
    @GwtIncompatible

    /* renamed from: b  reason: collision with root package name */
    static final long[] f28075b = {1, 10, 100, 1000, 10000, 100000, AnimationKt.MillisToNanos, 10000000, 100000000, 1000000000, RealConnection.IDLE_CONNECTION_HEALTHY_NS, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};
    @VisibleForTesting
    @J2ktIncompatible
    @GwtIncompatible

    /* renamed from: c  reason: collision with root package name */
    static final long[] f28076c = {3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};

    /* renamed from: d  reason: collision with root package name */
    static final long[] f28077d = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};

    /* renamed from: e  reason: collision with root package name */
    static final int[] f28078e = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, 534, 361, 265, 206, 169, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};
    @VisibleForTesting

    /* renamed from: f  reason: collision with root package name */
    static final int[] f28079f = {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, 1313, 684, HttpStatus.SC_INSUFFICIENT_SPACE_ON_RESOURCE, 287, Opcodes.OR_INT_LIT16, 169, 139, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};

    /* renamed from: g  reason: collision with root package name */
    private static final long[][] f28080g = {new long[]{291830, 126401071349994536L}, new long[]{885594168, 725270293939359937L, 3569819667048198375L}, new long[]{273919523040L, 15, 7363882082L, 992620450144556L}, new long[]{47636622961200L, 2, 2570940, 211991001, 3749873356L}, new long[]{7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, new long[]{585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, new long[]{Long.MAX_VALUE, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.common.math.LongMath$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f28081a;

        static {
            int[] iArr = new int[RoundingMode.values().length];
            f28081a = iArr;
            try {
                iArr[RoundingMode.UNNECESSARY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28081a[RoundingMode.DOWN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f28081a[RoundingMode.FLOOR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f28081a[RoundingMode.UP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f28081a[RoundingMode.CEILING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f28081a[RoundingMode.HALF_DOWN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f28081a[RoundingMode.HALF_UP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f28081a[RoundingMode.HALF_EVEN.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public enum MillerRabinTester {
        SMALL { // from class: com.google.common.math.LongMath.MillerRabinTester.1
            @Override // com.google.common.math.LongMath.MillerRabinTester
            long b(long j4, long j5, long j6) {
                return (j4 * j5) % j6;
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            long e(long j4, long j5) {
                return (j4 * j4) % j5;
            }
        },
        LARGE { // from class: com.google.common.math.LongMath.MillerRabinTester.2
            private long h(long j4, long j5, long j6) {
                int i4 = (j4 > (j6 - j5) ? 1 : (j4 == (j6 - j5) ? 0 : -1));
                long j7 = j4 + j5;
                if (i4 >= 0) {
                    return j7 - j6;
                }
                return j7;
            }

            private long i(long j4, long j5) {
                int i4 = 32;
                do {
                    int min = Math.min(i4, Long.numberOfLeadingZeros(j4));
                    j4 = UnsignedLongs.remainder(j4 << min, j5);
                    i4 -= min;
                } while (i4 > 0);
                return j4;
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            long b(long j4, long j5, long j6) {
                long j7 = j4 >>> 32;
                long j8 = j5 >>> 32;
                long j9 = j4 & UIDFolder.MAXUID;
                long j10 = j5 & UIDFolder.MAXUID;
                long i4 = i(j7 * j8, j6) + (j7 * j10);
                if (i4 < 0) {
                    i4 = UnsignedLongs.remainder(i4, j6);
                }
                Long.signum(j9);
                return h(i(i4 + (j8 * j9), j6), UnsignedLongs.remainder(j9 * j10, j6), j6);
            }

            @Override // com.google.common.math.LongMath.MillerRabinTester
            long e(long j4, long j5) {
                long j6 = j4 >>> 32;
                long j7 = j4 & UIDFolder.MAXUID;
                long i4 = i(j6 * j6, j5);
                long j8 = j6 * j7 * 2;
                if (j8 < 0) {
                    j8 = UnsignedLongs.remainder(j8, j5);
                }
                return h(i(i4 + j8, j5), UnsignedLongs.remainder(j7 * j7, j5), j5);
            }
        };

        private long c(long j4, long j5, long j6) {
            long j7 = 1;
            while (j5 != 0) {
                if ((j5 & 1) != 0) {
                    j7 = b(j7, j4, j6);
                }
                j4 = e(j4, j6);
                j5 >>= 1;
            }
            return j7;
        }

        static boolean f(long j4, long j5) {
            MillerRabinTester millerRabinTester;
            if (j5 <= 3037000499L) {
                millerRabinTester = SMALL;
            } else {
                millerRabinTester = LARGE;
            }
            return millerRabinTester.g(j4, j5);
        }

        private boolean g(long j4, long j5) {
            long j6 = j5 - 1;
            int numberOfTrailingZeros = Long.numberOfTrailingZeros(j6);
            long j7 = j6 >> numberOfTrailingZeros;
            long j8 = j4 % j5;
            if (j8 == 0) {
                return true;
            }
            long c4 = c(j8, j7, j5);
            if (c4 == 1) {
                return true;
            }
            int i4 = 0;
            while (c4 != j6) {
                i4++;
                if (i4 == numberOfTrailingZeros) {
                    return false;
                }
                c4 = e(c4, j5);
            }
            return true;
        }

        abstract long b(long j4, long j5, long j6);

        abstract long e(long j4, long j5);

        /* synthetic */ MillerRabinTester(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private LongMath() {
    }

    static boolean a(long j4) {
        if (((int) j4) == j4) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    static int b(long j4, long j5) {
        return (int) ((~(~(j4 - j5))) >>> 63);
    }

    public static long binomial(int i4, int i5) {
        boolean z3;
        MathPreconditions.e("n", i4);
        MathPreconditions.e("k", i5);
        if (i5 <= i4) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "k (%s) > n (%s)", i5, i4);
        if (i5 > (i4 >> 1)) {
            i5 = i4 - i5;
        }
        long j4 = 1;
        if (i5 == 0) {
            return 1L;
        }
        if (i5 != 1) {
            long[] jArr = f28077d;
            if (i4 < jArr.length) {
                return jArr[i4] / (jArr[i5] * jArr[i4 - i5]);
            }
            int[] iArr = f28078e;
            if (i5 < iArr.length && i4 <= iArr[i5]) {
                int[] iArr2 = f28079f;
                if (i5 < iArr2.length && i4 <= iArr2[i5]) {
                    int i6 = i4 - 1;
                    long j5 = i4;
                    for (int i7 = 2; i7 <= i5; i7++) {
                        j5 = (j5 * i6) / i7;
                        i6--;
                    }
                    return j5;
                }
                long j6 = i4;
                int log2 = log2(j6, RoundingMode.CEILING);
                int i8 = i4 - 1;
                int i9 = log2;
                long j7 = j6;
                int i10 = 2;
                long j8 = 1;
                while (i10 <= i5) {
                    i9 += log2;
                    if (i9 < 63) {
                        j7 *= i8;
                        j8 *= i10;
                    } else {
                        j4 = d(j4, j7, j8);
                        j7 = i8;
                        j8 = i10;
                        i9 = log2;
                    }
                    i10++;
                    i8--;
                }
                return d(j4, j7, j8);
            }
            return Long.MAX_VALUE;
        }
        return i4;
    }

    @J2ktIncompatible
    @GwtIncompatible
    static int c(long j4) {
        byte b4 = f28074a[Long.numberOfLeadingZeros(j4)];
        return b4 - b(j4, f28075b[b4]);
    }

    public static long ceilingPowerOfTwo(long j4) {
        MathPreconditions.i("x", j4);
        if (j4 <= Longs.MAX_POWER_OF_TWO) {
            return 1 << (-Long.numberOfLeadingZeros(j4 - 1));
        }
        throw new ArithmeticException("ceilingPowerOfTwo(" + j4 + ") is not representable as a long");
    }

    public static long checkedAdd(long j4, long j5) {
        boolean z3;
        long j6 = j4 + j5;
        boolean z4 = true;
        if ((j4 ^ j5) < 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if ((j4 ^ j6) < 0) {
            z4 = false;
        }
        MathPreconditions.c(z3 | z4, "checkedAdd", j4, j5);
        return j6;
    }

    public static long checkedMultiply(long j4, long j5) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(j4) + Long.numberOfLeadingZeros(~j4) + Long.numberOfLeadingZeros(j5) + Long.numberOfLeadingZeros(~j5);
        if (numberOfLeadingZeros > 65) {
            return j4 * j5;
        }
        if (numberOfLeadingZeros >= 64) {
            z3 = true;
        } else {
            z3 = false;
        }
        MathPreconditions.c(z3, "checkedMultiply", j4, j5);
        int i4 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
        if (i4 >= 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (j5 != Long.MIN_VALUE) {
            z5 = true;
        } else {
            z5 = false;
        }
        MathPreconditions.c(z4 | z5, "checkedMultiply", j4, j5);
        long j6 = j4 * j5;
        if (i4 != 0 && j6 / j4 != j5) {
            z6 = false;
        } else {
            z6 = true;
        }
        MathPreconditions.c(z6, "checkedMultiply", j4, j5);
        return j6;
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static long checkedPow(long j4, int i4) {
        boolean z3;
        boolean z4;
        long j5;
        boolean z5;
        boolean z6;
        boolean z7;
        MathPreconditions.e("exponent", i4);
        if (j4 >= -2) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (j4 <= 2) {
            z4 = true;
        } else {
            z4 = false;
        }
        long j6 = 1;
        if (z3 & z4) {
            int i5 = (int) j4;
            if (i5 != -2) {
                if (i5 != -1) {
                    if (i5 != 0) {
                        if (i5 == 1) {
                            return 1L;
                        }
                        if (i5 == 2) {
                            if (i4 < 63) {
                                z7 = true;
                            } else {
                                z7 = false;
                            }
                            MathPreconditions.c(z7, "checkedPow", j4, i4);
                            return 1 << i4;
                        }
                        throw new AssertionError();
                    } else if (i4 == 0) {
                        return 1L;
                    } else {
                        return 0L;
                    }
                } else if ((i4 & 1) == 0) {
                    return 1L;
                } else {
                    return -1L;
                }
            }
            if (i4 < 64) {
                z6 = true;
            } else {
                z6 = false;
            }
            MathPreconditions.c(z6, "checkedPow", j4, i4);
            if ((i4 & 1) == 0) {
                return 1 << i4;
            }
            return (-1) << i4;
        }
        long j7 = j4;
        int i6 = i4;
        while (i6 != 0) {
            if (i6 != 1) {
                if ((i6 & 1) != 0) {
                    j5 = checkedMultiply(j6, j7);
                } else {
                    j5 = j6;
                }
                int i7 = i6 >> 1;
                if (i7 > 0) {
                    if (-3037000499L <= j7 && j7 <= 3037000499L) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    MathPreconditions.c(z5, "checkedPow", j7, i7);
                    j7 *= j7;
                }
                j6 = j5;
                i6 = i7;
            } else {
                return checkedMultiply(j6, j7);
            }
        }
        return j6;
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static long checkedSubtract(long j4, long j5) {
        boolean z3;
        long j6 = j4 - j5;
        boolean z4 = true;
        if ((j4 ^ j5) >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if ((j4 ^ j6) < 0) {
            z4 = false;
        }
        MathPreconditions.c(z3 | z4, "checkedSubtract", j4, j5);
        return j6;
    }

    static long d(long j4, long j5, long j6) {
        if (j4 == 1) {
            return j5 / j6;
        }
        long gcd = gcd(j4, j6);
        return (j4 / gcd) * (j5 / (j6 / gcd));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004a, code lost:
        if (r10 > 0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x004d, code lost:
        if (r10 < 0) goto L24;
     */
    @com.google.common.annotations.J2ktIncompatible
    @com.google.common.annotations.GwtIncompatible
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long divide(long r9, long r11, java.math.RoundingMode r13) {
        /*
            com.google.common.base.Preconditions.checkNotNull(r13)
            long r0 = r9 / r11
            long r2 = r11 * r0
            long r2 = r9 - r2
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 != 0) goto L10
            return r0
        L10:
            long r9 = r9 ^ r11
            r7 = 63
            long r9 = r9 >> r7
            int r10 = (int) r9
            r9 = 1
            r10 = r10 | r9
            int[] r7 = com.google.common.math.LongMath.AnonymousClass1.f28081a
            int r8 = r13.ordinal()
            r7 = r7[r8]
            r8 = 0
            switch(r7) {
                case 1: goto L50;
                case 2: goto L57;
                case 3: goto L4d;
                case 4: goto L58;
                case 5: goto L4a;
                case 6: goto L29;
                case 7: goto L29;
                case 8: goto L29;
                default: goto L23;
            }
        L23:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            throw r9
        L29:
            long r2 = java.lang.Math.abs(r2)
            long r11 = java.lang.Math.abs(r11)
            long r11 = r11 - r2
            long r2 = r2 - r11
            int r11 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r11 != 0) goto L47
            java.math.RoundingMode r11 = java.math.RoundingMode.HALF_UP
            if (r13 == r11) goto L58
            java.math.RoundingMode r11 = java.math.RoundingMode.HALF_EVEN
            if (r13 != r11) goto L57
            r11 = 1
            long r11 = r11 & r0
            int r13 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r13 == 0) goto L57
            goto L58
        L47:
            if (r11 <= 0) goto L57
            goto L58
        L4a:
            if (r10 <= 0) goto L57
            goto L58
        L4d:
            if (r10 >= 0) goto L57
            goto L58
        L50:
            if (r6 != 0) goto L53
            goto L54
        L53:
            r9 = 0
        L54:
            com.google.common.math.MathPreconditions.k(r9)
        L57:
            r9 = 0
        L58:
            if (r9 == 0) goto L5c
            long r9 = (long) r10
            long r0 = r0 + r9
        L5c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.math.LongMath.divide(long, long, java.math.RoundingMode):long");
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static long factorial(int i4) {
        MathPreconditions.e("n", i4);
        long[] jArr = f28077d;
        if (i4 < jArr.length) {
            return jArr[i4];
        }
        return Long.MAX_VALUE;
    }

    public static long floorPowerOfTwo(long j4) {
        MathPreconditions.i("x", j4);
        return 1 << (63 - Long.numberOfLeadingZeros(j4));
    }

    public static long gcd(long j4, long j5) {
        MathPreconditions.f("a", j4);
        MathPreconditions.f("b", j5);
        if (j4 == 0) {
            return j5;
        }
        if (j5 == 0) {
            return j4;
        }
        int numberOfTrailingZeros = Long.numberOfTrailingZeros(j4);
        long j6 = j4 >> numberOfTrailingZeros;
        int numberOfTrailingZeros2 = Long.numberOfTrailingZeros(j5);
        long j7 = j5 >> numberOfTrailingZeros2;
        while (j6 != j7) {
            long j8 = j6 - j7;
            long j9 = (j8 >> 63) & j8;
            long j10 = (j8 - j9) - j9;
            j7 += j9;
            j6 = j10 >> Long.numberOfTrailingZeros(j10);
        }
        return j6 << Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
    }

    public static boolean isPowerOfTwo(long j4) {
        boolean z3;
        boolean z4 = true;
        if (j4 > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if ((j4 & (j4 - 1)) != 0) {
            z4 = false;
        }
        return z3 & z4;
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static boolean isPrime(long j4) {
        long[][] jArr;
        if (j4 < 2) {
            MathPreconditions.f("n", j4);
            return false;
        } else if (j4 < 66) {
            if (((722865708377213483 >> (((int) j4) - 2)) & 1) == 0) {
                return false;
            }
            return true;
        } else if (((1 << ((int) (j4 % 30))) & (-545925251)) != 0 || j4 % 7 == 0 || j4 % 11 == 0 || j4 % 13 == 0) {
            return false;
        } else {
            if (j4 < 289) {
                return true;
            }
            for (long[] jArr2 : f28080g) {
                if (j4 <= jArr2[0]) {
                    for (int i4 = 1; i4 < jArr2.length; i4++) {
                        if (!MillerRabinTester.f(jArr2[i4], j4)) {
                            return false;
                        }
                    }
                    return true;
                }
            }
            throw new AssertionError();
        }
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static int log10(long j4, RoundingMode roundingMode) {
        boolean z3;
        int b4;
        MathPreconditions.i("x", j4);
        int c4 = c(j4);
        long j5 = f28075b[c4];
        switch (AnonymousClass1.f28081a[roundingMode.ordinal()]) {
            case 1:
                if (j4 == j5) {
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
                b4 = b(j5, j4);
                return c4 + b4;
            case 6:
            case 7:
            case 8:
                b4 = b(f28076c[c4], j4);
                return c4 + b4;
            default:
                throw new AssertionError();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int log2(long j4, RoundingMode roundingMode) {
        MathPreconditions.i("x", j4);
        switch (AnonymousClass1.f28081a[roundingMode.ordinal()]) {
            case 1:
                MathPreconditions.k(isPowerOfTwo(j4));
                break;
            case 2:
            case 3:
                break;
            case 4:
            case 5:
                return 64 - Long.numberOfLeadingZeros(j4 - 1);
            case 6:
            case 7:
            case 8:
                int numberOfLeadingZeros = Long.numberOfLeadingZeros(j4);
                return (63 - numberOfLeadingZeros) + b((-5402926248376769404) >>> numberOfLeadingZeros, j4);
            default:
                throw new AssertionError("impossible");
        }
        return 63 - Long.numberOfLeadingZeros(j4);
    }

    public static long mean(long j4, long j5) {
        return (j4 & j5) + ((j4 ^ j5) >> 1);
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static int mod(long j4, int i4) {
        return (int) mod(j4, i4);
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static long pow(long j4, int i4) {
        long j5;
        MathPreconditions.e("exponent", i4);
        if (-2 <= j4 && j4 <= 2) {
            int i5 = (int) j4;
            if (i5 != -2) {
                if (i5 != -1) {
                    if (i5 != 0) {
                        if (i5 == 1) {
                            return 1L;
                        }
                        if (i5 == 2) {
                            if (i4 >= 64) {
                                return 0L;
                            }
                            return 1 << i4;
                        }
                        throw new AssertionError();
                    } else if (i4 == 0) {
                        return 1L;
                    } else {
                        return 0L;
                    }
                } else if ((i4 & 1) == 0) {
                    return 1L;
                } else {
                    return -1L;
                }
            } else if (i4 >= 64) {
                return 0L;
            } else {
                if ((i4 & 1) == 0) {
                    return 1 << i4;
                }
                return -(1 << i4);
            }
        }
        long j6 = 1;
        while (i4 != 0) {
            if (i4 != 1) {
                if ((i4 & 1) == 0) {
                    j5 = 1;
                } else {
                    j5 = j4;
                }
                j6 *= j5;
                j4 *= j4;
                i4 >>= 1;
            } else {
                return j6 * j4;
            }
        }
        return j6;
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static double roundToDouble(long j4, RoundingMode roundingMode) {
        int compare;
        boolean z3;
        double d4;
        long j5;
        double d5 = j4;
        long j6 = (long) d5;
        if (j6 == Long.MAX_VALUE) {
            compare = -1;
        } else {
            compare = Longs.compare(j4, j6);
        }
        int[] iArr = AnonymousClass1.f28081a;
        switch (iArr[roundingMode.ordinal()]) {
            case 1:
                if (compare == 0) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                MathPreconditions.k(z3);
                return d5;
            case 2:
                if (j4 >= 0) {
                    if (compare < 0) {
                        return DoubleUtils.f(d5);
                    }
                    return d5;
                } else if (compare > 0) {
                    return Math.nextUp(d5);
                } else {
                    return d5;
                }
            case 3:
                if (compare < 0) {
                    return DoubleUtils.f(d5);
                }
                return d5;
            case 4:
                if (j4 >= 0) {
                    if (compare > 0) {
                        return Math.nextUp(d5);
                    }
                    return d5;
                } else if (compare < 0) {
                    return DoubleUtils.f(d5);
                } else {
                    return d5;
                }
            case 5:
                if (compare > 0) {
                    return Math.nextUp(d5);
                }
                return d5;
            case 6:
            case 7:
            case 8:
                if (compare >= 0) {
                    d4 = Math.nextUp(d5);
                    j5 = (long) Math.ceil(d4);
                } else {
                    double f4 = DoubleUtils.f(d5);
                    j6 = (long) Math.floor(f4);
                    d4 = d5;
                    d5 = f4;
                    j5 = j6;
                }
                long j7 = j4 - j6;
                long j8 = j5 - j4;
                if (j5 == Long.MAX_VALUE) {
                    j8++;
                }
                int compare2 = Longs.compare(j7, j8);
                if (compare2 < 0) {
                    return d5;
                }
                if (compare2 > 0) {
                    return d4;
                }
                int i4 = iArr[roundingMode.ordinal()];
                if (i4 != 6) {
                    if (i4 != 7) {
                        if (i4 == 8) {
                            if ((DoubleUtils.c(d5) & 1) != 0) {
                                return d4;
                            }
                            return d5;
                        }
                        throw new AssertionError("impossible");
                    } else if (j4 >= 0) {
                        return d4;
                    } else {
                        return d5;
                    }
                } else if (j4 < 0) {
                    return d4;
                } else {
                    return d5;
                }
            default:
                throw new AssertionError("impossible");
        }
    }

    public static long saturatedAdd(long j4, long j5) {
        boolean z3;
        long j6 = j4 + j5;
        boolean z4 = true;
        if ((j5 ^ j4) < 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if ((j4 ^ j6) < 0) {
            z4 = false;
        }
        if (z3 | z4) {
            return j6;
        }
        return ((j6 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    public static long saturatedMultiply(long j4, long j5) {
        boolean z3;
        boolean z4;
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(j4) + Long.numberOfLeadingZeros(~j4) + Long.numberOfLeadingZeros(j5) + Long.numberOfLeadingZeros(~j5);
        if (numberOfLeadingZeros > 65) {
            return j4 * j5;
        }
        long j6 = ((j4 ^ j5) >>> 63) + Long.MAX_VALUE;
        boolean z5 = true;
        if (numberOfLeadingZeros < 64) {
            z3 = true;
        } else {
            z3 = false;
        }
        int i4 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
        if (i4 < 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (j5 != Long.MIN_VALUE) {
            z5 = false;
        }
        if (z3 | (z5 & z4)) {
            return j6;
        }
        long j7 = j4 * j5;
        if (i4 != 0 && j7 / j4 != j5) {
            return j6;
        }
        return j7;
    }

    public static long saturatedPow(long j4, int i4) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        MathPreconditions.e("exponent", i4);
        if (j4 >= -2) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (j4 <= 2) {
            z4 = true;
        } else {
            z4 = false;
        }
        long j5 = 1;
        if (z3 & z4) {
            int i5 = (int) j4;
            if (i5 != -2) {
                if (i5 != -1) {
                    if (i5 != 0) {
                        if (i5 == 1) {
                            return 1L;
                        }
                        if (i5 == 2) {
                            if (i4 >= 63) {
                                return Long.MAX_VALUE;
                            }
                            return 1 << i4;
                        }
                        throw new AssertionError();
                    } else if (i4 == 0) {
                        return 1L;
                    } else {
                        return 0L;
                    }
                } else if ((i4 & 1) == 0) {
                    return 1L;
                } else {
                    return -1L;
                }
            } else if (i4 >= 64) {
                return (i4 & 1) + Long.MAX_VALUE;
            } else {
                if ((i4 & 1) == 0) {
                    return 1 << i4;
                }
                return (-1) << i4;
            }
        }
        long j6 = ((j4 >>> 63) & i4 & 1) + Long.MAX_VALUE;
        while (i4 != 0) {
            if (i4 != 1) {
                if ((i4 & 1) != 0) {
                    j5 = saturatedMultiply(j5, j4);
                }
                i4 >>= 1;
                if (i4 > 0) {
                    if (-3037000499L > j4) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (j4 > 3037000499L) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    if (z5 | z6) {
                        return j6;
                    }
                    j4 *= j4;
                }
            } else {
                return saturatedMultiply(j5, j4);
            }
        }
        return j5;
    }

    public static long saturatedSubtract(long j4, long j5) {
        boolean z3;
        long j6 = j4 - j5;
        boolean z4 = true;
        if ((j5 ^ j4) >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if ((j4 ^ j6) < 0) {
            z4 = false;
        }
        if (z3 | z4) {
            return j6;
        }
        return ((j6 >>> 63) ^ 1) + Long.MAX_VALUE;
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static long sqrt(long j4, RoundingMode roundingMode) {
        MathPreconditions.f("x", j4);
        if (a(j4)) {
            return IntMath.sqrt((int) j4, roundingMode);
        }
        long sqrt = (long) Math.sqrt(j4);
        long j5 = sqrt * sqrt;
        boolean z3 = true;
        int i4 = 1;
        switch (AnonymousClass1.f28081a[roundingMode.ordinal()]) {
            case 1:
                if (j5 != j4) {
                    z3 = false;
                }
                MathPreconditions.k(z3);
                return sqrt;
            case 2:
            case 3:
                if (j4 < j5) {
                    return sqrt - 1;
                }
                return sqrt;
            case 4:
            case 5:
                if (j4 > j5) {
                    return sqrt + 1;
                }
                return sqrt;
            case 6:
            case 7:
            case 8:
                if (j4 >= j5) {
                    i4 = 0;
                }
                long j6 = sqrt - i4;
                return j6 + b((j6 * j6) + j6, j4);
            default:
                throw new AssertionError();
        }
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static long mod(long j4, long j5) {
        if (j5 > 0) {
            long j6 = j4 % j5;
            return j6 >= 0 ? j6 : j6 + j5;
        }
        throw new ArithmeticException("Modulus must be positive");
    }
}
