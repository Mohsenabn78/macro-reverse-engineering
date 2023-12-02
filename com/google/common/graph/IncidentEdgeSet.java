package com.google.common.graph;

import java.util.AbstractSet;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
abstract class IncidentEdgeSet<N> extends AbstractSet<EndpointPair<N>> {

    /* renamed from: a  reason: collision with root package name */
    final N f27733a;

    /* renamed from: b  reason: collision with root package name */
    final BaseGraph<N> f27734b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public IncidentEdgeSet(BaseGraph<N> baseGraph, N n4) {
        this.f27734b = baseGraph;
        this.f27733a = n4;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@CheckForNull Object obj) {
        if (!(obj instanceof EndpointPair)) {
            return false;
        }
        EndpointPair endpointPair = (EndpointPair) obj;
        if (this.f27734b.isDirected()) {
            if (!endpointPair.isOrdered()) {
                return false;
            }
            Object source = endpointPair.source();
            Object target = endpointPair.target();
            if ((!this.f27733a.equals(source) || !this.f27734b.successors((BaseGraph<N>) this.f27733a).contains(target)) && (!this.f27733a.equals(target) || !this.f27734b.predecessors((BaseGraph<N>) this.f27733a).contains(source))) {
                return false;
            }
            return true;
        } else if (endpointPair.isOrdered()) {
            return false;
        } else {
            Set<N> adjacentNodes = this.f27734b.adjacentNodes(this.f27733a);
            Object nodeU = endpointPair.nodeU();
            Object nodeV = endpointPair.nodeV();
            if ((!this.f27733a.equals(nodeV) || !adjacentNodes.contains(nodeU)) && (!this.f27733a.equals(nodeU) || !adjacentNodes.contains(nodeV))) {
                return false;
            }
            return true;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        if (this.f27734b.isDirected()) {
            return (this.f27734b.inDegree(this.f27733a) + this.f27734b.outDegree(this.f27733a)) - (this.f27734b.successors((BaseGraph<N>) this.f27733a).contains(this.f27733a) ? 1 : 0);
        }
        return this.f27734b.adjacentNodes(this.f27733a).size();
    }
}
