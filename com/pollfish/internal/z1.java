package com.pollfish.internal;

import com.pollfish.builder.Params;
import com.pollfish.builder.Position;
import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class z1 {

    /* loaded from: classes6.dex */
    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f37370a;

        static {
            int[] iArr = new int[Position.values().length];
            try {
                iArr[Position.TOP_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Position.MIDDLE_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Position.BOTTOM_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Position.TOP_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Position.MIDDLE_RIGHT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[Position.BOTTOM_RIGHT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f37370a = iArr;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0041, code lost:
        if (r7 == false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
        if (r7.length() == 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0053, code lost:
        if (r10 != false) goto L28;
     */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final com.pollfish.callback.SurveyInfo a(@org.jetbrains.annotations.NotNull java.lang.String r10) {
        /*
            r0 = 0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: org.json.JSONException -> L77
            r1.<init>(r10)     // Catch: org.json.JSONException -> L77
            java.lang.String r10 = "survey_price"
            int r10 = r1.getInt(r10)     // Catch: org.json.JSONException -> L12
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch: org.json.JSONException -> L12
            r3 = r10
            goto L13
        L12:
            r3 = r0
        L13:
            java.lang.String r10 = "survey_ir"
            int r10 = r1.getInt(r10)     // Catch: org.json.JSONException -> L1f
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch: org.json.JSONException -> L1f
            r4 = r10
            goto L20
        L1f:
            r4 = r0
        L20:
            java.lang.String r10 = "survey_loi"
            int r10 = r1.getInt(r10)     // Catch: org.json.JSONException -> L2c
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch: org.json.JSONException -> L2c
            r5 = r10
            goto L2d
        L2c:
            r5 = r0
        L2d:
            r10 = 0
            r2 = 1
            java.lang.String r6 = "survey_class"
            java.lang.String r6 = r1.getString(r6)     // Catch: org.json.JSONException -> L43
            if (r6 == 0) goto L40
            int r7 = r6.length()     // Catch: org.json.JSONException -> L43
            if (r7 != 0) goto L3e
            goto L40
        L3e:
            r7 = 0
            goto L41
        L40:
            r7 = 1
        L41:
            if (r7 == 0) goto L44
        L43:
            r6 = r0
        L44:
            java.lang.String r7 = "reward_name"
            java.lang.String r7 = r1.getString(r7)     // Catch: org.json.JSONException -> L55
            if (r7 == 0) goto L52
            int r8 = r7.length()     // Catch: org.json.JSONException -> L55
            if (r8 != 0) goto L53
        L52:
            r10 = 1
        L53:
            if (r10 == 0) goto L56
        L55:
            r7 = r0
        L56:
            java.lang.String r10 = "reward_value"
            int r10 = r1.getInt(r10)     // Catch: org.json.JSONException -> L62
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch: org.json.JSONException -> L62
            r8 = r10
            goto L63
        L62:
            r8 = r0
        L63:
            java.lang.String r10 = "remaining_completes"
            int r10 = r1.getInt(r10)     // Catch: org.json.JSONException -> L6f
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch: org.json.JSONException -> L6f
            r9 = r10
            goto L70
        L6f:
            r9 = r0
        L70:
            com.pollfish.callback.SurveyInfo r10 = new com.pollfish.callback.SurveyInfo     // Catch: org.json.JSONException -> L77
            r2 = r10
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)     // Catch: org.json.JSONException -> L77
            r0 = r10
        L77:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pollfish.internal.z1.a(java.lang.String):com.pollfish.callback.SurveyInfo");
    }

    @NotNull
    public static final int a(@NotNull Position position) {
        switch (a.f37370a[position.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return 1;
            case 4:
            case 5:
            case 6:
                return 2;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public static final t2 a(@NotNull Params params) {
        return new t2(params.getPollfishOpenedListener(), params.getPollfishClosedListener(), params.getPollfishSurveyCompletedListener(), params.getPollfishSurveyReceivedListener(), params.getPollfishSurveyNotAvailableListener(), params.getPollfishUserNotEligibleListener(), params.getPollfishUserRejectedSurveyListener());
    }
}
