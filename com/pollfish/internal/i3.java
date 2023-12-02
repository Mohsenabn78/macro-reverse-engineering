package com.pollfish.internal;

import com.pollfish.internal.u1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class i3 implements u1.a<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c3 f36920a;

    public i3(c3 c3Var) {
        this.f36920a = c3Var;
    }

    @Override // com.pollfish.internal.u1.a
    public final void a(Boolean bool) {
        if (Intrinsics.areEqual(bool, Boolean.FALSE)) {
            this.f36920a.a(true, false);
        }
    }
}
