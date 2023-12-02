package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;
import net.bytebuddy.pool.TypePool;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes5.dex */
public final class Bytes {

    @GwtCompatible
    /* loaded from: classes5.dex */
    private static class ByteArrayAsList extends AbstractList<Byte> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final byte[] array;
        final int end;
        final int start;

        ByteArrayAsList(byte[] bArr) {
            this(bArr, 0, bArr.length);
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a */
        public Byte get(int i4) {
            Preconditions.checkElementIndex(i4, size());
            return Byte.valueOf(this.array[this.start + i4]);
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: b */
        public Byte set(int i4, Byte b4) {
            Preconditions.checkElementIndex(i4, size());
            byte[] bArr = this.array;
            int i5 = this.start;
            byte b5 = bArr[i5 + i4];
            bArr[i5 + i4] = ((Byte) Preconditions.checkNotNull(b4)).byteValue();
            return Byte.valueOf(b5);
        }

        byte[] c() {
            return Arrays.copyOfRange(this.array, this.start, this.end);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object obj) {
            if ((obj instanceof Byte) && Bytes.c(this.array, ((Byte) obj).byteValue(), this.start, this.end) != -1) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (obj instanceof ByteArrayAsList) {
                ByteArrayAsList byteArrayAsList = (ByteArrayAsList) obj;
                int size = size();
                if (byteArrayAsList.size() != size) {
                    return false;
                }
                for (int i4 = 0; i4 < size; i4++) {
                    if (this.array[this.start + i4] != byteArrayAsList.array[byteArrayAsList.start + i4]) {
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
                i4 = (i4 * 31) + Bytes.hashCode(this.array[i5]);
            }
            return i4;
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object obj) {
            int c4;
            if ((obj instanceof Byte) && (c4 = Bytes.c(this.array, ((Byte) obj).byteValue(), this.start, this.end)) >= 0) {
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
            if ((obj instanceof Byte) && (d4 = Bytes.d(this.array, ((Byte) obj).byteValue(), this.start, this.end)) >= 0) {
                return d4 - this.start;
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.end - this.start;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Byte> subList(int i4, int i5) {
            Preconditions.checkPositionIndexes(i4, i5, size());
            if (i4 == i5) {
                return Collections.emptyList();
            }
            byte[] bArr = this.array;
            int i6 = this.start;
            return new ByteArrayAsList(bArr, i4 + i6, i6 + i5);
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 5);
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

        ByteArrayAsList(byte[] bArr, int i4, int i5) {
            this.array = bArr;
            this.start = i4;
            this.end = i5;
        }
    }

    private Bytes() {
    }

    public static List<Byte> asList(byte... bArr) {
        if (bArr.length == 0) {
            return Collections.emptyList();
        }
        return new ByteArrayAsList(bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int c(byte[] bArr, byte b4, int i4, int i5) {
        while (i4 < i5) {
            if (bArr[i4] == b4) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    public static byte[] concat(byte[]... bArr) {
        int i4 = 0;
        for (byte[] bArr2 : bArr) {
            i4 += bArr2.length;
        }
        byte[] bArr3 = new byte[i4];
        int i5 = 0;
        for (byte[] bArr4 : bArr) {
            System.arraycopy(bArr4, 0, bArr3, i5, bArr4.length);
            i5 += bArr4.length;
        }
        return bArr3;
    }

    public static boolean contains(byte[] bArr, byte b4) {
        for (byte b5 : bArr) {
            if (b5 == b4) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int d(byte[] bArr, byte b4, int i4, int i5) {
        for (int i6 = i5 - 1; i6 >= i4; i6--) {
            if (bArr[i6] == b4) {
                return i6;
            }
        }
        return -1;
    }

    public static byte[] ensureCapacity(byte[] bArr, int i4, int i5) {
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
        if (bArr.length < i4) {
            return Arrays.copyOf(bArr, i4 + i5);
        }
        return bArr;
    }

    public static int indexOf(byte[] bArr, byte b4) {
        return c(bArr, b4, 0, bArr.length);
    }

    public static int lastIndexOf(byte[] bArr, byte b4) {
        return d(bArr, b4, 0, bArr.length);
    }

    public static void reverse(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        reverse(bArr, 0, bArr.length);
    }

    public static void rotate(byte[] bArr, int i4) {
        rotate(bArr, i4, 0, bArr.length);
    }

    public static byte[] toArray(Collection<? extends Number> collection) {
        if (collection instanceof ByteArrayAsList) {
            return ((ByteArrayAsList) collection).c();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        byte[] bArr = new byte[length];
        for (int i4 = 0; i4 < length; i4++) {
            bArr[i4] = ((Number) Preconditions.checkNotNull(array[i4])).byteValue();
        }
        return bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r0 = r0 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int indexOf(byte[] r5, byte[] r6) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.primitives.Bytes.indexOf(byte[], byte[]):int");
    }

    public static void rotate(byte[] bArr, int i4, int i5, int i6) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkPositionIndexes(i5, i6, bArr.length);
        if (bArr.length <= 1) {
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
        reverse(bArr, i5, i9);
        reverse(bArr, i9, i6);
        reverse(bArr, i5, i6);
    }

    public static void reverse(byte[] bArr, int i4, int i5) {
        Preconditions.checkNotNull(bArr);
        Preconditions.checkPositionIndexes(i4, i5, bArr.length);
        for (int i6 = i5 - 1; i4 < i6; i6--) {
            byte b4 = bArr[i4];
            bArr[i4] = bArr[i6];
            bArr[i6] = b4;
            i4++;
        }
    }

    public static int hashCode(byte b4) {
        return b4;
    }
}
