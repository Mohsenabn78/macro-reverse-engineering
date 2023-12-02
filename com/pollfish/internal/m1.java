package com.pollfish.internal;

import com.pollfish.builder.Position;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class m1 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final Position f37079a;

    /* renamed from: b  reason: collision with root package name */
    public final int f37080b;

    public m1(@NotNull Position position, int i4) {
        this.f37079a = position;
        this.f37080b = i4;
    }

    public final int a() {
        return this.f37080b;
    }

    @NotNull
    public final Position b() {
        return this.f37079a;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m1)) {
            return false;
        }
        m1 m1Var = (m1) obj;
        if (this.f37079a == m1Var.f37079a && this.f37080b == m1Var.f37080b) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f37080b + (this.f37079a.hashCode() * 31);
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("IndicatorConfiguration(position=");
        a4.append(this.f37079a);
        a4.append(", padding=");
        a4.append(this.f37080b);
        a4.append(')');
        return a4.toString();
    }
}
