package com.pollfish.internal;

import com.pollfish.internal.f4;
import com.pollfish.internal.l4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class j4 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final f4.a f36940a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final l4.a f36941b;

    public j4(@NotNull f4.a aVar, @NotNull l4.a aVar2) {
        this.f36940a = aVar;
        this.f36941b = aVar2;
    }

    @NotNull
    public final l4.a a() {
        return this.f36941b;
    }

    @NotNull
    public final f4.a b() {
        return this.f36940a;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j4)) {
            return false;
        }
        j4 j4Var = (j4) obj;
        if (this.f36940a == j4Var.f36940a && Intrinsics.areEqual(this.f36941b, j4Var.f36941b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f36941b.hashCode() + (this.f36940a.hashCode() * 31);
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("ReporterParams(type=");
        a4.append(this.f36940a);
        a4.append(", error=");
        a4.append(this.f36941b);
        a4.append(')');
        return a4.toString();
    }
}
