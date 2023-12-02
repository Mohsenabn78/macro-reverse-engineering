package com.google.common.math;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@GwtIncompatible
/* loaded from: classes5.dex */
public final class Quantiles {

    /* loaded from: classes5.dex */
    public static final class Scale {

        /* renamed from: a  reason: collision with root package name */
        private final int f28088a;

        public ScaleAndIndex index(int i4) {
            return new ScaleAndIndex(this.f28088a, i4);
        }

        public ScaleAndIndexes indexes(int... iArr) {
            return new ScaleAndIndexes(this.f28088a, (int[]) iArr.clone());
        }

        private Scale(int i4) {
            Preconditions.checkArgument(i4 > 0, "Quantile scale must be positive");
            this.f28088a = i4;
        }

        public ScaleAndIndexes indexes(Collection<Integer> collection) {
            return new ScaleAndIndexes(this.f28088a, Ints.toArray(collection));
        }
    }

    /* loaded from: classes5.dex */
    public static final class ScaleAndIndex {

        /* renamed from: a  reason: collision with root package name */
        private final int f28089a;

        /* renamed from: b  reason: collision with root package name */
        private final int f28090b;

        public double compute(Collection<? extends Number> collection) {
            return computeInPlace(Doubles.toArray(collection));
        }

        public double computeInPlace(double... dArr) {
            boolean z3;
            if (dArr.length > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "Cannot calculate quantiles of an empty dataset");
            if (Quantiles.j(dArr)) {
                return Double.NaN;
            }
            long length = this.f28090b * (dArr.length - 1);
            int divide = (int) LongMath.divide(length, this.f28089a, RoundingMode.DOWN);
            int i4 = (int) (length - (divide * this.f28089a));
            Quantiles.q(divide, dArr, 0, dArr.length - 1);
            if (i4 == 0) {
                return dArr[divide];
            }
            int i5 = divide + 1;
            Quantiles.q(i5, dArr, i5, dArr.length - 1);
            return Quantiles.k(dArr[divide], dArr[i5], i4, this.f28089a);
        }

        private ScaleAndIndex(int i4, int i5) {
            Quantiles.h(i5, i4);
            this.f28089a = i4;
            this.f28090b = i5;
        }

        public double compute(double... dArr) {
            return computeInPlace((double[]) dArr.clone());
        }

        public double compute(long... jArr) {
            return computeInPlace(Quantiles.m(jArr));
        }

        public double compute(int... iArr) {
            return computeInPlace(Quantiles.l(iArr));
        }
    }

    /* loaded from: classes5.dex */
    public static final class ScaleAndIndexes {

        /* renamed from: a  reason: collision with root package name */
        private final int f28091a;

        /* renamed from: b  reason: collision with root package name */
        private final int[] f28092b;

        public Map<Integer, Double> compute(Collection<? extends Number> collection) {
            return computeInPlace(Doubles.toArray(collection));
        }

        public Map<Integer, Double> computeInPlace(double... dArr) {
            boolean z3;
            int i4 = 0;
            int i5 = 1;
            if (dArr.length > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "Cannot calculate quantiles of an empty dataset");
            if (Quantiles.j(dArr)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int[] iArr = this.f28092b;
                int length = iArr.length;
                while (i4 < length) {
                    linkedHashMap.put(Integer.valueOf(iArr[i4]), Double.valueOf(Double.NaN));
                    i4++;
                }
                return Collections.unmodifiableMap(linkedHashMap);
            }
            int[] iArr2 = this.f28092b;
            int[] iArr3 = new int[iArr2.length];
            int[] iArr4 = new int[iArr2.length];
            int[] iArr5 = new int[iArr2.length * 2];
            int i6 = 0;
            int i7 = 0;
            while (true) {
                int[] iArr6 = this.f28092b;
                if (i6 >= iArr6.length) {
                    break;
                }
                long length2 = iArr6[i6] * (dArr.length - i5);
                int divide = (int) LongMath.divide(length2, this.f28091a, RoundingMode.DOWN);
                int i8 = i6;
                int i9 = (int) (length2 - (divide * this.f28091a));
                iArr3[i8] = divide;
                iArr4[i8] = i9;
                iArr5[i7] = divide;
                i7++;
                if (i9 != 0) {
                    iArr5[i7] = divide + 1;
                    i7++;
                }
                i6 = i8 + 1;
                i5 = 1;
            }
            Arrays.sort(iArr5, 0, i7);
            Quantiles.p(iArr5, 0, i7 - 1, dArr, 0, dArr.length - 1);
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            while (true) {
                int[] iArr7 = this.f28092b;
                if (i4 < iArr7.length) {
                    int i10 = iArr3[i4];
                    int i11 = iArr4[i4];
                    if (i11 == 0) {
                        linkedHashMap2.put(Integer.valueOf(iArr7[i4]), Double.valueOf(dArr[i10]));
                    } else {
                        linkedHashMap2.put(Integer.valueOf(iArr7[i4]), Double.valueOf(Quantiles.k(dArr[i10], dArr[i10 + 1], i11, this.f28091a)));
                    }
                    i4++;
                } else {
                    return Collections.unmodifiableMap(linkedHashMap2);
                }
            }
        }

        private ScaleAndIndexes(int i4, int[] iArr) {
            for (int i5 : iArr) {
                Quantiles.h(i5, i4);
            }
            Preconditions.checkArgument(iArr.length > 0, "Indexes must be a non empty array");
            this.f28091a = i4;
            this.f28092b = iArr;
        }

        public Map<Integer, Double> compute(double... dArr) {
            return computeInPlace((double[]) dArr.clone());
        }

        public Map<Integer, Double> compute(long... jArr) {
            return computeInPlace(Quantiles.m(jArr));
        }

        public Map<Integer, Double> compute(int... iArr) {
            return computeInPlace(Quantiles.l(iArr));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(int i4, int i5) {
        if (i4 >= 0 && i4 <= i5) {
            return;
        }
        throw new IllegalArgumentException("Quantile indexes must be between 0 and the scale, which is " + i5);
    }

    private static int i(int[] iArr, int i4, int i5, int i6, int i7) {
        if (i4 == i5) {
            return i4;
        }
        int i8 = i6 + i7;
        int i9 = i8 >>> 1;
        while (i5 > i4 + 1) {
            int i10 = (i4 + i5) >>> 1;
            int i11 = iArr[i10];
            if (i11 > i9) {
                i5 = i10;
            } else if (i11 < i9) {
                i4 = i10;
            } else {
                return i10;
            }
        }
        if ((i8 - iArr[i4]) - iArr[i5] > 0) {
            return i5;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean j(double... dArr) {
        for (double d4 : dArr) {
            if (Double.isNaN(d4)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double k(double d4, double d5, double d6, double d7) {
        if (d4 == Double.NEGATIVE_INFINITY) {
            if (d5 != Double.POSITIVE_INFINITY) {
                return Double.NEGATIVE_INFINITY;
            }
            return Double.NaN;
        } else if (d5 == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        } else {
            return d4 + (((d5 - d4) * d6) / d7);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double[] l(int[] iArr) {
        int length = iArr.length;
        double[] dArr = new double[length];
        for (int i4 = 0; i4 < length; i4++) {
            dArr[i4] = iArr[i4];
        }
        return dArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static double[] m(long[] jArr) {
        int length = jArr.length;
        double[] dArr = new double[length];
        for (int i4 = 0; i4 < length; i4++) {
            dArr[i4] = jArr[i4];
        }
        return dArr;
    }

    public static ScaleAndIndex median() {
        return scale(2).index(1);
    }

    private static void n(double[] dArr, int i4, int i5) {
        boolean z3;
        boolean z4;
        boolean z5 = true;
        int i6 = (i4 + i5) >>> 1;
        double d4 = dArr[i5];
        double d5 = dArr[i6];
        if (d4 < d5) {
            z3 = true;
        } else {
            z3 = false;
        }
        double d6 = dArr[i4];
        if (d5 < d6) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (d4 >= d6) {
            z5 = false;
        }
        if (z3 == z4) {
            r(dArr, i6, i4);
        } else if (z3 != z5) {
            r(dArr, i4, i5);
        }
    }

    private static int o(double[] dArr, int i4, int i5) {
        n(dArr, i4, i5);
        double d4 = dArr[i4];
        int i6 = i5;
        while (i5 > i4) {
            if (dArr[i5] > d4) {
                r(dArr, i6, i5);
                i6--;
            }
            i5--;
        }
        r(dArr, i4, i6);
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p(int[] iArr, int i4, int i5, double[] dArr, int i6, int i7) {
        int i8 = i(iArr, i4, i5, i6, i7);
        int i9 = iArr[i8];
        q(i9, dArr, i6, i7);
        int i10 = i8 - 1;
        while (i10 >= i4 && iArr[i10] == i9) {
            i10--;
        }
        if (i10 >= i4) {
            p(iArr, i4, i10, dArr, i6, i9 - 1);
        }
        int i11 = i8 + 1;
        while (i11 <= i5 && iArr[i11] == i9) {
            i11++;
        }
        if (i11 <= i5) {
            p(iArr, i11, i5, dArr, i9 + 1, i7);
        }
    }

    public static Scale percentiles() {
        return scale(100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(int i4, double[] dArr, int i5, int i6) {
        if (i4 == i5) {
            int i7 = i5;
            for (int i8 = i5 + 1; i8 <= i6; i8++) {
                if (dArr[i7] > dArr[i8]) {
                    i7 = i8;
                }
            }
            if (i7 != i5) {
                r(dArr, i7, i5);
                return;
            }
            return;
        }
        while (i6 > i5) {
            int o4 = o(dArr, i5, i6);
            if (o4 >= i4) {
                i6 = o4 - 1;
            }
            if (o4 <= i4) {
                i5 = o4 + 1;
            }
        }
    }

    public static Scale quartiles() {
        return scale(4);
    }

    private static void r(double[] dArr, int i4, int i5) {
        double d4 = dArr[i4];
        dArr[i4] = dArr[i5];
        dArr[i5] = d4;
    }

    public static Scale scale(int i4) {
        return new Scale(i4);
    }
}
