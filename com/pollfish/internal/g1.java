package com.pollfish.internal;

import com.pollfish.internal.l4;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class g1 extends i5<x4, y2> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final j2 f36846a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final i5<x4, i0> f36847b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final i5<?, c> f36848c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public final i5<x4, l2> f36849d;

    public g1(@NotNull j2 j2Var, @NotNull q4 q4Var, @NotNull o4 o4Var, @NotNull t4 t4Var) {
        this.f36846a = j2Var;
        this.f36847b = q4Var;
        this.f36848c = o4Var;
        this.f36849d = t4Var;
    }

    @Override // com.pollfish.internal.i5
    public final l4<y2> a(x4 x4Var) {
        l4<y2> a4;
        x4 x4Var2 = x4Var;
        if (x4Var2 != null) {
            a4 = this.f36848c.a((i5<?, c>) ((i5) null));
            if (a4 instanceof l4.a) {
                return a4;
            }
            l4<l2> a5 = this.f36849d.a((i5<x4, l2>) x4Var2);
            if (a5 instanceof l4.b) {
                l4<g2> a6 = this.f36846a.a((l2) ((l4.b) a5).a());
                if (a6 instanceof l4.b) {
                    g2 g2Var = (g2) ((l4.b) a6).a();
                    l4<i0> a7 = this.f36847b.a((i5<x4, i0>) x4Var2);
                    if (a7 instanceof l4.b) {
                        return new l4.b(new y2(g2Var, (i0) ((l4.b) a7).a()));
                    }
                    return (l4.a) a7;
                }
                return (l4.a) a6;
            }
            return (l4.a) a5;
        }
        return l4.a.k0.f37041c;
    }
}
