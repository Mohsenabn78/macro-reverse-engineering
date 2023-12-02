package com.google.common.graph;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
final class DirectedNetworkConnections<N, E> extends AbstractDirectedNetworkConnections<N, E> {
    DirectedNetworkConnections(Map<E, N> map, Map<E, N> map2, int i4) {
        super(map, map2, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <N, E> DirectedNetworkConnections<N, E> n() {
        return new DirectedNetworkConnections<>(HashBiMap.create(2), HashBiMap.create(2), 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <N, E> DirectedNetworkConnections<N, E> o(Map<E, N> map, Map<E, N> map2, int i4) {
        return new DirectedNetworkConnections<>(ImmutableBiMap.copyOf((Map) map), ImmutableBiMap.copyOf((Map) map2), i4);
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> b() {
        return Collections.unmodifiableSet(((BiMap) this.f27669b).values());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> c() {
        return Collections.unmodifiableSet(((BiMap) this.f27668a).values());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> l(N n4) {
        return new EdgesConnecting(((BiMap) this.f27669b).inverse(), n4);
    }
}
