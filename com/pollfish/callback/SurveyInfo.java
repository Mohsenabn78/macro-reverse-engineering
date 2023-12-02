package com.pollfish.callback;

import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u0000 -2\u00020\u0001:\u0001\u001aBM\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0006J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\b\u0010\u0006J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u000b\u0010\u0006J\u0012\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\f\u0010\u0006Jd\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0016\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0006R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001b\u001a\u0004\b\u001e\u0010\u0006R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u001b\u001a\u0004\b \u0010\u0006R\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0019\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b%\u0010\"\u001a\u0004\b&\u0010$R\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b'\u0010\u001b\u001a\u0004\b(\u0010\u0006R\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b)\u0010\u001b\u001a\u0004\b*\u0010\u0006¨\u0006."}, d2 = {"Lcom/pollfish/callback/SurveyInfo;", "", "", "toString", "", "component1", "()Ljava/lang/Integer;", "component2", "component3", "component4", "component5", "component6", "component7", "surveyCPA", "surveyIR", "surveyLOI", "surveyClass", "rewardName", "rewardValue", "remainingCompletes", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/pollfish/callback/SurveyInfo;", "hashCode", "other", "", "equals", "a", "Ljava/lang/Integer;", "getSurveyCPA", "b", "getSurveyIR", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "getSurveyLOI", "d", "Ljava/lang/String;", "getSurveyClass", "()Ljava/lang/String;", "e", "getRewardName", "f", "getRewardValue", "g", "getRemainingCompletes", MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "Companion", "pollfish_googleplayRelease"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class SurveyInfo {
    @NotNull
    public static final a Companion = new a();
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final Integer f36673a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final Integer f36674b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final Integer f36675c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final String f36676d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final String f36677e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final Integer f36678f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final Integer f36679g;

    /* loaded from: classes6.dex */
    public static final class a {
    }

    public SurveyInfo(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable String str, @Nullable String str2, @Nullable Integer num4, @Nullable Integer num5) {
        this.f36673a = num;
        this.f36674b = num2;
        this.f36675c = num3;
        this.f36676d = str;
        this.f36677e = str2;
        this.f36678f = num4;
        this.f36679g = num5;
    }

    public static /* synthetic */ SurveyInfo copy$default(SurveyInfo surveyInfo, Integer num, Integer num2, Integer num3, String str, String str2, Integer num4, Integer num5, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            num = surveyInfo.f36673a;
        }
        if ((i4 & 2) != 0) {
            num2 = surveyInfo.f36674b;
        }
        Integer num6 = num2;
        if ((i4 & 4) != 0) {
            num3 = surveyInfo.f36675c;
        }
        Integer num7 = num3;
        if ((i4 & 8) != 0) {
            str = surveyInfo.f36676d;
        }
        String str3 = str;
        if ((i4 & 16) != 0) {
            str2 = surveyInfo.f36677e;
        }
        String str4 = str2;
        if ((i4 & 32) != 0) {
            num4 = surveyInfo.f36678f;
        }
        Integer num8 = num4;
        if ((i4 & 64) != 0) {
            num5 = surveyInfo.f36679g;
        }
        return surveyInfo.copy(num, num6, num7, str3, str4, num8, num5);
    }

    @Nullable
    public final Integer component1() {
        return this.f36673a;
    }

    @Nullable
    public final Integer component2() {
        return this.f36674b;
    }

    @Nullable
    public final Integer component3() {
        return this.f36675c;
    }

    @Nullable
    public final String component4() {
        return this.f36676d;
    }

    @Nullable
    public final String component5() {
        return this.f36677e;
    }

    @Nullable
    public final Integer component6() {
        return this.f36678f;
    }

    @Nullable
    public final Integer component7() {
        return this.f36679g;
    }

    @NotNull
    public final SurveyInfo copy(@Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3, @Nullable String str, @Nullable String str2, @Nullable Integer num4, @Nullable Integer num5) {
        return new SurveyInfo(num, num2, num3, str, str2, num4, num5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SurveyInfo)) {
            return false;
        }
        SurveyInfo surveyInfo = (SurveyInfo) obj;
        if (Intrinsics.areEqual(this.f36673a, surveyInfo.f36673a) && Intrinsics.areEqual(this.f36674b, surveyInfo.f36674b) && Intrinsics.areEqual(this.f36675c, surveyInfo.f36675c) && Intrinsics.areEqual(this.f36676d, surveyInfo.f36676d) && Intrinsics.areEqual(this.f36677e, surveyInfo.f36677e) && Intrinsics.areEqual(this.f36678f, surveyInfo.f36678f) && Intrinsics.areEqual(this.f36679g, surveyInfo.f36679g)) {
            return true;
        }
        return false;
    }

    @Nullable
    public final Integer getRemainingCompletes() {
        return this.f36679g;
    }

    @Nullable
    public final String getRewardName() {
        return this.f36677e;
    }

    @Nullable
    public final Integer getRewardValue() {
        return this.f36678f;
    }

    @Nullable
    public final Integer getSurveyCPA() {
        return this.f36673a;
    }

    @Nullable
    public final String getSurveyClass() {
        return this.f36676d;
    }

    @Nullable
    public final Integer getSurveyIR() {
        return this.f36674b;
    }

    @Nullable
    public final Integer getSurveyLOI() {
        return this.f36675c;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        Integer num = this.f36673a;
        int i4 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        int i5 = hashCode * 31;
        Integer num2 = this.f36674b;
        if (num2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = num2.hashCode();
        }
        int i6 = (i5 + hashCode2) * 31;
        Integer num3 = this.f36675c;
        if (num3 == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = num3.hashCode();
        }
        int i7 = (i6 + hashCode3) * 31;
        String str = this.f36676d;
        if (str == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = str.hashCode();
        }
        int i8 = (i7 + hashCode4) * 31;
        String str2 = this.f36677e;
        if (str2 == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = str2.hashCode();
        }
        int i9 = (i8 + hashCode5) * 31;
        Integer num4 = this.f36678f;
        if (num4 == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = num4.hashCode();
        }
        int i10 = (i9 + hashCode6) * 31;
        Integer num5 = this.f36679g;
        if (num5 != null) {
            i4 = num5.hashCode();
        }
        return i10 + i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0048, code lost:
        if (r1 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x006b, code lost:
        if (r1 == null) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00ba, code lost:
        if (r1 == null) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0026, code lost:
        if (r1 == null) goto L38;
     */
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String toString() {
        /*
            r6 = this;
            java.lang.String r0 = "SurveyInfo : [\n"
            java.lang.StringBuilder r0 = com.pollfish.internal.u4.a(r0)
            java.lang.Integer r1 = r6.f36673a
            r2 = 10
            java.lang.String r3 = ""
            if (r1 == 0) goto L28
            int r1 = r1.intValue()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "\tsurveyCPA: "
            r4.append(r5)
            r4.append(r1)
            r4.append(r2)
            java.lang.String r1 = r4.toString()
            if (r1 != 0) goto L29
        L28:
            r1 = r3
        L29:
            r0.append(r1)
            java.lang.Integer r1 = r6.f36674b
            if (r1 == 0) goto L4a
            int r1 = r1.intValue()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "\tsurveyIR: "
            r4.append(r5)
            r4.append(r1)
            r4.append(r2)
            java.lang.String r1 = r4.toString()
            if (r1 != 0) goto L4b
        L4a:
            r1 = r3
        L4b:
            r0.append(r1)
            java.lang.Integer r1 = r6.f36675c
            if (r1 == 0) goto L6d
            r1.intValue()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "\tsurveyLOI: "
            r1.append(r4)
            java.lang.Integer r4 = r6.f36675c
            r1.append(r4)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            if (r1 != 0) goto L6e
        L6d:
            r1 = r3
        L6e:
            r0.append(r1)
            java.lang.String r1 = r6.f36676d
            if (r1 == 0) goto L83
            java.lang.String r1 = "\tsurveyClass: "
            java.lang.StringBuilder r1 = com.pollfish.internal.u4.a(r1)
            java.lang.String r4 = r6.f36676d
            java.lang.String r1 = com.pollfish.internal.g5.a(r1, r4, r2)
            if (r1 != 0) goto L84
        L83:
            r1 = r3
        L84:
            r0.append(r1)
            java.lang.String r1 = r6.f36677e
            if (r1 == 0) goto L99
            java.lang.String r1 = "\trewardName: "
            java.lang.StringBuilder r1 = com.pollfish.internal.u4.a(r1)
            java.lang.String r4 = r6.f36677e
            java.lang.String r1 = com.pollfish.internal.g5.a(r1, r4, r2)
            if (r1 != 0) goto L9a
        L99:
            r1 = r3
        L9a:
            r0.append(r1)
            java.lang.Integer r1 = r6.f36678f
            if (r1 == 0) goto Lbc
            r1.intValue()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "\trewardValue: "
            r1.append(r4)
            java.lang.Integer r4 = r6.f36678f
            r1.append(r4)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            if (r1 != 0) goto Lbd
        Lbc:
            r1 = r3
        Lbd:
            r0.append(r1)
            java.lang.Integer r1 = r6.f36679g
            if (r1 == 0) goto Le1
            r1.intValue()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = "\tremainingCompletes: "
            r1.append(r4)
            java.lang.Integer r4 = r6.f36679g
            r1.append(r4)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            if (r1 != 0) goto Le0
            goto Le1
        Le0:
            r3 = r1
        Le1:
            r1 = 93
            java.lang.String r0 = com.pollfish.internal.g5.a(r0, r3, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pollfish.callback.SurveyInfo.toString():java.lang.String");
    }
}
