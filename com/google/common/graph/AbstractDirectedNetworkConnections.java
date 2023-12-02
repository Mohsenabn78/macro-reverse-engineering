package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.math.IntMath;
import java.util.AbstractSet;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class AbstractDirectedNetworkConnections<N, E> implements NetworkConnections<N, E> {

    /* renamed from: a  reason: collision with root package name */
    final Map<E, N> f27668a;

    /* renamed from: b  reason: collision with root package name */
    final Map<E, N> f27669b;

    /* renamed from: c  reason: collision with root package name */
    private int f27670c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractDirectedNetworkConnections(Map<E, N> map, Map<E, N> map2, int i4) {
        boolean z3;
        this.f27668a = (Map) Preconditions.checkNotNull(map);
        this.f27669b = (Map) Preconditions.checkNotNull(map2);
        this.f27670c = Graphs.b(i4);
        if (i4 <= map.size() && i4 <= map2.size()) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> a() {
        return Sets.union(c(), b());
    }

    @Override // com.google.common.graph.NetworkConnections
    public N d(E e4) {
        N n4 = this.f27669b.get(e4);
        Objects.requireNonNull(n4);
        return n4;
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> e() {
        return Collections.unmodifiableSet(this.f27668a.keySet());
    }

    @Override // com.google.common.graph.NetworkConnections
    public N f(E e4) {
        N remove = this.f27669b.remove(e4);
        Objects.requireNonNull(remove);
        return remove;
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> g() {
        return Collections.unmodifiableSet(this.f27669b.keySet());
    }

    @Override // com.google.common.graph.NetworkConnections
    public N h(E e4, boolean z3) {
        if (z3) {
            int i4 = this.f27670c - 1;
            this.f27670c = i4;
            Graphs.b(i4);
        }
        N remove = this.f27668a.remove(e4);
        Objects.requireNonNull(remove);
        return remove;
    }

    @Override // com.google.common.graph.NetworkConnections
    public void i(E e4, N n4) {
        boolean z3;
        Preconditions.checkNotNull(e4);
        Preconditions.checkNotNull(n4);
        if (this.f27669b.put(e4, n4) == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
    }

    @Override // com.google.common.graph.NetworkConnections
    public void j(E e4, N n4, boolean z3) {
        Preconditions.checkNotNull(e4);
        Preconditions.checkNotNull(n4);
        boolean z4 = true;
        if (z3) {
            int i4 = this.f27670c + 1;
            this.f27670c = i4;
            Graphs.d(i4);
        }
        if (this.f27668a.put(e4, n4) != null) {
            z4 = false;
        }
        Preconditions.checkState(z4);
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> k() {
        return new AbstractSet<E>() { // from class: com.google.common.graph.AbstractDirectedNetworkConnections.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            /* renamed from: a */
            public UnmodifiableIterator<E> iterator() {
                Iterable union;
                if (AbstractDirectedNetworkConnections.this.f27670c == 0) {
                    union = Iterables.concat(AbstractDirectedNetworkConnections.this.f27668a.keySet(), AbstractDirectedNetworkConnections.this.f27669b.keySet());
                } else {
                    union = Sets.union(AbstractDirectedNetworkConnections.this.f27668a.keySet(), AbstractDirectedNetworkConnections.this.f27669b.keySet());
                }
                return Iterators.unmodifiableIterator(union.iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object obj) {
                if (!AbstractDirectedNetworkConnections.this.f27668a.containsKey(obj) && !AbstractDirectedNetworkConnections.this.f27669b.containsKey(obj)) {
                    return false;
                }
                return true;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return IntMath.saturatedAdd(AbstractDirectedNetworkConnections.this.f27668a.size(), AbstractDirectedNetworkConnections.this.f27669b.size() - AbstractDirectedNetworkConnections.this.f27670c);
            }
        };
    }
}
