package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Objects;

/* JADX INFO: Access modifiers changed from: package-private */
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class StandardMutableNetwork<N, E> extends StandardNetwork<N, E> implements MutableNetwork<N, E> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public StandardMutableNetwork(NetworkBuilder<? super N, ? super E> networkBuilder) {
        super(networkBuilder);
    }

    @CanIgnoreReturnValue
    private NetworkConnections<N, E> i(N n4) {
        boolean z3;
        NetworkConnections<N, E> j4 = j();
        if (this.f27758f.h(n4, j4) == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        return j4;
    }

    private NetworkConnections<N, E> j() {
        if (isDirected()) {
            if (allowsParallelEdges()) {
                return DirectedMultiNetworkConnections.p();
            }
            return DirectedNetworkConnections.n();
        } else if (allowsParallelEdges()) {
            return UndirectedMultiNetworkConnections.p();
        } else {
            return UndirectedNetworkConnections.m();
        }
    }

    @Override // com.google.common.graph.MutableNetwork
    @CanIgnoreReturnValue
    public boolean addEdge(N n4, N n5, E e4) {
        Preconditions.checkNotNull(n4, "nodeU");
        Preconditions.checkNotNull(n5, "nodeV");
        Preconditions.checkNotNull(e4, "edge");
        boolean z3 = false;
        if (g(e4)) {
            EndpointPair<N> incidentNodes = incidentNodes(e4);
            EndpointPair b4 = EndpointPair.b(this, n4, n5);
            Preconditions.checkArgument(incidentNodes.equals(b4), "Edge %s already exists between the following nodes: %s, so it cannot be reused to connect the following nodes: %s.", e4, incidentNodes, b4);
            return false;
        }
        NetworkConnections<N, E> e5 = this.f27758f.e(n4);
        if (!allowsParallelEdges()) {
            Preconditions.checkArgument((e5 == null || !e5.b().contains(n5)) ? true : true, "Nodes %s and %s are already connected by a different edge. To construct a graph that allows parallel edges, call allowsParallelEdges(true) on the Builder.", n4, n5);
        }
        boolean equals = n4.equals(n5);
        if (!allowsSelfLoops()) {
            Preconditions.checkArgument(!equals, "Cannot add self-loop edge on node %s, as self-loops are not allowed. To construct a graph that allows self-loops, call allowsSelfLoops(true) on the Builder.", n4);
        }
        if (e5 == null) {
            e5 = i(n4);
        }
        e5.i(e4, n5);
        NetworkConnections<N, E> e6 = this.f27758f.e(n5);
        if (e6 == null) {
            e6 = i(n5);
        }
        e6.j(e4, n4, equals);
        this.f27759g.h(e4, n4);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    @CanIgnoreReturnValue
    public boolean addNode(N n4) {
        Preconditions.checkNotNull(n4, "node");
        if (h(n4)) {
            return false;
        }
        i(n4);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    @CanIgnoreReturnValue
    public boolean removeEdge(E e4) {
        Preconditions.checkNotNull(e4, "edge");
        N e5 = this.f27759g.e(e4);
        boolean z3 = false;
        if (e5 == null) {
            return false;
        }
        NetworkConnections<N, E> e6 = this.f27758f.e(e5);
        Objects.requireNonNull(e6);
        NetworkConnections<N, E> networkConnections = e6;
        N d4 = networkConnections.d(e4);
        NetworkConnections<N, E> e7 = this.f27758f.e(d4);
        Objects.requireNonNull(e7);
        NetworkConnections<N, E> networkConnections2 = e7;
        networkConnections.f(e4);
        if (allowsSelfLoops() && e5.equals(d4)) {
            z3 = true;
        }
        networkConnections2.h(e4, z3);
        this.f27759g.i(e4);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    @CanIgnoreReturnValue
    public boolean removeNode(N n4) {
        Preconditions.checkNotNull(n4, "node");
        NetworkConnections<N, E> e4 = this.f27758f.e(n4);
        if (e4 == null) {
            return false;
        }
        UnmodifiableIterator<E> it = ImmutableList.copyOf((Collection) e4.k()).iterator();
        while (it.hasNext()) {
            removeEdge(it.next());
        }
        this.f27758f.i(n4);
        return true;
    }

    @Override // com.google.common.graph.MutableNetwork
    @CanIgnoreReturnValue
    public boolean addEdge(EndpointPair<N> endpointPair, E e4) {
        d(endpointPair);
        return addEdge(endpointPair.nodeU(), endpointPair.nodeV(), e4);
    }
}
