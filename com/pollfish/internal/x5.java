package com.pollfish.internal;

import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class x5 {

    /* renamed from: a  reason: collision with root package name */
    public static n1 f37328a;

    /* renamed from: b  reason: collision with root package name */
    public static x4 f37329b;

    /* renamed from: c  reason: collision with root package name */
    public static x0 f37330c;

    public static void a(@NotNull n1 n1Var, @NotNull x4 x4Var, @NotNull x0 x0Var) {
        f37328a = n1Var;
        f37329b = x4Var;
        f37330c = x0Var;
    }

    @NotNull
    public static x3 a() {
        n1 n1Var = f37328a;
        if (n1Var == null) {
            n1Var = null;
        }
        x4 x4Var = f37329b;
        if (x4Var == null) {
            x4Var = null;
        }
        x0 x0Var = f37330c;
        return new x3(n1Var, x4Var, x0Var != null ? x0Var : null);
    }
}
