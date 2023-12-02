package com.pollfish.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.pollfish.internal.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class e4 {
    @Nullable
    public final String A;
    @Nullable
    public final String B;
    @Nullable
    public final String C;
    @Nullable
    public final Integer D;
    @Nullable
    public final Integer E;
    @Nullable
    public final String F;
    @Nullable
    public final String G;
    @Nullable
    public final Integer H;
    @NotNull
    public final String I;
    @Nullable
    public final Integer J;
    @Nullable
    public final Integer K;
    @Nullable
    public final String L;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public final String f36784a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final Boolean f36785b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public final Boolean f36786c;

    /* renamed from: d  reason: collision with root package name */
    public final int f36787d;

    /* renamed from: e  reason: collision with root package name */
    public final int f36788e;

    /* renamed from: f  reason: collision with root package name */
    public final int f36789f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    public final String f36790g;

    /* renamed from: h  reason: collision with root package name */
    public final int f36791h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f36792i;
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    public final String f36793j;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    public final String f36794k;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    public final String f36795l;
    @NotNull

    /* renamed from: m  reason: collision with root package name */
    public final List<q> f36796m;
    @NotNull

    /* renamed from: n  reason: collision with root package name */
    public final String f36797n;

    /* renamed from: o  reason: collision with root package name */
    public final boolean f36798o;

    /* renamed from: p  reason: collision with root package name */
    public final boolean f36799p;
    @NotNull

    /* renamed from: q  reason: collision with root package name */
    public final String f36800q;

    /* renamed from: r  reason: collision with root package name */
    public final boolean f36801r;

    /* renamed from: s  reason: collision with root package name */
    public final boolean f36802s;

    /* renamed from: t  reason: collision with root package name */
    public final boolean f36803t;

    /* renamed from: u  reason: collision with root package name */
    public final boolean f36804u;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public final String f36805v;
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    public final String f36806w;
    @Nullable

    /* renamed from: x  reason: collision with root package name */
    public final String f36807x;
    @NotNull

    /* renamed from: y  reason: collision with root package name */
    public final String f36808y;
    @Nullable

    /* renamed from: z  reason: collision with root package name */
    public final String f36809z;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: com.pollfish.internal.e4$a$a  reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C0213a implements Iterable<JSONObject>, KMappedMarker {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ JSONObject f36810a;

            public C0213a(JSONObject jSONObject) {
                this.f36810a = jSONObject;
            }

            @Override // java.lang.Iterable
            @NotNull
            public final Iterator<JSONObject> iterator() {
                return q1.a(this.f36810a.getJSONArray("assets"));
            }
        }

        @NotNull
        public static e4 a(@NotNull String str) {
            int collectionSizeOrDefault;
            List list;
            JSONObject jSONObject = new JSONObject(str);
            String c4 = q1.c("response_type", jSONObject);
            Boolean a4 = q1.a("containsSurvey", jSONObject);
            Boolean a5 = q1.a("origin_european_union", jSONObject);
            int i4 = jSONObject.getInt("intrusion");
            int i5 = jSONObject.getInt("width_percentage");
            int i6 = jSONObject.getInt("height_percentage");
            String string = jSONObject.getString(FirebaseAnalytics.Param.CONTENT);
            int i7 = jSONObject.getInt("s_id");
            boolean z3 = jSONObject.getBoolean("custom_indicator");
            String string2 = jSONObject.getString("indicator_image_left");
            String string3 = jSONObject.getString("indicator_image_right");
            String string4 = jSONObject.getString("mobile_data");
            C0213a c0213a = new C0213a(jSONObject);
            collectionSizeOrDefault = kotlin.collections.f.collectionSizeOrDefault(c0213a, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<JSONObject> it = c0213a.iterator();
            while (it.hasNext()) {
                arrayList.add(q.a.a(it.next()));
            }
            list = CollectionsKt___CollectionsKt.toList(arrayList);
            return new e4(c4, a4, a5, i4, i5, i6, string, i7, z3, string2, string3, string4, list, jSONObject.getString("background_color"), jSONObject.getBoolean("short_survey"), jSONObject.getBoolean("video_enabled"), jSONObject.getString("video_color"), jSONObject.getBoolean("close_on_touch"), jSONObject.getBoolean("clear_cache"), jSONObject.getBoolean("has_accepted_terms"), jSONObject.getBoolean("has_email"), q1.c("med_top_view_bg", jSONObject), q1.c("med_top_view_sep_bg", jSONObject), q1.c("med_top_view_txt_color", jSONObject), jSONObject.getString("med_top_view_logo"), q1.c("med_bot_view_bg", jSONObject), q1.c("med_bot_view_sep_bg", jSONObject), q1.c("med_bot_view_txt_color", jSONObject), q1.c("med_top_progr_bg", jSONObject), q1.b("survey_loi", jSONObject), q1.b("survey_ir", jSONObject), q1.c("survey_class", jSONObject), q1.c("reward_name", jSONObject), q1.b("reward_value", jSONObject), jSONObject.getString("error_html"), q1.b("remaining_completes", jSONObject), q1.b("survey_price", jSONObject), q1.c("indicatorRight", jSONObject));
        }
    }

    public e4(@Nullable String str, @Nullable Boolean bool, @Nullable Boolean bool2, int i4, int i5, int i6, @NotNull String str2, int i7, boolean z3, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull List<q> list, @NotNull String str6, boolean z4, boolean z5, @NotNull String str7, boolean z6, boolean z7, boolean z8, boolean z9, @Nullable String str8, @Nullable String str9, @Nullable String str10, @NotNull String str11, @Nullable String str12, @Nullable String str13, @Nullable String str14, @Nullable String str15, @Nullable Integer num, @Nullable Integer num2, @Nullable String str16, @Nullable String str17, @Nullable Integer num3, @NotNull String str18, @Nullable Integer num4, @Nullable Integer num5, @Nullable String str19) {
        this.f36784a = str;
        this.f36785b = bool;
        this.f36786c = bool2;
        this.f36787d = i4;
        this.f36788e = i5;
        this.f36789f = i6;
        this.f36790g = str2;
        this.f36791h = i7;
        this.f36792i = z3;
        this.f36793j = str3;
        this.f36794k = str4;
        this.f36795l = str5;
        this.f36796m = list;
        this.f36797n = str6;
        this.f36798o = z4;
        this.f36799p = z5;
        this.f36800q = str7;
        this.f36801r = z6;
        this.f36802s = z7;
        this.f36803t = z8;
        this.f36804u = z9;
        this.f36805v = str8;
        this.f36806w = str9;
        this.f36807x = str10;
        this.f36808y = str11;
        this.f36809z = str12;
        this.A = str13;
        this.B = str14;
        this.C = str15;
        this.D = num;
        this.E = num2;
        this.F = str16;
        this.G = str17;
        this.H = num3;
        this.I = str18;
        this.J = num4;
        this.K = num5;
        this.L = str19;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x010a  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0120  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0183 A[LOOP:1: B:76:0x017d->B:78:0x0183, LOOP_END] */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.pollfish.internal.g2 a(@org.jetbrains.annotations.NotNull int r47) {
        /*
            Method dump skipped, instructions count: 438
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pollfish.internal.e4.a(int):com.pollfish.internal.g2");
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e4)) {
            return false;
        }
        e4 e4Var = (e4) obj;
        if (Intrinsics.areEqual(this.f36784a, e4Var.f36784a) && Intrinsics.areEqual(this.f36785b, e4Var.f36785b) && Intrinsics.areEqual(this.f36786c, e4Var.f36786c) && this.f36787d == e4Var.f36787d && this.f36788e == e4Var.f36788e && this.f36789f == e4Var.f36789f && Intrinsics.areEqual(this.f36790g, e4Var.f36790g) && this.f36791h == e4Var.f36791h && this.f36792i == e4Var.f36792i && Intrinsics.areEqual(this.f36793j, e4Var.f36793j) && Intrinsics.areEqual(this.f36794k, e4Var.f36794k) && Intrinsics.areEqual(this.f36795l, e4Var.f36795l) && Intrinsics.areEqual(this.f36796m, e4Var.f36796m) && Intrinsics.areEqual(this.f36797n, e4Var.f36797n) && this.f36798o == e4Var.f36798o && this.f36799p == e4Var.f36799p && Intrinsics.areEqual(this.f36800q, e4Var.f36800q) && this.f36801r == e4Var.f36801r && this.f36802s == e4Var.f36802s && this.f36803t == e4Var.f36803t && this.f36804u == e4Var.f36804u && Intrinsics.areEqual(this.f36805v, e4Var.f36805v) && Intrinsics.areEqual(this.f36806w, e4Var.f36806w) && Intrinsics.areEqual(this.f36807x, e4Var.f36807x) && Intrinsics.areEqual(this.f36808y, e4Var.f36808y) && Intrinsics.areEqual(this.f36809z, e4Var.f36809z) && Intrinsics.areEqual(this.A, e4Var.A) && Intrinsics.areEqual(this.B, e4Var.B) && Intrinsics.areEqual(this.C, e4Var.C) && Intrinsics.areEqual(this.D, e4Var.D) && Intrinsics.areEqual(this.E, e4Var.E) && Intrinsics.areEqual(this.F, e4Var.F) && Intrinsics.areEqual(this.G, e4Var.G) && Intrinsics.areEqual(this.H, e4Var.H) && Intrinsics.areEqual(this.I, e4Var.I) && Intrinsics.areEqual(this.J, e4Var.J) && Intrinsics.areEqual(this.K, e4Var.K) && Intrinsics.areEqual(this.L, e4Var.L)) {
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
        String str = this.f36784a;
        int i4 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i5 = hashCode * 31;
        Boolean bool = this.f36785b;
        if (bool == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = bool.hashCode();
        }
        int i6 = (i5 + hashCode2) * 31;
        Boolean bool2 = this.f36786c;
        if (bool2 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = bool2.hashCode();
        }
        int a4 = x1.a(this.f36791h, m4.a(this.f36790g, x1.a(this.f36789f, x1.a(this.f36788e, x1.a(this.f36787d, (i6 + hashCode3) * 31, 31), 31), 31), 31), 31);
        boolean z3 = this.f36792i;
        int i7 = 1;
        int i8 = z3;
        if (z3 != 0) {
            i8 = 1;
        }
        int a5 = m4.a(this.f36795l, m4.a(this.f36794k, m4.a(this.f36793j, (a4 + i8) * 31, 31), 31), 31);
        int a6 = m4.a(this.f36797n, (this.f36796m.hashCode() + a5) * 31, 31);
        boolean z4 = this.f36798o;
        int i9 = z4;
        if (z4 != 0) {
            i9 = 1;
        }
        int i10 = (a6 + i9) * 31;
        boolean z5 = this.f36799p;
        int i11 = z5;
        if (z5 != 0) {
            i11 = 1;
        }
        int a7 = m4.a(this.f36800q, (i10 + i11) * 31, 31);
        boolean z6 = this.f36801r;
        int i12 = z6;
        if (z6 != 0) {
            i12 = 1;
        }
        int i13 = (a7 + i12) * 31;
        boolean z7 = this.f36802s;
        int i14 = z7;
        if (z7 != 0) {
            i14 = 1;
        }
        int i15 = (i13 + i14) * 31;
        boolean z8 = this.f36803t;
        int i16 = z8;
        if (z8 != 0) {
            i16 = 1;
        }
        int i17 = (i15 + i16) * 31;
        boolean z9 = this.f36804u;
        if (!z9) {
            i7 = z9 ? 1 : 0;
        }
        int i18 = (i17 + i7) * 31;
        String str2 = this.f36805v;
        if (str2 == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str2.hashCode();
        }
        int i19 = (i18 + hashCode4) * 31;
        String str3 = this.f36806w;
        if (str3 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str3.hashCode();
        }
        int i20 = (i19 + hashCode5) * 31;
        String str4 = this.f36807x;
        if (str4 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = str4.hashCode();
        }
        int a8 = m4.a(this.f36808y, (i20 + hashCode6) * 31, 31);
        String str5 = this.f36809z;
        if (str5 == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = str5.hashCode();
        }
        int i21 = (a8 + hashCode7) * 31;
        String str6 = this.A;
        if (str6 == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = str6.hashCode();
        }
        int i22 = (i21 + hashCode8) * 31;
        String str7 = this.B;
        if (str7 == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = str7.hashCode();
        }
        int i23 = (i22 + hashCode9) * 31;
        String str8 = this.C;
        if (str8 == null) {
            hashCode10 = 0;
        } else {
            hashCode10 = str8.hashCode();
        }
        int i24 = (i23 + hashCode10) * 31;
        Integer num = this.D;
        if (num == null) {
            hashCode11 = 0;
        } else {
            hashCode11 = num.hashCode();
        }
        int i25 = (i24 + hashCode11) * 31;
        Integer num2 = this.E;
        if (num2 == null) {
            hashCode12 = 0;
        } else {
            hashCode12 = num2.hashCode();
        }
        int i26 = (i25 + hashCode12) * 31;
        String str9 = this.F;
        if (str9 == null) {
            hashCode13 = 0;
        } else {
            hashCode13 = str9.hashCode();
        }
        int i27 = (i26 + hashCode13) * 31;
        String str10 = this.G;
        if (str10 == null) {
            hashCode14 = 0;
        } else {
            hashCode14 = str10.hashCode();
        }
        int i28 = (i27 + hashCode14) * 31;
        Integer num3 = this.H;
        if (num3 == null) {
            hashCode15 = 0;
        } else {
            hashCode15 = num3.hashCode();
        }
        int a9 = m4.a(this.I, (i28 + hashCode15) * 31, 31);
        Integer num4 = this.J;
        if (num4 == null) {
            hashCode16 = 0;
        } else {
            hashCode16 = num4.hashCode();
        }
        int i29 = (a9 + hashCode16) * 31;
        Integer num5 = this.K;
        if (num5 == null) {
            hashCode17 = 0;
        } else {
            hashCode17 = num5.hashCode();
        }
        int i30 = (i29 + hashCode17) * 31;
        String str11 = this.L;
        if (str11 != null) {
            i4 = str11.hashCode();
        }
        return i30 + i4;
    }

    @NotNull
    public final String toString() {
        return "RegisterResponseSchema(responseType=" + this.f36784a + ", containsSurvey=" + this.f36785b + ", originEuropeanUnion=" + this.f36786c + ", intrusion=" + this.f36787d + ", widthPercentage=" + this.f36788e + ", heightPercentage=" + this.f36789f + ", content=" + this.f36790g + ", surveyId=" + this.f36791h + ", customIndicator=" + this.f36792i + ", indicatorImageUrlLeft=" + this.f36793j + ", indicatorImageUrlRight=" + this.f36794k + ", mobileData=" + this.f36795l + ", assets=" + this.f36796m + ", backgroundColor=" + this.f36797n + ", shortSurvey=" + this.f36798o + ", videoEnabled=" + this.f36799p + ", videoColor=" + this.f36800q + ", closeOnTouch=" + this.f36801r + ", clearCache=" + this.f36802s + ", hasAcceptedTerms=" + this.f36803t + ", hasEmail=" + this.f36804u + ", mediationTopViewBackgroundColor=" + this.f36805v + ", mediationTopViewSeparatorBackgroundColor=" + this.f36806w + ", mediationTopViewTextColor=" + this.f36807x + ", mediationTopViewLogo=" + this.f36808y + ", mediationBottomViewBackgroundColor=" + this.f36809z + ", mediationBottomViewSeparatorBackgroundColor=" + this.A + ", mediationBottomViewTextColor=" + this.B + ", mediationTopViewProgressBackgroundColor=" + this.C + ", surveyLengthOfInterview=" + this.D + ", surveyIncidenceRate=" + this.E + ", surveyClass=" + this.F + ", rewardName=" + this.G + ", rewardValue=" + this.H + ", errorHtmlContent=" + this.I + ", remainingCompletes=" + this.J + ", surveyPrice=" + this.K + ", indicatorRight=" + this.L + ')';
    }
}
