package com.google.common.graph;

import com.google.common.base.Optional;

@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
abstract class AbstractGraphBuilder<N> {

    /* renamed from: a  reason: collision with root package name */
    final boolean f27672a;

    /* renamed from: b  reason: collision with root package name */
    boolean f27673b = false;

    /* renamed from: c  reason: collision with root package name */
    ElementOrder<N> f27674c = ElementOrder.insertion();

    /* renamed from: d  reason: collision with root package name */
    ElementOrder<N> f27675d = ElementOrder.unordered();

    /* renamed from: e  reason: collision with root package name */
    Optional<Integer> f27676e = Optional.absent();

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbstractGraphBuilder(boolean z3) {
        this.f27672a = z3;
    }
}
