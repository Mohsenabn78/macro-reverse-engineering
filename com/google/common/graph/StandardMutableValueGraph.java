package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Objects;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class StandardMutableValueGraph<N, V> extends StandardValueGraph<N, V> implements MutableValueGraph<N, V> {

    /* renamed from: f  reason: collision with root package name */
    private final ElementOrder<N> f27752f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StandardMutableValueGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        super(abstractGraphBuilder);
        this.f27752f = (ElementOrder<N>) abstractGraphBuilder.f27675d.a();
    }

    @CanIgnoreReturnValue
    private GraphConnections<N, V> k(N n4) {
        boolean z3;
        GraphConnections<N, V> l4 = l();
        if (this.f27763d.h(n4, l4) == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        return l4;
    }

    private GraphConnections<N, V> l() {
        if (isDirected()) {
            return DirectedGraphConnections.x(this.f27752f);
        }
        return UndirectedGraphConnections.l(this.f27752f);
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    public boolean addNode(N n4) {
        Preconditions.checkNotNull(n4, "node");
        if (h(n4)) {
            return false;
        }
        k(n4);
        return true;
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public ElementOrder<N> incidentEdgeOrder() {
        return this.f27752f;
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    @CheckForNull
    public V putEdgeValue(N n4, N n5, V v3) {
        Preconditions.checkNotNull(n4, "nodeU");
        Preconditions.checkNotNull(n5, "nodeV");
        Preconditions.checkNotNull(v3, "value");
        if (!allowsSelfLoops()) {
            Preconditions.checkArgument(!n4.equals(n5), "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", n4);
        }
        GraphConnections<N, V> e4 = this.f27763d.e(n4);
        if (e4 == null) {
            e4 = k(n4);
        }
        V i4 = e4.i(n5, v3);
        GraphConnections<N, V> e5 = this.f27763d.e(n5);
        if (e5 == null) {
            e5 = k(n5);
        }
        e5.d(n4, v3);
        if (i4 == null) {
            long j4 = this.f27764e + 1;
            this.f27764e = j4;
            Graphs.e(j4);
        }
        return i4;
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    @CheckForNull
    public V removeEdge(N n4, N n5) {
        Preconditions.checkNotNull(n4, "nodeU");
        Preconditions.checkNotNull(n5, "nodeV");
        GraphConnections<N, V> e4 = this.f27763d.e(n4);
        GraphConnections<N, V> e5 = this.f27763d.e(n5);
        if (e4 == null || e5 == null) {
            return null;
        }
        V f4 = e4.f(n5);
        if (f4 != null) {
            e5.g(n4);
            long j4 = this.f27764e - 1;
            this.f27764e = j4;
            Graphs.c(j4);
        }
        return f4;
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    public boolean removeNode(N n4) {
        boolean z3;
        Preconditions.checkNotNull(n4, "node");
        GraphConnections<N, V> e4 = this.f27763d.e(n4);
        if (e4 == null) {
            return false;
        }
        if (allowsSelfLoops() && e4.f(n4) != null) {
            e4.g(n4);
            this.f27764e--;
        }
        for (N n5 : e4.b()) {
            GraphConnections<N, V> g4 = this.f27763d.g(n5);
            Objects.requireNonNull(g4);
            g4.g(n4);
            this.f27764e--;
        }
        if (isDirected()) {
            for (N n6 : e4.c()) {
                GraphConnections<N, V> g5 = this.f27763d.g(n6);
                Objects.requireNonNull(g5);
                if (g5.f(n4) != null) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                Preconditions.checkState(z3);
                this.f27764e--;
            }
        }
        this.f27763d.i(n4);
        Graphs.c(this.f27764e);
        return true;
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    @CheckForNull
    public V removeEdge(EndpointPair<N> endpointPair) {
        c(endpointPair);
        return removeEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @Override // com.google.common.graph.MutableValueGraph
    @CanIgnoreReturnValue
    @CheckForNull
    public V putEdgeValue(EndpointPair<N> endpointPair, V v3) {
        c(endpointPair);
        return putEdgeValue(endpointPair.nodeU(), endpointPair.nodeV(), v3);
    }
}
