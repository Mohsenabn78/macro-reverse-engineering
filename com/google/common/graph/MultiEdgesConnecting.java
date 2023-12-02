package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.UnmodifiableIterator;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
abstract class MultiEdgesConnecting<E> extends AbstractSet<E> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<E, ?> f27744a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f27745b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MultiEdgesConnecting(Map<E, ?> map, Object obj) {
        this.f27744a = (Map) Preconditions.checkNotNull(map);
        this.f27745b = Preconditions.checkNotNull(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* renamed from: b */
    public UnmodifiableIterator<E> iterator() {
        final Iterator<Map.Entry<E, ?>> it = this.f27744a.entrySet().iterator();
        return new AbstractIterator<E>() { // from class: com.google.common.graph.MultiEdgesConnecting.1
            @Override // com.google.common.collect.AbstractIterator
            @CheckForNull
            protected E a() {
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    if (MultiEdgesConnecting.this.f27745b.equals(entry.getValue())) {
                        return (E) entry.getKey();
                    }
                }
                return b();
            }
        };
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object obj) {
        return this.f27745b.equals(this.f27744a.get(obj));
    }
}
