package com.pollfish.internal;

import com.pollfish.builder.Platform;
import com.pollfish.builder.RewardInfo;
import com.pollfish.builder.UserProperties;
import com.pollfish.internal.l4;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class t4 extends i5<x4, l2> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final i5<?, k0> f37242a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final i5<x4, t> f37243b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final i1 f37244c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public final d f37245d;

    public t4(@NotNull r4 r4Var, @NotNull p4 p4Var, @NotNull i1 i1Var, @NotNull d dVar) {
        this.f37242a = r4Var;
        this.f37243b = p4Var;
        this.f37244c = i1Var;
        this.f37245d = dVar;
    }

    @Override // com.pollfish.internal.i5
    public final l4<l2> a(x4 x4Var) {
        x4 x4Var2 = x4Var;
        if (x4Var2 == null) {
            return l4.a.k0.f37041c;
        }
        l4 a4 = this.f37243b.a((i5<x4, t>) x4Var2);
        if (!(a4 instanceof l4.a)) {
            t tVar = (t) ((l4.b) a4).a();
            a4 = this.f37242a.a((i5<?, k0>) ((i5) null));
            if (!(a4 instanceof l4.a)) {
                k0 k0Var = (k0) ((l4.b) a4).a();
                a4 = this.f37245d.b();
                if (!(a4 instanceof l4.a)) {
                    String a5 = x4Var2.a();
                    boolean g4 = x4Var2.g();
                    Platform h4 = x4Var2.h();
                    boolean l4 = x4Var2.l();
                    int f4 = x4Var2.f();
                    RewardInfo k4 = x4Var2.k();
                    UserProperties q4 = x4Var2.q();
                    this.f37244c.c();
                    a4 = new l4.b(new l2(a5, k0Var, tVar, g4, l4, h4, "googleplay", (h0) ((l4.b) a4).a(), f4, k4, q4));
                }
            }
        }
        return a4;
    }
}
