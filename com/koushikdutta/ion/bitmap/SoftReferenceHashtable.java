package com.koushikdutta.ion.bitmap;

import java.lang.ref.SoftReference;

/* loaded from: classes6.dex */
public class SoftReferenceHashtable<K, V> extends ReferenceHashtable<K, V, SoftReference<V>> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.koushikdutta.ion.bitmap.ReferenceHashtable
    /* renamed from: b */
    public SoftReference<V> a(V v3) {
        return new SoftReference<>(v3);
    }
}
