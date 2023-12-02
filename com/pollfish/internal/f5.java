package com.pollfish.internal;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class f5 implements a5 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final x4 f36838a;

    public f5(@NotNull x4 x4Var) {
        this.f36838a = x4Var;
    }

    @Override // com.pollfish.internal.a5
    @NotNull
    public final String a() {
        return "";
    }

    @Override // com.pollfish.internal.a5
    @NotNull
    public final String b() {
        return "/v2/device/set/survey/hidden";
    }

    @Override // com.pollfish.internal.a5
    @NotNull
    public final x4 c() {
        return this.f36838a;
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof f5) && Intrinsics.areEqual(this.f36838a, ((f5) obj).f36838a)) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f36838a.hashCode();
    }

    @NotNull
    public final String toString() {
        StringBuilder a4 = u4.a("SurveyHiddenParams(configuration=");
        a4.append(this.f36838a);
        a4.append(')');
        return a4.toString();
    }
}
