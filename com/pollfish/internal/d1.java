package com.pollfish.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class d1 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final String f36757a;

    public d1(@NotNull String str) {
        this.f36757a = str;
    }

    @NotNull
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("stacktrace", this.f36757a);
        return jSONObject;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof d1) && Intrinsics.areEqual(this.f36757a, ((d1) obj).f36757a)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f36757a.hashCode();
    }

    @NotNull
    public final String toString() {
        return g5.a(u4.a("ExceptionSchema(stacktrace="), this.f36757a, ')');
    }

    public d1(@NotNull e1 e1Var) {
        this(e1Var.a());
    }
}
