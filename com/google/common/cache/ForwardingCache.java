package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ForwardingObject;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes5.dex */
public abstract class ForwardingCache<K, V> extends ForwardingObject implements Cache<K, V> {

    /* loaded from: classes5.dex */
    public static abstract class SimpleForwardingCache<K, V> extends ForwardingCache<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private final Cache<K, V> f26468a;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
        /* renamed from: f */
        public final Cache<K, V> e() {
            return this.f26468a;
        }
    }

    @Override // com.google.common.cache.Cache
    public ConcurrentMap<K, V> asMap() {
        return e().asMap();
    }

    @Override // com.google.common.cache.Cache
    public void cleanUp() {
        e().cleanUp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingObject
    /* renamed from: f */
    public abstract Cache<K, V> e();

    @Override // com.google.common.cache.Cache
    public V get(K k4, Callable<? extends V> callable) throws ExecutionException {
        return e().get(k4, callable);
    }

    @Override // com.google.common.cache.Cache
    public ImmutableMap<K, V> getAllPresent(Iterable<? extends Object> iterable) {
        return e().getAllPresent(iterable);
    }

    @Override // com.google.common.cache.Cache
    @CheckForNull
    public V getIfPresent(Object obj) {
        return e().getIfPresent(obj);
    }

    @Override // com.google.common.cache.Cache
    public void invalidate(Object obj) {
        e().invalidate(obj);
    }

    @Override // com.google.common.cache.Cache
    public void invalidateAll(Iterable<? extends Object> iterable) {
        e().invalidateAll(iterable);
    }

    @Override // com.google.common.cache.Cache
    public void put(K k4, V v3) {
        e().put(k4, v3);
    }

    @Override // com.google.common.cache.Cache
    public void putAll(Map<? extends K, ? extends V> map) {
        e().putAll(map);
    }

    @Override // com.google.common.cache.Cache
    public long size() {
        return e().size();
    }

    @Override // com.google.common.cache.Cache
    public CacheStats stats() {
        return e().stats();
    }

    @Override // com.google.common.cache.Cache
    public void invalidateAll() {
        e().invalidateAll();
    }
}
