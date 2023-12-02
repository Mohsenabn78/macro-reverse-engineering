package com.pollfish.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class j5 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final String f36942a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final String f36943b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final String f36944c;

    public j5(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        this.f36942a = str;
        this.f36943b = str2;
        this.f36944c = str3;
    }

    @NotNull
    public final String a() {
        return this.f36942a;
    }

    @NotNull
    public final String b() {
        return this.f36943b;
    }

    @NotNull
    public final String c() {
        return this.f36944c;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j5)) {
            return false;
        }
        j5 j5Var = (j5) obj;
        if (Intrinsics.areEqual(this.f36942a, j5Var.f36942a) && Intrinsics.areEqual(this.f36943b, j5Var.f36943b) && Intrinsics.areEqual(this.f36944c, j5Var.f36944c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f36944c.hashCode() + m4.a(this.f36943b, this.f36942a.hashCode() * 31, 31);
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("Tags(apiKey=");
        a4.append(this.f36942a);
        a4.append(", build=");
        a4.append(this.f36943b);
        a4.append(", flavour=");
        return g5.a(a4, this.f36944c, ')');
    }
}
