package com.pollfish.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes6.dex */
public final class b3 extends Lambda implements Function0<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c3 f36697a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b3(c3 c3Var) {
        super(0);
        this.f36697a = c3Var;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        this.f36697a.f36734t = true;
        return Unit.INSTANCE;
    }
}
