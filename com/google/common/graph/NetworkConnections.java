package com.google.common.graph;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
interface NetworkConnections<N, E> {
    Set<N> a();

    Set<N> b();

    Set<N> c();

    N d(E e4);

    Set<E> e();

    @CanIgnoreReturnValue
    N f(E e4);

    Set<E> g();

    @CanIgnoreReturnValue
    @CheckForNull
    N h(E e4, boolean z3);

    void i(E e4, N n4);

    void j(E e4, N n4, boolean z3);

    Set<E> k();

    Set<E> l(N n4);
}
