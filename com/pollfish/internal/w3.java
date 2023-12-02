package com.pollfish.internal;

import com.pollfish.internal.l4;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes6.dex */
public final class w3 extends Lambda implements Function1<l4<? extends Unit>, Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ x3 f37282a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w3(x3 x3Var) {
        super(1);
        this.f37282a = x3Var;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(l4<? extends Unit> l4Var) {
        l4<? extends Unit> l4Var2 = l4Var;
        if (n4.a(l4Var2)) {
            x3.a(this.f37282a, (l4.a) l4Var2);
        }
        return Unit.INSTANCE;
    }
}
