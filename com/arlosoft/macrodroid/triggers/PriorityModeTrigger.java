package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.info.PriorityModeTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.PriorityModeReceiver;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PriorityModeTrigger.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class PriorityModeTrigger extends Trigger {
    private static int triggerCount;
    private int option;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @NotNull
    private static final PriorityModeReceiver priorityModeReceiver = new PriorityModeReceiver();
    @JvmField
    @NotNull
    public static final Parcelable.Creator<PriorityModeTrigger> CREATOR = new Parcelable.Creator<PriorityModeTrigger>() { // from class: com.arlosoft.macrodroid.triggers.PriorityModeTrigger$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public PriorityModeTrigger createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PriorityModeTrigger(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public PriorityModeTrigger[] newArray(int i4) {
            return new PriorityModeTrigger[i4];
        }
    };

    public /* synthetic */ PriorityModeTrigger(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final String[] M() {
        String r4 = SelectableItem.r(R.string.trigger_priority_mode_all);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.trigger_priority_mode_all)");
        String r5 = SelectableItem.r(R.string.trigger_priority_mode_priority);
        Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.trigger_priority_mode_priority)");
        String r6 = SelectableItem.r(R.string.trigger_priority_mode_none);
        Intrinsics.checkNotNullExpressionValue(r6, "getString(R.string.trigger_priority_mode_none)");
        String r7 = SelectableItem.r(R.string.action_set_priority_mode_alarm_only);
        Intrinsics.checkNotNullExpressionValue(r7, "getString(R.string.actio…priority_mode_alarm_only)");
        return new String[]{r4, r5, r6, r7};
    }

    private final String[] getOptions() {
        String r4 = SelectableItem.r(R.string.trigger_priority_mode_all);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.trigger_priority_mode_all)");
        String r5 = SelectableItem.r(R.string.trigger_priority_mode_priority);
        Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.trigger_priority_mode_priority)");
        String r6 = SelectableItem.r(R.string.trigger_priority_mode_none);
        Intrinsics.checkNotNullExpressionValue(r6, "getString(R.string.trigger_priority_mode_none)");
        return new String[]{r4, r5, r6};
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
                getContext().getApplicationContext().unregisterReceiver(priorityModeReceiver);
            } catch (Exception e4) {
                FirebaseCrashlytics.getInstance().recordException(e4);
            }
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (triggerCount == 0) {
            getContext().getApplicationContext().registerReceiver(priorityModeReceiver, new IntentFilter("android.app.action.INTERRUPTION_FILTER_CHANGED"));
        }
        triggerCount++;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getCheckedItemIndex() {
        if (Build.VERSION.SDK_INT <= 23) {
            return Math.min(this.option, getOptions().length - 1);
        }
        return this.option;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getExtendedDetail() {
        return M()[this.option];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return PriorityModeTriggerInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getListModeName() {
        String name = getName();
        String extendedDetail = getExtendedDetail();
        return name + ": " + extendedDetail;
    }

    public final int getOption() {
        return this.option;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String[] o() {
        if (Build.VERSION.SDK_INT > 23) {
            return M();
        }
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.option);
    }

    public PriorityModeTrigger(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public PriorityModeTrigger() {
    }

    private PriorityModeTrigger(Parcel parcel) {
        super(parcel);
        this.option = parcel.readInt();
    }

    /* compiled from: PriorityModeTrigger.kt */
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
