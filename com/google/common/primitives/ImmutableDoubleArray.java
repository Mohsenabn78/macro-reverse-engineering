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
public final class ImmutableDoubleArray implements Serializable {

    /* renamed from: b  reason: collision with root package name */
    private static final ImmutableDoubleArray f28154b = new ImmutableDoubleArray(new double[0]);

    /* renamed from: a  reason: collision with root package name */
    private final transient int f28155a;
    private final double[] array;
    private final int end;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class AsList extends AbstractList<Double> implements RandomAccess, Serializable {
        private final ImmutableDoubleArray parent;

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a */
        public Double get(int i4) {
            return Double.valueOf(this.parent.get(i4));
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
                int i4 = this.parent.f28155a;
                for (Object obj2 : list) {
                    if (obj2 instanceof Double) {
                        int i5 = i4 + 1;
                        if (ImmutableDoubleArray.f(this.parent.array[i4], ((Double) obj2).doubleValue())) {
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
            if (obj instanceof Double) {
                return this.parent.indexOf(((Double) obj).doubleValue());
            }
            return -1;
        }

        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(@CheckForNull Object obj) {
            if (obj instanceof Double) {
                return this.parent.lastIndexOf(((Double) obj).doubleValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<Double> subList(int i4, int i5) {
            return this.parent.subArray(i4, i5).asList();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return this.parent.toString();
        }

        private AsList(ImmutableDoubleArray immutableDoubleArray) {
            this.parent = immutableDoubleArray;
        }
    }

    public static Builder builder(int i4) {
        Preconditions.checkArgument(i4 >= 0, "Invalid initialCapacity: %s", i4);
        return new Builder(i4);
    }

    public static ImmutableDoubleArray copyOf(double[] dArr) {
        if (dArr.length == 0) {
            return f28154b;
        }
        return new ImmutableDoubleArray(Arrays.copyOf(dArr, dArr.length));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean f(double d4, double d5) {
        if (Double.doubleToLongBits(d4) == Double.doubleToLongBits(d5)) {
            return true;
        }
        return false;
    }

    private boolean g() {
        if (this.f28155a <= 0 && this.end >= this.array.length) {
            return false;
        }
        return true;
    }

    public static ImmutableDoubleArray of() {
        return f28154b;
    }

    public List<Double> asList() {
        return new AsList();
    }

    public boolean contains(double d4) {
        if (indexOf(d4) >= 0) {
            return true;
        }
        return false;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableDoubleArray)) {
            return false;
        }
        ImmutableDoubleArray immutableDoubleArray = (ImmutableDoubleArray) obj;
        if (length() != immutableDoubleArray.length()) {
            return false;
        }
        for (int i4 = 0; i4 < length(); i4++) {
            if (!f(get(i4), immutableDoubleArray.get(i4))) {
                return false;
            }
        }
        return true;
    }

    public double get(int i4) {
        Preconditions.checkElementIndex(i4, length());
        return this.array[this.f28155a + i4];
    }

    public int hashCode() {
        int i4 = 1;
        for (int i5 = this.f28155a; i5 < this.end; i5++) {
            i4 = (i4 * 31) + Doubles.hashCode(this.array[i5]);
        }
        return i4;
    }

    public int indexOf(double d4) {
        for (int i4 = this.f28155a; i4 < this.end; i4++) {
            if (f(this.array[i4], d4)) {
                return i4 - this.f28155a;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        if (this.end == this.f28155a) {
            return true;
        }
        return false;
    }

    public int lastIndexOf(double d4) {
        int i4 = this.end;
        while (true) {
            i4--;
            if (i4 >= this.f28155a) {
                if (f(this.array[i4], d4)) {
                    return i4 - this.f28155a;
                }
            } else {
                return -1;
            }
        }
    }

    public int length() {
        return this.end - this.f28155a;
    }

    Object readResolve() {
        if (isEmpty()) {
            return f28154b;
        }
        return this;
    }

    public ImmutableDoubleArray subArray(int i4, int i5) {
        Preconditions.checkPositionIndexes(i4, i5, length());
        if (i4 == i5) {
            return f28154b;
        }
        double[] dArr = this.array;
        int i6 = this.f28155a;
        return new ImmutableDoubleArray(dArr, i4 + i6, i6 + i5);
    }

    public double[] toArray() {
        return Arrays.copyOfRange(this.array, this.f28155a, this.end);
    }

    public String toString() {
        if (isEmpty()) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder(length() * 5);
        sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
        sb.append(this.array[this.f28155a]);
        int i4 = this.f28155a;
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

    public ImmutableDoubleArray trimmed() {
        if (g()) {
            return new ImmutableDoubleArray(toArray());
        }
        return this;
    }

    Object writeReplace() {
        return trimmed();
    }

    private ImmutableDoubleArray(double[] dArr) {
        this(dArr, 0, dArr.length);
    }

    public static ImmutableDoubleArray of(double d4) {
        return new ImmutableDoubleArray(new double[]{d4});
    }

    /* loaded from: classes5.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private double[] f28156a;

        /* renamed from: b  reason: collision with root package name */
        private int f28157b = 0;

        Builder(int i4) {
            this.f28156a = new double[i4];
        }

        private void a(int i4) {
            int i5 = this.f28157b + i4;
            double[] dArr = this.f28156a;
            if (i5 > dArr.length) {
                this.f28156a = Arrays.copyOf(dArr, b(dArr.length, i5));
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
        public Builder add(double d4) {
            a(1);
            double[] dArr = this.f28156a;
            int i4 = this.f28157b;
            dArr[i4] = d4;
            this.f28157b = i4 + 1;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addAll(double[] dArr) {
            a(dArr.length);
            System.arraycopy(dArr, 0, this.f28156a, this.f28157b, dArr.length);
            this.f28157b += dArr.length;
            return this;
        }

        public ImmutableDoubleArray build() {
            if (this.f28157b == 0) {
                return ImmutableDoubleArray.f28154b;
            }
            return new ImmutableDoubleArray(this.f28156a, 0, this.f28157b);
        }

        @CanIgnoreReturnValue
        public Builder addAll(Iterable<Double> iterable) {
            if (iterable instanceof Collection) {
                return addAll((Collection) iterable);
            }
            for (Double d4 : iterable) {
                add(d4.doubleValue());
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addAll(Collection<Double> collection) {
            a(collection.size());
            for (Double d4 : collection) {
                double[] dArr = this.f28156a;
                int i4 = this.f28157b;
                this.f28157b = i4 + 1;
                dArr[i4] = d4.doubleValue();
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder addAll(ImmutableDoubleArray immutableDoubleArray) {
            a(immutableDoubleArray.length());
            System.arraycopy(immutableDoubleArray.array, immutableDoubleArray.f28155a, this.f28156a, this.f28157b, immutableDoubleArray.length());
            this.f28157b += immutableDoubleArray.length();
            return this;
        }
    }

    private ImmutableDoubleArray(double[] dArr, int i4, int i5) {
        this.array = dArr;
        this.f28155a = i4;
        this.end = i5;
    }

    public static Builder builder() {
        return new Builder(10);
    }

    public static ImmutableDoubleArray of(double d4, double d5) {
        return new ImmutableDoubleArray(new double[]{d4, d5});
    }

    public static ImmutableDoubleArray copyOf(Collection<Double> collection) {
        return collection.isEmpty() ? f28154b : new ImmutableDoubleArray(Doubles.toArray(collection));
    }

    public static ImmutableDoubleArray of(double d4, double d5, double d6) {
        return new ImmutableDoubleArray(new double[]{d4, d5, d6});
    }

    public static ImmutableDoubleArray copyOf(Iterable<Double> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection<Double>) iterable);
        }
        return builder().addAll(iterable).build();
    }

    public static ImmutableDoubleArray of(double d4, double d5, double d6, double d7) {
        return new ImmutableDoubleArray(new double[]{d4, d5, d6, d7});
    }

    public static ImmutableDoubleArray of(double d4, double d5, double d6, double d7, double d8) {
        return new ImmutableDoubleArray(new double[]{d4, d5, d6, d7, d8});
    }

    public static ImmutableDoubleArray of(double d4, double d5, double d6, double d7, double d8, double d9) {
        return new ImmutableDoubleArray(new double[]{d4, d5, d6, d7, d8, d9});
    }

    public static ImmutableDoubleArray of(double d4, double... dArr) {
        Preconditions.checkArgument(dArr.length <= 2147483646, "the total number of elements must fit in an int");
        double[] dArr2 = new double[dArr.length + 1];
        dArr2[0] = d4;
        System.arraycopy(dArr, 0, dArr2, 1, dArr.length);
        return new ImmutableDoubleArray(dArr2);
    }
}
