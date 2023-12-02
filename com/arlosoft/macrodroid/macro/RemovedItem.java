package com.arlosoft.macrodroid.macro;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.SelectableItem;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: RemovedItem.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public abstract class RemovedItem {
    public static final int $stable = 8;

    /* renamed from: a  reason: collision with root package name */
    private final int f12851a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final SelectableItem f12852b;

    /* compiled from: RemovedItem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class ChildConstraint extends RemovedItem {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        private final SelectableItem f12853c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChildConstraint(@NotNull SelectableItem parent, int i4, @NotNull SelectableItem constraint) {
            super(i4, constraint, null);
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(constraint, "constraint");
            this.f12853c = parent;
        }

        @NotNull
        public final SelectableItem getParent() {
            return this.f12853c;
        }
    }

    /* compiled from: RemovedItem.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class StandardItem extends RemovedItem {
        public static final int $stable = 0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public StandardItem(int i4, @NotNull SelectableItem standardItem) {
            super(i4, standardItem, null);
            Intrinsics.checkNotNullParameter(standardItem, "standardItem");
        }
    }

    public /* synthetic */ RemovedItem(int i4, SelectableItem selectableItem, DefaultConstructorMarker defaultConstructorMarker) {
        this(i4, selectableItem);
    }

    public final int getIndex() {
        return this.f12851a;
    }

    @NotNull
    public final SelectableItem getItem() {
        return this.f12852b;
    }

    private RemovedItem(int i4, SelectableItem selectableItem) {
        this.f12851a = i4;
        this.f12852b = selectableItem;
    }
}
