package com.uchuhimo.collections;

import androidx.exifinterface.media.ExifInterface;
import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Map;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.MethodDelegation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: BiMaps.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010&\n\u0002\b\u000e\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004B\u001d\b\u0002\u0012\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b%\u0010&B1\b\u0016\u0012\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0004\b%\u0010)B1\b\u0012\u0012\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004\u0012\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b%\u0010*J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0096\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00028\u0001H\u0096\u0001¢\u0006\u0004\b\u000f\u0010\rJ\u001a\u0010\u0010\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000b\u001a\u00028\u0000H\u0096\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0012\u001a\u00020\u0007H\u0096\u0001R\"\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u00038\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R \u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00010\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR&\u0010\u001e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001d0\u00198\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u001bR\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u00198\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u001bR\u0014\u0010#\u001a\u00020\t8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006+"}, d2 = {"Lcom/uchuhimo/collections/a;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/uchuhimo/collections/BiMap;", "", "", "other", "", "equals", "", "hashCode", "key", "containsKey", "(Ljava/lang/Object;)Z", "value", "containsValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "a", "Lcom/uchuhimo/collections/BiMap;", "_inverse", "getInverse", "()Lcom/uchuhimo/collections/BiMap;", "inverse", "", "getValues", "()Ljava/util/Set;", "values", "", RemoteConfigConstants.ResponseFieldKey.ENTRIES, CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, UserMetadata.KEYDATA_FILENAME, "d", "()I", "size", MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX, MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/util/Map;)V", "forward", "backward", "(Ljava/util/Map;Ljava/util/Map;)V", "(Ljava/util/Map;Lcom/uchuhimo/collections/BiMap;)V", "kotlinx-bimap"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes6.dex */
public final class a<K, V> implements BiMap<K, V>, Map<K, V>, KMappedMarker {

    /* renamed from: a  reason: collision with root package name */
    private BiMap<V, K> f38140a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Map f38141b;

    private a(Map<K, ? extends V> map) {
        this.f38141b = map;
    }

    @NotNull
    public Set<Map.Entry<K, V>> a() {
        return this.f38141b.entrySet();
    }

    @NotNull
    public Set<K> c() {
        return this.f38141b.keySet();
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V compute(K k4, BiFunction<? super K, ? super V, ? extends V> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V computeIfAbsent(K k4, Function<? super K, ? extends V> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V computeIfPresent(K k4, BiFunction<? super K, ? super V, ? extends V> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.f38141b.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.f38141b.containsValue(obj);
    }

    public int d() {
        return this.f38141b.size();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return a();
    }

    @Override // java.util.Map
    public boolean equals(@Nullable Object obj) {
        return BiMapsKt.equals(this, obj);
    }

    @Override // java.util.Map
    @Nullable
    public V get(Object obj) {
        return (V) this.f38141b.get(obj);
    }

    @Override // com.uchuhimo.collections.BiMap
    @NotNull
    public BiMap<V, K> getInverse() {
        BiMap<V, K> biMap = this.f38140a;
        if (biMap == null) {
            Intrinsics.throwUninitializedPropertyAccessException("_inverse");
        }
        return biMap;
    }

    @Override // com.uchuhimo.collections.BiMap
    @NotNull
    public Set<V> getValues() {
        return getInverse().keySet();
    }

    @Override // java.util.Map
    public int hashCode() {
        return BiMapsKt.hashCodeOf(this);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f38141b.isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return c();
    }

    @Override // java.util.Map
    public V merge(K k4, V v3, BiFunction<? super V, ? super V, ? extends V> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V put(K k4, V v3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V putIfAbsent(K k4, V v3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public V replace(K k4, V v3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return d();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<V> values() {
        return getValues();
    }

    @Override // java.util.Map
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean replace(K k4, V v3, V v4) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(@NotNull Map<K, ? extends V> forward, @NotNull Map<V, ? extends K> backward) {
        this(forward);
        Intrinsics.checkParameterIsNotNull(forward, "forward");
        Intrinsics.checkParameterIsNotNull(backward, "backward");
        this.f38140a = new a((Map) backward, (BiMap) this);
    }

    private a(Map<K, ? extends V> map, BiMap<V, K> biMap) {
        this(map);
        this.f38140a = biMap;
    }
}
