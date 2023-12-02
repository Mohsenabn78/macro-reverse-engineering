package com.pollfish.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class s0 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final String f37198a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final String f37199b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final t f37200c;

    public s0(@NotNull String str, @NotNull String str2, @NotNull t tVar) {
        this.f37198a = str;
        this.f37199b = str2;
        this.f37200c = tVar;
    }

    @NotNull
    public final t a() {
        return this.f37200c;
    }

    @NotNull
    public final String b() {
        return this.f37198a;
    }

    @NotNull
    public final String c() {
        return this.f37199b;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s0)) {
            return false;
        }
        s0 s0Var = (s0) obj;
        if (Intrinsics.areEqual(this.f37198a, s0Var.f37198a) && Intrinsics.areEqual(this.f37199b, s0Var.f37199b) && Intrinsics.areEqual(this.f37200c, s0Var.f37200c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f37200c.hashCode() + m4.a(this.f37199b, this.f37198a.hashCode() * 31, 31);
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("EndpointParams(endpoint=");
        a4.append(this.f37198a);
        a4.append(", params=");
        a4.append(this.f37199b);
        a4.append(", baseParams=");
        a4.append(this.f37200c);
        a4.append(')');
        return a4.toString();
    }
}
