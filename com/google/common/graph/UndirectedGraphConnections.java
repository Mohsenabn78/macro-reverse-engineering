package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterators;
import com.google.common.graph.ElementOrder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
final class UndirectedGraphConnections<N, V> implements GraphConnections<N, V> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<N, V> f27786a;

    /* renamed from: com.google.common.graph.UndirectedGraphConnections$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f27787a;

        static {
            int[] iArr = new int[ElementOrder.Type.values().length];
            f27787a = iArr;
            try {
                iArr[ElementOrder.Type.UNORDERED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f27787a[ElementOrder.Type.STABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private UndirectedGraphConnections(Map<N, V> map) {
        this.f27786a = (Map) Preconditions.checkNotNull(map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <N, V> UndirectedGraphConnections<N, V> l(ElementOrder<N> elementOrder) {
        int i4 = AnonymousClass1.f27787a[elementOrder.type().ordinal()];
        if (i4 != 1) {
            if (i4 == 2) {
                return new UndirectedGraphConnections<>(new LinkedHashMap(2, 1.0f));
            }
            throw new AssertionError(elementOrder.type());
        }
        return new UndirectedGraphConnections<>(new HashMap(2, 1.0f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <N, V> UndirectedGraphConnections<N, V> m(Map<N, V> map) {
        return new UndirectedGraphConnections<>(ImmutableMap.copyOf((Map) map));
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> a() {
        return Collections.unmodifiableSet(this.f27786a.keySet());
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> b() {
        return a();
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> c() {
        return a();
    }

    @Override // com.google.common.graph.GraphConnections
    public void d(N n4, V v3) {
        i(n4, v3);
    }

    @Override // com.google.common.graph.GraphConnections
    @CheckForNull
    public V e(N n4) {
        return this.f27786a.get(n4);
    }

    @Override // com.google.common.graph.GraphConnections
    @CheckForNull
    public V f(N n4) {
        return this.f27786a.remove(n4);
    }

    @Override // com.google.common.graph.GraphConnections
    public void g(N n4) {
        f(n4);
    }

    @Override // com.google.common.graph.GraphConnections
    public Iterator<EndpointPair<N>> h(final N n4) {
        return Iterators.transform(this.f27786a.keySet().iterator(), new Function() { // from class: com.google.common.graph.r
            @Override // com.google.common.base.Function
            public final Object apply(Object obj) {
                EndpointPair unordered;
                unordered = EndpointPair.unordered(n4, obj);
                return unordered;
            }
        });
    }

    @Override // com.google.common.graph.GraphConnections
    @CheckForNull
    public V i(N n4, V v3) {
        return this.f27786a.put(n4, v3);
    }
}
