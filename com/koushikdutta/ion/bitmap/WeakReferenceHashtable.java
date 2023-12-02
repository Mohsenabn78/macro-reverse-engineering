package com.koushikdutta.ion.bitmap;

import java.lang.ref.WeakReference;

/* loaded from: classes6.dex */
public class WeakReferenceHashtable<K, V> extends ReferenceHashtable<K, V, WeakReference<V>> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.koushikdutta.ion.bitmap.ReferenceHashtable
    /* renamed from: b */
    public WeakReference<V> a(V v3) {
        return new WeakReference<>(v3);
    }
}
