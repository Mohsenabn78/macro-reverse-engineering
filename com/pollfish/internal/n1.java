package com.pollfish.internal;

import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class n1 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final s<x4, y2> f37119a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final s<a5, Unit> f37120b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final s<j4, Unit> f37121c;

    public n1(@NotNull d5 d5Var, @NotNull b5 b5Var, @NotNull g4 g4Var) {
        this.f37119a = d5Var;
        this.f37120b = b5Var;
        this.f37121c = g4Var;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n1)) {
            return false;
        }
        n1 n1Var = (n1) obj;
        if (Intrinsics.areEqual(this.f37119a, n1Var.f37119a) && Intrinsics.areEqual(this.f37120b, n1Var.f37120b) && Intrinsics.areEqual(this.f37121c, n1Var.f37121c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.f37120b.hashCode();
        return this.f37121c.hashCode() + ((hashCode + (this.f37119a.hashCode() * 31)) * 31);
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("Interactor(startFlowUseCase=");
        a4.append(this.f37119a);
        a4.append(", sendToServerUseCase=");
        a4.append(this.f37120b);
        a4.append(", reportErrorUseCase=");
        a4.append(this.f37121c);
        a4.append(')');
        return a4.toString();
    }
}
