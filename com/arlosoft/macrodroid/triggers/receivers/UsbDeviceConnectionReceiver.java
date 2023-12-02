package com.arlosoft.macrodroid.triggers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.hardware.usb.UsbAccessory;
import android.hardware.usb.UsbDevice;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.triggers.UsbDeviceConnectionTrigger;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.description.type.TypeDescription;
import org.jetbrains.annotations.Nullable;

/* compiled from: UsbDeviceConnectionReceiver.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class UsbDeviceConnectionReceiver extends BroadcastReceiver {
    public static final int $stable = 0;

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        String action;
        boolean z3;
        UsbDevice usbDevice;
        TriggerContextInfo createUsbTriggerContextInfo;
        if (intent != null && (action = intent.getAction()) != null) {
            if (!Intrinsics.areEqual(action, "android.hardware.usb.action.USB_DEVICE_ATTACHED") && !Intrinsics.areEqual(action, "android.hardware.usb.action.USB_ACCESSORY_ATTACHED")) {
                z3 = false;
            } else {
                z3 = true;
            }
            int hashCode = action.hashCode();
            UsbAccessory usbAccessory = null;
            if (hashCode == -2114103349 ? !action.equals("android.hardware.usb.action.USB_DEVICE_ATTACHED") : !(hashCode == -1608292967 && action.equals("android.hardware.usb.action.USB_DEVICE_DETACHED"))) {
                usbDevice = null;
            } else {
                usbDevice = (UsbDevice) intent.getParcelableExtra("device");
            }
            int hashCode2 = action.hashCode();
            if (hashCode2 == 1099555123 ? action.equals("android.hardware.usb.action.USB_ACCESSORY_ATTACHED") : hashCode2 == 1605365505 && action.equals("android.hardware.usb.action.USB_ACCESSORY_DETACHED")) {
                usbAccessory = (UsbAccessory) intent.getParcelableExtra("accessory");
            }
            ArrayList<Macro> arrayList = new ArrayList();
            for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
                while (it.hasNext()) {
                    Trigger next = it.next();
                    if (next instanceof UsbDeviceConnectionTrigger) {
                        String str = "";
                        String str2 = TypeDescription.Generic.OfWildcardType.SYMBOL;
                        if (usbDevice != null) {
                            String productName = usbDevice.getProductName();
                            if (productName != null) {
                                str2 = productName;
                            }
                            String manufacturerName = usbDevice.getManufacturerName();
                            if (manufacturerName != null) {
                                str = manufacturerName;
                            }
                            createUsbTriggerContextInfo = TriggerContextInfo.createUsbTriggerContextInfo(next, str2, str, String.valueOf(usbDevice.hashCode()));
                        } else if (usbAccessory != null) {
                            String model2 = usbAccessory.getModel();
                            if (model2 != null) {
                                str2 = model2;
                            }
                            String manufacturer = usbAccessory.getManufacturer();
                            if (manufacturer != null) {
                                str = manufacturer;
                            }
                            createUsbTriggerContextInfo = TriggerContextInfo.createUsbTriggerContextInfo(next, str2, str, "0");
                        } else {
                            createUsbTriggerContextInfo = TriggerContextInfo.createUsbTriggerContextInfo(next, TypeDescription.Generic.OfWildcardType.SYMBOL, "", "0");
                        }
                        if (next.constraintsMet(createUsbTriggerContextInfo)) {
                            UsbDeviceConnectionTrigger usbDeviceConnectionTrigger = (UsbDeviceConnectionTrigger) next;
                            if ((usbDeviceConnectionTrigger.getOption() == 0 && z3) || (usbDeviceConnectionTrigger.getOption() == 1 && !z3)) {
                                macro.setTriggerThatInvoked(next);
                                macro.setTriggerContextInfo(createUsbTriggerContextInfo);
                                if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                    Intrinsics.checkNotNullExpressionValue(macro, "macro");
                                    arrayList.add(macro);
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            for (Macro macro2 : arrayList) {
                macro2.invokeActions(macro2.getTriggerContextInfo());
            }
        }
    }
}
