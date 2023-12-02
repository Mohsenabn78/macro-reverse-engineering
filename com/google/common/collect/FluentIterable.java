package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.InlineMe;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class FluentIterable<E> implements Iterable<E> {

    /* renamed from: a  reason: collision with root package name */
    private final Optional<Iterable<E>> f26832a;

    /* loaded from: classes5.dex */
    private static class FromIterableFunction<E> implements Function<Iterable<E>, FluentIterable<E>> {
        private FromIterableFunction() {
        }

        @Override // com.google.common.base.Function
        /* renamed from: a */
        public FluentIterable<E> apply(Iterable<E> iterable) {
            return FluentIterable.from(iterable);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FluentIterable() {
        this.f26832a = Optional.absent();
    }

    private static <T> FluentIterable<T> a(final Iterable<? extends T>... iterableArr) {
        for (Iterable<? extends T> iterable : iterableArr) {
            Preconditions.checkNotNull(iterable);
        }
        return new FluentIterable<T>() { // from class: com.google.common.collect.FluentIterable.3
            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                return Iterators.concat(new AbstractIndexedListIterator<Iterator<? extends T>>(iterableArr.length) { // from class: com.google.common.collect.FluentIterable.3.1
                    @Override // com.google.common.collect.AbstractIndexedListIterator
                    /* renamed from: b */
                    public Iterator<? extends T> a(int i4) {
                        return iterableArr[i4].iterator();
                    }
                });
            }
        };
    }

    private Iterable<E> b() {
        return this.f26832a.or((Optional<Iterable<E>>) this);
    }

    public static <T> FluentIterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return a(iterable, iterable2);
    }

    public static <E> FluentIterable<E> from(final Iterable<E> iterable) {
        if (iterable instanceof FluentIterable) {
            return (FluentIterable) iterable;
        }
        return new FluentIterable<E>(iterable) { // from class: com.google.common.collect.FluentIterable.1
            @Override // java.lang.Iterable
            public Iterator<E> iterator() {
                return iterable.iterator();
            }
        };
    }

    public static <E> FluentIterable<E> of() {
        return from(Collections.emptyList());
    }

    public final boolean allMatch(Predicate<? super E> predicate) {
        return Iterables.all(b(), predicate);
    }

    public final boolean anyMatch(Predicate<? super E> predicate) {
        return Iterables.any(b(), predicate);
    }

    public final FluentIterable<E> append(Iterable<? extends E> iterable) {
        return concat(b(), iterable);
    }

    public final boolean contains(@CheckForNull Object obj) {
        return Iterables.contains(b(), obj);
    }

    @CanIgnoreReturnValue
    public final <C extends Collection<? super E>> C copyInto(C c4) {
        Preconditions.checkNotNull(c4);
        Iterable<E> b4 = b();
        if (b4 instanceof Collection) {
            c4.addAll((Collection) b4);
        } else {
            for (E e4 : b4) {
                c4.add(e4);
            }
        }
        return c4;
    }

    public final FluentIterable<E> cycle() {
        return from(Iterables.cycle(b()));
    }

    public final FluentIterable<E> filter(Predicate<? super E> predicate) {
        return from(Iterables.filter(b(), predicate));
    }

    public final Optional<E> first() {
        Iterator<E> it = b().iterator();
        if (it.hasNext()) {
            return Optional.of(it.next());
        }
        return Optional.absent();
    }

    public final Optional<E> firstMatch(Predicate<? super E> predicate) {
        return Iterables.tryFind(b(), predicate);
    }

    @ParametricNullness
    public final E get(int i4) {
        return (E) Iterables.get(b(), i4);
    }

    public final <K> ImmutableListMultimap<K, E> index(Function<? super E, K> function) {
        return Multimaps.index(b(), function);
    }

    public final boolean isEmpty() {
        return !b().iterator().hasNext();
    }

    public final String join(Joiner joiner) {
        return joiner.join(this);
    }

    public final Optional<E> last() {
        E next;
        Iterable<E> b4 = b();
        if (b4 instanceof List) {
            List list = (List) b4;
            if (list.isEmpty()) {
                return Optional.absent();
            }
            return Optional.of(list.get(list.size() - 1));
        }
        Iterator<E> it = b4.iterator();
        if (!it.hasNext()) {
            return Optional.absent();
        }
        if (b4 instanceof SortedSet) {
            return Optional.of(((SortedSet) b4).last());
        }
        do {
            next = it.next();
        } while (it.hasNext());
        return Optional.of(next);
    }

    public final FluentIterable<E> limit(int i4) {
        return from(Iterables.limit(b(), i4));
    }

    public final int size() {
        return Iterables.size(b());
    }

    public final FluentIterable<E> skip(int i4) {
        return from(Iterables.skip(b(), i4));
    }

    @GwtIncompatible
    public final E[] toArray(Class<E> cls) {
        return (E[]) Iterables.toArray(b(), cls);
    }

    public final ImmutableList<E> toList() {
        return ImmutableList.copyOf(b());
    }

    public final <V> ImmutableMap<E, V> toMap(Function<? super E, V> function) {
        return Maps.toMap(b(), function);
    }

    public final ImmutableMultiset<E> toMultiset() {
        return ImmutableMultiset.copyOf(b());
    }

    public final ImmutableSet<E> toSet() {
        return ImmutableSet.copyOf(b());
    }

    public final ImmutableList<E> toSortedList(Comparator<? super E> comparator) {
        return Ordering.from(comparator).immutableSortedCopy(b());
    }

    public final ImmutableSortedSet<E> toSortedSet(Comparator<? super E> comparator) {
        return ImmutableSortedSet.copyOf(comparator, b());
    }

    public String toString() {
        return Iterables.toString(b());
    }

    public final <T> FluentIterable<T> transform(Function<? super E, T> function) {
        return from(Iterables.transform(b(), function));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> FluentIterable<T> transformAndConcat(Function<? super E, ? extends Iterable<? extends T>> function) {
        return concat(transform(function));
    }

    public final <K> ImmutableMap<K, E> uniqueIndex(Function<? super E, K> function) {
        return Maps.uniqueIndex(b(), function);
    }

    public static <T> FluentIterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3) {
        return a(iterable, iterable2, iterable3);
    }

    public static <E> FluentIterable<E> of(@ParametricNullness E e4, E... eArr) {
        return from(Lists.asList(e4, eArr));
    }

    public final FluentIterable<E> append(E... eArr) {
        return concat(b(), Arrays.asList(eArr));
    }

    @GwtIncompatible
    public final <T> FluentIterable<T> filter(Class<T> cls) {
        return from(Iterables.filter((Iterable<?>) b(), (Class) cls));
    }

    FluentIterable(Iterable<E> iterable) {
        this.f26832a = Optional.of(iterable);
    }

    public static <T> FluentIterable<T> concat(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3, Iterable<? extends T> iterable4) {
        return a(iterable, iterable2, iterable3, iterable4);
    }

    public static <T> FluentIterable<T> concat(Iterable<? extends T>... iterableArr) {
        return a((Iterable[]) Arrays.copyOf(iterableArr, iterableArr.length));
    }

    public static <E> FluentIterable<E> from(E[] eArr) {
        return from(Arrays.asList(eArr));
    }

    public static <T> FluentIterable<T> concat(final Iterable<? extends Iterable<? extends T>> iterable) {
        Preconditions.checkNotNull(iterable);
        return new FluentIterable<T>() { // from class: com.google.common.collect.FluentIterable.2
            @Override // java.lang.Iterable
            public Iterator<T> iterator() {
                return Iterators.concat(Iterators.transform(iterable.iterator(), new c()));
            }
        };
    }

    @InlineMe(replacement = "checkNotNull(iterable)", staticImports = {"com.google.common.base.Preconditions.checkNotNull"})
    @Deprecated
    public static <E> FluentIterable<E> from(FluentIterable<E> fluentIterable) {
        return (FluentIterable) Preconditions.checkNotNull(fluentIterable);
    }
}
