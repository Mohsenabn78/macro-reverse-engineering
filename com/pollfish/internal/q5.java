package com.pollfish.internal;

import androidx.autofill.HintConstants;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class q5 {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final String f37165a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final String f37166b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final String f37167c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final String f37168d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final String f37169e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final String f37170f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    public final List<String> f37171g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public final String f37172h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public final String f37173i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public final String f37174j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    public final String f37175k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    public final String f37176l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    public final String f37177m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    public final JSONObject f37178n;

    public q5() {
        this(0);
    }

    @NotNull
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        q1.a(jSONObject, HintConstants.AUTOFILL_HINT_GENDER, this.f37165a);
        q1.a(jSONObject, "year_of_birth", this.f37166b);
        q1.a(jSONObject, "marital_status", this.f37167c);
        q1.a(jSONObject, "parental", this.f37168d);
        q1.a(jSONObject, "organization_role", this.f37169e);
        q1.a(jSONObject, "number_of_employees", this.f37170f);
        q1.a(jSONObject, this.f37171g);
        q1.a(jSONObject, "education", this.f37172h);
        q1.a(jSONObject, "employment", this.f37173i);
        q1.a(jSONObject, "career", this.f37174j);
        q1.a(jSONObject, "race", this.f37175k);
        q1.a(jSONObject, "income", this.f37176l);
        q1.a(jSONObject, "postal_data", this.f37177m);
        q1.a(jSONObject, this.f37178n);
        return jSONObject;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q5)) {
            return false;
        }
        q5 q5Var = (q5) obj;
        if (Intrinsics.areEqual(this.f37165a, q5Var.f37165a) && Intrinsics.areEqual(this.f37166b, q5Var.f37166b) && Intrinsics.areEqual(this.f37167c, q5Var.f37167c) && Intrinsics.areEqual(this.f37168d, q5Var.f37168d) && Intrinsics.areEqual(this.f37169e, q5Var.f37169e) && Intrinsics.areEqual(this.f37170f, q5Var.f37170f) && Intrinsics.areEqual(this.f37171g, q5Var.f37171g) && Intrinsics.areEqual(this.f37172h, q5Var.f37172h) && Intrinsics.areEqual(this.f37173i, q5Var.f37173i) && Intrinsics.areEqual(this.f37174j, q5Var.f37174j) && Intrinsics.areEqual(this.f37175k, q5Var.f37175k) && Intrinsics.areEqual(this.f37176l, q5Var.f37176l) && Intrinsics.areEqual(this.f37177m, q5Var.f37177m) && Intrinsics.areEqual(this.f37178n, q5Var.f37178n)) {
            return true;
        }
        return false;
    }

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
        String str = this.f37165a;
        int i4 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i5 = hashCode * 31;
        String str2 = this.f37166b;
        if (str2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str2.hashCode();
        }
        int i6 = (i5 + hashCode2) * 31;
        String str3 = this.f37167c;
        if (str3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str3.hashCode();
        }
        int i7 = (i6 + hashCode3) * 31;
        String str4 = this.f37168d;
        if (str4 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str4.hashCode();
        }
        int i8 = (i7 + hashCode4) * 31;
        String str5 = this.f37169e;
        if (str5 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str5.hashCode();
        }
        int i9 = (i8 + hashCode5) * 31;
        String str6 = this.f37170f;
        if (str6 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = str6.hashCode();
        }
        int i10 = (i9 + hashCode6) * 31;
        List<String> list = this.f37171g;
        if (list == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = list.hashCode();
        }
        int i11 = (i10 + hashCode7) * 31;
        String str7 = this.f37172h;
        if (str7 == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = str7.hashCode();
        }
        int i12 = (i11 + hashCode8) * 31;
        String str8 = this.f37173i;
        if (str8 == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = str8.hashCode();
        }
        int i13 = (i12 + hashCode9) * 31;
        String str9 = this.f37174j;
        if (str9 == null) {
            hashCode10 = 0;
        } else {
            hashCode10 = str9.hashCode();
        }
        int i14 = (i13 + hashCode10) * 31;
        String str10 = this.f37175k;
        if (str10 == null) {
            hashCode11 = 0;
        } else {
            hashCode11 = str10.hashCode();
        }
        int i15 = (i14 + hashCode11) * 31;
        String str11 = this.f37176l;
        if (str11 == null) {
            hashCode12 = 0;
        } else {
            hashCode12 = str11.hashCode();
        }
        int i16 = (i15 + hashCode12) * 31;
        String str12 = this.f37177m;
        if (str12 == null) {
            hashCode13 = 0;
        } else {
            hashCode13 = str12.hashCode();
        }
        int i17 = (i16 + hashCode13) * 31;
        JSONObject jSONObject = this.f37178n;
        if (jSONObject != null) {
            i4 = jSONObject.hashCode();
        }
        return i17 + i4;
    }

    @NotNull
    public final String toString() {
        return "UserPropertiesSchema(gender=" + this.f37165a + ", yearOfBirth=" + this.f37166b + ", maritalStatus=" + this.f37167c + ", parentalStatus=" + this.f37168d + ", organizationRole=" + this.f37169e + ", numberOfEmployees=" + this.f37170f + ", spokenLanguages=" + this.f37171g + ", educationLevel=" + this.f37172h + ", employmentStatus=" + this.f37173i + ", career=" + this.f37174j + ", race=" + this.f37175k + ", income=" + this.f37176l + ", postalData=" + this.f37177m + ", customAttributes=" + this.f37178n + ')';
    }

    public /* synthetic */ q5(int i4) {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null);
    }

    public q5(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable List<String> list, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable String str10, @Nullable String str11, @Nullable String str12, @Nullable JSONObject jSONObject) {
        this.f37165a = str;
        this.f37166b = str2;
        this.f37167c = str3;
        this.f37168d = str4;
        this.f37169e = str5;
        this.f37170f = str6;
        this.f37171g = list;
        this.f37172h = str7;
        this.f37173i = str8;
        this.f37174j = str9;
        this.f37175k = str10;
        this.f37176l = str11;
        this.f37177m = str12;
        this.f37178n = jSONObject;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public q5(@org.jetbrains.annotations.NotNull com.pollfish.builder.UserProperties r16) {
        /*
            r15 = this;
            java.lang.String r1 = r16.getGender()
            java.lang.String r2 = r16.getYearOfBirth()
            java.lang.String r3 = r16.getMaritalStatus()
            java.lang.String r4 = r16.getParentalStatus()
            java.lang.String r5 = r16.getOrganizationRole()
            java.lang.String r6 = r16.getNumberOfEmployees()
            java.util.List r7 = r16.getSpokenLanguages()
            java.lang.String r8 = r16.getEducationLevel()
            java.lang.String r9 = r16.getEmploymentStatus()
            java.lang.String r10 = r16.getCareer()
            java.lang.String r11 = r16.getRace()
            java.lang.String r12 = r16.getIncome()
            java.lang.String r13 = r16.getPostalData()
            java.util.Map r0 = r16.getCustomAttributes()
            if (r0 == 0) goto L40
            org.json.JSONObject r14 = new org.json.JSONObject
            r14.<init>(r0)
            goto L42
        L40:
            r0 = 0
            r14 = r0
        L42:
            r0 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pollfish.internal.q5.<init>(com.pollfish.builder.UserProperties):void");
    }
}
