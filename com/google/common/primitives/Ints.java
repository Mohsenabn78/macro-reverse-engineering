package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
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
public final class Ints extends IntsMethodsForWeb {
    public static final int BYTES = 4;
    public static final int MAX_POWER_OF_TWO = 1073741824;

    @GwtCompatible
    /* loaded from: classes5.dex */
    private static class IntArrayAsList extends AbstractList<Integer> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final int[] array;
        final int end;
        final int start;

        IntArrayAsList(int[] iArr) {
            this(iArr, 0, iArr.length);
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a */
        public Integer get(int i4) {
            Preconditions.checkElementIndex(i4, size());
            return Integer.valueOf(this.array[this.start + i4]);
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: b */
        public Integer set(int i4, Integer num) {
            Preconditions.checkElementIndex(i4, size());
            int[] iArr = this.array;
            int i5 = this.start;
            int i6 = iArr[i5 + i4];
            iArr[i5 + i4] = ((Integer) Preconditions.checkNotNull(num)).intValue();
            return Integer.valueOf(i6);
        }

        int[] c() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object obj) {
            if ((obj instanceof Integer) && Ints.c(this.array, ((Integer) obj).intValue(), this.start, this.end) != -1) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof IntArrayAsList) {
                IntArrayAsList intArrayAsList = (IntArrayAsList) obj;
                int size = size();
                if (intArrayAsList.size() != size) {
                    return false;
                }
                for (int i4 = 0; i4 < size; i4++) {
                    if (this.array[this.start + i4] != intArrayAsList.array[intArrayAsList.start + i4]) {
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
                i4 = (i4 * 31) + Ints.hashCode(this.array[i5]);
            }
            return i4;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object obj) {
            int c4;
            if ((obj instanceof Integer) && (c4 = Ints.c(this.array, ((Integer) obj).intValue(), this.start, this.end)) >= 0) {
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
            if ((obj instanceof Integer) && (d4 = Ints.d(this.array, ((Integer) obj).intValue(), this.start, this.end)) >= 0) {
                return d4 - this.start;
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Integer> subList(int i4, int i5) {
            Preconditions.checkPositionIndexes(i4, i5, size());
            if (i4 == i5) {
                return Collections.emptyList();
            }
            int[] iArr = this.array;
            int i6 = this.start;
            return new IntArrayAsList(iArr, i4 + i6, i6 + i5);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 5);
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

        IntArrayAsList(int[] iArr, int i4, int i5) {
            this.array = iArr;
            this.start = i4;
            this.end = i5;
        }
    }

    /* loaded from: classes5.dex */
    private static final class IntConverter extends Converter<String, Integer> implements Serializable {

        /* renamed from: b  reason: collision with root package name */
        static final IntConverter f28166b = new IntConverter();
        private static final long serialVersionUID = 1;

        private IntConverter() {
        }

        private Object readResolve() {
            return f28166b;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        /* renamed from: i */
        public String e(Integer num) {
            return num.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        /* renamed from: j */
        public Integer f(String str) {
            return Integer.decode(str);
        }

        public String toString() {
            return "Ints.stringConverter()";
        }
    }

    /* loaded from: classes5.dex */
    private enum LexicographicalComparator implements Comparator<int[]> {
        INSTANCE;

        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(int[] iArr, int[] iArr2) {
            int min = Math.min(iArr.length, iArr2.length);
            for (int i4 = 0; i4 < min; i4++) {
                int compare = Ints.compare(iArr[i4], iArr2[i4]);
                if (compare != 0) {
                    return compare;
                }
            }
            return iArr.length - iArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Ints.lexicographicalComparator()";
        }
    }

    private Ints() {
    }

    public static List<Integer> asList(int... iArr) {
        if (iArr.length == 0) {
            return Collections.emptyList();
        }
        return new IntArrayAsList(iArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int c(int[] iArr, int i4, int i5, int i6) {
        while (i5 < i6) {
            if (iArr[i5] == i4) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    public static int checkedCast(long j4) {
        boolean z3;
        int i4 = (int) j4;
        if (i4 == j4) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Out of range: %s", j4);
        return i4;
    }

    public static int compare(int i4, int i5) {
        if (i4 < i5) {
            return -1;
        }
        if (i4 > i5) {
            return 1;
        }
        return 0;
    }

    public static int[] concat(int[]... iArr) {
        int i4 = 0;
        for (int[] iArr2 : iArr) {
            i4 += iArr2.length;
        }
        int[] iArr3 = new int[i4];
        int i5 = 0;
        for (int[] iArr4 : iArr) {
            System.arraycopy(iArr4, 0, iArr3, i5, iArr4.length);
            i5 += iArr4.length;
        }
        return iArr3;
    }

    public static int constrainToRange(int i4, int i5, int i6) {
        boolean z3;
        if (i5 <= i6) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "min (%s) must be less than or equal to max (%s)", i5, i6);
        return Math.min(Math.max(i4, i5), i6);
    }

    public static boolean contains(int[] iArr, int i4) {
        for (int i5 : iArr) {
            if (i5 == i4) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(int[] iArr, int i4, int i5, int i6) {
        for (int i7 = i6 - 1; i7 >= i5; i7--) {
            if (iArr[i7] == i4) {
                return i7;
            }
        }
        return -1;
    }

    public static int[] ensureCapacity(int[] iArr, int i4, int i5) {
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
        if (iArr.length < i4) {
            return Arrays.copyOf(iArr, i4 + i5);
        }
        return iArr;
    }

    public static int fromByteArray(byte[] bArr) {
        boolean z3;
        if (bArr.length >= 4) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "array too small: %s < %s", bArr.length, 4);
        return fromBytes(bArr[0], bArr[1], bArr[2], bArr[3]);
    }

    public static int fromBytes(byte b4, byte b5, byte b6, byte b7) {
        return (b4 << Ascii.CAN) | ((b5 & 255) << 16) | ((b6 & 255) << 8) | (b7 & 255);
    }

    public static int indexOf(int[] iArr, int i4) {
        return c(iArr, i4, 0, iArr.length);
    }

    public static String join(String str, int... iArr) {
        Preconditions.checkNotNull(str);
        if (iArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(iArr.length * 5);
        sb.append(iArr[0]);
        for (int i4 = 1; i4 < iArr.length; i4++) {
            sb.append(str);
            sb.append(iArr[i4]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(int[] iArr, int i4) {
        return d(iArr, i4, 0, iArr.length);
    }

    public static Comparator<int[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    @GwtIncompatible("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static int max(int... iArr) {
        boolean z3;
        if (iArr.length > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        int i4 = iArr[0];
        for (int i5 = 1; i5 < iArr.length; i5++) {
            int i6 = iArr[i5];
            if (i6 > i4) {
                i4 = i6;
            }
        }
        return i4;
    }

    @GwtIncompatible("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static int min(int... iArr) {
        boolean z3;
        if (iArr.length > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        int i4 = iArr[0];
        for (int i5 = 1; i5 < iArr.length; i5++) {
            int i6 = iArr[i5];
            if (i6 < i4) {
                i4 = i6;
            }
        }
        return i4;
    }

    public static void reverse(int[] iArr) {
        Preconditions.checkNotNull(iArr);
        reverse(iArr, 0, iArr.length);
    }

    public static void rotate(int[] iArr, int i4) {
        rotate(iArr, i4, 0, iArr.length);
    }

    public static int saturatedCast(long j4) {
        if (j4 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j4 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j4;
    }

    public static void sortDescending(int[] iArr) {
        Preconditions.checkNotNull(iArr);
        sortDescending(iArr, 0, iArr.length);
    }

    public static Converter<String, Integer> stringConverter() {
        return IntConverter.f28166b;
    }

    public static int[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof IntArrayAsList) {
            return ((IntArrayAsList) collection).c();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        int[] iArr = new int[length];
        for (int i4 = 0; i4 < length; i4++) {
            iArr[i4] = ((Number) Preconditions.checkNotNull(array[i4])).intValue();
        }
        return iArr;
    }

    public static byte[] toByteArray(int i4) {
        return new byte[]{(byte) (i4 >> 24), (byte) (i4 >> 16), (byte) (i4 >> 8), (byte) i4};
    }

    @CheckForNull
    public static Integer tryParse(String str) {
        return tryParse(str, 10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int indexOf(int[] r5, int[] r6) {
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
            if (r0 >= r2) goto L2a
            r2 = 0
        L18:
            int r3 = r6.length
            if (r2 >= r3) goto L29
            int r3 = r0 + r2
            r3 = r5[r3]
            r4 = r6[r2]
            if (r3 == r4) goto L26
            int r0 = r0 + 1
            goto L10
        L26:
            int r2 = r2 + 1
            goto L18
        L29:
            return r0
        L2a:
            r5 = -1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.Ints.indexOf(int[], int[]):int");
    }

    public static void rotate(int[] iArr, int i4, int i5, int i6) {
        Preconditions.checkNotNull(iArr);
        Preconditions.checkPositionIndexes(i5, i6, iArr.length);
        if (iArr.length <= 1) {
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
        reverse(iArr, i5, i9);
        reverse(iArr, i9, i6);
        reverse(iArr, i5, i6);
    }

    @CheckForNull
    public static Integer tryParse(String str, int i4) {
        Long tryParse = Longs.tryParse(str, i4);
        if (tryParse == null || tryParse.longValue() != tryParse.intValue()) {
            return null;
        }
        return Integer.valueOf(tryParse.intValue());
    }

    public static void reverse(int[] iArr, int i4, int i5) {
        Preconditions.checkNotNull(iArr);
        Preconditions.checkPositionIndexes(i4, i5, iArr.length);
        for (int i6 = i5 - 1; i4 < i6; i6--) {
            int i7 = iArr[i4];
            iArr[i4] = iArr[i6];
            iArr[i6] = i7;
            i4++;
        }
    }

    public static void sortDescending(int[] iArr, int i4, int i5) {
        Preconditions.checkNotNull(iArr);
        Preconditions.checkPositionIndexes(i4, i5, iArr.length);
        Arrays.sort(iArr, i4, i5);
        reverse(iArr, i4, i5);
    }

    public static int hashCode(int i4) {
        return i4;
    }
}
