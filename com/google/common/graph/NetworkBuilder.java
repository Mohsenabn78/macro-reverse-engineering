package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.graph.ImmutableNetwork;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@Beta
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class NetworkBuilder<N, E> extends AbstractGraphBuilder<N> {

    /* renamed from: f  reason: collision with root package name */
    boolean f27748f;

    /* renamed from: g  reason: collision with root package name */
    ElementOrder<? super E> f27749g;

    /* renamed from: h  reason: collision with root package name */
    Optional<Integer> f27750h;

    private NetworkBuilder(boolean z3) {
        super(z3);
        this.f27748f = false;
        this.f27749g = ElementOrder.insertion();
        this.f27750h = Optional.absent();
    }

    public static NetworkBuilder<Object, Object> directed() {
        return new NetworkBuilder<>(true);
    }

    public static <N, E> NetworkBuilder<N, E> from(Network<N, E> network) {
        return new NetworkBuilder(network.isDirected()).allowsParallelEdges(network.allowsParallelEdges()).allowsSelfLoops(network.allowsSelfLoops()).nodeOrder(network.nodeOrder()).edgeOrder(network.edgeOrder());
    }

    public static NetworkBuilder<Object, Object> undirected() {
        return new NetworkBuilder<>(false);
    }

    @CanIgnoreReturnValue
    public NetworkBuilder<N, E> allowsParallelEdges(boolean z3) {
        this.f27748f = z3;
        return this;
    }

    @CanIgnoreReturnValue
    public NetworkBuilder<N, E> allowsSelfLoops(boolean z3) {
        this.f27673b = z3;
        return this;
    }

    public <N1 extends N, E1 extends E> MutableNetwork<N1, E1> build() {
        return new StandardMutableNetwork(this);
    }

    public <E1 extends E> NetworkBuilder<N, E1> edgeOrder(ElementOrder<E1> elementOrder) {
        NetworkBuilder<N, E1> networkBuilder = (NetworkBuilder<N, E1>) a();
        networkBuilder.f27749g = (ElementOrder) Preconditions.checkNotNull(elementOrder);
        return networkBuilder;
    }

    @CanIgnoreReturnValue
    public NetworkBuilder<N, E> expectedEdgeCount(int i4) {
        this.f27750h = Optional.of(Integer.valueOf(Graphs.b(i4)));
        return this;
    }

    @CanIgnoreReturnValue
    public NetworkBuilder<N, E> expectedNodeCount(int i4) {
        this.f27676e = Optional.of(Integer.valueOf(Graphs.b(i4)));
        return this;
    }

    public <N1 extends N, E1 extends E> ImmutableNetwork.Builder<N1, E1> immutable() {
        return new ImmutableNetwork.Builder<>(a());
    }

    public <N1 extends N> NetworkBuilder<N1, E> nodeOrder(ElementOrder<N1> elementOrder) {
        NetworkBuilder<N1, E> networkBuilder = (NetworkBuilder<N1, E>) a();
        networkBuilder.f27674c = (ElementOrder) Preconditions.checkNotNull(elementOrder);
        return networkBuilder;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N1 extends N, E1 extends E> NetworkBuilder<N1, E1> a() {
        return this;
    }
}
