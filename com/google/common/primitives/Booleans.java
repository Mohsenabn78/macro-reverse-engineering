package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
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

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes5.dex */
public final class Booleans {

    @GwtCompatible
    /* loaded from: classes5.dex */
    private static class BooleanArrayAsList extends AbstractList<Boolean> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final boolean[] array;
        final int end;
        final int start;

        BooleanArrayAsList(boolean[] zArr) {
            this(zArr, 0, zArr.length);
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a */
        public Boolean get(int i4) {
            Preconditions.checkElementIndex(i4, size());
            return Boolean.valueOf(this.array[this.start + i4]);
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: b */
        public Boolean set(int i4, Boolean bool) {
            Preconditions.checkElementIndex(i4, size());
            boolean[] zArr = this.array;
            int i5 = this.start;
            boolean z3 = zArr[i5 + i4];
            zArr[i5 + i4] = ((Boolean) Preconditions.checkNotNull(bool)).booleanValue();
            return Boolean.valueOf(z3);
        }

        boolean[] c() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object obj) {
            if ((obj instanceof Boolean) && Booleans.c(this.array, ((Boolean) obj).booleanValue(), this.start, this.end) != -1) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof BooleanArrayAsList) {
                BooleanArrayAsList booleanArrayAsList = (BooleanArrayAsList) obj;
                int size = size();
                if (booleanArrayAsList.size() != size) {
                    return false;
                }
                for (int i4 = 0; i4 < size; i4++) {
                    if (this.array[this.start + i4] != booleanArrayAsList.array[booleanArrayAsList.start + i4]) {
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
                i4 = (i4 * 31) + Booleans.hashCode(this.array[i5]);
            }
            return i4;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object obj) {
            int c4;
            if ((obj instanceof Boolean) && (c4 = Booleans.c(this.array, ((Boolean) obj).booleanValue(), this.start, this.end)) >= 0) {
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
            if ((obj instanceof Boolean) && (d4 = Booleans.d(this.array, ((Boolean) obj).booleanValue(), this.start, this.end)) >= 0) {
                return d4 - this.start;
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Boolean> subList(int i4, int i5) {
            Preconditions.checkPositionIndexes(i4, i5, size());
            if (i4 == i5) {
                return Collections.emptyList();
            }
            boolean[] zArr = this.array;
            int i6 = this.start;
            return new BooleanArrayAsList(zArr, i4 + i6, i6 + i5);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            String str;
            String str2;
            StringBuilder sb = new StringBuilder(size() * 7);
            if (this.array[this.start]) {
                str = "[true";
            } else {
                str = "[false";
            }
            sb.append(str);
            int i4 = this.start;
            while (true) {
                i4++;
                if (i4 < this.end) {
                    if (this.array[i4]) {
                        str2 = ", true";
                    } else {
                        str2 = ", false";
                    }
                    sb.append(str2);
                } else {
                    sb.append(']');
                    return sb.toString();
                }
            }
        }

        BooleanArrayAsList(boolean[] zArr, int i4, int i5) {
            this.array = zArr;
            this.start = i4;
            this.end = i5;
        }
    }

    /* loaded from: classes5.dex */
    private enum BooleanComparator implements Comparator<Boolean> {
        TRUE_FIRST(1, "Booleans.trueFirst()"),
        FALSE_FIRST(-1, "Booleans.falseFirst()");
        
        private final String toString;
        private final int trueValue;

        BooleanComparator(int i4, String str) {
            this.trueValue = i4;
            this.toString = str;
        }

        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(Boolean bool, Boolean bool2) {
            int i4;
            int i5 = 0;
            if (bool.booleanValue()) {
                i4 = this.trueValue;
            } else {
                i4 = 0;
            }
            if (bool2.booleanValue()) {
                i5 = this.trueValue;
            }
            return i5 - i4;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.toString;
        }
    }

    /* loaded from: classes5.dex */
    private enum LexicographicalComparator implements Comparator<boolean[]> {
        INSTANCE;

        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(boolean[] zArr, boolean[] zArr2) {
            int min = Math.min(zArr.length, zArr2.length);
            for (int i4 = 0; i4 < min; i4++) {
                int compare = Booleans.compare(zArr[i4], zArr2[i4]);
                if (compare != 0) {
                    return compare;
                }
            }
            return zArr.length - zArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Booleans.lexicographicalComparator()";
        }
    }

    private Booleans() {
    }

    public static List<Boolean> asList(boolean... zArr) {
        if (zArr.length == 0) {
            return Collections.emptyList();
        }
        return new BooleanArrayAsList(zArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int c(boolean[] zArr, boolean z3, int i4, int i5) {
        while (i4 < i5) {
            if (zArr[i4] == z3) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    public static int compare(boolean z3, boolean z4) {
        if (z3 == z4) {
            return 0;
        }
        if (z3) {
            return 1;
        }
        return -1;
    }

    public static boolean[] concat(boolean[]... zArr) {
        int i4 = 0;
        for (boolean[] zArr2 : zArr) {
            i4 += zArr2.length;
        }
        boolean[] zArr3 = new boolean[i4];
        int i5 = 0;
        for (boolean[] zArr4 : zArr) {
            System.arraycopy(zArr4, 0, zArr3, i5, zArr4.length);
            i5 += zArr4.length;
        }
        return zArr3;
    }

    public static boolean contains(boolean[] zArr, boolean z3) {
        for (boolean z4 : zArr) {
            if (z4 == z3) {
                return true;
            }
        }
        return false;
    }

    public static int countTrue(boolean... zArr) {
        int i4 = 0;
        for (boolean z3 : zArr) {
            if (z3) {
                i4++;
            }
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(boolean[] zArr, boolean z3, int i4, int i5) {
        for (int i6 = i5 - 1; i6 >= i4; i6--) {
            if (zArr[i6] == z3) {
                return i6;
            }
        }
        return -1;
    }

    public static boolean[] ensureCapacity(boolean[] zArr, int i4, int i5) {
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
        if (zArr.length < i4) {
            return Arrays.copyOf(zArr, i4 + i5);
        }
        return zArr;
    }

    public static Comparator<Boolean> falseFirst() {
        return BooleanComparator.FALSE_FIRST;
    }

    public static int hashCode(boolean z3) {
        if (z3) {
            return 1231;
        }
        return 1237;
    }

    public static int indexOf(boolean[] zArr, boolean z3) {
        return c(zArr, z3, 0, zArr.length);
    }

    public static String join(String str, boolean... zArr) {
        Preconditions.checkNotNull(str);
        if (zArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(zArr.length * 7);
        sb.append(zArr[0]);
        for (int i4 = 1; i4 < zArr.length; i4++) {
            sb.append(str);
            sb.append(zArr[i4]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(boolean[] zArr, boolean z3) {
        return d(zArr, z3, 0, zArr.length);
    }

    public static Comparator<boolean[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static void reverse(boolean[] zArr) {
        Preconditions.checkNotNull(zArr);
        reverse(zArr, 0, zArr.length);
    }

    public static void rotate(boolean[] zArr, int i4) {
        rotate(zArr, i4, 0, zArr.length);
    }

    public static boolean[] toArray(Collection<Boolean> collection) {
        if (collection instanceof BooleanArrayAsList) {
            return ((BooleanArrayAsList) collection).c();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        boolean[] zArr = new boolean[length];
        for (int i4 = 0; i4 < length; i4++) {
            zArr[i4] = ((Boolean) Preconditions.checkNotNull(array[i4])).booleanValue();
        }
        return zArr;
    }

    public static Comparator<Boolean> trueFirst() {
        return BooleanComparator.TRUE_FIRST;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int indexOf(boolean[] r5, boolean[] r6) {
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
            boolean r3 = r5[r3]
            boolean r4 = r6[r2]
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.Booleans.indexOf(boolean[], boolean[]):int");
    }

    public static void rotate(boolean[] zArr, int i4, int i5, int i6) {
        Preconditions.checkNotNull(zArr);
        Preconditions.checkPositionIndexes(i5, i6, zArr.length);
        if (zArr.length <= 1) {
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
        reverse(zArr, i5, i9);
        reverse(zArr, i9, i6);
        reverse(zArr, i5, i6);
    }

    public static void reverse(boolean[] zArr, int i4, int i5) {
        Preconditions.checkNotNull(zArr);
        Preconditions.checkPositionIndexes(i4, i5, zArr.length);
        for (int i6 = i5 - 1; i4 < i6; i6--) {
            boolean z3 = zArr[i4];
            zArr[i4] = zArr[i6];
            zArr[i6] = z3;
            i4++;
        }
    }
}
