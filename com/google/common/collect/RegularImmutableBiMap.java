package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.RegularImmutableMap;
import java.util.Map;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
final class RegularImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {

    /* renamed from: k  reason: collision with root package name */
    static final RegularImmutableBiMap<Object, Object> f27334k = new RegularImmutableBiMap<>();
    @CheckForNull

    /* renamed from: f  reason: collision with root package name */
    private final transient Object f27335f;
    @VisibleForTesting

    /* renamed from: g  reason: collision with root package name */
    final transient Object[] f27336g;

    /* renamed from: h  reason: collision with root package name */
    private final transient int f27337h;

    /* renamed from: i  reason: collision with root package name */
    private final transient int f27338i;

    /* renamed from: j  reason: collision with root package name */
    private final transient RegularImmutableBiMap<V, K> f27339j;

    /* JADX WARN: Multi-variable type inference failed */
    private RegularImmutableBiMap() {
        this.f27335f = null;
        this.f27336g = new Object[0];
        this.f27337h = 0;
        this.f27338i = 0;
        this.f27339j = this;
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> e() {
        return new RegularImmutableMap.EntrySet(this, this.f27336g, this.f27337h, this.f27338i);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> f() {
        return new RegularImmutableMap.KeySet(this, new RegularImmutableMap.KeysOrValuesAsList(this.f27336g, this.f27337h, this.f27338i));
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object obj) {
        V v3 = (V) RegularImmutableMap.q(this.f27335f, this.f27336g, this.f27338i, this.f27337h, obj);
        if (v3 == null) {
            return null;
        }
        return v3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public boolean j() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.f27338i;
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.BiMap
    public ImmutableBiMap<V, K> inverse() {
        return this.f27339j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegularImmutableBiMap(Object[] objArr, int i4) {
        this.f27336g = objArr;
        this.f27338i = i4;
        this.f27337h = 0;
        int i5 = i4 >= 2 ? ImmutableSet.i(i4) : 0;
        this.f27335f = RegularImmutableMap.p(objArr, i4, i5, 0);
        this.f27339j = new RegularImmutableBiMap<>(RegularImmutableMap.p(objArr, i4, i5, 1), objArr, i4, this);
    }

    private RegularImmutableBiMap(@CheckForNull Object obj, Object[] objArr, int i4, RegularImmutableBiMap<V, K> regularImmutableBiMap) {
        this.f27335f = obj;
        this.f27336g = objArr;
        this.f27337h = 1;
        this.f27338i = i4;
        this.f27339j = regularImmutableBiMap;
    }
}
