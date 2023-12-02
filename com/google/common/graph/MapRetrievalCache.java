package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Map;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
final class MapRetrievalCache<K, V> extends MapIteratorCache<K, V> {
    @CheckForNull

    /* renamed from: c  reason: collision with root package name */
    private volatile transient CacheEntry<K, V> f27740c;
    @CheckForNull

    /* renamed from: d  reason: collision with root package name */
    private volatile transient CacheEntry<K, V> f27741d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class CacheEntry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f27742a;

        /* renamed from: b  reason: collision with root package name */
        final V f27743b;

        CacheEntry(K k4, V v3) {
            this.f27742a = k4;
            this.f27743b = v3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapRetrievalCache(Map<K, V> map) {
        super(map);
    }

    private void k(CacheEntry<K, V> cacheEntry) {
        this.f27741d = this.f27740c;
        this.f27740c = cacheEntry;
    }

    private void l(K k4, V v3) {
        k(new CacheEntry<>(k4, v3));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.graph.MapIteratorCache
    public void c() {
        super.c();
        this.f27740c = null;
        this.f27741d = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.MapIteratorCache
    @CheckForNull
    public V e(Object obj) {
        Preconditions.checkNotNull(obj);
        V f4 = f(obj);
        if (f4 != null) {
            return f4;
        }
        V g4 = g(obj);
        if (g4 != null) {
            l(obj, g4);
        }
        return g4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.graph.MapIteratorCache
    @CheckForNull
    public V f(@CheckForNull Object obj) {
        V v3 = (V) super.f(obj);
        if (v3 != null) {
            return v3;
        }
        CacheEntry<K, V> cacheEntry = this.f27740c;
        if (cacheEntry != null && cacheEntry.f27742a == obj) {
            return cacheEntry.f27743b;
        }
        CacheEntry<K, V> cacheEntry2 = this.f27741d;
        if (cacheEntry2 != null && cacheEntry2.f27742a == obj) {
            k(cacheEntry2);
            return cacheEntry2.f27743b;
        }
        return null;
    }
}
