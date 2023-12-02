package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.action.info.ExitActionBlockActionInfo;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.ContinuePausedActionsHandler;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ExitActionBlockAction.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class ExitActionBlockAction extends Action {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ExitActionBlockAction> CREATOR = new Parcelable.Creator<ExitActionBlockAction>() { // from class: com.arlosoft.macrodroid.action.ExitActionBlockAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ExitActionBlockAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new ExitActionBlockAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public ExitActionBlockAction[] newArray(int i4) {
            return new ExitActionBlockAction[i4];
        }
    };

    public /* synthetic */ ExitActionBlockAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return ExitActionBlockActionInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean hasOptions() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
        MacroStore macroStore = MacroStore.getInstance();
        Intrinsics.checkNotNull(macroStore, "null cannot be cast to non-null type com.arlosoft.macrodroid.macro.ActionBlockStore");
        ActionBlock actionBlockByGuid = macroStore.getActionBlockByGuid(getMacro().getGUID());
        if (actionBlockByGuid != null) {
            actionBlockByGuid.cancelActiveMacro(getContext());
            ContinuePausedActionsHandler.cancelAlarmsForMacro(getContext(), actionBlockByGuid);
            return;
        }
        SystemLog.logWarning("Failed to exit current action block");
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
    }

    public ExitActionBlockAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public ExitActionBlockAction() {
    }

    private ExitActionBlockAction(Parcel parcel) {
        super(parcel);
    }

    /* compiled from: ExitActionBlockAction.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }
}
