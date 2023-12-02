package com.arlosoft.macrodroid.triggers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.BatteryLevelTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class BatteryLevelTriggerReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static int f15309a = -1;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        intent.getIntExtra("temperature", 0);
        if (action.equals("android.intent.action.BATTERY_CHANGED")) {
            int intExtra = (intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, 0) * 100) / intent.getIntExtra("scale", 100);
            int i4 = f15309a;
            if (i4 >= 0 && i4 != intExtra) {
                ArrayList arrayList = new ArrayList();
                for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                    Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
                    while (it.hasNext()) {
                        Trigger next = it.next();
                        if (next instanceof BatteryLevelTrigger) {
                            BatteryLevelTrigger batteryLevelTrigger = (BatteryLevelTrigger) next;
                            boolean z3 = true;
                            if (batteryLevelTrigger.getOption() == 1 && next.constraintsMet()) {
                                macro.setTriggerThatInvoked(next);
                                if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                    arrayList.add(macro);
                                }
                            } else if (batteryLevelTrigger.getOption() == 0) {
                                if (f15309a <= intExtra) {
                                    z3 = false;
                                }
                                if (batteryLevelTrigger.getDecreasesTo() && z3) {
                                    if (f15309a > batteryLevelTrigger.getBatteryLevel() && intExtra <= batteryLevelTrigger.getBatteryLevel() && next.constraintsMet()) {
                                        macro.setTriggerThatInvoked(next);
                                        if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                            arrayList.add(macro);
                                        }
                                    }
                                } else if (!batteryLevelTrigger.getDecreasesTo() && !z3 && f15309a < batteryLevelTrigger.getBatteryLevel() && intExtra >= batteryLevelTrigger.getBatteryLevel() && next.constraintsMet()) {
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
            f15309a = intExtra;
        }
    }
}
