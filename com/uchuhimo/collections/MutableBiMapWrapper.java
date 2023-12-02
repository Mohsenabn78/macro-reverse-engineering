package com.uchuhimo.collections;

import androidx.exifinterface.media.ExifInterface;
import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.MethodDelegation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MutableBiMaps.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010'\n\u0002\b\u000b\b\u0000\u0018\u0000 7*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004:\u00017B\u001b\u0012\u0012\u0010,\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010'¢\u0006\u0004\b5\u00106J!\u0010\u0007\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\t\u0010\u0010\u001a\u00020\u000fH\u0096\u0001J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00028\u0001H\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0012J\u001a\u0010\u0014\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00028\u0000H\u0096\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0016\u001a\u00020\u000bH\u0096\u0001J\"\u0010\u0017\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00028\u0001H\u0096\u0001¢\u0006\u0004\b\u0017\u0010\bJ\u001f\u0010\u001a\u001a\u00020\u000f2\u0014\u0010\u0019\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0018H\u0096\u0001J\u001a\u0010\u001b\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0005\u001a\u00028\u0000H\u0096\u0001¢\u0006\u0004\b\u001b\u0010\u0015R&\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR \u0010&\u001a\b\u0012\u0004\u0012\u00028\u00010!8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R&\u0010,\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010'8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R&\u0010/\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010-0!8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b.\u0010%R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00028\u00000!8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b0\u0010%R\u0014\u00104\u001a\u00020\r8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b2\u00103¨\u00068"}, d2 = {"Lcom/uchuhimo/collections/MutableBiMapWrapper;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/uchuhimo/collections/MutableBiMap;", "", "key", "value", "forcePut", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "", "other", "", "equals", "", "hashCode", "", "clear", "containsKey", "(Ljava/lang/Object;)Z", "containsValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "put", "", "from", "putAll", "remove", "a", "Lcom/uchuhimo/collections/MutableBiMap;", "getInverse", "()Lcom/uchuhimo/collections/MutableBiMap;", "inverse", "", "b", "Ljava/util/Set;", "getValues", "()Ljava/util/Set;", "values", "Lcom/google/common/collect/BiMap;", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "Lcom/google/common/collect/BiMap;", "getDelegate$kotlinx_bimap", "()Lcom/google/common/collect/BiMap;", MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX, "", "getEntries", RemoteConfigConstants.ResponseFieldKey.ENTRIES, "getKeys", UserMetadata.KEYDATA_FILENAME, "getSize", "()I", "size", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Lcom/google/common/collect/BiMap;)V", "Companion", "kotlinx-bimap"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes6.dex */
public final class MutableBiMapWrapper<K, V> implements MutableBiMap<K, V>, Map<K, V>, KMutableMap {
    public static final Companion Companion = new Companion(null);
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final MutableBiMap<V, K> f38133a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Set<V> f38134b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final com.google.common.collect.BiMap<K, V> f38135c;

    /* compiled from: MutableBiMaps.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/uchuhimo/collections/MutableBiMapWrapper$Companion;", "", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "()V", "a", "kotlinx-bimap"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes6.dex */
    public static final class Companion {

        /* compiled from: MutableBiMaps.kt */
        @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010'\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00032\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0004B\u001b\u0012\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00020'¢\u0006\u0004\b1\u00102J!\u0010\u0007\u001a\u0004\u0018\u00018\u00032\u0006\u0010\u0005\u001a\u00028\u00022\u0006\u0010\u0006\u001a\u00028\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0096\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\t\u0010\u0010\u001a\u00020\u000fH\u0096\u0001J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00028\u0002H\u0096\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00028\u0003H\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0012J\u001a\u0010\u0014\u001a\u0004\u0018\u00018\u00032\u0006\u0010\u0005\u001a\u00028\u0002H\u0096\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0016\u001a\u00020\u000bH\u0096\u0001J\"\u0010\u0017\u001a\u0004\u0018\u00018\u00032\u0006\u0010\u0005\u001a\u00028\u00022\u0006\u0010\u0006\u001a\u00028\u0003H\u0096\u0001¢\u0006\u0004\b\u0017\u0010\bJ\u001f\u0010\u001a\u001a\u00020\u000f2\u0014\u0010\u0019\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0018H\u0096\u0001J\u001a\u0010\u001b\u001a\u0004\u0018\u00018\u00032\u0006\u0010\u0005\u001a\u00028\u0002H\u0096\u0001¢\u0006\u0004\b\u001b\u0010\u0015R&\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00020\u00038\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR \u0010&\u001a\b\u0012\u0004\u0012\u00028\u00030!8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R \u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00020'8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R&\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030+0!8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001c\u0010%R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00028\u00020!8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b(\u0010%R\u0014\u00100\u001a\u00020\r8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00063"}, d2 = {"Lcom/uchuhimo/collections/MutableBiMapWrapper$Companion$a;", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "Lcom/uchuhimo/collections/MutableBiMap;", "", "key", "value", "forcePut", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "", "other", "", "equals", "", "hashCode", "", "clear", "containsKey", "(Ljava/lang/Object;)Z", "containsValue", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "isEmpty", "put", "", "from", "putAll", "remove", "a", "Lcom/uchuhimo/collections/MutableBiMap;", "getInverse", "()Lcom/uchuhimo/collections/MutableBiMap;", "inverse", "", "b", "Ljava/util/Set;", "getValues", "()Ljava/util/Set;", "values", "Lcom/uchuhimo/collections/MutableBiMapWrapper;", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "Lcom/uchuhimo/collections/MutableBiMapWrapper;", "wrapper", "", RemoteConfigConstants.ResponseFieldKey.ENTRIES, UserMetadata.KEYDATA_FILENAME, "d", "()I", "size", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Lcom/uchuhimo/collections/MutableBiMapWrapper;)V", "kotlinx-bimap"}, k = 1, mv = {1, 4, 0})
        /* loaded from: classes6.dex */
        private static final class a<K, V> implements MutableBiMap<K, V>, Map<K, V>, KMutableMap {
            @NotNull

            /* renamed from: a  reason: collision with root package name */
            private final MutableBiMap<V, K> f38136a;
            @NotNull

            /* renamed from: b  reason: collision with root package name */
            private final Set<V> f38137b;

            /* renamed from: c  reason: collision with root package name */
            private final MutableBiMapWrapper<V, K> f38138c;

            /* renamed from: d  reason: collision with root package name */
            private final /* synthetic */ com.google.common.collect.BiMap f38139d;

            public a(@NotNull MutableBiMapWrapper<V, K> wrapper) {
                Intrinsics.checkParameterIsNotNull(wrapper, "wrapper");
                com.google.common.collect.BiMap<K, V> inverse = wrapper.getDelegate$kotlinx_bimap().inverse();
                Intrinsics.checkExpressionValueIsNotNull(inverse, "wrapper.delegate.inverse()");
                this.f38139d = inverse;
                this.f38138c = wrapper;
                this.f38136a = wrapper;
                Set<V> set = (Set) wrapper.getDelegate$kotlinx_bimap().inverse().values();
                Intrinsics.checkExpressionValueIsNotNull(set, "wrapper.delegate.inverse().values");
                this.f38137b = set;
            }

            @NotNull
            public Set<Map.Entry<K, V>> a() {
                return this.f38139d.entrySet();
            }

            @NotNull
            public Set<K> c() {
                return this.f38139d.keySet();
            }

            @Override // java.util.Map
            public void clear() {
                this.f38139d.clear();
            }

            @Override // java.util.Map
            public boolean containsKey(Object obj) {
                return this.f38139d.containsKey(obj);
            }

            @Override // java.util.Map
            public boolean containsValue(Object obj) {
                return this.f38139d.containsValue(obj);
            }

            public int d() {
                return this.f38139d.size();
            }

            @Override // java.util.Map
            public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
                return a();
            }

            @Override // java.util.Map
            public boolean equals(@Nullable Object obj) {
                return BiMapsKt.equals(this, obj);
            }

            @Override // com.uchuhimo.collections.MutableBiMap
            @Nullable
            public V forcePut(K k4, V v3) {
                return this.f38138c.getDelegate$kotlinx_bimap().inverse().forcePut(k4, v3);
            }

            @Override // java.util.Map
            @Nullable
            public V get(Object obj) {
                return this.f38139d.get(obj);
            }

            @Override // com.uchuhimo.collections.MutableBiMap, com.uchuhimo.collections.BiMap
            @NotNull
            public Set<V> getValues() {
                return this.f38137b;
            }

            @Override // java.util.Map
            public int hashCode() {
                return BiMapsKt.hashCodeOf(this);
            }

            @Override // java.util.Map
            public boolean isEmpty() {
                return this.f38139d.isEmpty();
            }

            @Override // java.util.Map
            public final /* bridge */ Set<K> keySet() {
                return c();
            }

            @Override // com.uchuhimo.collections.MutableBiMap, java.util.Map
            @Nullable
            public V put(K k4, V v3) {
                return (V) this.f38139d.put(k4, v3);
            }

            @Override // java.util.Map
            public void putAll(@NotNull Map<? extends K, ? extends V> from) {
                Intrinsics.checkParameterIsNotNull(from, "from");
                this.f38139d.putAll(from);
            }

            @Override // java.util.Map
            @Nullable
            public V remove(Object obj) {
                return this.f38139d.remove(obj);
            }

            @Override // java.util.Map
            public final /* bridge */ int size() {
                return d();
            }

            @Override // java.util.Map
            public final /* bridge */ Set<V> values() {
                return getValues();
            }

            @Override // com.uchuhimo.collections.BiMap
            @NotNull
            public MutableBiMap<V, K> getInverse() {
                return this.f38136a;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public MutableBiMapWrapper(@NotNull com.google.common.collect.BiMap<K, V> delegate) {
        Intrinsics.checkParameterIsNotNull(delegate, "delegate");
        this.f38135c = delegate;
        this.f38133a = new Companion.a(this);
        Set<V> set = (Set) delegate.values();
        Intrinsics.checkExpressionValueIsNotNull(set, "delegate.values");
        this.f38134b = set;
    }

    @Override // java.util.Map
    public void clear() {
        this.f38135c.clear();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return this.f38135c.containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return this.f38135c.containsValue(obj);
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<K, V>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public boolean equals(@Nullable Object obj) {
        return BiMapsKt.equals(this, obj);
    }

    @Override // com.uchuhimo.collections.MutableBiMap
    @Nullable
    public V forcePut(K k4, V v3) {
        return this.f38135c.forcePut(k4, v3);
    }

    @Override // java.util.Map
    @Nullable
    public V get(Object obj) {
        return this.f38135c.get(obj);
    }

    @NotNull
    public final com.google.common.collect.BiMap<K, V> getDelegate$kotlinx_bimap() {
        return this.f38135c;
    }

    @NotNull
    public Set<Map.Entry<K, V>> getEntries() {
        return this.f38135c.entrySet();
    }

    @NotNull
    public Set<K> getKeys() {
        return this.f38135c.keySet();
    }

    public int getSize() {
        return this.f38135c.size();
    }

    @Override // com.uchuhimo.collections.MutableBiMap, com.uchuhimo.collections.BiMap
    @NotNull
    public Set<V> getValues() {
        return this.f38134b;
    }

    @Override // java.util.Map
    public int hashCode() {
        return BiMapsKt.hashCodeOf(this);
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.f38135c.isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<K> keySet() {
        return getKeys();
    }

    @Override // com.uchuhimo.collections.MutableBiMap, java.util.Map
    @Nullable
    public V put(K k4, V v3) {
        return this.f38135c.put(k4, v3);
    }

    @Override // java.util.Map
    public void putAll(@NotNull Map<? extends K, ? extends V> from) {
        Intrinsics.checkParameterIsNotNull(from, "from");
        this.f38135c.putAll(from);
    }

    @Override // java.util.Map
    @Nullable
    public V remove(Object obj) {
        return this.f38135c.remove(obj);
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<V> values() {
        return getValues();
    }

    @Override // com.uchuhimo.collections.BiMap
    @NotNull
    public MutableBiMap<V, K> getInverse() {
        return this.f38133a;
    }
}
