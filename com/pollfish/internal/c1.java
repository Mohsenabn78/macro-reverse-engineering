package com.pollfish.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class c1 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final String f36713a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final String f36714b;

    public c1(@NotNull String str, @NotNull String str2) {
        this.f36713a = str;
        this.f36714b = str2;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c1)) {
            return false;
        }
        c1 c1Var = (c1) obj;
        if (Intrinsics.areEqual(this.f36713a, c1Var.f36713a) && Intrinsics.areEqual(this.f36714b, c1Var.f36714b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f36714b.hashCode() + (this.f36713a.hashCode() * 31);
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("ExceptionEntryValueSchema(type=");
        a4.append(this.f36713a);
        a4.append(", value=");
        return g5.a(a4, this.f36714b, ')');
    }

    public c1(@NotNull b1 b1Var) {
        this(b1Var.b(), b1Var.a());
    }
}
