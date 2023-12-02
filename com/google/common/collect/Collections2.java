package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.math.IntMath;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.annotation.CheckForNull;
import net.bytebuddy.pool.TypePool;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class Collections2 {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class FilteredCollection<E> extends AbstractCollection<E> {

        /* renamed from: a  reason: collision with root package name */
        final Collection<E> f26714a;

        /* renamed from: b  reason: collision with root package name */
        final Predicate<? super E> f26715b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public FilteredCollection(Collection<E> collection, Predicate<? super E> predicate) {
            this.f26714a = collection;
            this.f26715b = predicate;
        }

        FilteredCollection<E> a(Predicate<? super E> predicate) {
            return new FilteredCollection<>(this.f26714a, Predicates.and(this.f26715b, predicate));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(@ParametricNullness E e4) {
            Preconditions.checkArgument(this.f26715b.apply(e4));
            return this.f26714a.add(e4);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            for (E e4 : collection) {
                Preconditions.checkArgument(this.f26715b.apply(e4));
            }
            return this.f26714a.addAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Iterables.removeIf(this.f26714a, this.f26715b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@CheckForNull Object obj) {
            if (Collections2.f(this.f26714a, obj)) {
                return this.f26715b.apply(obj);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return Collections2.b(this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return !Iterables.any(this.f26714a, this.f26715b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            return Iterators.filter(this.f26714a.iterator(), this.f26715b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(@CheckForNull Object obj) {
            if (contains(obj) && this.f26714a.remove(obj)) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            Iterator<E> it = this.f26714a.iterator();
            boolean z3 = false;
            while (it.hasNext()) {
                E next = it.next();
                if (this.f26715b.apply(next) && collection.contains(next)) {
                    it.remove();
                    z3 = true;
                }
            }
            return z3;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            Iterator<E> it = this.f26714a.iterator();
            boolean z3 = false;
            while (it.hasNext()) {
                E next = it.next();
                if (this.f26715b.apply(next) && !collection.contains(next)) {
                    it.remove();
                    z3 = true;
                }
            }
            return z3;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i4 = 0;
            for (E e4 : this.f26714a) {
                if (this.f26715b.apply(e4)) {
                    i4++;
                }
            }
            return i4;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return Lists.newArrayList(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) Lists.newArrayList(iterator()).toArray(tArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class OrderedPermutationCollection<E> extends AbstractCollection<List<E>> {

        /* renamed from: a  reason: collision with root package name */
        final ImmutableList<E> f26716a;

        /* renamed from: b  reason: collision with root package name */
        final Comparator<? super E> f26717b;

        /* renamed from: c  reason: collision with root package name */
        final int f26718c;

        OrderedPermutationCollection(Iterable<E> iterable, Comparator<? super E> comparator) {
            ImmutableList<E> sortedCopyOf = ImmutableList.sortedCopyOf(comparator, iterable);
            this.f26716a = sortedCopyOf;
            this.f26717b = comparator;
            this.f26718c = a(sortedCopyOf, comparator);
        }

        private static <E> int a(List<E> list, Comparator<? super E> comparator) {
            int i4 = 1;
            int i5 = 1;
            int i6 = 1;
            while (i4 < list.size()) {
                if (comparator.compare(list.get(i4 - 1), list.get(i4)) < 0) {
                    i5 = IntMath.saturatedMultiply(i5, IntMath.binomial(i4, i6));
                    if (i5 == Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                    i6 = 0;
                }
                i4++;
                i6++;
            }
            return IntMath.saturatedMultiply(i5, IntMath.binomial(i4, i6));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@CheckForNull Object obj) {
            if (obj instanceof List) {
                return Collections2.d(this.f26716a, (List) obj);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<List<E>> iterator() {
            return new OrderedPermutationIterator(this.f26716a, this.f26717b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f26718c;
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return "orderedPermutationCollection(" + this.f26716a + ")";
        }
    }

    /* loaded from: classes5.dex */
    private static final class OrderedPermutationIterator<E> extends AbstractIterator<List<E>> {
        @CheckForNull

        /* renamed from: c  reason: collision with root package name */
        List<E> f26719c;

        /* renamed from: d  reason: collision with root package name */
        final Comparator<? super E> f26720d;

        OrderedPermutationIterator(List<E> list, Comparator<? super E> comparator) {
            this.f26719c = Lists.newArrayList(list);
            this.f26720d = comparator;
        }

        void d() {
            int f4 = f();
            if (f4 == -1) {
                this.f26719c = null;
                return;
            }
            Objects.requireNonNull(this.f26719c);
            Collections.swap(this.f26719c, f4, g(f4));
            Collections.reverse(this.f26719c.subList(f4 + 1, this.f26719c.size()));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        /* renamed from: e */
        public List<E> a() {
            List<E> list = this.f26719c;
            if (list == null) {
                return b();
            }
            ImmutableList copyOf = ImmutableList.copyOf((Collection) list);
            d();
            return copyOf;
        }

        int f() {
            Objects.requireNonNull(this.f26719c);
            for (int size = this.f26719c.size() - 2; size >= 0; size--) {
                if (this.f26720d.compare((E) this.f26719c.get(size), (E) this.f26719c.get(size + 1)) < 0) {
                    return size;
                }
            }
            return -1;
        }

        int g(int i4) {
            Objects.requireNonNull(this.f26719c);
            E e4 = this.f26719c.get(i4);
            for (int size = this.f26719c.size() - 1; size > i4; size--) {
                if (this.f26720d.compare(e4, (E) this.f26719c.get(size)) < 0) {
                    return size;
                }
            }
            throw new AssertionError("this statement should be unreachable");
        }
    }

    /* loaded from: classes5.dex */
    private static final class PermutationCollection<E> extends AbstractCollection<List<E>> {

        /* renamed from: a  reason: collision with root package name */
        final ImmutableList<E> f26721a;

        PermutationCollection(ImmutableList<E> immutableList) {
            this.f26721a = immutableList;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@CheckForNull Object obj) {
            if (obj instanceof List) {
                return Collections2.d(this.f26721a, (List) obj);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<List<E>> iterator() {
            return new PermutationIterator(this.f26721a);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return IntMath.factorial(this.f26721a.size());
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return "permutations(" + this.f26721a + ")";
        }
    }

    /* loaded from: classes5.dex */
    private static class PermutationIterator<E> extends AbstractIterator<List<E>> {

        /* renamed from: c  reason: collision with root package name */
        final List<E> f26722c;

        /* renamed from: d  reason: collision with root package name */
        final int[] f26723d;

        /* renamed from: e  reason: collision with root package name */
        final int[] f26724e;

        /* renamed from: f  reason: collision with root package name */
        int f26725f;

        PermutationIterator(List<E> list) {
            this.f26722c = new ArrayList(list);
            int size = list.size();
            int[] iArr = new int[size];
            this.f26723d = iArr;
            int[] iArr2 = new int[size];
            this.f26724e = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 1);
            this.f26725f = Integer.MAX_VALUE;
        }

        void d() {
            int size = this.f26722c.size() - 1;
            this.f26725f = size;
            if (size == -1) {
                return;
            }
            int i4 = 0;
            while (true) {
                int[] iArr = this.f26723d;
                int i5 = this.f26725f;
                int i6 = iArr[i5];
                int i7 = this.f26724e[i5] + i6;
                if (i7 < 0) {
                    f();
                } else if (i7 == i5 + 1) {
                    if (i5 != 0) {
                        i4++;
                        f();
                    } else {
                        return;
                    }
                } else {
                    Collections.swap(this.f26722c, (i5 - i6) + i4, (i5 - i7) + i4);
                    this.f26723d[this.f26725f] = i7;
                    return;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        /* renamed from: e */
        public List<E> a() {
            if (this.f26725f <= 0) {
                return b();
            }
            ImmutableList copyOf = ImmutableList.copyOf((Collection) this.f26722c);
            d();
            return copyOf;
        }

        void f() {
            int[] iArr = this.f26724e;
            int i4 = this.f26725f;
            iArr[i4] = -iArr[i4];
            this.f26725f = i4 - 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class TransformedCollection<F, T> extends AbstractCollection<T> {

        /* renamed from: a  reason: collision with root package name */
        final Collection<F> f26726a;

        /* renamed from: b  reason: collision with root package name */
        final Function<? super F, ? extends T> f26727b;

        TransformedCollection(Collection<F> collection, Function<? super F, ? extends T> function) {
            this.f26726a = (Collection) Preconditions.checkNotNull(collection);
            this.f26727b = (Function) Preconditions.checkNotNull(function);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.f26726a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f26726a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.transform(this.f26726a.iterator(), this.f26727b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f26726a.size();
        }
    }

    private Collections2() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(Collection<?> collection, Collection<?> collection2) {
        Iterator<?> it = collection2.iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    private static <E> ObjectCountHashMap<E> c(Collection<E> collection) {
        ObjectCountHashMap<E> objectCountHashMap = new ObjectCountHashMap<>();
        for (E e4 : collection) {
            objectCountHashMap.u(e4, objectCountHashMap.f(e4) + 1);
        }
        return objectCountHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(List<?> list, List<?> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        ObjectCountHashMap c4 = c(list);
        ObjectCountHashMap c5 = c(list2);
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i4 = 0; i4 < list.size(); i4++) {
            if (c4.k(i4) != c5.f(c4.i(i4))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StringBuilder e(int i4) {
        CollectPreconditions.b(i4, "size");
        return new StringBuilder((int) Math.min(i4 * 8, 1073741824L));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean f(Collection<?> collection, @CheckForNull Object obj) {
        Preconditions.checkNotNull(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static <E> Collection<E> filter(Collection<E> collection, Predicate<? super E> predicate) {
        if (collection instanceof FilteredCollection) {
            return ((FilteredCollection) collection).a(predicate);
        }
        return new FilteredCollection((Collection) Preconditions.checkNotNull(collection), (Predicate) Preconditions.checkNotNull(predicate));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean g(Collection<?> collection, @CheckForNull Object obj) {
        Preconditions.checkNotNull(collection);
        try {
            return collection.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String h(Collection<?> collection) {
        StringBuilder e4 = e(collection.size());
        e4.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
        boolean z3 = true;
        for (Object obj : collection) {
            if (!z3) {
                e4.append(", ");
            }
            if (obj == collection) {
                e4.append("(this Collection)");
            } else {
                e4.append(obj);
            }
            z3 = false;
        }
        e4.append(']');
        return e4.toString();
    }

    public static <E extends Comparable<? super E>> Collection<List<E>> orderedPermutations(Iterable<E> iterable) {
        return orderedPermutations(iterable, Ordering.natural());
    }

    public static <E> Collection<List<E>> permutations(Collection<E> collection) {
        return new PermutationCollection(ImmutableList.copyOf((Collection) collection));
    }

    public static <F, T> Collection<T> transform(Collection<F> collection, Function<? super F, T> function) {
        return new TransformedCollection(collection, function);
    }

    public static <E> Collection<List<E>> orderedPermutations(Iterable<E> iterable, Comparator<? super E> comparator) {
        return new OrderedPermutationCollection(iterable, comparator);
    }
}
