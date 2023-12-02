package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ExecutionException;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes5.dex */
public abstract class ForwardingLoadingCache<K, V> extends ForwardingCache<K, V> implements LoadingCache<K, V> {

    /* loaded from: classes5.dex */
    public static abstract class SimpleForwardingLoadingCache<K, V> extends ForwardingLoadingCache<K, V> {

        /* renamed from: a  reason: collision with root package name */
        private final LoadingCache<K, V> f26469a;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.cache.ForwardingLoadingCache, com.google.common.cache.ForwardingCache
        /* renamed from: g */
        public final LoadingCache<K, V> f() {
            return this.f26469a;
        }
    }

    protected ForwardingLoadingCache() {
    }

    @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
    public V apply(K k4) {
        return f().apply(k4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.cache.ForwardingCache
    /* renamed from: g */
    public abstract LoadingCache<K, V> f();

    @Override // com.google.common.cache.LoadingCache
    @CanIgnoreReturnValue
    public V get(K k4) throws ExecutionException {
        return f().get(k4);
    }

    @Override // com.google.common.cache.LoadingCache
    @CanIgnoreReturnValue
    public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
        return f().getAll(iterable);
    }

    @Override // com.google.common.cache.LoadingCache
    @CanIgnoreReturnValue
    public V getUnchecked(K k4) {
        return f().getUnchecked(k4);
    }

    @Override // com.google.common.cache.LoadingCache
    public void refresh(K k4) {
        f().refresh(k4);
    }
}
