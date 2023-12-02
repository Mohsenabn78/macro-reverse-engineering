package com.pollfish.internal;

import com.arlosoft.macrodroid.action.activities.PopUpActionActivity;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class a2 {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f36683a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f36684b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f36685c;

    /* renamed from: d  reason: collision with root package name */
    public final int f36686d;

    /* renamed from: e  reason: collision with root package name */
    public final int f36687e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f36688f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    public final String f36689g;

    public a2(boolean z3, boolean z4, boolean z5, int i4, int i5, boolean z6, @NotNull String str) {
        this.f36683a = z3;
        this.f36684b = z4;
        this.f36685c = z5;
        this.f36686d = i4;
        this.f36687e = i5;
        this.f36688f = z6;
        this.f36689g = str;
    }

    @NotNull
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("release", this.f36683a);
        jSONObject.put("reward", this.f36684b);
        jSONObject.put("offerwall", this.f36685c);
        jSONObject.put(PopUpActionActivity.EXTRA_POSITION, this.f36686d);
        jSONObject.put("padding", this.f36687e);
        jSONObject.put("container", this.f36688f);
        jSONObject.put("platform", this.f36689g);
        return jSONObject;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a2)) {
            return false;
        }
        a2 a2Var = (a2) obj;
        if (this.f36683a == a2Var.f36683a && this.f36684b == a2Var.f36684b && this.f36685c == a2Var.f36685c && this.f36686d == a2Var.f36686d && this.f36687e == a2Var.f36687e && this.f36688f == a2Var.f36688f && Intrinsics.areEqual(this.f36689g, a2Var.f36689g)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r3v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean] */
    public final int hashCode() {
        boolean z3 = this.f36683a;
        int i4 = 1;
        ?? r02 = z3;
        if (z3) {
            r02 = 1;
        }
        int i5 = r02 * 31;
        ?? r32 = this.f36684b;
        int i6 = r32;
        if (r32 != 0) {
            i6 = 1;
        }
        int i7 = (i5 + i6) * 31;
        ?? r33 = this.f36685c;
        int i8 = r33;
        if (r33 != 0) {
            i8 = 1;
        }
        int a4 = x1.a(this.f36687e, x1.a(this.f36686d, (i7 + i8) * 31, 31), 31);
        boolean z4 = this.f36688f;
        if (!z4) {
            i4 = z4 ? 1 : 0;
        }
        return this.f36689g.hashCode() + ((a4 + i4) * 31);
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("ParamsSchema(releaseMode=");
        a4.append(this.f36683a);
        a4.append(", rewardMode=");
        a4.append(this.f36684b);
        a4.append(", offerwall=");
        a4.append(this.f36685c);
        a4.append(", position=");
        a4.append(this.f36686d);
        a4.append(", padding=");
        a4.append(this.f36687e);
        a4.append(", container=");
        a4.append(this.f36688f);
        a4.append(", platform=");
        return g5.a(a4, this.f36689g, ')');
    }

    public a2(@NotNull y1 y1Var) {
        this(y1Var.f(), y1Var.g(), y1Var.b(), y1Var.e().getValue(), y1Var.c(), y1Var.a(), y1Var.d().toString());
    }
}
