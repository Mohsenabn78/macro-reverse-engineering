package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class AbstractMapBasedMultimap<K, V> extends AbstractMultimap<K, V> implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;

    /* renamed from: f  reason: collision with root package name */
    private transient Map<K, Collection<V>> f26629f;

    /* renamed from: g  reason: collision with root package name */
    private transient int f26630g;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class AsMap extends Maps.ViewCachingAbstractMap<K, Collection<V>> {

        /* renamed from: d  reason: collision with root package name */
        final transient Map<K, Collection<V>> f26631d;

        /* loaded from: classes5.dex */
        class AsMapEntries extends Maps.EntrySet<K, Collection<V>> {
            AsMapEntries() {
            }

            @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object obj) {
                return Collections2.f(AsMap.this.f26631d.entrySet(), obj);
            }

            @Override // com.google.common.collect.Maps.EntrySet
            Map<K, Collection<V>> d() {
                return AsMap.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return new AsMapIterator();
            }

            @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@CheckForNull Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                AbstractMapBasedMultimap.this.A(entry.getKey());
                return true;
            }
        }

        /* loaded from: classes5.dex */
        class AsMapIterator implements Iterator<Map.Entry<K, Collection<V>>> {

            /* renamed from: a  reason: collision with root package name */
            final Iterator<Map.Entry<K, Collection<V>>> f26634a;
            @CheckForNull

            /* renamed from: b  reason: collision with root package name */
            Collection<V> f26635b;

            AsMapIterator() {
                this.f26634a = AsMap.this.f26631d.entrySet().iterator();
            }

            @Override // java.util.Iterator
            /* renamed from: a */
            public Map.Entry<K, Collection<V>> next() {
                Map.Entry<K, Collection<V>> next = this.f26634a.next();
                this.f26635b = next.getValue();
                return AsMap.this.g(next);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f26634a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                boolean z3;
                if (this.f26635b != null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Preconditions.checkState(z3, "no calls to next() since the last call to remove()");
                this.f26634a.remove();
                AbstractMapBasedMultimap.q(AbstractMapBasedMultimap.this, this.f26635b.size());
                this.f26635b.clear();
                this.f26635b = null;
            }
        }

        AsMap(Map<K, Collection<V>> map) {
            this.f26631d = map;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        protected Set<Map.Entry<K, Collection<V>>> a() {
            return new AsMapEntries();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.f26631d == AbstractMapBasedMultimap.this.f26629f) {
                AbstractMapBasedMultimap.this.clear();
            } else {
                Iterators.c(new AsMapIterator());
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            return Maps.C(this.f26631d, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* renamed from: e */
        public Collection<V> get(@CheckForNull Object obj) {
            Collection<V> collection = (Collection) Maps.D(this.f26631d, obj);
            if (collection == null) {
                return null;
            }
            return AbstractMapBasedMultimap.this.D(obj, collection);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(@CheckForNull Object obj) {
            if (this != obj && !this.f26631d.equals(obj)) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* renamed from: f */
        public Collection<V> remove(@CheckForNull Object obj) {
            Collection<V> remove = this.f26631d.remove(obj);
            if (remove == null) {
                return null;
            }
            Collection<V> t3 = AbstractMapBasedMultimap.this.t();
            t3.addAll(remove);
            AbstractMapBasedMultimap.q(AbstractMapBasedMultimap.this, remove.size());
            remove.clear();
            return t3;
        }

        Map.Entry<K, Collection<V>> g(Map.Entry<K, Collection<V>> entry) {
            K key = entry.getKey();
            return Maps.immutableEntry(key, AbstractMapBasedMultimap.this.D(key, entry.getValue()));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.f26631d.hashCode();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public Set<K> keySet() {
            return AbstractMapBasedMultimap.this.keySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f26631d.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.f26631d.toString();
        }
    }

    /* loaded from: classes5.dex */
    private abstract class Itr<T> implements Iterator<T> {

        /* renamed from: a  reason: collision with root package name */
        final Iterator<Map.Entry<K, Collection<V>>> f26637a;
        @CheckForNull

        /* renamed from: b  reason: collision with root package name */
        K f26638b = null;
        @CheckForNull

        /* renamed from: c  reason: collision with root package name */
        Collection<V> f26639c = null;

        /* renamed from: d  reason: collision with root package name */
        Iterator<V> f26640d = Iterators.h();

        Itr() {
            this.f26637a = (Iterator<Map.Entry<K, V>>) AbstractMapBasedMultimap.this.f26629f.entrySet().iterator();
        }

        abstract T a(@ParametricNullness K k4, @ParametricNullness V v3);

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.f26637a.hasNext() && !this.f26640d.hasNext()) {
                return false;
            }
            return true;
        }

        @Override // java.util.Iterator
        @ParametricNullness
        public T next() {
            if (!this.f26640d.hasNext()) {
                Map.Entry<K, Collection<V>> next = this.f26637a.next();
                this.f26638b = next.getKey();
                Collection<V> value = next.getValue();
                this.f26639c = value;
                this.f26640d = value.iterator();
            }
            return a(NullnessCasts.a(this.f26638b), this.f26640d.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f26640d.remove();
            Collection<V> collection = this.f26639c;
            Objects.requireNonNull(collection);
            if (collection.isEmpty()) {
                this.f26637a.remove();
            }
            AbstractMapBasedMultimap.o(AbstractMapBasedMultimap.this);
        }
    }

    /* loaded from: classes5.dex */
    private class KeySet extends Maps.KeySet<K, Collection<V>> {
        KeySet(Map<K, Collection<V>> map) {
            super(map);
        }

        @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Iterators.c(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return d().keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(@CheckForNull Object obj) {
            if (this != obj && !d().keySet().equals(obj)) {
                return false;
            }
            return true;
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return d().keySet().hashCode();
        }

        @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            final Iterator<Map.Entry<K, Collection<V>>> it = d().entrySet().iterator();
            return new Iterator<K>() { // from class: com.google.common.collect.AbstractMapBasedMultimap.KeySet.1
                @CheckForNull

                /* renamed from: a  reason: collision with root package name */
                Map.Entry<K, Collection<V>> f26643a;

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return it.hasNext();
                }

                @Override // java.util.Iterator
                @ParametricNullness
                public K next() {
                    Map.Entry<K, Collection<V>> entry = (Map.Entry) it.next();
                    this.f26643a = entry;
                    return entry.getKey();
                }

                @Override // java.util.Iterator
                public void remove() {
                    boolean z3;
                    if (this.f26643a != null) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    Preconditions.checkState(z3, "no calls to next() since the last call to remove()");
                    Collection<V> value = this.f26643a.getValue();
                    it.remove();
                    AbstractMapBasedMultimap.q(AbstractMapBasedMultimap.this, value.size());
                    value.clear();
                    this.f26643a = null;
                }
            };
        }

        @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            int i4;
            Collection<V> remove = d().remove(obj);
            if (remove != null) {
                i4 = remove.size();
                remove.clear();
                AbstractMapBasedMultimap.q(AbstractMapBasedMultimap.this, i4);
            } else {
                i4 = 0;
            }
            if (i4 <= 0) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes5.dex */
    class NavigableAsMap extends AbstractMapBasedMultimap<K, V>.SortedAsMap implements NavigableMap<K, Collection<V>> {
        NavigableAsMap(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> ceilingEntry(@ParametricNullness K k4) {
            Map.Entry<K, Collection<V>> ceilingEntry = j().ceilingEntry(k4);
            if (ceilingEntry == null) {
                return null;
            }
            return g(ceilingEntry);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K ceilingKey(@ParametricNullness K k4) {
            return j().ceilingKey(k4);
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> descendingMap() {
            return new NavigableAsMap(j().descendingMap());
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> firstEntry() {
            Map.Entry<K, Collection<V>> firstEntry = j().firstEntry();
            if (firstEntry == null) {
                return null;
            }
            return g(firstEntry);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> floorEntry(@ParametricNullness K k4) {
            Map.Entry<K, Collection<V>> floorEntry = j().floorEntry(k4);
            if (floorEntry == null) {
                return null;
            }
            return g(floorEntry);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K floorKey(@ParametricNullness K k4) {
            return j().floorKey(k4);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> higherEntry(@ParametricNullness K k4) {
            Map.Entry<K, Collection<V>> higherEntry = j().higherEntry(k4);
            if (higherEntry == null) {
                return null;
            }
            return g(higherEntry);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K higherKey(@ParametricNullness K k4) {
            return j().higherKey(k4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap
        /* renamed from: k */
        public NavigableSet<K> h() {
            return new NavigableKeySet(j());
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: l */
        public NavigableMap<K, Collection<V>> headMap(@ParametricNullness K k4) {
            return headMap(k4, false);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> lastEntry() {
            Map.Entry<K, Collection<V>> lastEntry = j().lastEntry();
            if (lastEntry == null) {
                return null;
            }
            return g(lastEntry);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> lowerEntry(@ParametricNullness K k4) {
            Map.Entry<K, Collection<V>> lowerEntry = j().lowerEntry(k4);
            if (lowerEntry == null) {
                return null;
            }
            return g(lowerEntry);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public K lowerKey(@ParametricNullness K k4) {
            return j().lowerKey(k4);
        }

        @CheckForNull
        Map.Entry<K, Collection<V>> m(Iterator<Map.Entry<K, Collection<V>>> it) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry<K, Collection<V>> next = it.next();
            Collection<V> t3 = AbstractMapBasedMultimap.this.t();
            t3.addAll(next.getValue());
            it.remove();
            return Maps.immutableEntry(next.getKey(), AbstractMapBasedMultimap.this.C(t3));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap
        /* renamed from: n */
        public NavigableMap<K, Collection<V>> j() {
            return (NavigableMap) super.j();
        }

        @Override // java.util.NavigableMap
        public NavigableSet<K> navigableKeySet() {
            return keySet();
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: o */
        public NavigableMap<K, Collection<V>> subMap(@ParametricNullness K k4, @ParametricNullness K k5) {
            return subMap(k4, true, k5, false);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, java.util.SortedMap, java.util.NavigableMap
        /* renamed from: p */
        public NavigableMap<K, Collection<V>> tailMap(@ParametricNullness K k4) {
            return tailMap(k4, true);
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> pollFirstEntry() {
            return m(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        @CheckForNull
        public Map.Entry<K, Collection<V>> pollLastEntry() {
            return m(descendingMap().entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> headMap(@ParametricNullness K k4, boolean z3) {
            return new NavigableAsMap(j().headMap(k4, z3));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedAsMap, com.google.common.collect.AbstractMapBasedMultimap.AsMap, com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        public NavigableSet<K> keySet() {
            return (NavigableSet) super.keySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> subMap(@ParametricNullness K k4, boolean z3, @ParametricNullness K k5, boolean z4) {
            return new NavigableAsMap(j().subMap(k4, z3, k5, z4));
        }

        @Override // java.util.NavigableMap
        public NavigableMap<K, Collection<V>> tailMap(@ParametricNullness K k4, boolean z3) {
            return new NavigableAsMap(j().tailMap(k4, z3));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class NavigableKeySet extends AbstractMapBasedMultimap<K, V>.SortedKeySet implements NavigableSet<K> {
        NavigableKeySet(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K ceiling(@ParametricNullness K k4) {
            return f().ceilingKey(k4);
        }

        @Override // java.util.NavigableSet
        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> descendingSet() {
            return new NavigableKeySet(f().descendingMap());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K floor(@ParametricNullness K k4) {
            return f().floorKey(k4);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: g */
        public NavigableSet<K> headSet(@ParametricNullness K k4) {
            return headSet(k4, false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet
        /* renamed from: h */
        public NavigableMap<K, Collection<V>> f() {
            return (NavigableMap) super.f();
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K higher(@ParametricNullness K k4) {
            return f().higherKey(k4);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: i */
        public NavigableSet<K> subSet(@ParametricNullness K k4, @ParametricNullness K k5) {
            return subSet(k4, true, k5, false);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.SortedKeySet, java.util.SortedSet, java.util.NavigableSet
        /* renamed from: j */
        public NavigableSet<K> tailSet(@ParametricNullness K k4) {
            return tailSet(k4, true);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K lower(@ParametricNullness K k4) {
            return f().lowerKey(k4);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K pollFirst() {
            return (K) Iterators.k(iterator());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public K pollLast() {
            return (K) Iterators.k(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> headSet(@ParametricNullness K k4, boolean z3) {
            return new NavigableKeySet(f().headMap(k4, z3));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> subSet(@ParametricNullness K k4, boolean z3, @ParametricNullness K k5, boolean z4) {
            return new NavigableKeySet(f().subMap(k4, z3, k5, z4));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<K> tailSet(@ParametricNullness K k4, boolean z3) {
            return new NavigableKeySet(f().tailMap(k4, z3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class RandomAccessWrappedList extends AbstractMapBasedMultimap<K, V>.WrappedList implements RandomAccess {
        RandomAccessWrappedList(@ParametricNullness AbstractMapBasedMultimap abstractMapBasedMultimap, K k4, @CheckForNull List<V> list, AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection) {
            super(k4, list, wrappedCollection);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class SortedAsMap extends AbstractMapBasedMultimap<K, V>.AsMap implements SortedMap<K, Collection<V>> {
        @CheckForNull

        /* renamed from: f  reason: collision with root package name */
        SortedSet<K> f26648f;

        SortedAsMap(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedMap
        @CheckForNull
        public Comparator<? super K> comparator() {
            return j().comparator();
        }

        @Override // java.util.SortedMap
        @ParametricNullness
        public K firstKey() {
            return j().firstKey();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        /* renamed from: h */
        public SortedSet<K> c() {
            return new SortedKeySet(j());
        }

        public SortedMap<K, Collection<V>> headMap(@ParametricNullness K k4) {
            return new SortedAsMap(j().headMap(k4));
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.AsMap, com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        /* renamed from: i */
        public SortedSet<K> keySet() {
            SortedSet<K> sortedSet = this.f26648f;
            if (sortedSet == null) {
                SortedSet<K> c4 = c();
                this.f26648f = c4;
                return c4;
            }
            return sortedSet;
        }

        SortedMap<K, Collection<V>> j() {
            return (SortedMap) this.f26631d;
        }

        @Override // java.util.SortedMap
        @ParametricNullness
        public K lastKey() {
            return j().lastKey();
        }

        public SortedMap<K, Collection<V>> subMap(@ParametricNullness K k4, @ParametricNullness K k5) {
            return new SortedAsMap(j().subMap(k4, k5));
        }

        public SortedMap<K, Collection<V>> tailMap(@ParametricNullness K k4) {
            return new SortedAsMap(j().tailMap(k4));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class SortedKeySet extends AbstractMapBasedMultimap<K, V>.KeySet implements SortedSet<K> {
        SortedKeySet(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        @Override // java.util.SortedSet
        @CheckForNull
        public Comparator<? super K> comparator() {
            return f().comparator();
        }

        SortedMap<K, Collection<V>> f() {
            return (SortedMap) super.d();
        }

        @Override // java.util.SortedSet
        @ParametricNullness
        public K first() {
            return f().firstKey();
        }

        public SortedSet<K> headSet(@ParametricNullness K k4) {
            return new SortedKeySet(f().headMap(k4));
        }

        @Override // java.util.SortedSet
        @ParametricNullness
        public K last() {
            return f().lastKey();
        }

        public SortedSet<K> subSet(@ParametricNullness K k4, @ParametricNullness K k5) {
            return new SortedKeySet(f().subMap(k4, k5));
        }

        public SortedSet<K> tailSet(@ParametricNullness K k4) {
            return new SortedKeySet(f().tailMap(k4));
        }
    }

    /* loaded from: classes5.dex */
    class WrappedNavigableSet extends AbstractMapBasedMultimap<K, V>.WrappedSortedSet implements NavigableSet<V> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public WrappedNavigableSet(@ParametricNullness K k4, NavigableSet<V> navigableSet, @CheckForNull AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection) {
            super(k4, navigableSet, wrappedCollection);
        }

        private NavigableSet<V> i(NavigableSet<V> navigableSet) {
            AbstractMapBasedMultimap<K, V>.WrappedCollection b4;
            AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
            K k4 = this.f26651a;
            if (b() == null) {
                b4 = this;
            } else {
                b4 = b();
            }
            return new WrappedNavigableSet(k4, navigableSet, b4);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public V ceiling(@ParametricNullness V v3) {
            return g().ceiling(v3);
        }

        @Override // java.util.NavigableSet
        public Iterator<V> descendingIterator() {
            return new WrappedCollection.WrappedIterator(g().descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> descendingSet() {
            return i(g().descendingSet());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public V floor(@ParametricNullness V v3) {
            return g().floor(v3);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.AbstractMapBasedMultimap.WrappedSortedSet
        /* renamed from: h */
        public NavigableSet<V> g() {
            return (NavigableSet) super.g();
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> headSet(@ParametricNullness V v3, boolean z3) {
            return i(g().headSet(v3, z3));
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public V higher(@ParametricNullness V v3) {
            return g().higher(v3);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public V lower(@ParametricNullness V v3) {
            return g().lower(v3);
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public V pollFirst() {
            return (V) Iterators.k(iterator());
        }

        @Override // java.util.NavigableSet
        @CheckForNull
        public V pollLast() {
            return (V) Iterators.k(descendingIterator());
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> subSet(@ParametricNullness V v3, boolean z3, @ParametricNullness V v4, boolean z4) {
            return i(g().subSet(v3, z3, v4, z4));
        }

        @Override // java.util.NavigableSet
        public NavigableSet<V> tailSet(@ParametricNullness V v3, boolean z3) {
            return i(g().tailSet(v3, z3));
        }
    }

    /* loaded from: classes5.dex */
    class WrappedSet extends AbstractMapBasedMultimap<K, V>.WrappedCollection implements Set<V> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public WrappedSet(@ParametricNullness K k4, Set<V> set) {
            super(k4, set, null);
        }

        @Override // com.google.common.collect.AbstractMapBasedMultimap.WrappedCollection, java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean d4 = Sets.d((Set) this.f26652b, collection);
            if (d4) {
                AbstractMapBasedMultimap.p(AbstractMapBasedMultimap.this, this.f26652b.size() - size);
                f();
            }
            return d4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class WrappedSortedSet extends AbstractMapBasedMultimap<K, V>.WrappedCollection implements SortedSet<V> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public WrappedSortedSet(@ParametricNullness K k4, SortedSet<V> sortedSet, @CheckForNull AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection) {
            super(k4, sortedSet, wrappedCollection);
        }

        @Override // java.util.SortedSet
        @CheckForNull
        public Comparator<? super V> comparator() {
            return g().comparator();
        }

        @Override // java.util.SortedSet
        @ParametricNullness
        public V first() {
            e();
            return g().first();
        }

        SortedSet<V> g() {
            return (SortedSet) c();
        }

        @Override // java.util.SortedSet
        public SortedSet<V> headSet(@ParametricNullness V v3) {
            AbstractMapBasedMultimap<K, V>.WrappedCollection b4;
            e();
            AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
            Object d4 = d();
            SortedSet<V> headSet = g().headSet(v3);
            if (b() == null) {
                b4 = this;
            } else {
                b4 = b();
            }
            return new WrappedSortedSet(d4, headSet, b4);
        }

        @Override // java.util.SortedSet
        @ParametricNullness
        public V last() {
            e();
            return g().last();
        }

        @Override // java.util.SortedSet
        public SortedSet<V> subSet(@ParametricNullness V v3, @ParametricNullness V v4) {
            AbstractMapBasedMultimap<K, V>.WrappedCollection b4;
            e();
            AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
            Object d4 = d();
            SortedSet<V> subSet = g().subSet(v3, v4);
            if (b() == null) {
                b4 = this;
            } else {
                b4 = b();
            }
            return new WrappedSortedSet(d4, subSet, b4);
        }

        @Override // java.util.SortedSet
        public SortedSet<V> tailSet(@ParametricNullness V v3) {
            AbstractMapBasedMultimap<K, V>.WrappedCollection b4;
            e();
            AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
            Object d4 = d();
            SortedSet<V> tailSet = g().tailSet(v3);
            if (b() == null) {
                b4 = this;
            } else {
                b4 = b();
            }
            return new WrappedSortedSet(d4, tailSet, b4);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractMapBasedMultimap(Map<K, Collection<V>> map) {
        Preconditions.checkArgument(map.isEmpty());
        this.f26629f = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A(@CheckForNull Object obj) {
        Collection collection = (Collection) Maps.E(this.f26629f, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.f26630g -= size;
        }
    }

    static /* synthetic */ int n(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i4 = abstractMapBasedMultimap.f26630g;
        abstractMapBasedMultimap.f26630g = i4 + 1;
        return i4;
    }

    static /* synthetic */ int o(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i4 = abstractMapBasedMultimap.f26630g;
        abstractMapBasedMultimap.f26630g = i4 - 1;
        return i4;
    }

    static /* synthetic */ int p(AbstractMapBasedMultimap abstractMapBasedMultimap, int i4) {
        int i5 = abstractMapBasedMultimap.f26630g + i4;
        abstractMapBasedMultimap.f26630g = i5;
        return i5;
    }

    static /* synthetic */ int q(AbstractMapBasedMultimap abstractMapBasedMultimap, int i4) {
        int i5 = abstractMapBasedMultimap.f26630g - i4;
        abstractMapBasedMultimap.f26630g = i5;
        return i5;
    }

    private Collection<V> y(@ParametricNullness K k4) {
        Collection<V> collection = this.f26629f.get(k4);
        if (collection == null) {
            Collection<V> u3 = u(k4);
            this.f26629f.put(k4, u3);
            return u3;
        }
        return collection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> Iterator<E> z(Collection<E> collection) {
        if (collection instanceof List) {
            return ((List) collection).listIterator();
        }
        return collection.iterator();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void B(Map<K, Collection<V>> map) {
        this.f26629f = map;
        this.f26630g = 0;
        for (Collection<V> collection : map.values()) {
            Preconditions.checkArgument(!collection.isEmpty());
            this.f26630g += collection.size();
        }
    }

    <E> Collection<E> C(Collection<E> collection) {
        return Collections.unmodifiableCollection(collection);
    }

    Collection<V> D(@ParametricNullness K k4, Collection<V> collection) {
        return new WrappedCollection(k4, collection, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<V> E(@ParametricNullness K k4, List<V> list, @CheckForNull AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection) {
        if (list instanceof RandomAccess) {
            return new RandomAccessWrappedList(this, k4, list, wrappedCollection);
        }
        return new WrappedList(k4, list, wrappedCollection);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Map<K, Collection<V>> b() {
        return new AsMap(this.f26629f);
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        for (Collection<V> collection : this.f26629f.values()) {
            collection.clear();
        }
        this.f26629f.clear();
        this.f26630g = 0;
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@CheckForNull Object obj) {
        return this.f26629f.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Collection<Map.Entry<K, V>> e() {
        if (this instanceof SetMultimap) {
            return new AbstractMultimap.EntrySet(this);
        }
        return new AbstractMultimap.Entries();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public Collection<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    @Override // com.google.common.collect.AbstractMultimap
    Set<K> f() {
        return new KeySet(this.f26629f);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Multiset<K> g() {
        return new Multimaps.Keys(this);
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection<V> get(@ParametricNullness K k4) {
        Collection<V> collection = this.f26629f.get(k4);
        if (collection == null) {
            collection = u(k4);
        }
        return D(k4, collection);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Collection<V> h() {
        return new AbstractMultimap.Values();
    }

    @Override // com.google.common.collect.AbstractMultimap
    Iterator<Map.Entry<K, V>> i() {
        return new AbstractMapBasedMultimap<K, V>.Itr<Map.Entry<K, V>>(this) { // from class: com.google.common.collect.AbstractMapBasedMultimap.2
            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.AbstractMapBasedMultimap.Itr
            /* renamed from: b */
            public Map.Entry<K, V> a(@ParametricNullness K k4, @ParametricNullness V v3) {
                return Maps.immutableEntry(k4, v3);
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultimap
    Iterator<V> j() {
        return new AbstractMapBasedMultimap<K, V>.Itr<V>(this) { // from class: com.google.common.collect.AbstractMapBasedMultimap.1
            @Override // com.google.common.collect.AbstractMapBasedMultimap.Itr
            @ParametricNullness
            V a(@ParametricNullness K k4, @ParametricNullness V v3) {
                return v3;
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public boolean put(@ParametricNullness K k4, @ParametricNullness V v3) {
        Collection<V> collection = this.f26629f.get(k4);
        if (collection == null) {
            Collection<V> u3 = u(k4);
            if (u3.add(v3)) {
                this.f26630g++;
                this.f26629f.put(k4, u3);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        } else if (collection.add(v3)) {
            this.f26630g++;
            return true;
        } else {
            return false;
        }
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection<V> removeAll(@CheckForNull Object obj) {
        Collection<V> remove = this.f26629f.remove(obj);
        if (remove == null) {
            return x();
        }
        Collection t3 = t();
        t3.addAll(remove);
        this.f26630g -= remove.size();
        remove.clear();
        return (Collection<V>) C(t3);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection<V> replaceValues(@ParametricNullness K k4, Iterable<? extends V> iterable) {
        Iterator<? extends V> it = iterable.iterator();
        if (!it.hasNext()) {
            return removeAll(k4);
        }
        Collection<V> y3 = y(k4);
        Collection t3 = t();
        t3.addAll(y3);
        this.f26630g -= y3.size();
        y3.clear();
        while (it.hasNext()) {
            if (y3.add(it.next())) {
                this.f26630g++;
            }
        }
        return (Collection<V>) C(t3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<K, Collection<V>> s() {
        return this.f26629f;
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.f26630g;
    }

    abstract Collection<V> t();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Collection<V> u(@ParametricNullness K k4) {
        return t();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<K, Collection<V>> v() {
        Map<K, Collection<V>> map = this.f26629f;
        if (map instanceof NavigableMap) {
            return new NavigableAsMap((NavigableMap) this.f26629f);
        }
        if (map instanceof SortedMap) {
            return new SortedAsMap((SortedMap) this.f26629f);
        }
        return new AsMap(this.f26629f);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public Collection<V> values() {
        return super.values();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<K> w() {
        Map<K, Collection<V>> map = this.f26629f;
        if (map instanceof NavigableMap) {
            return new NavigableKeySet((NavigableMap) this.f26629f);
        }
        if (map instanceof SortedMap) {
            return new SortedKeySet((SortedMap) this.f26629f);
        }
        return new KeySet(this.f26629f);
    }

    Collection<V> x() {
        return (Collection<V>) C(t());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class WrappedCollection extends AbstractCollection<V> {
        @ParametricNullness

        /* renamed from: a  reason: collision with root package name */
        final K f26651a;

        /* renamed from: b  reason: collision with root package name */
        Collection<V> f26652b;
        @CheckForNull

        /* renamed from: c  reason: collision with root package name */
        final AbstractMapBasedMultimap<K, V>.WrappedCollection f26653c;
        @CheckForNull

        /* renamed from: d  reason: collision with root package name */
        final Collection<V> f26654d;

        /* JADX INFO: Access modifiers changed from: package-private */
        public WrappedCollection(@ParametricNullness K k4, Collection<V> collection, @CheckForNull AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection) {
            Collection<V> c4;
            this.f26651a = k4;
            this.f26652b = collection;
            this.f26653c = wrappedCollection;
            if (wrappedCollection == null) {
                c4 = null;
            } else {
                c4 = wrappedCollection.c();
            }
            this.f26654d = c4;
        }

        void a() {
            AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection = this.f26653c;
            if (wrappedCollection != null) {
                wrappedCollection.a();
            } else {
                AbstractMapBasedMultimap.this.f26629f.put(this.f26651a, this.f26652b);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(@ParametricNullness V v3) {
            e();
            boolean isEmpty = this.f26652b.isEmpty();
            boolean add = this.f26652b.add(v3);
            if (add) {
                AbstractMapBasedMultimap.n(AbstractMapBasedMultimap.this);
                if (isEmpty) {
                    a();
                }
            }
            return add;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = this.f26652b.addAll(collection);
            if (addAll) {
                AbstractMapBasedMultimap.p(AbstractMapBasedMultimap.this, this.f26652b.size() - size);
                if (size == 0) {
                    a();
                }
            }
            return addAll;
        }

        @CheckForNull
        AbstractMapBasedMultimap<K, V>.WrappedCollection b() {
            return this.f26653c;
        }

        Collection<V> c() {
            return this.f26652b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size = size();
            if (size == 0) {
                return;
            }
            this.f26652b.clear();
            AbstractMapBasedMultimap.q(AbstractMapBasedMultimap.this, size);
            f();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@CheckForNull Object obj) {
            e();
            return this.f26652b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            e();
            return this.f26652b.containsAll(collection);
        }

        @ParametricNullness
        K d() {
            return this.f26651a;
        }

        void e() {
            Collection<V> collection;
            AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection = this.f26653c;
            if (wrappedCollection != null) {
                wrappedCollection.e();
                if (this.f26653c.c() != this.f26654d) {
                    throw new ConcurrentModificationException();
                }
            } else if (this.f26652b.isEmpty() && (collection = (Collection) AbstractMapBasedMultimap.this.f26629f.get(this.f26651a)) != null) {
                this.f26652b = collection;
            }
        }

        @Override // java.util.Collection
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            e();
            return this.f26652b.equals(obj);
        }

        void f() {
            AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection = this.f26653c;
            if (wrappedCollection != null) {
                wrappedCollection.f();
            } else if (this.f26652b.isEmpty()) {
                AbstractMapBasedMultimap.this.f26629f.remove(this.f26651a);
            }
        }

        @Override // java.util.Collection
        public int hashCode() {
            e();
            return this.f26652b.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            e();
            return new WrappedIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(@CheckForNull Object obj) {
            e();
            boolean remove = this.f26652b.remove(obj);
            if (remove) {
                AbstractMapBasedMultimap.o(AbstractMapBasedMultimap.this);
                f();
            }
            return remove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean removeAll = this.f26652b.removeAll(collection);
            if (removeAll) {
                AbstractMapBasedMultimap.p(AbstractMapBasedMultimap.this, this.f26652b.size() - size);
                f();
            }
            return removeAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            Preconditions.checkNotNull(collection);
            int size = size();
            boolean retainAll = this.f26652b.retainAll(collection);
            if (retainAll) {
                AbstractMapBasedMultimap.p(AbstractMapBasedMultimap.this, this.f26652b.size() - size);
                f();
            }
            return retainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            e();
            return this.f26652b.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            e();
            return this.f26652b.toString();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public class WrappedIterator implements Iterator<V> {

            /* renamed from: a  reason: collision with root package name */
            final Iterator<V> f26656a;

            /* renamed from: b  reason: collision with root package name */
            final Collection<V> f26657b;

            WrappedIterator() {
                Collection<V> collection = WrappedCollection.this.f26652b;
                this.f26657b = collection;
                this.f26656a = AbstractMapBasedMultimap.z(collection);
            }

            Iterator<V> a() {
                b();
                return this.f26656a;
            }

            void b() {
                WrappedCollection.this.e();
                if (WrappedCollection.this.f26652b == this.f26657b) {
                    return;
                }
                throw new ConcurrentModificationException();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                b();
                return this.f26656a.hasNext();
            }

            @Override // java.util.Iterator
            @ParametricNullness
            public V next() {
                b();
                return this.f26656a.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f26656a.remove();
                AbstractMapBasedMultimap.o(AbstractMapBasedMultimap.this);
                WrappedCollection.this.f();
            }

            WrappedIterator(Iterator<V> it) {
                this.f26657b = WrappedCollection.this.f26652b;
                this.f26656a = it;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class WrappedList extends AbstractMapBasedMultimap<K, V>.WrappedCollection implements List<V> {

        /* loaded from: classes5.dex */
        private class WrappedListIterator extends AbstractMapBasedMultimap<K, V>.WrappedCollection.WrappedIterator implements ListIterator<V> {
            WrappedListIterator() {
                super();
            }

            private ListIterator<V> c() {
                return (ListIterator) a();
            }

            @Override // java.util.ListIterator
            public void add(@ParametricNullness V v3) {
                boolean isEmpty = WrappedList.this.isEmpty();
                c().add(v3);
                AbstractMapBasedMultimap.n(AbstractMapBasedMultimap.this);
                if (isEmpty) {
                    WrappedList.this.a();
                }
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return c().hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return c().nextIndex();
            }

            @Override // java.util.ListIterator
            @ParametricNullness
            public V previous() {
                return c().previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return c().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(@ParametricNullness V v3) {
                c().set(v3);
            }

            public WrappedListIterator(int i4) {
                super(WrappedList.this.g().listIterator(i4));
            }
        }

        WrappedList(@ParametricNullness K k4, List<V> list, @CheckForNull AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection) {
            super(k4, list, wrappedCollection);
        }

        @Override // java.util.List
        public void add(int i4, @ParametricNullness V v3) {
            e();
            boolean isEmpty = c().isEmpty();
            g().add(i4, v3);
            AbstractMapBasedMultimap.n(AbstractMapBasedMultimap.this);
            if (isEmpty) {
                a();
            }
        }

        @Override // java.util.List
        public boolean addAll(int i4, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = g().addAll(i4, collection);
            if (addAll) {
                AbstractMapBasedMultimap.p(AbstractMapBasedMultimap.this, c().size() - size);
                if (size == 0) {
                    a();
                }
            }
            return addAll;
        }

        List<V> g() {
            return (List) c();
        }

        @Override // java.util.List
        @ParametricNullness
        public V get(int i4) {
            e();
            return g().get(i4);
        }

        @Override // java.util.List
        public int indexOf(@CheckForNull Object obj) {
            e();
            return g().indexOf(obj);
        }

        @Override // java.util.List
        public int lastIndexOf(@CheckForNull Object obj) {
            e();
            return g().lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator() {
            e();
            return new WrappedListIterator();
        }

        @Override // java.util.List
        @ParametricNullness
        public V remove(int i4) {
            e();
            V remove = g().remove(i4);
            AbstractMapBasedMultimap.o(AbstractMapBasedMultimap.this);
            f();
            return remove;
        }

        @Override // java.util.List
        @ParametricNullness
        public V set(int i4, @ParametricNullness V v3) {
            e();
            return g().set(i4, v3);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.List
        public List<V> subList(int i4, int i5) {
            AbstractMapBasedMultimap<K, V>.WrappedCollection b4;
            e();
            AbstractMapBasedMultimap abstractMapBasedMultimap = AbstractMapBasedMultimap.this;
            Object d4 = d();
            List<V> subList = g().subList(i4, i5);
            if (b() == null) {
                b4 = this;
            } else {
                b4 = b();
            }
            return abstractMapBasedMultimap.E(d4, subList, b4);
        }

        @Override // java.util.List
        public ListIterator<V> listIterator(int i4) {
            e();
            return new WrappedListIterator(i4);
        }
    }
}
