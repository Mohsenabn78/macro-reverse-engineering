package com.google.android.datatransport.runtime.dagger.internal;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public final class MapBuilder<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<K, V> f18728a;

    private MapBuilder(int i4) {
        this.f18728a = DaggerCollections.newLinkedHashMapWithExpectedSize(i4);
    }

    public static <K, V> MapBuilder<K, V> newMapBuilder(int i4) {
        return new MapBuilder<>(i4);
    }

    public Map<K, V> build() {
        if (this.f18728a.size() != 0) {
            return Collections.unmodifiableMap(this.f18728a);
        }
        return Collections.emptyMap();
    }

    public MapBuilder<K, V> put(K k4, V v3) {
        this.f18728a.put(k4, v3);
        return this;
    }

    public MapBuilder<K, V> putAll(Map<K, V> map) {
        this.f18728a.putAll(map);
        return this;
    }
}
