package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

@ElementTypesAreNonnullByDefault
@GwtCompatible
/* loaded from: classes5.dex */
public abstract class AbstractCache<K, V> implements Cache<K, V> {

    /* loaded from: classes5.dex */
    public static final class SimpleStatsCounter implements StatsCounter {

        /* renamed from: a  reason: collision with root package name */
        private final LongAddable f26409a = LongAddables.a();

        /* renamed from: b  reason: collision with root package name */
        private final LongAddable f26410b = LongAddables.a();

        /* renamed from: c  reason: collision with root package name */
        private final LongAddable f26411c = LongAddables.a();

        /* renamed from: d  reason: collision with root package name */
        private final LongAddable f26412d = LongAddables.a();

        /* renamed from: e  reason: collision with root package name */
        private final LongAddable f26413e = LongAddables.a();

        /* renamed from: f  reason: collision with root package name */
        private final LongAddable f26414f = LongAddables.a();

        private static long a(long j4) {
            if (j4 < 0) {
                return Long.MAX_VALUE;
            }
            return j4;
        }

        public void incrementBy(StatsCounter statsCounter) {
            CacheStats snapshot = statsCounter.snapshot();
            this.f26409a.add(snapshot.hitCount());
            this.f26410b.add(snapshot.missCount());
            this.f26411c.add(snapshot.loadSuccessCount());
            this.f26412d.add(snapshot.loadExceptionCount());
            this.f26413e.add(snapshot.totalLoadTime());
            this.f26414f.add(snapshot.evictionCount());
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordEviction() {
            this.f26414f.a();
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordHits(int i4) {
            this.f26409a.add(i4);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordLoadException(long j4) {
            this.f26412d.a();
            this.f26413e.add(j4);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordLoadSuccess(long j4) {
            this.f26411c.a();
            this.f26413e.add(j4);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void recordMisses(int i4) {
            this.f26410b.add(i4);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public CacheStats snapshot() {
            return new CacheStats(a(this.f26409a.sum()), a(this.f26410b.sum()), a(this.f26411c.sum()), a(this.f26412d.sum()), a(this.f26413e.sum()), a(this.f26414f.sum()));
        }
    }

    /* loaded from: classes5.dex */
    public interface StatsCounter {
        void recordEviction();

        void recordHits(int i4);

        void recordLoadException(long j4);

        void recordLoadSuccess(long j4);

        void recordMisses(int i4);

        CacheStats snapshot();
    }

    @Override // com.google.common.cache.Cache
    public ConcurrentMap<K, V> asMap() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public V get(K k4, Callable<? extends V> callable) throws ExecutionException {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.cache.Cache
    public ImmutableMap<K, V> getAllPresent(Iterable<? extends Object> iterable) {
        V ifPresent;
        LinkedHashMap newLinkedHashMap = Maps.newLinkedHashMap();
        for (Object obj : iterable) {
            if (!newLinkedHashMap.containsKey(obj) && (ifPresent = getIfPresent(obj)) != null) {
                newLinkedHashMap.put(obj, ifPresent);
            }
        }
        return ImmutableMap.copyOf((Map) newLinkedHashMap);
    }

    @Override // com.google.common.cache.Cache
    public void invalidate(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public void invalidateAll(Iterable<? extends Object> iterable) {
        for (Object obj : iterable) {
            invalidate(obj);
        }
    }

    @Override // com.google.common.cache.Cache
    public void put(K k4, V v3) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.common.cache.Cache
    public long size() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public CacheStats stats() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public void invalidateAll() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public void cleanUp() {
    }
}
