package com.pollfish.internal;

import com.pollfish.internal.l4;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class g4 extends s<j4, Unit> {
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final w2 f36877b;

    public g4(@NotNull w2 w2Var, @NotNull m5 m5Var) {
        super(m5Var);
        this.f36877b = w2Var;
    }

    @Override // com.pollfish.internal.s
    public final l4<Unit> a(j4 j4Var) {
        j4 j4Var2 = j4Var;
        if (j4Var2 != null) {
            int ordinal = j4Var2.b().ordinal();
            if (ordinal != 0) {
                if (ordinal != 1) {
                    if (ordinal != 2) {
                        if (ordinal != 3) {
                            if (ordinal == 4) {
                                this.f36877b.b(j4Var2.a().a(), j4Var2.a());
                            }
                        } else {
                            this.f36877b.d(j4Var2.a().a(), j4Var2.a());
                        }
                    } else {
                        this.f36877b.c(j4Var2.a().a(), j4Var2.a());
                    }
                } else {
                    w2 w2Var = this.f36877b;
                    j4Var2.a().a();
                    w2Var.a();
                }
            } else {
                this.f36877b.a(j4Var2.a().a(), j4Var2.a());
            }
            return new l4.b(Unit.INSTANCE);
        }
        return l4.a.k0.f37041c;
    }
}
