package com.arlosoft.macrodroid.editscreen;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.SelectableItem;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: AllSelectableItemsListAdapter.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public abstract class ItemType {
    public static final int $stable = 0;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final ViewType f11802a;

    /* renamed from: b  reason: collision with root package name */
    private final long f11803b;

    /* compiled from: AllSelectableItemsListAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class Action extends ItemType implements HasSelectableItem {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        private final com.arlosoft.macrodroid.action.Action f11804c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f11805d;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Action(@org.jetbrains.annotations.NotNull com.arlosoft.macrodroid.action.Action r5, boolean r6) {
            /*
                r4 = this;
                java.lang.String r0 = "action"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                if (r6 == 0) goto La
                com.arlosoft.macrodroid.editscreen.ViewType r0 = com.arlosoft.macrodroid.editscreen.ViewType.SELECTABLE_ITEM_ACTION_LAST
                goto Lc
            La:
                com.arlosoft.macrodroid.editscreen.ViewType r0 = com.arlosoft.macrodroid.editscreen.ViewType.SELECTABLE_ITEM_ACTION
            Lc:
                long r1 = r5.getSIGUID()
                r3 = 0
                r4.<init>(r0, r1, r3)
                r4.f11804c = r5
                r4.f11805d = r6
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.editscreen.ItemType.Action.<init>(com.arlosoft.macrodroid.action.Action, boolean):void");
        }

        @NotNull
        public final com.arlosoft.macrodroid.action.Action getAction() {
            return this.f11804c;
        }

        @Override // com.arlosoft.macrodroid.editscreen.HasSelectableItem
        @NotNull
        public SelectableItem getSelectableItem() {
            return this.f11804c;
        }

        public final boolean isLastItem() {
            return this.f11805d;
        }

        public final void setLastItem(boolean z3) {
            this.f11805d = z3;
        }
    }

    /* compiled from: AllSelectableItemsListAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class ActionHeader extends ItemType {
        public static final int $stable = 0;
        @NotNull
        public static final ActionHeader INSTANCE = new ActionHeader();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private ActionHeader() {
            /*
                r4 = this;
                com.arlosoft.macrodroid.editscreen.ViewType r0 = com.arlosoft.macrodroid.editscreen.ViewType.ACTION_HEADER
                int r1 = r0.getId()
                long r1 = (long) r1
                r3 = 0
                r4.<init>(r0, r1, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.editscreen.ItemType.ActionHeader.<init>():void");
        }
    }

    /* compiled from: AllSelectableItemsListAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class ActionsEmpty extends ItemType {
        public static final int $stable = 0;
        @NotNull
        public static final ActionsEmpty INSTANCE = new ActionsEmpty();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private ActionsEmpty() {
            /*
                r4 = this;
                com.arlosoft.macrodroid.editscreen.ViewType r0 = com.arlosoft.macrodroid.editscreen.ViewType.ACTION_EMPTY
                int r1 = r0.getId()
                long r1 = (long) r1
                r3 = 0
                r4.<init>(r0, r1, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.editscreen.ItemType.ActionsEmpty.<init>():void");
        }
    }

    /* compiled from: AllSelectableItemsListAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class Constraint extends ItemType implements HasSelectableItem {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        private final com.arlosoft.macrodroid.constraint.Constraint f11806c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f11807d;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Constraint(@org.jetbrains.annotations.NotNull com.arlosoft.macrodroid.constraint.Constraint r5, boolean r6) {
            /*
                r4 = this;
                java.lang.String r0 = "constraint"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                if (r6 == 0) goto La
                com.arlosoft.macrodroid.editscreen.ViewType r0 = com.arlosoft.macrodroid.editscreen.ViewType.SELECTABLE_ITEM_CONSTRAINT_LAST
                goto Lc
            La:
                com.arlosoft.macrodroid.editscreen.ViewType r0 = com.arlosoft.macrodroid.editscreen.ViewType.SELECTABLE_ITEM_CONSTRAINT
            Lc:
                long r1 = r5.getSIGUID()
                r3 = 0
                r4.<init>(r0, r1, r3)
                r4.f11806c = r5
                r4.f11807d = r6
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.editscreen.ItemType.Constraint.<init>(com.arlosoft.macrodroid.constraint.Constraint, boolean):void");
        }

        @NotNull
        public final com.arlosoft.macrodroid.constraint.Constraint getConstraint() {
            return this.f11806c;
        }

        @Override // com.arlosoft.macrodroid.editscreen.HasSelectableItem
        @NotNull
        public SelectableItem getSelectableItem() {
            return this.f11806c;
        }

        public final boolean isLastItem() {
            return this.f11807d;
        }
    }

    /* compiled from: AllSelectableItemsListAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class ConstraintHeader extends ItemType {
        public static final int $stable = 0;
        @NotNull
        public static final ConstraintHeader INSTANCE = new ConstraintHeader();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private ConstraintHeader() {
            /*
                r4 = this;
                com.arlosoft.macrodroid.editscreen.ViewType r0 = com.arlosoft.macrodroid.editscreen.ViewType.CONSTRAINT_HEADER
                int r1 = r0.getId()
                long r1 = (long) r1
                r3 = 0
                r4.<init>(r0, r1, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.editscreen.ItemType.ConstraintHeader.<init>():void");
        }
    }

    /* compiled from: AllSelectableItemsListAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class ConstraintsEmpty extends ItemType {
        public static final int $stable = 0;
        @NotNull
        public static final ConstraintsEmpty INSTANCE = new ConstraintsEmpty();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private ConstraintsEmpty() {
            /*
                r4 = this;
                com.arlosoft.macrodroid.editscreen.ViewType r0 = com.arlosoft.macrodroid.editscreen.ViewType.CONSTRAINT_EMPTY
                int r1 = r0.getId()
                long r1 = (long) r1
                r3 = 0
                r4.<init>(r0, r1, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.editscreen.ItemType.ConstraintsEmpty.<init>():void");
        }
    }

    /* compiled from: AllSelectableItemsListAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class LocalVariable extends ItemType {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        private final MacroDroidVariable f11808c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f11809d;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public LocalVariable(@org.jetbrains.annotations.NotNull com.arlosoft.macrodroid.common.MacroDroidVariable r5, boolean r6) {
            /*
                r4 = this;
                java.lang.String r0 = "localVariable"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                if (r6 == 0) goto La
                com.arlosoft.macrodroid.editscreen.ViewType r0 = com.arlosoft.macrodroid.editscreen.ViewType.LOCAL_VARIABLE_ITEM_LAST
                goto Lc
            La:
                com.arlosoft.macrodroid.editscreen.ViewType r0 = com.arlosoft.macrodroid.editscreen.ViewType.LOCAL_VARIABLE_ITEM
            Lc:
                r1 = 999(0x3e7, double:4.936E-321)
                r3 = 0
                r4.<init>(r0, r1, r3)
                r4.f11808c = r5
                r4.f11809d = r6
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.editscreen.ItemType.LocalVariable.<init>(com.arlosoft.macrodroid.common.MacroDroidVariable, boolean):void");
        }

        @NotNull
        public final MacroDroidVariable getLocalVariable() {
            return this.f11808c;
        }

        public final boolean isLastItem() {
            return this.f11809d;
        }
    }

    /* compiled from: AllSelectableItemsListAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class LocalVariableHeader extends ItemType {
        public static final int $stable = 0;
        @NotNull
        public static final LocalVariableHeader INSTANCE = new LocalVariableHeader();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private LocalVariableHeader() {
            /*
                r4 = this;
                com.arlosoft.macrodroid.editscreen.ViewType r0 = com.arlosoft.macrodroid.editscreen.ViewType.LOCAL_VARIABLE_HEADER
                int r1 = r0.getId()
                long r1 = (long) r1
                r3 = 0
                r4.<init>(r0, r1, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.editscreen.ItemType.LocalVariableHeader.<init>():void");
        }
    }

    /* compiled from: AllSelectableItemsListAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class LocalVariablesEmpty extends ItemType {
        public static final int $stable = 0;
        @NotNull
        public static final LocalVariablesEmpty INSTANCE = new LocalVariablesEmpty();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private LocalVariablesEmpty() {
            /*
                r4 = this;
                com.arlosoft.macrodroid.editscreen.ViewType r0 = com.arlosoft.macrodroid.editscreen.ViewType.LOCAL_VARIABLE_EMPTY
                int r1 = r0.getId()
                long r1 = (long) r1
                r3 = 0
                r4.<init>(r0, r1, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.editscreen.ItemType.LocalVariablesEmpty.<init>():void");
        }
    }

    /* compiled from: AllSelectableItemsListAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class Trigger extends ItemType implements HasSelectableItem {
        public static final int $stable = 8;
        @NotNull

        /* renamed from: c  reason: collision with root package name */
        private final com.arlosoft.macrodroid.triggers.Trigger f11810c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f11811d;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public Trigger(@org.jetbrains.annotations.NotNull com.arlosoft.macrodroid.triggers.Trigger r5, boolean r6) {
            /*
                r4 = this;
                java.lang.String r0 = "trigger"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
                if (r6 == 0) goto La
                com.arlosoft.macrodroid.editscreen.ViewType r0 = com.arlosoft.macrodroid.editscreen.ViewType.SELECTABLE_ITEM_TRIGGER_LAST
                goto Lc
            La:
                com.arlosoft.macrodroid.editscreen.ViewType r0 = com.arlosoft.macrodroid.editscreen.ViewType.SELECTABLE_ITEM_TRIGGER
            Lc:
                long r1 = r5.getSIGUID()
                r3 = 0
                r4.<init>(r0, r1, r3)
                r4.f11810c = r5
                r4.f11811d = r6
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.editscreen.ItemType.Trigger.<init>(com.arlosoft.macrodroid.triggers.Trigger, boolean):void");
        }

        @Override // com.arlosoft.macrodroid.editscreen.HasSelectableItem
        @NotNull
        public SelectableItem getSelectableItem() {
            return this.f11810c;
        }

        @NotNull
        public final com.arlosoft.macrodroid.triggers.Trigger getTrigger() {
            return this.f11810c;
        }

        public final boolean isLastItem() {
            return this.f11811d;
        }
    }

    /* compiled from: AllSelectableItemsListAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class TriggerHeader extends ItemType {
        public static final int $stable = 0;
        @NotNull
        public static final TriggerHeader INSTANCE = new TriggerHeader();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private TriggerHeader() {
            /*
                r4 = this;
                com.arlosoft.macrodroid.editscreen.ViewType r0 = com.arlosoft.macrodroid.editscreen.ViewType.TRIGGER_HEADER
                int r1 = r0.getId()
                long r1 = (long) r1
                r3 = 0
                r4.<init>(r0, r1, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.editscreen.ItemType.TriggerHeader.<init>():void");
        }
    }

    /* compiled from: AllSelectableItemsListAdapter.kt */
    @StabilityInferred(parameters = 0)
    /* loaded from: classes3.dex */
    public static final class TriggersEmpty extends ItemType {
        public static final int $stable = 0;
        @NotNull
        public static final TriggersEmpty INSTANCE = new TriggersEmpty();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private TriggersEmpty() {
            /*
                r4 = this;
                com.arlosoft.macrodroid.editscreen.ViewType r0 = com.arlosoft.macrodroid.editscreen.ViewType.TRIGGER_EMPTY
                int r1 = r0.getId()
                long r1 = (long) r1
                r3 = 0
                r4.<init>(r0, r1, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.editscreen.ItemType.TriggersEmpty.<init>():void");
        }
    }

    public /* synthetic */ ItemType(ViewType viewType, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewType, j4);
    }

    public final long getId() {
        return this.f11803b;
    }

    @NotNull
    public final ViewType getViewType() {
        return this.f11802a;
    }

    private ItemType(ViewType viewType, long j4) {
        this.f11802a = viewType;
        this.f11803b = j4;
    }
}
