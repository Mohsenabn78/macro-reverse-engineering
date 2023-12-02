package com.arlosoft.macrodroid.helper.data;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ShellScriptResult.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class ShellScriptResult extends HelperResult {
    public static final int $stable = 0;

    /* renamed from: b  reason: collision with root package name */
    private final int f12290b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final String f12291c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f12292d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShellScriptResult(int i4, @NotNull String resultString, boolean z3) {
        super(i4);
        Intrinsics.checkNotNullParameter(resultString, "resultString");
        this.f12290b = i4;
        this.f12291c = resultString;
        this.f12292d = z3;
    }

    public static /* synthetic */ ShellScriptResult copy$default(ShellScriptResult shellScriptResult, int i4, String str, boolean z3, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = shellScriptResult.f12290b;
        }
        if ((i5 & 2) != 0) {
            str = shellScriptResult.f12291c;
        }
        if ((i5 & 4) != 0) {
            z3 = shellScriptResult.f12292d;
        }
        return shellScriptResult.copy(i4, str, z3);
    }

    public final int component1() {
        return this.f12290b;
    }

    @NotNull
    public final String component2() {
        return this.f12291c;
    }

    public final boolean component3() {
        return this.f12292d;
    }

    @NotNull
    public final ShellScriptResult copy(int i4, @NotNull String resultString, boolean z3) {
        Intrinsics.checkNotNullParameter(resultString, "resultString");
        return new ShellScriptResult(i4, resultString, z3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShellScriptResult)) {
            return false;
        }
        ShellScriptResult shellScriptResult = (ShellScriptResult) obj;
        if (this.f12290b == shellScriptResult.f12290b && Intrinsics.areEqual(this.f12291c, shellScriptResult.f12291c) && this.f12292d == shellScriptResult.f12292d) {
            return true;
        }
        return false;
    }

    public final boolean getDidTimeout() {
        return this.f12292d;
    }

    public final int getRequestId() {
        return this.f12290b;
    }

    @NotNull
    public final String getResultString() {
        return this.f12291c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f12290b * 31) + this.f12291c.hashCode()) * 31;
        boolean z3 = this.f12292d;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        return hashCode + i4;
    }

    @NotNull
    public String toString() {
        int i4 = this.f12290b;
        String str = this.f12291c;
        boolean z3 = this.f12292d;
        return "ShellScriptResult(requestId=" + i4 + ", resultString=" + str + ", didTimeout=" + z3 + ")";
    }
}
