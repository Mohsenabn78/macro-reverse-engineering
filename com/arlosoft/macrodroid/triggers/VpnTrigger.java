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
import com.arlosoft.macrodroid.triggers.info.VpnTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.VpnChangeReceiver;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.Arrays;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VpnTrigger.kt */
@StabilityInferred(parameters = 0)
@TargetApi(21)
/* loaded from: classes3.dex */
public final class VpnTrigger extends Trigger {
    private static final int OPTION_DISABLED = 1;
    private static final int OPTION_ENABLED = 0;
    private static int triggerCount;
    @Nullable
    private static VpnChangeReceiver vpnChangeTriggerReceiver;
    private int option;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<VpnTrigger> CREATOR = new Parcelable.Creator<VpnTrigger>() { // from class: com.arlosoft.macrodroid.triggers.VpnTrigger$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public VpnTrigger createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new VpnTrigger(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public VpnTrigger[] newArray(int i4) {
            return new VpnTrigger[i4];
        }
    };

    public /* synthetic */ VpnTrigger(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final String[] getOptions() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String r4 = SelectableItem.r(R.string.enabled);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.enabled)");
        String format = String.format(r4, Arrays.copyOf(new Object[0], 0));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        String r5 = SelectableItem.r(R.string.disabled);
        Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.disabled)");
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
                MacroDroidApplication.Companion.getInstance().unregisterReceiver(vpnChangeTriggerReceiver);
            } catch (Exception e4) {
                FirebaseCrashlytics.getInstance().recordException(e4);
            }
            vpnChangeTriggerReceiver = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (triggerCount == 0) {
            vpnChangeTriggerReceiver = new VpnChangeReceiver();
            MacroDroidApplication.Companion.getInstance().registerReceiver(vpnChangeTriggerReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
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
        return VpnTriggerInfo.Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String getListModeName() {
        String name = getName();
        String extendedDetail = getExtendedDetail();
        return name + " (" + extendedDetail + ")";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @Nullable
    public String[] o() {
        return getOptions();
    }

    public final boolean triggerOnEnabled() {
        if (this.option == 0) {
            return true;
        }
        return false;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.option);
    }

    public VpnTrigger(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public VpnTrigger() {
    }

    private VpnTrigger(Parcel parcel) {
        super(parcel);
        this.option = parcel.readInt();
    }

    /* compiled from: VpnTrigger.kt */
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
