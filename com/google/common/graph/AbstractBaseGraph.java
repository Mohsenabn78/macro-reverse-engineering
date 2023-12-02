package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.graph.AbstractBaseGraph;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class AbstractBaseGraph<N> implements BaseGraph<N> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.common.graph.AbstractBaseGraph$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass2 extends IncidentEdgeSet<N> {
        AnonymousClass2(AbstractBaseGraph abstractBaseGraph, BaseGraph baseGraph, Object obj) {
            super(baseGraph, obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ EndpointPair e(Object obj) {
            return EndpointPair.ordered(obj, this.f27733a);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ EndpointPair f(Object obj) {
            return EndpointPair.ordered(this.f27733a, obj);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ EndpointPair g(Object obj) {
            return EndpointPair.unordered(this.f27733a, obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        /* renamed from: d */
        public UnmodifiableIterator<EndpointPair<N>> iterator() {
            if (this.f27734b.isDirected()) {
                return Iterators.unmodifiableIterator(Iterators.concat(Iterators.transform(this.f27734b.predecessors((BaseGraph<N>) this.f27733a).iterator(), new Function() { // from class: com.google.common.graph.a
                    @Override // com.google.common.base.Function
                    public final Object apply(Object obj) {
                        EndpointPair e4;
                        e4 = AbstractBaseGraph.AnonymousClass2.this.e(obj);
                        return e4;
                    }
                }), Iterators.transform(Sets.difference(this.f27734b.successors((BaseGraph<N>) this.f27733a), ImmutableSet.of(this.f27733a)).iterator(), new Function() { // from class: com.google.common.graph.b
                    @Override // com.google.common.base.Function
                    public final Object apply(Object obj) {
                        EndpointPair f4;
                        f4 = AbstractBaseGraph.AnonymousClass2.this.f(obj);
                        return f4;
                    }
                })));
            }
            return Iterators.unmodifiableIterator(Iterators.transform(this.f27734b.adjacentNodes(this.f27733a).iterator(), new Function() { // from class: com.google.common.graph.c
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    EndpointPair g4;
                    g4 = AbstractBaseGraph.AnonymousClass2.this.g(obj);
                    return g4;
                }
            }));
        }
    }

    protected long a() {
        Iterator<N> it;
        boolean z3;
        long j4 = 0;
        while (nodes().iterator().hasNext()) {
            j4 += degree(it.next());
        }
        if ((1 & j4) == 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
        return j4 >>> 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean b(EndpointPair<?> endpointPair) {
        if (endpointPair.isOrdered() == isDirected()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(EndpointPair<?> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        Preconditions.checkArgument(b(endpointPair), "Mismatch: endpoints' ordering is not compatible with directionality of the graph");
    }

    @Override // com.google.common.graph.BaseGraph
    public int degree(N n4) {
        int i4;
        if (isDirected()) {
            return IntMath.saturatedAdd(predecessors((AbstractBaseGraph<N>) n4).size(), successors((AbstractBaseGraph<N>) n4).size());
        }
        Set<N> adjacentNodes = adjacentNodes(n4);
        if (allowsSelfLoops() && adjacentNodes.contains(n4)) {
            i4 = 1;
        } else {
            i4 = 0;
        }
        return IntMath.saturatedAdd(adjacentNodes.size(), i4);
    }

    @Override // com.google.common.graph.BaseGraph
    public Set<EndpointPair<N>> edges() {
        return new AbstractSet<EndpointPair<N>>() { // from class: com.google.common.graph.AbstractBaseGraph.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            /* renamed from: a */
            public UnmodifiableIterator<EndpointPair<N>> iterator() {
                return EndpointPairIterator.e(AbstractBaseGraph.this);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object obj) {
                if (!(obj instanceof EndpointPair)) {
                    return false;
                }
                EndpointPair<?> endpointPair = (EndpointPair) obj;
                if (!AbstractBaseGraph.this.b(endpointPair) || !AbstractBaseGraph.this.nodes().contains(endpointPair.nodeU()) || !AbstractBaseGraph.this.successors((AbstractBaseGraph) endpointPair.nodeU()).contains(endpointPair.nodeV())) {
                    return false;
                }
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(@CheckForNull Object obj) {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return Ints.saturatedCast(AbstractBaseGraph.this.a());
            }
        };
    }

    @Override // com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(N n4, N n5) {
        Preconditions.checkNotNull(n4);
        Preconditions.checkNotNull(n5);
        return nodes().contains(n4) && successors((AbstractBaseGraph<N>) n4).contains(n5);
    }

    @Override // com.google.common.graph.BaseGraph
    public int inDegree(N n4) {
        if (isDirected()) {
            return predecessors((AbstractBaseGraph<N>) n4).size();
        }
        return degree(n4);
    }

    @Override // com.google.common.graph.BaseGraph
    public ElementOrder<N> incidentEdgeOrder() {
        return ElementOrder.unordered();
    }

    @Override // com.google.common.graph.BaseGraph
    public Set<EndpointPair<N>> incidentEdges(N n4) {
        Preconditions.checkNotNull(n4);
        Preconditions.checkArgument(nodes().contains(n4), "Node %s is not an element of this graph.", n4);
        return new AnonymousClass2(this, this, n4);
    }

    @Override // com.google.common.graph.BaseGraph
    public int outDegree(N n4) {
        if (isDirected()) {
            return successors((AbstractBaseGraph<N>) n4).size();
        }
        return degree(n4);
    }

    @Override // com.google.common.graph.PredecessorsFunction
    public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
        Iterable predecessors;
        predecessors = predecessors((AbstractBaseGraph<N>) ((BaseGraph) obj));
        return predecessors;
    }

    @Override // com.google.common.graph.SuccessorsFunction
    public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
        Iterable successors;
        successors = successors((AbstractBaseGraph<N>) ((BaseGraph) obj));
        return successors;
    }

    @Override // com.google.common.graph.BaseGraph
    public boolean hasEdgeConnecting(EndpointPair<N> endpointPair) {
        Preconditions.checkNotNull(endpointPair);
        if (b(endpointPair)) {
            N nodeU = endpointPair.nodeU();
            return nodes().contains(nodeU) && successors((AbstractBaseGraph<N>) nodeU).contains(endpointPair.nodeV());
        }
        return false;
    }
}
