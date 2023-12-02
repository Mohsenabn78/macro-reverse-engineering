package com.pollfish.internal;

import com.pollfish.internal.l4;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class o4 extends i5<?, c> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final d f37141a;

    public o4(@NotNull d dVar) {
        this.f37141a = dVar;
    }

    @Override // com.pollfish.internal.i5
    public final l4<c> a(Object obj) {
        Void r4 = (Void) obj;
        l4<String> c4 = this.f37141a.c();
        if (c4 instanceof l4.b) {
            String str = (String) ((l4.b) c4).a();
            l4<Boolean> a4 = this.f37141a.a();
            if (a4 instanceof l4.b) {
                return new l4.b(new c(str, ((Boolean) ((l4.b) a4).a()).booleanValue()));
            }
            return (l4.a) a4;
        }
        return (l4.a) c4;
    }
}
