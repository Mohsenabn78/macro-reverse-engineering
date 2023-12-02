package com.pollfish.internal;

import com.pollfish.internal.l4;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class b5 extends s<a5, Unit> {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final p0 f36709b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final i5<x4, t> f36710c;

    public b5(@NotNull p0 p0Var, @NotNull p4 p4Var, @NotNull m5 m5Var) {
        super(m5Var);
        this.f36709b = p0Var;
        this.f36710c = p4Var;
    }

    @Override // com.pollfish.internal.s
    public final l4<Unit> a(a5 a5Var) {
        a5 a5Var2 = a5Var;
        if (a5Var2 != null) {
            l4 a4 = this.f36710c.a((i5<x4, t>) a5Var2.c());
            if (!(a4 instanceof l4.a)) {
                return this.f36709b.a(new s0(a5Var2.b(), a5Var2.a(), (t) ((l4.b) a4).a()));
            }
            return a4;
        }
        return l4.a.k0.f37041c;
    }
}
