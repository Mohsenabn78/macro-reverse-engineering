package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public class TreeRangeSet<C extends Comparable<?>> extends AbstractRangeSet<C> implements Serializable {
    @CheckForNull

    /* renamed from: a  reason: collision with root package name */
    private transient Set<Range<C>> f27553a;
    @CheckForNull

    /* renamed from: b  reason: collision with root package name */
    private transient Set<Range<C>> f27554b;
    @CheckForNull

    /* renamed from: c  reason: collision with root package name */
    private transient RangeSet<C> f27555c;
    @VisibleForTesting
    final NavigableMap<Cut<C>, Range<C>> rangesByLowerBound;

    /* loaded from: classes5.dex */
    final class AsRanges extends ForwardingCollection<Range<C>> implements Set<Range<C>> {

        /* renamed from: a  reason: collision with root package name */
        final Collection<Range<C>> f27556a;

        AsRanges(TreeRangeSet treeRangeSet, Collection<Range<C>> collection) {
            this.f27556a = collection;
        }

        @Override // java.util.Collection, java.util.Set
        public boolean equals(@CheckForNull Object obj) {
            return Sets.a(this, obj);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: f */
        public Collection<Range<C>> e() {
            return this.f27556a;
        }

        @Override // java.util.Collection, java.util.Set
        public int hashCode() {
            return Sets.b(this);
        }
    }

    /* loaded from: classes5.dex */
    private final class Complement extends TreeRangeSet<C> {
        Complement() {
            super(new ComplementRangesByLowerBound(TreeRangeSet.this.rangesByLowerBound));
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public void add(Range<C> range) {
            TreeRangeSet.this.remove(range);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.RangeSet
        public RangeSet<C> complement() {
            return TreeRangeSet.this;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public boolean contains(C c4) {
            return !TreeRangeSet.this.contains(c4);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public void remove(Range<C> range) {
            TreeRangeSet.this.add(range);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class ComplementRangesByLowerBound<C extends Comparable<?>> extends AbstractNavigableMap<Cut<C>, Range<C>> {

        /* renamed from: a  reason: collision with root package name */
        private final NavigableMap<Cut<C>, Range<C>> f27557a;

        /* renamed from: b  reason: collision with root package name */
        private final NavigableMap<Cut<C>, Range<C>> f27558b;

        /* renamed from: c  reason: collision with root package name */
        private final Range<Cut<C>> f27559c;

        ComplementRangesByLowerBound(NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this(navigableMap, Range.all());
        }

        private NavigableMap<Cut<C>, Range<C>> h(Range<Cut<C>> range) {
            if (!this.f27559c.isConnected(range)) {
                return ImmutableSortedMap.of();
            }
            return new ComplementRangesByLowerBound(this.f27557a, range.intersection(this.f27559c));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            Collection<Range<C>> values;
            Cut cut;
            boolean z3;
            if (this.f27559c.hasLowerBound()) {
                NavigableMap<Cut<C>, Range<C>> navigableMap = this.f27558b;
                Cut<C> lowerEndpoint = this.f27559c.lowerEndpoint();
                if (this.f27559c.lowerBoundType() == BoundType.CLOSED) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                values = navigableMap.tailMap(lowerEndpoint, z3).values();
            } else {
                values = this.f27558b.values();
            }
            PeekingIterator peekingIterator = Iterators.peekingIterator(values.iterator());
            if (this.f27559c.contains(Cut.c()) && (!peekingIterator.hasNext() || ((Range) peekingIterator.peek()).lowerBound != Cut.c())) {
                cut = Cut.c();
            } else if (peekingIterator.hasNext()) {
                cut = ((Range) peekingIterator.next()).upperBound;
            } else {
                return Iterators.f();
            }
            return new AbstractIterator<Map.Entry<Cut<C>, Range<C>>>(cut, peekingIterator) { // from class: com.google.common.collect.TreeRangeSet.ComplementRangesByLowerBound.1

                /* renamed from: c  reason: collision with root package name */
                Cut<C> f27560c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ Cut f27561d;

                /* renamed from: e  reason: collision with root package name */
                final /* synthetic */ PeekingIterator f27562e;

                {
                    this.f27561d = cut;
                    this.f27562e = peekingIterator;
                    this.f27560c = cut;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractIterator
                @CheckForNull
                /* renamed from: d */
                public Map.Entry<Cut<C>, Range<C>> a() {
                    Range b4;
                    if (!ComplementRangesByLowerBound.this.f27559c.upperBound.m(this.f27560c) && this.f27560c != Cut.a()) {
                        if (this.f27562e.hasNext()) {
                            Range range = (Range) this.f27562e.next();
                            b4 = Range.b(this.f27560c, range.lowerBound);
                            this.f27560c = range.upperBound;
                        } else {
                            b4 = Range.b(this.f27560c, Cut.a());
                            this.f27560c = Cut.a();
                        }
                        return Maps.immutableEntry(b4.lowerBound, b4);
                    }
                    return (Map.Entry) b();
                }
            };
        }

        @Override // com.google.common.collect.AbstractNavigableMap
        Iterator<Map.Entry<Cut<C>, Range<C>>> c() {
            Cut<C> a4;
            boolean z3;
            Cut<C> higherKey;
            if (this.f27559c.hasUpperBound()) {
                a4 = this.f27559c.upperEndpoint();
            } else {
                a4 = Cut.a();
            }
            if (this.f27559c.hasUpperBound() && this.f27559c.upperBoundType() == BoundType.CLOSED) {
                z3 = true;
            } else {
                z3 = false;
            }
            PeekingIterator peekingIterator = Iterators.peekingIterator(this.f27558b.headMap(a4, z3).descendingMap().values().iterator());
            if (peekingIterator.hasNext()) {
                if (((Range) peekingIterator.peek()).upperBound == Cut.a()) {
                    higherKey = ((Range) peekingIterator.next()).lowerBound;
                } else {
                    higherKey = this.f27557a.higherKey(((Range) peekingIterator.peek()).upperBound);
                }
            } else if (this.f27559c.contains(Cut.c()) && !this.f27557a.containsKey(Cut.c())) {
                higherKey = this.f27557a.higherKey(Cut.c());
            } else {
                return Iterators.f();
            }
            return new AbstractIterator<Map.Entry<Cut<C>, Range<C>>>((Cut) MoreObjects.firstNonNull(higherKey, Cut.a()), peekingIterator) { // from class: com.google.common.collect.TreeRangeSet.ComplementRangesByLowerBound.2

                /* renamed from: c  reason: collision with root package name */
                Cut<C> f27564c;

                /* renamed from: d  reason: collision with root package name */
                final /* synthetic */ Cut f27565d;

                /* renamed from: e  reason: collision with root package name */
                final /* synthetic */ PeekingIterator f27566e;

                {
                    this.f27565d = r2;
                    this.f27566e = peekingIterator;
                    this.f27564c = r2;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractIterator
                @CheckForNull
                /* renamed from: d */
                public Map.Entry<Cut<C>, Range<C>> a() {
                    if (this.f27564c == Cut.c()) {
                        return (Map.Entry) b();
                    }
                    if (this.f27566e.hasNext()) {
                        Range range = (Range) this.f27566e.next();
                        Range b4 = Range.b(range.upperBound, this.f27564c);
                        this.f27564c = range.lowerBound;
                        if (ComplementRangesByLowerBound.this.f27559c.lowerBound.m(b4.lowerBound)) {
                            return Maps.immutableEntry(b4.lowerBound, b4);
                        }
                    } else if (ComplementRangesByLowerBound.this.f27559c.lowerBound.m(Cut.c())) {
                        Range b5 = Range.b(Cut.c(), this.f27564c);
                        this.f27564c = Cut.c();
                        return Maps.immutableEntry(Cut.c(), b5);
                    }
                    return (Map.Entry) b();
                }
            };
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            if (get(obj) != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* renamed from: e */
        public Range<C> get(@CheckForNull Object obj) {
            if (obj instanceof Cut) {
                try {
                    Cut<C> cut = (Cut) obj;
                    Map.Entry<Cut<C>, Range<C>> firstEntry = tailMap(cut, true).firstEntry();
                    if (firstEntry != null && firstEntry.getKey().equals(cut)) {
                        return firstEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* renamed from: f */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z3) {
            return h(Range.upTo(cut, BoundType.b(z3)));
        }

        @Override // java.util.NavigableMap
        /* renamed from: g */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z3, Cut<C> cut2, boolean z4) {
            return h(Range.range(cut, BoundType.b(z3), cut2, BoundType.b(z4)));
        }

        @Override // java.util.NavigableMap
        /* renamed from: i */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z3) {
            return h(Range.downTo(cut, BoundType.b(z3)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return Iterators.size(a());
        }

        private ComplementRangesByLowerBound(NavigableMap<Cut<C>, Range<C>> navigableMap, Range<Cut<C>> range) {
            this.f27557a = navigableMap;
            this.f27558b = new RangesByUpperBound(navigableMap);
            this.f27559c = range;
        }
    }

    /* loaded from: classes5.dex */
    private final class SubRangeSet extends TreeRangeSet<C> {
        private final Range<C> restriction;

        SubRangeSet(Range<C> range) {
            super(new SubRangeSetRangesByLowerBound(Range.all(), range, TreeRangeSet.this.rangesByLowerBound));
            this.restriction = range;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public void add(Range<C> range) {
            Preconditions.checkArgument(this.restriction.encloses(range), "Cannot add range %s to subRangeSet(%s)", range, this.restriction);
            TreeRangeSet.this.add(range);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public void clear() {
            TreeRangeSet.this.remove(this.restriction);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public boolean contains(C c4) {
            if (this.restriction.contains(c4) && TreeRangeSet.this.contains(c4)) {
                return true;
            }
            return false;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public boolean encloses(Range<C> range) {
            Range b4;
            if (this.restriction.isEmpty() || !this.restriction.encloses(range) || (b4 = TreeRangeSet.this.b(range)) == null || b4.intersection(this.restriction).isEmpty()) {
                return false;
            }
            return true;
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        @CheckForNull
        public Range<C> rangeContaining(C c4) {
            Range<C> rangeContaining;
            if (!this.restriction.contains(c4) || (rangeContaining = TreeRangeSet.this.rangeContaining(c4)) == null) {
                return null;
            }
            return rangeContaining.intersection(this.restriction);
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
        public void remove(Range<C> range) {
            if (range.isConnected(this.restriction)) {
                TreeRangeSet.this.remove(range.intersection(this.restriction));
            }
        }

        @Override // com.google.common.collect.TreeRangeSet, com.google.common.collect.RangeSet
        public RangeSet<C> subRangeSet(Range<C> range) {
            if (range.encloses(this.restriction)) {
                return this;
            }
            if (range.isConnected(this.restriction)) {
                return new SubRangeSet(this.restriction.intersection(range));
            }
            return ImmutableRangeSet.of();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class SubRangeSetRangesByLowerBound<C extends Comparable<?>> extends AbstractNavigableMap<Cut<C>, Range<C>> {

        /* renamed from: a  reason: collision with root package name */
        private final Range<Cut<C>> f27574a;

        /* renamed from: b  reason: collision with root package name */
        private final Range<C> f27575b;

        /* renamed from: c  reason: collision with root package name */
        private final NavigableMap<Cut<C>, Range<C>> f27576c;

        /* renamed from: d  reason: collision with root package name */
        private final NavigableMap<Cut<C>, Range<C>> f27577d;

        private NavigableMap<Cut<C>, Range<C>> i(Range<Cut<C>> range) {
            if (!range.isConnected(this.f27574a)) {
                return ImmutableSortedMap.of();
            }
            return new SubRangeSetRangesByLowerBound(this.f27574a.intersection(range), this.f27575b, this.f27576c);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            final Iterator<Range<C>> it;
            if (this.f27575b.isEmpty()) {
                return Iterators.f();
            }
            if (this.f27574a.upperBound.m(this.f27575b.lowerBound)) {
                return Iterators.f();
            }
            boolean z3 = false;
            if (this.f27574a.lowerBound.m(this.f27575b.lowerBound)) {
                it = this.f27577d.tailMap(this.f27575b.lowerBound, false).values().iterator();
            } else {
                NavigableMap<Cut<C>, Range<C>> navigableMap = this.f27576c;
                Cut<C> j4 = this.f27574a.lowerBound.j();
                if (this.f27574a.lowerBoundType() == BoundType.CLOSED) {
                    z3 = true;
                }
                it = navigableMap.tailMap(j4, z3).values().iterator();
            }
            final Cut cut = (Cut) Ordering.natural().min(this.f27574a.upperBound, Cut.e(this.f27575b.upperBound));
            return new AbstractIterator<Map.Entry<Cut<C>, Range<C>>>() { // from class: com.google.common.collect.TreeRangeSet.SubRangeSetRangesByLowerBound.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractIterator
                @CheckForNull
                /* renamed from: d */
                public Map.Entry<Cut<C>, Range<C>> a() {
                    if (!it.hasNext()) {
                        return (Map.Entry) b();
                    }
                    Range range = (Range) it.next();
                    if (cut.m(range.lowerBound)) {
                        return (Map.Entry) b();
                    }
                    Range intersection = range.intersection(SubRangeSetRangesByLowerBound.this.f27575b);
                    return Maps.immutableEntry(intersection.lowerBound, intersection);
                }
            };
        }

        @Override // com.google.common.collect.AbstractNavigableMap
        Iterator<Map.Entry<Cut<C>, Range<C>>> c() {
            boolean z3;
            if (this.f27575b.isEmpty()) {
                return Iterators.f();
            }
            Cut cut = (Cut) Ordering.natural().min(this.f27574a.upperBound, Cut.e(this.f27575b.upperBound));
            NavigableMap<Cut<C>, Range<C>> navigableMap = this.f27576c;
            Cut<C> cut2 = (Cut) cut.j();
            if (cut.p() == BoundType.CLOSED) {
                z3 = true;
            } else {
                z3 = false;
            }
            final Iterator<Range<C>> it = navigableMap.headMap(cut2, z3).descendingMap().values().iterator();
            return new AbstractIterator<Map.Entry<Cut<C>, Range<C>>>() { // from class: com.google.common.collect.TreeRangeSet.SubRangeSetRangesByLowerBound.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractIterator
                @CheckForNull
                /* renamed from: d */
                public Map.Entry<Cut<C>, Range<C>> a() {
                    if (!it.hasNext()) {
                        return (Map.Entry) b();
                    }
                    Range range = (Range) it.next();
                    if (SubRangeSetRangesByLowerBound.this.f27575b.lowerBound.compareTo(range.upperBound) >= 0) {
                        return (Map.Entry) b();
                    }
                    Range intersection = range.intersection(SubRangeSetRangesByLowerBound.this.f27575b);
                    if (SubRangeSetRangesByLowerBound.this.f27574a.contains(intersection.lowerBound)) {
                        return Maps.immutableEntry(intersection.lowerBound, intersection);
                    }
                    return (Map.Entry) b();
                }
            };
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            if (get(obj) != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* renamed from: f */
        public Range<C> get(@CheckForNull Object obj) {
            if (obj instanceof Cut) {
                try {
                    Cut<C> cut = (Cut) obj;
                    if (this.f27574a.contains(cut) && cut.compareTo(this.f27575b.lowerBound) >= 0 && cut.compareTo(this.f27575b.upperBound) < 0) {
                        if (cut.equals(this.f27575b.lowerBound)) {
                            Range range = (Range) Maps.P(this.f27576c.floorEntry(cut));
                            if (range != null && range.upperBound.compareTo(this.f27575b.lowerBound) > 0) {
                                return range.intersection(this.f27575b);
                            }
                        } else {
                            Range<C> range2 = this.f27576c.get(cut);
                            if (range2 != null) {
                                return range2.intersection(this.f27575b);
                            }
                        }
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* renamed from: g */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z3) {
            return i(Range.upTo(cut, BoundType.b(z3)));
        }

        @Override // java.util.NavigableMap
        /* renamed from: h */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z3, Cut<C> cut2, boolean z4) {
            return i(Range.range(cut, BoundType.b(z3), cut2, BoundType.b(z4)));
        }

        @Override // java.util.NavigableMap
        /* renamed from: j */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z3) {
            return i(Range.downTo(cut, BoundType.b(z3)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return Iterators.size(a());
        }

        private SubRangeSetRangesByLowerBound(Range<Cut<C>> range, Range<C> range2, NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this.f27574a = (Range) Preconditions.checkNotNull(range);
            this.f27575b = (Range) Preconditions.checkNotNull(range2);
            this.f27576c = (NavigableMap) Preconditions.checkNotNull(navigableMap);
            this.f27577d = new RangesByUpperBound(navigableMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CheckForNull
    public Range<C> b(Range<C> range) {
        Preconditions.checkNotNull(range);
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        if (floorEntry != null && floorEntry.getValue().encloses(range)) {
            return floorEntry.getValue();
        }
        return null;
    }

    private void c(Range<C> range) {
        if (range.isEmpty()) {
            this.rangesByLowerBound.remove(range.lowerBound);
        } else {
            this.rangesByLowerBound.put(range.lowerBound, range);
        }
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create() {
        return new TreeRangeSet<>(new TreeMap());
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public void add(Range<C> range) {
        Preconditions.checkNotNull(range);
        if (range.isEmpty()) {
            return;
        }
        Cut<C> cut = range.lowerBound;
        Cut<C> cut2 = range.upperBound;
        Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(cut);
        if (lowerEntry != null) {
            Range<C> value = lowerEntry.getValue();
            if (value.upperBound.compareTo(cut) >= 0) {
                if (value.upperBound.compareTo(cut2) >= 0) {
                    cut2 = value.upperBound;
                }
                cut = value.lowerBound;
            }
        }
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(cut2);
        if (floorEntry != null) {
            Range<C> value2 = floorEntry.getValue();
            if (value2.upperBound.compareTo(cut2) >= 0) {
                cut2 = value2.upperBound;
            }
        }
        this.rangesByLowerBound.subMap(cut, cut2).clear();
        c(Range.b(cut, cut2));
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void addAll(RangeSet rangeSet) {
        super.addAll(rangeSet);
    }

    @Override // com.google.common.collect.RangeSet
    public Set<Range<C>> asDescendingSetOfRanges() {
        Set<Range<C>> set = this.f27554b;
        if (set == null) {
            AsRanges asRanges = new AsRanges(this, this.rangesByLowerBound.descendingMap().values());
            this.f27554b = asRanges;
            return asRanges;
        }
        return set;
    }

    @Override // com.google.common.collect.RangeSet
    public Set<Range<C>> asRanges() {
        Set<Range<C>> set = this.f27553a;
        if (set == null) {
            AsRanges asRanges = new AsRanges(this, this.rangesByLowerBound.values());
            this.f27553a = asRanges;
            return asRanges;
        }
        return set;
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.RangeSet
    public RangeSet<C> complement() {
        RangeSet<C> rangeSet = this.f27555c;
        if (rangeSet == null) {
            Complement complement = new Complement();
            this.f27555c = complement;
            return complement;
        }
        return rangeSet;
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean contains(Comparable comparable) {
        return super.contains(comparable);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public boolean encloses(Range<C> range) {
        Preconditions.checkNotNull(range);
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.lowerBound);
        if (floorEntry != null && floorEntry.getValue().encloses(range)) {
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

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public boolean intersects(Range<C> range) {
        Preconditions.checkNotNull(range);
        Map.Entry<Cut<C>, Range<C>> ceilingEntry = this.rangesByLowerBound.ceilingEntry(range.lowerBound);
        if (ceilingEntry != null && ceilingEntry.getValue().isConnected(range) && !ceilingEntry.getValue().intersection(range).isEmpty()) {
            return true;
        }
        Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
        if (lowerEntry != null && lowerEntry.getValue().isConnected(range) && !lowerEntry.getValue().intersection(range).isEmpty()) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    @CheckForNull
    public Range<C> rangeContaining(C c4) {
        Preconditions.checkNotNull(c4);
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(Cut.e(c4));
        if (floorEntry != null && floorEntry.getValue().contains(c4)) {
            return floorEntry.getValue();
        }
        return null;
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public void remove(Range<C> range) {
        Preconditions.checkNotNull(range);
        if (range.isEmpty()) {
            return;
        }
        Map.Entry<Cut<C>, Range<C>> lowerEntry = this.rangesByLowerBound.lowerEntry(range.lowerBound);
        if (lowerEntry != null) {
            Range<C> value = lowerEntry.getValue();
            if (value.upperBound.compareTo(range.lowerBound) >= 0) {
                if (range.hasUpperBound() && value.upperBound.compareTo(range.upperBound) >= 0) {
                    c(Range.b(range.upperBound, value.upperBound));
                }
                c(Range.b(value.lowerBound, range.lowerBound));
            }
        }
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.rangesByLowerBound.floorEntry(range.upperBound);
        if (floorEntry != null) {
            Range<C> value2 = floorEntry.getValue();
            if (range.hasUpperBound() && value2.upperBound.compareTo(range.upperBound) >= 0) {
                c(Range.b(range.upperBound, value2.upperBound));
            }
        }
        this.rangesByLowerBound.subMap(range.lowerBound, range.upperBound).clear();
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void removeAll(RangeSet rangeSet) {
        super.removeAll(rangeSet);
    }

    @Override // com.google.common.collect.RangeSet
    public Range<C> span() {
        Map.Entry<Cut<C>, Range<C>> firstEntry = this.rangesByLowerBound.firstEntry();
        Map.Entry<Cut<C>, Range<C>> lastEntry = this.rangesByLowerBound.lastEntry();
        if (firstEntry != null && lastEntry != null) {
            return Range.b(firstEntry.getValue().lowerBound, lastEntry.getValue().upperBound);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.RangeSet
    public RangeSet<C> subRangeSet(Range<C> range) {
        if (range.equals(Range.all())) {
            return this;
        }
        return new SubRangeSet(range);
    }

    private TreeRangeSet(NavigableMap<Cut<C>, Range<C>> navigableMap) {
        this.rangesByLowerBound = navigableMap;
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(RangeSet<C> rangeSet) {
        TreeRangeSet<C> create = create();
        create.addAll(rangeSet);
        return create;
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void addAll(Iterable iterable) {
        super.addAll(iterable);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ boolean enclosesAll(Iterable iterable) {
        return super.enclosesAll(iterable);
    }

    @Override // com.google.common.collect.AbstractRangeSet, com.google.common.collect.RangeSet
    public /* bridge */ /* synthetic */ void removeAll(Iterable iterable) {
        super.removeAll(iterable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes5.dex */
    public static final class RangesByUpperBound<C extends Comparable<?>> extends AbstractNavigableMap<Cut<C>, Range<C>> {

        /* renamed from: a  reason: collision with root package name */
        private final NavigableMap<Cut<C>, Range<C>> f27568a;

        /* renamed from: b  reason: collision with root package name */
        private final Range<Cut<C>> f27569b;

        RangesByUpperBound(NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this.f27568a = navigableMap;
            this.f27569b = Range.all();
        }

        private NavigableMap<Cut<C>, Range<C>> h(Range<Cut<C>> range) {
            if (range.isConnected(this.f27569b)) {
                return new RangesByUpperBound(this.f27568a, range.intersection(this.f27569b));
            }
            return ImmutableSortedMap.of();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            final Iterator<Range<C>> it;
            if (!this.f27569b.hasLowerBound()) {
                it = this.f27568a.values().iterator();
            } else {
                Map.Entry<Cut<C>, Range<C>> lowerEntry = this.f27568a.lowerEntry(this.f27569b.lowerEndpoint());
                if (lowerEntry == null) {
                    it = this.f27568a.values().iterator();
                } else if (this.f27569b.lowerBound.m(lowerEntry.getValue().upperBound)) {
                    it = this.f27568a.tailMap(lowerEntry.getKey(), true).values().iterator();
                } else {
                    it = this.f27568a.tailMap(this.f27569b.lowerEndpoint(), true).values().iterator();
                }
            }
            return new AbstractIterator<Map.Entry<Cut<C>, Range<C>>>() { // from class: com.google.common.collect.TreeRangeSet.RangesByUpperBound.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractIterator
                @CheckForNull
                /* renamed from: d */
                public Map.Entry<Cut<C>, Range<C>> a() {
                    if (!it.hasNext()) {
                        return (Map.Entry) b();
                    }
                    Range range = (Range) it.next();
                    if (RangesByUpperBound.this.f27569b.upperBound.m(range.upperBound)) {
                        return (Map.Entry) b();
                    }
                    return Maps.immutableEntry(range.upperBound, range);
                }
            };
        }

        @Override // com.google.common.collect.AbstractNavigableMap
        Iterator<Map.Entry<Cut<C>, Range<C>>> c() {
            Collection<Range<C>> values;
            if (this.f27569b.hasUpperBound()) {
                values = this.f27568a.headMap(this.f27569b.upperEndpoint(), false).descendingMap().values();
            } else {
                values = this.f27568a.descendingMap().values();
            }
            final PeekingIterator peekingIterator = Iterators.peekingIterator(values.iterator());
            if (peekingIterator.hasNext() && this.f27569b.upperBound.m(((Range) peekingIterator.peek()).upperBound)) {
                peekingIterator.next();
            }
            return new AbstractIterator<Map.Entry<Cut<C>, Range<C>>>() { // from class: com.google.common.collect.TreeRangeSet.RangesByUpperBound.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractIterator
                @CheckForNull
                /* renamed from: d */
                public Map.Entry<Cut<C>, Range<C>> a() {
                    if (!peekingIterator.hasNext()) {
                        return (Map.Entry) b();
                    }
                    Range range = (Range) peekingIterator.next();
                    if (RangesByUpperBound.this.f27569b.lowerBound.m(range.upperBound)) {
                        return Maps.immutableEntry(range.upperBound, range);
                    }
                    return (Map.Entry) b();
                }
            };
        }

        @Override // java.util.SortedMap
        public Comparator<? super Cut<C>> comparator() {
            return Ordering.natural();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            if (get(obj) != null) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* renamed from: e */
        public Range<C> get(@CheckForNull Object obj) {
            Map.Entry<Cut<C>, Range<C>> lowerEntry;
            if (obj instanceof Cut) {
                try {
                    Cut<C> cut = (Cut) obj;
                    if (this.f27569b.contains(cut) && (lowerEntry = this.f27568a.lowerEntry(cut)) != null && lowerEntry.getValue().upperBound.equals(cut)) {
                        return lowerEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        @Override // java.util.NavigableMap
        /* renamed from: f */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z3) {
            return h(Range.upTo(cut, BoundType.b(z3)));
        }

        @Override // java.util.NavigableMap
        /* renamed from: g */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z3, Cut<C> cut2, boolean z4) {
            return h(Range.range(cut, BoundType.b(z3), cut2, BoundType.b(z4)));
        }

        @Override // java.util.NavigableMap
        /* renamed from: i */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z3) {
            return h(Range.downTo(cut, BoundType.b(z3)));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean isEmpty() {
            if (this.f27569b.equals(Range.all())) {
                return this.f27568a.isEmpty();
            }
            if (!a().hasNext()) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            if (this.f27569b.equals(Range.all())) {
                return this.f27568a.size();
            }
            return Iterators.size(a());
        }

        private RangesByUpperBound(NavigableMap<Cut<C>, Range<C>> navigableMap, Range<Cut<C>> range) {
            this.f27568a = navigableMap;
            this.f27569b = range;
        }
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> create(Iterable<Range<C>> iterable) {
        TreeRangeSet<C> create = create();
        create.addAll(iterable);
        return create;
    }
}
