package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.cache.LocalCache;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
/* loaded from: classes5.dex */
interface ReferenceEntry<K, V> {
    @CheckForNull
    LocalCache.ValueReference<K, V> a();

    int b();

    void c(ReferenceEntry<K, V> referenceEntry);

    ReferenceEntry<K, V> e();

    void f(LocalCache.ValueReference<K, V> valueReference);

    long g();

    @CheckForNull
    K getKey();

    @CheckForNull
    ReferenceEntry<K, V> getNext();

    void h(long j4);

    void i(long j4);

    ReferenceEntry<K, V> j();

    ReferenceEntry<K, V> l();

    ReferenceEntry<K, V> m();

    long n();

    void o(ReferenceEntry<K, V> referenceEntry);

    void p(ReferenceEntry<K, V> referenceEntry);

    void q(ReferenceEntry<K, V> referenceEntry);
}
