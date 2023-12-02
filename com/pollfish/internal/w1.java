package com.pollfish.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class w1 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final String f37280a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final String f37281b;

    public w1(@NotNull String str, @NotNull String str2) {
        this.f37280a = str;
        this.f37281b = str2;
    }

    @NotNull
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("name", this.f37280a);
        jSONObject.put("version", this.f37281b);
        return jSONObject;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w1)) {
            return false;
        }
        w1 w1Var = (w1) obj;
        if (Intrinsics.areEqual(this.f37280a, w1Var.f37280a) && Intrinsics.areEqual(this.f37281b, w1Var.f37281b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f37281b.hashCode() + (this.f37280a.hashCode() * 31);
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("OperatingSystemSchema(name=");
        a4.append(this.f37280a);
        a4.append(", version=");
        return g5.a(a4, this.f37281b, ')');
    }

    public w1(@NotNull v1 v1Var) {
        this(v1Var.a(), v1Var.b());
    }
}
