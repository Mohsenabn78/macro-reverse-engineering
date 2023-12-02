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
import javax.annotation.CheckForNull;
import net.bytebuddy.pool.TypePool;

@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
/* loaded from: classes5.dex */
public final class Floats extends FloatsMethodsForWeb {
    public static final int BYTES = 4;

    @GwtCompatible
    /* loaded from: classes5.dex */
    private static class FloatArrayAsList extends AbstractList<Float> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final float[] array;
        final int end;
        final int start;

        FloatArrayAsList(float[] fArr) {
            this(fArr, 0, fArr.length);
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a */
        public Float get(int i4) {
            Preconditions.checkElementIndex(i4, size());
            return Float.valueOf(this.array[this.start + i4]);
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: b */
        public Float set(int i4, Float f4) {
            Preconditions.checkElementIndex(i4, size());
            float[] fArr = this.array;
            int i5 = this.start;
            float f5 = fArr[i5 + i4];
            fArr[i5 + i4] = ((Float) Preconditions.checkNotNull(f4)).floatValue();
            return Float.valueOf(f5);
        }

        float[] c() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object obj) {
            if ((obj instanceof Float) && Floats.c(this.array, ((Float) obj).floatValue(), this.start, this.end) != -1) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof FloatArrayAsList) {
                FloatArrayAsList floatArrayAsList = (FloatArrayAsList) obj;
                int size = size();
                if (floatArrayAsList.size() != size) {
                    return false;
                }
                for (int i4 = 0; i4 < size; i4++) {
                    if (this.array[this.start + i4] != floatArrayAsList.array[floatArrayAsList.start + i4]) {
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
                i4 = (i4 * 31) + Floats.hashCode(this.array[i5]);
            }
            return i4;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object obj) {
            int c4;
            if ((obj instanceof Float) && (c4 = Floats.c(this.array, ((Float) obj).floatValue(), this.start, this.end)) >= 0) {
                return c4 - this.start;
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(@CheckForNull Object obj) {
            int d4;
            if ((obj instanceof Float) && (d4 = Floats.d(this.array, ((Float) obj).floatValue(), this.start, this.end)) >= 0) {
                return d4 - this.start;
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Float> subList(int i4, int i5) {
            Preconditions.checkPositionIndexes(i4, i5, size());
            if (i4 == i5) {
                return Collections.emptyList();
            }
            float[] fArr = this.array;
            int i6 = this.start;
            return new FloatArrayAsList(fArr, i4 + i6, i6 + i5);
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

        FloatArrayAsList(float[] fArr, int i4, int i5) {
            this.array = fArr;
            this.start = i4;
            this.end = i5;
        }
    }

    /* loaded from: classes5.dex */
    private static final class FloatConverter extends Converter<String, Float> implements Serializable {

        /* renamed from: b  reason: collision with root package name */
        static final FloatConverter f28151b = new FloatConverter();
        private static final long serialVersionUID = 1;

        private FloatConverter() {
        }

        private Object readResolve() {
            return f28151b;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        /* renamed from: i */
        public String e(Float f4) {
            return f4.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        /* renamed from: j */
        public Float f(String str) {
            return Float.valueOf(str);
        }

        public String toString() {
            return "Floats.stringConverter()";
        }
    }

    /* loaded from: classes5.dex */
    private enum LexicographicalComparator implements Comparator<float[]> {
        INSTANCE;

        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(float[] fArr, float[] fArr2) {
            int min = Math.min(fArr.length, fArr2.length);
            for (int i4 = 0; i4 < min; i4++) {
                int compare = Float.compare(fArr[i4], fArr2[i4]);
                if (compare != 0) {
                    return compare;
                }
            }
            return fArr.length - fArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Floats.lexicographicalComparator()";
        }
    }

    private Floats() {
    }

    public static List<Float> asList(float... fArr) {
        if (fArr.length == 0) {
            return Collections.emptyList();
        }
        return new FloatArrayAsList(fArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int c(float[] fArr, float f4, int i4, int i5) {
        while (i4 < i5) {
            if (fArr[i4] == f4) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    public static int compare(float f4, float f5) {
        return Float.compare(f4, f5);
    }

    public static float[] concat(float[]... fArr) {
        int i4 = 0;
        for (float[] fArr2 : fArr) {
            i4 += fArr2.length;
        }
        float[] fArr3 = new float[i4];
        int i5 = 0;
        for (float[] fArr4 : fArr) {
            System.arraycopy(fArr4, 0, fArr3, i5, fArr4.length);
            i5 += fArr4.length;
        }
        return fArr3;
    }

    public static float constrainToRange(float f4, float f5, float f6) {
        if (f5 <= f6) {
            return Math.min(Math.max(f4, f5), f6);
        }
        throw new IllegalArgumentException(Strings.lenientFormat("min (%s) must be less than or equal to max (%s)", Float.valueOf(f5), Float.valueOf(f6)));
    }

    public static boolean contains(float[] fArr, float f4) {
        int length = fArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (fArr[i4] == f4) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(float[] fArr, float f4, int i4, int i5) {
        for (int i6 = i5 - 1; i6 >= i4; i6--) {
            if (fArr[i6] == f4) {
                return i6;
            }
        }
        return -1;
    }

    public static float[] ensureCapacity(float[] fArr, int i4, int i5) {
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
        if (fArr.length < i4) {
            return Arrays.copyOf(fArr, i4 + i5);
        }
        return fArr;
    }

    public static int hashCode(float f4) {
        return Float.valueOf(f4).hashCode();
    }

    public static int indexOf(float[] fArr, float f4) {
        return c(fArr, f4, 0, fArr.length);
    }

    public static boolean isFinite(float f4) {
        if (Float.NEGATIVE_INFINITY < f4 && f4 < Float.POSITIVE_INFINITY) {
            return true;
        }
        return false;
    }

    public static String join(String str, float... fArr) {
        Preconditions.checkNotNull(str);
        if (fArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(fArr.length * 12);
        sb.append(fArr[0]);
        for (int i4 = 1; i4 < fArr.length; i4++) {
            sb.append(str);
            sb.append(fArr[i4]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(float[] fArr, float f4) {
        return d(fArr, f4, 0, fArr.length);
    }

    public static Comparator<float[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    @GwtIncompatible("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static float max(float... fArr) {
        boolean z3;
        if (fArr.length > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        float f4 = fArr[0];
        for (int i4 = 1; i4 < fArr.length; i4++) {
            f4 = Math.max(f4, fArr[i4]);
        }
        return f4;
    }

    @GwtIncompatible("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static float min(float... fArr) {
        boolean z3;
        if (fArr.length > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        float f4 = fArr[0];
        for (int i4 = 1; i4 < fArr.length; i4++) {
            f4 = Math.min(f4, fArr[i4]);
        }
        return f4;
    }

    public static void reverse(float[] fArr) {
        Preconditions.checkNotNull(fArr);
        reverse(fArr, 0, fArr.length);
    }

    public static void rotate(float[] fArr, int i4) {
        rotate(fArr, i4, 0, fArr.length);
    }

    public static void sortDescending(float[] fArr) {
        Preconditions.checkNotNull(fArr);
        sortDescending(fArr, 0, fArr.length);
    }

    public static Converter<String, Float> stringConverter() {
        return FloatConverter.f28151b;
    }

    public static float[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof FloatArrayAsList) {
            return ((FloatArrayAsList) collection).c();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        float[] fArr = new float[length];
        for (int i4 = 0; i4 < length; i4++) {
            fArr[i4] = ((Number) Preconditions.checkNotNull(array[i4])).floatValue();
        }
        return fArr;
    }

    @J2ktIncompatible
    @CheckForNull
    @GwtIncompatible
    public static Float tryParse(String str) {
        if (Doubles.f28147a.matcher(str).matches()) {
            try {
                return Float.valueOf(Float.parseFloat(str));
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
    public static int indexOf(float[] r5, float[] r6) {
        /*
            java.lang.String r0 = "array"
            com.google.common.base.Preconditions.checkNotNull(r5, r0)
            java.lang.String r0 = "target"
            com.google.common.base.Preconditions.checkNotNull(r6, r0)
            int r0 = r6.length
            r1 = 0
            if (r0 != 0) goto Lf
            return r1
        Lf:
            r0 = 0
        L10:
            int r2 = r5.length
            int r3 = r6.length
            int r2 = r2 - r3
            int r2 = r2 + 1
            if (r0 >= r2) goto L2c
            r2 = 0
        L18:
            int r3 = r6.length
            if (r2 >= r3) goto L2b
            int r3 = r0 + r2
            r3 = r5[r3]
            r4 = r6[r2]
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 == 0) goto L28
            int r0 = r0 + 1
            goto L10
        L28:
            int r2 = r2 + 1
            goto L18
        L2b:
            return r0
        L2c:
            r5 = -1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.Floats.indexOf(float[], float[]):int");
    }

    public static void rotate(float[] fArr, int i4, int i5, int i6) {
        Preconditions.checkNotNull(fArr);
        Preconditions.checkPositionIndexes(i5, i6, fArr.length);
        if (fArr.length <= 1) {
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
        reverse(fArr, i5, i9);
        reverse(fArr, i9, i6);
        reverse(fArr, i5, i6);
    }

    public static void reverse(float[] fArr, int i4, int i5) {
        Preconditions.checkNotNull(fArr);
        Preconditions.checkPositionIndexes(i4, i5, fArr.length);
        for (int i6 = i5 - 1; i4 < i6; i6--) {
            float f4 = fArr[i4];
            fArr[i4] = fArr[i6];
            fArr[i6] = f4;
            i4++;
        }
    }

    public static void sortDescending(float[] fArr, int i4, int i5) {
        Preconditions.checkNotNull(fArr);
        Preconditions.checkPositionIndexes(i4, i5, fArr.length);
        Arrays.sort(fArr, i4, i5);
        reverse(fArr, i4, i5);
    }
}
