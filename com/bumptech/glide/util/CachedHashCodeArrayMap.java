package com.bumptech.glide.util;

import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;

/* loaded from: classes3.dex */
public final class CachedHashCodeArrayMap<K, V> extends ArrayMap<K, V> {

    /* renamed from: a  reason: collision with root package name */
    private int f17566a;

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public void clear() {
        this.f17566a = 0;
        super.clear();
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public int hashCode() {
        if (this.f17566a == 0) {
            this.f17566a = super.hashCode();
        }
        return this.f17566a;
    }

    @Override // androidx.collection.SimpleArrayMap, java.util.Map
    public V put(K k4, V v3) {
        this.f17566a = 0;
        return (V) super.put(k4, v3);
    }

    @Override // androidx.collection.SimpleArrayMap
    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this.f17566a = 0;
        super.putAll(simpleArrayMap);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V removeAt(int i4) {
        this.f17566a = 0;
        return (V) super.removeAt(i4);
    }

    @Override // androidx.collection.SimpleArrayMap
    public V setValueAt(int i4, V v3) {
        this.f17566a = 0;
        return (V) super.setValueAt(i4, v3);
    }
}
