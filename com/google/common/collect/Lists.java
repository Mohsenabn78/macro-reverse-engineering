package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class Lists {

    /* renamed from: com.google.common.collect.Lists$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass1 extends RandomAccessListWrapper<Object> {
        @Override // java.util.AbstractList, java.util.List
        public ListIterator<Object> listIterator(int i4) {
            return this.f27087a.listIterator(i4);
        }
    }

    /* renamed from: com.google.common.collect.Lists$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    class AnonymousClass2 extends AbstractListWrapper<Object> {
        @Override // java.util.AbstractList, java.util.List
        public ListIterator<Object> listIterator(int i4) {
            return this.f27087a.listIterator(i4);
        }
    }

    /* loaded from: classes5.dex */
    private static class AbstractListWrapper<E> extends AbstractList<E> {

        /* renamed from: a  reason: collision with root package name */
        final List<E> f27087a;

        @Override // java.util.AbstractList, java.util.List
        public void add(int i4, @ParametricNullness E e4) {
            this.f27087a.add(i4, e4);
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int i4, Collection<? extends E> collection) {
            return this.f27087a.addAll(i4, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object obj) {
            return this.f27087a.contains(obj);
        }

        @Override // java.util.AbstractList, java.util.List
        @ParametricNullness
        public E get(int i4) {
            return this.f27087a.get(i4);
        }

        @Override // java.util.AbstractList, java.util.List
        @ParametricNullness
        public E remove(int i4) {
            return this.f27087a.remove(i4);
        }

        @Override // java.util.AbstractList, java.util.List
        @ParametricNullness
        public E set(int i4, @ParametricNullness E e4) {
            return this.f27087a.set(i4, e4);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f27087a.size();
        }
    }

    /* loaded from: classes5.dex */
    private static final class CharSequenceAsList extends AbstractList<Character> {

        /* renamed from: a  reason: collision with root package name */
        private final CharSequence f27088a;

        CharSequenceAsList(CharSequence charSequence) {
            this.f27088a = charSequence;
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a */
        public Character get(int i4) {
            Preconditions.checkElementIndex(i4, size());
            return Character.valueOf(this.f27088a.charAt(i4));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f27088a.length();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class OnePlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        @J2ktIncompatible
        private static final long serialVersionUID = 0;
        @ParametricNullness
        final E first;
        final E[] rest;

        OnePlusArrayList(@ParametricNullness E e4, E[] eArr) {
            this.first = e4;
            this.rest = (E[]) ((Object[]) Preconditions.checkNotNull(eArr));
        }

        @Override // java.util.AbstractList, java.util.List
        @ParametricNullness
        public E get(int i4) {
            Preconditions.checkElementIndex(i4, size());
            if (i4 == 0) {
                return this.first;
            }
            return this.rest[i4 - 1];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return IntMath.saturatedAdd(this.rest.length, 1);
        }
    }

    /* loaded from: classes5.dex */
    private static class Partition<T> extends AbstractList<List<T>> {

        /* renamed from: a  reason: collision with root package name */
        final List<T> f27089a;

        /* renamed from: b  reason: collision with root package name */
        final int f27090b;

        Partition(List<T> list, int i4) {
            this.f27089a = list;
            this.f27090b = i4;
        }

        @Override // java.util.AbstractList, java.util.List
        /* renamed from: a */
        public List<T> get(int i4) {
            Preconditions.checkElementIndex(i4, size());
            int i5 = this.f27090b;
            int i6 = i4 * i5;
            return this.f27089a.subList(i6, Math.min(i5 + i6, this.f27089a.size()));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.f27089a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return IntMath.divide(this.f27089a.size(), this.f27090b, RoundingMode.CEILING);
        }
    }

    /* loaded from: classes5.dex */
    private static class RandomAccessListWrapper<E> extends AbstractListWrapper<E> implements RandomAccess {
    }

    /* loaded from: classes5.dex */
    private static class RandomAccessPartition<T> extends Partition<T> implements RandomAccess {
        RandomAccessPartition(List<T> list, int i4) {
            super(list, i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class RandomAccessReverseList<T> extends ReverseList<T> implements RandomAccess {
        RandomAccessReverseList(List<T> list) {
            super(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class ReverseList<T> extends AbstractList<T> {

        /* renamed from: a  reason: collision with root package name */
        private final List<T> f27091a;

        ReverseList(List<T> list) {
            this.f27091a = (List) Preconditions.checkNotNull(list);
        }

        private int c(int i4) {
            int size = size();
            Preconditions.checkElementIndex(i4, size);
            return (size - 1) - i4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int d(int i4) {
            int size = size();
            Preconditions.checkPositionIndex(i4, size);
            return size - i4;
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i4, @ParametricNullness T t3) {
            this.f27091a.add(d(i4), t3);
        }

        List<T> b() {
            return this.f27091a;
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.f27091a.clear();
        }

        @Override // java.util.AbstractList, java.util.List
        @ParametricNullness
        public T get(int i4) {
            return this.f27091a.get(c(i4));
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i4) {
            final ListIterator<T> listIterator = this.f27091a.listIterator(d(i4));
            return new ListIterator<T>() { // from class: com.google.common.collect.Lists.ReverseList.1

                /* renamed from: a  reason: collision with root package name */
                boolean f27092a;

                @Override // java.util.ListIterator
                public void add(@ParametricNullness T t3) {
                    listIterator.add(t3);
                    listIterator.previous();
                    this.f27092a = false;
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public boolean hasNext() {
                    return listIterator.hasPrevious();
                }

                @Override // java.util.ListIterator
                public boolean hasPrevious() {
                    return listIterator.hasNext();
                }

                @Override // java.util.ListIterator, java.util.Iterator
                @ParametricNullness
                public T next() {
                    if (hasNext()) {
                        this.f27092a = true;
                        return (T) listIterator.previous();
                    }
                    throw new NoSuchElementException();
                }

                @Override // java.util.ListIterator
                public int nextIndex() {
                    return ReverseList.this.d(listIterator.nextIndex());
                }

                @Override // java.util.ListIterator
                @ParametricNullness
                public T previous() {
                    if (hasPrevious()) {
                        this.f27092a = true;
                        return (T) listIterator.next();
                    }
                    throw new NoSuchElementException();
                }

                @Override // java.util.ListIterator
                public int previousIndex() {
                    return nextIndex() - 1;
                }

                @Override // java.util.ListIterator, java.util.Iterator
                public void remove() {
                    CollectPreconditions.e(this.f27092a);
                    listIterator.remove();
                    this.f27092a = false;
                }

                @Override // java.util.ListIterator
                public void set(@ParametricNullness T t3) {
                    Preconditions.checkState(this.f27092a);
                    listIterator.set(t3);
                }
            };
        }

        @Override // java.util.AbstractList, java.util.List
        @ParametricNullness
        public T remove(int i4) {
            return this.f27091a.remove(c(i4));
        }

        @Override // java.util.AbstractList
        protected void removeRange(int i4, int i5) {
            subList(i4, i5).clear();
        }

        @Override // java.util.AbstractList, java.util.List
        @ParametricNullness
        public T set(int i4, @ParametricNullness T t3) {
            return this.f27091a.set(c(i4), t3);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f27091a.size();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<T> subList(int i4, int i5) {
            Preconditions.checkPositionIndexes(i4, i5, size());
            return Lists.reverse(this.f27091a.subList(d(i5), d(i4)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class StringAsImmutableList extends ImmutableList<Character> {
        private final String string;

        StringAsImmutableList(String str) {
            this.string = str;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean f() {
            return false;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(@CheckForNull Object obj) {
            if (obj instanceof Character) {
                return this.string.indexOf(((Character) obj).charValue());
            }
            return -1;
        }

        @Override // java.util.List
        /* renamed from: l */
        public Character get(int i4) {
            Preconditions.checkElementIndex(i4, size());
            return Character.valueOf(this.string.charAt(i4));
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(@CheckForNull Object obj) {
            if (obj instanceof Character) {
                return this.string.lastIndexOf(((Character) obj).charValue());
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.string.length();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<Character> subList(int i4, int i5) {
            Preconditions.checkPositionIndexes(i4, i5, size());
            return Lists.charactersOf(this.string.substring(i4, i5));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TransformingRandomAccessList<F, T> extends AbstractList<T> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final Function<? super F, ? extends T> function;

        TransformingRandomAccessList(List<F> list, Function<? super F, ? extends T> function) {
            this.fromList = (List) Preconditions.checkNotNull(list);
            this.function = (Function) Preconditions.checkNotNull(function);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.AbstractList, java.util.List
        @ParametricNullness
        public T get(int i4) {
            return this.function.apply((F) this.fromList.get(i4));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.fromList.isEmpty();
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i4) {
            return new TransformedListIterator<F, T>(this.fromList.listIterator(i4)) { // from class: com.google.common.collect.Lists.TransformingRandomAccessList.1
                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // com.google.common.collect.TransformedIterator
                public T a(F f4) {
                    return TransformingRandomAccessList.this.function.apply(f4);
                }
            };
        }

        @Override // java.util.AbstractList, java.util.List
        public T remove(int i4) {
            return this.function.apply((F) this.fromList.remove(i4));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TransformingSequentialList<F, T> extends AbstractSequentialList<T> implements Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final Function<? super F, ? extends T> function;

        TransformingSequentialList(List<F> list, Function<? super F, ? extends T> function) {
            this.fromList = (List) Preconditions.checkNotNull(list);
            this.function = (Function) Preconditions.checkNotNull(function);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i4) {
            return new TransformedListIterator<F, T>(this.fromList.listIterator(i4)) { // from class: com.google.common.collect.Lists.TransformingSequentialList.1
                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // com.google.common.collect.TransformedIterator
                @ParametricNullness
                public T a(@ParametricNullness F f4) {
                    return TransformingSequentialList.this.function.apply(f4);
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    /* loaded from: classes5.dex */
    private static class TwoPlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        @J2ktIncompatible
        private static final long serialVersionUID = 0;
        @ParametricNullness
        final E first;
        final E[] rest;
        @ParametricNullness
        final E second;

        TwoPlusArrayList(@ParametricNullness E e4, @ParametricNullness E e5, E[] eArr) {
            this.first = e4;
            this.second = e5;
            this.rest = (E[]) ((Object[]) Preconditions.checkNotNull(eArr));
        }

        @Override // java.util.AbstractList, java.util.List
        @ParametricNullness
        public E get(int i4) {
            if (i4 != 0) {
                if (i4 != 1) {
                    Preconditions.checkElementIndex(i4, size());
                    return this.rest[i4 - 2];
                }
                return this.second;
            }
            return this.first;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return IntMath.saturatedAdd(this.rest.length, 2);
        }
    }

    private Lists() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> List<T> a(Iterable<T> iterable) {
        return (List) iterable;
    }

    public static <E> List<E> asList(@ParametricNullness E e4, E[] eArr) {
        return new OnePlusArrayList(e4, eArr);
    }

    @VisibleForTesting
    static int b(int i4) {
        CollectPreconditions.b(i4, "arraySize");
        return Ints.saturatedCast(i4 + 5 + (i4 / 10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(List<?> list, @CheckForNull Object obj) {
        if (obj == Preconditions.checkNotNull(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if ((list instanceof RandomAccess) && (list2 instanceof RandomAccess)) {
            for (int i4 = 0; i4 < size; i4++) {
                if (!Objects.equal(list.get(i4), list2.get(i4))) {
                    return false;
                }
            }
            return true;
        }
        return Iterators.elementsEqual(list.iterator(), list2.iterator());
    }

    public static <B> List<List<B>> cartesianProduct(List<? extends List<? extends B>> list) {
        return CartesianList.c(list);
    }

    public static ImmutableList<Character> charactersOf(String str) {
        return new StringAsImmutableList((String) Preconditions.checkNotNull(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(List<?> list, @CheckForNull Object obj) {
        if (list instanceof RandomAccess) {
            return e(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (Objects.equal(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    private static int e(List<?> list, @CheckForNull Object obj) {
        int size = list.size();
        int i4 = 0;
        if (obj == null) {
            while (i4 < size) {
                if (list.get(i4) == null) {
                    return i4;
                }
                i4++;
            }
            return -1;
        }
        while (i4 < size) {
            if (obj.equals(list.get(i4))) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(List<?> list, @CheckForNull Object obj) {
        if (list instanceof RandomAccess) {
            return g(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (Objects.equal(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    private static int g(List<?> list, @CheckForNull Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayList() {
        return new ArrayList<>();
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayListWithCapacity(int i4) {
        CollectPreconditions.b(i4, "initialArraySize");
        return new ArrayList<>(i4);
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayListWithExpectedSize(int i4) {
        return new ArrayList<>(b(i4));
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static <E> CopyOnWriteArrayList<E> newCopyOnWriteArrayList() {
        return new CopyOnWriteArrayList<>();
    }

    @GwtCompatible(serializable = true)
    public static <E> LinkedList<E> newLinkedList() {
        return new LinkedList<>();
    }

    public static <T> List<List<T>> partition(List<T> list, int i4) {
        boolean z3;
        Preconditions.checkNotNull(list);
        if (i4 > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        if (list instanceof RandomAccess) {
            return new RandomAccessPartition(list, i4);
        }
        return new Partition(list, i4);
    }

    public static <T> List<T> reverse(List<T> list) {
        if (list instanceof ImmutableList) {
            return ((ImmutableList) list).reverse();
        }
        if (list instanceof ReverseList) {
            return ((ReverseList) list).b();
        }
        if (list instanceof RandomAccess) {
            return new RandomAccessReverseList(list);
        }
        return new ReverseList(list);
    }

    public static <F, T> List<T> transform(List<F> list, Function<? super F, ? extends T> function) {
        if (list instanceof RandomAccess) {
            return new TransformingRandomAccessList(list, function);
        }
        return new TransformingSequentialList(list, function);
    }

    public static <E> List<E> asList(@ParametricNullness E e4, @ParametricNullness E e5, E[] eArr) {
        return new TwoPlusArrayList(e4, e5, eArr);
    }

    @SafeVarargs
    public static <B> List<List<B>> cartesianProduct(List<? extends B>... listArr) {
        return cartesianProduct(Arrays.asList(listArr));
    }

    public static List<Character> charactersOf(CharSequence charSequence) {
        return new CharSequenceAsList((CharSequence) Preconditions.checkNotNull(charSequence));
    }

    @SafeVarargs
    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayList(E... eArr) {
        Preconditions.checkNotNull(eArr);
        ArrayList<E> arrayList = new ArrayList<>(b(eArr.length));
        Collections.addAll(arrayList, eArr);
        return arrayList;
    }

    @J2ktIncompatible
    @GwtIncompatible
    public static <E> CopyOnWriteArrayList<E> newCopyOnWriteArrayList(Iterable<? extends E> iterable) {
        Collection newArrayList;
        if (iterable instanceof Collection) {
            newArrayList = (Collection) iterable;
        } else {
            newArrayList = newArrayList(iterable);
        }
        return new CopyOnWriteArrayList<>(newArrayList);
    }

    @GwtCompatible(serializable = true)
    public static <E> LinkedList<E> newLinkedList(Iterable<? extends E> iterable) {
        LinkedList<E> newLinkedList = newLinkedList();
        Iterables.addAll(newLinkedList, iterable);
        return newLinkedList;
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayList(Iterable<? extends E> iterable) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof Collection) {
            return new ArrayList<>((Collection) iterable);
        }
        return newArrayList(iterable.iterator());
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> newArrayList(Iterator<? extends E> it) {
        ArrayList<E> newArrayList = newArrayList();
        Iterators.addAll(newArrayList, it);
        return newArrayList;
    }
}
