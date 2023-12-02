package com.pollfish.internal;

import com.google.android.gms.common.internal.ImagesContract;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* loaded from: classes6.dex */
public final class j3 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public int f36931a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public String f36932b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public String f36933c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public String f36934d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public String f36935e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public String f36936f;
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    public String f36937g;
    @NotNull

    /* renamed from: h  reason: collision with root package name */
    public String f36938h;
    @NotNull

    /* renamed from: i  reason: collision with root package name */
    public String f36939i;

    /* loaded from: classes6.dex */
    public static final class a {
        @NotNull
        public static Pair a(@NotNull String str) {
            Exception exc;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            String str7;
            String str8;
            String str9;
            String str10;
            String str11;
            String str12;
            String str13;
            String str14;
            String str15;
            String str16;
            int i4;
            JSONObject jSONObject;
            try {
                jSONObject = new JSONObject(str);
                try {
                    str2 = jSONObject.getString(ImagesContract.URL);
                } catch (Exception e4) {
                    throw e4;
                }
            } catch (Exception e5) {
                exc = e5;
                str2 = "";
                str3 = str2;
            }
            try {
                str3 = jSONObject.getString("surveyByTxt");
                try {
                    try {
                        str4 = jSONObject.getString("providerImgPath");
                        try {
                            JSONObject jSONObject2 = new JSONObject(jSONObject.getString("action"));
                            int a4 = z2.a(jSONObject2.getString("action"));
                            exc = null;
                            if (a4 == 1) {
                                i4 = a4;
                                str14 = "";
                                str16 = str14;
                                str15 = str16;
                                str9 = str15;
                                str13 = str9;
                                str10 = str2;
                                str11 = str3;
                                str12 = str4;
                            } else {
                                str5 = jSONObject2.getString("actionCancel");
                                try {
                                    str6 = jSONObject2.getString("redirectURL");
                                    try {
                                        str7 = jSONObject2.getString("actionDescription");
                                        try {
                                            str8 = jSONObject2.getString("actionTitle");
                                            try {
                                                i4 = a4;
                                                str9 = jSONObject2.getString("actionConfirm");
                                                str10 = str2;
                                                str11 = str3;
                                                str12 = str4;
                                                str13 = str5;
                                                str14 = str6;
                                                str15 = str7;
                                                str16 = str8;
                                            } catch (Exception e6) {
                                                exc = e6;
                                                str9 = "";
                                                str10 = str2;
                                                str11 = str3;
                                                str12 = str4;
                                                str13 = str5;
                                                str14 = str6;
                                                str15 = str7;
                                                str16 = str8;
                                                i4 = 1;
                                                return new Pair(new j3(i4, str10, str14, str16, str15, str9, str13, str11, str12), exc);
                                            }
                                        } catch (Exception e7) {
                                            exc = e7;
                                            str8 = "";
                                        }
                                    } catch (Exception e8) {
                                        exc = e8;
                                        str7 = "";
                                        str8 = str7;
                                        str9 = "";
                                        str10 = str2;
                                        str11 = str3;
                                        str12 = str4;
                                        str13 = str5;
                                        str14 = str6;
                                        str15 = str7;
                                        str16 = str8;
                                        i4 = 1;
                                        return new Pair(new j3(i4, str10, str14, str16, str15, str9, str13, str11, str12), exc);
                                    }
                                } catch (Exception e9) {
                                    exc = e9;
                                    str6 = "";
                                    str7 = str6;
                                    str8 = str7;
                                    str9 = "";
                                    str10 = str2;
                                    str11 = str3;
                                    str12 = str4;
                                    str13 = str5;
                                    str14 = str6;
                                    str15 = str7;
                                    str16 = str8;
                                    i4 = 1;
                                    return new Pair(new j3(i4, str10, str14, str16, str15, str9, str13, str11, str12), exc);
                                }
                            }
                        } catch (Exception e10) {
                            throw e10;
                        }
                    } catch (Exception e11) {
                        exc = e11;
                        str5 = "";
                        str6 = str5;
                        str7 = str6;
                        str8 = str7;
                        str9 = "";
                        str10 = str2;
                        str11 = str3;
                        str12 = str4;
                        str13 = str5;
                        str14 = str6;
                        str15 = str7;
                        str16 = str8;
                        i4 = 1;
                        return new Pair(new j3(i4, str10, str14, str16, str15, str9, str13, str11, str12), exc);
                    }
                    return new Pair(new j3(i4, str10, str14, str16, str15, str9, str13, str11, str12), exc);
                } catch (Exception e12) {
                    try {
                        throw e12;
                    } catch (Exception e13) {
                        exc = e13;
                        str4 = "";
                        str5 = str4;
                        str6 = str5;
                        str7 = str6;
                        str8 = str7;
                        str9 = "";
                        str10 = str2;
                        str11 = str3;
                        str12 = str4;
                        str13 = str5;
                        str14 = str6;
                        str15 = str7;
                        str16 = str8;
                        i4 = 1;
                        return new Pair(new j3(i4, str10, str14, str16, str15, str9, str13, str11, str12), exc);
                    }
                }
            } catch (Exception e14) {
                try {
                    throw e14;
                } catch (Exception e15) {
                    exc = e15;
                    str3 = "";
                    str4 = str3;
                    str5 = str4;
                    str6 = str5;
                    str7 = str6;
                    str8 = str7;
                    str9 = "";
                    str10 = str2;
                    str11 = str3;
                    str12 = str4;
                    str13 = str5;
                    str14 = str6;
                    str15 = str7;
                    str16 = str8;
                    i4 = 1;
                    return new Pair(new j3(i4, str10, str14, str16, str15, str9, str13, str11, str12), exc);
                }
            }
        }
    }

    public j3(@NotNull int i4, @NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull String str8) {
        this.f36931a = i4;
        this.f36932b = str;
        this.f36933c = str2;
        this.f36934d = str3;
        this.f36935e = str4;
        this.f36936f = str5;
        this.f36937g = str6;
        this.f36938h = str7;
        this.f36939i = str8;
    }

    @NotNull
    public final String a() {
        return this.f36939i;
    }

    @NotNull
    public final String b() {
        return this.f36938h;
    }

    @NotNull
    public final String c() {
        return this.f36932b;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j3)) {
            return false;
        }
        j3 j3Var = (j3) obj;
        if (this.f36931a == j3Var.f36931a && Intrinsics.areEqual(this.f36932b, j3Var.f36932b) && Intrinsics.areEqual(this.f36933c, j3Var.f36933c) && Intrinsics.areEqual(this.f36934d, j3Var.f36934d) && Intrinsics.areEqual(this.f36935e, j3Var.f36935e) && Intrinsics.areEqual(this.f36936f, j3Var.f36936f) && Intrinsics.areEqual(this.f36937g, j3Var.f36937g) && Intrinsics.areEqual(this.f36938h, j3Var.f36938h) && Intrinsics.areEqual(this.f36939i, j3Var.f36939i)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f36939i.hashCode() + m4.a(this.f36938h, m4.a(this.f36937g, m4.a(this.f36936f, m4.a(this.f36935e, m4.a(this.f36934d, m4.a(this.f36933c, m4.a(this.f36932b, v0.a(this.f36931a) * 31, 31), 31), 31), 31), 31), 31), 31);
    }

    @NotNull
    public final String toString() {
        String trimIndent;
        StringBuilder a4 = u4.a("\n        {\n            \"url\": \"");
        a4.append(this.f36932b);
        a4.append("\",\n            \"surveyByTxt\": \"");
        a4.append(this.f36938h);
        a4.append("\",\n            \"providerImgPath\": \"");
        a4.append(this.f36939i);
        a4.append("\",\n            \"action\": {\n                \"action\": \"");
        a4.append(a3.a(this.f36931a));
        a4.append("\",\n                \"actionCancel\": \"");
        a4.append(this.f36937g);
        a4.append("\",\n                \"actionTitle\": \"");
        a4.append(this.f36934d);
        a4.append("\",\n                \"actionDescription\": \"");
        a4.append(this.f36935e);
        a4.append("\",\n                \"redirectURL\": \"");
        a4.append(this.f36933c);
        a4.append("\",\n                \"actionConfirm\": \"");
        a4.append(this.f36936f);
        a4.append("\"\n            }\n        }\n    ");
        trimIndent = kotlin.text.f.trimIndent(a4.toString());
        return trimIndent;
    }
}
