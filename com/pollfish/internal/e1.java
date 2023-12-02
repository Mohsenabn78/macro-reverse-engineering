package com.pollfish.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class e1 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final String f36782a;

    public e1(@NotNull String str) {
        this.f36782a = str;
    }

    @NotNull
    public final String a() {
        return this.f36782a;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof e1) && Intrinsics.areEqual(this.f36782a, ((e1) obj).f36782a)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f36782a.hashCode();
    }

    @NotNull
    public final String toString() {
        return g5.a(u4.a("ExceptionValue(stacktrace="), this.f36782a, ')');
    }
}
