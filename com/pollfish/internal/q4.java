package com.pollfish.internal;

import com.pollfish.internal.l4;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class q4 extends i5<x4, i0> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final l0 f37163a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final i1 f37164b;

    public q4(@NotNull l0 l0Var, @NotNull i1 i1Var) {
        this.f37163a = l0Var;
        this.f37164b = i1Var;
    }

    @Override // com.pollfish.internal.i5
    public final l4<i0> a(x4 x4Var) {
        x4 x4Var2 = x4Var;
        if (x4Var2 == null) {
            return l4.a.k0.f37041c;
        }
        int b4 = this.f37163a.b();
        String e4 = this.f37163a.e();
        String str = x4Var2.f37326q;
        int i4 = x4Var2.f37319j;
        this.f37164b.a();
        return new l4.b(new i0(b4, e4, str, i4, 122));
    }
}
