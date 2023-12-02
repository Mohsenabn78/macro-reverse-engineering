package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public class MapIteratorCache<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<K, V> f27735a;
    @CheckForNull

    /* renamed from: b  reason: collision with root package name */
    private volatile transient Map.Entry<K, V> f27736b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapIteratorCache(Map<K, V> map) {
        this.f27735a = (Map) Preconditions.checkNotNull(map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f27736b = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean d(@CheckForNull Object obj) {
        if (f(obj) == null && !this.f27735a.containsKey(obj)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CheckForNull
    public V e(Object obj) {
        Preconditions.checkNotNull(obj);
        V f4 = f(obj);
        if (f4 == null) {
            return g(obj);
        }
        return f4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CheckForNull
    public V f(@CheckForNull Object obj) {
        Map.Entry<K, V> entry = this.f27736b;
        if (entry != null && entry.getKey() == obj) {
            return entry.getValue();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CheckForNull
    public final V g(Object obj) {
        Preconditions.checkNotNull(obj);
        return this.f27735a.get(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    @CheckForNull
    public final V h(K k4, V v3) {
        Preconditions.checkNotNull(k4);
        Preconditions.checkNotNull(v3);
        c();
        return this.f27735a.put(k4, v3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    @CheckForNull
    public final V i(Object obj) {
        Preconditions.checkNotNull(obj);
        c();
        return this.f27735a.remove(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<K> j() {
        return new AbstractSet<K>() { // from class: com.google.common.graph.MapIteratorCache.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            /* renamed from: a */
            public UnmodifiableIterator<K> iterator() {
                final Iterator<Map.Entry<K, V>> it = MapIteratorCache.this.f27735a.entrySet().iterator();
                return new UnmodifiableIterator<K>() { // from class: com.google.common.graph.MapIteratorCache.1.1
                    @Override // java.util.Iterator
                    public boolean hasNext() {
                        return it.hasNext();
                    }

                    @Override // java.util.Iterator
                    public K next() {
                        Map.Entry entry = (Map.Entry) it.next();
                        MapIteratorCache.this.f27736b = entry;
                        return (K) entry.getKey();
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object obj) {
                return MapIteratorCache.this.d(obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return MapIteratorCache.this.f27735a.size();
            }
        };
    }
}
