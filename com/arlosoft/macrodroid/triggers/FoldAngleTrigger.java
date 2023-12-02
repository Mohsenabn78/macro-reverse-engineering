package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.info.FoldAngleTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.HingeEventListener;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FoldAngleTrigger.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class FoldAngleTrigger extends Trigger {
    public static final int OPTION_CLOSED = 1;
    public static final int OPTION_CLOSED_TO_90 = 4;
    public static final int OPTION_HALF_OPEN = 2;
    public static final int OPTION_OPEN = 0;
    public static final int OPTION_OPEN_TO_90 = 3;
    @Nullable
    private static HingeEventListener hingeEventListener;
    private static int triggerCount;
    private int option;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<FoldAngleTrigger> CREATOR = new Parcelable.Creator<FoldAngleTrigger>() { // from class: com.arlosoft.macrodroid.triggers.FoldAngleTrigger$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public FoldAngleTrigger createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FoldAngleTrigger(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public FoldAngleTrigger[] newArray(int i4) {
            return new FoldAngleTrigger[i4];
        }
    };

    public /* synthetic */ FoldAngleTrigger(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(FoldAngleTrigger this$0, HingeEventListener.HingeState hingeState) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(hingeState, "hingeState");
        this$0.O(hingeState);
    }

    private final void O(HingeEventListener.HingeState hingeState) {
        ArrayList arrayList = new ArrayList();
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (it.hasNext()) {
                Trigger next = it.next();
                if ((next instanceof FoldAngleTrigger) && P((FoldAngleTrigger) next, hingeState) && next.constraintsMet()) {
                    macro.setTriggerThatInvoked(next);
                    if (macro.canInvoke(macro.getTriggerContextInfo())) {
                        arrayList.add(macro);
                    }
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Macro macro2 = (Macro) it2.next();
            macro2.invokeActions(macro2.getTriggerContextInfo());
        }
    }

    private final boolean P(FoldAngleTrigger foldAngleTrigger, HingeEventListener.HingeState hingeState) {
        int option = foldAngleTrigger.getOption();
        if (option != 0) {
            if (option != 1) {
                if (option != 2) {
                    if (option != 3) {
                        if (option != 4 || hingeState != HingeEventListener.HingeState.CLOSED_TO_90) {
                            return false;
                        }
                    } else if (hingeState != HingeEventListener.HingeState.OPEN_TO_90) {
                        return false;
                    }
                } else if (hingeState != HingeEventListener.HingeState.OPEN_TO_90 && hingeState != HingeEventListener.HingeState.CLOSED_TO_90) {
                    return false;
                }
            } else if (hingeState != HingeEventListener.HingeState.CLOSED) {
                return false;
            }
        } else if (hingeState != HingeEventListener.HingeState.OPEN) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.option = i4;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
        int i4 = triggerCount - 1;
        triggerCount = i4;
        if (i4 == 0) {
            if (hingeEventListener != null) {
                Object systemService = getContext().getSystemService("sensor");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
                ((SensorManager) systemService).unregisterListener(hingeEventListener);
            }
            hingeEventListener = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (triggerCount == 0) {
            if (Build.VERSION.SDK_INT < 30) {
                SystemLog.logError("Fold Angle is not supported on this device");
            } else {
                hingeEventListener = new HingeEventListener(getContext(), new HingeEventListener.OnHingeChangeListener() { // from class: com.arlosoft.macrodroid.triggers.e3
                    @Override // com.arlosoft.macrodroid.triggers.receivers.HingeEventListener.OnHingeChangeListener
                    public final void onHingeChange(HingeEventListener.HingeState hingeState) {
                        FoldAngleTrigger.N(FoldAngleTrigger.this, hingeState);
                    }
                });
                Object systemService = getContext().getSystemService("sensor");
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.hardware.SensorManager");
                SensorManager sensorManager = (SensorManager) systemService;
                sensorManager.registerListener(hingeEventListener, sensorManager.getDefaultSensor(36), 3);
            }
        }
        triggerCount++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        return this.option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        String str = Companion.a()[this.option];
        Intrinsics.checkNotNullExpressionValue(str, "getOptions()[option]");
        return str;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return FoldAngleTriggerInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getListModeName() {
        String configuredName = getConfiguredName();
        String extendedDetail = getExtendedDetail();
        return configuredName + " (" + extendedDetail + ")";
    }

    public final int getOption() {
        return this.option;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String[] o() {
        return Companion.a();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.option);
    }

    public FoldAngleTrigger(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public FoldAngleTrigger() {
    }

    private FoldAngleTrigger(Parcel parcel) {
        super(parcel);
        this.option = parcel.readInt();
    }

    /* compiled from: FoldAngleTrigger.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final String[] a() {
            return new String[]{SelectableItem.r(R.string.trigger_fold_state_open), SelectableItem.r(R.string.trigger_fold_state_closed), SelectableItem.r(R.string.trigger_half_open_90_degrees), SelectableItem.r(R.string.trigger_fold_state_open_to_90), SelectableItem.r(R.string.trigger_fold_state_closed_to_90)};
        }

        public static /* synthetic */ void getCREATOR$annotations() {
        }
    }
}
