package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class Ordering<T> implements Comparator<T> {

    @VisibleForTesting
    @J2ktIncompatible
    /* loaded from: classes5.dex */
    static class ArbitraryOrdering extends Ordering<Object> {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicInteger f27322a = new AtomicInteger(0);

        /* renamed from: b  reason: collision with root package name */
        private final ConcurrentMap<Object, Integer> f27323b = Platform.j(new MapMaker()).makeMap();

        ArbitraryOrdering() {
        }

        private Integer b(Object obj) {
            Integer num = this.f27323b.get(obj);
            if (num == null) {
                Integer valueOf = Integer.valueOf(this.f27322a.getAndIncrement());
                Integer putIfAbsent = this.f27323b.putIfAbsent(obj, valueOf);
                if (putIfAbsent != null) {
                    return putIfAbsent;
                }
                return valueOf;
            }
            return num;
        }

        int c(Object obj) {
            return System.identityHashCode(obj);
        }

        @Override // com.google.common.collect.Ordering, java.util.Comparator
        public int compare(@CheckForNull Object obj, @CheckForNull Object obj2) {
            if (obj == obj2) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            int c4 = c(obj);
            int c5 = c(obj2);
            if (c4 != c5) {
                if (c4 < c5) {
                    return -1;
                }
                return 1;
            }
            int compareTo = b(obj).compareTo(b(obj2));
            if (compareTo != 0) {
                return compareTo;
            }
            throw new AssertionError();
        }

        public String toString() {
            return "Ordering.arbitrary()";
        }
    }

    @J2ktIncompatible
    /* loaded from: classes5.dex */
    private static class ArbitraryOrderingHolder {

        /* renamed from: a  reason: collision with root package name */
        static final Ordering<Object> f27324a = new ArbitraryOrdering();

        private ArbitraryOrderingHolder() {
        }
    }

    @VisibleForTesting
    /* loaded from: classes5.dex */
    static class IncomparableValueException extends ClassCastException {
        private static final long serialVersionUID = 0;
        final Object value;

        /* JADX INFO: Access modifiers changed from: package-private */
        public IncomparableValueException(Object obj) {
            super("Cannot compare value: " + obj);
            this.value = obj;
        }
    }

    @GwtCompatible(serializable = true)
    public static Ordering<Object> allEqual() {
        return AllEqualOrdering.f26691a;
    }

    @J2ktIncompatible
    public static Ordering<Object> arbitrary() {
        return ArbitraryOrderingHolder.f27324a;
    }

    @GwtCompatible(serializable = true)
    public static <T> Ordering<T> explicit(List<T> list) {
        return new ExplicitOrdering(list);
    }

    @GwtCompatible(serializable = true)
    public static <T> Ordering<T> from(Comparator<T> comparator) {
        if (comparator instanceof Ordering) {
            return (Ordering) comparator;
        }
        return new ComparatorOrdering(comparator);
    }

    @GwtCompatible(serializable = true)
    public static <C extends Comparable> Ordering<C> natural() {
        return NaturalOrdering.f27305c;
    }

    @GwtCompatible(serializable = true)
    public static Ordering<Object> usingToString() {
        return UsingToStringOrdering.f27599a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T2 extends T> Ordering<Map.Entry<T2, ?>> a() {
        return (Ordering<Map.Entry<T2, ?>>) onResultOf(Maps.t());
    }

    @Deprecated
    public int binarySearch(List<? extends T> list, @ParametricNullness T t3) {
        return Collections.binarySearch(list, t3, this);
    }

    @Override // java.util.Comparator
    public abstract int compare(@ParametricNullness T t3, @ParametricNullness T t4);

    @GwtCompatible(serializable = true)
    public <U extends T> Ordering<U> compound(Comparator<? super U> comparator) {
        return new CompoundOrdering(this, (Comparator) Preconditions.checkNotNull(comparator));
    }

    public <E extends T> List<E> greatestOf(Iterable<E> iterable, int i4) {
        return reverse().leastOf(iterable, i4);
    }

    public <E extends T> ImmutableList<E> immutableSortedCopy(Iterable<E> iterable) {
        return ImmutableList.sortedCopyOf(this, iterable);
    }

    public boolean isOrdered(Iterable<? extends T> iterable) {
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                T next2 = it.next();
                if (compare(next, next2) > 0) {
                    return false;
                }
                next = next2;
            }
            return true;
        }
        return true;
    }

    public boolean isStrictlyOrdered(Iterable<? extends T> iterable) {
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                T next2 = it.next();
                if (compare(next, next2) >= 0) {
                    return false;
                }
                next = next2;
            }
            return true;
        }
        return true;
    }

    public <E extends T> List<E> leastOf(Iterable<E> iterable, int i4) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= i4 * 2) {
                Object[] array = collection.toArray();
                Arrays.sort(array, this);
                if (array.length > i4) {
                    array = Arrays.copyOf(array, i4);
                }
                return Collections.unmodifiableList(Arrays.asList(array));
            }
        }
        return leastOf(iterable.iterator(), i4);
    }

    @GwtCompatible(serializable = true)
    public <S extends T> Ordering<Iterable<S>> lexicographical() {
        return new LexicographicalOrdering(this);
    }

    @ParametricNullness
    public <E extends T> E max(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = (E) max(next, it.next());
        }
        return next;
    }

    @ParametricNullness
    public <E extends T> E min(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = (E) min(next, it.next());
        }
        return next;
    }

    @GwtCompatible(serializable = true)
    public <S extends T> Ordering<S> nullsFirst() {
        return new NullsFirstOrdering(this);
    }

    @GwtCompatible(serializable = true)
    public <S extends T> Ordering<S> nullsLast() {
        return new NullsLastOrdering(this);
    }

    @GwtCompatible(serializable = true)
    public <F> Ordering<F> onResultOf(Function<F, ? extends T> function) {
        return new ByFunctionOrdering(function, this);
    }

    @GwtCompatible(serializable = true)
    public <S extends T> Ordering<S> reverse() {
        return new ReverseOrdering(this);
    }

    public <E extends T> List<E> sortedCopy(Iterable<E> iterable) {
        Object[] f4 = Iterables.f(iterable);
        Arrays.sort(f4, this);
        return Lists.newArrayList(Arrays.asList(f4));
    }

    @GwtCompatible(serializable = true)
    public static <T> Ordering<T> compound(Iterable<? extends Comparator<? super T>> iterable) {
        return new CompoundOrdering(iterable);
    }

    @GwtCompatible(serializable = true)
    public static <T> Ordering<T> explicit(T t3, T... tArr) {
        return explicit(Lists.asList(t3, tArr));
    }

    public <E extends T> List<E> greatestOf(Iterator<E> it, int i4) {
        return reverse().leastOf(it, i4);
    }

    @GwtCompatible(serializable = true)
    @Deprecated
    public static <T> Ordering<T> from(Ordering<T> ordering) {
        return (Ordering) Preconditions.checkNotNull(ordering);
    }

    @ParametricNullness
    public <E extends T> E max(Iterable<E> iterable) {
        return (E) max(iterable.iterator());
    }

    @ParametricNullness
    public <E extends T> E min(Iterable<E> iterable) {
        return (E) min(iterable.iterator());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @ParametricNullness
    public <E extends T> E max(@ParametricNullness E e4, @ParametricNullness E e5) {
        return compare(e4, e5) >= 0 ? e4 : e5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @ParametricNullness
    public <E extends T> E min(@ParametricNullness E e4, @ParametricNullness E e5) {
        return compare(e4, e5) <= 0 ? e4 : e5;
    }

    @ParametricNullness
    public <E extends T> E max(@ParametricNullness E e4, @ParametricNullness E e5, @ParametricNullness E e6, E... eArr) {
        E e7 = (E) max(max(e4, e5), e6);
        for (E e8 : eArr) {
            e7 = (E) max(e7, e8);
        }
        return e7;
    }

    @ParametricNullness
    public <E extends T> E min(@ParametricNullness E e4, @ParametricNullness E e5, @ParametricNullness E e6, E... eArr) {
        E e7 = (E) min(min(e4, e5), e6);
        for (E e8 : eArr) {
            e7 = (E) min(e7, e8);
        }
        return e7;
    }

    public <E extends T> List<E> leastOf(Iterator<E> it, int i4) {
        Preconditions.checkNotNull(it);
        CollectPreconditions.b(i4, "k");
        if (i4 == 0 || !it.hasNext()) {
            return Collections.emptyList();
        }
        if (i4 >= 1073741823) {
            ArrayList newArrayList = Lists.newArrayList(it);
            Collections.sort(newArrayList, this);
            if (newArrayList.size() > i4) {
                newArrayList.subList(i4, newArrayList.size()).clear();
            }
            newArrayList.trimToSize();
            return Collections.unmodifiableList(newArrayList);
        }
        TopKSelector a4 = TopKSelector.a(i4, this);
        a4.c(it);
        return a4.f();
    }
}
