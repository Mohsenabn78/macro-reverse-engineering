package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@Immutable(containerOf = {"C"})
@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class Range<C extends Comparable> extends RangeGwtSerializationDependencies implements Predicate<C> {

    /* renamed from: a  reason: collision with root package name */
    private static final Range<Comparable> f27325a = new Range<>(Cut.c(), Cut.a());
    private static final long serialVersionUID = 0;
    final Cut<C> lowerBound;
    final Cut<C> upperBound;

    /* renamed from: com.google.common.collect.Range$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f27326a;

        static {
            int[] iArr = new int[BoundType.values().length];
            f27326a = iArr;
            try {
                iArr[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f27326a[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes5.dex */
    static class LowerBoundFn implements Function<Range, Cut> {

        /* renamed from: a  reason: collision with root package name */
        static final LowerBoundFn f27327a = new LowerBoundFn();

        LowerBoundFn() {
        }

        @Override // com.google.common.base.Function
        /* renamed from: a */
        public Cut apply(Range range) {
            return range.lowerBound;
        }
    }

    /* loaded from: classes5.dex */
    private static class RangeLexOrdering extends Ordering<Range<?>> implements Serializable {

        /* renamed from: a  reason: collision with root package name */
        static final Ordering<Range<?>> f27328a = new RangeLexOrdering();
        private static final long serialVersionUID = 0;

        private RangeLexOrdering() {
        }

        @Override // com.google.common.collect.Ordering, java.util.Comparator
        /* renamed from: b */
        public int compare(Range<?> range, Range<?> range2) {
            return ComparisonChain.start().compare(range.lowerBound, range2.lowerBound).compare(range.upperBound, range2.upperBound).result();
        }
    }

    /* loaded from: classes5.dex */
    static class UpperBoundFn implements Function<Range, Cut> {

        /* renamed from: a  reason: collision with root package name */
        static final UpperBoundFn f27329a = new UpperBoundFn();

        UpperBoundFn() {
        }

        @Override // com.google.common.base.Function
        /* renamed from: a */
        public Cut apply(Range range) {
            return range.upperBound;
        }
    }

    private Range(Cut<C> cut, Cut<C> cut2) {
        this.lowerBound = (Cut) Preconditions.checkNotNull(cut);
        this.upperBound = (Cut) Preconditions.checkNotNull(cut2);
        if (cut.compareTo(cut2) <= 0 && cut != Cut.a() && cut2 != Cut.c()) {
            return;
        }
        throw new IllegalArgumentException("Invalid range: " + f(cut, cut2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    public static <C extends Comparable<?>> Range<C> all() {
        return (Range<C>) f27325a;
    }

    public static <C extends Comparable<?>> Range<C> atLeast(C c4) {
        return b(Cut.e(c4), Cut.a());
    }

    public static <C extends Comparable<?>> Range<C> atMost(C c4) {
        return b(Cut.c(), Cut.b(c4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable<?>> Range<C> b(Cut<C> cut, Cut<C> cut2) {
        return new Range<>(cut, cut2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable<?>> Function<Range<C>, Cut<C>> c() {
        return LowerBoundFn.f27327a;
    }

    public static <C extends Comparable<?>> Range<C> closed(C c4, C c5) {
        return b(Cut.e(c4), Cut.b(c5));
    }

    public static <C extends Comparable<?>> Range<C> closedOpen(C c4, C c5) {
        return b(Cut.e(c4), Cut.e(c5));
    }

    public static <C extends Comparable<?>> Range<C> downTo(C c4, BoundType boundType) {
        int i4 = AnonymousClass1.f27326a[boundType.ordinal()];
        if (i4 != 1) {
            if (i4 == 2) {
                return atLeast(c4);
            }
            throw new AssertionError();
        }
        return greaterThan(c4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable<?>> Ordering<Range<C>> e() {
        return (Ordering<Range<C>>) RangeLexOrdering.f27328a;
    }

    public static <C extends Comparable<?>> Range<C> encloseAll(Iterable<C> iterable) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) iterable;
            Comparator comparator = sortedSet.comparator();
            if (Ordering.natural().equals(comparator) || comparator == null) {
                return closed((Comparable) sortedSet.first(), (Comparable) sortedSet.last());
            }
        }
        Iterator<C> it = iterable.iterator();
        Comparable comparable = (Comparable) Preconditions.checkNotNull(it.next());
        Comparable comparable2 = comparable;
        while (it.hasNext()) {
            Comparable comparable3 = (Comparable) Preconditions.checkNotNull(it.next());
            comparable = (Comparable) Ordering.natural().min(comparable, comparable3);
            comparable2 = (Comparable) Ordering.natural().max(comparable2, comparable3);
        }
        return closed(comparable, comparable2);
    }

    private static String f(Cut<?> cut, Cut<?> cut2) {
        StringBuilder sb = new StringBuilder(16);
        cut.h(sb);
        sb.append("..");
        cut2.i(sb);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable<?>> Function<Range<C>, Cut<C>> g() {
        return UpperBoundFn.f27329a;
    }

    public static <C extends Comparable<?>> Range<C> greaterThan(C c4) {
        return b(Cut.b(c4), Cut.a());
    }

    public static <C extends Comparable<?>> Range<C> lessThan(C c4) {
        return b(Cut.c(), Cut.e(c4));
    }

    public static <C extends Comparable<?>> Range<C> open(C c4, C c5) {
        return b(Cut.b(c4), Cut.e(c5));
    }

    public static <C extends Comparable<?>> Range<C> openClosed(C c4, C c5) {
        return b(Cut.b(c4), Cut.b(c5));
    }

    public static <C extends Comparable<?>> Range<C> range(C c4, BoundType boundType, C c5, BoundType boundType2) {
        Cut e4;
        Cut b4;
        Preconditions.checkNotNull(boundType);
        Preconditions.checkNotNull(boundType2);
        BoundType boundType3 = BoundType.OPEN;
        if (boundType == boundType3) {
            e4 = Cut.b(c4);
        } else {
            e4 = Cut.e(c4);
        }
        if (boundType2 == boundType3) {
            b4 = Cut.e(c5);
        } else {
            b4 = Cut.b(c5);
        }
        return b(e4, b4);
    }

    public static <C extends Comparable<?>> Range<C> singleton(C c4) {
        return closed(c4, c4);
    }

    public static <C extends Comparable<?>> Range<C> upTo(C c4, BoundType boundType) {
        int i4 = AnonymousClass1.f27326a[boundType.ordinal()];
        if (i4 != 1) {
            if (i4 == 2) {
                return atMost(c4);
            }
            throw new AssertionError();
        }
        return lessThan(c4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.base.Predicate
    @Deprecated
    public /* bridge */ /* synthetic */ boolean apply(Object obj) {
        return apply((Range<C>) ((Comparable) obj));
    }

    public Range<C> canonical(DiscreteDomain<C> discreteDomain) {
        Preconditions.checkNotNull(discreteDomain);
        Cut<C> f4 = this.lowerBound.f(discreteDomain);
        Cut<C> f5 = this.upperBound.f(discreteDomain);
        if (f4 == this.lowerBound && f5 == this.upperBound) {
            return this;
        }
        return b(f4, f5);
    }

    public boolean contains(C c4) {
        Preconditions.checkNotNull(c4);
        if (this.lowerBound.m(c4) && !this.upperBound.m(c4)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean containsAll(Iterable<? extends C> iterable) {
        if (Iterables.isEmpty(iterable)) {
            return true;
        }
        if (iterable instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) iterable;
            Comparator comparator = sortedSet.comparator();
            if (Ordering.natural().equals(comparator) || comparator == null) {
                if (contains((Comparable) sortedSet.first()) && contains((Comparable) sortedSet.last())) {
                    return true;
                }
                return false;
            }
        }
        for (C c4 : iterable) {
            if (!contains(c4)) {
                return false;
            }
        }
        return true;
    }

    public boolean encloses(Range<C> range) {
        if (this.lowerBound.compareTo(range.lowerBound) <= 0 && this.upperBound.compareTo(range.upperBound) >= 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.base.Predicate
    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        if (!this.lowerBound.equals(range.lowerBound) || !this.upperBound.equals(range.upperBound)) {
            return false;
        }
        return true;
    }

    public Range<C> gap(Range<C> range) {
        boolean z3;
        Range<C> range2;
        if (this.lowerBound.compareTo(range.upperBound) < 0 && range.lowerBound.compareTo(this.upperBound) < 0) {
            throw new IllegalArgumentException("Ranges have a nonempty intersection: " + this + ", " + range);
        }
        if (this.lowerBound.compareTo(range.lowerBound) < 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            range2 = this;
        } else {
            range2 = range;
        }
        if (!z3) {
            range = this;
        }
        return b(range2.upperBound, range.lowerBound);
    }

    public boolean hasLowerBound() {
        if (this.lowerBound != Cut.c()) {
            return true;
        }
        return false;
    }

    public boolean hasUpperBound() {
        if (this.upperBound != Cut.a()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.lowerBound.hashCode() * 31) + this.upperBound.hashCode();
    }

    public Range<C> intersection(Range<C> range) {
        Cut<C> cut;
        Cut<C> cut2;
        boolean z3;
        int compareTo = this.lowerBound.compareTo(range.lowerBound);
        int compareTo2 = this.upperBound.compareTo(range.upperBound);
        if (compareTo >= 0 && compareTo2 <= 0) {
            return this;
        }
        if (compareTo <= 0 && compareTo2 >= 0) {
            return range;
        }
        if (compareTo >= 0) {
            cut = this.lowerBound;
        } else {
            cut = range.lowerBound;
        }
        if (compareTo2 <= 0) {
            cut2 = this.upperBound;
        } else {
            cut2 = range.upperBound;
        }
        if (cut.compareTo(cut2) <= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "intersection is undefined for disconnected ranges %s and %s", this, range);
        return b(cut, cut2);
    }

    public boolean isConnected(Range<C> range) {
        if (this.lowerBound.compareTo(range.upperBound) <= 0 && range.lowerBound.compareTo(this.upperBound) <= 0) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        return this.lowerBound.equals(this.upperBound);
    }

    public BoundType lowerBoundType() {
        return this.lowerBound.o();
    }

    public C lowerEndpoint() {
        return this.lowerBound.j();
    }

    Object readResolve() {
        if (equals(f27325a)) {
            return all();
        }
        return this;
    }

    public Range<C> span(Range<C> range) {
        Cut<C> cut;
        Cut<C> cut2;
        int compareTo = this.lowerBound.compareTo(range.lowerBound);
        int compareTo2 = this.upperBound.compareTo(range.upperBound);
        if (compareTo <= 0 && compareTo2 >= 0) {
            return this;
        }
        if (compareTo >= 0 && compareTo2 <= 0) {
            return range;
        }
        if (compareTo <= 0) {
            cut = this.lowerBound;
        } else {
            cut = range.lowerBound;
        }
        if (compareTo2 >= 0) {
            cut2 = this.upperBound;
        } else {
            cut2 = range.upperBound;
        }
        return b(cut, cut2);
    }

    public String toString() {
        return f(this.lowerBound, this.upperBound);
    }

    public BoundType upperBoundType() {
        return this.upperBound.p();
    }

    public C upperEndpoint() {
        return this.upperBound.j();
    }

    @Deprecated
    public boolean apply(C c4) {
        return contains(c4);
    }
}
