package com.pollfish.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class v1 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final String f37271a = "Android";
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final String f37272b;

    public v1(@NotNull String str) {
        this.f37272b = str;
    }

    @NotNull
    public final String a() {
        return this.f37271a;
    }

    @NotNull
    public final String b() {
        return this.f37272b;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v1)) {
            return false;
        }
        v1 v1Var = (v1) obj;
        if (Intrinsics.areEqual(this.f37271a, v1Var.f37271a) && Intrinsics.areEqual(this.f37272b, v1Var.f37272b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f37272b.hashCode() + (this.f37271a.hashCode() * 31);
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("OperatingSystem(name=");
        a4.append(this.f37271a);
        a4.append(", version=");
        return g5.a(a4, this.f37272b, ')');
    }
}
