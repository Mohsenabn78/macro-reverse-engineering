package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSortedSet;
import com.google.errorprone.annotations.DoNotCall;
import java.lang.Comparable;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.SortedSet;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class ContiguousSet<C extends Comparable> extends ImmutableSortedSet<C> {
    final DiscreteDomain<C> domain;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ContiguousSet(DiscreteDomain<C> discreteDomain) {
        super(Ordering.natural());
        this.domain = discreteDomain;
    }

    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public static <E> ImmutableSortedSet.Builder<E> builder() {
        throw new UnsupportedOperationException();
    }

    public static ContiguousSet<Integer> closed(int i4, int i5) {
        return create(Range.closed(Integer.valueOf(i4), Integer.valueOf(i5)), DiscreteDomain.integers());
    }

    public static ContiguousSet<Integer> closedOpen(int i4, int i5) {
        return create(Range.closedOpen(Integer.valueOf(i4), Integer.valueOf(i5)), DiscreteDomain.integers());
    }

    public static <C extends Comparable> ContiguousSet<C> create(Range<C> range, DiscreteDomain<C> discreteDomain) {
        Range<C> range2;
        Preconditions.checkNotNull(range);
        Preconditions.checkNotNull(discreteDomain);
        try {
            if (!range.hasLowerBound()) {
                range2 = range.intersection(Range.atLeast(discreteDomain.minValue()));
            } else {
                range2 = range;
            }
            if (!range.hasUpperBound()) {
                range2 = range2.intersection(Range.atMost(discreteDomain.maxValue()));
            }
            boolean z3 = true;
            if (!range2.isEmpty()) {
                C n4 = range.lowerBound.n(discreteDomain);
                Objects.requireNonNull(n4);
                C l4 = range.upperBound.l(discreteDomain);
                Objects.requireNonNull(l4);
                if (Range.a(n4, l4) <= 0) {
                    z3 = false;
                }
            }
            if (z3) {
                return new EmptyContiguousSet(discreteDomain);
            }
            return new RegularContiguousSet(range2, discreteDomain);
        } catch (NoSuchElementException e4) {
            throw new IllegalArgumentException(e4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet headSet(Object obj) {
        return headSet((ContiguousSet<C>) ((Comparable) obj));
    }

    public abstract ContiguousSet<C> intersection(ContiguousSet<C> contiguousSet);

    @Override // com.google.common.collect.ImmutableSortedSet
    @GwtIncompatible
    ImmutableSortedSet<C> p() {
        return new DescendingImmutableSortedSet(this);
    }

    public abstract Range<C> range();

    public abstract Range<C> range(BoundType boundType, BoundType boundType2);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ ImmutableSortedSet tailSet(Object obj) {
        return tailSet((ContiguousSet<C>) ((Comparable) obj));
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return range().toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSortedSet
    /* renamed from: w */
    public abstract ContiguousSet<C> r(C c4, boolean z3);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSortedSet
    /* renamed from: x */
    public abstract ContiguousSet<C> s(C c4, boolean z3, C c5, boolean z4);

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSortedSet
    /* renamed from: y */
    public abstract ContiguousSet<C> t(C c4, boolean z3);

    public static ContiguousSet<Long> closed(long j4, long j5) {
        return create(Range.closed(Long.valueOf(j4), Long.valueOf(j5)), DiscreteDomain.longs());
    }

    public static ContiguousSet<Long> closedOpen(long j4, long j5) {
        return create(Range.closedOpen(Long.valueOf(j4), Long.valueOf(j5)), DiscreteDomain.longs());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible
    public /* bridge */ /* synthetic */ ImmutableSortedSet headSet(Object obj, boolean z3) {
        return headSet((ContiguousSet<C>) ((Comparable) obj), z3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible
    public /* bridge */ /* synthetic */ ImmutableSortedSet subSet(Object obj, boolean z3, Object obj2, boolean z4) {
        return subSet((boolean) ((Comparable) obj), z3, (boolean) ((Comparable) obj2), z4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible
    public /* bridge */ /* synthetic */ ImmutableSortedSet tailSet(Object obj, boolean z3) {
        return tailSet((ContiguousSet<C>) ((Comparable) obj), z3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible
    public /* bridge */ /* synthetic */ NavigableSet headSet(Object obj, boolean z3) {
        return headSet((ContiguousSet<C>) ((Comparable) obj), z3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible
    public /* bridge */ /* synthetic */ NavigableSet subSet(Object obj, boolean z3, Object obj2, boolean z4) {
        return subSet((boolean) ((Comparable) obj), z3, (boolean) ((Comparable) obj2), z4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible
    public /* bridge */ /* synthetic */ NavigableSet tailSet(Object obj, boolean z3) {
        return tailSet((ContiguousSet<C>) ((Comparable) obj), z3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ SortedSet headSet(Object obj) {
        return headSet((ContiguousSet<C>) ((Comparable) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ SortedSet tailSet(Object obj) {
        return tailSet((ContiguousSet<C>) ((Comparable) obj));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContiguousSet<C> headSet(C c4) {
        return r((Comparable) Preconditions.checkNotNull(c4), false);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet, java.util.SortedSet
    public ContiguousSet<C> subSet(C c4, C c5) {
        Preconditions.checkNotNull(c4);
        Preconditions.checkNotNull(c5);
        Preconditions.checkArgument(comparator().compare(c4, c5) <= 0);
        return s(c4, true, c5, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ContiguousSet<C> tailSet(C c4) {
        return t((Comparable) Preconditions.checkNotNull(c4), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    public ContiguousSet<C> headSet(C c4, boolean z3) {
        return r((Comparable) Preconditions.checkNotNull(c4), z3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    public ContiguousSet<C> tailSet(C c4, boolean z3) {
        return t((Comparable) Preconditions.checkNotNull(c4), z3);
    }

    @GwtIncompatible
    public ContiguousSet<C> subSet(C c4, boolean z3, C c5, boolean z4) {
        Preconditions.checkNotNull(c4);
        Preconditions.checkNotNull(c5);
        Preconditions.checkArgument(comparator().compare(c4, c5) <= 0);
        return s(c4, z3, c5, z4);
    }
}
