package com.pollfish.internal;

import com.pollfish.builder.RewardInfo;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class v4 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final String f37275a;

    /* renamed from: b  reason: collision with root package name */
    public final double f37276b;

    public v4(@NotNull String str, double d4) {
        this.f37275a = str;
        this.f37276b = d4;
    }

    @NotNull
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("reward_name", this.f37275a);
        jSONObject.put("reward_conversion", String.valueOf(this.f37276b));
        return jSONObject;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v4)) {
            return false;
        }
        v4 v4Var = (v4) obj;
        if (Intrinsics.areEqual(this.f37275a, v4Var.f37275a) && Double.compare(this.f37276b, v4Var.f37276b) == 0) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return androidx.compose.animation.core.b.a(this.f37276b) + (this.f37275a.hashCode() * 31);
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("RewardInfoSchema(rewardName=");
        a4.append(this.f37275a);
        a4.append(", rewardConversion=");
        a4.append(this.f37276b);
        a4.append(')');
        return a4.toString();
    }

    public v4(@NotNull RewardInfo rewardInfo) {
        this(rewardInfo.getRewardName(), rewardInfo.getRewardConversion());
    }
}
