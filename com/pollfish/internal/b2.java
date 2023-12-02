package com.pollfish.internal;

import com.pollfish.Pollfish;
import com.pollfish.internal.u1;

/* loaded from: classes6.dex */
public final class b2 implements u1.a<w0> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Pollfish f36696a;

    public b2(Pollfish pollfish) {
        this.f36696a = pollfish;
    }

    @Override // com.pollfish.internal.u1.a
    public final void a(w0 w0Var) {
        w0 w0Var2 = w0Var;
        if (w0Var2 != null) {
            Pollfish pollfish = this.f36696a;
            if (w0Var2 instanceof r1) {
                Pollfish.access$onLifecycleEvent(pollfish, (r1) w0Var2);
            }
        }
    }
}
