package com.pollfish.internal;

import com.pollfish.internal.l4;
import com.pollfish.internal.m5;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class f1<T> implements Runnable {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final Function0<l4<T>> f36812a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final Function1<l4<? extends T>, Unit> f36813b;

    public f1(@NotNull m5.b bVar, @NotNull m5.c cVar) {
        this.f36812a = bVar;
        this.f36813b = cVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (Thread.currentThread().isInterrupted()) {
            this.f36813b.invoke(l4.a.p.f37055c);
        }
        l4<T> invoke = this.f36812a.invoke();
        if (Thread.currentThread().isInterrupted()) {
            this.f36813b.invoke(l4.a.p.f37055c);
        } else {
            this.f36813b.invoke(invoke);
        }
    }
}
