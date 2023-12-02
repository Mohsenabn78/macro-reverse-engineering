package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class EndpointPairIterator<N> extends AbstractIterator<EndpointPair<N>> {

    /* renamed from: c  reason: collision with root package name */
    private final BaseGraph<N> f27715c;

    /* renamed from: d  reason: collision with root package name */
    private final Iterator<N> f27716d;
    @CheckForNull

    /* renamed from: e  reason: collision with root package name */
    N f27717e;

    /* renamed from: f  reason: collision with root package name */
    Iterator<N> f27718f;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class Directed<N> extends EndpointPairIterator<N> {
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        /* renamed from: f */
        public EndpointPair<N> a() {
            while (!this.f27718f.hasNext()) {
                if (!d()) {
                    return b();
                }
            }
            N n4 = this.f27717e;
            Objects.requireNonNull(n4);
            return EndpointPair.ordered(n4, this.f27718f.next());
        }

        private Directed(BaseGraph<N> baseGraph) {
            super(baseGraph);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class Undirected<N> extends EndpointPairIterator<N> {
        @CheckForNull

        /* renamed from: g  reason: collision with root package name */
        private Set<N> f27719g;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        /* renamed from: f */
        public EndpointPair<N> a() {
            do {
                Objects.requireNonNull(this.f27719g);
                while (this.f27718f.hasNext()) {
                    N next = this.f27718f.next();
                    if (!this.f27719g.contains(next)) {
                        N n4 = this.f27717e;
                        Objects.requireNonNull(n4);
                        return EndpointPair.unordered(n4, next);
                    }
                }
                this.f27719g.add(this.f27717e);
            } while (d());
            this.f27719g = null;
            return b();
        }

        private Undirected(BaseGraph<N> baseGraph) {
            super(baseGraph);
            this.f27719g = Sets.newHashSetWithExpectedSize(baseGraph.nodes().size() + 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <N> EndpointPairIterator<N> e(BaseGraph<N> baseGraph) {
        if (baseGraph.isDirected()) {
            return new Directed(baseGraph);
        }
        return new Undirected(baseGraph);
    }

    final boolean d() {
        Preconditions.checkState(!this.f27718f.hasNext());
        if (!this.f27716d.hasNext()) {
            return false;
        }
        N next = this.f27716d.next();
        this.f27717e = next;
        this.f27718f = this.f27715c.successors((BaseGraph<N>) next).iterator();
        return true;
    }

    private EndpointPairIterator(BaseGraph<N> baseGraph) {
        this.f27717e = null;
        this.f27718f = ImmutableSet.of().iterator();
        this.f27715c = baseGraph;
        this.f27716d = baseGraph.nodes().iterator();
    }
}
