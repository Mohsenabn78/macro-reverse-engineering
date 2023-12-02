package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.InlineMe;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {

    /* renamed from: b  reason: collision with root package name */
    private static final UnmodifiableListIterator<Object> f26886b = new Itr(RegularImmutableList.f27340e, 0);

    /* loaded from: classes5.dex */
    public static final class Builder<E> extends ImmutableCollection.ArrayBasedBuilder<E> {
        public Builder() {
            this(4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableCollection.ArrayBasedBuilder add(Object obj) {
            return add((Builder<E>) obj);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(int i4) {
            super(i4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder add(Object obj) {
            return add((Builder<E>) obj);
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        public ImmutableList<E> build() {
            this.f26882c = true;
            return ImmutableList.h(this.f26880a, this.f26881b);
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> iterable) {
            super.addAll((Iterable) iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E e4) {
            super.add((Builder<E>) e4);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> it) {
            super.addAll((Iterator) it);
            return this;
        }

        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        @CanIgnoreReturnValue
        public Builder<E> add(E... eArr) {
            super.add((Object[]) eArr);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class Itr<E> extends AbstractIndexedListIterator<E> {

        /* renamed from: c  reason: collision with root package name */
        private final ImmutableList<E> f26887c;

        Itr(ImmutableList<E> immutableList, int i4) {
            super(immutableList.size(), i4);
            this.f26887c = immutableList;
        }

        @Override // com.google.common.collect.AbstractIndexedListIterator
        protected E a(int i4) {
            return this.f26887c.get(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class ReverseImmutableList<E> extends ImmutableList<E> {

        /* renamed from: c  reason: collision with root package name */
        private final transient ImmutableList<E> f26888c;

        ReverseImmutableList(ImmutableList<E> immutableList) {
            this.f26888c = immutableList;
        }

        private int l(int i4) {
            return (size() - 1) - i4;
        }

        private int m(int i4) {
            return size() - i4;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            return this.f26888c.contains(obj);
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean f() {
            return this.f26888c.f();
        }

        @Override // java.util.List
        public E get(int i4) {
            Preconditions.checkElementIndex(i4, size());
            return this.f26888c.get(l(i4));
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(@CheckForNull Object obj) {
            int lastIndexOf = this.f26888c.lastIndexOf(obj);
            if (lastIndexOf >= 0) {
                return l(lastIndexOf);
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(@CheckForNull Object obj) {
            int indexOf = this.f26888c.indexOf(obj);
            if (indexOf >= 0) {
                return l(indexOf);
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // com.google.common.collect.ImmutableList
        public ImmutableList<E> reverse() {
            return this.f26888c;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f26888c.size();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i4) {
            return super.listIterator(i4);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int i4, int i5) {
            Preconditions.checkPositionIndexes(i4, i5, size());
            return this.f26888c.subList(m(i5), m(i4)).reverse();
        }
    }

    @J2ktIncompatible
    /* loaded from: classes5.dex */
    static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        Object readResolve() {
            return ImmutableList.copyOf(this.elements);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class SubList extends ImmutableList<E> {

        /* renamed from: c  reason: collision with root package name */
        final transient int f26889c;

        /* renamed from: d  reason: collision with root package name */
        final transient int f26890d;

        SubList(int i4, int i5) {
            this.f26889c = i4;
            this.f26890d = i5;
        }

        @Override // com.google.common.collect.ImmutableCollection
        @CheckForNull
        Object[] b() {
            return ImmutableList.this.b();
        }

        @Override // com.google.common.collect.ImmutableCollection
        int c() {
            return ImmutableList.this.e() + this.f26889c + this.f26890d;
        }

        @Override // com.google.common.collect.ImmutableCollection
        int e() {
            return ImmutableList.this.e() + this.f26889c;
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean f() {
            return true;
        }

        @Override // java.util.List
        public E get(int i4) {
            Preconditions.checkElementIndex(i4, this.f26890d);
            return ImmutableList.this.get(i4 + this.f26889c);
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f26890d;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i4) {
            return super.listIterator(i4);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int i4, int i5) {
            Preconditions.checkPositionIndexes(i4, i5, this.f26890d);
            ImmutableList immutableList = ImmutableList.this;
            int i6 = this.f26889c;
            return immutableList.subList(i4 + i6, i5 + i6);
        }
    }

    public static <E> Builder<E> builder() {
        return new Builder<>();
    }

    public static <E> Builder<E> builderWithExpectedSize(int i4) {
        CollectPreconditions.b(i4, "expectedSize");
        return new Builder<>(i4);
    }

    public static <E> ImmutableList<E> copyOf(Iterable<? extends E> iterable) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof Collection) {
            return copyOf((Collection) iterable);
        }
        return copyOf(iterable.iterator());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> ImmutableList<E> g(Object[] objArr) {
        return h(objArr, objArr.length);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> ImmutableList<E> h(Object[] objArr, int i4) {
        if (i4 == 0) {
            return of();
        }
        return new RegularImmutableList(objArr, i4);
    }

    private static <E> ImmutableList<E> i(Object... objArr) {
        return g(ObjectArrays.b(objArr));
    }

    public static <E> ImmutableList<E> of() {
        return (ImmutableList<E>) RegularImmutableList.f27340e;
    }

    @J2ktIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<? super E>> ImmutableList<E> sortedCopyOf(Iterable<? extends E> iterable) {
        Comparable[] comparableArr = (Comparable[]) Iterables.g(iterable, new Comparable[0]);
        ObjectArrays.b(comparableArr);
        Arrays.sort(comparableArr);
        return g(comparableArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int a(Object[] objArr, int i4) {
        int size = size();
        for (int i5 = 0; i5 < size; i5++) {
            objArr[i4 + i5] = get(i5);
        }
        return i4 + size;
    }

    @Override // java.util.List
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void add(int i4, E e4) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean addAll(int i4, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@CheckForNull Object obj) {
        return Lists.c(this, obj);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i4 = 1;
        for (int i5 = 0; i5 < size; i5++) {
            i4 = ~(~((i4 * 31) + get(i5).hashCode()));
        }
        return i4;
    }

    @Override // java.util.List
    public int indexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        return Lists.d(this, obj);
    }

    ImmutableList<E> j(int i4, int i5) {
        return new SubList(i4, i5 - i4);
    }

    @Override // java.util.List
    public int lastIndexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        return Lists.f(this, obj);
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final E remove(int i4) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> reverse() {
        if (size() <= 1) {
            return this;
        }
        return new ReverseImmutableList(this);
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final E set(int i4, E e4) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection
    @J2ktIncompatible
    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> ImmutableList<E> of(E e4) {
        return i(e4);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
    public UnmodifiableIterator<E> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public ImmutableList<E> subList(int i4, int i5) {
        Preconditions.checkPositionIndexes(i4, i5, size());
        int i6 = i5 - i4;
        if (i6 == size()) {
            return this;
        }
        if (i6 == 0) {
            return of();
        }
        return j(i4, i5);
    }

    public static <E> ImmutableList<E> of(E e4, E e5) {
        return i(e4, e5);
    }

    @Override // java.util.List
    public UnmodifiableListIterator<E> listIterator() {
        return listIterator(0);
    }

    public static <E> ImmutableList<E> of(E e4, E e5, E e6) {
        return i(e4, e5, e6);
    }

    @Override // java.util.List
    public UnmodifiableListIterator<E> listIterator(int i4) {
        Preconditions.checkPositionIndex(i4, size());
        if (isEmpty()) {
            return (UnmodifiableListIterator<E>) f26886b;
        }
        return new Itr(this, i4);
    }

    public static <E> ImmutableList<E> copyOf(Collection<? extends E> collection) {
        if (collection instanceof ImmutableCollection) {
            ImmutableList<E> asList = ((ImmutableCollection) collection).asList();
            return asList.f() ? g(asList.toArray()) : asList;
        }
        return i(collection.toArray());
    }

    public static <E> ImmutableList<E> of(E e4, E e5, E e6, E e7) {
        return i(e4, e5, e6, e7);
    }

    public static <E> ImmutableList<E> sortedCopyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        Preconditions.checkNotNull(comparator);
        Object[] f4 = Iterables.f(iterable);
        ObjectArrays.b(f4);
        Arrays.sort(f4, comparator);
        return g(f4);
    }

    public static <E> ImmutableList<E> of(E e4, E e5, E e6, E e7, E e8) {
        return i(e4, e5, e6, e7, e8);
    }

    public static <E> ImmutableList<E> of(E e4, E e5, E e6, E e7, E e8, E e9) {
        return i(e4, e5, e6, e7, e8, e9);
    }

    public static <E> ImmutableList<E> of(E e4, E e5, E e6, E e7, E e8, E e9, E e10) {
        return i(e4, e5, e6, e7, e8, e9, e10);
    }

    public static <E> ImmutableList<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        if (!it.hasNext()) {
            return of((Object) next);
        }
        return new Builder().add((Builder) next).addAll((Iterator) it).build();
    }

    public static <E> ImmutableList<E> of(E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11) {
        return i(e4, e5, e6, e7, e8, e9, e10, e11);
    }

    public static <E> ImmutableList<E> of(E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11, E e12) {
        return i(e4, e5, e6, e7, e8, e9, e10, e11, e12);
    }

    public static <E> ImmutableList<E> of(E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11, E e12, E e13) {
        return i(e4, e5, e6, e7, e8, e9, e10, e11, e12, e13);
    }

    public static <E> ImmutableList<E> of(E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11, E e12, E e13, E e14) {
        return i(e4, e5, e6, e7, e8, e9, e10, e11, e12, e13, e14);
    }

    @SafeVarargs
    public static <E> ImmutableList<E> of(E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11, E e12, E e13, E e14, E e15, E... eArr) {
        Preconditions.checkArgument(eArr.length <= 2147483635, "the total number of elements must fit in an int");
        Object[] objArr = new Object[eArr.length + 12];
        objArr[0] = e4;
        objArr[1] = e5;
        objArr[2] = e6;
        objArr[3] = e7;
        objArr[4] = e8;
        objArr[5] = e9;
        objArr[6] = e10;
        objArr[7] = e11;
        objArr[8] = e12;
        objArr[9] = e13;
        objArr[10] = e14;
        objArr[11] = e15;
        System.arraycopy(eArr, 0, objArr, 12, eArr.length);
        return i(objArr);
    }

    public static <E> ImmutableList<E> copyOf(E[] eArr) {
        if (eArr.length == 0) {
            return of();
        }
        return i((Object[]) eArr.clone());
    }

    @Override // com.google.common.collect.ImmutableCollection
    @InlineMe(replacement = "this")
    @Deprecated
    public final ImmutableList<E> asList() {
        return this;
    }
}
