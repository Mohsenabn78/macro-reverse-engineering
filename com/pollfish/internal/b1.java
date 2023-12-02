package com.pollfish.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class b1 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final String f36694a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final String f36695b;

    public b1(@NotNull String str, @NotNull String str2) {
        this.f36694a = str;
        this.f36695b = str2;
    }

    @NotNull
    public final String a() {
        return this.f36695b;
    }

    @NotNull
    public final String b() {
        return this.f36694a;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b1)) {
            return false;
        }
        b1 b1Var = (b1) obj;
        if (Intrinsics.areEqual(this.f36694a, b1Var.f36694a) && Intrinsics.areEqual(this.f36695b, b1Var.f36695b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f36695b.hashCode() + (this.f36694a.hashCode() * 31);
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("ExceptionEntryValue(type=");
        a4.append(this.f36694a);
        a4.append(", message=");
        return g5.a(a4, this.f36695b, ')');
    }
}
