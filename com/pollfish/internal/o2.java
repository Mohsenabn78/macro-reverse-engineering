package com.pollfish.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes6.dex */
public final class o2 extends Lambda implements Function0<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f37139a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o2(Function0<Unit> function0) {
        super(0);
        this.f37139a = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        this.f37139a.invoke();
        return Unit.INSTANCE;
    }
}
