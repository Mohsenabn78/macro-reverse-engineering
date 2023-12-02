package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.DoNotMock;

@DoNotMock("Implement with a lambda, or use GraphBuilder to build a Graph with the desired edges")
@Beta
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public interface SuccessorsFunction<N> {
    Iterable<? extends N> successors(N n4);
}
