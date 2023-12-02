package com.pollfish.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class t {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final String f37211a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final String f37212b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final Integer f37213c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final Integer f37214d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final String f37215e;

    /* renamed from: f  reason: collision with root package name */
    public final int f37216f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f37217g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    public final String f37218h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public final String f37219i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    public final String f37220j = "no_encrypt";

    /* renamed from: k  reason: collision with root package name */
    public final boolean f37221k;

    public t(@NotNull String str, @NotNull String str2, @Nullable Integer num, @Nullable Integer num2, @Nullable String str3, int i4, boolean z3, @NotNull String str4, @Nullable String str5, boolean z4) {
        this.f37211a = str;
        this.f37212b = str2;
        this.f37213c = num;
        this.f37214d = num2;
        this.f37215e = str3;
        this.f37216f = i4;
        this.f37217g = z3;
        this.f37218h = str4;
        this.f37219i = str5;
        this.f37221k = z4;
    }

    @NotNull
    public final String a() {
        return this.f37211a;
    }

    @Nullable
    public final String b() {
        return this.f37219i;
    }

    public final boolean c() {
        return this.f37217g;
    }

    @NotNull
    public final String d() {
        return this.f37212b;
    }

    @NotNull
    public final String e() {
        return this.f37220j;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        if (Intrinsics.areEqual(this.f37211a, tVar.f37211a) && Intrinsics.areEqual(this.f37212b, tVar.f37212b) && Intrinsics.areEqual(this.f37213c, tVar.f37213c) && Intrinsics.areEqual(this.f37214d, tVar.f37214d) && Intrinsics.areEqual(this.f37215e, tVar.f37215e) && this.f37216f == tVar.f37216f && this.f37217g == tVar.f37217g && Intrinsics.areEqual(this.f37218h, tVar.f37218h) && Intrinsics.areEqual(this.f37219i, tVar.f37219i) && Intrinsics.areEqual(this.f37220j, tVar.f37220j) && this.f37221k == tVar.f37221k) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        return this.f37221k;
    }

    @Nullable
    public final String g() {
        return this.f37215e;
    }

    public final int h() {
        return this.f37216f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int a4 = m4.a(this.f37212b, this.f37211a.hashCode() * 31, 31);
        Integer num = this.f37213c;
        int i4 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int i5 = (a4 + hashCode) * 31;
        Integer num2 = this.f37214d;
        if (num2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = num2.hashCode();
        }
        int i6 = (i5 + hashCode2) * 31;
        String str = this.f37215e;
        if (str == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str.hashCode();
        }
        int a5 = x1.a(this.f37216f, (i6 + hashCode3) * 31, 31);
        boolean z3 = this.f37217g;
        int i7 = 1;
        int i8 = z3;
        if (z3 != 0) {
            i8 = 1;
        }
        int a6 = m4.a(this.f37218h, (a5 + i8) * 31, 31);
        String str2 = this.f37219i;
        if (str2 != null) {
            i4 = str2.hashCode();
        }
        int a7 = m4.a(this.f37220j, (a6 + i4) * 31, 31);
        boolean z4 = this.f37221k;
        if (!z4) {
            i7 = z4 ? 1 : 0;
        }
        return a7 + i7;
    }

    @Nullable
    public final Integer i() {
        return this.f37213c;
    }

    @Nullable
    public final Integer j() {
        return this.f37214d;
    }

    @NotNull
    public final String k() {
        return this.f37218h;
    }

    @NotNull
    public final String toString() {
        return "BaseParams(apiKey=" + this.f37211a + ", deviceId=" + this.f37212b + ", surveyFormat=" + this.f37213c + ", surveyId=" + this.f37214d + ", requestUUID=" + this.f37215e + ", sdkVersion=" + this.f37216f + ", debug=" + this.f37217g + ", timestamp=" + this.f37218h + ", clickId=" + this.f37219i + ", encryption=" + this.f37220j + ", optOut=" + this.f37221k + ')';
    }
}
