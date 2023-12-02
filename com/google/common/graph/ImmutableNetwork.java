package com.google.common.graph;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.util.Map;
import java.util.Set;

@Immutable(containerOf = {"N", ExifInterface.LONGITUDE_EAST})
@Beta
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class ImmutableNetwork<N, E> extends StandardNetwork<N, E> {

    /* loaded from: classes5.dex */
    public static class Builder<N, E> {

        /* renamed from: a  reason: collision with root package name */
        private final MutableNetwork<N, E> f27731a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(NetworkBuilder<N, E> networkBuilder) {
            this.f27731a = (MutableNetwork<N, E>) networkBuilder.build();
        }

        @CanIgnoreReturnValue
        public Builder<N, E> addEdge(N n4, N n5, E e4) {
            this.f27731a.addEdge(n4, n5, e4);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<N, E> addNode(N n4) {
            this.f27731a.addNode(n4);
            return this;
        }

        public ImmutableNetwork<N, E> build() {
            return ImmutableNetwork.copyOf(this.f27731a);
        }

        @CanIgnoreReturnValue
        public Builder<N, E> addEdge(EndpointPair<N> endpointPair, E e4) {
            this.f27731a.addEdge(endpointPair, e4);
            return this;
        }
    }

    private ImmutableNetwork(Network<N, E> network) {
        super(NetworkBuilder.from(network), o(network), n(network));
    }

    public static <N, E> ImmutableNetwork<N, E> copyOf(Network<N, E> network) {
        if (network instanceof ImmutableNetwork) {
            return (ImmutableNetwork) network;
        }
        return new ImmutableNetwork<>(network);
    }

    private static <N, E> Function<E, N> l(final Network<N, E> network, final N n4) {
        return new Function() { // from class: com.google.common.graph.o
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                Object p4;
                p4 = ImmutableNetwork.p(Network.this, n4, obj);
                return p4;
            }
        };
    }

    private static <N, E> NetworkConnections<N, E> m(Network<N, E> network, N n4) {
        if (network.isDirected()) {
            Map asMap = Maps.asMap(network.inEdges(n4), s(network));
            Map asMap2 = Maps.asMap(network.outEdges(n4), t(network));
            int size = network.edgesConnecting(n4, n4).size();
            if (network.allowsParallelEdges()) {
                return DirectedMultiNetworkConnections.q(asMap, asMap2, size);
            }
            return DirectedNetworkConnections.o(asMap, asMap2, size);
        }
        Map asMap3 = Maps.asMap(network.incidentEdges(n4), l(network, n4));
        if (network.allowsParallelEdges()) {
            return UndirectedMultiNetworkConnections.q(asMap3);
        }
        return UndirectedNetworkConnections.n(asMap3);
    }

    private static <N, E> Map<E, N> n(Network<N, E> network) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (E e4 : network.edges()) {
            builder.put(e4, network.incidentNodes(e4).nodeU());
        }
        return builder.buildOrThrow();
    }

    private static <N, E> Map<N, NetworkConnections<N, E>> o(Network<N, E> network) {
        ImmutableMap.Builder builder = ImmutableMap.builder();
        for (N n4 : network.nodes()) {
            builder.put(n4, m(network, n4));
        }
        return builder.buildOrThrow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object p(Network network, Object obj, Object obj2) {
        return network.incidentNodes(obj2).adjacentNode(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object q(Network network, Object obj) {
        return network.incidentNodes(obj).source();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object r(Network network, Object obj) {
        return network.incidentNodes(obj).target();
    }

    private static <N, E> Function<E, N> s(final Network<N, E> network) {
        return new Function() { // from class: com.google.common.graph.m
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                Object q4;
                q4 = ImmutableNetwork.q(Network.this, obj);
                return q4;
            }
        };
    }

    private static <N, E> Function<E, N> t(final Network<N, E> network) {
        return new Function() { // from class: com.google.common.graph.n
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                Object r4;
                r4 = ImmutableNetwork.r(Network.this, obj);
                return r4;
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set adjacentNodes(Object obj) {
        return super.adjacentNodes(obj);
    }

    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ boolean allowsParallelEdges() {
        return super.allowsParallelEdges();
    }

    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ boolean allowsSelfLoops() {
        return super.allowsSelfLoops();
    }

    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ ElementOrder edgeOrder() {
        return super.edgeOrder();
    }

    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set edges() {
        return super.edges();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set edgesConnecting(Object obj, Object obj2) {
        return super.edgesConnecting(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set inEdges(Object obj) {
        return super.inEdges(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set incidentEdges(Object obj) {
        return super.incidentEdges(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ EndpointPair incidentNodes(Object obj) {
        return super.incidentNodes(obj);
    }

    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ boolean isDirected() {
        return super.isDirected();
    }

    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ ElementOrder nodeOrder() {
        return super.nodeOrder();
    }

    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set nodes() {
        return super.nodes();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.Network
    public /* bridge */ /* synthetic */ Set outEdges(Object obj) {
        return super.outEdges(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction
    public /* bridge */ /* synthetic */ Set predecessors(Object obj) {
        return super.predecessors((ImmutableNetwork<N, E>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.StandardNetwork, com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction
    public /* bridge */ /* synthetic */ Set successors(Object obj) {
        return super.successors((ImmutableNetwork<N, E>) obj);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public ImmutableGraph<N> asGraph() {
        return new ImmutableGraph<>(super.asGraph());
    }

    @Deprecated
    public static <N, E> ImmutableNetwork<N, E> copyOf(ImmutableNetwork<N, E> immutableNetwork) {
        return (ImmutableNetwork) Preconditions.checkNotNull(immutableNetwork);
    }
}
