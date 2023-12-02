package com.pollfish.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class j {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final String f36921a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final String f36922b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final String f36923c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public final String f36924d;

    public j(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        this.f36921a = str;
        this.f36922b = str2;
        this.f36923c = str3;
        this.f36924d = str4;
    }

    @NotNull
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("app_name", this.f36921a);
        jSONObject.put("app_identifier", this.f36922b);
        jSONObject.put("app_version", this.f36923c);
        jSONObject.put("app_build", this.f36924d);
        return jSONObject;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (Intrinsics.areEqual(this.f36921a, jVar.f36921a) && Intrinsics.areEqual(this.f36922b, jVar.f36922b) && Intrinsics.areEqual(this.f36923c, jVar.f36923c) && Intrinsics.areEqual(this.f36924d, jVar.f36924d)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f36924d.hashCode() + m4.a(this.f36923c, m4.a(this.f36922b, this.f36921a.hashCode() * 31, 31), 31);
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("AppSchema(name=");
        a4.append(this.f36921a);
        a4.append(", identifier=");
        a4.append(this.f36922b);
        a4.append(", version=");
        a4.append(this.f36923c);
        a4.append(", build=");
        return g5.a(a4, this.f36924d, ')');
    }

    public j(@NotNull i iVar) {
        this(iVar.c(), iVar.b(), iVar.d(), iVar.a());
    }
}
