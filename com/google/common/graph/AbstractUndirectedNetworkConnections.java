package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
abstract class AbstractUndirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {

    /* renamed from: a  reason: collision with root package name */
    final Map<E, N> f27682a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractUndirectedNetworkConnections(Map<E, N> map) {
        this.f27682a = (Map) Preconditions.checkNotNull(map);
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> b() {
        return a();
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> c() {
        return a();
    }

    @Override // com.google.common.graph.NetworkConnections
    public N d(E e4) {
        N n4 = this.f27682a.get(e4);
        Objects.requireNonNull(n4);
        return n4;
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> e() {
        return k();
    }

    @Override // com.google.common.graph.NetworkConnections
    public N f(E e4) {
        N remove = this.f27682a.remove(e4);
        Objects.requireNonNull(remove);
        return remove;
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> g() {
        return k();
    }

    @Override // com.google.common.graph.NetworkConnections
    @CheckForNull
    public N h(E e4, boolean z3) {
        if (!z3) {
            return f(e4);
        }
        return null;
    }

    @Override // com.google.common.graph.NetworkConnections
    public void i(E e4, N n4) {
        boolean z3;
        if (this.f27682a.put(e4, n4) == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
    }

    @Override // com.google.common.graph.NetworkConnections
    public void j(E e4, N n4, boolean z3) {
        if (!z3) {
            i(e4, n4);
        }
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> k() {
        return Collections.unmodifiableSet(this.f27682a.keySet());
    }
}
