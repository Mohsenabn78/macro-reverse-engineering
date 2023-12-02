package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import java.util.regex.Pattern;
import javax.annotation.CheckForNull;
import net.bytebuddy.pool.TypePool;
import org.slf4j.Marker;

@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
/* loaded from: classes5.dex */
public final class Doubles extends DoublesMethodsForWeb {
    public static final int BYTES = 8;
    @J2ktIncompatible
    @GwtIncompatible

    /* renamed from: a  reason: collision with root package name */
    static final Pattern f28147a = c();

    @GwtCompatible
    /* loaded from: classes5.dex */
    private static class DoubleArrayAsList extends AbstractList<Double> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final double[] array;
        final int end;
        final int start;

        DoubleArrayAsList(double[] dArr) {
            this(dArr, 0, dArr.length);
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a */
        public Double get(int i4) {
            Preconditions.checkElementIndex(i4, size());
            return Double.valueOf(this.array[this.start + i4]);
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: b */
        public Double set(int i4, Double d4) {
            Preconditions.checkElementIndex(i4, size());
            double[] dArr = this.array;
            int i5 = this.start;
            double d5 = dArr[i5 + i4];
            dArr[i5 + i4] = ((Double) Preconditions.checkNotNull(d4)).doubleValue();
            return Double.valueOf(d5);
        }

        double[] c() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object obj) {
            if ((obj instanceof Double) && Doubles.d(this.array, ((Double) obj).doubleValue(), this.start, this.end) != -1) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof DoubleArrayAsList) {
                DoubleArrayAsList doubleArrayAsList = (DoubleArrayAsList) obj;
                int size = size();
                if (doubleArrayAsList.size() != size) {
                    return false;
                }
                for (int i4 = 0; i4 < size; i4++) {
                    if (this.array[this.start + i4] != doubleArrayAsList.array[doubleArrayAsList.start + i4]) {
                        return false;
                    }
                }
                return true;
            }
            return super.equals(obj);
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            int i4 = 1;
            for (int i5 = this.start; i5 < this.end; i5++) {
                i4 = (i4 * 31) + Doubles.hashCode(this.array[i5]);
            }
            return i4;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object obj) {
            int d4;
            if ((obj instanceof Double) && (d4 = Doubles.d(this.array, ((Double) obj).doubleValue(), this.start, this.end)) >= 0) {
                return d4 - this.start;
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(@CheckForNull Object obj) {
            int e4;
            if ((obj instanceof Double) && (e4 = Doubles.e(this.array, ((Double) obj).doubleValue(), this.start, this.end)) >= 0) {
                return e4 - this.start;
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Double> subList(int i4, int i5) {
            Preconditions.checkPositionIndexes(i4, i5, size());
            if (i4 == i5) {
                return Collections.emptyList();
            }
            double[] dArr = this.array;
            int i6 = this.start;
            return new DoubleArrayAsList(dArr, i4 + i6, i6 + i5);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 12);
            sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
            sb.append(this.array[this.start]);
            int i4 = this.start;
            while (true) {
                i4++;
                if (i4 < this.end) {
                    sb.append(", ");
                    sb.append(this.array[i4]);
                } else {
                    sb.append(']');
                    return sb.toString();
                }
            }
        }

        DoubleArrayAsList(double[] dArr, int i4, int i5) {
            this.array = dArr;
            this.start = i4;
            this.end = i5;
        }
    }

    /* loaded from: classes5.dex */
    private static final class DoubleConverter extends Converter<String, Double> implements Serializable {

        /* renamed from: b  reason: collision with root package name */
        static final DoubleConverter f28148b = new DoubleConverter();
        private static final long serialVersionUID = 1;

        private DoubleConverter() {
        }

        private Object readResolve() {
            return f28148b;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        /* renamed from: i */
        public String e(Double d4) {
            return d4.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        /* renamed from: j */
        public Double f(String str) {
            return Double.valueOf(str);
        }

        public String toString() {
            return "Doubles.stringConverter()";
        }
    }

    /* loaded from: classes5.dex */
    private enum LexicographicalComparator implements Comparator<double[]> {
        INSTANCE;

        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(double[] dArr, double[] dArr2) {
            int min = Math.min(dArr.length, dArr2.length);
            for (int i4 = 0; i4 < min; i4++) {
                int compare = Double.compare(dArr[i4], dArr2[i4]);
                if (compare != 0) {
                    return compare;
                }
            }
            return dArr.length - dArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Doubles.lexicographicalComparator()";
        }
    }

    private Doubles() {
    }

    public static List<Double> asList(double... dArr) {
        if (dArr.length == 0) {
            return Collections.emptyList();
        }
        return new DoubleArrayAsList(dArr);
    }

    @GwtIncompatible
    private static Pattern c() {
        return Pattern.compile(("[+-]?(?:NaN|Infinity|" + ("(?:\\d+#(?:\\.\\d*#)?|\\.\\d+#)(?:[eE][+-]?\\d+#)?[fFdD]?") + "|" + ("0[xX](?:[0-9a-fA-F]+#(?:\\.[0-9a-fA-F]*#)?|\\.[0-9a-fA-F]+#)[pP][+-]?\\d+#[fFdD]?") + ")").replace("#", Marker.ANY_NON_NULL_MARKER));
    }

    public static int compare(double d4, double d5) {
        return Double.compare(d4, d5);
    }

    public static double[] concat(double[]... dArr) {
        int i4 = 0;
        for (double[] dArr2 : dArr) {
            i4 += dArr2.length;
        }
        double[] dArr3 = new double[i4];
        int i5 = 0;
        for (double[] dArr4 : dArr) {
            System.arraycopy(dArr4, 0, dArr3, i5, dArr4.length);
            i5 += dArr4.length;
        }
        return dArr3;
    }

    public static double constrainToRange(double d4, double d5, double d6) {
        if (d5 <= d6) {
            return Math.min(Math.max(d4, d5), d6);
        }
        throw new IllegalArgumentException(Strings.lenientFormat("min (%s) must be less than or equal to max (%s)", Double.valueOf(d5), Double.valueOf(d6)));
    }

    public static boolean contains(double[] dArr, double d4) {
        int length = dArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (dArr[i4] == d4) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(double[] dArr, double d4, int i4, int i5) {
        while (i4 < i5) {
            if (dArr[i4] == d4) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int e(double[] dArr, double d4, int i4, int i5) {
        for (int i6 = i5 - 1; i6 >= i4; i6--) {
            if (dArr[i6] == d4) {
                return i6;
            }
        }
        return -1;
    }

    public static double[] ensureCapacity(double[] dArr, int i4, int i5) {
        boolean z3;
        boolean z4 = true;
        if (i4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Invalid minLength: %s", i4);
        if (i5 < 0) {
            z4 = false;
        }
        Preconditions.checkArgument(z4, "Invalid padding: %s", i5);
        if (dArr.length < i4) {
            return Arrays.copyOf(dArr, i4 + i5);
        }
        return dArr;
    }

    public static int hashCode(double d4) {
        return Double.valueOf(d4).hashCode();
    }

    public static int indexOf(double[] dArr, double d4) {
        return d(dArr, d4, 0, dArr.length);
    }

    public static boolean isFinite(double d4) {
        if (Double.NEGATIVE_INFINITY < d4 && d4 < Double.POSITIVE_INFINITY) {
            return true;
        }
        return false;
    }

    public static String join(String str, double... dArr) {
        Preconditions.checkNotNull(str);
        if (dArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(dArr.length * 12);
        sb.append(dArr[0]);
        for (int i4 = 1; i4 < dArr.length; i4++) {
            sb.append(str);
            sb.append(dArr[i4]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(double[] dArr, double d4) {
        return e(dArr, d4, 0, dArr.length);
    }

    public static Comparator<double[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    @GwtIncompatible("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static double max(double... dArr) {
        boolean z3;
        if (dArr.length > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        double d4 = dArr[0];
        for (int i4 = 1; i4 < dArr.length; i4++) {
            d4 = Math.max(d4, dArr[i4]);
        }
        return d4;
    }

    @GwtIncompatible("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static double min(double... dArr) {
        boolean z3;
        if (dArr.length > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        double d4 = dArr[0];
        for (int i4 = 1; i4 < dArr.length; i4++) {
            d4 = Math.min(d4, dArr[i4]);
        }
        return d4;
    }

    public static void reverse(double[] dArr) {
        Preconditions.checkNotNull(dArr);
        reverse(dArr, 0, dArr.length);
    }

    public static void rotate(double[] dArr, int i4) {
        rotate(dArr, i4, 0, dArr.length);
    }

    public static void sortDescending(double[] dArr) {
        Preconditions.checkNotNull(dArr);
        sortDescending(dArr, 0, dArr.length);
    }

    public static Converter<String, Double> stringConverter() {
        return DoubleConverter.f28148b;
    }

    public static double[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof DoubleArrayAsList) {
            return ((DoubleArrayAsList) collection).c();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        double[] dArr = new double[length];
        for (int i4 = 0; i4 < length; i4++) {
            dArr[i4] = ((Number) Preconditions.checkNotNull(array[i4])).doubleValue();
        }
        return dArr;
    }

    @J2ktIncompatible
    @CheckForNull
    @GwtIncompatible
    public static Double tryParse(String str) {
        if (f28147a.matcher(str).matches()) {
            try {
                return Double.valueOf(Double.parseDouble(str));
            } catch (NumberFormatException unused) {
                return null;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int indexOf(double[] r8, double[] r9) {
        /*
            java.lang.String r0 = "array"
            com.google.common.base.Preconditions.checkNotNull(r8, r0)
            java.lang.String r0 = "target"
            com.google.common.base.Preconditions.checkNotNull(r9, r0)
            int r0 = r9.length
            r1 = 0
            if (r0 != 0) goto Lf
            return r1
        Lf:
            r0 = 0
        L10:
            int r2 = r8.length
            int r3 = r9.length
            int r2 = r2 - r3
            int r2 = r2 + 1
            if (r0 >= r2) goto L2c
            r2 = 0
        L18:
            int r3 = r9.length
            if (r2 >= r3) goto L2b
            int r3 = r0 + r2
            r3 = r8[r3]
            r5 = r9[r2]
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L28
            int r0 = r0 + 1
            goto L10
        L28:
            int r2 = r2 + 1
            goto L18
        L2b:
            return r0
        L2c:
            r8 = -1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.Doubles.indexOf(double[], double[]):int");
    }

    public static void rotate(double[] dArr, int i4, int i5, int i6) {
        Preconditions.checkNotNull(dArr);
        Preconditions.checkPositionIndexes(i5, i6, dArr.length);
        if (dArr.length <= 1) {
            return;
        }
        int i7 = i6 - i5;
        int i8 = (-i4) % i7;
        if (i8 < 0) {
            i8 += i7;
        }
        int i9 = i8 + i5;
        if (i9 == i5) {
            return;
        }
        reverse(dArr, i5, i9);
        reverse(dArr, i9, i6);
        reverse(dArr, i5, i6);
    }

    public static void reverse(double[] dArr, int i4, int i5) {
        Preconditions.checkNotNull(dArr);
        Preconditions.checkPositionIndexes(i4, i5, dArr.length);
        for (int i6 = i5 - 1; i4 < i6; i6--) {
            double d4 = dArr[i4];
            dArr[i4] = dArr[i6];
            dArr[i6] = d4;
            i4++;
        }
    }

    public static void sortDescending(double[] dArr, int i4, int i5) {
        Preconditions.checkNotNull(dArr);
        Preconditions.checkPositionIndexes(i4, i5, dArr.length);
        Arrays.sort(dArr, i4, i5);
        reverse(dArr, i4, i5);
    }
}
