package com.arlosoft.macrodroid.triggers;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.IntentFilter;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.SimChangeTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.SimChangeReceiver;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.Arrays;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SimChangeTrigger.kt */
@StabilityInferred(parameters = 0)
@TargetApi(21)
/* loaded from: classes3.dex */
public final class SimChangeTrigger extends Trigger {
    public static final int OPTION_INSERTED = 0;
    public static final int OPTION_REMOVED = 1;
    @Nullable
    private static SimChangeReceiver simChangeTriggerReceiver;
    private static int triggerCount;
    private int option;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SimChangeTrigger> CREATOR = new Parcelable.Creator<SimChangeTrigger>() { // from class: com.arlosoft.macrodroid.triggers.SimChangeTrigger$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SimChangeTrigger createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new SimChangeTrigger(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public SimChangeTrigger[] newArray(int i4) {
            return new SimChangeTrigger[i4];
        }
    };

    public /* synthetic */ SimChangeTrigger(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final String[] getOptions() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String r4 = SelectableItem.r(R.string.trigger_sim_added);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.trigger_sim_added)");
        String format = String.format(r4, Arrays.copyOf(new Object[0], 0));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        String r5 = SelectableItem.r(R.string.trigger_sim_removed);
        Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.trigger_sim_removed)");
        String format2 = String.format(r5, Arrays.copyOf(new Object[0], 0));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        return new String[]{format, format2};
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
            try {
                MacroDroidApplication.Companion.getInstance().unregisterReceiver(simChangeTriggerReceiver);
            } catch (Exception e4) {
                FirebaseCrashlytics.getInstance().recordException(e4);
            }
            simChangeTriggerReceiver = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (triggerCount == 0) {
            SimChangeReceiver.Companion.resetIgnoredState();
            simChangeTriggerReceiver = new SimChangeReceiver();
            MacroDroidApplication.Companion.getInstance().registerReceiver(simChangeTriggerReceiver, new IntentFilter("android.intent.action.SIM_STATE_CHANGED"));
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
        return getOptions()[this.option];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return SimChangeTriggerInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getListModeName() {
        String name = getName();
        String extendedDetail = getExtendedDetail();
        return name + " (" + extendedDetail + ")";
    }

    public final int getTriggerOption() {
        return this.option;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.option);
    }

    public SimChangeTrigger(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public SimChangeTrigger() {
    }

    private SimChangeTrigger(Parcel parcel) {
        super(parcel);
        this.option = parcel.readInt();
    }

    /* compiled from: SimChangeTrigger.kt */
    /* loaded from: classes3.dex */
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
