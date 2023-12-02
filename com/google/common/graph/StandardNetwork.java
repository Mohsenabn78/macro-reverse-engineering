package com.google.common.graph;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public class StandardNetwork<N, E> extends AbstractNetwork<N, E> {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f27753a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f27754b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f27755c;

    /* renamed from: d  reason: collision with root package name */
    private final ElementOrder<N> f27756d;

    /* renamed from: e  reason: collision with root package name */
    private final ElementOrder<E> f27757e;

    /* renamed from: f  reason: collision with root package name */
    final MapIteratorCache<N, NetworkConnections<N, E>> f27758f;

    /* renamed from: g  reason: collision with root package name */
    final MapIteratorCache<E, N> f27759g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StandardNetwork(NetworkBuilder<? super N, ? super E> networkBuilder) {
        this(networkBuilder, networkBuilder.f27674c.b(networkBuilder.f27676e.or((Optional<Integer>) 10).intValue()), networkBuilder.f27749g.b(networkBuilder.f27750h.or((Optional<Integer>) 20).intValue()));
    }

    @Override // com.google.common.graph.Network
    public Set<N> adjacentNodes(N n4) {
        return e(n4).a();
    }

    @Override // com.google.common.graph.Network
    public boolean allowsParallelEdges() {
        return this.f27754b;
    }

    @Override // com.google.common.graph.Network
    public boolean allowsSelfLoops() {
        return this.f27755c;
    }

    final NetworkConnections<N, E> e(N n4) {
        NetworkConnections<N, E> e4 = this.f27758f.e(n4);
        if (e4 != null) {
            return e4;
        }
        Preconditions.checkNotNull(n4);
        throw new IllegalArgumentException(String.format("Node %s is not an element of this graph.", n4));
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<E> edgeOrder() {
        return this.f27757e;
    }

    @Override // com.google.common.graph.Network
    public Set<E> edges() {
        return this.f27759g.j();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network
    public Set<E> edgesConnecting(N n4, N n5) {
        NetworkConnections<N, E> e4 = e(n4);
        if (!this.f27755c && n4 == n5) {
            return ImmutableSet.of();
        }
        Preconditions.checkArgument(h(n5), "Node %s is not an element of this graph.", n5);
        return e4.l(n5);
    }

    final N f(E e4) {
        N e5 = this.f27759g.e(e4);
        if (e5 != null) {
            return e5;
        }
        Preconditions.checkNotNull(e4);
        throw new IllegalArgumentException(String.format("Edge %s is not an element of this graph.", e4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean g(E e4) {
        return this.f27759g.d(e4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean h(N n4) {
        return this.f27758f.d(n4);
    }

    @Override // com.google.common.graph.Network
    public Set<E> inEdges(N n4) {
        return e(n4).e();
    }

    @Override // com.google.common.graph.Network
    public Set<E> incidentEdges(N n4) {
        return e(n4).k();
    }

    @Override // com.google.common.graph.Network
    public EndpointPair<N> incidentNodes(E e4) {
        N f4 = f(e4);
        NetworkConnections<N, E> e5 = this.f27758f.e(f4);
        Objects.requireNonNull(e5);
        return EndpointPair.b(this, f4, e5.d(e4));
    }

    @Override // com.google.common.graph.Network
    public boolean isDirected() {
        return this.f27753a;
    }

    @Override // com.google.common.graph.Network
    public ElementOrder<N> nodeOrder() {
        return this.f27756d;
    }

    @Override // com.google.common.graph.Network
    public Set<N> nodes() {
        return this.f27758f.j();
    }

    @Override // com.google.common.graph.Network
    public Set<E> outEdges(N n4) {
        return e(n4).g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction
    public /* bridge */ /* synthetic */ Iterable predecessors(Object obj) {
        return predecessors((StandardNetwork<N, E>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction
    public /* bridge */ /* synthetic */ Iterable successors(Object obj) {
        return successors((StandardNetwork<N, E>) obj);
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.PredecessorsFunction
    public Set<N> predecessors(N n4) {
        return e(n4).c();
    }

    @Override // com.google.common.graph.AbstractNetwork, com.google.common.graph.Network, com.google.common.graph.SuccessorsFunction
    public Set<N> successors(N n4) {
        return e(n4).b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public StandardNetwork(NetworkBuilder<? super N, ? super E> networkBuilder, Map<N, NetworkConnections<N, E>> map, Map<E, N> map2) {
        MapIteratorCache<N, NetworkConnections<N, E>> mapIteratorCache;
        this.f27753a = networkBuilder.f27672a;
        this.f27754b = networkBuilder.f27748f;
        this.f27755c = networkBuilder.f27673b;
        this.f27756d = (ElementOrder<N>) networkBuilder.f27674c.a();
        this.f27757e = (ElementOrder<E>) networkBuilder.f27749g.a();
        if (map instanceof TreeMap) {
            mapIteratorCache = new MapRetrievalCache<>(map);
        } else {
            mapIteratorCache = new MapIteratorCache<>(map);
        }
        this.f27758f = mapIteratorCache;
        this.f27759g = new MapIteratorCache<>(map2);
    }
}
