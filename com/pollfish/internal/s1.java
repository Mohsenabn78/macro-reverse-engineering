package com.pollfish.internal;

import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class s1 {

    /* renamed from: a  reason: collision with root package name */
    public static x4 f37201a;

    /* renamed from: b  reason: collision with root package name */
    public static i1 f37202b;

    /* renamed from: c  reason: collision with root package name */
    public static l0 f37203c;

    /* renamed from: d  reason: collision with root package name */
    public static d f37204d;

    /* renamed from: e  reason: collision with root package name */
    public static f f37205e;

    public static void a(@NotNull x4 x4Var, @NotNull i1 i1Var, @NotNull l0 l0Var, @NotNull d dVar, @NotNull f fVar) {
        f37201a = x4Var;
        f37202b = i1Var;
        f37203c = l0Var;
        f37204d = dVar;
        f37205e = fVar;
    }

    @NotNull
    public static x2 a() {
        b0 b0Var = new b0();
        x4 x4Var = f37201a;
        x4 x4Var2 = x4Var == null ? null : x4Var;
        l0 l0Var = f37203c;
        l0 l0Var2 = l0Var == null ? null : l0Var;
        i1 i1Var = f37202b;
        i1 i1Var2 = i1Var == null ? null : i1Var;
        d dVar = f37204d;
        d dVar2 = dVar == null ? null : dVar;
        f fVar = f37205e;
        return new x2(b0Var, new c5(x4Var2, l0Var2, i1Var2, dVar2, fVar == null ? null : fVar));
    }
}
