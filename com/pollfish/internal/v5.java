package com.pollfish.internal;

import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes6.dex */
public final class v5 extends Lambda implements Function0<Unit> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ w5 f37277a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ViewGroup f37278b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v5(w5 w5Var, ViewGroup viewGroup) {
        super(0);
        this.f37277a = w5Var;
        this.f37278b = viewGroup;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Unit invoke() {
        this.f37277a.f37286c = new WeakReference(t5.c(this.f37278b.getContext()));
        this.f37277a.f37287d = new WeakReference(this.f37278b.getContext());
        w5.f(this.f37277a);
        return Unit.INSTANCE;
    }
}
