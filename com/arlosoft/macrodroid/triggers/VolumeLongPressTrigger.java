package com.arlosoft.macrodroid.triggers;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.appcompat.app.AlertDialog;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.ListenForVolumeLongPressEvent;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.root.RootToolsHelper;
import com.arlosoft.macrodroid.triggers.info.VolumeLongPressTriggerInfo;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VolumeLongPressedTrigger.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class VolumeLongPressTrigger extends Trigger {
    private boolean isNew;
    private int option;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<VolumeLongPressTrigger> CREATOR = new Parcelable.Creator<VolumeLongPressTrigger>() { // from class: com.arlosoft.macrodroid.triggers.VolumeLongPressTrigger$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public VolumeLongPressTrigger createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VolumeLongPressTrigger(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public VolumeLongPressTrigger[] newArray(int i4) {
            return new VolumeLongPressTrigger[i4];
        }
    };

    public /* synthetic */ VolumeLongPressTrigger(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(VolumeLongPressTrigger this$0, DialogInterface dialogInterface, int i4) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        super.onItemSelected();
    }

    private final String[] getOptions() {
        String r4 = SelectableItem.r(R.string.trigger_volume_button_up);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.trigger_volume_button_up)");
        String r5 = SelectableItem.r(R.string.trigger_volume_button_down);
        Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.trigger_volume_button_down)");
        return new String[]{r4, r5};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void C(int i4) {
        this.option = i4;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (ContextCompat.checkSelfPermission(getContext(), "android.permission.SET_VOLUME_KEY_LONG_PRESS_LISTENER") != 0 && RootToolsHelper.isAccessGiven()) {
            Util.runAsRoot(new String[]{"pm grant com.arlosoft.macrodroid android.permission.SET_VOLUME_KEY_LONG_PRESS_LISTENER"});
        }
        EventBusUtils.getEventBus().post(new ListenForVolumeLongPressEvent());
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
        return VolumeLongPressTriggerInfo.Companion.getInstance();
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
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void onEditScreenClosed() {
        if (isEnabled() && getMacro().isEnabled() && ContextCompat.checkSelfPermission(getContext(), "android.permission.SET_VOLUME_KEY_LONG_PRESS_LISTENER") == 0) {
            EventBusUtils.getEventBus().post(new ListenForVolumeLongPressEvent());
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void onItemSelected() {
        if (this.isNew) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), m());
            builder.setMessage(R.string.trigger_volume_long_press_warning);
            builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() { // from class: com.arlosoft.macrodroid.triggers.p9
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i4) {
                    VolumeLongPressTrigger.N(VolumeLongPressTrigger.this, dialogInterface, i4);
                }
            });
            builder.show();
            return;
        }
        super.onItemSelected();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public boolean requiresNotificationAccess() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.triggers.Trigger, com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        this.isNew = false;
        super.secondaryItemConfirmed();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.option);
        out.writeInt(this.isNew ? 1 : 0);
    }

    public VolumeLongPressTrigger(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public VolumeLongPressTrigger() {
        this.isNew = true;
    }

    private VolumeLongPressTrigger(Parcel parcel) {
        super(parcel);
        this.isNew = true;
        this.option = parcel.readInt();
        this.isNew = parcel.readInt() != 0;
    }

    /* compiled from: VolumeLongPressedTrigger.kt */
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

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void disableTrigger() {
    }
}
