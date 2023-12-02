package com.pollfish.internal;

import com.pollfish.internal.u1;
import com.pollfish.internal.y5;

/* loaded from: classes6.dex */
public final class e3 implements u1.a<w0> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c3 f36783a;

    public e3(c3 c3Var) {
        this.f36783a = c3Var;
    }

    @Override // com.pollfish.internal.u1.a
    public final void a(w0 w0Var) {
        w0 w0Var2 = w0Var;
        if (w0Var2 instanceof y5.d) {
            this.f36783a.a(false, false);
        } else if (w0Var2 instanceof y5.c) {
            this.f36783a.a(false, true);
        }
    }
}
