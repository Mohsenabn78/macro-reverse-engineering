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
final class DirectedMultiNetworkConnections<N, E> extends AbstractDirectedNetworkConnections<N, E> {
    @CheckForNull
    @LazyInit

    /* renamed from: d  reason: collision with root package name */
    private transient Reference<Multiset<N>> f27703d;
    @CheckForNull
    @LazyInit

    /* renamed from: e  reason: collision with root package name */
    private transient Reference<Multiset<N>> f27704e;

    private DirectedMultiNetworkConnections(Map<E, N> map, Map<E, N> map2, int i4) {
        super(map, map2, i4);
    }

    @CheckForNull
    private static <T> T o(@CheckForNull Reference<T> reference) {
        if (reference == null) {
            return null;
        }
        return reference.get();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <N, E> DirectedMultiNetworkConnections<N, E> p() {
        return new DirectedMultiNetworkConnections<>(new HashMap(2, 1.0f), new HashMap(2, 1.0f), 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <N, E> DirectedMultiNetworkConnections<N, E> q(Map<E, N> map, Map<E, N> map2, int i4) {
        return new DirectedMultiNetworkConnections<>(ImmutableMap.copyOf((Map) map), ImmutableMap.copyOf((Map) map2), i4);
    }

    private Multiset<N> r() {
        Multiset<N> multiset = (Multiset) o(this.f27703d);
        if (multiset == null) {
            HashMultiset create = HashMultiset.create(this.f27668a.values());
            this.f27703d = new SoftReference(create);
            return create;
        }
        return multiset;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Multiset<N> s() {
        Multiset<N> multiset = (Multiset) o(this.f27704e);
        if (multiset == null) {
            HashMultiset create = HashMultiset.create(this.f27669b.values());
            this.f27704e = new SoftReference(create);
            return create;
        }
        return multiset;
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> b() {
        return Collections.unmodifiableSet(s().elementSet());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> c() {
        return Collections.unmodifiableSet(r().elementSet());
    }

    @Override // com.google.common.graph.AbstractDirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public N f(E e4) {
        N n4 = (N) super.f(e4);
        Multiset multiset = (Multiset) o(this.f27704e);
        if (multiset != null) {
            Preconditions.checkState(multiset.remove(n4));
        }
        return n4;
    }

    @Override // com.google.common.graph.AbstractDirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public N h(E e4, boolean z3) {
        N n4 = (N) super.h(e4, z3);
        Multiset multiset = (Multiset) o(this.f27703d);
        if (multiset != null) {
            Preconditions.checkState(multiset.remove(n4));
        }
        return n4;
    }

    @Override // com.google.common.graph.AbstractDirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public void i(E e4, N n4) {
        super.i(e4, n4);
        Multiset multiset = (Multiset) o(this.f27704e);
        if (multiset != null) {
            Preconditions.checkState(multiset.add(n4));
        }
    }

    @Override // com.google.common.graph.AbstractDirectedNetworkConnections, com.google.common.graph.NetworkConnections
    public void j(E e4, N n4, boolean z3) {
        super.j(e4, n4, z3);
        Multiset multiset = (Multiset) o(this.f27703d);
        if (multiset != null) {
            Preconditions.checkState(multiset.add(n4));
        }
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> l(final N n4) {
        return new MultiEdgesConnecting<E>(this.f27669b, n4) { // from class: com.google.common.graph.DirectedMultiNetworkConnections.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return DirectedMultiNetworkConnections.this.s().count(n4);
            }
        };
    }
}
