package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
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
import kotlin.jvm.internal.CharCompanionObject;
import net.bytebuddy.pool.TypePool;
import okhttp3.internal.ws.WebSocketProtocol;

@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
/* loaded from: classes5.dex */
public final class Chars {
    public static final int BYTES = 2;

    @GwtCompatible
    /* loaded from: classes5.dex */
    private static class CharArrayAsList extends AbstractList<Character> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final char[] array;
        final int end;
        final int start;

        CharArrayAsList(char[] cArr) {
            this(cArr, 0, cArr.length);
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a */
        public Character get(int i4) {
            Preconditions.checkElementIndex(i4, size());
            return Character.valueOf(this.array[this.start + i4]);
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: b */
        public Character set(int i4, Character ch) {
            Preconditions.checkElementIndex(i4, size());
            char[] cArr = this.array;
            int i5 = this.start;
            char c4 = cArr[i5 + i4];
            cArr[i5 + i4] = ((Character) Preconditions.checkNotNull(ch)).charValue();
            return Character.valueOf(c4);
        }

        char[] c() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object obj) {
            if ((obj instanceof Character) && Chars.c(this.array, ((Character) obj).charValue(), this.start, this.end) != -1) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof CharArrayAsList) {
                CharArrayAsList charArrayAsList = (CharArrayAsList) obj;
                int size = size();
                if (charArrayAsList.size() != size) {
                    return false;
                }
                for (int i4 = 0; i4 < size; i4++) {
                    if (this.array[this.start + i4] != charArrayAsList.array[charArrayAsList.start + i4]) {
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
                i4 = (i4 * 31) + Chars.hashCode(this.array[i5]);
            }
            return i4;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object obj) {
            int c4;
            if ((obj instanceof Character) && (c4 = Chars.c(this.array, ((Character) obj).charValue(), this.start, this.end)) >= 0) {
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
            if ((obj instanceof Character) && (d4 = Chars.d(this.array, ((Character) obj).charValue(), this.start, this.end)) >= 0) {
                return d4 - this.start;
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Character> subList(int i4, int i5) {
            Preconditions.checkPositionIndexes(i4, i5, size());
            if (i4 == i5) {
                return Collections.emptyList();
            }
            char[] cArr = this.array;
            int i6 = this.start;
            return new CharArrayAsList(cArr, i4 + i6, i6 + i5);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 3);
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

        CharArrayAsList(char[] cArr, int i4, int i5) {
            this.array = cArr;
            this.start = i4;
            this.end = i5;
        }
    }

    /* loaded from: classes5.dex */
    private enum LexicographicalComparator implements Comparator<char[]> {
        INSTANCE;

        @Override // java.util.Comparator
        /* renamed from: b */
        public int compare(char[] cArr, char[] cArr2) {
            int min = Math.min(cArr.length, cArr2.length);
            for (int i4 = 0; i4 < min; i4++) {
                int compare = Chars.compare(cArr[i4], cArr2[i4]);
                if (compare != 0) {
                    return compare;
                }
            }
            return cArr.length - cArr2.length;
        }

        @Override // java.lang.Enum
        public String toString() {
            return "Chars.lexicographicalComparator()";
        }
    }

    private Chars() {
    }

    public static List<Character> asList(char... cArr) {
        if (cArr.length == 0) {
            return Collections.emptyList();
        }
        return new CharArrayAsList(cArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int c(char[] cArr, char c4, int i4, int i5) {
        while (i4 < i5) {
            if (cArr[i4] == c4) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    public static char checkedCast(long j4) {
        boolean z3;
        char c4 = (char) j4;
        if (c4 == j4) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Out of range: %s", j4);
        return c4;
    }

    public static int compare(char c4, char c5) {
        return c4 - c5;
    }

    public static char[] concat(char[]... cArr) {
        int i4 = 0;
        for (char[] cArr2 : cArr) {
            i4 += cArr2.length;
        }
        char[] cArr3 = new char[i4];
        int i5 = 0;
        for (char[] cArr4 : cArr) {
            System.arraycopy(cArr4, 0, cArr3, i5, cArr4.length);
            i5 += cArr4.length;
        }
        return cArr3;
    }

    public static char constrainToRange(char c4, char c5, char c6) {
        boolean z3;
        if (c5 <= c6) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "min (%s) must be less than or equal to max (%s)", c5, c6);
        if (c4 < c5) {
            return c5;
        }
        if (c4 >= c6) {
            return c6;
        }
        return c4;
    }

    public static boolean contains(char[] cArr, char c4) {
        for (char c5 : cArr) {
            if (c5 == c4) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(char[] cArr, char c4, int i4, int i5) {
        for (int i6 = i5 - 1; i6 >= i4; i6--) {
            if (cArr[i6] == c4) {
                return i6;
            }
        }
        return -1;
    }

    public static char[] ensureCapacity(char[] cArr, int i4, int i5) {
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
        if (cArr.length < i4) {
            return Arrays.copyOf(cArr, i4 + i5);
        }
        return cArr;
    }

    @GwtIncompatible
    public static char fromByteArray(byte[] bArr) {
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
    public static char fromBytes(byte b4, byte b5) {
        return (char) ((b4 << 8) | (b5 & 255));
    }

    public static int indexOf(char[] cArr, char c4) {
        return c(cArr, c4, 0, cArr.length);
    }

    public static String join(String str, char... cArr) {
        Preconditions.checkNotNull(str);
        int length = cArr.length;
        if (length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder((str.length() * (length - 1)) + length);
        sb.append(cArr[0]);
        for (int i4 = 1; i4 < length; i4++) {
            sb.append(str);
            sb.append(cArr[i4]);
        }
        return sb.toString();
    }

    public static int lastIndexOf(char[] cArr, char c4) {
        return d(cArr, c4, 0, cArr.length);
    }

    public static Comparator<char[]> lexicographicalComparator() {
        return LexicographicalComparator.INSTANCE;
    }

    public static char max(char... cArr) {
        boolean z3;
        if (cArr.length > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        char c4 = cArr[0];
        for (int i4 = 1; i4 < cArr.length; i4++) {
            char c5 = cArr[i4];
            if (c5 > c4) {
                c4 = c5;
            }
        }
        return c4;
    }

    public static char min(char... cArr) {
        boolean z3;
        if (cArr.length > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        char c4 = cArr[0];
        for (int i4 = 1; i4 < cArr.length; i4++) {
            char c5 = cArr[i4];
            if (c5 < c4) {
                c4 = c5;
            }
        }
        return c4;
    }

    public static void reverse(char[] cArr) {
        Preconditions.checkNotNull(cArr);
        reverse(cArr, 0, cArr.length);
    }

    public static void rotate(char[] cArr, int i4) {
        rotate(cArr, i4, 0, cArr.length);
    }

    public static char saturatedCast(long j4) {
        if (j4 > WebSocketProtocol.PAYLOAD_SHORT_MAX) {
            return CharCompanionObject.MAX_VALUE;
        }
        if (j4 < 0) {
            return (char) 0;
        }
        return (char) j4;
    }

    public static void sortDescending(char[] cArr) {
        Preconditions.checkNotNull(cArr);
        sortDescending(cArr, 0, cArr.length);
    }

    public static char[] toArray(Collection<Character> collection) {
        if (collection instanceof CharArrayAsList) {
            return ((CharArrayAsList) collection).c();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        char[] cArr = new char[length];
        for (int i4 = 0; i4 < length; i4++) {
            cArr[i4] = ((Character) Preconditions.checkNotNull(array[i4])).charValue();
        }
        return cArr;
    }

    @GwtIncompatible
    public static byte[] toByteArray(char c4) {
        return new byte[]{(byte) (c4 >> '\b'), (byte) c4};
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int indexOf(char[] r5, char[] r6) {
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
            char r3 = r5[r3]
            char r4 = r6[r2]
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.Chars.indexOf(char[], char[]):int");
    }

    public static void rotate(char[] cArr, int i4, int i5, int i6) {
        Preconditions.checkNotNull(cArr);
        Preconditions.checkPositionIndexes(i5, i6, cArr.length);
        if (cArr.length <= 1) {
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
        reverse(cArr, i5, i9);
        reverse(cArr, i9, i6);
        reverse(cArr, i5, i6);
    }

    public static void reverse(char[] cArr, int i4, int i5) {
        Preconditions.checkNotNull(cArr);
        Preconditions.checkPositionIndexes(i4, i5, cArr.length);
        for (int i6 = i5 - 1; i4 < i6; i6--) {
            char c4 = cArr[i4];
            cArr[i4] = cArr[i6];
            cArr[i6] = c4;
            i4++;
        }
    }

    public static void sortDescending(char[] cArr, int i4, int i5) {
        Preconditions.checkNotNull(cArr);
        Preconditions.checkPositionIndexes(i4, i5, cArr.length);
        Arrays.sort(cArr, i4, i5);
        reverse(cArr, i4, i5);
    }

    public static int hashCode(char c4) {
        return c4;
    }
}
