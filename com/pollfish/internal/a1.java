package com.pollfish.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class a1 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final z0 f36682a;

    public a1(@NotNull z0 z0Var) {
        this.f36682a = z0Var;
    }

    @NotNull
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (b1 b1Var : this.f36682a.f37369a) {
            c1 c1Var = new c1(b1Var);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("type", c1Var.f36713a);
            jSONObject2.put("value", c1Var.f36714b);
            jSONArray.put(jSONObject2);
        }
        jSONObject.put("values", jSONArray);
        return jSONObject;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof a1) && Intrinsics.areEqual(this.f36682a, ((a1) obj).f36682a)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f36682a.f37369a.hashCode();
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("ExceptionEntrySchema(entry=");
        a4.append(this.f36682a);
        a4.append(')');
        return a4.toString();
    }
}
