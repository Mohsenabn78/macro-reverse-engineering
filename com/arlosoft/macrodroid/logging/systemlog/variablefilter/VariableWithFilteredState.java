package com.arlosoft.macrodroid.logging.systemlog.variablefilter;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VariableWithFilteredState.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class VariableWithFilteredState {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final MacroDroidVariable f12795a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f12796b;

    public VariableWithFilteredState(@NotNull MacroDroidVariable variable, boolean z3) {
        Intrinsics.checkNotNullParameter(variable, "variable");
        this.f12795a = variable;
        this.f12796b = z3;
    }

    public static /* synthetic */ VariableWithFilteredState copy$default(VariableWithFilteredState variableWithFilteredState, MacroDroidVariable macroDroidVariable, boolean z3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            macroDroidVariable = variableWithFilteredState.f12795a;
        }
        if ((i4 & 2) != 0) {
            z3 = variableWithFilteredState.f12796b;
        }
        return variableWithFilteredState.copy(macroDroidVariable, z3);
    }

    @NotNull
    public final MacroDroidVariable component1() {
        return this.f12795a;
    }

    public final boolean component2() {
        return this.f12796b;
    }

    @NotNull
    public final VariableWithFilteredState copy(@NotNull MacroDroidVariable variable, boolean z3) {
        Intrinsics.checkNotNullParameter(variable, "variable");
        return new VariableWithFilteredState(variable, z3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VariableWithFilteredState)) {
            return false;
        }
        VariableWithFilteredState variableWithFilteredState = (VariableWithFilteredState) obj;
        if (Intrinsics.areEqual(this.f12795a, variableWithFilteredState.f12795a) && this.f12796b == variableWithFilteredState.f12796b) {
            return true;
        }
        return false;
    }

    @NotNull
    public final MacroDroidVariable getVariable() {
        return this.f12795a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.f12795a.hashCode() * 31;
        boolean z3 = this.f12796b;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        return hashCode + i4;
    }

    public final boolean isEnabled() {
        return this.f12796b;
    }

    @NotNull
    public String toString() {
        MacroDroidVariable macroDroidVariable = this.f12795a;
        boolean z3 = this.f12796b;
        return "VariableWithFilteredState(variable=" + macroDroidVariable + ", isEnabled=" + z3 + ")";
    }
}
