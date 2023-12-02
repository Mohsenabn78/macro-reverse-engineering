package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.graph.AbstractNetwork;
import com.google.common.math.IntMath;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@Beta
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class AbstractNetwork<N, E> implements Network<N, E> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.common.graph.AbstractNetwork$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass1 extends AbstractGraph<N> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.google.common.graph.AbstractNetwork$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes5.dex */
        public class C01691 extends AbstractSet<EndpointPair<N>> {
            C01691() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public /* synthetic */ EndpointPair b(Object obj) {
                return AbstractNetwork.this.incidentNodes(obj);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair<?> endpointPair = (EndpointPair) obj;
                if (!AnonymousClass1.this.b(endpointPair) || !AnonymousClass1.this.nodes().contains(endpointPair.nodeU()) || !AnonymousClass1.this.successors((AnonymousClass1) endpointPair.nodeU()).contains(endpointPair.nodeV())) {
                    return false;
                }
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator<EndpointPair<N>> iterator() {
                return Iterators.transform(AbstractNetwork.this.edges().iterator(), new Function() { // from class: com.google.common.graph.e
                    @Override // com.google.common.base.Function
                    public final Object apply(Object obj) {
                        EndpointPair b4;
                        b4 = AbstractNetwork.AnonymousClass1.C01691.this.b(obj);
                        return b4;
                    }
                });
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return AbstractNetwork.this.edges().size();
            }
        }

        AnonymousClass1() {
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public Set<N> adjacentNodes(N n4) {
            return AbstractNetwork.this.adjacentNodes(n4);
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public boolean allowsSelfLoops() {
            return AbstractNetwork.this.allowsSelfLoops();
        }

        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public Set<EndpointPair<N>> edges() {
            if (AbstractNetwork.this.allowsParallelEdges()) {
                return super.edges();
            }
            return new C01691();
        }

        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.BaseGraph
        public ElementOrder<N> incidentEdgeOrder() {
            return ElementOrder.unordered();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public boolean isDirected() {
            return AbstractNetwork.this.isDirected();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public ElementOrder<N> nodeOrder() {
            return AbstractNetwork.this.nodeOrder();
        }

        @Override // com.google.common.graph.BaseGraph, com.google.common.graph.Graph
        public Set<N> nodes() {
            return AbstractNetwork.this.nodes();
        }

        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.PredecessorsFunction
        public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
            return predecessors((AnonymousClass1) obj);
        }

        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.SuccessorsFunction
        public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
            return successors((AnonymousClass1) obj);
        }

        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.PredecessorsFunction
        public Set<N> predecessors(N n4) {
            return AbstractNetwork.this.predecessors((AbstractNetwork) n4);
        }

        @Override // com.google.common.graph.AbstractGraph, com.google.common.graph.AbstractBaseGraph, com.google.common.graph.SuccessorsFunction
        public Set<N> successors(N n4) {
            return AbstractNetwork.this.successors((AbstractNetwork) n4);
        }
    }

    private Predicate<E> a(final N n4, final N n5) {
        return new Predicate<E>() { // from class: com.google.common.graph.AbstractNetwork.2
            @Override // com.google.common.base.Predicate
            public boolean apply(E e4) {
                return AbstractNetwork.this.incidentNodes(e4).adjacentNode((N) n4).equals(n5);
            }
        };
    }

    private static <N, E> Map<E, EndpointPair<N>> b(final Network<N, E> network) {
        return Maps.asMap(network.edges(), new Function() { // from class: com.google.common.graph.d
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                return Network.this.incidentNodes(obj);
            }
        });
    }

    @Override // com.google.common.graph.Network
    public Set<E> adjacentEdges(E e4) {
        EndpointPair<N> incidentNodes = incidentNodes(e4);
        return Sets.difference(Sets.union(incidentEdges(incidentNodes.nodeU()), incidentEdges(incidentNodes.nodeV())), ImmutableSet.of((Object) e4));
    }

    @Override // com.google.common.graph.Network
    public Graph<N> asGraph() {
        return new AnonymousClass1();
    }

    protected final boolean c(EndpointPair<?> endpointPair) {
        if (endpointPair.isOrdered() == isDirected()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d(EndpointPair<?> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        Preconditions.checkArgument(c(endpointPair), "Mismatch: endpoints' ordering is not compatible with directionality of the graph");
    }

    @Override // com.google.common.graph.Network
    public int degree(N n4) {
        if (isDirected()) {
            return IntMath.saturatedAdd(inEdges(n4).size(), outEdges(n4).size());
        }
        return IntMath.saturatedAdd(incidentEdges(n4).size(), edgesConnecting(n4, n4).size());
    }

    @Override // com.google.common.graph.Network
    @CheckForNull
    public E edgeConnectingOrNull(N n4, N n5) {
        Set<E> edgesConnecting = edgesConnecting(n4, n5);
        int size = edgesConnecting.size();
        if (size != 0) {
            if (size == 1) {
                return edgesConnecting.iterator().next();
            }
            throw new IllegalArgumentException(String.format("Cannot call edgeConnecting() when parallel edges exist between %s and %s. Consider calling edgesConnecting() instead.", n4, n5));
        }
        return null;
    }

    @Override // com.google.common.graph.Network
    public Set<E> edgesConnecting(N n4, N n5) {
        Set<E> outEdges = outEdges(n4);
        Set<E> inEdges = inEdges(n5);
        if (outEdges.size() <= inEdges.size()) {
            return Collections.unmodifiableSet(Sets.filter(outEdges, a(n4, n5)));
        }
        return Collections.unmodifiableSet(Sets.filter(inEdges, a(n5, n4)));
    }

    @Override // com.google.common.graph.Network
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Network)) {
            return false;
        }
        Network network = (Network) obj;
        if (isDirected() == network.isDirected() && nodes().equals(network.nodes()) && b(this).equals(b(network))) {
            return true;
        }
        return false;
    }

    @Override // com.google.common.graph.Network
    public boolean hasEdgeConnecting(N n4, N n5) {
        Preconditions.checkNotNull(n4);
        Preconditions.checkNotNull(n5);
        return nodes().contains(n4) && successors((AbstractNetwork<N, E>) n4).contains(n5);
    }

    @Override // com.google.common.graph.Network
    public final int hashCode() {
        return b(this).hashCode();
    }

    @Override // com.google.common.graph.Network
    public int inDegree(N n4) {
        if (isDirected()) {
            return inEdges(n4).size();
        }
        return degree(n4);
    }

    @Override // com.google.common.graph.Network
    public int outDegree(N n4) {
        if (isDirected()) {
            return outEdges(n4).size();
        }
        return degree(n4);
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction
    public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
        Iterable predecessors;
        predecessors = predecessors((AbstractNetwork<N, E>) ((Network) obj));
        return predecessors;
    }

    @Override // com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction
    public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
        Iterable successors;
        successors = successors((AbstractNetwork<N, E>) ((Network) obj));
        return successors;
    }

    public String toString() {
        return "isDirected: " + isDirected() + ", allowsParallelEdges: " + allowsParallelEdges() + ", allowsSelfLoops: " + allowsSelfLoops() + ", nodes: " + nodes() + ", edges: " + b(this);
    }

    @Override // com.google.common.graph.Network
    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        if (c(endpointPair)) {
            return hasEdgeConnecting(endpointPair.nodeU(), endpointPair.nodeV());
        }
        return false;
    }

    @Override // com.google.common.graph.Network
    @CheckForNull
    public E edgeConnectingOrNull(EndpointPair<N> endpointPair) {
        d(endpointPair);
        return edgeConnectingOrNull(endpointPair.nodeU(), endpointPair.nodeV());
    }

    @Override // com.google.common.graph.Network
    public Set<E> edgesConnecting(EndpointPair<N> endpointPair) {
        d(endpointPair);
        return edgesConnecting(endpointPair.nodeU(), endpointPair.nodeV());
    }
}
