package com.arlosoft.macrodroid.triggers.receivers;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.os.PowerManager;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.BluetoothTrigger;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class BluetoothTriggerReceiver extends BroadcastReceiver {
    private boolean b(BluetoothDevice bluetoothDevice, BluetoothTrigger bluetoothTrigger) {
        if (bluetoothDevice == null || bluetoothTrigger == null) {
            return false;
        }
        String name = bluetoothDevice.getName();
        String deviceName = bluetoothTrigger.getDeviceName();
        if (name == null || deviceName == null) {
            return false;
        }
        if ((!name.equals(deviceName) || bluetoothTrigger.getDeviceAddress() != null) && (bluetoothTrigger.getDeviceAddress() == null || !bluetoothTrigger.getDeviceAddress().equals(bluetoothDevice.getAddress()))) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(ArrayList arrayList, PowerManager.WakeLock wakeLock) {
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                Macro macro = (Macro) it.next();
                macro.invokeActions(macro.getTriggerContextInfo());
            }
        } finally {
            if (wakeLock.isHeld()) {
                wakeLock.release();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:129:0x0043, code lost:
        continue;
     */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onReceive(android.content.Context r17, android.content.Intent r18) {
        /*
            Method dump skipped, instructions count: 560
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.triggers.receivers.BluetoothTriggerReceiver.onReceive(android.content.Context, android.content.Intent):void");
    }
}
