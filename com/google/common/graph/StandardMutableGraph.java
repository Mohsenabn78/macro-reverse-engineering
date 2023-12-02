package com.google.common.graph;

import com.google.common.graph.GraphConstants;

/* JADX INFO: Access modifiers changed from: package-private */
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class StandardMutableGraph<N> extends ForwardingGraph<N> implements MutableGraph<N> {

    /* renamed from: a  reason: collision with root package name */
    private final MutableValueGraph<N, GraphConstants.Presence> f27751a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StandardMutableGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        this.f27751a = new StandardMutableValueGraph(abstractGraphBuilder);
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean addNode(N n4) {
        return this.f27751a.addNode(n4);
    }

    @Override // com.google.common.graph.ForwardingGraph
    BaseGraph<N> d() {
        return this.f27751a;
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean putEdge(N n4, N n5) {
        return this.f27751a.putEdgeValue(n4, n5, GraphConstants.Presence.EDGE_EXISTS) == null;
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean removeEdge(N n4, N n5) {
        return this.f27751a.removeEdge(n4, n5) != null;
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean removeNode(N n4) {
        return this.f27751a.removeNode(n4);
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean putEdge(EndpointPair<N> endpointPair) {
        c(endpointPair);
        return putEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @Override // com.google.common.graph.MutableGraph
    public boolean removeEdge(EndpointPair<N> endpointPair) {
        c(endpointPair);
        return removeEdge(endpointPair.nodeU(), endpointPair.nodeV());
    }
}
