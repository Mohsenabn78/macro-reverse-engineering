package com.pollfish.internal;

import java.util.List;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public interface n5 {
    @NotNull
    <R> l4<Unit> a(@NotNull List<? extends Callable<l4<R>>> list);

    void a(@NotNull f1 f1Var);

    void a(@NotNull Function1 function1, @NotNull l4 l4Var);

    void shutdown();
}
