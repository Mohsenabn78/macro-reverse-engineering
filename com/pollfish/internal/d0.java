package com.pollfish.internal;

import com.sun.mail.imap.IMAPStore;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class d0 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final JSONObject f36752a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final JSONObject f36753b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final JSONObject f36754c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public final JSONObject f36755d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public final JSONObject f36756e;

    public d0(@NotNull JSONObject jSONObject, @NotNull JSONObject jSONObject2, @NotNull JSONObject jSONObject3, @NotNull JSONObject jSONObject4, @NotNull JSONObject jSONObject5) {
        this.f36752a = jSONObject;
        this.f36753b = jSONObject2;
        this.f36754c = jSONObject3;
        this.f36755d = jSONObject4;
        this.f36756e = jSONObject5;
    }

    @NotNull
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("device", this.f36752a);
        jSONObject.put(IMAPStore.ID_OS, this.f36753b);
        jSONObject.put("app", this.f36754c);
        jSONObject.put("parameters", this.f36755d);
        jSONObject.put("exception", this.f36756e);
        return jSONObject;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        if (Intrinsics.areEqual(this.f36752a, d0Var.f36752a) && Intrinsics.areEqual(this.f36753b, d0Var.f36753b) && Intrinsics.areEqual(this.f36754c, d0Var.f36754c) && Intrinsics.areEqual(this.f36755d, d0Var.f36755d) && Intrinsics.areEqual(this.f36756e, d0Var.f36756e)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.f36753b.hashCode();
        int hashCode2 = this.f36754c.hashCode();
        int hashCode3 = this.f36755d.hashCode();
        return this.f36756e.hashCode() + ((hashCode3 + ((hashCode2 + ((hashCode + (this.f36752a.hashCode() * 31)) * 31)) * 31)) * 31);
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("ContextsSchema(device=");
        a4.append(this.f36752a);
        a4.append(", os=");
        a4.append(this.f36753b);
        a4.append(", app=");
        a4.append(this.f36754c);
        a4.append(", params=");
        a4.append(this.f36755d);
        a4.append(", exception=");
        a4.append(this.f36756e);
        a4.append(')');
        return a4.toString();
    }

    public d0(@NotNull g0 g0Var, @NotNull v1 v1Var, @NotNull i iVar, @NotNull y1 y1Var, @NotNull e1 e1Var) {
        this(new j0(g0Var).a(), new w1(v1Var).a(), new j(iVar).a(), new a2(y1Var).a(), new d1(e1Var).a());
    }
}
