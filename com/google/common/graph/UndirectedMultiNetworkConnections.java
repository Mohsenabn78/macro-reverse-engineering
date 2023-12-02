package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Multiset;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
final class UndirectedMultiNetworkConnections<N, E> extends AbstractUndirectedNetworkConnections<N, E> {
    @CheckForNull
    @LazyInit

    /* renamed from: b  reason: collision with root package name */
    private transient Reference<Multiset<N>> f27788b;

    private UndirectedMultiNetworkConnections(Map<E, N> map) {
        super(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Multiset<N> n() {
        Multiset<N> multiset = (Multiset) o(this.f27788b);
        if (multiset == null) {
            HashMultiset create = HashMultiset.create(this.f27682a.values());
            this.f27788b = new SoftReference(create);
            return create;
        }
        return multiset;
    }

    @CheckForNull
    private static <T> T o(@CheckForNull Reference<T> reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <N, E> UndirectedMultiNetworkConnections<N, E> p() {
        return new UndirectedMultiNetworkConnections<>(new HashMap(2, 1.0f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <N, E> UndirectedMultiNetworkConnections<N, E> q(Map<E, N> map) {
        return new UndirectedMultiNetworkConnections<>(ImmutableMap.copyOf((Map) map));
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> a() {
        return Collections.unmodifiableSet(n().elementSet());
    }

    @Override // com.google.common.graph.AbstractUndirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public N f(E e4) {
        N n4 = (N) super.f(e4);
        Multiset multiset = (Multiset) o(this.f27788b);
        if (multiset != null) {
            Preconditions.checkState(multiset.remove(n4));
        }
        return n4;
    }

    @Override // com.google.common.graph.AbstractUndirectedNetworkConnections, com.google.common.graph.NetworkConnections
    @CheckForNull
    public N h(E e4, boolean z3) {
        if (!z3) {
            return f(e4);
        }
        return null;
    }

    @Override // com.google.common.graph.AbstractUndirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public void i(E e4, N n4) {
        super.i(e4, n4);
        Multiset multiset = (Multiset) o(this.f27788b);
        if (multiset != null) {
            Preconditions.checkState(multiset.add(n4));
        }
    }

    @Override // com.google.common.graph.AbstractUndirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public void j(E e4, N n4, boolean z3) {
        if (!z3) {
            i(e4, n4);
        }
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> l(final N n4) {
        return new MultiEdgesConnecting<E>(this.f27682a, n4) { // from class: com.google.common.graph.UndirectedMultiNetworkConnections.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return UndirectedMultiNetworkConnections.this.n().count(n4);
            }
        };
    }
}
