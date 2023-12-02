package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@Beta
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public interface MutableNetwork<N, E> extends Network<N, E> {
    @CanIgnoreReturnValue
    boolean addEdge(EndpointPair<N> endpointPair, E e4);

    @CanIgnoreReturnValue
    boolean addEdge(N n4, N n5, E e4);

    @CanIgnoreReturnValue
    boolean addNode(N n4);

    @CanIgnoreReturnValue
    boolean removeEdge(E e4);

    @CanIgnoreReturnValue
    boolean removeNode(N n4);
}
