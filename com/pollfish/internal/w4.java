package com.pollfish.internal;

import com.pollfish.internal.l4;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class w4 extends i5<String, Unit> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final o f37283a;

    public w4(@NotNull o oVar) {
        this.f37283a = oVar;
    }

    @Override // com.pollfish.internal.i5
    public final l4<Unit> a(String str) {
        l4<Unit> a4;
        String str2 = str;
        if (str2 == null || (a4 = this.f37283a.a(str2)) == null) {
            return l4.a.k0.f37041c;
        }
        return a4;
    }
}
