package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Map;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
final class EdgesConnecting<E> extends AbstractSet<E> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<?, E> f27707a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f27708b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EdgesConnecting(Map<?, E> map, Object obj) {
        this.f27707a = (Map) Preconditions.checkNotNull(map);
        this.f27708b = Preconditions.checkNotNull(obj);
    }

    @CheckForNull
    private E a() {
        return this.f27707a.get(this.f27708b);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: b */
    public UnmodifiableIterator<E> iterator() {
        E a4 = a();
        if (a4 == null) {
            return ImmutableSet.of().iterator();
        }
        return Iterators.singletonIterator(a4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object obj) {
        E a4 = a();
        if (a4 != null && a4.equals(obj)) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        if (a() == null) {
            return 0;
        }
        return 1;
    }
}
