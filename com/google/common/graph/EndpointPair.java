package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.Immutable;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@Immutable(containerOf = {"N"})
@Beta
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class EndpointPair<N> implements Iterable<N> {

    /* renamed from: a  reason: collision with root package name */
    private final N f27713a;

    /* renamed from: b  reason: collision with root package name */
    private final N f27714b;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class Ordered<N> extends EndpointPair<N> {
        @Override // com.google.common.graph.EndpointPair
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair endpointPair = (EndpointPair) obj;
            if (isOrdered() == endpointPair.isOrdered() && source().equals(endpointPair.source()) && target().equals(endpointPair.target())) {
                return true;
            }
            return false;
        }

        @Override // com.google.common.graph.EndpointPair
        public int hashCode() {
            return Objects.hashCode(source(), target());
        }

        @Override // com.google.common.graph.EndpointPair
        public boolean isOrdered() {
            return true;
        }

        @Override // com.google.common.graph.EndpointPair, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.graph.EndpointPair
        public N source() {
            return nodeU();
        }

        @Override // com.google.common.graph.EndpointPair
        public N target() {
            return nodeV();
        }

        public String toString() {
            return "<" + source() + " -> " + target() + ">";
        }

        private Ordered(N n4, N n5) {
            super(n4, n5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class Unordered<N> extends EndpointPair<N> {
        @Override // com.google.common.graph.EndpointPair
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof EndpointPair)) {
                return false;
            }
            EndpointPair endpointPair = (EndpointPair) obj;
            if (isOrdered() != endpointPair.isOrdered()) {
                return false;
            }
            if (nodeU().equals(endpointPair.nodeU())) {
                return nodeV().equals(endpointPair.nodeV());
            }
            if (nodeU().equals(endpointPair.nodeV()) && nodeV().equals(endpointPair.nodeU())) {
                return true;
            }
            return false;
        }

        @Override // com.google.common.graph.EndpointPair
        public int hashCode() {
            return nodeU().hashCode() + nodeV().hashCode();
        }

        @Override // com.google.common.graph.EndpointPair
        public boolean isOrdered() {
            return false;
        }

        @Override // com.google.common.graph.EndpointPair, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.graph.EndpointPair
        public N source() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        @Override // com.google.common.graph.EndpointPair
        public N target() {
            throw new UnsupportedOperationException("Cannot call source()/target() on a EndpointPair from an undirected graph. Consider calling adjacentNode(node) if you already have a node, or nodeU()/nodeV() if you don't.");
        }

        public String toString() {
            return "[" + nodeU() + ", " + nodeV() + "]";
        }

        private Unordered(N n4, N n5) {
            super(n4, n5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <N> EndpointPair<N> a(Graph<?> graph, N n4, N n5) {
        if (graph.isDirected()) {
            return ordered(n4, n5);
        }
        return unordered(n4, n5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <N> EndpointPair<N> b(Network<?, ?> network, N n4, N n5) {
        if (network.isDirected()) {
            return ordered(n4, n5);
        }
        return unordered(n4, n5);
    }

    public static <N> EndpointPair<N> ordered(N n4, N n5) {
        return new Ordered(n4, n5);
    }

    public static <N> EndpointPair<N> unordered(N n4, N n5) {
        return new Unordered(n5, n4);
    }

    public final N adjacentNode(N n4) {
        if (n4.equals(this.f27713a)) {
            return this.f27714b;
        }
        if (n4.equals(this.f27714b)) {
            return this.f27713a;
        }
        throw new IllegalArgumentException("EndpointPair " + this + " does not contain node " + n4);
    }

    public abstract boolean equals(@CheckForNull Object obj);

    public abstract int hashCode();

    public abstract boolean isOrdered();

    public final N nodeU() {
        return this.f27713a;
    }

    public final N nodeV() {
        return this.f27714b;
    }

    public abstract N source();

    public abstract N target();

    private EndpointPair(N n4, N n5) {
        this.f27713a = (N) Preconditions.checkNotNull(n4);
        this.f27714b = (N) Preconditions.checkNotNull(n5);
    }

    @Override // java.lang.Iterable
    public final UnmodifiableIterator<N> iterator() {
        return Iterators.forArray(this.f27713a, this.f27714b);
    }
}
