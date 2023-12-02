package com.pollfish.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class g0 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final String f36840a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final String f36841b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final String f36842c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public final String f36843d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public final String f36844e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f36845f;

    public g0(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, boolean z3) {
        this.f36840a = str;
        this.f36841b = str2;
        this.f36842c = str3;
        this.f36843d = str4;
        this.f36844e = str5;
        this.f36845f = z3;
    }

    @NotNull
    public final String a() {
        return this.f36843d;
    }

    @NotNull
    public final String b() {
        return this.f36842c;
    }

    @NotNull
    public final String c() {
        return this.f36841b;
    }

    @NotNull
    public final String d() {
        return this.f36840a;
    }

    @NotNull
    public final String e() {
        return this.f36844e;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        if (Intrinsics.areEqual(this.f36840a, g0Var.f36840a) && Intrinsics.areEqual(this.f36841b, g0Var.f36841b) && Intrinsics.areEqual(this.f36842c, g0Var.f36842c) && Intrinsics.areEqual(this.f36843d, g0Var.f36843d) && Intrinsics.areEqual(this.f36844e, g0Var.f36844e) && this.f36845f == g0Var.f36845f) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        return this.f36845f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int a4 = m4.a(this.f36844e, m4.a(this.f36843d, m4.a(this.f36842c, m4.a(this.f36841b, this.f36840a.hashCode() * 31, 31), 31), 31), 31);
        boolean z3 = this.f36845f;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        return a4 + i4;
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("Device(name=");
        a4.append(this.f36840a);
        a4.append(", model=");
        a4.append(this.f36841b);
        a4.append(", manufacturer=");
        a4.append(this.f36842c);
        a4.append(", arch=");
        a4.append(this.f36843d);
        a4.append(", orientation=");
        a4.append(this.f36844e);
        a4.append(", simulator=");
        a4.append(this.f36845f);
        a4.append(')');
        return a4.toString();
    }
}
