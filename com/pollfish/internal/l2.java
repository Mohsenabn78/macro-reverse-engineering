package com.pollfish.internal;

import com.pollfish.builder.Platform;
import com.pollfish.builder.RewardInfo;
import com.pollfish.builder.UserProperties;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class l2 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final String f36997a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final k0 f36998b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final t f36999c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f37000d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f37001e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public final Platform f37002f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    public final String f37003g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    public final h0 f37004h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public final int f37005i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public final RewardInfo f37006j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    public final UserProperties f37007k;

    public l2(@NotNull String str, @NotNull k0 k0Var, @NotNull t tVar, boolean z3, boolean z4, @NotNull Platform platform, @NotNull String str2, @NotNull h0 h0Var, @NotNull int i4, @Nullable RewardInfo rewardInfo, @Nullable UserProperties userProperties) {
        this.f36997a = str;
        this.f36998b = k0Var;
        this.f36999c = tVar;
        this.f37000d = z3;
        this.f37001e = z4;
        this.f37002f = platform;
        this.f37003g = str2;
        this.f37004h = h0Var;
        this.f37005i = i4;
        this.f37006j = rewardInfo;
        this.f37007k = userProperties;
    }

    @NotNull
    public final t a() {
        return this.f36999c;
    }

    @NotNull
    public final h0 b() {
        return this.f37004h;
    }

    @NotNull
    public final k0 c() {
        return this.f36998b;
    }

    @NotNull
    public final String d() {
        return this.f37003g;
    }

    public final boolean e() {
        return this.f37000d;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l2)) {
            return false;
        }
        l2 l2Var = (l2) obj;
        if (Intrinsics.areEqual(this.f36997a, l2Var.f36997a) && Intrinsics.areEqual(this.f36998b, l2Var.f36998b) && Intrinsics.areEqual(this.f36999c, l2Var.f36999c) && this.f37000d == l2Var.f37000d && this.f37001e == l2Var.f37001e && this.f37002f == l2Var.f37002f && Intrinsics.areEqual(this.f37003g, l2Var.f37003g) && this.f37004h == l2Var.f37004h && this.f37005i == l2Var.f37005i && Intrinsics.areEqual(this.f37006j, l2Var.f37006j) && Intrinsics.areEqual(this.f37007k, l2Var.f37007k)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final Platform f() {
        return this.f37002f;
    }

    @NotNull
    public final int g() {
        return this.f37005i;
    }

    @Nullable
    public final RewardInfo h() {
        return this.f37006j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode;
        int hashCode2 = this.f36998b.hashCode();
        int hashCode3 = (this.f36999c.hashCode() + ((hashCode2 + (this.f36997a.hashCode() * 31)) * 31)) * 31;
        boolean z3 = this.f37000d;
        int i4 = 1;
        int i5 = z3;
        if (z3 != 0) {
            i5 = 1;
        }
        int i6 = (hashCode3 + i5) * 31;
        boolean z4 = this.f37001e;
        if (!z4) {
            i4 = z4 ? 1 : 0;
        }
        int hashCode4 = this.f37002f.hashCode();
        int a4 = m4.a(this.f37003g, (hashCode4 + ((i6 + i4) * 31)) * 31, 31);
        int a5 = (v0.a(this.f37005i) + ((this.f37004h.hashCode() + a4) * 31)) * 31;
        RewardInfo rewardInfo = this.f37006j;
        int i7 = 0;
        if (rewardInfo == null) {
            hashCode = 0;
        } else {
            hashCode = rewardInfo.hashCode();
        }
        int i8 = (a5 + hashCode) * 31;
        UserProperties userProperties = this.f37007k;
        if (userProperties != null) {
            i7 = userProperties.hashCode();
        }
        return i8 + i7;
    }

    public final boolean i() {
        return this.f37001e;
    }

    @Nullable
    public final UserProperties j() {
        return this.f37007k;
    }

    @NotNull
    public final String toString() {
        return "PollfishConfigurationRequestParams(apiKey=" + this.f36997a + ", deviceSpecs=" + this.f36998b + ", baseParams=" + this.f36999c + ", offerwall=" + this.f37000d + ", rewardMode=" + this.f37001e + ", platform=" + this.f37002f + ", flavour=" + this.f37003g + ", deviceIdType=" + this.f37004h + ", position=" + q3.b(this.f37005i) + ", rewardInfo=" + this.f37006j + ", userProperties=" + this.f37007k + ')';
    }
}
