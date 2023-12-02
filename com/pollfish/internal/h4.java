package com.pollfish.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.sun.mail.imap.IMAPStore;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class h4 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final String f36897a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final String f36898b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final String f36899c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public final String f36900d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public final String f36901e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public final String f36902f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    public final String f36903g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    public final JSONObject f36904h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public final JSONObject f36905i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    public final JSONObject f36906j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    public final JSONObject f36907k;

    public h4(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull JSONObject jSONObject, @NotNull JSONObject jSONObject2, @NotNull JSONObject jSONObject3, @NotNull JSONObject jSONObject4) {
        this.f36897a = str;
        this.f36898b = str2;
        this.f36899c = str3;
        this.f36900d = str4;
        this.f36901e = str5;
        this.f36902f = str6;
        this.f36903g = str7;
        this.f36904h = jSONObject;
        this.f36905i = jSONObject2;
        this.f36906j = jSONObject3;
        this.f36907k = jSONObject4;
    }

    @NotNull
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("culprit", this.f36897a);
        jSONObject.put("message", this.f36898b);
        jSONObject.put(IMAPStore.ID_ENVIRONMENT, this.f36899c);
        jSONObject.put(FirebaseAnalytics.Param.LEVEL, this.f36900d);
        jSONObject.put("release", this.f36901e);
        jSONObject.put("dist", this.f36902f);
        jSONObject.put("timestamp", this.f36903g);
        jSONObject.put("contexts", this.f36904h);
        jSONObject.put("tags", this.f36905i);
        jSONObject.put("user", this.f36906j);
        jSONObject.put("exception", this.f36907k);
        return jSONObject;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h4)) {
            return false;
        }
        h4 h4Var = (h4) obj;
        if (Intrinsics.areEqual(this.f36897a, h4Var.f36897a) && Intrinsics.areEqual(this.f36898b, h4Var.f36898b) && Intrinsics.areEqual(this.f36899c, h4Var.f36899c) && Intrinsics.areEqual(this.f36900d, h4Var.f36900d) && Intrinsics.areEqual(this.f36901e, h4Var.f36901e) && Intrinsics.areEqual(this.f36902f, h4Var.f36902f) && Intrinsics.areEqual(this.f36903g, h4Var.f36903g) && Intrinsics.areEqual(this.f36904h, h4Var.f36904h) && Intrinsics.areEqual(this.f36905i, h4Var.f36905i) && Intrinsics.areEqual(this.f36906j, h4Var.f36906j) && Intrinsics.areEqual(this.f36907k, h4Var.f36907k)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int a4 = m4.a(this.f36903g, m4.a(this.f36902f, m4.a(this.f36901e, m4.a(this.f36900d, m4.a(this.f36899c, m4.a(this.f36898b, this.f36897a.hashCode() * 31, 31), 31), 31), 31), 31), 31);
        int hashCode = this.f36905i.hashCode();
        int hashCode2 = this.f36906j.hashCode();
        return this.f36907k.hashCode() + ((hashCode2 + ((hashCode + ((this.f36904h.hashCode() + a4) * 31)) * 31)) * 31);
    }

    @NotNull
    public final String toString() {
        return "ReportSchema(culprit=" + this.f36897a + ", message=" + this.f36898b + ", environment=" + this.f36899c + ", level=" + this.f36900d + ", release=" + this.f36901e + ", dist=" + this.f36902f + ", timestamp=" + this.f36903g + ", contexts=" + this.f36904h + ", tags=" + this.f36905i + ", user=" + this.f36906j + ", exception=" + this.f36907k + ')';
    }

    public h4(@NotNull f4 f4Var) {
        this(f4Var.b(), f4Var.i(), u0.a(f4Var.e()), f4Var.h().a(), f4Var.l(), f4Var.d(), f4Var.n(), new d0(f4Var.c(), f4Var.j(), f4Var.a(), f4Var.k(), f4Var.f()).a(), new k5(f4Var.m()).a(), new r5(f4Var.o()).a(), new a1(f4Var.g()).a());
    }
}
