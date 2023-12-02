package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public class FilteredKeyMultimap<K, V> extends AbstractMultimap<K, V> implements FilteredMultimap<K, V> {

    /* renamed from: f  reason: collision with root package name */
    final Multimap<K, V> f26826f;

    /* renamed from: g  reason: collision with root package name */
    final Predicate<? super K> f26827g;

    /* loaded from: classes5.dex */
    static class AddRejectingList<K, V> extends ForwardingList<V> {
        @ParametricNullness

        /* renamed from: a  reason: collision with root package name */
        final K f26828a;

        AddRejectingList(@ParametricNullness K k4) {
            this.f26828a = k4;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public boolean add(@ParametricNullness V v3) {
            add(0, v3);
            return true;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            addAll(0, collection);
            return true;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingList, com.google.common.collect.ForwardingCollection
        /* renamed from: n */
        public List<V> f() {
            return Collections.emptyList();
        }

        @Override // com.google.common.collect.ForwardingList, java.util.List
        public void add(int i4, @ParametricNullness V v3) {
            Preconditions.checkPositionIndex(i4, 0);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.f26828a);
        }

        @Override // com.google.common.collect.ForwardingList, java.util.List
        @CanIgnoreReturnValue
        public boolean addAll(int i4, Collection<? extends V> collection) {
            Preconditions.checkNotNull(collection);
            Preconditions.checkPositionIndex(i4, 0);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.f26828a);
        }
    }

    /* loaded from: classes5.dex */
    static class AddRejectingSet<K, V> extends ForwardingSet<V> {
        @ParametricNullness

        /* renamed from: a  reason: collision with root package name */
        final K f26829a;

        AddRejectingSet(@ParametricNullness K k4) {
            this.f26829a = k4;
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Queue
        public boolean add(@ParametricNullness V v3) {
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.f26829a);
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            Preconditions.checkNotNull(collection);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.f26829a);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection
        /* renamed from: n */
        public Set<V> f() {
            return Collections.emptySet();
        }
    }

    /* loaded from: classes5.dex */
    class Entries extends ForwardingCollection<Map.Entry<K, V>> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public Entries() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        /* renamed from: f */
        public Collection<Map.Entry<K, V>> e() {
            return Collections2.filter(FilteredKeyMultimap.this.f26826f.entries(), FilteredKeyMultimap.this.c());
        }

        @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
        public boolean remove(@CheckForNull Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (FilteredKeyMultimap.this.f26826f.containsKey(entry.getKey()) && FilteredKeyMultimap.this.f26827g.apply((Object) entry.getKey())) {
                    return FilteredKeyMultimap.this.f26826f.remove(entry.getKey(), entry.getValue());
                }
                return false;
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FilteredKeyMultimap(Multimap<K, V> multimap, Predicate<? super K> predicate) {
        this.f26826f = (Multimap) Preconditions.checkNotNull(multimap);
        this.f26827g = (Predicate) Preconditions.checkNotNull(predicate);
    }

    public Multimap<K, V> a() {
        return this.f26826f;
    }

    @Override // com.google.common.collect.AbstractMultimap
    Map<K, Collection<V>> b() {
        return Maps.filterKeys(this.f26826f.asMap(), this.f26827g);
    }

    @Override // com.google.common.collect.FilteredMultimap
    public Predicate<? super Map.Entry<K, V>> c() {
        return Maps.w(this.f26827g);
    }

    @Override // com.google.common.collect.Multimap
    public void clear() {
        keySet().clear();
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@CheckForNull Object obj) {
        if (this.f26826f.containsKey(obj)) {
            return this.f26827g.apply(obj);
        }
        return false;
    }

    @Override // com.google.common.collect.AbstractMultimap
    Collection<Map.Entry<K, V>> e() {
        return new Entries();
    }

    @Override // com.google.common.collect.AbstractMultimap
    Set<K> f() {
        return Sets.filter(this.f26826f.keySet(), this.f26827g);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Multiset<K> g() {
        return Multisets.filter(this.f26826f.keys(), this.f26827g);
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection<V> get(@ParametricNullness K k4) {
        if (this.f26827g.apply(k4)) {
            return this.f26826f.get(k4);
        }
        if (this.f26826f instanceof SetMultimap) {
            return new AddRejectingSet(k4);
        }
        return new AddRejectingList(k4);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Collection<V> h() {
        return new FilteredMultimapValues(this);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Iterator<Map.Entry<K, V>> i() {
        throw new AssertionError("should never be called");
    }

    Collection<V> l() {
        if (this.f26826f instanceof SetMultimap) {
            return Collections.emptySet();
        }
        return Collections.emptyList();
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Collection<V> removeAll(@CheckForNull Object obj) {
        if (containsKey(obj)) {
            return this.f26826f.removeAll(obj);
        }
        return l();
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        int i4 = 0;
        for (Collection<V> collection : asMap().values()) {
            i4 += collection.size();
        }
        return i4;
    }
}
