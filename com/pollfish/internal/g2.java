package com.pollfish.internal;

import com.pollfish.callback.SurveyInfo;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class g2 {
    @Nullable
    public final String A;
    @Nullable
    public final String B;
    @Nullable
    public final Integer C;
    @NotNull
    public final String D;
    @Nullable
    public final Integer E;
    @Nullable
    public final k F;
    @NotNull
    public final List<k> G;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final Boolean f36850a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final int f36851b;

    /* renamed from: c  reason: collision with root package name */
    public final int f36852c;

    /* renamed from: d  reason: collision with root package name */
    public final int f36853d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public final String f36854e;

    /* renamed from: f  reason: collision with root package name */
    public final int f36855f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    public final String f36856g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final k f36857h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public final String f36858i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f36859j;

    /* renamed from: k  reason: collision with root package name */
    public final int f36860k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f36861l;
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    public final String f36862m;

    /* renamed from: n  reason: collision with root package name */
    public final boolean f36863n;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f36864o;

    /* renamed from: p  reason: collision with root package name */
    public final boolean f36865p;

    /* renamed from: q  reason: collision with root package name */
    public final boolean f36866q;
    @NotNull

    /* renamed from: r  reason: collision with root package name */
    public final String f36867r;
    @NotNull

    /* renamed from: s  reason: collision with root package name */
    public final String f36868s;
    @NotNull

    /* renamed from: t  reason: collision with root package name */
    public final String f36869t;
    @NotNull

    /* renamed from: u  reason: collision with root package name */
    public final String f36870u;
    @NotNull

    /* renamed from: v  reason: collision with root package name */
    public final String f36871v;
    @NotNull

    /* renamed from: w  reason: collision with root package name */
    public final String f36872w;
    @NotNull

    /* renamed from: x  reason: collision with root package name */
    public final String f36873x;
    @Nullable

    /* renamed from: y  reason: collision with root package name */
    public final Integer f36874y;
    @Nullable

    /* renamed from: z  reason: collision with root package name */
    public final Integer f36875z;

    /* JADX WARN: Incorrect types in method signature: (Ljava/lang/Boolean;Ljava/lang/Object;IILjava/lang/String;ILjava/lang/String;Lcom/pollfish/internal/k;Ljava/lang/String;ZIZLjava/lang/String;ZZZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Lcom/pollfish/internal/k;Ljava/util/List<Lcom/pollfish/internal/k;>;)V */
    public g2(@Nullable Boolean bool, @NotNull int i4, int i5, int i6, @NotNull String str, int i7, @NotNull String str2, @Nullable k kVar, @NotNull String str3, boolean z3, int i8, boolean z4, @NotNull String str4, boolean z5, boolean z6, boolean z7, boolean z8, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8, @NotNull String str9, @NotNull String str10, @NotNull String str11, @Nullable Integer num, @Nullable Integer num2, @Nullable String str12, @Nullable String str13, @Nullable Integer num3, @NotNull String str14, @Nullable Integer num4, @Nullable k kVar2, @NotNull List list) {
        this.f36850a = bool;
        this.f36851b = i4;
        this.f36852c = i5;
        this.f36853d = i6;
        this.f36854e = str;
        this.f36855f = i7;
        this.f36856g = str2;
        this.f36857h = kVar;
        this.f36858i = str3;
        this.f36859j = z3;
        this.f36860k = i8;
        this.f36861l = z4;
        this.f36862m = str4;
        this.f36863n = z5;
        this.f36864o = z6;
        this.f36865p = z7;
        this.f36866q = z8;
        this.f36867r = str5;
        this.f36868s = str6;
        this.f36869t = str7;
        this.f36870u = str8;
        this.f36871v = str9;
        this.f36872w = str10;
        this.f36873x = str11;
        this.f36874y = num;
        this.f36875z = num2;
        this.A = str12;
        this.B = str13;
        this.C = num3;
        this.D = str14;
        this.E = num4;
        this.F = kVar2;
        this.G = list;
    }

    @NotNull
    public final List<k> a() {
        return this.G;
    }

    @NotNull
    public final String b() {
        return this.f36858i;
    }

    public final boolean c() {
        return this.f36864o;
    }

    public final boolean d() {
        return this.f36863n;
    }

    @NotNull
    public final String e() {
        return this.f36854e;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g2)) {
            return false;
        }
        g2 g2Var = (g2) obj;
        if (Intrinsics.areEqual(this.f36850a, g2Var.f36850a) && this.f36851b == g2Var.f36851b && this.f36852c == g2Var.f36852c && this.f36853d == g2Var.f36853d && Intrinsics.areEqual(this.f36854e, g2Var.f36854e) && this.f36855f == g2Var.f36855f && Intrinsics.areEqual(this.f36856g, g2Var.f36856g) && Intrinsics.areEqual(this.f36857h, g2Var.f36857h) && Intrinsics.areEqual(this.f36858i, g2Var.f36858i) && this.f36859j == g2Var.f36859j && this.f36860k == g2Var.f36860k && this.f36861l == g2Var.f36861l && Intrinsics.areEqual(this.f36862m, g2Var.f36862m) && this.f36863n == g2Var.f36863n && this.f36864o == g2Var.f36864o && this.f36865p == g2Var.f36865p && this.f36866q == g2Var.f36866q && Intrinsics.areEqual(this.f36867r, g2Var.f36867r) && Intrinsics.areEqual(this.f36868s, g2Var.f36868s) && Intrinsics.areEqual(this.f36869t, g2Var.f36869t) && Intrinsics.areEqual(this.f36870u, g2Var.f36870u) && Intrinsics.areEqual(this.f36871v, g2Var.f36871v) && Intrinsics.areEqual(this.f36872w, g2Var.f36872w) && Intrinsics.areEqual(this.f36873x, g2Var.f36873x) && Intrinsics.areEqual(this.f36874y, g2Var.f36874y) && Intrinsics.areEqual(this.f36875z, g2Var.f36875z) && Intrinsics.areEqual(this.A, g2Var.A) && Intrinsics.areEqual(this.B, g2Var.B) && Intrinsics.areEqual(this.C, g2Var.C) && Intrinsics.areEqual(this.D, g2Var.D) && Intrinsics.areEqual(this.E, g2Var.E) && Intrinsics.areEqual(this.F, g2Var.F) && Intrinsics.areEqual(this.G, g2Var.G)) {
            return true;
        }
        return false;
    }

    public final int f() {
        return this.f36853d;
    }

    @Nullable
    public final k g() {
        return this.f36857h;
    }

    @NotNull
    public final String h() {
        return this.f36870u;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        Boolean bool = this.f36850a;
        int i4 = 0;
        if (bool == null) {
            hashCode = 0;
        } else {
            hashCode = bool.hashCode();
        }
        int a4 = v0.a(this.f36851b);
        int a5 = m4.a(this.f36856g, x1.a(this.f36855f, m4.a(this.f36854e, x1.a(this.f36853d, x1.a(this.f36852c, (a4 + (hashCode * 31)) * 31, 31), 31), 31), 31), 31);
        k kVar = this.f36857h;
        if (kVar == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = kVar.hashCode();
        }
        int a6 = m4.a(this.f36858i, (a5 + hashCode2) * 31, 31);
        boolean z3 = this.f36859j;
        int i5 = 1;
        int i6 = z3;
        if (z3 != 0) {
            i6 = 1;
        }
        int a7 = x1.a(this.f36860k, (a6 + i6) * 31, 31);
        boolean z4 = this.f36861l;
        int i7 = z4;
        if (z4 != 0) {
            i7 = 1;
        }
        int a8 = m4.a(this.f36862m, (a7 + i7) * 31, 31);
        boolean z5 = this.f36863n;
        int i8 = z5;
        if (z5 != 0) {
            i8 = 1;
        }
        int i9 = (a8 + i8) * 31;
        boolean z6 = this.f36864o;
        int i10 = z6;
        if (z6 != 0) {
            i10 = 1;
        }
        int i11 = (i9 + i10) * 31;
        boolean z7 = this.f36865p;
        int i12 = z7;
        if (z7 != 0) {
            i12 = 1;
        }
        int i13 = (i11 + i12) * 31;
        boolean z8 = this.f36866q;
        if (!z8) {
            i5 = z8 ? 1 : 0;
        }
        int a9 = m4.a(this.f36873x, m4.a(this.f36872w, m4.a(this.f36871v, m4.a(this.f36870u, m4.a(this.f36869t, m4.a(this.f36868s, m4.a(this.f36867r, (i13 + i5) * 31, 31), 31), 31), 31), 31), 31), 31);
        Integer num = this.f36874y;
        if (num == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = num.hashCode();
        }
        int i14 = (a9 + hashCode3) * 31;
        Integer num2 = this.f36875z;
        if (num2 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = num2.hashCode();
        }
        int i15 = (i14 + hashCode4) * 31;
        String str = this.A;
        if (str == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str.hashCode();
        }
        int i16 = (i15 + hashCode5) * 31;
        String str2 = this.B;
        if (str2 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = str2.hashCode();
        }
        int i17 = (i16 + hashCode6) * 31;
        Integer num3 = this.C;
        if (num3 == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = num3.hashCode();
        }
        int a10 = m4.a(this.D, (i17 + hashCode7) * 31, 31);
        Integer num4 = this.E;
        if (num4 == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = num4.hashCode();
        }
        int i18 = (a10 + hashCode8) * 31;
        k kVar2 = this.F;
        if (kVar2 != null) {
            i4 = kVar2.hashCode();
        }
        return this.G.hashCode() + ((i18 + i4) * 31);
    }

    @NotNull
    public final String i() {
        return this.f36871v;
    }

    @NotNull
    public final String j() {
        return this.f36872w;
    }

    @Nullable
    public final k k() {
        return this.F;
    }

    @NotNull
    public final String l() {
        return this.f36867r;
    }

    @NotNull
    public final String m() {
        return this.f36873x;
    }

    @NotNull
    public final String n() {
        return this.f36868s;
    }

    @NotNull
    public final String o() {
        return this.f36869t;
    }

    @NotNull
    public final String p() {
        return this.f36862m;
    }

    public final int q() {
        return this.f36852c;
    }

    @NotNull
    public final SurveyInfo r() {
        return new SurveyInfo(Integer.valueOf(this.f36860k), this.f36875z, this.f36874y, this.A, this.B, this.C, this.E);
    }

    public final boolean s() {
        if (this.f36851b == 2) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String toString() {
        return "PollfishConfiguration(containsSurvey=" + this.f36850a + ", intrusion=" + p1.b(this.f36851b) + ", widthPercentage=" + this.f36852c + ", heightPercentage=" + this.f36853d + ", content=" + this.f36854e + ", surveyId=" + this.f36855f + ", mobileData=" + this.f36856g + ", indicatorAsset=" + this.f36857h + ", backgroundColor=" + this.f36858i + ", shortSurvey=" + this.f36859j + ", surveyPrice=" + this.f36860k + ", videoEnabled=" + this.f36861l + ", videoColor=" + this.f36862m + ", closeOnTouch=" + this.f36863n + ", clearCache=" + this.f36864o + ", hasAcceptedTerms=" + this.f36865p + ", hasEmail=" + this.f36866q + ", mediationTopViewBackgroundColor=" + this.f36867r + ", mediationTopViewSeparatorBackgroundColor=" + this.f36868s + ", mediationTopViewTextColor=" + this.f36869t + ", mediationBottomViewBackgroundColor=" + this.f36870u + ", mediationBottomViewSeparatorBackgroundColor=" + this.f36871v + ", mediationBottomViewTextColor=" + this.f36872w + ", mediationTopViewProgressBackgroundColor=" + this.f36873x + ", surveyLengthOfInterview=" + this.f36874y + ", surveyIncidenceRate=" + this.f36875z + ", surveyClass=" + this.A + ", rewardName=" + this.B + ", rewardValue=" + this.C + ", errorHtmlContent=" + this.D + ", remainingCompletes=" + this.E + ", mediationTopLogoAsset=" + this.F + ", assets=" + this.G + ')';
    }
}
