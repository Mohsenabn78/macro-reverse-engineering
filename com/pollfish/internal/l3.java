package com.pollfish.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes6.dex */
public final class l3 extends Lambda implements Function0<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f37008a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l3(Function0<Unit> function0) {
        super(0);
        this.f37008a = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        this.f37008a.invoke();
        return Unit.INSTANCE;
    }
}
