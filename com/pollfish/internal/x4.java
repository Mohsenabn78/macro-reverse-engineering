package com.pollfish.internal;

import com.pollfish.builder.Platform;
import com.pollfish.builder.Position;
import com.pollfish.builder.RewardInfo;
import com.pollfish.builder.UserProperties;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class x4 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final String f37310a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f37311b;

    /* renamed from: c  reason: collision with root package name */
    public final int f37312c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f37313d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f37314e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final Integer f37315f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public final String f37316g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final String f37317h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public final String f37318i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    public final int f37319j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    public final Position f37320k;

    /* renamed from: l  reason: collision with root package name */
    public final int f37321l;

    /* renamed from: m  reason: collision with root package name */
    public final boolean f37322m;
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    public final Platform f37323n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    public final RewardInfo f37324o;
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    public final UserProperties f37325p;
    @NotNull

    /* renamed from: q  reason: collision with root package name */
    public final String f37326q;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    public final String f37327r;

    public x4(@NotNull String str, boolean z3, int i4, boolean z4, boolean z5, @Nullable Integer num, @Nullable String str2, @Nullable String str3, @Nullable String str4, @NotNull int i5, @NotNull Position position, int i6, boolean z6, @NotNull Platform platform, @Nullable RewardInfo rewardInfo, @Nullable UserProperties userProperties, @Nullable String str5) {
        this.f37310a = str;
        this.f37311b = z3;
        this.f37312c = i4;
        this.f37313d = z4;
        this.f37314e = z5;
        this.f37315f = num;
        this.f37316g = str2;
        this.f37317h = str3;
        this.f37318i = str4;
        this.f37319j = i5;
        this.f37320k = position;
        this.f37321l = i6;
        this.f37322m = z6;
        this.f37323n = platform;
        this.f37324o = rewardInfo;
        this.f37325p = userProperties;
        this.f37326q = "https://wss.pollfish.com";
        this.f37327r = str5;
    }

    @NotNull
    public final String a() {
        return this.f37310a;
    }

    @Nullable
    public final String b() {
        return this.f37317h;
    }

    @NotNull
    public final String c() {
        return this.f37326q;
    }

    public final int d() {
        return this.f37321l;
    }

    @NotNull
    public final Position e() {
        return this.f37320k;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x4)) {
            return false;
        }
        x4 x4Var = (x4) obj;
        if (Intrinsics.areEqual(this.f37310a, x4Var.f37310a) && this.f37311b == x4Var.f37311b && this.f37312c == x4Var.f37312c && this.f37313d == x4Var.f37313d && this.f37314e == x4Var.f37314e && Intrinsics.areEqual(this.f37315f, x4Var.f37315f) && Intrinsics.areEqual(this.f37316g, x4Var.f37316g) && Intrinsics.areEqual(this.f37317h, x4Var.f37317h) && Intrinsics.areEqual(this.f37318i, x4Var.f37318i) && this.f37319j == x4Var.f37319j && this.f37320k == x4Var.f37320k && this.f37321l == x4Var.f37321l && this.f37322m == x4Var.f37322m && this.f37323n == x4Var.f37323n && Intrinsics.areEqual(this.f37324o, x4Var.f37324o) && Intrinsics.areEqual(this.f37325p, x4Var.f37325p) && Intrinsics.areEqual(this.f37326q, x4Var.f37326q) && Intrinsics.areEqual(this.f37327r, x4Var.f37327r)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final int f() {
        return this.f37319j;
    }

    public final boolean g() {
        return this.f37314e;
    }

    @NotNull
    public final Platform h() {
        return this.f37323n;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7 = this.f37310a.hashCode() * 31;
        boolean z3 = this.f37311b;
        int i4 = 1;
        int i5 = z3;
        if (z3 != 0) {
            i5 = 1;
        }
        int a4 = x1.a(this.f37312c, (hashCode7 + i5) * 31, 31);
        boolean z4 = this.f37313d;
        int i6 = z4;
        if (z4 != 0) {
            i6 = 1;
        }
        int i7 = (a4 + i6) * 31;
        boolean z5 = this.f37314e;
        int i8 = z5;
        if (z5 != 0) {
            i8 = 1;
        }
        int i9 = (i7 + i8) * 31;
        Integer num = this.f37315f;
        int i10 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int i11 = (i9 + hashCode) * 31;
        String str = this.f37316g;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        String str2 = this.f37317h;
        if (str2 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str2.hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        String str3 = this.f37318i;
        if (str3 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str3.hashCode();
        }
        int a5 = v0.a(this.f37319j);
        int hashCode8 = this.f37320k.hashCode();
        int a6 = x1.a(this.f37321l, (hashCode8 + ((a5 + ((i13 + hashCode4) * 31)) * 31)) * 31, 31);
        boolean z6 = this.f37322m;
        if (!z6) {
            i4 = z6 ? 1 : 0;
        }
        int hashCode9 = (this.f37323n.hashCode() + ((a6 + i4) * 31)) * 31;
        RewardInfo rewardInfo = this.f37324o;
        if (rewardInfo == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = rewardInfo.hashCode();
        }
        int i14 = (hashCode9 + hashCode5) * 31;
        UserProperties userProperties = this.f37325p;
        if (userProperties == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = userProperties.hashCode();
        }
        int a7 = m4.a(this.f37326q, (i14 + hashCode6) * 31, 31);
        String str4 = this.f37327r;
        if (str4 != null) {
            i10 = str4.hashCode();
        }
        return a7 + i10;
    }

    public final boolean i() {
        return this.f37311b;
    }

    @Nullable
    public final String j() {
        return this.f37316g;
    }

    @Nullable
    public final RewardInfo k() {
        return this.f37324o;
    }

    public final boolean l() {
        return this.f37313d;
    }

    @Nullable
    public final String m() {
        return this.f37327r;
    }

    public final int n() {
        return this.f37312c;
    }

    @Nullable
    public final Integer o() {
        return this.f37315f;
    }

    @Nullable
    public final String p() {
        return this.f37318i;
    }

    @Nullable
    public final UserProperties q() {
        return this.f37325p;
    }

    public final boolean r() {
        return this.f37322m;
    }

    @NotNull
    public final String toString() {
        return "SdkConfiguration(apiKey=" + this.f37310a + ", releaseMode=" + this.f37311b + ", surveyFormat=" + this.f37312c + ", rewardedMode=" + this.f37313d + ", offerwallMode=" + this.f37314e + ", surveyId=" + this.f37315f + ", requestUUID=" + this.f37316g + ", clickId=" + this.f37317h + ", userId=" + this.f37318i + ", indicatorSide=" + q3.b(this.f37319j) + ", indicatorPosition=" + this.f37320k + ", indicatorPadding=" + this.f37321l + ", isOverlay=" + this.f37322m + ", platform=" + this.f37323n + ", rewardInfo=" + this.f37324o + ", userProperties=" + this.f37325p + ", host=" + this.f37326q + ", signature=" + this.f37327r + ')';
    }

    public /* synthetic */ x4(String str, boolean z3, int i4, boolean z4, boolean z5, String str2, String str3, String str4, int i5, Position position, int i6, boolean z6, Platform platform, RewardInfo rewardInfo, UserProperties userProperties, String str5) {
        this(str, z3, i4, z4, z5, null, str2, str3, str4, i5, position, i6, z6, platform, rewardInfo, userProperties, str5);
    }
}
