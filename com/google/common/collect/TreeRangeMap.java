package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class TreeRangeMap<K extends Comparable, V> implements RangeMap<K, V> {

    /* renamed from: b  reason: collision with root package name */
    private static final RangeMap<Comparable<?>, Object> f27536b = new RangeMap<Comparable<?>, Object>() { // from class: com.google.common.collect.TreeRangeMap.1
        @Override // com.google.common.collect.RangeMap
        public Map<Range<Comparable<?>>, Object> asDescendingMapOfRanges() {
            return Collections.emptyMap();
        }

        @Override // com.google.common.collect.RangeMap
        public Map<Range<Comparable<?>>, Object> asMapOfRanges() {
            return Collections.emptyMap();
        }

        @Override // com.google.common.collect.RangeMap
        @CheckForNull
        public Object get(Comparable<?> comparable) {
            return null;
        }

        @Override // com.google.common.collect.RangeMap
        @CheckForNull
        public Map.Entry<Range<Comparable<?>>, Object> getEntry(Comparable<?> comparable) {
            return null;
        }

        @Override // com.google.common.collect.RangeMap
        public void put(Range<Comparable<?>> range, Object obj) {
            Preconditions.checkNotNull(range);
            throw new IllegalArgumentException("Cannot insert range " + range + " into an empty subRangeMap");
        }

        @Override // com.google.common.collect.RangeMap
        public void putAll(RangeMap<Comparable<?>, ? extends Object> rangeMap) {
            if (rangeMap.asMapOfRanges().isEmpty()) {
                return;
            }
            throw new IllegalArgumentException("Cannot putAll(nonEmptyRangeMap) into an empty subRangeMap");
        }

        @Override // com.google.common.collect.RangeMap
        public void putCoalescing(Range<Comparable<?>> range, Object obj) {
            Preconditions.checkNotNull(range);
            throw new IllegalArgumentException("Cannot insert range " + range + " into an empty subRangeMap");
        }

        @Override // com.google.common.collect.RangeMap
        public void remove(Range<Comparable<?>> range) {
            Preconditions.checkNotNull(range);
        }

        @Override // com.google.common.collect.RangeMap
        public Range<Comparable<?>> span() {
            throw new NoSuchElementException();
        }

        @Override // com.google.common.collect.RangeMap
        public RangeMap<Comparable<?>, Object> subRangeMap(Range<Comparable<?>> range) {
            Preconditions.checkNotNull(range);
            return this;
        }

        @Override // com.google.common.collect.RangeMap
        public void clear() {
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private final NavigableMap<Cut<K>, RangeMapEntry<K, V>> f27537a = Maps.newTreeMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class AsMapOfRanges extends Maps.IteratorBasedAbstractMap<Range<K>, V> {

        /* renamed from: a  reason: collision with root package name */
        final Iterable<Map.Entry<Range<K>, V>> f27538a;

        AsMapOfRanges(Iterable<RangeMapEntry<K, V>> iterable) {
            this.f27538a = iterable;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        public Iterator<Map.Entry<Range<K>, V>> a() {
            return this.f27538a.iterator();
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
        public V get(@CheckForNull Object obj) {
            if (obj instanceof Range) {
                Range range = (Range) obj;
                RangeMapEntry rangeMapEntry = (RangeMapEntry) TreeRangeMap.this.f27537a.get(range.lowerBound);
                if (rangeMapEntry != null && rangeMapEntry.getKey().equals(range)) {
                    return (V) rangeMapEntry.getValue();
                }
                return null;
            }
            return null;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return TreeRangeMap.this.f27537a.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class RangeMapEntry<K extends Comparable, V> extends AbstractMapEntry<Range<K>, V> {

        /* renamed from: a  reason: collision with root package name */
        private final Range<K> f27540a;

        /* renamed from: b  reason: collision with root package name */
        private final V f27541b;

        RangeMapEntry(Cut<K> cut, Cut<K> cut2, V v3) {
            this(Range.b(cut, cut2), v3);
        }

        public boolean f(K k4) {
            return this.f27540a.contains(k4);
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        /* renamed from: g */
        public Range<K> getKey() {
            return this.f27540a;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public V getValue() {
            return this.f27541b;
        }

        Cut<K> h() {
            return this.f27540a.lowerBound;
        }

        Cut<K> i() {
            return this.f27540a.upperBound;
        }

        RangeMapEntry(Range<K> range, V v3) {
            this.f27540a = range;
            this.f27541b = v3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class SubRangeMap implements RangeMap<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private final Range<K> f27542a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public class SubRangeMapAsMap extends AbstractMap<Range<K>, V> {
            SubRangeMapAsMap() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public boolean d(Predicate<? super Map.Entry<Range<K>, V>> predicate) {
                ArrayList<Range<K>> newArrayList = Lists.newArrayList();
                for (Map.Entry<Range<K>, V> entry : entrySet()) {
                    if (predicate.apply(entry)) {
                        newArrayList.add(entry.getKey());
                    }
                }
                for (Range<K> range : newArrayList) {
                    TreeRangeMap.this.remove(range);
                }
                return !newArrayList.isEmpty();
            }

            Iterator<Map.Entry<Range<K>, V>> c() {
                if (!SubRangeMap.this.f27542a.isEmpty()) {
                    final Iterator<V> it = TreeRangeMap.this.f27537a.tailMap((Cut) MoreObjects.firstNonNull((Cut) TreeRangeMap.this.f27537a.floorKey(SubRangeMap.this.f27542a.lowerBound), SubRangeMap.this.f27542a.lowerBound), true).values().iterator();
                    return new AbstractIterator<Map.Entry<Range<K>, V>>() { // from class: com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.3
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.google.common.collect.AbstractIterator
                        @CheckForNull
                        /* renamed from: d */
                        public Map.Entry<Range<K>, V> a() {
                            while (it.hasNext()) {
                                RangeMapEntry rangeMapEntry = (RangeMapEntry) it.next();
                                if (rangeMapEntry.h().compareTo((Cut<K>) SubRangeMap.this.f27542a.upperBound) >= 0) {
                                    return (Map.Entry) b();
                                }
                                if (rangeMapEntry.i().compareTo((Cut<K>) SubRangeMap.this.f27542a.lowerBound) > 0) {
                                    return Maps.immutableEntry(rangeMapEntry.getKey().intersection(SubRangeMap.this.f27542a), rangeMapEntry.getValue());
                                }
                            }
                            return (Map.Entry) b();
                        }
                    };
                }
                return Iterators.f();
            }

            @Override // java.util.AbstractMap, java.util.Map
            public void clear() {
                SubRangeMap.this.clear();
            }

            @Override // java.util.AbstractMap, java.util.Map
            public boolean containsKey(@CheckForNull Object obj) {
                if (get(obj) != null) {
                    return true;
                }
                return false;
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Set<Map.Entry<Range<K>, V>> entrySet() {
                return new Maps.EntrySet<Range<K>, V>() { // from class: com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.2
                    @Override // com.google.common.collect.Maps.EntrySet
                    Map<Range<K>, V> d() {
                        return SubRangeMapAsMap.this;
                    }

                    @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean isEmpty() {
                        return !iterator().hasNext();
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                    public Iterator<Map.Entry<Range<K>, V>> iterator() {
                        return SubRangeMapAsMap.this.c();
                    }

                    @Override // com.google.common.collect.Maps.EntrySet, com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean retainAll(Collection<?> collection) {
                        return SubRangeMapAsMap.this.d(Predicates.not(Predicates.in(collection)));
                    }

                    @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public int size() {
                        return Iterators.size(iterator());
                    }
                };
            }

            @Override // java.util.AbstractMap, java.util.Map
            @CheckForNull
            public V get(@CheckForNull Object obj) {
                RangeMapEntry rangeMapEntry;
                try {
                    if (obj instanceof Range) {
                        Range range = (Range) obj;
                        if (SubRangeMap.this.f27542a.encloses(range) && !range.isEmpty()) {
                            if (range.lowerBound.compareTo(SubRangeMap.this.f27542a.lowerBound) == 0) {
                                Map.Entry floorEntry = TreeRangeMap.this.f27537a.floorEntry(range.lowerBound);
                                if (floorEntry != null) {
                                    rangeMapEntry = (RangeMapEntry) floorEntry.getValue();
                                } else {
                                    rangeMapEntry = null;
                                }
                            } else {
                                rangeMapEntry = (RangeMapEntry) TreeRangeMap.this.f27537a.get(range.lowerBound);
                            }
                            if (rangeMapEntry != null && rangeMapEntry.getKey().isConnected(SubRangeMap.this.f27542a) && rangeMapEntry.getKey().intersection(SubRangeMap.this.f27542a).equals(range)) {
                                return (V) rangeMapEntry.getValue();
                            }
                        }
                    }
                } catch (ClassCastException unused) {
                }
                return null;
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Set<Range<K>> keySet() {
                return new Maps.KeySet<Range<K>, V>(this) { // from class: com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.1
                    @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean remove(@CheckForNull Object obj) {
                        if (SubRangeMapAsMap.this.remove(obj) != null) {
                            return true;
                        }
                        return false;
                    }

                    @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                    public boolean retainAll(Collection<?> collection) {
                        return SubRangeMapAsMap.this.d(Predicates.compose(Predicates.not(Predicates.in(collection)), Maps.t()));
                    }
                };
            }

            @Override // java.util.AbstractMap, java.util.Map
            @CheckForNull
            public V remove(@CheckForNull Object obj) {
                V v3 = (V) get(obj);
                if (v3 != null) {
                    Objects.requireNonNull(obj);
                    TreeRangeMap.this.remove((Range) obj);
                    return v3;
                }
                return null;
            }

            @Override // java.util.AbstractMap, java.util.Map
            public Collection<V> values() {
                return new Maps.Values<Range<K>, V>(this) { // from class: com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.4
                    @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
                    public boolean removeAll(Collection<?> collection) {
                        return SubRangeMapAsMap.this.d(Predicates.compose(Predicates.in(collection), Maps.N()));
                    }

                    @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
                    public boolean retainAll(Collection<?> collection) {
                        return SubRangeMapAsMap.this.d(Predicates.compose(Predicates.not(Predicates.in(collection)), Maps.N()));
                    }
                };
            }
        }

        SubRangeMap(Range<K> range) {
            this.f27542a = range;
        }

        @Override // com.google.common.collect.RangeMap
        public Map<Range<K>, V> asDescendingMapOfRanges() {
            return new TreeRangeMap<K, V>.SubRangeMap.SubRangeMapAsMap() { // from class: com.google.common.collect.TreeRangeMap.SubRangeMap.1
                @Override // com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap
                Iterator<Map.Entry<Range<K>, V>> c() {
                    if (SubRangeMap.this.f27542a.isEmpty()) {
                        return Iterators.f();
                    }
                    final Iterator<V> it = TreeRangeMap.this.f27537a.headMap(SubRangeMap.this.f27542a.upperBound, false).descendingMap().values().iterator();
                    return new AbstractIterator<Map.Entry<Range<K>, V>>() { // from class: com.google.common.collect.TreeRangeMap.SubRangeMap.1.1
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.google.common.collect.AbstractIterator
                        @CheckForNull
                        /* renamed from: d */
                        public Map.Entry<Range<K>, V> a() {
                            if (it.hasNext()) {
                                RangeMapEntry rangeMapEntry = (RangeMapEntry) it.next();
                                if (rangeMapEntry.i().compareTo((Cut<K>) SubRangeMap.this.f27542a.lowerBound) <= 0) {
                                    return (Map.Entry) b();
                                }
                                return Maps.immutableEntry(rangeMapEntry.getKey().intersection(SubRangeMap.this.f27542a), rangeMapEntry.getValue());
                            }
                            return (Map.Entry) b();
                        }
                    };
                }
            };
        }

        @Override // com.google.common.collect.RangeMap
        public Map<Range<K>, V> asMapOfRanges() {
            return new SubRangeMapAsMap();
        }

        @Override // com.google.common.collect.RangeMap
        public void clear() {
            TreeRangeMap.this.remove(this.f27542a);
        }

        @Override // com.google.common.collect.RangeMap
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof RangeMap) {
                return asMapOfRanges().equals(((RangeMap) obj).asMapOfRanges());
            }
            return false;
        }

        @Override // com.google.common.collect.RangeMap
        @CheckForNull
        public V get(K k4) {
            if (this.f27542a.contains(k4)) {
                return (V) TreeRangeMap.this.get(k4);
            }
            return null;
        }

        @Override // com.google.common.collect.RangeMap
        @CheckForNull
        public Map.Entry<Range<K>, V> getEntry(K k4) {
            Map.Entry<Range<K>, V> entry;
            if (this.f27542a.contains(k4) && (entry = TreeRangeMap.this.getEntry(k4)) != null) {
                return Maps.immutableEntry(entry.getKey().intersection(this.f27542a), entry.getValue());
            }
            return null;
        }

        @Override // com.google.common.collect.RangeMap
        public int hashCode() {
            return asMapOfRanges().hashCode();
        }

        @Override // com.google.common.collect.RangeMap
        public void put(Range<K> range, V v3) {
            Preconditions.checkArgument(this.f27542a.encloses(range), "Cannot put range %s into a subRangeMap(%s)", range, this.f27542a);
            TreeRangeMap.this.put(range, v3);
        }

        @Override // com.google.common.collect.RangeMap
        public void putAll(RangeMap<K, ? extends V> rangeMap) {
            if (rangeMap.asMapOfRanges().isEmpty()) {
                return;
            }
            Range<K> span = rangeMap.span();
            Preconditions.checkArgument(this.f27542a.encloses(span), "Cannot putAll rangeMap with span %s into a subRangeMap(%s)", span, this.f27542a);
            TreeRangeMap.this.putAll(rangeMap);
        }

        @Override // com.google.common.collect.RangeMap
        public void putCoalescing(Range<K> range, V v3) {
            if (!TreeRangeMap.this.f27537a.isEmpty() && this.f27542a.encloses(range)) {
                put(TreeRangeMap.this.e(range, Preconditions.checkNotNull(v3)).intersection(this.f27542a), v3);
            } else {
                put(range, v3);
            }
        }

        @Override // com.google.common.collect.RangeMap
        public void remove(Range<K> range) {
            if (range.isConnected(this.f27542a)) {
                TreeRangeMap.this.remove(range.intersection(this.f27542a));
            }
        }

        @Override // com.google.common.collect.RangeMap
        public Range<K> span() {
            Cut<K> cut;
            Cut<K> i4;
            Map.Entry floorEntry = TreeRangeMap.this.f27537a.floorEntry(this.f27542a.lowerBound);
            if (floorEntry != null && ((RangeMapEntry) floorEntry.getValue()).i().compareTo(this.f27542a.lowerBound) > 0) {
                cut = this.f27542a.lowerBound;
            } else {
                cut = (Cut) TreeRangeMap.this.f27537a.ceilingKey(this.f27542a.lowerBound);
                if (cut == null || cut.compareTo(this.f27542a.upperBound) >= 0) {
                    throw new NoSuchElementException();
                }
            }
            Map.Entry lowerEntry = TreeRangeMap.this.f27537a.lowerEntry(this.f27542a.upperBound);
            if (lowerEntry != null) {
                if (((RangeMapEntry) lowerEntry.getValue()).i().compareTo(this.f27542a.upperBound) >= 0) {
                    i4 = this.f27542a.upperBound;
                } else {
                    i4 = ((RangeMapEntry) lowerEntry.getValue()).i();
                }
                return Range.b(cut, i4);
            }
            throw new NoSuchElementException();
        }

        @Override // com.google.common.collect.RangeMap
        public RangeMap<K, V> subRangeMap(Range<K> range) {
            if (!range.isConnected(this.f27542a)) {
                return TreeRangeMap.this.f();
            }
            return TreeRangeMap.this.subRangeMap(range.intersection(this.f27542a));
        }

        @Override // com.google.common.collect.RangeMap
        public String toString() {
            return asMapOfRanges().toString();
        }
    }

    private TreeRangeMap() {
    }

    public static <K extends Comparable, V> TreeRangeMap<K, V> create() {
        return new TreeRangeMap<>();
    }

    private static <K extends Comparable, V> Range<K> d(Range<K> range, V v3, @CheckForNull Map.Entry<Cut<K>, RangeMapEntry<K, V>> entry) {
        if (entry != null && entry.getValue().getKey().isConnected(range) && entry.getValue().getValue().equals(v3)) {
            return range.span(entry.getValue().getKey());
        }
        return range;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Range<K> e(Range<K> range, V v3) {
        return d(d(range, v3, this.f27537a.lowerEntry(range.lowerBound)), v3, this.f27537a.floorEntry(range.upperBound));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RangeMap<K, V> f() {
        return f27536b;
    }

    private void g(Cut<K> cut, Cut<K> cut2, V v3) {
        this.f27537a.put(cut, new RangeMapEntry<>(cut, cut2, v3));
    }

    @Override // com.google.common.collect.RangeMap
    public Map<Range<K>, V> asDescendingMapOfRanges() {
        return new AsMapOfRanges(this.f27537a.descendingMap().values());
    }

    @Override // com.google.common.collect.RangeMap
    public Map<Range<K>, V> asMapOfRanges() {
        return new AsMapOfRanges(this.f27537a.values());
    }

    @Override // com.google.common.collect.RangeMap
    public void clear() {
        this.f27537a.clear();
    }

    @Override // com.google.common.collect.RangeMap
    public boolean equals(@CheckForNull Object obj) {
        if (obj instanceof RangeMap) {
            return asMapOfRanges().equals(((RangeMap) obj).asMapOfRanges());
        }
        return false;
    }

    @Override // com.google.common.collect.RangeMap
    @CheckForNull
    public V get(K k4) {
        Map.Entry<Range<K>, V> entry = getEntry(k4);
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    @Override // com.google.common.collect.RangeMap
    @CheckForNull
    public Map.Entry<Range<K>, V> getEntry(K k4) {
        Map.Entry<Cut<K>, RangeMapEntry<K, V>> floorEntry = this.f27537a.floorEntry(Cut.e(k4));
        if (floorEntry != null && floorEntry.getValue().f(k4)) {
            return floorEntry.getValue();
        }
        return null;
    }

    @Override // com.google.common.collect.RangeMap
    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    @Override // com.google.common.collect.RangeMap
    public void put(Range<K> range, V v3) {
        if (!range.isEmpty()) {
            Preconditions.checkNotNull(v3);
            remove(range);
            this.f27537a.put(range.lowerBound, new RangeMapEntry<>(range, v3));
        }
    }

    @Override // com.google.common.collect.RangeMap
    public void putAll(RangeMap<K, ? extends V> rangeMap) {
        for (Map.Entry<Range<K>, ? extends V> entry : rangeMap.asMapOfRanges().entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.RangeMap
    public void putCoalescing(Range<K> range, V v3) {
        if (this.f27537a.isEmpty()) {
            put(range, v3);
        } else {
            put(e(range, Preconditions.checkNotNull(v3)), v3);
        }
    }

    @Override // com.google.common.collect.RangeMap
    public void remove(Range<K> range) {
        if (range.isEmpty()) {
            return;
        }
        Map.Entry<Cut<K>, RangeMapEntry<K, V>> lowerEntry = this.f27537a.lowerEntry(range.lowerBound);
        if (lowerEntry != null) {
            RangeMapEntry<K, V> value = lowerEntry.getValue();
            if (value.i().compareTo(range.lowerBound) > 0) {
                if (value.i().compareTo(range.upperBound) > 0) {
                    g(range.upperBound, value.i(), lowerEntry.getValue().getValue());
                }
                g(value.h(), range.lowerBound, lowerEntry.getValue().getValue());
            }
        }
        Map.Entry<Cut<K>, RangeMapEntry<K, V>> lowerEntry2 = this.f27537a.lowerEntry(range.upperBound);
        if (lowerEntry2 != null) {
            RangeMapEntry<K, V> value2 = lowerEntry2.getValue();
            if (value2.i().compareTo(range.upperBound) > 0) {
                g(range.upperBound, value2.i(), lowerEntry2.getValue().getValue());
            }
        }
        this.f27537a.subMap(range.lowerBound, range.upperBound).clear();
    }

    @Override // com.google.common.collect.RangeMap
    public Range<K> span() {
        Map.Entry<Cut<K>, RangeMapEntry<K, V>> firstEntry = this.f27537a.firstEntry();
        Map.Entry<Cut<K>, RangeMapEntry<K, V>> lastEntry = this.f27537a.lastEntry();
        if (firstEntry != null && lastEntry != null) {
            return Range.b(firstEntry.getValue().getKey().lowerBound, lastEntry.getValue().getKey().upperBound);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.RangeMap
    public RangeMap<K, V> subRangeMap(Range<K> range) {
        if (range.equals(Range.all())) {
            return this;
        }
        return new SubRangeMap(range);
    }

    @Override // com.google.common.collect.RangeMap
    public String toString() {
        return this.f27537a.values().toString();
    }
}
