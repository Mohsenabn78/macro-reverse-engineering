package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
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
import kotlin.jvm.internal.ShortCompanionObject;
import net.bytebuddy.pool.TypePool;

@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
/* loaded from: classes5.dex */
public final class Shorts extends ShortsMethodsForWeb {
    public static final int BYTES = 2;
    public static final short MAX_POWER_OF_TWO = 16384;

    /* loaded from: classes5.dex */
    private enum LexicographicalComparator implements Comparator<short[]> {
        INSTANCE;

        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(short[] sArr, short[] sArr2) {
            int min = Math.min(sArr.length, sArr2.length);
            for (int i4 = 0; i4 < min; i4++) {
                int compare = Shorts.compare(sArr[i4], sArr2[i4]);
                if (compare != 0) {
                    return compare;
                }
            }
            return sArr.length - sArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Shorts.lexicographicalComparator()";
        }
    }

    @GwtCompatible
    /* loaded from: classes5.dex */
    private static class ShortArrayAsList extends AbstractList<Short> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final short[] array;
        final int end;
        final int start;

        ShortArrayAsList(short[] sArr) {
            this(sArr, 0, sArr.length);
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a */
        public Short get(int i4) {
            Preconditions.checkElementIndex(i4, size());
            return Short.valueOf(this.array[this.start + i4]);
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: b */
        public Short set(int i4, Short sh) {
            Preconditions.checkElementIndex(i4, size());
            short[] sArr = this.array;
            int i5 = this.start;
            short s3 = sArr[i5 + i4];
            sArr[i5 + i4] = ((Short) Preconditions.checkNotNull(sh)).shortValue();
            return Short.valueOf(s3);
        }

        short[] c() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object obj) {
            if ((obj instanceof Short) && Shorts.c(this.array, ((Short) obj).shortValue(), this.start, this.end) != -1) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ShortArrayAsList) {
                ShortArrayAsList shortArrayAsList = (ShortArrayAsList) obj;
                int size = size();
                if (shortArrayAsList.size() != size) {
                    return false;
                }
                for (int i4 = 0; i4 < size; i4++) {
                    if (this.array[this.start + i4] != shortArrayAsList.array[shortArrayAsList.start + i4]) {
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
                i4 = (i4 * 31) + Shorts.hashCode(this.array[i5]);
            }
            return i4;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object obj) {
            int c4;
            if ((obj instanceof Short) && (c4 = Shorts.c(this.array, ((Short) obj).shortValue(), this.start, this.end)) >= 0) {
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
            if ((obj instanceof Short) && (d4 = Shorts.d(this.array, ((Short) obj).shortValue(), this.start, this.end)) >= 0) {
                return d4 - this.start;
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Short> subList(int i4, int i5) {
            Preconditions.checkPositionIndexes(i4, i5, size());
            if (i4 == i5) {
                return Collections.emptyList();
            }
            short[] sArr = this.array;
            int i6 = this.start;
            return new ShortArrayAsList(sArr, i4 + i6, i6 + i5);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 6);
            sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
            sb.append((int) this.array[this.start]);
            int i4 = this.start;
            while (true) {
                i4++;
                if (i4 < this.end) {
                    sb.append(", ");
                    sb.append((int) this.array[i4]);
                } else {
                    sb.append(']');
                    return sb.toString();
                }
            }
        }

        ShortArrayAsList(short[] sArr, int i4, int i5) {
            this.array = sArr;
            this.start = i4;
            this.end = i5;
        }
    }

    /* loaded from: classes5.dex */
    private static final class ShortConverter extends Converter<String, Short> implements Serializable {

        /* renamed from: b  reason: collision with root package name */
        static final ShortConverter f28179b = new ShortConverter();
        private static final long serialVersionUID = 1;

        private ShortConverter() {
        }

        private Object readResolve() {
            return f28179b;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        /* renamed from: i */
        public String e(Short sh) {
            return sh.toString();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.Converter
        /* renamed from: j */
        public Short f(String str) {
            return Short.decode(str);
        }

        public String toString() {
            return "Shorts.stringConverter()";
        }
    }

    private Shorts() {
    }

    public static List<Short> asList(short... sArr) {
        if (sArr.length == 0) {
            return Collections.emptyList();
        }
        return new ShortArrayAsList(sArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int c(short[] sArr, short s3, int i4, int i5) {
        while (i4 < i5) {
            if (sArr[i4] == s3) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    public static short checkedCast(long j4) {
        boolean z3;
        short s3 = (short) j4;
        if (s3 == j4) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Out of range: %s", j4);
        return s3;
    }

    public static int compare(short s3, short s4) {
        return s3 - s4;
    }

    public static short[] concat(short[]... sArr) {
        int i4 = 0;
        for (short[] sArr2 : sArr) {
            i4 += sArr2.length;
        }
        short[] sArr3 = new short[i4];
        int i5 = 0;
        for (short[] sArr4 : sArr) {
            System.arraycopy(sArr4, 0, sArr3, i5, sArr4.length);
            i5 += sArr4.length;
        }
        return sArr3;
    }

    public static short constrainToRange(short s3, short s4, short s5) {
        boolean z3;
        if (s4 <= s5) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "min (%s) must be less than or equal to max (%s)", (int) s4, (int) s5);
        if (s3 < s4) {
            return s4;
        }
        if (s3 >= s5) {
            return s5;
        }
        return s3;
    }

    public static boolean contains(short[] sArr, short s3) {
        for (short s4 : sArr) {
            if (s4 == s3) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(short[] sArr, short s3, int i4, int i5) {
        for (int i6 = i5 - 1; i6 >= i4; i6--) {
            if (sArr[i6] == s3) {
                return i6;
            }
        }
        return -1;
    }

    public static short[] ensureCapacity(short[] sArr, int i4, int i5) {
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
        if (sArr.length < i4) {
            return Arrays.copyOf(sArr, i4 + i5);
        }
        return sArr;
    }

    @GwtIncompatible
    public static short fromByteArray(byte[] bArr) {
        boolean z3;
        if (bArr.length >= 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "array too small: %s < %s", bArr.length, 2);
        return fromBytes(bArr[0], bArr[1]);
    }

    @GwtIncompatible
    public static short fromBytes(byte b4, byte b5) {
        return (short) ((b4 << 8) | (b5 & 255));
    }

    public static int indexOf(short[] sArr, short s3) {
        return c(sArr, s3, 0, sArr.length);
    }

    public static String join(String str, short... sArr) {
        Preconditions.checkNotNull(str);
        if (sArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(sArr.length * 6);
        sb.append((int) sArr[0]);
        for (int i4 = 1; i4 < sArr.length; i4++) {
            sb.append(str);
            sb.append((int) sArr[i4]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(short[] sArr, short s3) {
        return d(sArr, s3, 0, sArr.length);
    }

    public static Comparator<short[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    @GwtIncompatible("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static short max(short... sArr) {
        boolean z3;
        if (sArr.length > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        short s3 = sArr[0];
        for (int i4 = 1; i4 < sArr.length; i4++) {
            short s4 = sArr[i4];
            if (s4 > s3) {
                s3 = s4;
            }
        }
        return s3;
    }

    @GwtIncompatible("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static short min(short... sArr) {
        boolean z3;
        if (sArr.length > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        short s3 = sArr[0];
        for (int i4 = 1; i4 < sArr.length; i4++) {
            short s4 = sArr[i4];
            if (s4 < s3) {
                s3 = s4;
            }
        }
        return s3;
    }

    public static void reverse(short[] sArr) {
        Preconditions.checkNotNull(sArr);
        reverse(sArr, 0, sArr.length);
    }

    public static void rotate(short[] sArr, int i4) {
        rotate(sArr, i4, 0, sArr.length);
    }

    public static short saturatedCast(long j4) {
        if (j4 > 32767) {
            return ShortCompanionObject.MAX_VALUE;
        }
        if (j4 < -32768) {
            return ShortCompanionObject.MIN_VALUE;
        }
        return (short) j4;
    }

    public static void sortDescending(short[] sArr) {
        Preconditions.checkNotNull(sArr);
        sortDescending(sArr, 0, sArr.length);
    }

    public static Converter<String, Short> stringConverter() {
        return ShortConverter.f28179b;
    }

    public static short[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof ShortArrayAsList) {
            return ((ShortArrayAsList) collection).c();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        short[] sArr = new short[length];
        for (int i4 = 0; i4 < length; i4++) {
            sArr[i4] = ((Number) Preconditions.checkNotNull(array[i4])).shortValue();
        }
        return sArr;
    }

    @GwtIncompatible
    public static byte[] toByteArray(short s3) {
        return new byte[]{(byte) (s3 >> 8), (byte) s3};
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int indexOf(short[] r5, short[] r6) {
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
            short r3 = r5[r3]
            short r4 = r6[r2]
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.Shorts.indexOf(short[], short[]):int");
    }

    public static void rotate(short[] sArr, int i4, int i5, int i6) {
        Preconditions.checkNotNull(sArr);
        Preconditions.checkPositionIndexes(i5, i6, sArr.length);
        if (sArr.length <= 1) {
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
        reverse(sArr, i5, i9);
        reverse(sArr, i9, i6);
        reverse(sArr, i5, i6);
    }

    public static void reverse(short[] sArr, int i4, int i5) {
        Preconditions.checkNotNull(sArr);
        Preconditions.checkPositionIndexes(i4, i5, sArr.length);
        for (int i6 = i5 - 1; i4 < i6; i6--) {
            short s3 = sArr[i4];
            sArr[i4] = sArr[i6];
            sArr[i6] = s3;
            i4++;
        }
    }

    public static void sortDescending(short[] sArr, int i4, int i5) {
        Preconditions.checkNotNull(sArr);
        Preconditions.checkPositionIndexes(i4, i5, sArr.length);
        Arrays.sort(sArr, i4, i5);
        reverse(sArr, i4, i5);
    }

    public static int hashCode(short s3) {
        return s3;
    }
}
