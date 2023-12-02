package com.pollfish.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class t0 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final String f37222a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final JSONObject f37223b;

    public t0(@NotNull String str, @NotNull JSONObject jSONObject) {
        this.f37222a = str;
        this.f37223b = jSONObject;
    }

    @NotNull
    public final JSONObject a() {
        boolean z3;
        JSONObject jSONObject;
        if (this.f37222a.length() > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            jSONObject = new JSONObject(this.f37222a);
        } else {
            jSONObject = new JSONObject();
        }
        q1.a(jSONObject, this.f37223b);
        return jSONObject;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t0)) {
            return false;
        }
        t0 t0Var = (t0) obj;
        if (Intrinsics.areEqual(this.f37222a, t0Var.f37222a) && Intrinsics.areEqual(this.f37223b, t0Var.f37223b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f37223b.hashCode() + (this.f37222a.hashCode() * 31);
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("EndpointRequestSchema(params=");
        a4.append(this.f37222a);
        a4.append(", baseParams=");
        a4.append(this.f37223b);
        a4.append(')');
        return a4.toString();
    }

    public t0(@NotNull s0 s0Var) {
        this(s0Var.c(), new u(s0Var.a()).a());
    }
}
