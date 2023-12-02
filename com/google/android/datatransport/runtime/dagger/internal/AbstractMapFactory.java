package com.google.android.datatransport.runtime.dagger.internal;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Provider;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class AbstractMapFactory<K, V, V2> implements Factory<Map<K, V2>> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<K, Provider<V>> f18720a;

    /* loaded from: classes.dex */
    public static abstract class Builder<K, V, V2> {

        /* renamed from: a  reason: collision with root package name */
        final LinkedHashMap<K, Provider<V>> f18721a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(int i4) {
            this.f18721a = DaggerCollections.newLinkedHashMapWithExpectedSize(i4);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Multi-variable type inference failed */
        public Builder<K, V, V2> put(K k4, Provider<V> provider) {
            this.f18721a.put(Preconditions.checkNotNull(k4, "key"), Preconditions.checkNotNull(provider, "provider"));
            return this;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder<K, V, V2> putAll(Provider<Map<K, V2>> provider) {
            if (provider instanceof DelegateFactory) {
                return putAll(((DelegateFactory) provider).a());
            }
            this.f18721a.putAll(((AbstractMapFactory) provider).f18720a);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractMapFactory(Map<K, Provider<V>> map) {
        this.f18720a = Collections.unmodifiableMap(map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Map<K, Provider<V>> b() {
        return this.f18720a;
    }
}
