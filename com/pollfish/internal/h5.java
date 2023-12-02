package com.pollfish.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class h5 implements a5 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final x4 f36908a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    public final Integer f36909b;

    public h5(@NotNull x4 x4Var, @Nullable Integer num) {
        this.f36908a = x4Var;
        this.f36909b = num;
    }

    @Override // com.pollfish.internal.a5
    @NotNull
    public final String a() {
        String trimIndent;
        Integer num = this.f36909b;
        if (num != null) {
            num.intValue();
            trimIndent = kotlin.text.f.trimIndent("\n                { \"s_id\": " + this.f36909b + " }\n            ");
            if (trimIndent != null) {
                return trimIndent;
            }
        }
        return "";
    }

    @Override // com.pollfish.internal.a5
    @NotNull
    public final String b() {
        if (this.f36908a.f37314e) {
            return "/v2/device/set/session/viewed";
        }
        return "/v2/device/set/survey/viewed";
    }

    @Override // com.pollfish.internal.a5
    @NotNull
    public final x4 c() {
        return this.f36908a;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h5)) {
            return false;
        }
        h5 h5Var = (h5) obj;
        if (Intrinsics.areEqual(this.f36908a, h5Var.f36908a) && Intrinsics.areEqual(this.f36909b, h5Var.f36909b)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2 = this.f36908a.hashCode() * 31;
        Integer num = this.f36909b;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("SurveyViewedParams(configuration=");
        a4.append(this.f36908a);
        a4.append(", surveyId=");
        a4.append(this.f36909b);
        a4.append(')');
        return a4.toString();
    }
}
