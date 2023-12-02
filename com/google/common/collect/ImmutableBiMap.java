package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class ImmutableBiMap<K, V> extends ImmutableMap<K, V> implements BiMap<K, V> {

    /* loaded from: classes5.dex */
    public static final class Builder<K, V> extends ImmutableMap.Builder<K, V> {
        public Builder() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public /* bridge */ /* synthetic */ ImmutableMap.Builder put(Object obj, Object obj2) {
            return put((Builder<K, V>) obj, obj2);
        }

        Builder(int i4) {
            super(i4);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public ImmutableBiMap<K, V> build() {
            return buildOrThrow();
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @DoNotCall
        @Deprecated
        public ImmutableBiMap<K, V> buildKeepingLast() {
            throw new UnsupportedOperationException("Not supported for bimaps");
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        public ImmutableBiMap<K, V> buildOrThrow() {
            int i4 = this.f26900c;
            if (i4 == 0) {
                return ImmutableBiMap.of();
            }
            if (this.f26898a != null) {
                if (this.f26901d) {
                    this.f26899b = Arrays.copyOf(this.f26899b, i4 * 2);
                }
                ImmutableMap.Builder.d(this.f26899b, this.f26900c, this.f26898a);
            }
            this.f26901d = true;
            return new RegularImmutableBiMap(this.f26899b, this.f26900c);
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> orderEntriesByValue(Comparator<? super V> comparator) {
            super.orderEntriesByValue((Comparator) comparator);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> put(K k4, V v3) {
            super.put((Builder<K, V>) k4, (K) v3);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Map<? extends K, ? extends V> map) {
            super.putAll((Map) map);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry) {
            super.put((Map.Entry) entry);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        @CanIgnoreReturnValue
        public Builder<K, V> putAll(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.putAll((Iterable) iterable);
            return this;
        }
    }

    @J2ktIncompatible
    /* loaded from: classes5.dex */
    private static class SerializedForm<K, V> extends ImmutableMap.SerializedForm<K, V> {
        private static final long serialVersionUID = 0;

        SerializedForm(ImmutableBiMap<K, V> immutableBiMap) {
            super(immutableBiMap);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        /* renamed from: c */
        public Builder<K, V> b(int i4) {
            return new Builder<>(i4);
        }
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    public static <K, V> Builder<K, V> builderWithExpectedSize(int i4) {
        CollectPreconditions.b(i4, "expectedSize");
        return new Builder<>(i4);
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if (map instanceof ImmutableBiMap) {
            ImmutableBiMap<K, V> immutableBiMap = (ImmutableBiMap) map;
            if (!immutableBiMap.j()) {
                return immutableBiMap;
            }
        }
        return copyOf((Iterable) map.entrySet());
    }

    public static <K, V> ImmutableBiMap<K, V> of() {
        return RegularImmutableBiMap.f27334k;
    }

    @SafeVarargs
    public static <K, V> ImmutableBiMap<K, V> ofEntries(Map.Entry<? extends K, ? extends V>... entryArr) {
        return copyOf((Iterable) Arrays.asList(entryArr));
    }

    @J2ktIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.BiMap
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    @CanIgnoreReturnValue
    public final V forcePut(K k4, V v3) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.BiMap
    public abstract ImmutableBiMap<V, K> inverse();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    /* renamed from: m */
    public final ImmutableSet<V> g() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.ImmutableMap
    @J2ktIncompatible
    Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k4, V v3) {
        CollectPreconditions.a(k4, v3);
        return new RegularImmutableBiMap(new Object[]{k4, v3}, 1);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k4, V v3, K k5, V v4) {
        CollectPreconditions.a(k4, v3);
        CollectPreconditions.a(k5, v4);
        return new RegularImmutableBiMap(new Object[]{k4, v3, k5, v4}, 2);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.BiMap
    public ImmutableSet<V> values() {
        return inverse().keySet();
    }

    public static <K, V> ImmutableBiMap<K, V> copyOf(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return new Builder(iterable instanceof Collection ? ((Collection) iterable).size() : 4).putAll((Iterable) iterable).build();
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k4, V v3, K k5, V v4, K k6, V v5) {
        CollectPreconditions.a(k4, v3);
        CollectPreconditions.a(k5, v4);
        CollectPreconditions.a(k6, v5);
        return new RegularImmutableBiMap(new Object[]{k4, v3, k5, v4, k6, v5}, 3);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k4, V v3, K k5, V v4, K k6, V v5, K k7, V v6) {
        CollectPreconditions.a(k4, v3);
        CollectPreconditions.a(k5, v4);
        CollectPreconditions.a(k6, v5);
        CollectPreconditions.a(k7, v6);
        return new RegularImmutableBiMap(new Object[]{k4, v3, k5, v4, k6, v5, k7, v6}, 4);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k4, V v3, K k5, V v4, K k6, V v5, K k7, V v6, K k8, V v7) {
        CollectPreconditions.a(k4, v3);
        CollectPreconditions.a(k5, v4);
        CollectPreconditions.a(k6, v5);
        CollectPreconditions.a(k7, v6);
        CollectPreconditions.a(k8, v7);
        return new RegularImmutableBiMap(new Object[]{k4, v3, k5, v4, k6, v5, k7, v6, k8, v7}, 5);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k4, V v3, K k5, V v4, K k6, V v5, K k7, V v6, K k8, V v7, K k9, V v8) {
        CollectPreconditions.a(k4, v3);
        CollectPreconditions.a(k5, v4);
        CollectPreconditions.a(k6, v5);
        CollectPreconditions.a(k7, v6);
        CollectPreconditions.a(k8, v7);
        CollectPreconditions.a(k9, v8);
        return new RegularImmutableBiMap(new Object[]{k4, v3, k5, v4, k6, v5, k7, v6, k8, v7, k9, v8}, 6);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k4, V v3, K k5, V v4, K k6, V v5, K k7, V v6, K k8, V v7, K k9, V v8, K k10, V v9) {
        CollectPreconditions.a(k4, v3);
        CollectPreconditions.a(k5, v4);
        CollectPreconditions.a(k6, v5);
        CollectPreconditions.a(k7, v6);
        CollectPreconditions.a(k8, v7);
        CollectPreconditions.a(k9, v8);
        CollectPreconditions.a(k10, v9);
        return new RegularImmutableBiMap(new Object[]{k4, v3, k5, v4, k6, v5, k7, v6, k8, v7, k9, v8, k10, v9}, 7);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k4, V v3, K k5, V v4, K k6, V v5, K k7, V v6, K k8, V v7, K k9, V v8, K k10, V v9, K k11, V v10) {
        CollectPreconditions.a(k4, v3);
        CollectPreconditions.a(k5, v4);
        CollectPreconditions.a(k6, v5);
        CollectPreconditions.a(k7, v6);
        CollectPreconditions.a(k8, v7);
        CollectPreconditions.a(k9, v8);
        CollectPreconditions.a(k10, v9);
        CollectPreconditions.a(k11, v10);
        return new RegularImmutableBiMap(new Object[]{k4, v3, k5, v4, k6, v5, k7, v6, k8, v7, k9, v8, k10, v9, k11, v10}, 8);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k4, V v3, K k5, V v4, K k6, V v5, K k7, V v6, K k8, V v7, K k9, V v8, K k10, V v9, K k11, V v10, K k12, V v11) {
        CollectPreconditions.a(k4, v3);
        CollectPreconditions.a(k5, v4);
        CollectPreconditions.a(k6, v5);
        CollectPreconditions.a(k7, v6);
        CollectPreconditions.a(k8, v7);
        CollectPreconditions.a(k9, v8);
        CollectPreconditions.a(k10, v9);
        CollectPreconditions.a(k11, v10);
        CollectPreconditions.a(k12, v11);
        return new RegularImmutableBiMap(new Object[]{k4, v3, k5, v4, k6, v5, k7, v6, k8, v7, k9, v8, k10, v9, k11, v10, k12, v11}, 9);
    }

    public static <K, V> ImmutableBiMap<K, V> of(K k4, V v3, K k5, V v4, K k6, V v5, K k7, V v6, K k8, V v7, K k9, V v8, K k10, V v9, K k11, V v10, K k12, V v11, K k13, V v12) {
        CollectPreconditions.a(k4, v3);
        CollectPreconditions.a(k5, v4);
        CollectPreconditions.a(k6, v5);
        CollectPreconditions.a(k7, v6);
        CollectPreconditions.a(k8, v7);
        CollectPreconditions.a(k9, v8);
        CollectPreconditions.a(k10, v9);
        CollectPreconditions.a(k11, v10);
        CollectPreconditions.a(k12, v11);
        CollectPreconditions.a(k13, v12);
        return new RegularImmutableBiMap(new Object[]{k4, v3, k5, v4, k6, v5, k7, v6, k8, v7, k9, v8, k10, v9, k11, v10, k12, v11, k13, v12}, 10);
    }
}
