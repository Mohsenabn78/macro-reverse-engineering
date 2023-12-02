package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.MacroDroidService;
import com.arlosoft.macrodroid.action.info.DisableMacrodroidActionInfo;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.MacroDroidDisabledEvent;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.triggers.services.FloatingTextService;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: DisableMacroDroidAction.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class DisableMacroDroidAction extends Action {
    private int state;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<DisableMacroDroidAction> CREATOR = new Parcelable.Creator<DisableMacroDroidAction>() { // from class: com.arlosoft.macrodroid.action.DisableMacroDroidAction$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public DisableMacroDroidAction createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new DisableMacroDroidAction(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public DisableMacroDroidAction[] newArray(int i4) {
            return new DisableMacroDroidAction[i4];
        }
    };

    public /* synthetic */ DisableMacroDroidAction(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return DisableMacrodroidActionInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean hasOptions() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.action.Action
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
        FloatingTextService.Companion companion = FloatingTextService.Companion;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        companion.stopService(context);
        MacroDroidService.Companion companion2 = MacroDroidService.Companion;
        Context applicationContext = getContext().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        companion2.stopService(applicationContext);
        Settings.setMacroDroidEnabled(getContext(), false);
        Macro.setMacroDroidEnabledState(false);
        MacroStore.getInstance().updateEnabledStateOfAllCompletedMacros();
        EventBusUtils.getEventBus().post(new MacroDroidDisabledEvent());
    }

    @Override // com.arlosoft.macrodroid.action.Action, com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.state);
    }

    public DisableMacroDroidAction(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public DisableMacroDroidAction() {
    }

    private DisableMacroDroidAction(Parcel parcel) {
        super(parcel);
        this.state = parcel.readInt();
    }

    /* compiled from: DisableMacroDroidAction.kt */
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
