package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;
import net.bytebuddy.pool.TypePool;
import okhttp3.HttpUrl;

@ElementTypesAreNonnullByDefault
@Immutable
@GwtCompatible
/* loaded from: classes5.dex */
public final class ImmutableLongArray implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    private static final ImmutableLongArray f28162b = new ImmutableLongArray(new long[0]);

    /* renamed from: a  reason: collision with root package name */
    private final transient int f28163a;
    private final long[] array;
    private final int end;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class AsList extends AbstractList<Long> implements RandomAccess, Serializable {
        private final ImmutableLongArray parent;

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a */
        public Long get(int i4) {
            return Long.valueOf(this.parent.get(i4));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object obj) {
            if (indexOf(obj) >= 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof AsList) {
                return this.parent.equals(((AsList) obj).parent);
            }
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            if (size() == list.size()) {
                int i4 = this.parent.f28163a;
                for (Object obj2 : list) {
                    if (obj2 instanceof Long) {
                        int i5 = i4 + 1;
                        if (this.parent.array[i4] == ((Long) obj2).longValue()) {
                            i4 = i5;
                        }
                    }
                    return false;
                }
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.parent.hashCode();
        }

        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object obj) {
            if (obj instanceof Long) {
                return this.parent.indexOf(((Long) obj).longValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(@CheckForNull Object obj) {
            if (obj instanceof Long) {
                return this.parent.lastIndexOf(((Long) obj).longValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Long> subList(int i4, int i5) {
            return this.parent.subArray(i4, i5).asList();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.parent.toString();
        }

        private AsList(ImmutableLongArray immutableLongArray) {
            this.parent = immutableLongArray;
        }
    }

    public static Builder builder(int i4) {
        Preconditions.checkArgument(i4 >= 0, "Invalid initialCapacity: %s", i4);
        return new Builder(i4);
    }

    public static ImmutableLongArray copyOf(long[] jArr) {
        if (jArr.length == 0) {
            return f28162b;
        }
        return new ImmutableLongArray(Arrays.copyOf(jArr, jArr.length));
    }

    private boolean e() {
        if (this.f28163a <= 0 && this.end >= this.array.length) {
            return false;
        }
        return true;
    }

    public static ImmutableLongArray of() {
        return f28162b;
    }

    public List<Long> asList() {
        return new AsList();
    }

    public boolean contains(long j4) {
        if (indexOf(j4) >= 0) {
            return true;
        }
        return false;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableLongArray)) {
            return false;
        }
        ImmutableLongArray immutableLongArray = (ImmutableLongArray) obj;
        if (length() != immutableLongArray.length()) {
            return false;
        }
        for (int i4 = 0; i4 < length(); i4++) {
            if (get(i4) != immutableLongArray.get(i4)) {
                return false;
            }
        }
        return true;
    }

    public long get(int i4) {
        Preconditions.checkElementIndex(i4, length());
        return this.array[this.f28163a + i4];
    }

    public int hashCode() {
        int i4 = 1;
        for (int i5 = this.f28163a; i5 < this.end; i5++) {
            i4 = (i4 * 31) + Longs.hashCode(this.array[i5]);
        }
        return i4;
    }

    public int indexOf(long j4) {
        for (int i4 = this.f28163a; i4 < this.end; i4++) {
            if (this.array[i4] == j4) {
                return i4 - this.f28163a;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        if (this.end == this.f28163a) {
            return true;
        }
        return false;
    }

    public int lastIndexOf(long j4) {
        int i4 = this.end;
        while (true) {
            i4--;
            int i5 = this.f28163a;
            if (i4 >= i5) {
                if (this.array[i4] == j4) {
                    return i4 - i5;
                }
            } else {
                return -1;
            }
        }
    }

    public int length() {
        return this.end - this.f28163a;
    }

    Object readResolve() {
        if (isEmpty()) {
            return f28162b;
        }
        return this;
    }

    public ImmutableLongArray subArray(int i4, int i5) {
        Preconditions.checkPositionIndexes(i4, i5, length());
        if (i4 == i5) {
            return f28162b;
        }
        long[] jArr = this.array;
        int i6 = this.f28163a;
        return new ImmutableLongArray(jArr, i4 + i6, i6 + i5);
    }

    public long[] toArray() {
        return Arrays.copyOfRange(this.array, this.f28163a, this.end);
    }

    public String toString() {
        if (isEmpty()) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder(length() * 5);
        sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
        sb.append(this.array[this.f28163a]);
        int i4 = this.f28163a;
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

    public ImmutableLongArray trimmed() {
        if (e()) {
            return new ImmutableLongArray(toArray());
        }
        return this;
    }

    Object writeReplace() {
        return trimmed();
    }

    private ImmutableLongArray(long[] jArr) {
        this(jArr, 0, jArr.length);
    }

    public static ImmutableLongArray of(long j4) {
        return new ImmutableLongArray(new long[]{j4});
    }

    /* loaded from: classes5.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private long[] f28164a;

        /* renamed from: b  reason: collision with root package name */
        private int f28165b = 0;

        Builder(int i4) {
            this.f28164a = new long[i4];
        }

        private void a(int i4) {
            int i5 = this.f28165b + i4;
            long[] jArr = this.f28164a;
            if (i5 > jArr.length) {
                this.f28164a = Arrays.copyOf(jArr, b(jArr.length, i5));
            }
        }

        private static int b(int i4, int i5) {
            if (i5 >= 0) {
                int i6 = i4 + (i4 >> 1) + 1;
                if (i6 < i5) {
                    i6 = Integer.highestOneBit(i5 - 1) << 1;
                }
                if (i6 < 0) {
                    return Integer.MAX_VALUE;
                }
                return i6;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }

        @CanIgnoreReturnValue
        public Builder add(long j4) {
            a(1);
            long[] jArr = this.f28164a;
            int i4 = this.f28165b;
            jArr[i4] = j4;
            this.f28165b = i4 + 1;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addAll(long[] jArr) {
            a(jArr.length);
            System.arraycopy(jArr, 0, this.f28164a, this.f28165b, jArr.length);
            this.f28165b += jArr.length;
            return this;
        }

        public ImmutableLongArray build() {
            if (this.f28165b == 0) {
                return ImmutableLongArray.f28162b;
            }
            return new ImmutableLongArray(this.f28164a, 0, this.f28165b);
        }

        @CanIgnoreReturnValue
        public Builder addAll(Iterable<Long> iterable) {
            if (iterable instanceof Collection) {
                return addAll((Collection) iterable);
            }
            for (Long l4 : iterable) {
                add(l4.longValue());
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addAll(Collection<Long> collection) {
            a(collection.size());
            for (Long l4 : collection) {
                long[] jArr = this.f28164a;
                int i4 = this.f28165b;
                this.f28165b = i4 + 1;
                jArr[i4] = l4.longValue();
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addAll(ImmutableLongArray immutableLongArray) {
            a(immutableLongArray.length());
            System.arraycopy(immutableLongArray.array, immutableLongArray.f28163a, this.f28164a, this.f28165b, immutableLongArray.length());
            this.f28165b += immutableLongArray.length();
            return this;
        }
    }

    private ImmutableLongArray(long[] jArr, int i4, int i5) {
        this.array = jArr;
        this.f28163a = i4;
        this.end = i5;
    }

    public static Builder builder() {
        return new Builder(10);
    }

    public static ImmutableLongArray of(long j4, long j5) {
        return new ImmutableLongArray(new long[]{j4, j5});
    }

    public static ImmutableLongArray copyOf(Collection<Long> collection) {
        return collection.isEmpty() ? f28162b : new ImmutableLongArray(Longs.toArray(collection));
    }

    public static ImmutableLongArray of(long j4, long j5, long j6) {
        return new ImmutableLongArray(new long[]{j4, j5, j6});
    }

    public static ImmutableLongArray copyOf(Iterable<Long> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection<Long>) iterable);
        }
        return builder().addAll(iterable).build();
    }

    public static ImmutableLongArray of(long j4, long j5, long j6, long j7) {
        return new ImmutableLongArray(new long[]{j4, j5, j6, j7});
    }

    public static ImmutableLongArray of(long j4, long j5, long j6, long j7, long j8) {
        return new ImmutableLongArray(new long[]{j4, j5, j6, j7, j8});
    }

    public static ImmutableLongArray of(long j4, long j5, long j6, long j7, long j8, long j9) {
        return new ImmutableLongArray(new long[]{j4, j5, j6, j7, j8, j9});
    }

    public static ImmutableLongArray of(long j4, long... jArr) {
        Preconditions.checkArgument(jArr.length <= 2147483646, "the total number of elements must fit in an int");
        long[] jArr2 = new long[jArr.length + 1];
        jArr2[0] = j4;
        System.arraycopy(jArr, 0, jArr2, 1, jArr.length);
        return new ImmutableLongArray(jArr2);
    }
}
