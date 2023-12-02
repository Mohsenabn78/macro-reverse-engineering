package com.arlosoft.macrodroid.triggers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.BatteryTemperatureTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class BatteryTemperatureTriggerReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static int f15310a = -1;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
            int intExtra = intent.getIntExtra("temperature", 0) / 10;
            int i4 = f15310a;
            if (i4 >= 0 && i4 != intExtra) {
                ArrayList arrayList = new ArrayList();
                for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                    Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
                    while (it.hasNext()) {
                        Trigger next = it.next();
                        if (next instanceof BatteryTemperatureTrigger) {
                            BatteryTemperatureTrigger batteryTemperatureTrigger = (BatteryTemperatureTrigger) next;
                            boolean z3 = true;
                            if (batteryTemperatureTrigger.getOption() == 1 && next.constraintsMet()) {
                                macro.setTriggerThatInvoked(next);
                                if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                    arrayList.add(macro);
                                }
                            } else if (batteryTemperatureTrigger.getOption() == 0) {
                                if (f15310a <= intExtra) {
                                    z3 = false;
                                }
                                if (batteryTemperatureTrigger.getDecreasesTo() && z3) {
                                    if (f15310a > batteryTemperatureTrigger.getTemperature() && intExtra <= batteryTemperatureTrigger.getTemperature() && next.constraintsMet()) {
                                        macro.setTriggerThatInvoked(next);
                                        if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                            arrayList.add(macro);
                                        }
                                    }
                                } else if (!batteryTemperatureTrigger.getDecreasesTo() && !z3 && f15310a < batteryTemperatureTrigger.getTemperature() && intExtra >= batteryTemperatureTrigger.getTemperature() && next.constraintsMet()) {
                                    macro.setTriggerThatInvoked(next);
                                    if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                        arrayList.add(macro);
                                    }
                                }
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
            f15310a = intExtra;
        }
    }
}
