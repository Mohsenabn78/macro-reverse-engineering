package com.arlosoft.macrodroid.uiinteraction;

import androidx.compose.animation.a;
import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UIInteractionResult.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class UIInteractionResult {
    public static final int $stable = 0;

    /* renamed from: a  reason: collision with root package name */
    private final int f15858a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f15859b;

    /* renamed from: c  reason: collision with root package name */
    private final long f15860c;

    public UIInteractionResult(int i4, boolean z3, long j4) {
        this.f15858a = i4;
        this.f15859b = z3;
        this.f15860c = j4;
    }

    public static /* synthetic */ UIInteractionResult copy$default(UIInteractionResult uIInteractionResult, int i4, boolean z3, long j4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i4 = uIInteractionResult.f15858a;
        }
        if ((i5 & 2) != 0) {
            z3 = uIInteractionResult.f15859b;
        }
        if ((i5 & 4) != 0) {
            j4 = uIInteractionResult.f15860c;
        }
        return uIInteractionResult.copy(i4, z3, j4);
    }

    public final int component1() {
        return this.f15858a;
    }

    public final boolean component2() {
        return this.f15859b;
    }

    public final long component3() {
        return this.f15860c;
    }

    @NotNull
    public final UIInteractionResult copy(int i4, boolean z3, long j4) {
        return new UIInteractionResult(i4, z3, j4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UIInteractionResult)) {
            return false;
        }
        UIInteractionResult uIInteractionResult = (UIInteractionResult) obj;
        if (this.f15858a == uIInteractionResult.f15858a && this.f15859b == uIInteractionResult.f15859b && this.f15860c == uIInteractionResult.f15860c) {
            return true;
        }
        return false;
    }

    public final int getRequestId() {
        return this.f15858a;
    }

    public final boolean getResult() {
        return this.f15859b;
    }

    public final long getTimeTaken() {
        return this.f15860c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i4 = this.f15858a * 31;
        boolean z3 = this.f15859b;
        int i5 = z3;
        if (z3 != 0) {
            i5 = 1;
        }
        return ((i4 + i5) * 31) + a.a(this.f15860c);
    }

    @NotNull
    public String toString() {
        int i4 = this.f15858a;
        boolean z3 = this.f15859b;
        long j4 = this.f15860c;
        return "UIInteractionResult(requestId=" + i4 + ", result=" + z3 + ", timeTaken=" + j4 + ")";
    }
}
