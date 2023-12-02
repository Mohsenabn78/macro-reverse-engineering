package com.pollfish.internal;

import com.pollfish.internal.l4;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class p4 extends i5<x4, t> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final i5<?, h1> f37152a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final i5<?, c> f37153b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final l0 f37154c;

    public p4(@NotNull s4 s4Var, @NotNull o4 o4Var, @NotNull l0 l0Var) {
        this.f37152a = s4Var;
        this.f37153b = o4Var;
        this.f37154c = l0Var;
    }

    @Override // com.pollfish.internal.i5
    public final l4<t> a(x4 x4Var) {
        l4<t> a4;
        l4<t> a5;
        x4 x4Var2 = x4Var;
        if (x4Var2 != null) {
            a4 = this.f37153b.a((i5<?, c>) ((i5) null));
            if (a4 instanceof l4.a) {
                return a4;
            }
            c cVar = (c) ((l4.b) a4).a();
            a5 = this.f37152a.a((i5<?, h1>) ((i5) null));
            if (a5 instanceof l4.a) {
                return a5;
            }
            return new l4.b(new t(x4Var2.a(), cVar.a(), Integer.valueOf(x4Var2.n()), x4Var2.o(), x4Var2.j(), ((h1) ((l4.b) a5).a()).a(), !x4Var2.i(), this.f37154c.d(), x4Var2.b(), cVar.b()));
        }
        return l4.a.k0.f37041c;
    }
}
