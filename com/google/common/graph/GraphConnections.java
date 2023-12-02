package com.google.common.graph;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
interface GraphConnections<N, V> {
    Set<N> a();

    Set<N> b();

    Set<N> c();

    void d(N n4, V v3);

    @CheckForNull
    V e(N n4);

    @CanIgnoreReturnValue
    @CheckForNull
    V f(N n4);

    void g(N n4);

    Iterator<EndpointPair<N>> h(N n4);

    @CanIgnoreReturnValue
    @CheckForNull
    V i(N n4, V v3);
}
