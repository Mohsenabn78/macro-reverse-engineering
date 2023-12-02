package com.arlosoft.macrodroid.actionblock.list;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ActionBlockListViewModel.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes.dex */
public abstract class ActionBlockEvent {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final ActionBlock f5589a;

    /* compiled from: ActionBlockListViewModel.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes.dex */
    public static final class AddNewBlock extends ActionBlockEvent {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddNewBlock(@NotNull ActionBlock actionBlock) {
            super(actionBlock, null);
            Intrinsics.checkNotNullParameter(actionBlock, "actionBlock");
        }
    }

    /* compiled from: ActionBlockListViewModel.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes.dex */
    public static final class OpenActionBlock extends ActionBlockEvent {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OpenActionBlock(@NotNull ActionBlock actionBlock) {
            super(actionBlock, null);
            Intrinsics.checkNotNullParameter(actionBlock, "actionBlock");
        }
    }

    /* compiled from: ActionBlockListViewModel.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes.dex */
    public static final class ShowActionBlockMenu extends ActionBlockEvent {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowActionBlockMenu(@NotNull ActionBlock actionBlock) {
            super(actionBlock, null);
            Intrinsics.checkNotNullParameter(actionBlock, "actionBlock");
        }
    }

    public /* synthetic */ ActionBlockEvent(ActionBlock actionBlock, DefaultConstructorMarker defaultConstructorMarker) {
        this(actionBlock);
    }

    @NotNull
    public final ActionBlock getActionBlock() {
        return this.f5589a;
    }

    private ActionBlockEvent(ActionBlock actionBlock) {
        this.f5589a = actionBlock;
    }
}
