package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterators;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.annotation.CheckForNull;
import kotlin.text.Typography;
import net.bytebuddy.pool.TypePool;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class Iterators {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class ArrayItr<T> extends AbstractIndexedListIterator<T> {

        /* renamed from: e  reason: collision with root package name */
        static final UnmodifiableListIterator<Object> f27021e = new ArrayItr(new Object[0], 0, 0, 0);

        /* renamed from: c  reason: collision with root package name */
        private final T[] f27022c;

        /* renamed from: d  reason: collision with root package name */
        private final int f27023d;

        ArrayItr(T[] tArr, int i4, int i5, int i6) {
            super(i5, i6);
            this.f27022c = tArr;
            this.f27023d = i4;
        }

        @Override // com.google.common.collect.AbstractIndexedListIterator
        @ParametricNullness
        protected T a(int i4) {
            return this.f27022c[this.f27023d + i4];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class ConcatenatedIterator<T> implements Iterator<T> {
        @CheckForNull

        /* renamed from: a  reason: collision with root package name */
        private Iterator<? extends T> f27024a;

        /* renamed from: b  reason: collision with root package name */
        private Iterator<? extends T> f27025b = Iterators.f();
        @CheckForNull

        /* renamed from: c  reason: collision with root package name */
        private Iterator<? extends Iterator<? extends T>> f27026c;
        @CheckForNull

        /* renamed from: d  reason: collision with root package name */
        private Deque<Iterator<? extends Iterator<? extends T>>> f27027d;

        ConcatenatedIterator(Iterator<? extends Iterator<? extends T>> it) {
            this.f27026c = (Iterator) Preconditions.checkNotNull(it);
        }

        @CheckForNull
        private Iterator<? extends Iterator<? extends T>> a() {
            while (true) {
                Iterator<? extends Iterator<? extends T>> it = this.f27026c;
                if (it != null && it.hasNext()) {
                    return this.f27026c;
                }
                Deque<Iterator<? extends Iterator<? extends T>>> deque = this.f27027d;
                if (deque != null && !deque.isEmpty()) {
                    this.f27026c = this.f27027d.removeFirst();
                } else {
                    return null;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            while (!((Iterator) Preconditions.checkNotNull(this.f27025b)).hasNext()) {
                Iterator<? extends Iterator<? extends T>> a4 = a();
                this.f27026c = a4;
                if (a4 == null) {
                    return false;
                }
                Iterator<? extends T> next = a4.next();
                this.f27025b = next;
                if (next instanceof ConcatenatedIterator) {
                    ConcatenatedIterator concatenatedIterator = (ConcatenatedIterator) next;
                    this.f27025b = concatenatedIterator.f27025b;
                    if (this.f27027d == null) {
                        this.f27027d = new ArrayDeque();
                    }
                    this.f27027d.addFirst(this.f27026c);
                    if (concatenatedIterator.f27027d != null) {
                        while (!concatenatedIterator.f27027d.isEmpty()) {
                            this.f27027d.addFirst(concatenatedIterator.f27027d.removeLast());
                        }
                    }
                    this.f27026c = concatenatedIterator.f27026c;
                }
            }
            return true;
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public T next() {
            if (hasNext()) {
                Iterator<? extends T> it = this.f27025b;
                this.f27024a = it;
                return it.next();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            Iterator<? extends T> it = this.f27024a;
            if (it != null) {
                it.remove();
                this.f27024a = null;
                return;
            }
            throw new IllegalStateException("no calls to next() since the last call to remove()");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public enum EmptyModifiableIterator implements Iterator<Object> {
        INSTANCE;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            CollectPreconditions.e(false);
        }
    }

    /* loaded from: classes5.dex */
    private static class MergingIterator<T> extends UnmodifiableIterator<T> {

        /* renamed from: a  reason: collision with root package name */
        final Queue<PeekingIterator<T>> f27030a;

        public MergingIterator(Iterable<? extends Iterator<? extends T>> iterable, final Comparator<? super T> comparator) {
            this.f27030a = new PriorityQueue(2, new Comparator() { // from class: com.google.common.collect.e
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int b4;
                    b4 = Iterators.MergingIterator.b(comparator, (PeekingIterator) obj, (PeekingIterator) obj2);
                    return b4;
                }
            });
            for (Iterator<? extends T> it : iterable) {
                if (it.hasNext()) {
                    this.f27030a.add(Iterators.peekingIterator(it));
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ int b(Comparator comparator, PeekingIterator peekingIterator, PeekingIterator peekingIterator2) {
            return comparator.compare(peekingIterator.peek(), peekingIterator2.peek());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f27030a.isEmpty();
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public T next() {
            PeekingIterator<T> remove = this.f27030a.remove();
            T next = remove.next();
            if (remove.hasNext()) {
                this.f27030a.add(remove);
            }
            return next;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class PeekingImpl<E> implements PeekingIterator<E> {

        /* renamed from: a  reason: collision with root package name */
        private final Iterator<? extends E> f27031a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f27032b;
        @CheckForNull

        /* renamed from: c  reason: collision with root package name */
        private E f27033c;

        public PeekingImpl(Iterator<? extends E> it) {
            this.f27031a = (Iterator) Preconditions.checkNotNull(it);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.f27032b && !this.f27031a.hasNext()) {
                return false;
            }
            return true;
        }

        @Override // com.google.common.collect.PeekingIterator, java.util.Iterator
        @ParametricNullness
        public E next() {
            if (!this.f27032b) {
                return this.f27031a.next();
            }
            E e4 = (E) NullnessCasts.a(this.f27033c);
            this.f27032b = false;
            this.f27033c = null;
            return e4;
        }

        @Override // com.google.common.collect.PeekingIterator
        @ParametricNullness
        public E peek() {
            if (!this.f27032b) {
                this.f27033c = this.f27031a.next();
                this.f27032b = true;
            }
            return (E) NullnessCasts.a(this.f27033c);
        }

        @Override // com.google.common.collect.PeekingIterator, java.util.Iterator
        public void remove() {
            Preconditions.checkState(!this.f27032b, "Can't remove after you've peeked at next");
            this.f27031a.remove();
        }
    }

    private Iterators() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> ListIterator<T> a(Iterator<T> it) {
        return (ListIterator) it;
    }

    @CanIgnoreReturnValue
    public static <T> boolean addAll(Collection<T> collection, Iterator<? extends T> it) {
        Preconditions.checkNotNull(collection);
        Preconditions.checkNotNull(it);
        boolean z3 = false;
        while (it.hasNext()) {
            z3 |= collection.add(it.next());
        }
        return z3;
    }

    @CanIgnoreReturnValue
    public static int advance(Iterator<?> it, int i4) {
        boolean z3;
        Preconditions.checkNotNull(it);
        int i5 = 0;
        if (i4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "numberToAdvance must be nonnegative");
        while (i5 < i4 && it.hasNext()) {
            it.next();
            i5++;
        }
        return i5;
    }

    public static <T> boolean all(Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate);
        while (it.hasNext()) {
            if (!predicate.apply(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean any(Iterator<T> it, Predicate<? super T> predicate) {
        if (indexOf(it, predicate) != -1) {
            return true;
        }
        return false;
    }

    public static <T> Enumeration<T> asEnumeration(final Iterator<T> it) {
        Preconditions.checkNotNull(it);
        return new Enumeration<T>() { // from class: com.google.common.collect.Iterators.11
            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return it.hasNext();
            }

            @Override // java.util.Enumeration
            @ParametricNullness
            public T nextElement() {
                return (T) it.next();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(int i4) {
        if (i4 >= 0) {
            return;
        }
        throw new IndexOutOfBoundsException("position (" + i4 + ") must not be negative");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(Iterator<?> it) {
        Preconditions.checkNotNull(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> it, Iterator<? extends T> it2) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(it2);
        return concat(e(it, it2));
    }

    public static <T> Iterator<T> consumingIterator(final Iterator<T> it) {
        Preconditions.checkNotNull(it);
        return new UnmodifiableIterator<T>() { // from class: com.google.common.collect.Iterators.8
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override // java.util.Iterator
            @ParametricNullness
            public T next() {
                T t3 = (T) it.next();
                it.remove();
                return t3;
            }

            public String toString() {
                return "Iterators.consumingIterator(...)";
            }
        };
    }

    public static boolean contains(Iterator<?> it, @CheckForNull Object obj) {
        if (obj == null) {
            while (it.hasNext()) {
                if (it.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it.hasNext()) {
            if (obj.equals(it.next())) {
                return true;
            }
        }
        return false;
    }

    public static <T> Iterator<T> cycle(final Iterable<T> iterable) {
        Preconditions.checkNotNull(iterable);
        return new Iterator<T>() { // from class: com.google.common.collect.Iterators.2

            /* renamed from: a  reason: collision with root package name */
            Iterator<T> f27005a = Iterators.h();

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (!this.f27005a.hasNext() && !iterable.iterator().hasNext()) {
                    return false;
                }
                return true;
            }

            @Override // java.util.Iterator
            @ParametricNullness
            public T next() {
                if (!this.f27005a.hasNext()) {
                    Iterator<T> it = iterable.iterator();
                    this.f27005a = it;
                    if (!it.hasNext()) {
                        throw new NoSuchElementException();
                    }
                }
                return this.f27005a.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f27005a.remove();
            }
        };
    }

    static <T> Iterator<T> d(Iterator<? extends T>... itArr) {
        for (Iterator it : (Iterator[]) Preconditions.checkNotNull(itArr)) {
            Preconditions.checkNotNull(it);
        }
        return concat(e(itArr));
    }

    private static <I extends Iterator<?>> Iterator<I> e(final I... iArr) {
        return new UnmodifiableIterator<I>() { // from class: com.google.common.collect.Iterators.3

            /* renamed from: a  reason: collision with root package name */
            int f27007a = 0;

            /* JADX WARN: Incorrect return type in method signature: ()TI; */
            @Override // java.util.Iterator
            /* renamed from: a */
            public Iterator next() {
                if (hasNext()) {
                    Iterator it = iArr[this.f27007a];
                    Objects.requireNonNull(it);
                    Iterator it2 = it;
                    Iterator[] itArr = iArr;
                    int i4 = this.f27007a;
                    itArr[i4] = null;
                    this.f27007a = i4 + 1;
                    return it2;
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.f27007a < iArr.length) {
                    return true;
                }
                return false;
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0006  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean elementsEqual(java.util.Iterator<?> r3, java.util.Iterator<?> r4) {
        /*
        L0:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L1d
            boolean r0 = r4.hasNext()
            r1 = 0
            if (r0 != 0) goto Le
            return r1
        Le:
            java.lang.Object r0 = r3.next()
            java.lang.Object r2 = r4.next()
            boolean r0 = com.google.common.base.Objects.equal(r0, r2)
            if (r0 != 0) goto L0
            return r1
        L1d:
            boolean r3 = r4.hasNext()
            r3 = r3 ^ 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Iterators.elementsEqual(java.util.Iterator, java.util.Iterator):boolean");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> UnmodifiableIterator<T> f() {
        return g();
    }

    public static <T> UnmodifiableIterator<T> filter(final Iterator<T> it, final Predicate<? super T> predicate) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(predicate);
        return new AbstractIterator<T>() { // from class: com.google.common.collect.Iterators.5
            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            protected T a() {
                while (it.hasNext()) {
                    T t3 = (T) it.next();
                    if (predicate.apply(t3)) {
                        return t3;
                    }
                }
                return b();
            }
        };
    }

    @ParametricNullness
    public static <T> T find(Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(predicate);
        while (it.hasNext()) {
            T next = it.next();
            if (predicate.apply(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }

    @SafeVarargs
    public static <T> UnmodifiableIterator<T> forArray(T... tArr) {
        return i(tArr, 0, tArr.length, 0);
    }

    public static <T> UnmodifiableIterator<T> forEnumeration(final Enumeration<T> enumeration) {
        Preconditions.checkNotNull(enumeration);
        return new UnmodifiableIterator<T>() { // from class: com.google.common.collect.Iterators.10
            @Override // java.util.Iterator
            public boolean hasNext() {
                return enumeration.hasMoreElements();
            }

            @Override // java.util.Iterator
            @ParametricNullness
            public T next() {
                return (T) enumeration.nextElement();
            }
        };
    }

    public static int frequency(Iterator<?> it, @CheckForNull Object obj) {
        int i4 = 0;
        while (contains(it, obj)) {
            i4++;
        }
        return i4;
    }

    static <T> UnmodifiableListIterator<T> g() {
        return (UnmodifiableListIterator<T>) ArrayItr.f27021e;
    }

    @ParametricNullness
    public static <T> T get(Iterator<T> it, int i4) {
        b(i4);
        int advance = advance(it, i4);
        if (it.hasNext()) {
            return it.next();
        }
        throw new IndexOutOfBoundsException("position (" + i4 + ") must be less than the number of elements that remained (" + advance + ")");
    }

    @ParametricNullness
    public static <T> T getLast(Iterator<T> it) {
        T next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    @ParametricNullness
    public static <T> T getNext(Iterator<? extends T> it, @ParametricNullness T t3) {
        if (it.hasNext()) {
            return it.next();
        }
        return t3;
    }

    @ParametricNullness
    public static <T> T getOnlyElement(Iterator<T> it) {
        T next = it.next();
        if (it.hasNext()) {
            StringBuilder sb = new StringBuilder();
            sb.append("expected one element but was: <");
            sb.append(next);
            for (int i4 = 0; i4 < 4 && it.hasNext(); i4++) {
                sb.append(", ");
                sb.append(it.next());
            }
            if (it.hasNext()) {
                sb.append(", ...");
            }
            sb.append(Typography.greater);
            throw new IllegalArgumentException(sb.toString());
        }
        return next;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Iterator<T> h() {
        return EmptyModifiableIterator.INSTANCE;
    }

    static <T> UnmodifiableListIterator<T> i(T[] tArr, int i4, int i5, int i6) {
        boolean z3;
        if (i5 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3);
        Preconditions.checkPositionIndexes(i4, i4 + i5, tArr.length);
        Preconditions.checkPositionIndex(i6, i5);
        if (i5 == 0) {
            return g();
        }
        return new ArrayItr(tArr, i4, i5, i6);
    }

    public static <T> int indexOf(Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate, "predicate");
        int i4 = 0;
        while (it.hasNext()) {
            if (predicate.apply(it.next())) {
                return i4;
            }
            i4++;
        }
        return -1;
    }

    private static <T> UnmodifiableIterator<List<T>> j(final Iterator<T> it, final int i4, final boolean z3) {
        boolean z4;
        Preconditions.checkNotNull(it);
        if (i4 > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Preconditions.checkArgument(z4);
        return new UnmodifiableIterator<List<T>>() { // from class: com.google.common.collect.Iterators.4
            @Override // java.util.Iterator
            /* renamed from: a */
            public List<T> next() {
                if (hasNext()) {
                    Object[] objArr = new Object[i4];
                    int i5 = 0;
                    while (i5 < i4 && it.hasNext()) {
                        objArr[i5] = it.next();
                        i5++;
                    }
                    for (int i6 = i5; i6 < i4; i6++) {
                        objArr[i6] = null;
                    }
                    List<T> unmodifiableList = Collections.unmodifiableList(Arrays.asList(objArr));
                    if (!z3 && i5 != i4) {
                        return unmodifiableList.subList(0, i5);
                    }
                    return unmodifiableList;
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return it.hasNext();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CheckForNull
    public static <T> T k(Iterator<T> it) {
        if (it.hasNext()) {
            T next = it.next();
            it.remove();
            return next;
        }
        return null;
    }

    public static <T> Iterator<T> limit(final Iterator<T> it, final int i4) {
        boolean z3;
        Preconditions.checkNotNull(it);
        if (i4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "limit is negative");
        return new Iterator<T>() { // from class: com.google.common.collect.Iterators.7

            /* renamed from: a  reason: collision with root package name */
            private int f27015a;

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.f27015a < i4 && it.hasNext()) {
                    return true;
                }
                return false;
            }

            @Override // java.util.Iterator
            @ParametricNullness
            public T next() {
                if (hasNext()) {
                    this.f27015a++;
                    return (T) it.next();
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                it.remove();
            }
        };
    }

    public static <T> UnmodifiableIterator<T> mergeSorted(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
        Preconditions.checkNotNull(iterable, "iterators");
        Preconditions.checkNotNull(comparator, "comparator");
        return new MergingIterator(iterable, comparator);
    }

    public static <T> UnmodifiableIterator<List<T>> paddedPartition(Iterator<T> it, int i4) {
        return j(it, i4, true);
    }

    public static <T> UnmodifiableIterator<List<T>> partition(Iterator<T> it, int i4) {
        return j(it, i4, false);
    }

    public static <T> PeekingIterator<T> peekingIterator(Iterator<? extends T> it) {
        if (it instanceof PeekingImpl) {
            return (PeekingImpl) it;
        }
        return new PeekingImpl(it);
    }

    @CanIgnoreReturnValue
    public static boolean removeAll(Iterator<?> it, Collection<?> collection) {
        Preconditions.checkNotNull(collection);
        boolean z3 = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z3 = true;
            }
        }
        return z3;
    }

    @CanIgnoreReturnValue
    public static <T> boolean removeIf(Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(predicate);
        boolean z3 = false;
        while (it.hasNext()) {
            if (predicate.apply(it.next())) {
                it.remove();
                z3 = true;
            }
        }
        return z3;
    }

    @CanIgnoreReturnValue
    public static boolean retainAll(Iterator<?> it, Collection<?> collection) {
        Preconditions.checkNotNull(collection);
        boolean z3 = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z3 = true;
            }
        }
        return z3;
    }

    public static <T> UnmodifiableIterator<T> singletonIterator(@ParametricNullness final T t3) {
        return new UnmodifiableIterator<T>() { // from class: com.google.common.collect.Iterators.9

            /* renamed from: a  reason: collision with root package name */
            boolean f27019a;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return !this.f27019a;
            }

            @Override // java.util.Iterator
            @ParametricNullness
            public T next() {
                if (!this.f27019a) {
                    this.f27019a = true;
                    return (T) t3;
                }
                throw new NoSuchElementException();
            }
        };
    }

    public static int size(Iterator<?> it) {
        long j4 = 0;
        while (it.hasNext()) {
            it.next();
            j4++;
        }
        return Ints.saturatedCast(j4);
    }

    @GwtIncompatible
    public static <T> T[] toArray(Iterator<? extends T> it, Class<T> cls) {
        return (T[]) Iterables.toArray(Lists.newArrayList(it), cls);
    }

    public static String toString(Iterator<?> it) {
        StringBuilder sb = new StringBuilder();
        sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
        boolean z3 = true;
        while (it.hasNext()) {
            if (!z3) {
                sb.append(", ");
            }
            sb.append(it.next());
            z3 = false;
        }
        sb.append(']');
        return sb.toString();
    }

    public static <F, T> Iterator<T> transform(Iterator<F> it, final Function<? super F, ? extends T> function) {
        Preconditions.checkNotNull(function);
        return new TransformedIterator<F, T>(it) { // from class: com.google.common.collect.Iterators.6
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.TransformedIterator
            @ParametricNullness
            public T a(@ParametricNullness F f4) {
                return (T) function.apply(f4);
            }
        };
    }

    public static <T> Optional<T> tryFind(Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(predicate);
        while (it.hasNext()) {
            T next = it.next();
            if (predicate.apply(next)) {
                return Optional.of(next);
            }
        }
        return Optional.absent();
    }

    public static <T> UnmodifiableIterator<T> unmodifiableIterator(final Iterator<? extends T> it) {
        Preconditions.checkNotNull(it);
        if (it instanceof UnmodifiableIterator) {
            return (UnmodifiableIterator) it;
        }
        return new UnmodifiableIterator<T>() { // from class: com.google.common.collect.Iterators.1
            @Override // java.util.Iterator
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override // java.util.Iterator
            @ParametricNullness
            public T next() {
                return (T) it.next();
            }
        };
    }

    @SafeVarargs
    public static <T> Iterator<T> cycle(T... tArr) {
        return cycle(Lists.newArrayList(tArr));
    }

    @ParametricNullness
    public static <T> T getLast(Iterator<? extends T> it, @ParametricNullness T t3) {
        return it.hasNext() ? (T) getLast(it) : t3;
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> it, Iterator<? extends T> it2, Iterator<? extends T> it3) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(it2);
        Preconditions.checkNotNull(it3);
        return concat(e(it, it2, it3));
    }

    @GwtIncompatible
    public static <T> UnmodifiableIterator<T> filter(Iterator<?> it, Class<T> cls) {
        return filter(it, Predicates.instanceOf(cls));
    }

    @Deprecated
    public static <T> PeekingIterator<T> peekingIterator(PeekingIterator<T> peekingIterator) {
        return (PeekingIterator) Preconditions.checkNotNull(peekingIterator);
    }

    @Deprecated
    public static <T> UnmodifiableIterator<T> unmodifiableIterator(UnmodifiableIterator<T> unmodifiableIterator) {
        return (UnmodifiableIterator) Preconditions.checkNotNull(unmodifiableIterator);
    }

    @ParametricNullness
    public static <T> T get(Iterator<? extends T> it, int i4, @ParametricNullness T t3) {
        b(i4);
        advance(it, i4);
        return (T) getNext(it, t3);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Object] */
    @CheckForNull
    public static <T> T find(Iterator<? extends T> it, Predicate<? super T> predicate, @CheckForNull T t3) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(predicate);
        while (it.hasNext()) {
            T next = it.next();
            if (predicate.apply(next)) {
                return next;
            }
        }
        return t3;
    }

    public static <T> Iterator<T> concat(Iterator<? extends T> it, Iterator<? extends T> it2, Iterator<? extends T> it3, Iterator<? extends T> it4) {
        Preconditions.checkNotNull(it);
        Preconditions.checkNotNull(it2);
        Preconditions.checkNotNull(it3);
        Preconditions.checkNotNull(it4);
        return concat(e(it, it2, it3, it4));
    }

    @ParametricNullness
    public static <T> T getOnlyElement(Iterator<? extends T> it, @ParametricNullness T t3) {
        return it.hasNext() ? (T) getOnlyElement(it) : t3;
    }

    public static <T> Iterator<T> concat(Iterator<? extends T>... itArr) {
        return d((Iterator[]) Arrays.copyOf(itArr, itArr.length));
    }

    public static <T> Iterator<T> concat(Iterator<? extends Iterator<? extends T>> it) {
        return new ConcatenatedIterator(it);
    }
}
