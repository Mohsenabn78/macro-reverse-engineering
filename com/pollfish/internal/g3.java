package com.pollfish.internal;

import com.pollfish.internal.u1;
import kotlin.Unit;

/* loaded from: classes6.dex */
public final class g3 implements u1.a<j3> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c3 f36876a;

    public g3(c3 c3Var) {
        this.f36876a = c3Var;
    }

    @Override // com.pollfish.internal.u1.a
    public final void a(j3 j3Var) {
        Unit unit;
        j3 j3Var2 = j3Var;
        if (j3Var2 != null) {
            c3.a(this.f36876a, j3Var2);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            c3.d(this.f36876a);
        }
    }
}
