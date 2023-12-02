package com.pollfish.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes6.dex */
public final class p2 extends Lambda implements Function0<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ n2 f37150a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p2(n2 n2Var) {
        super(0);
        this.f37150a = n2Var;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        n2.e(this.f37150a);
        this.f37150a.f37122a.x();
        return Unit.INSTANCE;
    }
}
