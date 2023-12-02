package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.graph.ElementOrder;
import com.google.common.graph.ImmutableGraph;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;

@DoNotMock
@Beta
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class GraphBuilder<N> extends AbstractGraphBuilder<N> {
    private GraphBuilder(boolean z3) {
        super(z3);
    }

    public static GraphBuilder<Object> directed() {
        return new GraphBuilder<>(true);
    }

    public static <N> GraphBuilder<N> from(Graph<N> graph) {
        return new GraphBuilder(graph.isDirected()).allowsSelfLoops(graph.allowsSelfLoops()).nodeOrder(graph.nodeOrder()).incidentEdgeOrder(graph.incidentEdgeOrder());
    }

    public static GraphBuilder<Object> undirected() {
        return new GraphBuilder<>(false);
    }

    @CanIgnoreReturnValue
    public GraphBuilder<N> allowsSelfLoops(boolean z3) {
        this.f27673b = z3;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public GraphBuilder<N> b() {
        GraphBuilder<N> graphBuilder = new GraphBuilder<>(this.f27672a);
        graphBuilder.f27673b = this.f27673b;
        graphBuilder.f27674c = this.f27674c;
        graphBuilder.f27676e = this.f27676e;
        graphBuilder.f27675d = this.f27675d;
        return graphBuilder;
    }

    public <N1 extends N> MutableGraph<N1> build() {
        return new StandardMutableGraph(this);
    }

    @CanIgnoreReturnValue
    public GraphBuilder<N> expectedNodeCount(int i4) {
        this.f27676e = Optional.of(Integer.valueOf(Graphs.b(i4)));
        return this;
    }

    public <N1 extends N> ImmutableGraph.Builder<N1> immutable() {
        return new ImmutableGraph.Builder<>(a());
    }

    public <N1 extends N> GraphBuilder<N1> incidentEdgeOrder(ElementOrder<N1> elementOrder) {
        boolean z3;
        if (elementOrder.type() != ElementOrder.Type.UNORDERED && elementOrder.type() != ElementOrder.Type.STABLE) {
            z3 = false;
        } else {
            z3 = true;
        }
        Preconditions.checkArgument(z3, "The given elementOrder (%s) is unsupported. incidentEdgeOrder() only supports ElementOrder.unordered() and ElementOrder.stable().", elementOrder);
        GraphBuilder<N1> a4 = a();
        a4.f27675d = (ElementOrder) Preconditions.checkNotNull(elementOrder);
        return a4;
    }

    public <N1 extends N> GraphBuilder<N1> nodeOrder(ElementOrder<N1> elementOrder) {
        GraphBuilder<N1> a4 = a();
        a4.f27674c = (ElementOrder) Preconditions.checkNotNull(elementOrder);
        return a4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N1 extends N> GraphBuilder<N1> a() {
        return this;
    }
}
