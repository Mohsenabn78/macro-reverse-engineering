package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.SortedLists;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class ImmutableRangeSet<C extends Comparable> extends AbstractRangeSet<C> implements Serializable {

    /* renamed from: c  reason: collision with root package name */
    private static final ImmutableRangeSet<Comparable<?>> f26939c = new ImmutableRangeSet<>(ImmutableList.of());

    /* renamed from: d  reason: collision with root package name */
    private static final ImmutableRangeSet<Comparable<?>> f26940d = new ImmutableRangeSet<>(ImmutableList.of(Range.all()));

    /* renamed from: a  reason: collision with root package name */
    private final transient ImmutableList<Range<C>> f26941a;
    @CheckForNull
    @LazyInit

    /* renamed from: b  reason: collision with root package name */
    private transient ImmutableRangeSet<C> f26942b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class AsSet extends ImmutableSortedSet<C> {
        private final DiscreteDomain<C> domain;
        @CheckForNull

        /* renamed from: e  reason: collision with root package name */
        private transient Integer f26943e;

        AsSet(DiscreteDomain<C> discreteDomain) {
            super(Ordering.natural());
            this.domain = discreteDomain;
        }

        @J2ktIncompatible
        private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("Use SerializedForm");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableSortedSet
        /* renamed from: A */
        public ImmutableSortedSet<C> t(C c4, boolean z3) {
            return y(Range.downTo(c4, BoundType.b(z3)));
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@CheckForNull Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                return ImmutableRangeSet.this.contains((Comparable) obj);
            } catch (ClassCastException unused) {
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean f() {
            return ImmutableRangeSet.this.f26941a.f();
        }

        @Override // com.google.common.collect.ImmutableSortedSet
        ImmutableSortedSet<C> p() {
            return new DescendingImmutableSortedSet(this);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            Integer num = this.f26943e;
            if (num == null) {
                UnmodifiableIterator it = ImmutableRangeSet.this.f26941a.iterator();
                long j4 = 0;
                while (it.hasNext()) {
                    j4 += ContiguousSet.create((Range) it.next(), this.domain).size();
                    if (j4 >= 2147483647L) {
                        break;
                    }
                }
                num = Integer.valueOf(Ints.saturatedCast(j4));
                this.f26943e = num;
            }
            return num.intValue();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            return ImmutableRangeSet.this.f26941a.toString();
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        @J2ktIncompatible
        Object writeReplace() {
            return new AsSetSerializedForm(ImmutableRangeSet.this.f26941a, this.domain);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableSortedSet
        /* renamed from: x */
        public ImmutableSortedSet<C> r(C c4, boolean z3) {
            return y(Range.upTo(c4, BoundType.b(z3)));
        }

        ImmutableSortedSet<C> y(Range<C> range) {
            return ImmutableRangeSet.this.subRangeSet((Range) range).asSet(this.domain);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableSortedSet
        /* renamed from: z */
        public ImmutableSortedSet<C> s(C c4, boolean z3, C c5, boolean z4) {
            if (!z3 && !z4 && Range.a(c4, c5) == 0) {
                return ImmutableSortedSet.of();
            }
            return y(Range.range(c4, BoundType.b(z3), c5, BoundType.b(z4)));
        }

        @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
        @GwtIncompatible("NavigableSet")
        public UnmodifiableIterator<C> descendingIterator() {
            return new AbstractIterator<C>() { // from class: com.google.common.collect.ImmutableRangeSet.AsSet.2

                /* renamed from: c  reason: collision with root package name */
                final Iterator<Range<C>> f26947c;

                /* renamed from: d  reason: collision with root package name */
                Iterator<C> f26948d = Iterators.f();

                {
                    this.f26947c = ImmutableRangeSet.this.f26941a.reverse().iterator();
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractIterator
                @CheckForNull
                /* renamed from: d */
                public C a() {
                    while (!this.f26948d.hasNext()) {
                        if (this.f26947c.hasNext()) {
                            this.f26948d = ContiguousSet.create(this.f26947c.next(), AsSet.this.domain).descendingIterator();
                        } else {
                            return (C) b();
                        }
                    }
                    return this.f26948d.next();
                }
            };
        }

        @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        public UnmodifiableIterator<C> iterator() {
            return new AbstractIterator<C>() { // from class: com.google.common.collect.ImmutableRangeSet.AsSet.1

                /* renamed from: c  reason: collision with root package name */
                final Iterator<Range<C>> f26944c;

                /* renamed from: d  reason: collision with root package name */
                Iterator<C> f26945d = Iterators.f();

                {
                    this.f26944c = ImmutableRangeSet.this.f26941a.iterator();
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractIterator
                @CheckForNull
                /* renamed from: d */
                public C a() {
                    while (!this.f26945d.hasNext()) {
                        if (this.f26944c.hasNext()) {
                            this.f26945d = ContiguousSet.create(this.f26944c.next(), AsSet.this.domain).iterator();
                        } else {
                            return (C) b();
                        }
                    }
                    return this.f26945d.next();
                }
            };
        }
    }

    /* loaded from: classes5.dex */
    private static class AsSetSerializedForm<C extends Comparable> implements Serializable {
        private final DiscreteDomain<C> domain;
        private final ImmutableList<Range<C>> ranges;

        AsSetSerializedForm(ImmutableList<Range<C>> immutableList, DiscreteDomain<C> discreteDomain) {
            this.ranges = immutableList;
            this.domain = discreteDomain;
        }

        Object readResolve() {
            return new ImmutableRangeSet(this.ranges).asSet(this.domain);
        }
    }

    /* loaded from: classes5.dex */
    public static class Builder<C extends Comparable<?>> {

        /* renamed from: a  reason: collision with root package name */
        private final List<Range<C>> f26950a = Lists.newArrayList();

        @CanIgnoreReturnValue
        public Builder<C> add(Range<C> range) {
            Preconditions.checkArgument(!range.isEmpty(), "range must not be empty, but was %s", range);
            this.f26950a.add(range);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<C> addAll(RangeSet<C> rangeSet) {
            return addAll(rangeSet.asRanges());
        }

        public ImmutableRangeSet<C> build() {
            ImmutableList.Builder builder = new ImmutableList.Builder(this.f26950a.size());
            Collections.sort(this.f26950a, Range.e());
            PeekingIterator peekingIterator = Iterators.peekingIterator(this.f26950a.iterator());
            while (peekingIterator.hasNext()) {
                Range range = (Range) peekingIterator.next();
                while (peekingIterator.hasNext()) {
                    Range<C> range2 = (Range) peekingIterator.peek();
                    if (range.isConnected(range2)) {
                        Preconditions.checkArgument(range.intersection(range2).isEmpty(), "Overlapping ranges not permitted but found %s overlapping %s", range, range2);
                        range = range.span((Range) peekingIterator.next());
                    }
                }
                builder.add((ImmutableList.Builder) range);
            }
            ImmutableList build = builder.build();
            if (build.isEmpty()) {
                return ImmutableRangeSet.of();
            }
            if (build.size() == 1 && ((Range) Iterables.getOnlyElement(build)).equals(Range.all())) {
                return ImmutableRangeSet.b();
            }
            return new ImmutableRangeSet<>(build);
        }

        @CanIgnoreReturnValue
        public Builder<C> addAll(Iterable<Range<C>> iterable) {
            for (Range<C> range : iterable) {
                add(range);
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class ComplementRanges extends ImmutableList<Range<C>> {
        private final boolean positiveBoundedAbove;
        private final boolean positiveBoundedBelow;
        private final int size;

        ComplementRanges() {
            boolean hasLowerBound = ((Range) ImmutableRangeSet.this.f26941a.get(0)).hasLowerBound();
            this.positiveBoundedBelow = hasLowerBound;
            boolean hasUpperBound = ((Range) Iterables.getLast(ImmutableRangeSet.this.f26941a)).hasUpperBound();
            this.positiveBoundedAbove = hasUpperBound;
            int size = ImmutableRangeSet.this.f26941a.size() - 1;
            size = hasLowerBound ? size + 1 : size;
            this.size = hasUpperBound ? size + 1 : size;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean f() {
            return true;
        }

        @Override // java.util.List
        /* renamed from: l */
        public Range<C> get(int i4) {
            Cut<C> cut;
            Cut<C> cut2;
            Preconditions.checkElementIndex(i4, this.size);
            if (this.positiveBoundedBelow) {
                if (i4 == 0) {
                    cut = Cut.c();
                } else {
                    cut = ((Range) ImmutableRangeSet.this.f26941a.get(i4 - 1)).upperBound;
                }
            } else {
                cut = ((Range) ImmutableRangeSet.this.f26941a.get(i4)).upperBound;
            }
            if (this.positiveBoundedAbove && i4 == this.size - 1) {
                cut2 = Cut.a();
            } else {
                cut2 = ((Range) ImmutableRangeSet.this.f26941a.get(i4 + (!this.positiveBoundedBelow ? 1 : 0))).lowerBound;
            }
            return Range.b(cut, cut2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.size;
        }
    }

    /* loaded from: classes5.dex */
    private static final class SerializedForm<C extends Comparable> implements Serializable {
        private final ImmutableList<Range<C>> ranges;

        SerializedForm(ImmutableList<Range<C>> immutableList) {
            this.ranges = immutableList;
        }

        Object readResolve() {
            if (this.ranges.isEmpty()) {
                return ImmutableRangeSet.of();
            }
            if (this.ranges.equals(ImmutableList.of(Range.all()))) {
                return ImmutableRangeSet.b();
            }
            return new ImmutableRangeSet(this.ranges);
        }
    }

    ImmutableRangeSet(ImmutableList<Range<C>> immutableList) {
        this.f26941a = immutableList;
    }

    static <C extends Comparable> ImmutableRangeSet<C> b() {
        return f26940d;
    }

    public static <C extends Comparable<?>> Builder<C> builder() {
        return new Builder<>();
    }

    private ImmutableList<Range<C>> c(final Range<C> range) {
        final int i4;
        int size;
        if (!this.f26941a.isEmpty() && !range.isEmpty()) {
            if (range.encloses(span())) {
                return this.f26941a;
            }
            if (range.hasLowerBound()) {
                i4 = SortedLists.a(this.f26941a, Range.g(), range.lowerBound, SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
            } else {
                i4 = 0;
            }
            if (range.hasUpperBound()) {
                size = SortedLists.a(this.f26941a, Range.c(), range.upperBound, SortedLists.KeyPresentBehavior.FIRST_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
            } else {
                size = this.f26941a.size();
            }
            final int i5 = size - i4;
            if (i5 == 0) {
                return ImmutableList.of();
            }
            return (ImmutableList<Range<C>>) new ImmutableList<Range<C>>() { // from class: com.google.common.collect.ImmutableRangeSet.1
                /* JADX INFO: Access modifiers changed from: package-private */
                @Override // com.google.common.collect.ImmutableCollection
                public boolean f() {
                    return true;
                }

                @Override // java.util.List
                /* renamed from: l */
                public Range<C> get(int i6) {
                    Preconditions.checkElementIndex(i6, i5);
                    if (i6 != 0 && i6 != i5 - 1) {
                        return (Range) ImmutableRangeSet.this.f26941a.get(i6 + i4);
                    }
                    return ((Range) ImmutableRangeSet.this.f26941a.get(i6 + i4)).intersection(range);
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                public int size() {
                    return i5;
                }
            };
        }
        return ImmutableList.of();
    }

    public static <C extends Comparable> ImmutableRangeSet<C> copyOf(RangeSet<C> rangeSet) {
        Preconditions.checkNotNull(rangeSet);
        if (rangeSet.isEmpty()) {
            return of();
        }
        if (rangeSet.encloses(Range.all())) {
            return b();
        }
        if (rangeSet instanceof ImmutableRangeSet) {
            ImmutableRangeSet<C> immutableRangeSet = (ImmutableRangeSet) rangeSet;
            if (!immutableRangeSet.e()) {
                return immutableRangeSet;
            }
        }
        return new ImmutableRangeSet<>(ImmutableList.copyOf((Collection) rangeSet.asRanges()));
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of() {
        return f26939c;
    }

    @J2ktIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> unionOf(Iterable<Range<C>> iterable) {
        return copyOf(TreeRangeSet.create(iterable));
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void add(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void addAll(RangeSet<C> rangeSet) {
        throw new UnsupportedOperationException();
    }

    public ImmutableSortedSet<C> asSet(DiscreteDomain<C> discreteDomain) {
        Preconditions.checkNotNull(discreteDomain);
        if (isEmpty()) {
            return ImmutableSortedSet.of();
        }
        Range<C> canonical = span().canonical(discreteDomain);
        if (canonical.hasLowerBound()) {
            if (!canonical.hasUpperBound()) {
                try {
                    discreteDomain.maxValue();
                } catch (NoSuchElementException unused) {
                    throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
                }
            }
            return new AsSet(discreteDomain);
        }
        throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    public ImmutableRangeSet<C> difference(RangeSet<C> rangeSet) {
        TreeRangeSet create = TreeRangeSet.create(this);
        create.removeAll(rangeSet);
        return copyOf(create);
    }

    boolean e() {
        return this.f26941a.f();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public boolean encloses(Range<C> range) {
        int b4 = SortedLists.b(this.f26941a, Range.c(), range.lowerBound, Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (b4 != -1 && this.f26941a.get(b4).encloses(range)) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean enclosesAll(RangeSet rangeSet) {
        return super.enclosesAll(rangeSet);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    public ImmutableRangeSet<C> intersection(RangeSet<C> rangeSet) {
        TreeRangeSet create = TreeRangeSet.create(this);
        create.removeAll(rangeSet.complement());
        return copyOf(create);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public boolean intersects(Range<C> range) {
        int b4 = SortedLists.b(this.f26941a, Range.c(), range.lowerBound, Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        if (b4 < this.f26941a.size() && this.f26941a.get(b4).isConnected(range) && !this.f26941a.get(b4).intersection(range).isEmpty()) {
            return true;
        }
        if (b4 > 0) {
            int i4 = b4 - 1;
            if (this.f26941a.get(i4).isConnected(range) && !this.f26941a.get(i4).intersection(range).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public boolean isEmpty() {
        return this.f26941a.isEmpty();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    @CheckForNull
    public Range<C> rangeContaining(C c4) {
        int b4 = SortedLists.b(this.f26941a, Range.c(), Cut.e(c4), Ordering.natural(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (b4 == -1) {
            return null;
        }
        Range<C> range = this.f26941a.get(b4);
        if (!range.contains(c4)) {
            return null;
        }
        return range;
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void remove(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void removeAll(RangeSet<C> rangeSet) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet
    public Range<C> span() {
        if (!this.f26941a.isEmpty()) {
            Cut<C> cut = this.f26941a.get(0).lowerBound;
            ImmutableList<Range<C>> immutableList = this.f26941a;
            return Range.b(cut, immutableList.get(immutableList.size() - 1).upperBound);
        }
        throw new NoSuchElementException();
    }

    public ImmutableRangeSet<C> union(RangeSet<C> rangeSet) {
        return unionOf(Iterables.concat(asRanges(), rangeSet.asRanges()));
    }

    @J2ktIncompatible
    Object writeReplace() {
        return new SerializedForm(this.f26941a);
    }

    public static <C extends Comparable> ImmutableRangeSet<C> of(Range<C> range) {
        Preconditions.checkNotNull(range);
        if (range.isEmpty()) {
            return of();
        }
        if (range.equals(Range.all())) {
            return b();
        }
        return new ImmutableRangeSet<>(ImmutableList.of(range));
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void addAll(Iterable<Range<C>> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet
    public ImmutableSet<Range<C>> asDescendingSetOfRanges() {
        if (this.f26941a.isEmpty()) {
            return ImmutableSet.of();
        }
        return new RegularImmutableSortedSet(this.f26941a.reverse(), Range.e().reverse());
    }

    @Override // com.google.common.collect.RangeSet
    public ImmutableSet<Range<C>> asRanges() {
        if (this.f26941a.isEmpty()) {
            return ImmutableSet.of();
        }
        return new RegularImmutableSortedSet(this.f26941a, Range.e());
    }

    @Override // com.google.common.collect.RangeSet
    public ImmutableRangeSet<C> complement() {
        ImmutableRangeSet<C> immutableRangeSet = this.f26942b;
        if (immutableRangeSet != null) {
            return immutableRangeSet;
        }
        if (this.f26941a.isEmpty()) {
            ImmutableRangeSet<C> b4 = b();
            this.f26942b = b4;
            return b4;
        } else if (this.f26941a.size() == 1 && this.f26941a.get(0).equals(Range.all())) {
            ImmutableRangeSet<C> of = of();
            this.f26942b = of;
            return of;
        } else {
            ImmutableRangeSet<C> immutableRangeSet2 = new ImmutableRangeSet<>(new ComplementRanges(), this);
            this.f26942b = immutableRangeSet2;
            return immutableRangeSet2;
        }
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return super.enclosesAll(iterable);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void removeAll(Iterable<Range<C>> iterable) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.RangeSet
    public ImmutableRangeSet<C> subRangeSet(Range<C> range) {
        if (!isEmpty()) {
            Range<C> span = span();
            if (range.encloses(span)) {
                return this;
            }
            if (range.isConnected(span)) {
                return new ImmutableRangeSet<>(c(range));
            }
        }
        return of();
    }

    private ImmutableRangeSet(ImmutableList<Range<C>> immutableList, ImmutableRangeSet<C> immutableRangeSet) {
        this.f26941a = immutableList;
        this.f26942b = immutableRangeSet;
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> copyOf(Iterable<Range<C>> iterable) {
        return new Builder().addAll(iterable).build();
    }
}
