package com.pollfish.internal;

import com.pollfish.internal.l4;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class x extends i5<Boolean, Unit> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final o f37295a;

    public x(@NotNull o oVar) {
        this.f37295a = oVar;
    }

    @Override // com.pollfish.internal.i5
    public final l4<Unit> a(Boolean bool) {
        l4<Unit> bVar;
        Boolean bool2 = bool;
        if (bool2 != null) {
            if (bool2.booleanValue()) {
                bVar = this.f37295a.a();
            } else {
                bVar = new l4.b<>(Unit.INSTANCE);
            }
            if (bVar != null) {
                return bVar;
            }
        }
        return l4.a.k0.f37041c;
    }
}
