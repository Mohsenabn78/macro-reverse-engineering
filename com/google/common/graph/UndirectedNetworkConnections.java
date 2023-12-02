package com.google.common.graph;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
final class UndirectedNetworkConnections<N, E> extends AbstractUndirectedNetworkConnections<N, E> {
    UndirectedNetworkConnections(Map<E, N> map) {
        super(map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <N, E> UndirectedNetworkConnections<N, E> m() {
        return new UndirectedNetworkConnections<>(HashBiMap.create(2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <N, E> UndirectedNetworkConnections<N, E> n(Map<E, N> map) {
        return new UndirectedNetworkConnections<>(ImmutableBiMap.copyOf((Map) map));
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> a() {
        return Collections.unmodifiableSet(((BiMap) this.f27682a).values());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> l(N n4) {
        return new EdgesConnecting(((BiMap) this.f27682a).inverse(), n4);
    }
}
