package com.pollfish.internal;

import com.pollfish.internal.l4;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class n4 {
    public static final boolean a(@NotNull l4<?> l4Var) {
        return l4Var instanceof l4.a;
    }

    public static final boolean b(@NotNull l4<?> l4Var) {
        if ((l4Var instanceof l4.b) && ((l4.b) l4Var).a() != null) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final l4 a(@NotNull Function1 function1, @NotNull l4 l4Var) {
        if (l4Var instanceof l4.b) {
            return new l4.b(function1.invoke(((l4.b) l4Var).a()));
        }
        if (l4Var instanceof l4.a) {
            return l4Var;
        }
        throw new NoWhenBranchMatchedException();
    }
}
