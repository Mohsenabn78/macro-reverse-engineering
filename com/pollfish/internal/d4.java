package com.pollfish.internal;

import com.arlosoft.macrodroid.action.activities.PopUpActionActivity;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class d4 {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f36761a;

    /* renamed from: b  reason: collision with root package name */
    public final int f36762b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f36763c;

    /* renamed from: d  reason: collision with root package name */
    public final int f36764d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public final String f36765e;

    /* renamed from: f  reason: collision with root package name */
    public final int f36766f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    public final JSONObject f36767g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    public final JSONObject f36768h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public final JSONObject f36769i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public final JSONObject f36770j;

    public d4(boolean z3, int i4, boolean z4, int i5, @NotNull String str, int i6, @NotNull JSONObject jSONObject, @NotNull JSONObject jSONObject2, @Nullable JSONObject jSONObject3, @Nullable JSONObject jSONObject4) {
        this.f36761a = z3;
        this.f36762b = i4;
        this.f36763c = z4;
        this.f36764d = i5;
        this.f36765e = str;
        this.f36766f = i6;
        this.f36767g = jSONObject;
        this.f36768h = jSONObject2;
        this.f36769i = jSONObject3;
        this.f36770j = jSONObject4;
    }

    @NotNull
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("offerwall", this.f36761a);
        jSONObject.put(PopUpActionActivity.EXTRA_POSITION, this.f36762b);
        jSONObject.put("reward_mode", this.f36763c);
        jSONObject.put("platform", this.f36764d);
        jSONObject.put("sdk_device_id_type", this.f36766f);
        q1.a(jSONObject, this.f36767g);
        q1.a(jSONObject, this.f36768h);
        q1.a(jSONObject, this.f36769i);
        q1.a(jSONObject, this.f36770j);
        return jSONObject;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d4)) {
            return false;
        }
        d4 d4Var = (d4) obj;
        if (this.f36761a == d4Var.f36761a && this.f36762b == d4Var.f36762b && this.f36763c == d4Var.f36763c && this.f36764d == d4Var.f36764d && Intrinsics.areEqual(this.f36765e, d4Var.f36765e) && this.f36766f == d4Var.f36766f && Intrinsics.areEqual(this.f36767g, d4Var.f36767g) && Intrinsics.areEqual(this.f36768h, d4Var.f36768h) && Intrinsics.areEqual(this.f36769i, d4Var.f36769i) && Intrinsics.areEqual(this.f36770j, d4Var.f36770j)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    public final int hashCode() {
        int hashCode;
        boolean z3 = this.f36761a;
        int i4 = 1;
        ?? r02 = z3;
        if (z3) {
            r02 = 1;
        }
        int a4 = x1.a(this.f36762b, r02 * 31, 31);
        boolean z4 = this.f36763c;
        if (!z4) {
            i4 = z4 ? 1 : 0;
        }
        int a5 = x1.a(this.f36766f, m4.a(this.f36765e, x1.a(this.f36764d, (a4 + i4) * 31, 31), 31), 31);
        int hashCode2 = (this.f36768h.hashCode() + ((this.f36767g.hashCode() + a5) * 31)) * 31;
        JSONObject jSONObject = this.f36769i;
        int i5 = 0;
        if (jSONObject == null) {
            hashCode = 0;
        } else {
            hashCode = jSONObject.hashCode();
        }
        int i6 = (hashCode2 + hashCode) * 31;
        JSONObject jSONObject2 = this.f36770j;
        if (jSONObject2 != null) {
            i5 = jSONObject2.hashCode();
        }
        return i6 + i5;
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("RegisterRequestParamsSchema(offerwall=");
        a4.append(this.f36761a);
        a4.append(", position=");
        a4.append(this.f36762b);
        a4.append(", rewardMode=");
        a4.append(this.f36763c);
        a4.append(", platform=");
        a4.append(this.f36764d);
        a4.append(", flavour=");
        a4.append(this.f36765e);
        a4.append(", deviceIdType=");
        a4.append(this.f36766f);
        a4.append(", baseParams=");
        a4.append(this.f36767g);
        a4.append(", deviceSpecs=");
        a4.append(this.f36768h);
        a4.append(", rewardInfo=");
        a4.append(this.f36769i);
        a4.append(", userProperties=");
        a4.append(this.f36770j);
        a4.append(')');
        return a4.toString();
    }

    public d4(@NotNull l2 l2Var) {
        this(l2Var.e(), q3.a(l2Var.g()), l2Var.i(), l2Var.f().getValue(), l2Var.d(), l2Var.b().a(), new u(l2Var.a()).a(), new n0(l2Var.c()).a(), l2Var.h() != null ? new v4(l2Var.h()).a() : null, l2Var.j() != null ? new q5(l2Var.j()).a() : null);
    }
}
