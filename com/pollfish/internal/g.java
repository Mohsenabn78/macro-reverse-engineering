package com.pollfish.internal;

import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static x4 f36839a;

    public static void a(@NotNull x4 x4Var) {
        f36839a = x4Var;
    }

    @NotNull
    public static h a() {
        x4 x4Var = f36839a;
        if (x4Var == null) {
            x4Var = null;
        }
        String c4 = x4Var.c();
        x4 x4Var2 = f36839a;
        return new h(c4, (x4Var2 != null ? x4Var2 : null).m());
    }
}
