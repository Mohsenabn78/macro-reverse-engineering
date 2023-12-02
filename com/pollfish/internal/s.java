package com.pollfish.internal;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public abstract class s<P, R> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final m5 f37197a;

    public s(@NotNull m5 m5Var) {
        this.f37197a = m5Var;
    }

    @NotNull
    public abstract l4<R> a(@Nullable P p4);

    public final void a(P p4, @NotNull Function1<? super l4<? extends R>, Unit> function1) {
        this.f37197a.a((s<? super s<P, R>, R>) this, (s<P, R>) p4, (Function1) function1);
    }
}
