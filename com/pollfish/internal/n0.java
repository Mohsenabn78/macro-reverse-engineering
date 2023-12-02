package com.pollfish.internal;

import com.sun.mail.imap.IMAPStore;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class n0 {
    @NotNull
    public final List<String> A;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final String f37093a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final String f37094b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final String f37095c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final String f37096d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final Boolean f37097e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public Boolean f37098f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public String f37099g;

    /* renamed from: h  reason: collision with root package name */
    public int f37100h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public String f37101i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public Integer f37102j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    public Integer f37103k;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    public String f37104l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    public String f37105m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    public String f37106n;
    @Nullable

    /* renamed from: o  reason: collision with root package name */
    public String f37107o;
    @NotNull

    /* renamed from: p  reason: collision with root package name */
    public String f37108p;
    @Nullable

    /* renamed from: q  reason: collision with root package name */
    public Boolean f37109q;
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    public Boolean f37110r;
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public Boolean f37111s;
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public Boolean f37112t;

    /* renamed from: u  reason: collision with root package name */
    public boolean f37113u;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public final String f37114v;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    public final Integer f37115w;
    @Nullable

    /* renamed from: x  reason: collision with root package name */
    public final String f37116x;
    @Nullable

    /* renamed from: y  reason: collision with root package name */
    public final String f37117y;

    /* renamed from: z  reason: collision with root package name */
    public final boolean f37118z;

    public n0(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str5, int i4, @NotNull String str6, @Nullable Integer num, @Nullable Integer num2, @NotNull String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @NotNull String str11, @Nullable Boolean bool3, @Nullable Boolean bool4, @Nullable Boolean bool5, @Nullable Boolean bool6, boolean z3, @Nullable String str12, @Nullable Integer num3, @Nullable String str13, @Nullable String str14, boolean z4, @NotNull List<String> list) {
        this.f37093a = str;
        this.f37094b = str2;
        this.f37095c = str3;
        this.f37096d = str4;
        this.f37097e = bool;
        this.f37098f = bool2;
        this.f37099g = str5;
        this.f37100h = i4;
        this.f37101i = str6;
        this.f37102j = num;
        this.f37103k = num2;
        this.f37104l = str7;
        this.f37105m = str8;
        this.f37106n = str9;
        this.f37107o = str10;
        this.f37108p = str11;
        this.f37109q = bool3;
        this.f37110r = bool4;
        this.f37111s = bool5;
        this.f37112t = bool6;
        this.f37113u = z3;
        this.f37114v = str12;
        this.f37115w = num3;
        this.f37116x = str13;
        this.f37117y = str14;
        this.f37118z = z4;
        this.A = list;
    }

    @NotNull
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("device_descr", this.f37093a);
        q1.a(jSONObject, "provider", this.f37094b);
        q1.a(jSONObject, "provider_mcc", this.f37095c);
        q1.a(jSONObject, "provider_mnc", this.f37096d);
        q1.a(jSONObject, "nfc_enabled", this.f37097e);
        q1.a(jSONObject, "nfc_exists", this.f37098f);
        q1.a(jSONObject, "app_id", this.f37099g);
        jSONObject.put(IMAPStore.ID_OS, this.f37100h);
        jSONObject.put("os_ver", this.f37101i);
        q1.a(jSONObject, "scr_h", this.f37102j);
        q1.a(jSONObject, "scr_w", this.f37103k);
        jSONObject.put("manufacturer", this.f37104l);
        q1.a(jSONObject, "app_version", this.f37105m);
        q1.a(jSONObject, "con_type", this.f37106n);
        q1.a(jSONObject, "locale", this.f37107o);
        jSONObject.put("scr_size", this.f37108p);
        q1.a(jSONObject, "is_roaming", this.f37109q);
        q1.a(jSONObject, "accessibility_enabled", this.f37110r);
        q1.a(jSONObject, "developer_enabled", this.f37111s);
        q1.a(jSONObject, "install_non_market_apps", this.f37112t);
        jSONObject.put("hardware_accelerated", this.f37113u);
        q1.a(jSONObject, "usr_agent", this.f37114v);
        q1.a(jSONObject, "target", this.f37115w);
        q1.a(jSONObject, "board", this.f37116x);
        q1.a(jSONObject, "brand", this.f37117y);
        jSONObject.put("video", this.f37118z);
        JSONArray jSONArray = new JSONArray();
        for (String str : this.A) {
            jSONArray.put(str);
        }
        jSONObject.put("locale_list", jSONArray);
        return jSONObject;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n0)) {
            return false;
        }
        n0 n0Var = (n0) obj;
        if (Intrinsics.areEqual(this.f37093a, n0Var.f37093a) && Intrinsics.areEqual(this.f37094b, n0Var.f37094b) && Intrinsics.areEqual(this.f37095c, n0Var.f37095c) && Intrinsics.areEqual(this.f37096d, n0Var.f37096d) && Intrinsics.areEqual(this.f37097e, n0Var.f37097e) && Intrinsics.areEqual(this.f37098f, n0Var.f37098f) && Intrinsics.areEqual(this.f37099g, n0Var.f37099g) && this.f37100h == n0Var.f37100h && Intrinsics.areEqual(this.f37101i, n0Var.f37101i) && Intrinsics.areEqual(this.f37102j, n0Var.f37102j) && Intrinsics.areEqual(this.f37103k, n0Var.f37103k) && Intrinsics.areEqual(this.f37104l, n0Var.f37104l) && Intrinsics.areEqual(this.f37105m, n0Var.f37105m) && Intrinsics.areEqual(this.f37106n, n0Var.f37106n) && Intrinsics.areEqual(this.f37107o, n0Var.f37107o) && Intrinsics.areEqual(this.f37108p, n0Var.f37108p) && Intrinsics.areEqual(this.f37109q, n0Var.f37109q) && Intrinsics.areEqual(this.f37110r, n0Var.f37110r) && Intrinsics.areEqual(this.f37111s, n0Var.f37111s) && Intrinsics.areEqual(this.f37112t, n0Var.f37112t) && this.f37113u == n0Var.f37113u && Intrinsics.areEqual(this.f37114v, n0Var.f37114v) && Intrinsics.areEqual(this.f37115w, n0Var.f37115w) && Intrinsics.areEqual(this.f37116x, n0Var.f37116x) && Intrinsics.areEqual(this.f37117y, n0Var.f37117y) && this.f37118z == n0Var.f37118z && Intrinsics.areEqual(this.A, n0Var.A)) {
            return true;
        }
        return false;
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
        int hashCode9;
        int hashCode10;
        int hashCode11;
        int hashCode12;
        int hashCode13;
        int hashCode14;
        int hashCode15;
        int hashCode16;
        int hashCode17;
        int hashCode18;
        int hashCode19 = this.f37093a.hashCode() * 31;
        String str = this.f37094b;
        int i4 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i5 = (hashCode19 + hashCode) * 31;
        String str2 = this.f37095c;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i6 = (i5 + hashCode2) * 31;
        String str3 = this.f37096d;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i7 = (i6 + hashCode3) * 31;
        Boolean bool = this.f37097e;
        if (bool == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = bool.hashCode();
        }
        int i8 = (i7 + hashCode4) * 31;
        Boolean bool2 = this.f37098f;
        if (bool2 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = bool2.hashCode();
        }
        int i9 = (i8 + hashCode5) * 31;
        String str4 = this.f37099g;
        if (str4 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = str4.hashCode();
        }
        int a4 = m4.a(this.f37101i, x1.a(this.f37100h, (i9 + hashCode6) * 31, 31), 31);
        Integer num = this.f37102j;
        if (num == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = num.hashCode();
        }
        int i10 = (a4 + hashCode7) * 31;
        Integer num2 = this.f37103k;
        if (num2 == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = num2.hashCode();
        }
        int a5 = m4.a(this.f37104l, (i10 + hashCode8) * 31, 31);
        String str5 = this.f37105m;
        if (str5 == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = str5.hashCode();
        }
        int i11 = (a5 + hashCode9) * 31;
        String str6 = this.f37106n;
        if (str6 == null) {
            hashCode10 = 0;
        } else {
            hashCode10 = str6.hashCode();
        }
        int i12 = (i11 + hashCode10) * 31;
        String str7 = this.f37107o;
        if (str7 == null) {
            hashCode11 = 0;
        } else {
            hashCode11 = str7.hashCode();
        }
        int a6 = m4.a(this.f37108p, (i12 + hashCode11) * 31, 31);
        Boolean bool3 = this.f37109q;
        if (bool3 == null) {
            hashCode12 = 0;
        } else {
            hashCode12 = bool3.hashCode();
        }
        int i13 = (a6 + hashCode12) * 31;
        Boolean bool4 = this.f37110r;
        if (bool4 == null) {
            hashCode13 = 0;
        } else {
            hashCode13 = bool4.hashCode();
        }
        int i14 = (i13 + hashCode13) * 31;
        Boolean bool5 = this.f37111s;
        if (bool5 == null) {
            hashCode14 = 0;
        } else {
            hashCode14 = bool5.hashCode();
        }
        int i15 = (i14 + hashCode14) * 31;
        Boolean bool6 = this.f37112t;
        if (bool6 == null) {
            hashCode15 = 0;
        } else {
            hashCode15 = bool6.hashCode();
        }
        int i16 = (i15 + hashCode15) * 31;
        boolean z3 = this.f37113u;
        int i17 = 1;
        int i18 = z3;
        if (z3 != 0) {
            i18 = 1;
        }
        int i19 = (i16 + i18) * 31;
        String str8 = this.f37114v;
        if (str8 == null) {
            hashCode16 = 0;
        } else {
            hashCode16 = str8.hashCode();
        }
        int i20 = (i19 + hashCode16) * 31;
        Integer num3 = this.f37115w;
        if (num3 == null) {
            hashCode17 = 0;
        } else {
            hashCode17 = num3.hashCode();
        }
        int i21 = (i20 + hashCode17) * 31;
        String str9 = this.f37116x;
        if (str9 == null) {
            hashCode18 = 0;
        } else {
            hashCode18 = str9.hashCode();
        }
        int i22 = (i21 + hashCode18) * 31;
        String str10 = this.f37117y;
        if (str10 != null) {
            i4 = str10.hashCode();
        }
        int i23 = (i22 + i4) * 31;
        boolean z4 = this.f37118z;
        if (!z4) {
            i17 = z4 ? 1 : 0;
        }
        return this.A.hashCode() + ((i23 + i17) * 31);
    }

    @NotNull
    public final String toString() {
        return "DeviceSpecsSchema(deviceDescription=" + this.f37093a + ", provider=" + this.f37094b + ", mobileCountryCode=" + this.f37095c + ", mobileNetworkCode=" + this.f37096d + ", nfcEnabled=" + this.f37097e + ", nfcExists=" + this.f37098f + ", applicationId=" + this.f37099g + ", operatingSystem=" + this.f37100h + ", operatingSystemVersion=" + this.f37101i + ", screenHeight=" + this.f37102j + ", screenWidth=" + this.f37103k + ", manufacturer=" + this.f37104l + ", applicationVersion=" + this.f37105m + ", connectionType=" + this.f37106n + ", locale=" + this.f37107o + ", screenSizeDiagonalInches=" + this.f37108p + ", isRoaming=" + this.f37109q + ", accessibilityEnabled=" + this.f37110r + ", developerEnabled=" + this.f37111s + ", installNonMarketApps=" + this.f37112t + ", hardwareAccelerated=" + this.f37113u + ", userAgent=" + this.f37114v + ", targetSDK=" + this.f37115w + ", board=" + this.f37116x + ", brand=" + this.f37117y + ", videoSupport=" + this.f37118z + ", localeList=" + this.A + ')';
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public n0(@org.jetbrains.annotations.NotNull com.pollfish.internal.k0 r29) {
        /*
            r28 = this;
            java.lang.String r1 = r29.h()
            java.lang.String r2 = r29.t()
            java.lang.String r3 = r29.n()
            java.lang.String r4 = r29.o()
            java.lang.Boolean r5 = r29.p()
            java.lang.Boolean r6 = r29.q()
            java.lang.String r7 = r29.b()
            int r8 = r29.r()
            int r0 = r29.s()
            java.lang.String r9 = java.lang.String.valueOf(r0)
            java.lang.Integer r10 = r29.u()
            java.lang.Integer r11 = r29.w()
            java.lang.String r12 = r29.m()
            java.lang.String r13 = r29.c()
            java.lang.String r14 = r29.f()
            java.lang.String r15 = r29.k()
            java.lang.Double r0 = r29.v()
            if (r0 == 0) goto L4c
            java.lang.String r0 = r0.toString()
            if (r0 != 0) goto L4e
        L4c:
            java.lang.String r0 = "unknown"
        L4e:
            r16 = r0
            java.lang.Boolean r17 = r29.A()
            java.lang.Boolean r18 = r29.a()
            java.lang.Boolean r19 = r29.g()
            java.lang.Boolean r20 = r29.j()
            boolean r21 = r29.i()
            java.lang.String r22 = r29.y()
            java.lang.Integer r23 = r29.x()
            java.lang.String r24 = r29.d()
            java.lang.String r25 = r29.e()
            boolean r26 = r29.z()
            java.util.List r27 = r29.l()
            r0 = r28
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pollfish.internal.n0.<init>(com.pollfish.internal.k0):void");
    }
}
