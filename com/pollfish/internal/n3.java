package com.pollfish.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes6.dex */
public final class n3 extends Lambda implements Function0<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k3 f37134a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f37135b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n3(k3 k3Var, boolean z3) {
        super(0);
        this.f37134a = k3Var;
        this.f37135b = z3;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        k3.a(this.f37134a, true, this.f37135b);
        return Unit.INSTANCE;
    }
}
