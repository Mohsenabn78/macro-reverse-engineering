package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    @RetainedWith
    @CheckForNull
    @LazyInit

    /* renamed from: b  reason: collision with root package name */
    private transient ImmutableList<E> f26951b;

    /* loaded from: classes5.dex */
    public static class Builder<E> extends ImmutableCollection.ArrayBasedBuilder<E> {
        @VisibleForTesting
        @CheckForNull

        /* renamed from: d  reason: collision with root package name */
        Object[] f26952d;

        /* renamed from: e  reason: collision with root package name */
        private int f26953e;

        public Builder() {
            super(4);
        }

        private void d(E e4) {
            Objects.requireNonNull(this.f26952d);
            int length = this.f26952d.length - 1;
            int hashCode = e4.hashCode();
            int c4 = Hashing.c(hashCode);
            while (true) {
                int i4 = c4 & length;
                Object[] objArr = this.f26952d;
                Object obj = objArr[i4];
                if (obj == null) {
                    objArr[i4] = e4;
                    this.f26953e += hashCode;
                    super.add((Builder<E>) e4);
                    return;
                } else if (obj.equals(e4)) {
                    return;
                } else {
                    c4 = i4 + 1;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableCollection.ArrayBasedBuilder add(Object obj) {
            return add((Builder<E>) obj);
        }

        Builder(int i4) {
            super(i4);
            this.f26952d = new Object[ImmutableSet.i(i4)];
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder add(Object obj) {
            return add((Builder<E>) obj);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public ImmutableSet<E> build() {
            ImmutableSet<E> j4;
            int i4 = this.f26881b;
            if (i4 != 0) {
                if (i4 != 1) {
                    if (this.f26952d == null || ImmutableSet.i(i4) != this.f26952d.length) {
                        j4 = ImmutableSet.j(this.f26881b, this.f26880a);
                        this.f26881b = j4.size();
                    } else {
                        Object[] copyOf = ImmutableSet.n(this.f26881b, this.f26880a.length) ? Arrays.copyOf(this.f26880a, this.f26881b) : this.f26880a;
                        int i5 = this.f26953e;
                        Object[] objArr = this.f26952d;
                        j4 = new RegularImmutableSet<>(copyOf, i5, objArr, objArr.length - 1, this.f26881b);
                    }
                    this.f26882c = true;
                    this.f26952d = null;
                    return j4;
                }
                Object obj = this.f26880a[0];
                Objects.requireNonNull(obj);
                return ImmutableSet.of(obj);
            }
            return ImmutableSet.of();
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> iterable) {
            Preconditions.checkNotNull(iterable);
            if (this.f26952d != null) {
                for (E e4 : iterable) {
                    add((Builder<E>) e4);
                }
            } else {
                super.addAll((Iterable) iterable);
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E e4) {
            Preconditions.checkNotNull(e4);
            if (this.f26952d != null && ImmutableSet.i(this.f26881b) <= this.f26952d.length) {
                d(e4);
                return this;
            }
            this.f26952d = null;
            super.add((Builder<E>) e4);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> it) {
            Preconditions.checkNotNull(it);
            while (it.hasNext()) {
                add((Builder<E>) it.next());
            }
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E... eArr) {
            if (this.f26952d != null) {
                for (E e4 : eArr) {
                    add((Builder<E>) e4);
                }
            } else {
                super.add((Object[]) eArr);
            }
            return this;
        }
    }

    @J2ktIncompatible
    /* loaded from: classes5.dex */
    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        Object readResolve() {
            return ImmutableSet.copyOf(this.elements);
        }
    }

    public static <E> Builder<E> builder() {
        return new Builder<>();
    }

    public static <E> Builder<E> builderWithExpectedSize(int i4) {
        CollectPreconditions.b(i4, "expectedSize");
        return new Builder<>(i4);
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof SortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.f()) {
                return immutableSet;
            }
        }
        Object[] array = collection.toArray();
        return j(array.length, array);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public static int i(int i4) {
        int max = Math.max(i4, 2);
        boolean z3 = true;
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (highestOneBit * 0.7d < max) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        if (max >= 1073741824) {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "collection too large");
        return 1073741824;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ImmutableSet<E> j(int i4, Object... objArr) {
        if (i4 != 0) {
            if (i4 != 1) {
                int i5 = i(i4);
                Object[] objArr2 = new Object[i5];
                int i6 = i5 - 1;
                int i7 = 0;
                int i8 = 0;
                for (int i9 = 0; i9 < i4; i9++) {
                    Object a4 = ObjectArrays.a(objArr[i9], i9);
                    int hashCode = a4.hashCode();
                    int c4 = Hashing.c(hashCode);
                    while (true) {
                        int i10 = c4 & i6;
                        Object obj = objArr2[i10];
                        if (obj == null) {
                            objArr[i8] = a4;
                            objArr2[i10] = a4;
                            i7 += hashCode;
                            i8++;
                            break;
                        } else if (obj.equals(a4)) {
                            break;
                        } else {
                            c4++;
                        }
                    }
                }
                Arrays.fill(objArr, i8, i4, (Object) null);
                if (i8 == 1) {
                    Object obj2 = objArr[0];
                    Objects.requireNonNull(obj2);
                    return new SingletonImmutableSet(obj2);
                } else if (i(i8) < i5 / 2) {
                    return j(i8, objArr);
                } else {
                    if (n(i8, objArr.length)) {
                        objArr = Arrays.copyOf(objArr, i8);
                    }
                    return new RegularImmutableSet(objArr, i7, objArr2, i6, i8);
                }
            }
            Object obj3 = objArr[0];
            Objects.requireNonNull(obj3);
            return of(obj3);
        }
        return of();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean n(int i4, int i5) {
        if (i4 < (i5 >> 1) + (i5 >> 2)) {
            return true;
        }
        return false;
    }

    public static <E> ImmutableSet<E> of() {
        return RegularImmutableSet.f27361i;
    }

    @J2ktIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.f26951b;
        if (immutableList == null) {
            ImmutableList<E> l4 = l();
            this.f26951b = l4;
            return l4;
        }
        return immutableList;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && m() && ((ImmutableSet) obj).m() && hashCode() != obj.hashCode()) {
            return false;
        }
        return Sets.a(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return Sets.b(this);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public abstract UnmodifiableIterator<E> iterator();

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableList<E> l() {
        return ImmutableList.g(toArray());
    }

    boolean m() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection
    @J2ktIncompatible
    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> ImmutableSet<E> of(E e4) {
        return new SingletonImmutableSet(e4);
    }

    public static <E> ImmutableSet<E> of(E e4, E e5) {
        return j(2, e4, e5);
    }

    public static <E> ImmutableSet<E> of(E e4, E e5, E e6) {
        return j(3, e4, e5, e6);
    }

    public static <E> ImmutableSet<E> of(E e4, E e5, E e6, E e7) {
        return j(4, e4, e5, e6, e7);
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection) iterable);
        }
        return copyOf(iterable.iterator());
    }

    public static <E> ImmutableSet<E> of(E e4, E e5, E e6, E e7, E e8) {
        return j(5, e4, e5, e6, e7, e8);
    }

    @SafeVarargs
    public static <E> ImmutableSet<E> of(E e4, E e5, E e6, E e7, E e8, E e9, E... eArr) {
        Preconditions.checkArgument(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = eArr.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e4;
        objArr[1] = e5;
        objArr[2] = e6;
        objArr[3] = e7;
        objArr[4] = e8;
        objArr[5] = e9;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return j(length, objArr);
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        if (!it.hasNext()) {
            return of((Object) next);
        }
        return new Builder().add((Builder) next).addAll((Iterator) it).build();
    }

    public static <E> ImmutableSet<E> copyOf(E[] eArr) {
        int length = eArr.length;
        if (length != 0) {
            if (length != 1) {
                return j(eArr.length, (Object[]) eArr.clone());
            }
            return of((Object) eArr[0]);
        }
        return of();
    }
}
