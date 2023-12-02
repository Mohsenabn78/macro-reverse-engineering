package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.graph.Graphs;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@Beta
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class Graphs {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public enum NodeVisitState {
        PENDING,
        COMPLETE
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class TransposedGraph<N> extends ForwardingGraph<N> {

        /* renamed from: a  reason: collision with root package name */
        private final Graph<N> f27725a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.google.common.graph.Graphs$TransposedGraph$1  reason: invalid class name */
        /* loaded from: classes5.dex */
        public class AnonymousClass1 extends IncidentEdgeSet<N> {
            AnonymousClass1(BaseGraph baseGraph, Object obj) {
                super(baseGraph, obj);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ EndpointPair b(EndpointPair endpointPair) {
                return EndpointPair.a(TransposedGraph.this.d(), endpointPair.nodeV(), endpointPair.nodeU());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<EndpointPair<N>> iterator() {
                return Iterators.transform(TransposedGraph.this.d().incidentEdges(this.f27733a).iterator(), new Function() { // from class: com.google.common.graph.l
                    @Override // com.google.common.base.Function
                    public final Object apply(Object obj) {
                        EndpointPair b4;
                        b4 = Graphs.TransposedGraph.AnonymousClass1.this.b((EndpointPair) obj);
                        return b4;
                    }
                });
            }
        }

        TransposedGraph(Graph<N> graph) {
            this.f27725a = graph;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.graph.ForwardingGraph
        /* renamed from: f */
        public Graph<N> d() {
            return this.f27725a;
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean hasEdgeConnecting(N n4, N n5) {
            return d().hasEdgeConnecting(n5, n4);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int inDegree(N n4) {
            return d().outDegree(n4);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public Set<EndpointPair<N>> incidentEdges(N n4) {
            return new AnonymousClass1(this, n4);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int outDegree(N n4) {
            return d().inDegree(n4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.PredecessorsFunction
        public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
            return predecessors((TransposedGraph<N>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.SuccessorsFunction
        public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
            return successors((TransposedGraph<N>) obj);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
            return d().hasEdgeConnecting(Graphs.g(endpointPair));
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.PredecessorsFunction
        public Set<N> predecessors(N n4) {
            return d().successors((Graph<N>) n4);
        }

        @Override // com.google.common.graph.ForwardingGraph, com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.SuccessorsFunction
        public Set<N> successors(N n4) {
            return d().predecessors((Graph<N>) n4);
        }
    }

    /* loaded from: classes5.dex */
    private static class TransposedNetwork<N, E> extends ForwardingNetwork<N, E> {

        /* renamed from: a  reason: collision with root package name */
        private final Network<N, E> f27727a;

        TransposedNetwork(Network<N, E> network) {
            this.f27727a = network;
        }

        @Override // com.google.common.graph.ForwardingNetwork
        Network<N, E> e() {
            return this.f27727a;
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        @CheckForNull
        public E edgeConnectingOrNull(N n4, N n5) {
            return e().edgeConnectingOrNull(n5, n4);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public Set<E> edgesConnecting(N n4, N n5) {
            return e().edgesConnecting(n5, n4);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public boolean hasEdgeConnecting(N n4, N n5) {
            return e().hasEdgeConnecting(n5, n4);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public int inDegree(N n4) {
            return e().outDegree(n4);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network
        public Set<E> inEdges(N n4) {
            return e().outEdges(n4);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network
        public EndpointPair<N> incidentNodes(E e4) {
            EndpointPair<N> incidentNodes = e().incidentNodes(e4);
            return EndpointPair.b(this.f27727a, incidentNodes.nodeV(), incidentNodes.nodeU());
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public int outDegree(N n4) {
            return e().inDegree(n4);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.Network
        public Set<E> outEdges(N n4) {
            return e().inEdges(n4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction
        public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
            return predecessors((TransposedNetwork<N, E>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction
        public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
            return successors((TransposedNetwork<N, E>) obj);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        @CheckForNull
        public E edgeConnectingOrNull(EndpointPair<N> endpointPair) {
            return e().edgeConnectingOrNull(Graphs.g(endpointPair));
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public Set<E> edgesConnecting(EndpointPair<N> endpointPair) {
            return e().edgesConnecting(Graphs.g(endpointPair));
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
        public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
            return e().hasEdgeConnecting(Graphs.g(endpointPair));
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction
        public Set<N> predecessors(N n4) {
            return e().successors((Network<N, E>) n4);
        }

        @Override // com.google.common.graph.ForwardingNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction
        public Set<N> successors(N n4) {
            return e().predecessors((Network<N, E>) n4);
        }
    }

    /* loaded from: classes5.dex */
    private static class TransposedValueGraph<N, V> extends ForwardingValueGraph<N, V> {

        /* renamed from: a  reason: collision with root package name */
        private final ValueGraph<N, V> f27728a;

        TransposedValueGraph(ValueGraph<N, V> valueGraph) {
            this.f27728a = valueGraph;
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.ValueGraph
        @CheckForNull
        public V edgeValueOrDefault(N n4, N n5, @CheckForNull V v3) {
            return g().edgeValueOrDefault(n5, n4, v3);
        }

        @Override // com.google.common.graph.ForwardingValueGraph
        ValueGraph<N, V> g() {
            return this.f27728a;
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean hasEdgeConnecting(N n4, N n5) {
            return g().hasEdgeConnecting(n5, n4);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int inDegree(N n4) {
            return g().outDegree(n4);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public int outDegree(N n4) {
            return g().inDegree(n4);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.PredecessorsFunction
        public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
            return predecessors((TransposedValueGraph<N, V>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.SuccessorsFunction
        public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
            return successors((TransposedValueGraph<N, V>) obj);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.ValueGraph
        @CheckForNull
        public V edgeValueOrDefault(EndpointPair<N> endpointPair, @CheckForNull V v3) {
            return g().edgeValueOrDefault(Graphs.g(endpointPair), v3);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
            return g().hasEdgeConnecting(Graphs.g(endpointPair));
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.PredecessorsFunction
        public Set<N> predecessors(N n4) {
            return g().successors((ValueGraph<N, V>) n4);
        }

        @Override // com.google.common.graph.ForwardingValueGraph, com.google.common.graph.AbstractValueGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.SuccessorsFunction
        public Set<N> successors(N n4) {
            return g().predecessors((ValueGraph<N, V>) n4);
        }
    }

    private Graphs() {
    }

    private static boolean a(Graph<?> graph, Object obj, @CheckForNull Object obj2) {
        if (!graph.isDirected() && Objects.equal(obj2, obj)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public static int b(int i4) {
        boolean z3;
        if (i4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Not true that %s is non-negative.", i4);
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public static long c(long j4) {
        boolean z3;
        if (j4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Not true that %s is non-negative.", j4);
        return j4;
    }

    public static <N> MutableGraph<N> copyOf(Graph<N> graph) {
        MutableGraph<N> mutableGraph = (MutableGraph<N>) GraphBuilder.from(graph).expectedNodeCount(graph.nodes().size()).build();
        for (N n4 : graph.nodes()) {
            mutableGraph.addNode(n4);
        }
        for (EndpointPair<N> endpointPair : graph.edges()) {
            mutableGraph.putEdge(endpointPair.nodeU(), endpointPair.nodeV());
        }
        return mutableGraph;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public static int d(int i4) {
        boolean z3;
        if (i4 > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Not true that %s is positive.", i4);
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public static long e(long j4) {
        boolean z3;
        if (j4 > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Not true that %s is positive.", j4);
        return j4;
    }

    private static <N> boolean f(Graph<N> graph, Map<Object, NodeVisitState> map, N n4, @CheckForNull N n5) {
        NodeVisitState nodeVisitState = map.get(n4);
        if (nodeVisitState == NodeVisitState.COMPLETE) {
            return false;
        }
        NodeVisitState nodeVisitState2 = NodeVisitState.PENDING;
        if (nodeVisitState == nodeVisitState2) {
            return true;
        }
        map.put(n4, nodeVisitState2);
        for (N n6 : graph.successors((Graph<N>) n4)) {
            if (a(graph, n6, n5) && f(graph, map, n6, n4)) {
                return true;
            }
        }
        map.put(n4, NodeVisitState.COMPLETE);
        return false;
    }

    static <N> EndpointPair<N> g(EndpointPair<N> endpointPair) {
        if (endpointPair.isOrdered()) {
            return EndpointPair.ordered(endpointPair.target(), endpointPair.source());
        }
        return endpointPair;
    }

    public static <N> boolean hasCycle(Graph<N> graph) {
        int size = graph.edges().size();
        if (size == 0) {
            return false;
        }
        if (graph.isDirected() || size < graph.nodes().size()) {
            HashMap newHashMapWithExpectedSize = Maps.newHashMapWithExpectedSize(graph.nodes().size());
            for (N n4 : graph.nodes()) {
                if (f(graph, newHashMapWithExpectedSize, n4, null)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public static <N> MutableGraph<N> inducedSubgraph(Graph<N> graph, Iterable<? extends N> iterable) {
        MutableGraph<N> mutableGraph;
        if (iterable instanceof Collection) {
            mutableGraph = GraphBuilder.from(graph).expectedNodeCount(((Collection) iterable).size()).build();
        } else {
            mutableGraph = GraphBuilder.from(graph).build();
        }
        for (N n4 : iterable) {
            mutableGraph.addNode(n4);
        }
        for (N n5 : mutableGraph.nodes()) {
            for (N n6 : graph.successors((Graph<N>) n5)) {
                if (mutableGraph.nodes().contains(n6)) {
                    mutableGraph.putEdge(n5, n6);
                }
            }
        }
        return mutableGraph;
    }

    public static <N> Set<N> reachableNodes(Graph<N> graph, N n4) {
        Preconditions.checkArgument(graph.nodes().contains(n4), "Node %s is not an element of this graph.", n4);
        return ImmutableSet.copyOf(Traverser.forGraph(graph).breadthFirst((Traverser) n4));
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.common.graph.MutableGraph, com.google.common.graph.Graph<N>] */
    public static <N> Graph<N> transitiveClosure(Graph<N> graph) {
        ?? build = GraphBuilder.from(graph).allowsSelfLoops(true).build();
        if (graph.isDirected()) {
            for (N n4 : graph.nodes()) {
                for (Object obj : reachableNodes(graph, n4)) {
                    build.putEdge(n4, obj);
                }
            }
        } else {
            HashSet hashSet = new HashSet();
            for (N n5 : graph.nodes()) {
                if (!hashSet.contains(n5)) {
                    Set reachableNodes = reachableNodes(graph, n5);
                    hashSet.addAll(reachableNodes);
                    int i4 = 1;
                    for (Object obj2 : reachableNodes) {
                        int i5 = i4 + 1;
                        for (Object obj3 : Iterables.limit(reachableNodes, i4)) {
                            build.putEdge(obj2, obj3);
                        }
                        i4 = i5;
                    }
                }
            }
        }
        return build;
    }

    public static <N> Graph<N> transpose(Graph<N> graph) {
        if (graph.isDirected()) {
            if (graph instanceof TransposedGraph) {
                return ((TransposedGraph) graph).f27725a;
            }
            return new TransposedGraph(graph);
        }
        return graph;
    }

    public static <N, V> ValueGraph<N, V> transpose(ValueGraph<N, V> valueGraph) {
        if (valueGraph.isDirected()) {
            if (valueGraph instanceof TransposedValueGraph) {
                return ((TransposedValueGraph) valueGraph).f27728a;
            }
            return new TransposedValueGraph(valueGraph);
        }
        return valueGraph;
    }

    public static <N, V> MutableValueGraph<N, V> copyOf(ValueGraph<N, V> valueGraph) {
        MutableValueGraph<N, V> mutableValueGraph = (MutableValueGraph<N, V>) ValueGraphBuilder.from(valueGraph).expectedNodeCount(valueGraph.nodes().size()).build();
        for (N n4 : valueGraph.nodes()) {
            mutableValueGraph.addNode(n4);
        }
        for (EndpointPair<N> endpointPair : valueGraph.edges()) {
            N nodeU = endpointPair.nodeU();
            N nodeV = endpointPair.nodeV();
            V edgeValueOrDefault = valueGraph.edgeValueOrDefault(endpointPair.nodeU(), endpointPair.nodeV(), null);
            java.util.Objects.requireNonNull(edgeValueOrDefault);
            mutableValueGraph.putEdgeValue(nodeU, nodeV, edgeValueOrDefault);
        }
        return mutableValueGraph;
    }

    public static boolean hasCycle(Network<?, ?> network) {
        if (network.isDirected() || !network.allowsParallelEdges() || network.edges().size() <= network.asGraph().edges().size()) {
            return hasCycle(network.asGraph());
        }
        return true;
    }

    public static <N, E> Network<N, E> transpose(Network<N, E> network) {
        if (network.isDirected()) {
            if (network instanceof TransposedNetwork) {
                return ((TransposedNetwork) network).f27727a;
            }
            return new TransposedNetwork(network);
        }
        return network;
    }

    public static <N, V> MutableValueGraph<N, V> inducedSubgraph(ValueGraph<N, V> valueGraph, Iterable<? extends N> iterable) {
        MutableValueGraph<N, V> mutableValueGraph;
        if (iterable instanceof Collection) {
            mutableValueGraph = ValueGraphBuilder.from(valueGraph).expectedNodeCount(((Collection) iterable).size()).build();
        } else {
            mutableValueGraph = ValueGraphBuilder.from(valueGraph).build();
        }
        for (N n4 : iterable) {
            mutableValueGraph.addNode(n4);
        }
        for (N n5 : mutableValueGraph.nodes()) {
            for (N n6 : valueGraph.successors((ValueGraph<N, V>) n5)) {
                if (mutableValueGraph.nodes().contains(n6)) {
                    V edgeValueOrDefault = valueGraph.edgeValueOrDefault(n5, n6, null);
                    java.util.Objects.requireNonNull(edgeValueOrDefault);
                    mutableValueGraph.putEdgeValue(n5, n6, edgeValueOrDefault);
                }
            }
        }
        return mutableValueGraph;
    }

    public static <N, E> MutableNetwork<N, E> copyOf(Network<N, E> network) {
        MutableNetwork<N, E> mutableNetwork = (MutableNetwork<N, E>) NetworkBuilder.from(network).expectedNodeCount(network.nodes().size()).expectedEdgeCount(network.edges().size()).build();
        for (N n4 : network.nodes()) {
            mutableNetwork.addNode(n4);
        }
        for (E e4 : network.edges()) {
            EndpointPair<N> incidentNodes = network.incidentNodes(e4);
            mutableNetwork.addEdge(incidentNodes.nodeU(), incidentNodes.nodeV(), e4);
        }
        return mutableNetwork;
    }

    public static <N, E> MutableNetwork<N, E> inducedSubgraph(Network<N, E> network, Iterable<? extends N> iterable) {
        MutableNetwork<N, E> mutableNetwork;
        if (iterable instanceof Collection) {
            mutableNetwork = NetworkBuilder.from(network).expectedNodeCount(((Collection) iterable).size()).build();
        } else {
            mutableNetwork = NetworkBuilder.from(network).build();
        }
        for (N n4 : iterable) {
            mutableNetwork.addNode(n4);
        }
        for (N n5 : mutableNetwork.nodes()) {
            for (E e4 : network.outEdges(n5)) {
                N adjacentNode = network.incidentNodes(e4).adjacentNode(n5);
                if (mutableNetwork.nodes().contains(adjacentNode)) {
                    mutableNetwork.addEdge(n5, adjacentNode, e4);
                }
            }
        }
        return mutableNetwork;
    }
}
