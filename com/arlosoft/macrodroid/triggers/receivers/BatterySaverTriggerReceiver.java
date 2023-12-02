package com.arlosoft.macrodroid.triggers.receivers;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.BatterySaverTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class BatterySaverTriggerReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    @TargetApi(21)
    public void onReceive(Context context, Intent intent) {
        ArrayList<Macro> arrayList = new ArrayList();
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (it.hasNext()) {
                Trigger next = it.next();
                if (next instanceof BatterySaverTrigger) {
                    BatterySaverTrigger batterySaverTrigger = (BatterySaverTrigger) next;
                    if (batterySaverTrigger.getOption() == 0 && powerManager.isPowerSaveMode() && next.constraintsMet()) {
                        macro.setTriggerThatInvoked(next);
                        if (macro.canInvoke(macro.getTriggerContextInfo())) {
                            arrayList.add(macro);
                        }
                    } else if (batterySaverTrigger.getOption() == 1 && !powerManager.isPowerSaveMode() && next.constraintsMet()) {
                        macro.setTriggerThatInvoked(next);
                        if (macro.canInvoke(macro.getTriggerContextInfo())) {
                            arrayList.add(macro);
                        }
                    }
                }
            }
        }
        for (Macro macro2 : arrayList) {
            macro2.invokeActions(macro2.getTriggerContextInfo());
        }
    }
}
