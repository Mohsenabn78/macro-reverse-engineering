package com.koushikdutta.ion.bitmap;

import java.lang.ref.Reference;
import java.util.Hashtable;

/* loaded from: classes6.dex */
public abstract class ReferenceHashtable<K, V, R extends Reference<V>> {

    /* renamed from: a  reason: collision with root package name */
    Hashtable<K, R> f35813a = new Hashtable<>();

    protected abstract R a(V v3);

    public void clear() {
        this.f35813a.clear();
    }

    public V get(K k4) {
        R r4 = this.f35813a.get(k4);
        if (r4 == null) {
            return null;
        }
        V v3 = (V) r4.get();
        if (v3 == null) {
            this.f35813a.remove(k4);
        }
        return v3;
    }

    public V put(K k4, V v3) {
        R put = this.f35813a.put(k4, a(v3));
        if (put == null) {
            return null;
        }
        return (V) put.get();
    }

    public V remove(K k4) {
        R remove = this.f35813a.remove(k4);
        if (remove == null) {
            return null;
        }
        return (V) remove.get();
    }
}
