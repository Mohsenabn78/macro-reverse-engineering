package com.pollfish.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class y2 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final g2 f37360a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final i0 f37361b;

    public y2(@NotNull g2 g2Var, @NotNull i0 i0Var) {
        this.f37360a = g2Var;
        this.f37361b = i0Var;
    }

    @NotNull
    public final g2 a() {
        return this.f37360a;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y2)) {
            return false;
        }
        y2 y2Var = (y2) obj;
        if (Intrinsics.areEqual(this.f37360a, y2Var.f37360a) && Intrinsics.areEqual(this.f37361b, y2Var.f37361b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f37361b.hashCode() + (this.f37360a.hashCode() * 31);
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("PollfishOverlayParams(pollfishConfiguration=");
        a4.append(this.f37360a);
        a4.append(", deviceInfo=");
        a4.append(this.f37361b);
        a4.append(')');
        return a4.toString();
    }
}
