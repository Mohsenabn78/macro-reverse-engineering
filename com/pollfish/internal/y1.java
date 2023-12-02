package com.pollfish.internal;

import com.pollfish.builder.Platform;
import com.pollfish.builder.Position;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class y1 {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f37353a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f37354b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f37355c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public final Position f37356d;

    /* renamed from: e  reason: collision with root package name */
    public final int f37357e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f37358f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    public final Platform f37359g;

    public y1(boolean z3, boolean z4, boolean z5, @NotNull Position position, int i4, boolean z6, @NotNull Platform platform) {
        this.f37353a = z3;
        this.f37354b = z4;
        this.f37355c = z5;
        this.f37356d = position;
        this.f37357e = i4;
        this.f37358f = z6;
        this.f37359g = platform;
    }

    public final boolean a() {
        return this.f37358f;
    }

    public final boolean b() {
        return this.f37355c;
    }

    public final int c() {
        return this.f37357e;
    }

    @NotNull
    public final Platform d() {
        return this.f37359g;
    }

    @NotNull
    public final Position e() {
        return this.f37356d;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y1)) {
            return false;
        }
        y1 y1Var = (y1) obj;
        if (this.f37353a == y1Var.f37353a && this.f37354b == y1Var.f37354b && this.f37355c == y1Var.f37355c && this.f37356d == y1Var.f37356d && this.f37357e == y1Var.f37357e && this.f37358f == y1Var.f37358f && this.f37359g == y1Var.f37359g) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        return this.f37353a;
    }

    public final boolean g() {
        return this.f37354b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r3v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean] */
    public final int hashCode() {
        boolean z3 = this.f37353a;
        int i4 = 1;
        ?? r02 = z3;
        if (z3) {
            r02 = 1;
        }
        int i5 = r02 * 31;
        ?? r32 = this.f37354b;
        int i6 = r32;
        if (r32 != 0) {
            i6 = 1;
        }
        int i7 = (i5 + i6) * 31;
        ?? r33 = this.f37355c;
        int i8 = r33;
        if (r33 != 0) {
            i8 = 1;
        }
        int hashCode = this.f37356d.hashCode();
        int a4 = x1.a(this.f37357e, (hashCode + ((i7 + i8) * 31)) * 31, 31);
        boolean z4 = this.f37358f;
        if (!z4) {
            i4 = z4 ? 1 : 0;
        }
        return this.f37359g.hashCode() + ((a4 + i4) * 31);
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("Params(releaseMode=");
        a4.append(this.f37353a);
        a4.append(", rewardMode=");
        a4.append(this.f37354b);
        a4.append(", offerwall=");
        a4.append(this.f37355c);
        a4.append(", position=");
        a4.append(this.f37356d);
        a4.append(", padding=");
        a4.append(this.f37357e);
        a4.append(", container=");
        a4.append(this.f37358f);
        a4.append(", platform=");
        a4.append(this.f37359g);
        a4.append(')');
        return a4.toString();
    }
}
