package com.pollfish.internal;

import com.pollfish.internal.l4;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class r0 implements p0 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final f f37185a;

    public r0(@NotNull f fVar) {
        this.f37185a = fVar;
    }

    @Override // com.pollfish.internal.p0
    @NotNull
    public final l4<Unit> a(@NotNull s0 s0Var) {
        try {
            return this.f37185a.a(s0Var.b(), new t0(s0Var).a().toString());
        } catch (Exception e4) {
            return new l4.a.k(s0Var.b(), s0Var.c(), e4);
        }
    }
}
