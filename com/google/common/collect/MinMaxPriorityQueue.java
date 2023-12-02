package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Queue;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class MinMaxPriorityQueue<E> extends AbstractQueue<E> {

    /* renamed from: a  reason: collision with root package name */
    private final MinMaxPriorityQueue<E>.Heap f27212a;

    /* renamed from: b  reason: collision with root package name */
    private final MinMaxPriorityQueue<E>.Heap f27213b;
    @VisibleForTesting

    /* renamed from: c  reason: collision with root package name */
    final int f27214c;

    /* renamed from: d  reason: collision with root package name */
    private Object[] f27215d;

    /* renamed from: e  reason: collision with root package name */
    private int f27216e;

    /* renamed from: f  reason: collision with root package name */
    private int f27217f;

    /* loaded from: classes5.dex */
    public static final class Builder<B> {

        /* renamed from: a  reason: collision with root package name */
        private final Comparator<B> f27218a;

        /* renamed from: b  reason: collision with root package name */
        private int f27219b;

        /* renamed from: c  reason: collision with root package name */
        private int f27220c;

        /* JADX INFO: Access modifiers changed from: private */
        public <T extends B> Ordering<T> c() {
            return Ordering.from(this.f27218a);
        }

        public <T extends B> MinMaxPriorityQueue<T> create() {
            return create(Collections.emptySet());
        }

        @CanIgnoreReturnValue
        public Builder<B> expectedSize(int i4) {
            boolean z3;
            if (i4 >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3);
            this.f27219b = i4;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<B> maximumSize(int i4) {
            boolean z3;
            if (i4 > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3);
            this.f27220c = i4;
            return this;
        }

        private Builder(Comparator<B> comparator) {
            this.f27219b = -1;
            this.f27220c = Integer.MAX_VALUE;
            this.f27218a = (Comparator) Preconditions.checkNotNull(comparator);
        }

        public <T extends B> MinMaxPriorityQueue<T> create(Iterable<? extends T> iterable) {
            MinMaxPriorityQueue<T> minMaxPriorityQueue = new MinMaxPriorityQueue<>(this, MinMaxPriorityQueue.k(this.f27219b, this.f27220c, iterable));
            for (T t3 : iterable) {
                minMaxPriorityQueue.offer(t3);
            }
            return minMaxPriorityQueue;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class Heap {

        /* renamed from: a  reason: collision with root package name */
        final Ordering<E> f27221a;
        @Weak

        /* renamed from: b  reason: collision with root package name */
        MinMaxPriorityQueue<E>.Heap f27222b;

        Heap(Ordering<E> ordering) {
            this.f27221a = ordering;
        }

        private int j(int i4) {
            return l(l(i4));
        }

        private int k(int i4) {
            return (i4 * 2) + 1;
        }

        private int l(int i4) {
            return (i4 - 1) / 2;
        }

        private int m(int i4) {
            return (i4 * 2) + 2;
        }

        void a(int i4, E e4) {
            Heap heap;
            int e5 = e(i4, e4);
            if (e5 == i4) {
                e5 = i4;
                heap = this;
            } else {
                heap = this.f27222b;
            }
            heap.b(e5, e4);
        }

        @CanIgnoreReturnValue
        int b(int i4, E e4) {
            while (i4 > 2) {
                int j4 = j(i4);
                Object f4 = MinMaxPriorityQueue.this.f(j4);
                if (((Ordering<E>) this.f27221a).compare(f4, e4) <= 0) {
                    break;
                }
                MinMaxPriorityQueue.this.f27215d[i4] = f4;
                i4 = j4;
            }
            MinMaxPriorityQueue.this.f27215d[i4] = e4;
            return i4;
        }

        int c(int i4, int i5) {
            return ((Ordering<E>) this.f27221a).compare(MinMaxPriorityQueue.this.f(i4), MinMaxPriorityQueue.this.f(i5));
        }

        int d(int i4, E e4) {
            int h4 = h(i4);
            if (h4 > 0 && ((Ordering<E>) this.f27221a).compare(MinMaxPriorityQueue.this.f(h4), e4) < 0) {
                MinMaxPriorityQueue.this.f27215d[i4] = MinMaxPriorityQueue.this.f(h4);
                MinMaxPriorityQueue.this.f27215d[h4] = e4;
                return h4;
            }
            return e(i4, e4);
        }

        int e(int i4, E e4) {
            int m4;
            if (i4 == 0) {
                MinMaxPriorityQueue.this.f27215d[0] = e4;
                return 0;
            }
            int l4 = l(i4);
            Object f4 = MinMaxPriorityQueue.this.f(l4);
            if (l4 != 0 && (m4 = m(l(l4))) != l4 && k(m4) >= MinMaxPriorityQueue.this.f27216e) {
                Object f5 = MinMaxPriorityQueue.this.f(m4);
                if (((Ordering<E>) this.f27221a).compare(f5, f4) < 0) {
                    l4 = m4;
                    f4 = f5;
                }
            }
            if (((Ordering<E>) this.f27221a).compare(f4, e4) < 0) {
                MinMaxPriorityQueue.this.f27215d[i4] = f4;
                MinMaxPriorityQueue.this.f27215d[l4] = e4;
                return l4;
            }
            MinMaxPriorityQueue.this.f27215d[i4] = e4;
            return i4;
        }

        int f(int i4) {
            while (true) {
                int i5 = i(i4);
                if (i5 > 0) {
                    MinMaxPriorityQueue.this.f27215d[i4] = MinMaxPriorityQueue.this.f(i5);
                    i4 = i5;
                } else {
                    return i4;
                }
            }
        }

        int g(int i4, int i5) {
            boolean z3;
            if (i4 >= MinMaxPriorityQueue.this.f27216e) {
                return -1;
            }
            if (i4 > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3);
            int min = Math.min(i4, MinMaxPriorityQueue.this.f27216e - i5) + i5;
            for (int i6 = i4 + 1; i6 < min; i6++) {
                if (c(i6, i4) < 0) {
                    i4 = i6;
                }
            }
            return i4;
        }

        int h(int i4) {
            return g(k(i4), 2);
        }

        int i(int i4) {
            int k4 = k(i4);
            if (k4 < 0) {
                return -1;
            }
            return g(k(k4), 4);
        }

        int n(E e4) {
            int m4;
            int l4 = l(MinMaxPriorityQueue.this.f27216e);
            if (l4 != 0 && (m4 = m(l(l4))) != l4 && k(m4) >= MinMaxPriorityQueue.this.f27216e) {
                Object f4 = MinMaxPriorityQueue.this.f(m4);
                if (((Ordering<E>) this.f27221a).compare(f4, e4) < 0) {
                    MinMaxPriorityQueue.this.f27215d[m4] = e4;
                    MinMaxPriorityQueue.this.f27215d[MinMaxPriorityQueue.this.f27216e] = f4;
                    return m4;
                }
            }
            return MinMaxPriorityQueue.this.f27216e;
        }

        @CheckForNull
        MoveDesc<E> o(int i4, int i5, E e4) {
            Object f4;
            int d4 = d(i5, e4);
            if (d4 == i5) {
                return null;
            }
            if (d4 < i4) {
                f4 = MinMaxPriorityQueue.this.f(i4);
            } else {
                f4 = MinMaxPriorityQueue.this.f(l(i4));
            }
            if (this.f27222b.b(d4, e4) >= i4) {
                return null;
            }
            return new MoveDesc<>(e4, f4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class MoveDesc<E> {

        /* renamed from: a  reason: collision with root package name */
        final E f27224a;

        /* renamed from: b  reason: collision with root package name */
        final E f27225b;

        MoveDesc(E e4, E e5) {
            this.f27224a = e4;
            this.f27225b = e5;
        }
    }

    /* loaded from: classes5.dex */
    private class QueueIterator implements Iterator<E> {

        /* renamed from: a  reason: collision with root package name */
        private int f27226a;

        /* renamed from: b  reason: collision with root package name */
        private int f27227b;

        /* renamed from: c  reason: collision with root package name */
        private int f27228c;
        @CheckForNull

        /* renamed from: d  reason: collision with root package name */
        private Queue<E> f27229d;
        @CheckForNull

        /* renamed from: e  reason: collision with root package name */
        private List<E> f27230e;
        @CheckForNull

        /* renamed from: f  reason: collision with root package name */
        private E f27231f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f27232g;

        private QueueIterator() {
            this.f27226a = -1;
            this.f27227b = -1;
            this.f27228c = MinMaxPriorityQueue.this.f27217f;
        }

        private void a() {
            if (MinMaxPriorityQueue.this.f27217f == this.f27228c) {
                return;
            }
            throw new ConcurrentModificationException();
        }

        private boolean b(Iterable<E> iterable, E e4) {
            Iterator<E> it = iterable.iterator();
            while (it.hasNext()) {
                if (it.next() == e4) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        private void c(int i4) {
            if (this.f27227b < i4) {
                if (this.f27230e != null) {
                    while (i4 < MinMaxPriorityQueue.this.size() && b(this.f27230e, MinMaxPriorityQueue.this.f(i4))) {
                        i4++;
                    }
                }
                this.f27227b = i4;
            }
        }

        private boolean d(Object obj) {
            for (int i4 = 0; i4 < MinMaxPriorityQueue.this.f27216e; i4++) {
                if (MinMaxPriorityQueue.this.f27215d[i4] == obj) {
                    MinMaxPriorityQueue.this.n(i4);
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            c(this.f27226a + 1);
            if (this.f27227b < MinMaxPriorityQueue.this.size()) {
                return true;
            }
            Queue<E> queue = this.f27229d;
            if (queue != null && !queue.isEmpty()) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            a();
            c(this.f27226a + 1);
            if (this.f27227b < MinMaxPriorityQueue.this.size()) {
                int i4 = this.f27227b;
                this.f27226a = i4;
                this.f27232g = true;
                return (E) MinMaxPriorityQueue.this.f(i4);
            }
            if (this.f27229d != null) {
                this.f27226a = MinMaxPriorityQueue.this.size();
                E poll = this.f27229d.poll();
                this.f27231f = poll;
                if (poll != null) {
                    this.f27232g = true;
                    return poll;
                }
            }
            throw new NoSuchElementException("iterator moved past last element in queue.");
        }

        @Override // java.util.Iterator
        public void remove() {
            CollectPreconditions.e(this.f27232g);
            a();
            this.f27232g = false;
            this.f27228c++;
            if (this.f27226a < MinMaxPriorityQueue.this.size()) {
                MoveDesc<E> n4 = MinMaxPriorityQueue.this.n(this.f27226a);
                if (n4 != null) {
                    if (this.f27229d == null || this.f27230e == null) {
                        this.f27229d = new ArrayDeque();
                        this.f27230e = new ArrayList(3);
                    }
                    if (!b(this.f27230e, n4.f27224a)) {
                        this.f27229d.add(n4.f27224a);
                    }
                    if (!b(this.f27229d, n4.f27225b)) {
                        this.f27230e.add(n4.f27225b);
                    }
                }
                this.f27226a--;
                this.f27227b--;
                return;
            }
            E e4 = this.f27231f;
            Objects.requireNonNull(e4);
            Preconditions.checkState(d(e4));
            this.f27231f = null;
        }
    }

    public static <E extends Comparable<E>> MinMaxPriorityQueue<E> create() {
        return new Builder(Ordering.natural()).create();
    }

    private int d() {
        int checkedMultiply;
        int length = this.f27215d.length;
        if (length < 64) {
            checkedMultiply = (length + 1) * 2;
        } else {
            checkedMultiply = IntMath.checkedMultiply(length / 2, 3);
        }
        return e(checkedMultiply, this.f27214c);
    }

    private static int e(int i4, int i5) {
        return Math.min(i4 - 1, i5) + 1;
    }

    public static Builder<Comparable> expectedSize(int i4) {
        return new Builder(Ordering.natural()).expectedSize(i4);
    }

    @CheckForNull
    private MoveDesc<E> g(int i4, E e4) {
        MinMaxPriorityQueue<E>.Heap j4 = j(i4);
        int f4 = j4.f(i4);
        int b4 = j4.b(f4, e4);
        if (b4 == f4) {
            return j4.o(i4, f4, e4);
        }
        if (b4 < i4) {
            return new MoveDesc<>(e4, f(i4));
        }
        return null;
    }

    private int h() {
        int i4 = this.f27216e;
        if (i4 != 1) {
            if (i4 == 2 || this.f27213b.c(1, 2) <= 0) {
                return 1;
            }
            return 2;
        }
        return 0;
    }

    private void i() {
        if (this.f27216e > this.f27215d.length) {
            Object[] objArr = new Object[d()];
            Object[] objArr2 = this.f27215d;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f27215d = objArr;
        }
    }

    private MinMaxPriorityQueue<E>.Heap j(int i4) {
        if (l(i4)) {
            return this.f27212a;
        }
        return this.f27213b;
    }

    @VisibleForTesting
    static int k(int i4, int i5, Iterable<?> iterable) {
        if (i4 == -1) {
            i4 = 11;
        }
        if (iterable instanceof Collection) {
            i4 = Math.max(i4, ((Collection) iterable).size());
        }
        return e(i4, i5);
    }

    @VisibleForTesting
    static boolean l(int i4) {
        boolean z3;
        int i5 = ~(~(i4 + 1));
        if (i5 > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, "negative index");
        if ((1431655765 & i5) > (i5 & (-1431655766))) {
            return true;
        }
        return false;
    }

    private E m(int i4) {
        E f4 = f(i4);
        n(i4);
        return f4;
    }

    public static Builder<Comparable> maximumSize(int i4) {
        return new Builder(Ordering.natural()).maximumSize(i4);
    }

    public static <B> Builder<B> orderedBy(Comparator<B> comparator) {
        return new Builder<>(comparator);
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    @CanIgnoreReturnValue
    public boolean add(E e4) {
        offer(e4);
        return true;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public boolean addAll(Collection<? extends E> collection) {
        boolean z3 = false;
        for (E e4 : collection) {
            offer(e4);
            z3 = true;
        }
        return z3;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        for (int i4 = 0; i4 < this.f27216e; i4++) {
            this.f27215d[i4] = null;
        }
        this.f27216e = 0;
    }

    public Comparator<? super E> comparator() {
        return this.f27212a.f27221a;
    }

    E f(int i4) {
        E e4 = (E) this.f27215d[i4];
        Objects.requireNonNull(e4);
        return e4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new QueueIterator();
    }

    @VisibleForTesting
    @CanIgnoreReturnValue
    @CheckForNull
    MoveDesc<E> n(int i4) {
        Preconditions.checkPositionIndex(i4, this.f27216e);
        this.f27217f++;
        int i5 = this.f27216e - 1;
        this.f27216e = i5;
        if (i5 == i4) {
            this.f27215d[i5] = null;
            return null;
        }
        E f4 = f(i5);
        int n4 = j(this.f27216e).n(f4);
        if (n4 == i4) {
            this.f27215d[this.f27216e] = null;
            return null;
        }
        E f5 = f(this.f27216e);
        this.f27215d[this.f27216e] = null;
        MoveDesc<E> g4 = g(i4, f5);
        if (n4 < i4) {
            if (g4 == null) {
                return new MoveDesc<>(f4, f5);
            }
            return new MoveDesc<>(f4, g4.f27225b);
        }
        return g4;
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    public boolean offer(E e4) {
        Preconditions.checkNotNull(e4);
        this.f27217f++;
        int i4 = this.f27216e;
        this.f27216e = i4 + 1;
        i();
        j(i4).a(i4, e4);
        if (this.f27216e <= this.f27214c || pollLast() != e4) {
            return true;
        }
        return false;
    }

    @Override // java.util.Queue
    @CheckForNull
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return f(0);
    }

    @CheckForNull
    public E peekFirst() {
        return peek();
    }

    @CheckForNull
    public E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return f(h());
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    @CheckForNull
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return m(0);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public E pollFirst() {
        return poll();
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public E pollLast() {
        if (isEmpty()) {
            return null;
        }
        return m(h());
    }

    @CanIgnoreReturnValue
    public E removeFirst() {
        return remove();
    }

    @CanIgnoreReturnValue
    public E removeLast() {
        if (!isEmpty()) {
            return m(h());
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.f27216e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @J2ktIncompatible
    public Object[] toArray() {
        int i4 = this.f27216e;
        Object[] objArr = new Object[i4];
        System.arraycopy(this.f27215d, 0, objArr, 0, i4);
        return objArr;
    }

    private MinMaxPriorityQueue(Builder<? super E> builder, int i4) {
        Ordering c4 = builder.c();
        MinMaxPriorityQueue<E>.Heap heap = new Heap(c4);
        this.f27212a = heap;
        MinMaxPriorityQueue<E>.Heap heap2 = new Heap(c4.reverse());
        this.f27213b = heap2;
        heap.f27222b = heap2;
        heap2.f27222b = heap;
        this.f27214c = ((Builder) builder).f27220c;
        this.f27215d = new Object[i4];
    }

    public static <E extends Comparable<E>> MinMaxPriorityQueue<E> create(Iterable<? extends E> iterable) {
        return new Builder(Ordering.natural()).create(iterable);
    }
}
