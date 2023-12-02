package com.arlosoft.macrodroid.triggers;

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
import com.arlosoft.macrodroid.triggers.info.UsbDeviceConnectionTriggerInfo;
import com.arlosoft.macrodroid.triggers.receivers.UsbDeviceConnectionReceiver;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: UsbDeviceConnectionTrigger.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class UsbDeviceConnectionTrigger extends Trigger {
    private static int triggerCount;
    @Nullable
    private static UsbDeviceConnectionReceiver usbDeviceConnectionTriggerReceiver;
    private int option;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @JvmField
    @NotNull
    public static final Parcelable.Creator<UsbDeviceConnectionTrigger> CREATOR = new Parcelable.Creator<UsbDeviceConnectionTrigger>() { // from class: com.arlosoft.macrodroid.triggers.UsbDeviceConnectionTrigger$Companion$CREATOR$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public UsbDeviceConnectionTrigger createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new UsbDeviceConnectionTrigger(parcel, (DefaultConstructorMarker) null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public UsbDeviceConnectionTrigger[] newArray(int i4) {
            return new UsbDeviceConnectionTrigger[i4];
        }
    };

    public /* synthetic */ UsbDeviceConnectionTrigger(Parcel parcel, DefaultConstructorMarker defaultConstructorMarker) {
        this(parcel);
    }

    private final String[] getOptions() {
        String r4 = SelectableItem.r(R.string.trigger_usb_device_connected);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.trigger_usb_device_connected)");
        String r5 = SelectableItem.r(R.string.trigger_usb_device_disconnected);
        Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.trigg…_usb_device_disconnected)");
        return new String[]{r4, r5};
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
                MacroDroidApplication.Companion.getInstance().unregisterReceiver(usbDeviceConnectionTriggerReceiver);
            } catch (Exception e4) {
                FirebaseCrashlytics.getInstance().recordException(e4);
            }
            usbDeviceConnectionTriggerReceiver = null;
        }
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    public void enableTrigger() {
        if (triggerCount == 0) {
            usbDeviceConnectionTriggerReceiver = new UsbDeviceConnectionReceiver();
            IntentFilter intentFilter = new IntentFilter("android.hardware.usb.action.USB_DEVICE_ATTACHED");
            intentFilter.addAction("android.hardware.usb.action.USB_DEVICE_DETACHED");
            intentFilter.addAction("android.hardware.usb.action.USB_ACCESSORY_ATTACHED");
            intentFilter.addAction("android.hardware.usb.action.USB_ACCESSORY_DETACHED");
            MacroDroidApplication.Companion.getInstance().registerReceiver(usbDeviceConnectionTriggerReceiver, intentFilter);
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
    public String getConfiguredName() {
        return getOptions()[this.option];
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public SelectableItemInfo getInfo() {
        return UsbDeviceConnectionTriggerInfo.Companion.getInstance();
    }

    public final int getOption() {
        return this.option;
    }

    @Override // com.arlosoft.macrodroid.triggers.Trigger
    @Nullable
    public TriggerContextInfo getTestTriggerContentInfo() {
        return TriggerContextInfo.createUsbTriggerContextInfo(this, "test product name", "test manufacturer name", "999");
    }

    public final boolean isOpen() {
        if (this.option == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    @NotNull
    public String[] o() {
        return getOptions();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel out, int i4) {
        Intrinsics.checkNotNullParameter(out, "out");
        super.writeToParcel(out, i4);
        out.writeInt(this.option);
    }

    public UsbDeviceConnectionTrigger(@Nullable Activity activity, @Nullable Macro macro) {
        this();
        setActivity(activity);
        this.m_macro = macro;
    }

    public UsbDeviceConnectionTrigger() {
    }

    private UsbDeviceConnectionTrigger(Parcel parcel) {
        super(parcel);
        this.option = parcel.readInt();
    }

    /* compiled from: UsbDeviceConnectionTrigger.kt */
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
