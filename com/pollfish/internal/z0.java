package com.pollfish.internal;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class z0 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final List<b1> f37369a;

    public z0(@NotNull List<b1> list) {
        this.f37369a = list;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof z0) && Intrinsics.areEqual(this.f37369a, ((z0) obj).f37369a)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f37369a.hashCode();
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("ExceptionEntry(values=");
        a4.append(this.f37369a);
        a4.append(')');
        return a4.toString();
    }
}
