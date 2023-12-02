package com.pollfish.internal;

import android.content.Context;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes6.dex */
public final class u5 extends Lambda implements Function0<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ w5 f37267a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f37268b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u5(w5 w5Var, Context context) {
        super(0);
        this.f37267a = w5Var;
        this.f37268b = context;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        this.f37267a.f37286c = new WeakReference(t5.c(this.f37268b));
        w5.f(this.f37267a);
        return Unit.INSTANCE;
    }
}
