package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class TreeMultiset<E> extends AbstractSortedMultiset<E> implements Serializable {
    @J2ktIncompatible
    @GwtIncompatible
    private static final long serialVersionUID = 1;

    /* renamed from: d  reason: collision with root package name */
    private final transient Reference<AvlNode<E>> f27511d;

    /* renamed from: e  reason: collision with root package name */
    private final transient GeneralRange<E> f27512e;

    /* renamed from: f  reason: collision with root package name */
    private final transient AvlNode<E> f27513f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.common.collect.TreeMultiset$4  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f27522a;

        static {
            int[] iArr = new int[BoundType.values().length];
            f27522a = iArr;
            try {
                iArr[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f27522a[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public enum Aggregate {
        SIZE { // from class: com.google.common.collect.TreeMultiset.Aggregate.1
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            int b(AvlNode<?> avlNode) {
                return ((AvlNode) avlNode).f27527b;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            long c(@CheckForNull AvlNode<?> avlNode) {
                if (avlNode != null) {
                    return ((AvlNode) avlNode).f27529d;
                }
                return 0L;
            }
        },
        DISTINCT { // from class: com.google.common.collect.TreeMultiset.Aggregate.2
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            int b(AvlNode<?> avlNode) {
                return 1;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            long c(@CheckForNull AvlNode<?> avlNode) {
                if (avlNode == null) {
                    return 0L;
                }
                return ((AvlNode) avlNode).f27528c;
            }
        };

        abstract int b(AvlNode<?> avlNode);

        abstract long c(@CheckForNull AvlNode<?> avlNode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class Reference<T> {
        @CheckForNull

        /* renamed from: a  reason: collision with root package name */
        private T f27535a;

        private Reference() {
        }

        public void a(@CheckForNull T t3, @CheckForNull T t4) {
            if (this.f27535a == t3) {
                this.f27535a = t4;
                return;
            }
            throw new ConcurrentModificationException();
        }

        void b() {
            this.f27535a = null;
        }

        @CheckForNull
        public T c() {
            return this.f27535a;
        }
    }

    TreeMultiset(Reference<AvlNode<E>> reference, GeneralRange<E> generalRange, AvlNode<E> avlNode) {
        super(generalRange.b());
        this.f27511d = reference;
        this.f27512e = generalRange;
        this.f27513f = avlNode;
    }

    public static <E extends Comparable> TreeMultiset<E> create() {
        return new TreeMultiset<>(Ordering.natural());
    }

    private long q(Aggregate aggregate, @CheckForNull AvlNode<E> avlNode) {
        long c4;
        long q4;
        if (avlNode == null) {
            return 0L;
        }
        int compare = comparator().compare(NullnessCasts.a(this.f27512e.i()), avlNode.x());
        if (compare > 0) {
            return q(aggregate, ((AvlNode) avlNode).f27532g);
        }
        if (compare == 0) {
            int i4 = AnonymousClass4.f27522a[this.f27512e.h().ordinal()];
            if (i4 != 1) {
                if (i4 == 2) {
                    return aggregate.c(((AvlNode) avlNode).f27532g);
                }
                throw new AssertionError();
            }
            c4 = aggregate.b(avlNode);
            q4 = aggregate.c(((AvlNode) avlNode).f27532g);
        } else {
            c4 = aggregate.c(((AvlNode) avlNode).f27532g) + aggregate.b(avlNode);
            q4 = q(aggregate, ((AvlNode) avlNode).f27531f);
        }
        return c4 + q4;
    }

    private long r(Aggregate aggregate, @CheckForNull AvlNode<E> avlNode) {
        long c4;
        long r4;
        if (avlNode == null) {
            return 0L;
        }
        int compare = comparator().compare(NullnessCasts.a(this.f27512e.g()), avlNode.x());
        if (compare < 0) {
            return r(aggregate, ((AvlNode) avlNode).f27531f);
        }
        if (compare == 0) {
            int i4 = AnonymousClass4.f27522a[this.f27512e.f().ordinal()];
            if (i4 != 1) {
                if (i4 == 2) {
                    return aggregate.c(((AvlNode) avlNode).f27531f);
                }
                throw new AssertionError();
            }
            c4 = aggregate.b(avlNode);
            r4 = aggregate.c(((AvlNode) avlNode).f27531f);
        } else {
            c4 = aggregate.c(((AvlNode) avlNode).f27531f) + aggregate.b(avlNode);
            r4 = r(aggregate, ((AvlNode) avlNode).f27532g);
        }
        return c4 + r4;
    }

    @J2ktIncompatible
    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        Serialization.a(AbstractSortedMultiset.class, "comparator").b(this, comparator);
        Serialization.a(TreeMultiset.class, "range").b(this, GeneralRange.a(comparator));
        Serialization.a(TreeMultiset.class, "rootReference").b(this, new Reference());
        AvlNode avlNode = new AvlNode();
        Serialization.a(TreeMultiset.class, "header").b(this, avlNode);
        w(avlNode, avlNode);
        Serialization.f(this, objectInputStream);
    }

    private long s(Aggregate aggregate) {
        AvlNode<E> c4 = this.f27511d.c();
        long c5 = aggregate.c(c4);
        if (this.f27512e.j()) {
            c5 -= r(aggregate, c4);
        }
        if (this.f27512e.l()) {
            return c5 - q(aggregate, c4);
        }
        return c5;
    }

    static int t(@CheckForNull AvlNode<?> avlNode) {
        if (avlNode != null) {
            return ((AvlNode) avlNode).f27528c;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CheckForNull
    public AvlNode<E> u() {
        AvlNode<E> L;
        AvlNode<E> c4 = this.f27511d.c();
        if (c4 == null) {
            return null;
        }
        if (!this.f27512e.j()) {
            L = this.f27513f.L();
        } else {
            Object a4 = NullnessCasts.a(this.f27512e.g());
            L = c4.s(comparator(), a4);
            if (L == null) {
                return null;
            }
            if (this.f27512e.f() == BoundType.OPEN && comparator().compare(a4, L.x()) == 0) {
                L = L.L();
            }
        }
        if (L == this.f27513f || !this.f27512e.c(L.x())) {
            return null;
        }
        return L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CheckForNull
    public AvlNode<E> v() {
        AvlNode<E> z3;
        AvlNode<E> c4 = this.f27511d.c();
        if (c4 == null) {
            return null;
        }
        if (!this.f27512e.l()) {
            z3 = this.f27513f.z();
        } else {
            Object a4 = NullnessCasts.a(this.f27512e.i());
            z3 = c4.v(comparator(), a4);
            if (z3 == null) {
                return null;
            }
            if (this.f27512e.h() == BoundType.OPEN && comparator().compare(a4, z3.x()) == 0) {
                z3 = z3.z();
            }
        }
        if (z3 == this.f27513f || !this.f27512e.c(z3.x())) {
            return null;
        }
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void w(AvlNode<T> avlNode, AvlNode<T> avlNode2) {
        ((AvlNode) avlNode).f27534i = avlNode2;
        ((AvlNode) avlNode2).f27533h = avlNode;
    }

    @J2ktIncompatible
    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(elementSet().comparator());
        Serialization.k(this, objectOutputStream);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> void x(AvlNode<T> avlNode, AvlNode<T> avlNode2, AvlNode<T> avlNode3) {
        w(avlNode, avlNode2);
        w(avlNode2, avlNode3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Multiset.Entry<E> y(final AvlNode<E> avlNode) {
        return new Multisets.AbstractEntry<E>() { // from class: com.google.common.collect.TreeMultiset.1
            @Override // com.google.common.collect.Multiset.Entry
            public int getCount() {
                int w3 = avlNode.w();
                if (w3 == 0) {
                    return TreeMultiset.this.count(getElement());
                }
                return w3;
            }

            @Override // com.google.common.collect.Multiset.Entry
            @ParametricNullness
            public E getElement() {
                return (E) avlNode.x();
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int add(@ParametricNullness E e4, int i4) {
        CollectPreconditions.b(i4, "occurrences");
        if (i4 == 0) {
            return count(e4);
        }
        Preconditions.checkArgument(this.f27512e.c(e4));
        AvlNode<E> c4 = this.f27511d.c();
        if (c4 == null) {
            comparator().compare(e4, e4);
            AvlNode<E> avlNode = new AvlNode<>(e4, i4);
            AvlNode<E> avlNode2 = this.f27513f;
            x(avlNode2, avlNode, avlNode2);
            this.f27511d.a(c4, avlNode);
            return 0;
        }
        int[] iArr = new int[1];
        this.f27511d.a(c4, c4.o(comparator(), e4, i4, iArr));
        return iArr[0];
    }

    @Override // com.google.common.collect.AbstractMultiset
    int b() {
        return Ints.saturatedCast(s(Aggregate.DISTINCT));
    }

    @Override // com.google.common.collect.AbstractMultiset
    Iterator<E> c() {
        return Multisets.e(e());
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        if (!this.f27512e.j() && !this.f27512e.l()) {
            AvlNode<E> L = this.f27513f.L();
            while (true) {
                AvlNode<E> avlNode = this.f27513f;
                if (L != avlNode) {
                    AvlNode<E> L2 = L.L();
                    ((AvlNode) L).f27527b = 0;
                    ((AvlNode) L).f27531f = null;
                    ((AvlNode) L).f27532g = null;
                    ((AvlNode) L).f27533h = null;
                    ((AvlNode) L).f27534i = null;
                    L = L2;
                } else {
                    w(avlNode, avlNode);
                    this.f27511d.b();
                    return;
                }
            }
        } else {
            Iterators.c(e());
        }
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(@CheckForNull Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@CheckForNull Object obj) {
        try {
            AvlNode<E> c4 = this.f27511d.c();
            if (this.f27512e.c(obj) && c4 != null) {
                return c4.t(comparator(), obj);
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset descendingMultiset() {
        return super.descendingMultiset();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMultiset
    public Iterator<Multiset.Entry<E>> e() {
        return new Iterator<Multiset.Entry<E>>() { // from class: com.google.common.collect.TreeMultiset.2
            @CheckForNull

            /* renamed from: a  reason: collision with root package name */
            AvlNode<E> f27516a;
            @CheckForNull

            /* renamed from: b  reason: collision with root package name */
            Multiset.Entry<E> f27517b;

            {
                this.f27516a = TreeMultiset.this.u();
            }

            @Override // java.util.Iterator
            /* renamed from: a */
            public Multiset.Entry<E> next() {
                if (hasNext()) {
                    TreeMultiset treeMultiset = TreeMultiset.this;
                    AvlNode<E> avlNode = this.f27516a;
                    Objects.requireNonNull(avlNode);
                    Multiset.Entry<E> y3 = treeMultiset.y(avlNode);
                    this.f27517b = y3;
                    if (this.f27516a.L() == TreeMultiset.this.f27513f) {
                        this.f27516a = null;
                    } else {
                        this.f27516a = this.f27516a.L();
                    }
                    return y3;
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.f27516a == null) {
                    return false;
                }
                if (TreeMultiset.this.f27512e.n(this.f27516a.x())) {
                    this.f27516a = null;
                    return false;
                }
                return true;
            }

            @Override // java.util.Iterator
            public void remove() {
                boolean z3;
                if (this.f27517b != null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Preconditions.checkState(z3, "no calls to next() since the last call to remove()");
                TreeMultiset.this.setCount(this.f27517b.getElement(), 0);
                this.f27517b = null;
            }
        };
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return super.elementSet();
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    @CheckForNull
    public /* bridge */ /* synthetic */ Multiset.Entry firstEntry() {
        return super.firstEntry();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset
    Iterator<Multiset.Entry<E>> h() {
        return new Iterator<Multiset.Entry<E>>() { // from class: com.google.common.collect.TreeMultiset.3
            @CheckForNull

            /* renamed from: a  reason: collision with root package name */
            AvlNode<E> f27519a;
            @CheckForNull

            /* renamed from: b  reason: collision with root package name */
            Multiset.Entry<E> f27520b = null;

            {
                this.f27519a = TreeMultiset.this.v();
            }

            @Override // java.util.Iterator
            /* renamed from: a */
            public Multiset.Entry<E> next() {
                if (hasNext()) {
                    Objects.requireNonNull(this.f27519a);
                    Multiset.Entry<E> y3 = TreeMultiset.this.y(this.f27519a);
                    this.f27520b = y3;
                    if (this.f27519a.z() == TreeMultiset.this.f27513f) {
                        this.f27519a = null;
                    } else {
                        this.f27519a = this.f27519a.z();
                    }
                    return y3;
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.f27519a == null) {
                    return false;
                }
                if (TreeMultiset.this.f27512e.o(this.f27519a.x())) {
                    this.f27519a = null;
                    return false;
                }
                return true;
            }

            @Override // java.util.Iterator
            public void remove() {
                boolean z3;
                if (this.f27520b != null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Preconditions.checkState(z3, "no calls to next() since the last call to remove()");
                TreeMultiset.this.setCount(this.f27520b.getElement(), 0);
                this.f27520b = null;
            }
        };
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> headMultiset(@ParametricNullness E e4, BoundType boundType) {
        return new TreeMultiset(this.f27511d, this.f27512e.m(GeneralRange.p(comparator(), e4, boundType)), this.f27513f);
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public Iterator<E> iterator() {
        return Multisets.h(this);
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    @CheckForNull
    public /* bridge */ /* synthetic */ Multiset.Entry lastEntry() {
        return super.lastEntry();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    @CheckForNull
    public /* bridge */ /* synthetic */ Multiset.Entry pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    @CheckForNull
    public /* bridge */ /* synthetic */ Multiset.Entry pollLastEntry() {
        return super.pollLastEntry();
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int remove(@CheckForNull Object obj, int i4) {
        CollectPreconditions.b(i4, "occurrences");
        if (i4 == 0) {
            return count(obj);
        }
        AvlNode<E> c4 = this.f27511d.c();
        int[] iArr = new int[1];
        try {
            if (this.f27512e.c(obj) && c4 != null) {
                this.f27511d.a(c4, c4.E(comparator(), obj, i4, iArr));
                return iArr[0];
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int setCount(@ParametricNullness E e4, int i4) {
        CollectPreconditions.b(i4, "count");
        if (!this.f27512e.c(e4)) {
            Preconditions.checkArgument(i4 == 0);
            return 0;
        }
        AvlNode<E> c4 = this.f27511d.c();
        if (c4 == null) {
            if (i4 > 0) {
                add(e4, i4);
            }
            return 0;
        }
        int[] iArr = new int[1];
        this.f27511d.a(c4, c4.K(comparator(), e4, i4, iArr));
        return iArr[0];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return Ints.saturatedCast(s(Aggregate.SIZE));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset subMultiset(@ParametricNullness Object obj, BoundType boundType, @ParametricNullness Object obj2, BoundType boundType2) {
        return super.subMultiset(obj, boundType, obj2, boundType2);
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset<E> tailMultiset(@ParametricNullness E e4, BoundType boundType) {
        return new TreeMultiset(this.f27511d, this.f27512e.m(GeneralRange.e(comparator(), e4, boundType)), this.f27513f);
    }

    public static <E> TreeMultiset<E> create(@CheckForNull Comparator<? super E> comparator) {
        if (comparator == null) {
            return new TreeMultiset<>(Ordering.natural());
        }
        return new TreeMultiset<>(comparator);
    }

    public static <E extends Comparable> TreeMultiset<E> create(Iterable<? extends E> iterable) {
        TreeMultiset<E> create = create();
        Iterables.addAll(create, iterable);
        return create;
    }

    TreeMultiset(Comparator<? super E> comparator) {
        super(comparator);
        this.f27512e = GeneralRange.a(comparator);
        AvlNode<E> avlNode = new AvlNode<>();
        this.f27513f = avlNode;
        w(avlNode, avlNode);
        this.f27511d = new Reference<>();
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public boolean setCount(@ParametricNullness E e4, int i4, int i5) {
        CollectPreconditions.b(i5, "newCount");
        CollectPreconditions.b(i4, "oldCount");
        Preconditions.checkArgument(this.f27512e.c(e4));
        AvlNode<E> c4 = this.f27511d.c();
        if (c4 != null) {
            int[] iArr = new int[1];
            this.f27511d.a(c4, c4.J(comparator(), e4, i4, i5, iArr));
            return iArr[0] == i4;
        } else if (i4 == 0) {
            if (i5 > 0) {
                add(e4, i5);
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class AvlNode<E> {
        @CheckForNull

        /* renamed from: a  reason: collision with root package name */
        private final E f27526a;

        /* renamed from: b  reason: collision with root package name */
        private int f27527b;

        /* renamed from: c  reason: collision with root package name */
        private int f27528c;

        /* renamed from: d  reason: collision with root package name */
        private long f27529d;

        /* renamed from: e  reason: collision with root package name */
        private int f27530e;
        @CheckForNull

        /* renamed from: f  reason: collision with root package name */
        private AvlNode<E> f27531f;
        @CheckForNull

        /* renamed from: g  reason: collision with root package name */
        private AvlNode<E> f27532g;
        @CheckForNull

        /* renamed from: h  reason: collision with root package name */
        private AvlNode<E> f27533h;
        @CheckForNull

        /* renamed from: i  reason: collision with root package name */
        private AvlNode<E> f27534i;

        AvlNode(@ParametricNullness E e4, int i4) {
            Preconditions.checkArgument(i4 > 0);
            this.f27526a = e4;
            this.f27527b = i4;
            this.f27529d = i4;
            this.f27528c = 1;
            this.f27530e = 1;
            this.f27531f = null;
            this.f27532g = null;
        }

        private AvlNode<E> A() {
            int r4 = r();
            if (r4 != -2) {
                if (r4 != 2) {
                    C();
                    return this;
                }
                Objects.requireNonNull(this.f27531f);
                if (this.f27531f.r() < 0) {
                    this.f27531f = this.f27531f.H();
                }
                return I();
            }
            Objects.requireNonNull(this.f27532g);
            if (this.f27532g.r() > 0) {
                this.f27532g = this.f27532g.I();
            }
            return H();
        }

        private void B() {
            D();
            C();
        }

        private void C() {
            this.f27530e = Math.max(y(this.f27531f), y(this.f27532g)) + 1;
        }

        private void D() {
            this.f27528c = TreeMultiset.t(this.f27531f) + 1 + TreeMultiset.t(this.f27532g);
            this.f27529d = this.f27527b + M(this.f27531f) + M(this.f27532g);
        }

        @CheckForNull
        private AvlNode<E> F(AvlNode<E> avlNode) {
            AvlNode<E> avlNode2 = this.f27532g;
            if (avlNode2 == null) {
                return this.f27531f;
            }
            this.f27532g = avlNode2.F(avlNode);
            this.f27528c--;
            this.f27529d -= avlNode.f27527b;
            return A();
        }

        @CheckForNull
        private AvlNode<E> G(AvlNode<E> avlNode) {
            AvlNode<E> avlNode2 = this.f27531f;
            if (avlNode2 == null) {
                return this.f27532g;
            }
            this.f27531f = avlNode2.G(avlNode);
            this.f27528c--;
            this.f27529d -= avlNode.f27527b;
            return A();
        }

        private AvlNode<E> H() {
            boolean z3;
            if (this.f27532g != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3);
            AvlNode<E> avlNode = this.f27532g;
            this.f27532g = avlNode.f27531f;
            avlNode.f27531f = this;
            avlNode.f27529d = this.f27529d;
            avlNode.f27528c = this.f27528c;
            B();
            avlNode.C();
            return avlNode;
        }

        private AvlNode<E> I() {
            boolean z3;
            if (this.f27531f != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkState(z3);
            AvlNode<E> avlNode = this.f27531f;
            this.f27531f = avlNode.f27532g;
            avlNode.f27532g = this;
            avlNode.f27529d = this.f27529d;
            avlNode.f27528c = this.f27528c;
            B();
            avlNode.C();
            return avlNode;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AvlNode<E> L() {
            AvlNode<E> avlNode = this.f27534i;
            Objects.requireNonNull(avlNode);
            return avlNode;
        }

        private static long M(@CheckForNull AvlNode<?> avlNode) {
            if (avlNode == null) {
                return 0L;
            }
            return ((AvlNode) avlNode).f27529d;
        }

        private AvlNode<E> p(@ParametricNullness E e4, int i4) {
            this.f27531f = new AvlNode<>(e4, i4);
            TreeMultiset.x(z(), this.f27531f, this);
            this.f27530e = Math.max(2, this.f27530e);
            this.f27528c++;
            this.f27529d += i4;
            return this;
        }

        private AvlNode<E> q(@ParametricNullness E e4, int i4) {
            AvlNode<E> avlNode = new AvlNode<>(e4, i4);
            this.f27532g = avlNode;
            TreeMultiset.x(this, avlNode, L());
            this.f27530e = Math.max(2, this.f27530e);
            this.f27528c++;
            this.f27529d += i4;
            return this;
        }

        private int r() {
            return y(this.f27531f) - y(this.f27532g);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        @CheckForNull
        public AvlNode<E> s(Comparator<? super E> comparator, @ParametricNullness E e4) {
            int compare = comparator.compare(e4, x());
            if (compare < 0) {
                AvlNode<E> avlNode = this.f27531f;
                if (avlNode == null) {
                    return this;
                }
                return (AvlNode) MoreObjects.firstNonNull(avlNode.s(comparator, e4), this);
            } else if (compare == 0) {
                return this;
            } else {
                AvlNode<E> avlNode2 = this.f27532g;
                if (avlNode2 == null) {
                    return null;
                }
                return avlNode2.s(comparator, e4);
            }
        }

        @CheckForNull
        private AvlNode<E> u() {
            int i4 = this.f27527b;
            this.f27527b = 0;
            TreeMultiset.w(z(), L());
            AvlNode<E> avlNode = this.f27531f;
            if (avlNode == null) {
                return this.f27532g;
            }
            AvlNode<E> avlNode2 = this.f27532g;
            if (avlNode2 == null) {
                return avlNode;
            }
            if (avlNode.f27530e >= avlNode2.f27530e) {
                AvlNode<E> z3 = z();
                z3.f27531f = this.f27531f.F(z3);
                z3.f27532g = this.f27532g;
                z3.f27528c = this.f27528c - 1;
                z3.f27529d = this.f27529d - i4;
                return z3.A();
            }
            AvlNode<E> L = L();
            L.f27532g = this.f27532g.G(L);
            L.f27531f = this.f27531f;
            L.f27528c = this.f27528c - 1;
            L.f27529d = this.f27529d - i4;
            return L.A();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        @CheckForNull
        public AvlNode<E> v(Comparator<? super E> comparator, @ParametricNullness E e4) {
            int compare = comparator.compare(e4, x());
            if (compare > 0) {
                AvlNode<E> avlNode = this.f27532g;
                if (avlNode == null) {
                    return this;
                }
                return (AvlNode) MoreObjects.firstNonNull(avlNode.v(comparator, e4), this);
            } else if (compare == 0) {
                return this;
            } else {
                AvlNode<E> avlNode2 = this.f27531f;
                if (avlNode2 == null) {
                    return null;
                }
                return avlNode2.v(comparator, e4);
            }
        }

        private static int y(@CheckForNull AvlNode<?> avlNode) {
            if (avlNode == null) {
                return 0;
            }
            return ((AvlNode) avlNode).f27530e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AvlNode<E> z() {
            AvlNode<E> avlNode = this.f27533h;
            Objects.requireNonNull(avlNode);
            return avlNode;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CheckForNull
        AvlNode<E> E(Comparator<? super E> comparator, @ParametricNullness E e4, int i4, int[] iArr) {
            int compare = comparator.compare(e4, x());
            if (compare < 0) {
                AvlNode<E> avlNode = this.f27531f;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.f27531f = avlNode.E(comparator, e4, i4, iArr);
                int i5 = iArr[0];
                if (i5 > 0) {
                    if (i4 >= i5) {
                        this.f27528c--;
                        this.f27529d -= i5;
                    } else {
                        this.f27529d -= i4;
                    }
                }
                if (i5 == 0) {
                    return this;
                }
                return A();
            } else if (compare > 0) {
                AvlNode<E> avlNode2 = this.f27532g;
                if (avlNode2 == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.f27532g = avlNode2.E(comparator, e4, i4, iArr);
                int i6 = iArr[0];
                if (i6 > 0) {
                    if (i4 >= i6) {
                        this.f27528c--;
                        this.f27529d -= i6;
                    } else {
                        this.f27529d -= i4;
                    }
                }
                return A();
            } else {
                int i7 = this.f27527b;
                iArr[0] = i7;
                if (i4 >= i7) {
                    return u();
                }
                this.f27527b = i7 - i4;
                this.f27529d -= i4;
                return this;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CheckForNull
        AvlNode<E> J(Comparator<? super E> comparator, @ParametricNullness E e4, int i4, int i5, int[] iArr) {
            int compare = comparator.compare(e4, x());
            if (compare < 0) {
                AvlNode<E> avlNode = this.f27531f;
                if (avlNode == null) {
                    iArr[0] = 0;
                    if (i4 == 0 && i5 > 0) {
                        return p(e4, i5);
                    }
                    return this;
                }
                this.f27531f = avlNode.J(comparator, e4, i4, i5, iArr);
                int i6 = iArr[0];
                if (i6 == i4) {
                    if (i5 == 0 && i6 != 0) {
                        this.f27528c--;
                    } else if (i5 > 0 && i6 == 0) {
                        this.f27528c++;
                    }
                    this.f27529d += i5 - i6;
                }
                return A();
            } else if (compare > 0) {
                AvlNode<E> avlNode2 = this.f27532g;
                if (avlNode2 == null) {
                    iArr[0] = 0;
                    if (i4 == 0 && i5 > 0) {
                        return q(e4, i5);
                    }
                    return this;
                }
                this.f27532g = avlNode2.J(comparator, e4, i4, i5, iArr);
                int i7 = iArr[0];
                if (i7 == i4) {
                    if (i5 == 0 && i7 != 0) {
                        this.f27528c--;
                    } else if (i5 > 0 && i7 == 0) {
                        this.f27528c++;
                    }
                    this.f27529d += i5 - i7;
                }
                return A();
            } else {
                int i8 = this.f27527b;
                iArr[0] = i8;
                if (i4 == i8) {
                    if (i5 == 0) {
                        return u();
                    }
                    this.f27529d += i5 - i8;
                    this.f27527b = i5;
                }
                return this;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @CheckForNull
        AvlNode<E> K(Comparator<? super E> comparator, @ParametricNullness E e4, int i4, int[] iArr) {
            int i5;
            int compare = comparator.compare(e4, x());
            if (compare < 0) {
                AvlNode<E> avlNode = this.f27531f;
                if (avlNode == null) {
                    iArr[0] = 0;
                    if (i4 > 0) {
                        return p(e4, i4);
                    }
                    return this;
                }
                this.f27531f = avlNode.K(comparator, e4, i4, iArr);
                if (i4 == 0 && iArr[0] != 0) {
                    this.f27528c--;
                } else if (i4 > 0 && iArr[0] == 0) {
                    this.f27528c++;
                }
                this.f27529d += i4 - iArr[0];
                return A();
            } else if (compare > 0) {
                AvlNode<E> avlNode2 = this.f27532g;
                if (avlNode2 == null) {
                    iArr[0] = 0;
                    if (i4 > 0) {
                        return q(e4, i4);
                    }
                    return this;
                }
                this.f27532g = avlNode2.K(comparator, e4, i4, iArr);
                if (i4 == 0 && iArr[0] != 0) {
                    this.f27528c--;
                } else if (i4 > 0 && iArr[0] == 0) {
                    this.f27528c++;
                }
                this.f27529d += i4 - iArr[0];
                return A();
            } else {
                iArr[0] = this.f27527b;
                if (i4 == 0) {
                    return u();
                }
                this.f27529d += i4 - i5;
                this.f27527b = i4;
                return this;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        AvlNode<E> o(Comparator<? super E> comparator, @ParametricNullness E e4, int i4, int[] iArr) {
            int compare = comparator.compare(e4, x());
            boolean z3 = true;
            if (compare < 0) {
                AvlNode<E> avlNode = this.f27531f;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return p(e4, i4);
                }
                int i5 = avlNode.f27530e;
                AvlNode<E> o4 = avlNode.o(comparator, e4, i4, iArr);
                this.f27531f = o4;
                if (iArr[0] == 0) {
                    this.f27528c++;
                }
                this.f27529d += i4;
                if (o4.f27530e == i5) {
                    return this;
                }
                return A();
            } else if (compare > 0) {
                AvlNode<E> avlNode2 = this.f27532g;
                if (avlNode2 == null) {
                    iArr[0] = 0;
                    return q(e4, i4);
                }
                int i6 = avlNode2.f27530e;
                AvlNode<E> o5 = avlNode2.o(comparator, e4, i4, iArr);
                this.f27532g = o5;
                if (iArr[0] == 0) {
                    this.f27528c++;
                }
                this.f27529d += i4;
                if (o5.f27530e == i6) {
                    return this;
                }
                return A();
            } else {
                int i7 = this.f27527b;
                iArr[0] = i7;
                long j4 = i4;
                if (i7 + j4 > 2147483647L) {
                    z3 = false;
                }
                Preconditions.checkArgument(z3);
                this.f27527b += i4;
                this.f27529d += j4;
                return this;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        int t(Comparator<? super E> comparator, @ParametricNullness E e4) {
            int compare = comparator.compare(e4, x());
            if (compare < 0) {
                AvlNode<E> avlNode = this.f27531f;
                if (avlNode == null) {
                    return 0;
                }
                return avlNode.t(comparator, e4);
            } else if (compare > 0) {
                AvlNode<E> avlNode2 = this.f27532g;
                if (avlNode2 == null) {
                    return 0;
                }
                return avlNode2.t(comparator, e4);
            } else {
                return this.f27527b;
            }
        }

        public String toString() {
            return Multisets.immutableEntry(x(), w()).toString();
        }

        int w() {
            return this.f27527b;
        }

        @ParametricNullness
        E x() {
            return (E) NullnessCasts.a(this.f27526a);
        }

        AvlNode() {
            this.f27526a = null;
            this.f27527b = 1;
        }
    }
}
