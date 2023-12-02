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
public final class ImmutableIntArray implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    private static final ImmutableIntArray f28158b = new ImmutableIntArray(new int[0]);

    /* renamed from: a  reason: collision with root package name */
    private final transient int f28159a;
    private final int[] array;
    private final int end;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class AsList extends AbstractList<Integer> implements RandomAccess, Serializable {
        private final ImmutableIntArray parent;

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a */
        public Integer get(int i4) {
            return Integer.valueOf(this.parent.get(i4));
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
                int i4 = this.parent.f28159a;
                for (Object obj2 : list) {
                    if (obj2 instanceof Integer) {
                        int i5 = i4 + 1;
                        if (this.parent.array[i4] == ((Integer) obj2).intValue()) {
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
            if (obj instanceof Integer) {
                return this.parent.indexOf(((Integer) obj).intValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(@CheckForNull Object obj) {
            if (obj instanceof Integer) {
                return this.parent.lastIndexOf(((Integer) obj).intValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Integer> subList(int i4, int i5) {
            return this.parent.subArray(i4, i5).asList();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.parent.toString();
        }

        private AsList(ImmutableIntArray immutableIntArray) {
            this.parent = immutableIntArray;
        }
    }

    public static Builder builder(int i4) {
        Preconditions.checkArgument(i4 >= 0, "Invalid initialCapacity: %s", i4);
        return new Builder(i4);
    }

    public static ImmutableIntArray copyOf(int[] iArr) {
        return iArr.length == 0 ? f28158b : new ImmutableIntArray(Arrays.copyOf(iArr, iArr.length));
    }

    private boolean e() {
        if (this.f28159a <= 0 && this.end >= this.array.length) {
            return false;
        }
        return true;
    }

    public static ImmutableIntArray of() {
        return f28158b;
    }

    public List<Integer> asList() {
        return new AsList();
    }

    public boolean contains(int i4) {
        if (indexOf(i4) >= 0) {
            return true;
        }
        return false;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableIntArray)) {
            return false;
        }
        ImmutableIntArray immutableIntArray = (ImmutableIntArray) obj;
        if (length() != immutableIntArray.length()) {
            return false;
        }
        for (int i4 = 0; i4 < length(); i4++) {
            if (get(i4) != immutableIntArray.get(i4)) {
                return false;
            }
        }
        return true;
    }

    public int get(int i4) {
        Preconditions.checkElementIndex(i4, length());
        return this.array[this.f28159a + i4];
    }

    public int hashCode() {
        int i4 = 1;
        for (int i5 = this.f28159a; i5 < this.end; i5++) {
            i4 = (i4 * 31) + Ints.hashCode(this.array[i5]);
        }
        return i4;
    }

    public int indexOf(int i4) {
        for (int i5 = this.f28159a; i5 < this.end; i5++) {
            if (this.array[i5] == i4) {
                return i5 - this.f28159a;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        if (this.end == this.f28159a) {
            return true;
        }
        return false;
    }

    public int lastIndexOf(int i4) {
        int i5 = this.end;
        while (true) {
            i5--;
            int i6 = this.f28159a;
            if (i5 >= i6) {
                if (this.array[i5] == i4) {
                    return i5 - i6;
                }
            } else {
                return -1;
            }
        }
    }

    public int length() {
        return this.end - this.f28159a;
    }

    Object readResolve() {
        if (isEmpty()) {
            return f28158b;
        }
        return this;
    }

    public ImmutableIntArray subArray(int i4, int i5) {
        Preconditions.checkPositionIndexes(i4, i5, length());
        if (i4 == i5) {
            return f28158b;
        }
        int[] iArr = this.array;
        int i6 = this.f28159a;
        return new ImmutableIntArray(iArr, i4 + i6, i6 + i5);
    }

    public int[] toArray() {
        return Arrays.copyOfRange(this.array, this.f28159a, this.end);
    }

    public String toString() {
        if (isEmpty()) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder(length() * 5);
        sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
        sb.append(this.array[this.f28159a]);
        int i4 = this.f28159a;
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

    public ImmutableIntArray trimmed() {
        if (e()) {
            return new ImmutableIntArray(toArray());
        }
        return this;
    }

    Object writeReplace() {
        return trimmed();
    }

    private ImmutableIntArray(int[] iArr) {
        this(iArr, 0, iArr.length);
    }

    public static ImmutableIntArray copyOf(Collection<Integer> collection) {
        return collection.isEmpty() ? f28158b : new ImmutableIntArray(Ints.toArray(collection));
    }

    public static ImmutableIntArray of(int i4) {
        return new ImmutableIntArray(new int[]{i4});
    }

    /* loaded from: classes5.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private int[] f28160a;

        /* renamed from: b  reason: collision with root package name */
        private int f28161b = 0;

        Builder(int i4) {
            this.f28160a = new int[i4];
        }

        private void a(int i4) {
            int i5 = this.f28161b + i4;
            int[] iArr = this.f28160a;
            if (i5 > iArr.length) {
                this.f28160a = Arrays.copyOf(iArr, b(iArr.length, i5));
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
        public Builder add(int i4) {
            a(1);
            int[] iArr = this.f28160a;
            int i5 = this.f28161b;
            iArr[i5] = i4;
            this.f28161b = i5 + 1;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addAll(int[] iArr) {
            a(iArr.length);
            System.arraycopy(iArr, 0, this.f28160a, this.f28161b, iArr.length);
            this.f28161b += iArr.length;
            return this;
        }

        public ImmutableIntArray build() {
            if (this.f28161b == 0) {
                return ImmutableIntArray.f28158b;
            }
            return new ImmutableIntArray(this.f28160a, 0, this.f28161b);
        }

        @CanIgnoreReturnValue
        public Builder addAll(Iterable<Integer> iterable) {
            if (iterable instanceof Collection) {
                return addAll((Collection) iterable);
            }
            for (Integer num : iterable) {
                add(num.intValue());
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addAll(Collection<Integer> collection) {
            a(collection.size());
            for (Integer num : collection) {
                int[] iArr = this.f28160a;
                int i4 = this.f28161b;
                this.f28161b = i4 + 1;
                iArr[i4] = num.intValue();
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addAll(ImmutableIntArray immutableIntArray) {
            a(immutableIntArray.length());
            System.arraycopy(immutableIntArray.array, immutableIntArray.f28159a, this.f28160a, this.f28161b, immutableIntArray.length());
            this.f28161b += immutableIntArray.length();
            return this;
        }
    }

    private ImmutableIntArray(int[] iArr, int i4, int i5) {
        this.array = iArr;
        this.f28159a = i4;
        this.end = i5;
    }

    public static Builder builder() {
        return new Builder(10);
    }

    public static ImmutableIntArray copyOf(Iterable<Integer> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection<Integer>) iterable);
        }
        return builder().addAll(iterable).build();
    }

    public static ImmutableIntArray of(int i4, int i5) {
        return new ImmutableIntArray(new int[]{i4, i5});
    }

    public static ImmutableIntArray of(int i4, int i5, int i6) {
        return new ImmutableIntArray(new int[]{i4, i5, i6});
    }

    public static ImmutableIntArray of(int i4, int i5, int i6, int i7) {
        return new ImmutableIntArray(new int[]{i4, i5, i6, i7});
    }

    public static ImmutableIntArray of(int i4, int i5, int i6, int i7, int i8) {
        return new ImmutableIntArray(new int[]{i4, i5, i6, i7, i8});
    }

    public static ImmutableIntArray of(int i4, int i5, int i6, int i7, int i8, int i9) {
        return new ImmutableIntArray(new int[]{i4, i5, i6, i7, i8, i9});
    }

    public static ImmutableIntArray of(int i4, int... iArr) {
        Preconditions.checkArgument(iArr.length <= 2147483646, "the total number of elements must fit in an int");
        int[] iArr2 = new int[iArr.length + 1];
        iArr2[0] = i4;
        System.arraycopy(iArr, 0, iArr2, 1, iArr.length);
        return new ImmutableIntArray(iArr2);
    }
}
