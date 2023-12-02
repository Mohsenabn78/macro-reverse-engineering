package com.uchuhimo.collections;

import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"com/uchuhimo/collections/b", "com/uchuhimo/collections/c"}, d2 = {}, k = 4, mv = {1, 4, 0})
/* loaded from: classes6.dex */
public final class BiMapsKt {
    @NotNull
    public static final <K, V> com.google.common.collect.BiMap<K, V> asGuavaBiMap(@NotNull MutableBiMap<K, V> mutableBiMap) {
        return c.a(mutableBiMap);
    }

    @NotNull
    public static final <K, V> MutableBiMap<K, V> asMutableBiMap(@NotNull com.google.common.collect.BiMap<K, V> biMap) {
        return c.b(biMap);
    }

    @NotNull
    public static final <K, V> BiMap<K, V> biMapOf(@NotNull Pair<? extends K, ? extends V> pair) {
        return b.a(pair);
    }

    @NotNull
    public static final <K, V> BiMap<K, V> emptyBiMap() {
        return b.c();
    }

    public static final boolean equals(@NotNull BiMap<?, ?> biMap, @Nullable Object obj) {
        return b.d(biMap, obj);
    }

    public static final int hashCodeOf(@NotNull Map<?, ?> map) {
        return b.e(map);
    }

    @NotNull
    public static final <K, V> MutableBiMap<K, V> mutableBiMapOf(@NotNull Pair<? extends K, ? extends V>... pairArr) {
        return c.c(pairArr);
    }

    @NotNull
    public static final <K, V> BiMap<K, V> toBiMap(@NotNull Map<K, ? extends V> map) {
        return b.f(map);
    }

    @NotNull
    public static final <K, V> MutableBiMap<K, V> toMutableBiMap(@NotNull Map<K, ? extends V> map) {
        return c.d(map);
    }

    @NotNull
    public static final <K, V> BiMap<K, V> biMapOf(@NotNull Pair<? extends K, ? extends V>... pairArr) {
        return b.b(pairArr);
    }
}
