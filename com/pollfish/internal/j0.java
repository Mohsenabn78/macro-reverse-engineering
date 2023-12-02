package com.pollfish.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class j0 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final String f36925a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final String f36926b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final String f36927c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public final String f36928d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public final String f36929e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f36930f;

    public j0(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, boolean z3) {
        this.f36925a = str;
        this.f36926b = str2;
        this.f36927c = str3;
        this.f36928d = str4;
        this.f36929e = str5;
        this.f36930f = z3;
    }

    @NotNull
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", this.f36925a);
        jSONObject.put("model", this.f36926b);
        jSONObject.put("manufacturer", this.f36927c);
        jSONObject.put("arch", this.f36928d);
        jSONObject.put("orientation", this.f36929e);
        jSONObject.put("simulator", this.f36930f);
        return jSONObject;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j0)) {
            return false;
        }
        j0 j0Var = (j0) obj;
        if (Intrinsics.areEqual(this.f36925a, j0Var.f36925a) && Intrinsics.areEqual(this.f36926b, j0Var.f36926b) && Intrinsics.areEqual(this.f36927c, j0Var.f36927c) && Intrinsics.areEqual(this.f36928d, j0Var.f36928d) && Intrinsics.areEqual(this.f36929e, j0Var.f36929e) && this.f36930f == j0Var.f36930f) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int a4 = m4.a(this.f36929e, m4.a(this.f36928d, m4.a(this.f36927c, m4.a(this.f36926b, this.f36925a.hashCode() * 31, 31), 31), 31), 31);
        boolean z3 = this.f36930f;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        return a4 + i4;
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("DeviceSchema(name=");
        a4.append(this.f36925a);
        a4.append(", model=");
        a4.append(this.f36926b);
        a4.append(", manufacturer=");
        a4.append(this.f36927c);
        a4.append(", arch=");
        a4.append(this.f36928d);
        a4.append(", orientation=");
        a4.append(this.f36929e);
        a4.append(", simulator=");
        a4.append(this.f36930f);
        a4.append(')');
        return a4.toString();
    }

    public j0(@NotNull g0 g0Var) {
        this(g0Var.d(), g0Var.c(), g0Var.b(), g0Var.a(), g0Var.e(), g0Var.f());
    }
}
