package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.FilteredEntryMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public class FilteredEntryMultimap<K, V> extends AbstractMultimap<K, V> implements FilteredMultimap<K, V> {

    /* renamed from: f  reason: collision with root package name */
    final Multimap<K, V> f26814f;

    /* renamed from: g  reason: collision with root package name */
    final Predicate<? super Map.Entry<K, V>> f26815g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class AsMap extends Maps.ViewCachingAbstractMap<K, Collection<V>> {
        AsMap() {
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        Set<Map.Entry<K, Collection<V>>> a() {
            return new Maps.EntrySet<K, Collection<V>>() { // from class: com.google.common.collect.FilteredEntryMultimap.AsMap.1EntrySetImpl
                @Override // com.google.common.collect.Maps.EntrySet
                Map<K, Collection<V>> d() {
                    return AsMap.this;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                    return new AbstractIterator<Map.Entry<K, Collection<V>>>() { // from class: com.google.common.collect.FilteredEntryMultimap.AsMap.1EntrySetImpl.1

                        /* renamed from: c  reason: collision with root package name */
                        final Iterator<Map.Entry<K, Collection<V>>> f26818c;

                        {
                            this.f26818c = FilteredEntryMultimap.this.f26814f.asMap().entrySet().iterator();
                        }

                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // com.google.common.collect.AbstractIterator
                        @CheckForNull
                        /* renamed from: d */
                        public Map.Entry<K, Collection<V>> a() {
                            while (this.f26818c.hasNext()) {
                                Map.Entry<K, Collection<V>> next = this.f26818c.next();
                                K key = next.getKey();
                                Collection m4 = FilteredEntryMultimap.m(next.getValue(), new ValuePredicate(key));
                                if (!m4.isEmpty()) {
                                    return Maps.immutableEntry(key, m4);
                                }
                            }
                            return b();
                        }
                    };
                }

                @Override // com.google.common.collect.Maps.EntrySet, com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean removeAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.n(Predicates.in(collection));
                }

                @Override // com.google.common.collect.Maps.EntrySet, com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean retainAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.n(Predicates.not(Predicates.in(collection)));
                }

                @Override // com.google.common.collect.Maps.EntrySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return Iterators.size(iterator());
                }
            };
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        Set<K> c() {
            return new Maps.KeySet<K, Collection<V>>() { // from class: com.google.common.collect.FilteredEntryMultimap.AsMap.1KeySetImpl
                @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean remove(@CheckForNull Object obj) {
                    if (AsMap.this.remove(obj) != null) {
                        return true;
                    }
                    return false;
                }

                @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean removeAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.n(Maps.w(Predicates.in(collection)));
                }

                @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean retainAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.n(Maps.w(Predicates.not(Predicates.in(collection))));
                }
            };
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            FilteredEntryMultimap.this.clear();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(@CheckForNull Object obj) {
            if (get(obj) != null) {
                return true;
            }
            return false;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        Collection<Collection<V>> d() {
            return new Maps.Values<K, Collection<V>>() { // from class: com.google.common.collect.FilteredEntryMultimap.AsMap.1ValuesImpl
                @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
                public boolean remove(@CheckForNull Object obj) {
                    if (obj instanceof Collection) {
                        Collection collection = (Collection) obj;
                        Iterator<Map.Entry<K, Collection<V>>> it = FilteredEntryMultimap.this.f26814f.asMap().entrySet().iterator();
                        while (it.hasNext()) {
                            Map.Entry<K, Collection<V>> next = it.next();
                            Collection m4 = FilteredEntryMultimap.m(next.getValue(), new ValuePredicate(next.getKey()));
                            if (!m4.isEmpty() && collection.equals(m4)) {
                                if (m4.size() == next.getValue().size()) {
                                    it.remove();
                                    return true;
                                }
                                m4.clear();
                                return true;
                            }
                        }
                        return false;
                    }
                    return false;
                }

                @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
                public boolean removeAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.n(Maps.Q(Predicates.in(collection)));
                }

                @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
                public boolean retainAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.n(Maps.Q(Predicates.not(Predicates.in(collection))));
                }
            };
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* renamed from: e */
        public Collection<V> get(@CheckForNull Object obj) {
            Collection<V> collection = FilteredEntryMultimap.this.f26814f.asMap().get(obj);
            if (collection == null) {
                return null;
            }
            Collection<V> m4 = FilteredEntryMultimap.m(collection, new ValuePredicate(obj));
            if (m4.isEmpty()) {
                return null;
            }
            return m4;
        }

        @Override // java.util.AbstractMap, java.util.Map
        @CheckForNull
        /* renamed from: f */
        public Collection<V> remove(@CheckForNull Object obj) {
            Collection<V> collection = FilteredEntryMultimap.this.f26814f.asMap().get(obj);
            if (collection == null) {
                return null;
            }
            ArrayList newArrayList = Lists.newArrayList();
            Iterator<V> it = collection.iterator();
            while (it.hasNext()) {
                V next = it.next();
                if (FilteredEntryMultimap.this.o(obj, next)) {
                    it.remove();
                    newArrayList.add(next);
                }
            }
            if (newArrayList.isEmpty()) {
                return null;
            }
            if (FilteredEntryMultimap.this.f26814f instanceof SetMultimap) {
                return Collections.unmodifiableSet(Sets.newLinkedHashSet(newArrayList));
            }
            return Collections.unmodifiableList(newArrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class Keys extends Multimaps.Keys<K, V> {

        /* renamed from: com.google.common.collect.FilteredEntryMultimap$Keys$1  reason: invalid class name */
        /* loaded from: classes5.dex */
        class AnonymousClass1 extends Multisets.EntrySet<K> {
            AnonymousClass1() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static /* synthetic */ boolean g(Predicate predicate, Map.Entry entry) {
                return predicate.apply(Multisets.immutableEntry(entry.getKey(), ((Collection) entry.getValue()).size()));
            }

            private boolean h(final Predicate<? super Multiset.Entry<K>> predicate) {
                return FilteredEntryMultimap.this.n(new Predicate() { // from class: com.google.common.collect.b
                    @Override // com.google.common.base.Predicate
                    public final boolean apply(Object obj) {
                        boolean g4;
                        g4 = FilteredEntryMultimap.Keys.AnonymousClass1.g(Predicate.this, (Map.Entry) obj);
                        return g4;
                    }
                });
            }

            @Override // com.google.common.collect.Multisets.EntrySet
            Multiset<K> d() {
                return Keys.this;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<Multiset.Entry<K>> iterator() {
                return Keys.this.e();
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection<?> collection) {
                return h(Predicates.in(collection));
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection<?> collection) {
                return h(Predicates.not(Predicates.in(collection)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return FilteredEntryMultimap.this.keySet().size();
            }
        }

        Keys() {
            super(FilteredEntryMultimap.this);
        }

        @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public Set<Multiset.Entry<K>> entrySet() {
            return new AnonymousClass1();
        }

        @Override // com.google.common.collect.Multimaps.Keys, com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
        public int remove(@CheckForNull Object obj, int i4) {
            CollectPreconditions.b(i4, "occurrences");
            if (i4 == 0) {
                return count(obj);
            }
            Collection<V> collection = FilteredEntryMultimap.this.f26814f.asMap().get(obj);
            int i5 = 0;
            if (collection == null) {
                return 0;
            }
            Iterator<V> it = collection.iterator();
            while (it.hasNext()) {
                if (FilteredEntryMultimap.this.o(obj, it.next()) && (i5 = i5 + 1) <= i4) {
                    it.remove();
                }
            }
            return i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public final class ValuePredicate implements Predicate<V> {
        @ParametricNullness

        /* renamed from: a  reason: collision with root package name */
        private final K f26824a;

        ValuePredicate(@ParametricNullness K k4) {
            this.f26824a = k4;
        }

        @Override // com.google.common.base.Predicate
        public boolean apply(@ParametricNullness V v3) {
            return FilteredEntryMultimap.this.o(this.f26824a, v3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FilteredEntryMultimap(Multimap<K, V> multimap, Predicate<? super Map.Entry<K, V>> predicate) {
        this.f26814f = (Multimap) Preconditions.checkNotNull(multimap);
        this.f26815g = (Predicate) Preconditions.checkNotNull(predicate);
    }

    static <E> Collection<E> m(Collection<E> collection, Predicate<? super E> predicate) {
        if (collection instanceof Set) {
            return Sets.filter((Set) collection, predicate);
        }
        return Collections2.filter(collection, predicate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o(@ParametricNullness K k4, @ParametricNullness V v3) {
        return this.f26815g.apply(Maps.immutableEntry(k4, v3));
    }

    @Override // com.google.common.collect.FilteredMultimap
    public Multimap<K, V> a() {
        return this.f26814f;
    }

    @Override // com.google.common.collect.AbstractMultimap
    Map<K, Collection<V>> b() {
        return new AsMap();
    }

    @Override // com.google.common.collect.FilteredMultimap
    public Predicate<? super Map.Entry<K, V>> c() {
        return this.f26815g;
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        entries().clear();
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@CheckForNull Object obj) {
        if (asMap().get(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractMultimap
    Collection<Map.Entry<K, V>> e() {
        return m(this.f26814f.entries(), this.f26815g);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Set<K> f() {
        return asMap().keySet();
    }

    @Override // com.google.common.collect.AbstractMultimap
    Multiset<K> g() {
        return new Keys();
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection<V> get(@ParametricNullness K k4) {
        return m(this.f26814f.get(k4), new ValuePredicate(k4));
    }

    @Override // com.google.common.collect.AbstractMultimap
    Collection<V> h() {
        return new FilteredMultimapValues(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Iterator<Map.Entry<K, V>> i() {
        throw new AssertionError("should never be called");
    }

    boolean n(Predicate<? super Map.Entry<K, Collection<V>>> predicate) {
        Iterator<Map.Entry<K, Collection<V>>> it = this.f26814f.asMap().entrySet().iterator();
        boolean z3 = false;
        while (it.hasNext()) {
            Map.Entry<K, Collection<V>> next = it.next();
            K key = next.getKey();
            Collection m4 = m(next.getValue(), new ValuePredicate(key));
            if (!m4.isEmpty() && predicate.apply(Maps.immutableEntry(key, m4))) {
                if (m4.size() == next.getValue().size()) {
                    it.remove();
                } else {
                    m4.clear();
                }
                z3 = true;
            }
        }
        return z3;
    }

    Collection<V> p() {
        if (this.f26814f instanceof SetMultimap) {
            return Collections.emptySet();
        }
        return Collections.emptyList();
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection<V> removeAll(@CheckForNull Object obj) {
        return (Collection) MoreObjects.firstNonNull(asMap().remove(obj), p());
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return entries().size();
    }
}
