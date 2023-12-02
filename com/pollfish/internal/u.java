package com.pollfish.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class u {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final String f37249a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final String f37250b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final Integer f37251c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public final Integer f37252d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final String f37253e;

    /* renamed from: f  reason: collision with root package name */
    public final int f37254f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f37255g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    public final String f37256h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public final String f37257i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    public final String f37258j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    public final String f37259k;

    public u(@NotNull String str, @NotNull String str2, @Nullable Integer num, @Nullable Integer num2, @Nullable String str3, int i4, boolean z3, @NotNull String str4, @Nullable String str5, @NotNull String str6, @NotNull String str7) {
        this.f37249a = str;
        this.f37250b = str2;
        this.f37251c = num;
        this.f37252d = num2;
        this.f37253e = str3;
        this.f37254f = i4;
        this.f37255g = z3;
        this.f37256h = str4;
        this.f37257i = str5;
        this.f37258j = str6;
        this.f37259k = str7;
    }

    @NotNull
    public final JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("api_key", this.f37249a);
        jSONObject.put("device_id", this.f37250b);
        q1.a(jSONObject, "survey_format", this.f37251c);
        q1.a(jSONObject, "survey_id", this.f37252d);
        q1.a(jSONObject, "request_uuid", this.f37253e);
        jSONObject.put("version", this.f37254f);
        jSONObject.put("debug", this.f37255g);
        jSONObject.put("timestamp", this.f37256h);
        jSONObject.put("click_id", this.f37257i);
        jSONObject.put("encryption", this.f37258j);
        jSONObject.put("opt_out", this.f37259k);
        return jSONObject;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof u)) {
            return false;
        }
        u uVar = (u) obj;
        if (Intrinsics.areEqual(this.f37249a, uVar.f37249a) && Intrinsics.areEqual(this.f37250b, uVar.f37250b) && Intrinsics.areEqual(this.f37251c, uVar.f37251c) && Intrinsics.areEqual(this.f37252d, uVar.f37252d) && Intrinsics.areEqual(this.f37253e, uVar.f37253e) && this.f37254f == uVar.f37254f && this.f37255g == uVar.f37255g && Intrinsics.areEqual(this.f37256h, uVar.f37256h) && Intrinsics.areEqual(this.f37257i, uVar.f37257i) && Intrinsics.areEqual(this.f37258j, uVar.f37258j) && Intrinsics.areEqual(this.f37259k, uVar.f37259k)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int a4 = m4.a(this.f37250b, this.f37249a.hashCode() * 31, 31);
        Integer num = this.f37251c;
        int i4 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int i5 = (a4 + hashCode) * 31;
        Integer num2 = this.f37252d;
        if (num2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = num2.hashCode();
        }
        int i6 = (i5 + hashCode2) * 31;
        String str = this.f37253e;
        if (str == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str.hashCode();
        }
        int a5 = x1.a(this.f37254f, (i6 + hashCode3) * 31, 31);
        boolean z3 = this.f37255g;
        int i7 = z3;
        if (z3 != 0) {
            i7 = 1;
        }
        int a6 = m4.a(this.f37256h, (a5 + i7) * 31, 31);
        String str2 = this.f37257i;
        if (str2 != null) {
            i4 = str2.hashCode();
        }
        return this.f37259k.hashCode() + m4.a(this.f37258j, (a6 + i4) * 31, 31);
    }

    @NotNull
    public final String toString() {
        return "BaseParamsSchema(apiKey=" + this.f37249a + ", deviceId=" + this.f37250b + ", surveyFormat=" + this.f37251c + ", surveyId=" + this.f37252d + ", requestUUID=" + this.f37253e + ", sdkVersion=" + this.f37254f + ", debug=" + this.f37255g + ", timestamp=" + this.f37256h + ", clickId=" + this.f37257i + ", encryption=" + this.f37258j + ", optOut=" + this.f37259k + ')';
    }

    public u(@NotNull t tVar) {
        this(tVar.a(), tVar.d(), tVar.i(), tVar.j(), tVar.g(), tVar.h(), tVar.c(), tVar.k(), tVar.b(), tVar.e(), String.valueOf(tVar.f()));
    }
}
