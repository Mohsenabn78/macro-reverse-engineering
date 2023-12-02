package com.pollfish.internal;

import com.pollfish.internal.e4;
import com.pollfish.internal.l4;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class h2 implements i2 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public f f36895a;

    public h2(@NotNull f fVar) {
        this.f36895a = fVar;
    }

    @Override // com.pollfish.internal.i2
    @NotNull
    public final l4<g2> a(@NotNull l2 l2Var) {
        String replace$default;
        l4.b bVar;
        try {
            replace$default = kotlin.text.m.replace$default(new d4(l2Var).a().toString(0), "\n", "", false, 4, (Object) null);
            l4<String> a4 = this.f36895a.a(replace$default);
            try {
                if (a4 instanceof l4.b) {
                    return new l4.b(e4.a.a((String) ((l4.b) a4).a()).a(l2Var.g()));
                }
                return (l4.a) a4;
            } catch (Exception e4) {
                if (a4 instanceof l4.b) {
                    bVar = (l4.b) a4;
                } else {
                    bVar = null;
                }
                return new l4.a.x((bVar == null || (r0 = (String) bVar.a()) == null) ? "" : "", e4);
            }
        } catch (Exception e5) {
            return new l4.a.w(e5);
        }
    }
}
