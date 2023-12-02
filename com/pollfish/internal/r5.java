package com.pollfish.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class r5 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final String f37195a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final String f37196b;

    public r5(@NotNull String str, @NotNull String str2) {
        this.f37195a = str;
        this.f37196b = str2;
    }

    @NotNull
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", this.f37195a);
        jSONObject.put("ip_address", this.f37196b);
        return jSONObject;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r5)) {
            return false;
        }
        r5 r5Var = (r5) obj;
        if (Intrinsics.areEqual(this.f37195a, r5Var.f37195a) && Intrinsics.areEqual(this.f37196b, r5Var.f37196b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f37196b.hashCode() + (this.f37195a.hashCode() * 31);
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("UserSchema(id=");
        a4.append(this.f37195a);
        a4.append(", ipAddress=");
        return g5.a(a4, this.f37196b, ')');
    }

    public r5(@NotNull p5 p5Var) {
        this(p5Var.a(), p5Var.b());
    }
}
