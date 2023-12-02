package com.pollfish.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class p5 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final String f37155a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final String f37156b = "{{auto}}";

    public p5(@NotNull String str) {
        this.f37155a = str;
    }

    @NotNull
    public final String a() {
        return this.f37155a;
    }

    @NotNull
    public final String b() {
        return this.f37156b;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p5)) {
            return false;
        }
        p5 p5Var = (p5) obj;
        if (Intrinsics.areEqual(this.f37155a, p5Var.f37155a) && Intrinsics.areEqual(this.f37156b, p5Var.f37156b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f37156b.hashCode() + (this.f37155a.hashCode() * 31);
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("User(id=");
        a4.append(this.f37155a);
        a4.append(", ipAddress=");
        return g5.a(a4, this.f37156b, ')');
    }
}
