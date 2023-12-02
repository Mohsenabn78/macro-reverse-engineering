package com.google.common.graph;

import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class ForwardingNetwork<N, E> extends AbstractNetwork<N, E> {
    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set<E> adjacentEdges(E e4) {
        return e().adjacentEdges(e4);
    }

    @Override // com.google.common.graph.Network
    public Set<N> adjacentNodes(N n4) {
        return e().adjacentNodes(n4);
    }

    @Override // com.google.common.graph.Network
    public boolean allowsParallelEdges() {
        return e().allowsParallelEdges();
    }

    @Override // com.google.common.graph.Network
    public boolean allowsSelfLoops() {
        return e().allowsSelfLoops();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public int degree(N n4) {
        return e().degree(n4);
    }

    abstract Network<N, E> e();

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    @CheckForNull
    public E edgeConnectingOrNull(N n4, N n5) {
        return e().edgeConnectingOrNull(n4, n5);
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<E> edgeOrder() {
        return e().edgeOrder();
    }

    @Override // com.google.common.graph.Network
    public Set<E> edges() {
        return e().edges();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set<E> edgesConnecting(N n4, N n5) {
        return e().edgesConnecting(n4, n5);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public boolean hasEdgeConnecting(N n4, N n5) {
        return e().hasEdgeConnecting(n4, n5);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public int inDegree(N n4) {
        return e().inDegree(n4);
    }

    @Override // com.google.common.graph.Network
    public Set<E> inEdges(N n4) {
        return e().inEdges(n4);
    }

    @Override // com.google.common.graph.Network
    public Set<E> incidentEdges(N n4) {
        return e().incidentEdges(n4);
    }

    @Override // com.google.common.graph.Network
    public EndpointPair<N> incidentNodes(E e4) {
        return e().incidentNodes(e4);
    }

    @Override // com.google.common.graph.Network
    public boolean isDirected() {
        return e().isDirected();
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<N> nodeOrder() {
        return e().nodeOrder();
    }

    @Override // com.google.common.graph.Network
    public Set<N> nodes() {
        return e().nodes();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public int outDegree(N n4) {
        return e().outDegree(n4);
    }

    @Override // com.google.common.graph.Network
    public Set<E> outEdges(N n4) {
        return e().outEdges(n4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction
    public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
        return predecessors((ForwardingNetwork<N, E>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction
    public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
        return successors((ForwardingNetwork<N, E>) obj);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    @CheckForNull
    public E edgeConnectingOrNull(EndpointPair<N> endpointPair) {
        return e().edgeConnectingOrNull(endpointPair);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set<E> edgesConnecting(EndpointPair<N> endpointPair) {
        return e().edgesConnecting(endpointPair);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        return e().hasEdgeConnecting(endpointPair);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction
    public Set<N> predecessors(N n4) {
        return e().predecessors((Network<N, E>) n4);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction
    public Set<N> successors(N n4) {
        return e().successors((Network<N, E>) n4);
    }
}
