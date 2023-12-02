package com.pollfish.internal;

import com.pollfish.internal.f4;
import com.pollfish.internal.l4;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class x2 implements w2 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final i4 f37296a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final i4 f37297b;

    public x2(@NotNull b0 b0Var, @NotNull c5 c5Var) {
        this.f37296a = b0Var;
        this.f37297b = c5Var;
    }

    @Override // com.pollfish.internal.w2
    public final void a() {
    }

    @Override // com.pollfish.internal.w2
    public final void b(@NotNull String str, @Nullable l4.a aVar) {
        this.f37297b.a(f4.a.ERROR, str, aVar);
    }

    @Override // com.pollfish.internal.w2
    public final void c(@NotNull String str, @Nullable l4.a aVar) {
        this.f37297b.a(f4.a.ERROR, str, aVar);
    }

    @Override // com.pollfish.internal.w2
    public final void d(@NotNull String str, @Nullable l4.a aVar) {
        this.f37297b.a(f4.a.ERROR, str, aVar);
    }

    @Override // com.pollfish.internal.w2
    public final void a(@NotNull String str, @Nullable l4.a aVar) {
        this.f37296a.a(f4.a.INFO, str, aVar);
    }
}
