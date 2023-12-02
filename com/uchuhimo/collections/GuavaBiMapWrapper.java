package com.uchuhimo.collections;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.MethodDelegation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MutableBiMaps.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010'\n\u0002\b\u0007\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003B\u001b\u0012\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f¢\u0006\u0004\b1\u00102J\u001e\u0010\u0007\u001a\u00020\u00062\u0014\u0010\u0005\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H\u0016J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u0017\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0010\u0010\u000bJ\b\u0010\u0011\u001a\u00020\tH\u0016J%\u0010\u0012\u001a\u0004\u0018\u00018\u00012\b\u0010\b\u001a\u0004\u0018\u00018\u00002\b\u0010\u000f\u001a\u0004\u0018\u00018\u0001H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0014\u001a\u0004\u0018\u00018\u00012\b\u0010\b\u001a\u0004\u0018\u00018\u00002\b\u0010\u000f\u001a\u0004\u0018\u00018\u0001H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u0014\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u0013\u0010\u0019\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0096\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0016R \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR&\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0014\u0010'\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00010(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R&\u0010.\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010,0(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010*R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010*¨\u00063"}, d2 = {"Lcom/uchuhimo/collections/GuavaBiMapWrapper;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/google/common/collect/BiMap;", "", "from", "", "putAll", "key", "", "containsKey", "(Ljava/lang/Object;)Z", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "remove", "value", "containsValue", "isEmpty", "forcePut", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "put", "inverse", "clear", "", "other", "equals", "", "hashCode", "a", "Lcom/google/common/collect/BiMap;", "_inverse", "Lcom/uchuhimo/collections/MutableBiMap;", "b", "Lcom/uchuhimo/collections/MutableBiMap;", "getDelegate$kotlinx_bimap", "()Lcom/uchuhimo/collections/MutableBiMap;", MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX, "getSize", "()I", "size", "", "getValues", "()Ljava/util/Set;", "values", "", "getEntries", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "getKeys", UserMetadata.KEYDATA_FILENAME, MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Lcom/uchuhimo/collections/MutableBiMap;)V", "kotlinx-bimap"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes6.dex */
public final class GuavaBiMapWrapper<K, V> implements com.google.common.collect.BiMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private final com.google.common.collect.BiMap<V, K> f38131a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final MutableBiMap<K, V> f38132b;

    public GuavaBiMapWrapper(@NotNull MutableBiMap<K, V> delegate) {
        Intrinsics.checkParameterIsNotNull(delegate, "delegate");
        this.f38132b = delegate;
        this.f38131a = BiMapsKt.asGuavaBiMap(delegate.getInverse());
    }

    @Override // java.util.Map
    public void clear() {
        this.f38132b.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.f38132b.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.f38132b.containsValue(obj);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.google.common.collect.BiMap) || ((com.google.common.collect.BiMap) obj).size() != size()) {
            return false;
        }
        for (Map.Entry<K, V> entry : entrySet()) {
            K key = entry.getKey();
            V value = entry.getValue();
            if (value == null) {
                Map map = (Map) obj;
                if (map.get(key) != null || !map.containsKey(key)) {
                    return false;
                }
            } else if (!Intrinsics.areEqual(value, ((Map) obj).get(key))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.common.collect.BiMap
    @Nullable
    public V forcePut(@Nullable K k4, @Nullable V v3) {
        MutableBiMap<K, V> mutableBiMap = this.f38132b;
        if (k4 == null) {
            Intrinsics.throwNpe();
        }
        if (v3 == null) {
            Intrinsics.throwNpe();
        }
        return mutableBiMap.forcePut(k4, v3);
    }

    @Override // java.util.Map
    @Nullable
    public V get(Object obj) {
        return this.f38132b.get(obj);
    }

    @NotNull
    public final MutableBiMap<K, V> getDelegate$kotlinx_bimap() {
        return this.f38132b;
    }

    @NotNull
    public Set<Map.Entry<K, V>> getEntries() {
        return this.f38132b.entrySet();
    }

    @NotNull
    public Set<K> getKeys() {
        return this.f38132b.keySet();
    }

    public int getSize() {
        return this.f38132b.size();
    }

    @Override // com.google.common.collect.BiMap, java.util.Map
    @NotNull
    /* renamed from: getValues */
    public Set<V> values() {
        return (Set) this.f38132b.values();
    }

    @Override // java.util.Map
    public int hashCode() {
        return BiMapsKt.hashCodeOf(this);
    }

    @Override // com.google.common.collect.BiMap
    @NotNull
    public com.google.common.collect.BiMap<V, K> inverse() {
        return this.f38131a;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f38132b.isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @Override // com.google.common.collect.BiMap
    @Nullable
    public V put(@Nullable K k4, @Nullable V v3) {
        MutableBiMap<K, V> mutableBiMap = this.f38132b;
        if (k4 == null) {
            Intrinsics.throwNpe();
        }
        if (v3 == null) {
            Intrinsics.throwNpe();
        }
        return mutableBiMap.put(k4, v3);
    }

    @Override // com.google.common.collect.BiMap
    public void putAll(@NotNull Map<? extends K, ? extends V> from) {
        Intrinsics.checkParameterIsNotNull(from, "from");
        this.f38132b.putAll(from);
    }

    @Override // java.util.Map
    @Nullable
    public V remove(Object obj) {
        return this.f38132b.remove(obj);
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // com.google.common.collect.BiMap
    public final /* bridge */ Set<V> values() {
        return values();
    }
}
