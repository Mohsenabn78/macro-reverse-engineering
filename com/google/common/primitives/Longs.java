package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
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
@GwtCompatible
/* loaded from: classes5.dex */
public final class Longs {
    public static final int BYTES = 8;
    public static final long MAX_POWER_OF_TWO = 4611686018427387904L;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static final class AsciiDigits {

        /* renamed from: a  reason: collision with root package name */
        private static final byte[] f28169a;

        static {
            byte[] bArr = new byte[128];
            Arrays.fill(bArr, (byte) -1);
            for (int i4 = 0; i4 < 10; i4++) {
                bArr[i4 + 48] = (byte) i4;
            }
            for (int i5 = 0; i5 < 26; i5++) {
                byte b4 = (byte) (i5 + 10);
                bArr[i5 + 65] = b4;
                bArr[i5 + 97] = b4;
            }
            f28169a = bArr;
        }

        private AsciiDigits() {
        }

        static int a(char c4) {
            if (c4 < 128) {
                return f28169a[c4];
            }
            return -1;
        }
    }

    /* loaded from: classes5.dex */
    private enum LexicographicalComparator implements Comparator<long[]> {
        INSTANCE;

        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(long[] jArr, long[] jArr2) {
            int min = Math.min(jArr.length, jArr2.length);
            for (int i4 = 0; i4 < min; i4++) {
                int compare = Longs.compare(jArr[i4], jArr2[i4]);
                if (compare != 0) {
                    return compare;
                }
            }
            return jArr.length - jArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Longs.lexicographicalComparator()";
        }
    }

    @GwtCompatible
    /* loaded from: classes5.dex */
    private static class LongArrayAsList extends AbstractList<Long> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final long[] array;
        final int end;
        final int start;

        LongArrayAsList(long[] jArr) {
            this(jArr, 0, jArr.length);
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a */
        public Long get(int i4) {
            Preconditions.checkElementIndex(i4, size());
            return Long.valueOf(this.array[this.start + i4]);
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: b */
        public Long set(int i4, Long l4) {
            Preconditions.checkElementIndex(i4, size());
            long[] jArr = this.array;
            int i5 = this.start;
            long j4 = jArr[i5 + i4];
            jArr[i5 + i4] = ((Long) Preconditions.checkNotNull(l4)).longValue();
            return Long.valueOf(j4);
        }

        long[] c() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object obj) {
            if ((obj instanceof Long) && Longs.c(this.array, ((Long) obj).longValue(), this.start, this.end) != -1) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof LongArrayAsList) {
                LongArrayAsList longArrayAsList = (LongArrayAsList) obj;
                int size = size();
                if (longArrayAsList.size() != size) {
                    return false;
                }
                for (int i4 = 0; i4 < size; i4++) {
                    if (this.array[this.start + i4] != longArrayAsList.array[longArrayAsList.start + i4]) {
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
                i4 = (i4 * 31) + Longs.hashCode(this.array[i5]);
            }
            return i4;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object obj) {
            int c4;
            if ((obj instanceof Long) && (c4 = Longs.c(this.array, ((Long) obj).longValue(), this.start, this.end)) >= 0) {
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
            if ((obj instanceof Long) && (d4 = Longs.d(this.array, ((Long) obj).longValue(), this.start, this.end)) >= 0) {
                return d4 - this.start;
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Long> subList(int i4, int i5) {
            Preconditions.checkPositionIndexes(i4, i5, size());
            if (i4 == i5) {
                return Collections.emptyList();
            }
            long[] jArr = this.array;
            int i6 = this.start;
            return new LongArrayAsList(jArr, i4 + i6, i6 + i5);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 10);
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

        LongArrayAsList(long[] jArr, int i4, int i5) {
            this.array = jArr;
            this.start = i4;
            this.end = i5;
        }
    }

    /* loaded from: classes5.dex */
    private static final class LongConverter extends Converter<String, Long> implements Serializable {

        /* renamed from: b  reason: collision with root package name */
        static final LongConverter f28172b = new LongConverter();
        private static final long serialVersionUID = 1;

        private LongConverter() {
        }

        private Object readResolve() {
            return f28172b;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        /* renamed from: i */
        public String e(Long l4) {
            return l4.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        /* renamed from: j */
        public Long f(String str) {
            return Long.decode(str);
        }

        public String toString() {
            return "Longs.stringConverter()";
        }
    }

    private Longs() {
    }

    public static List<Long> asList(long... jArr) {
        if (jArr.length == 0) {
            return Collections.emptyList();
        }
        return new LongArrayAsList(jArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int c(long[] jArr, long j4, int i4, int i5) {
        while (i4 < i5) {
            if (jArr[i4] == j4) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    public static int compare(long j4, long j5) {
        int i4 = (j4 > j5 ? 1 : (j4 == j5 ? 0 : -1));
        if (i4 < 0) {
            return -1;
        }
        if (i4 > 0) {
            return 1;
        }
        return 0;
    }

    public static long[] concat(long[]... jArr) {
        int i4 = 0;
        for (long[] jArr2 : jArr) {
            i4 += jArr2.length;
        }
        long[] jArr3 = new long[i4];
        int i5 = 0;
        for (long[] jArr4 : jArr) {
            System.arraycopy(jArr4, 0, jArr3, i5, jArr4.length);
            i5 += jArr4.length;
        }
        return jArr3;
    }

    public static long constrainToRange(long j4, long j5, long j6) {
        boolean z3;
        if (j5 <= j6) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "min (%s) must be less than or equal to max (%s)", j5, j6);
        return Math.min(Math.max(j4, j5), j6);
    }

    public static boolean contains(long[] jArr, long j4) {
        int length = jArr.length;
        for (int i4 = 0; i4 < length; i4++) {
            if (jArr[i4] == j4) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(long[] jArr, long j4, int i4, int i5) {
        for (int i6 = i5 - 1; i6 >= i4; i6--) {
            if (jArr[i6] == j4) {
                return i6;
            }
        }
        return -1;
    }

    public static long[] ensureCapacity(long[] jArr, int i4, int i5) {
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
        if (jArr.length < i4) {
            return Arrays.copyOf(jArr, i4 + i5);
        }
        return jArr;
    }

    public static long fromByteArray(byte[] bArr) {
        boolean z3;
        if (bArr.length >= 8) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "array too small: %s < %s", bArr.length, 8);
        return fromBytes(bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5], bArr[6], bArr[7]);
    }

    public static long fromBytes(byte b4, byte b5, byte b6, byte b7, byte b8, byte b9, byte b10, byte b11) {
        return ((b5 & 255) << 48) | ((b4 & 255) << 56) | ((b6 & 255) << 40) | ((b7 & 255) << 32) | ((b8 & 255) << 24) | ((b9 & 255) << 16) | ((b10 & 255) << 8) | (b11 & 255);
    }

    public static int hashCode(long j4) {
        return (int) (j4 ^ (j4 >>> 32));
    }

    public static int indexOf(long[] jArr, long j4) {
        return c(jArr, j4, 0, jArr.length);
    }

    public static String join(String str, long... jArr) {
        Preconditions.checkNotNull(str);
        if (jArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(jArr.length * 10);
        sb.append(jArr[0]);
        for (int i4 = 1; i4 < jArr.length; i4++) {
            sb.append(str);
            sb.append(jArr[i4]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(long[] jArr, long j4) {
        return d(jArr, j4, 0, jArr.length);
    }

    public static Comparator<long[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static long max(long... jArr) {
        boolean z3;
        if (jArr.length > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        long j4 = jArr[0];
        for (int i4 = 1; i4 < jArr.length; i4++) {
            long j5 = jArr[i4];
            if (j5 > j4) {
                j4 = j5;
            }
        }
        return j4;
    }

    public static long min(long... jArr) {
        boolean z3;
        if (jArr.length > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        long j4 = jArr[0];
        for (int i4 = 1; i4 < jArr.length; i4++) {
            long j5 = jArr[i4];
            if (j5 < j4) {
                j4 = j5;
            }
        }
        return j4;
    }

    public static void reverse(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        reverse(jArr, 0, jArr.length);
    }

    public static void rotate(long[] jArr, int i4) {
        rotate(jArr, i4, 0, jArr.length);
    }

    public static void sortDescending(long[] jArr) {
        Preconditions.checkNotNull(jArr);
        sortDescending(jArr, 0, jArr.length);
    }

    public static Converter<String, Long> stringConverter() {
        return LongConverter.f28172b;
    }

    public static long[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof LongArrayAsList) {
            return ((LongArrayAsList) collection).c();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        long[] jArr = new long[length];
        for (int i4 = 0; i4 < length; i4++) {
            jArr[i4] = ((Number) Preconditions.checkNotNull(array[i4])).longValue();
        }
        return jArr;
    }

    public static byte[] toByteArray(long j4) {
        byte[] bArr = new byte[8];
        for (int i4 = 7; i4 >= 0; i4--) {
            bArr[i4] = (byte) (255 & j4);
            j4 >>= 8;
        }
        return bArr;
    }

    @CheckForNull
    public static Long tryParse(String str) {
        return tryParse(str, 10);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int indexOf(long[] r8, long[] r9) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.Longs.indexOf(long[], long[]):int");
    }

    public static void rotate(long[] jArr, int i4, int i5, int i6) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i5, i6, jArr.length);
        if (jArr.length <= 1) {
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
        reverse(jArr, i5, i9);
        reverse(jArr, i9, i6);
        reverse(jArr, i5, i6);
    }

    @CheckForNull
    public static Long tryParse(String str, int i4) {
        if (((String) Preconditions.checkNotNull(str)).isEmpty()) {
            return null;
        }
        if (i4 >= 2 && i4 <= 36) {
            int i5 = str.charAt(0) == '-' ? 1 : 0;
            if (i5 == str.length()) {
                return null;
            }
            int i6 = i5 + 1;
            int a4 = AsciiDigits.a(str.charAt(i5));
            if (a4 < 0 || a4 >= i4) {
                return null;
            }
            long j4 = -a4;
            long j5 = i4;
            long j6 = Long.MIN_VALUE / j5;
            while (i6 < str.length()) {
                int i7 = i6 + 1;
                int a5 = AsciiDigits.a(str.charAt(i6));
                if (a5 < 0 || a5 >= i4 || j4 < j6) {
                    return null;
                }
                long j7 = j4 * j5;
                long j8 = a5;
                if (j7 < j8 - Long.MIN_VALUE) {
                    return null;
                }
                j4 = j7 - j8;
                i6 = i7;
            }
            if (i5 != 0) {
                return Long.valueOf(j4);
            }
            if (j4 == Long.MIN_VALUE) {
                return null;
            }
            return Long.valueOf(-j4);
        }
        throw new IllegalArgumentException("radix must be between MIN_RADIX and MAX_RADIX but was " + i4);
    }

    public static void reverse(long[] jArr, int i4, int i5) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i4, i5, jArr.length);
        for (int i6 = i5 - 1; i4 < i6; i6--) {
            long j4 = jArr[i4];
            jArr[i4] = jArr[i6];
            jArr[i6] = j4;
            i4++;
        }
    }

    public static void sortDescending(long[] jArr, int i4, int i5) {
        Preconditions.checkNotNull(jArr);
        Preconditions.checkPositionIndexes(i4, i5, jArr.length);
        Arrays.sort(jArr, i4, i5);
        reverse(jArr, i4, i5);
    }
}
