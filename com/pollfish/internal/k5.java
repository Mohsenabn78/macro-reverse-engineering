package com.pollfish.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class k5 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final String f36991a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final String f36992b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final String f36993c;

    public k5(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        this.f36991a = str;
        this.f36992b = str2;
        this.f36993c = str3;
    }

    @NotNull
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("api_key", this.f36991a);
        jSONObject.put("build", this.f36992b);
        jSONObject.put("flavour", this.f36993c);
        return jSONObject;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k5)) {
            return false;
        }
        k5 k5Var = (k5) obj;
        if (Intrinsics.areEqual(this.f36991a, k5Var.f36991a) && Intrinsics.areEqual(this.f36992b, k5Var.f36992b) && Intrinsics.areEqual(this.f36993c, k5Var.f36993c)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f36993c.hashCode() + m4.a(this.f36992b, this.f36991a.hashCode() * 31, 31);
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("TagsSchema(apiKey=");
        a4.append(this.f36991a);
        a4.append(", build=");
        a4.append(this.f36992b);
        a4.append(", flavour=");
        return g5.a(a4, this.f36993c, ')');
    }

    public k5(@NotNull j5 j5Var) {
        this(j5Var.a(), j5Var.b(), j5Var.c());
    }
}
