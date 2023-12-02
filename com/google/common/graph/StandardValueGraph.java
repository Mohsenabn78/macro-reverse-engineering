package com.google.common.graph;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
class StandardValueGraph<N, V> extends AbstractValueGraph<N, V> {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f27760a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f27761b;

    /* renamed from: c  reason: collision with root package name */
    private final ElementOrder<N> f27762c;

    /* renamed from: d  reason: collision with root package name */
    final MapIteratorCache<N, GraphConnections<N, V>> f27763d;

    /* renamed from: e  reason: collision with root package name */
    long f27764e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StandardValueGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder) {
        this(abstractGraphBuilder, abstractGraphBuilder.f27674c.b(abstractGraphBuilder.f27676e.or((Optional<Integer>) 10).intValue()), 0L);
    }

    private final GraphConnections<N, V> g(N n4) {
        GraphConnections<N, V> e4 = this.f27763d.e(n4);
        if (e4 != null) {
            return e4;
        }
        Preconditions.checkNotNull(n4);
        throw new IllegalArgumentException("Node " + n4 + " is not an element of this graph.");
    }

    @CheckForNull
    private final V i(N n4, N n5, @CheckForNull V v3) {
        V e4;
        GraphConnections<N, V> e5 = this.f27763d.e(n4);
        if (e5 == null) {
            e4 = null;
        } else {
            e4 = e5.e(n5);
        }
        if (e4 == null) {
            return v3;
        }
        return e4;
    }

    private final boolean j(N n4, N n5) {
        GraphConnections<N, V> e4 = this.f27763d.e(n4);
        if (e4 != null && e4.b().contains(n5)) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.graph.AbstractBaseGraph
    protected long a() {
        return this.f27764e;
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public Set<N> adjacentNodes(N n4) {
        return g(n4).a();
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public boolean allowsSelfLoops() {
        return this.f27761b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @CheckForNull
    public V edgeValueOrDefault(N n4, N n5, @CheckForNull V v3) {
        return (V) i(Preconditions.checkNotNull(n4), Preconditions.checkNotNull(n5), v3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean h(@CheckForNull N n4) {
        return this.f27763d.d(n4);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(N n4, N n5) {
        return j(Preconditions.checkNotNull(n4), Preconditions.checkNotNull(n5));
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public Set<EndpointPair<N>> incidentEdges(N n4) {
        final GraphConnections<N, V> g4 = g(n4);
        return new IncidentEdgeSet<N>(this, this, n4) { // from class: com.google.common.graph.StandardValueGraph.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<EndpointPair<N>> iterator() {
                return g4.h(this.f27733a);
            }
        };
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public boolean isDirected() {
        return this.f27760a;
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public ElementOrder<N> nodeOrder() {
        return this.f27762c;
    }

    @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
    public Set<N> nodes() {
        return this.f27763d.j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.PredecessorsFunction
    public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
        return predecessors((StandardValueGraph<N, V>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.SuccessorsFunction
    public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
        return successors((StandardValueGraph<N, V>) obj);
    }

    @CheckForNull
    public V edgeValueOrDefault(EndpointPair<N> endpointPair, @CheckForNull V v3) {
        c(endpointPair);
        return i(endpointPair.nodeU(), endpointPair.nodeV(), v3);
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        return b(endpointPair) && j(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.PredecessorsFunction
    public Set<N> predecessors(N n4) {
        return g(n4).c();
    }

    @Override // com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.SuccessorsFunction
    public Set<N> successors(N n4) {
        return g(n4).b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StandardValueGraph(AbstractGraphBuilder<? super N> abstractGraphBuilder, Map<N, GraphConnections<N, V>> map, long j4) {
        MapIteratorCache<N, GraphConnections<N, V>> mapIteratorCache;
        this.f27760a = abstractGraphBuilder.f27672a;
        this.f27761b = abstractGraphBuilder.f27673b;
        this.f27762c = (ElementOrder<N>) abstractGraphBuilder.f27674c.a();
        if (map instanceof TreeMap) {
            mapIteratorCache = new MapRetrievalCache<>(map);
        } else {
            mapIteratorCache = new MapIteratorCache<>(map);
        }
        this.f27763d = mapIteratorCache;
        this.f27764e = Graphs.c(j4);
    }
}
