package com.arlosoft.macrodroid.events;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ShowActionBlockTestSummaryEvent.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class ShowActionBlockTestSummaryEvent {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final ActionBlock f11986a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final List<MacroDroidVariable> f11987b;

    public ShowActionBlockTestSummaryEvent(@NotNull ActionBlock actionBlock, @NotNull List<MacroDroidVariable> outputVars) {
        Intrinsics.checkNotNullParameter(actionBlock, "actionBlock");
        Intrinsics.checkNotNullParameter(outputVars, "outputVars");
        this.f11986a = actionBlock;
        this.f11987b = outputVars;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ShowActionBlockTestSummaryEvent copy$default(ShowActionBlockTestSummaryEvent showActionBlockTestSummaryEvent, ActionBlock actionBlock, List list, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            actionBlock = showActionBlockTestSummaryEvent.f11986a;
        }
        if ((i4 & 2) != 0) {
            list = showActionBlockTestSummaryEvent.f11987b;
        }
        return showActionBlockTestSummaryEvent.copy(actionBlock, list);
    }

    @NotNull
    public final ActionBlock component1() {
        return this.f11986a;
    }

    @NotNull
    public final List<MacroDroidVariable> component2() {
        return this.f11987b;
    }

    @NotNull
    public final ShowActionBlockTestSummaryEvent copy(@NotNull ActionBlock actionBlock, @NotNull List<MacroDroidVariable> outputVars) {
        Intrinsics.checkNotNullParameter(actionBlock, "actionBlock");
        Intrinsics.checkNotNullParameter(outputVars, "outputVars");
        return new ShowActionBlockTestSummaryEvent(actionBlock, outputVars);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ShowActionBlockTestSummaryEvent)) {
            return false;
        }
        ShowActionBlockTestSummaryEvent showActionBlockTestSummaryEvent = (ShowActionBlockTestSummaryEvent) obj;
        if (Intrinsics.areEqual(this.f11986a, showActionBlockTestSummaryEvent.f11986a) && Intrinsics.areEqual(this.f11987b, showActionBlockTestSummaryEvent.f11987b)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final ActionBlock getActionBlock() {
        return this.f11986a;
    }

    @NotNull
    public final List<MacroDroidVariable> getOutputVars() {
        return this.f11987b;
    }

    public int hashCode() {
        return (this.f11986a.hashCode() * 31) + this.f11987b.hashCode();
    }

    @NotNull
    public String toString() {
        ActionBlock actionBlock = this.f11986a;
        List<MacroDroidVariable> list = this.f11987b;
        return "ShowActionBlockTestSummaryEvent(actionBlock=" + actionBlock + ", outputVars=" + list + ")";
    }
}
