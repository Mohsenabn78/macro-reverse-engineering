package com.pollfish.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class h1 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final String f36891a = "pollfish-android";

    /* renamed from: b  reason: collision with root package name */
    public final int f36892b = 122;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final String f36893c = "6.4.0";
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public final String f36894d = "googleplay";

    public final int a() {
        return this.f36892b;
    }

    @NotNull
    public final String b() {
        return this.f36893c;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h1)) {
            return false;
        }
        h1 h1Var = (h1) obj;
        if (Intrinsics.areEqual(this.f36891a, h1Var.f36891a) && this.f36892b == h1Var.f36892b && Intrinsics.areEqual(this.f36893c, h1Var.f36893c) && Intrinsics.areEqual(this.f36894d, h1Var.f36894d)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f36894d.hashCode() + m4.a(this.f36893c, x1.a(this.f36892b, this.f36891a.hashCode() * 31, 31), 31);
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("FrameworkInfo(sdkName=");
        a4.append(this.f36891a);
        a4.append(", sdkVersion=");
        a4.append(this.f36892b);
        a4.append(", sdkVersionName=");
        a4.append(this.f36893c);
        a4.append(", flavour=");
        return g5.a(a4, this.f36894d, ')');
    }
}
