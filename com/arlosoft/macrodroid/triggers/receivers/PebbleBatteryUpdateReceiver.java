package com.arlosoft.macrodroid.triggers.receivers;

import android.content.Context;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.PebbleTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.getpebble.android.kit.PebbleKit;
import com.getpebble.android.kit.util.PebbleDictionary;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

/* loaded from: classes3.dex */
public class PebbleBatteryUpdateReceiver extends PebbleKit.PebbleDataReceiver {

    /* renamed from: b  reason: collision with root package name */
    private static int f15336b = -1;

    public PebbleBatteryUpdateReceiver(UUID uuid) {
        super(uuid);
    }

    public static int getLastKnownBatteryLevel() {
        return f15336b;
    }

    @Override // com.getpebble.android.kit.PebbleKit.PebbleDataReceiver
    public void receiveData(Context context, int i4, PebbleDictionary pebbleDictionary) {
        int i5;
        boolean z3;
        PebbleKit.sendAckToPebble(MacroDroidApplication.getInstance(), i4);
        if (pebbleDictionary.contains(2)) {
            int intValue = pebbleDictionary.getInteger(2).intValue();
            ArrayList arrayList = new ArrayList();
            for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Trigger next = it.next();
                        if ((next instanceof PebbleTrigger) && next.constraintsMet()) {
                            PebbleTrigger pebbleTrigger = (PebbleTrigger) next;
                            if (pebbleTrigger.getOption() == 3 && (i5 = f15336b) >= 0 && i5 != intValue) {
                                if (i5 > intValue) {
                                    z3 = true;
                                } else {
                                    z3 = false;
                                }
                                if (pebbleTrigger.getDecreasesTo() && z3) {
                                    if (f15336b > pebbleTrigger.getBatteryLevel() && intValue <= pebbleTrigger.getBatteryLevel()) {
                                        macro.setTriggerThatInvoked(next);
                                        if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                            arrayList.add(macro);
                                        }
                                    }
                                } else if (!pebbleTrigger.getDecreasesTo() && !z3 && f15336b < pebbleTrigger.getBatteryLevel() && intValue >= pebbleTrigger.getBatteryLevel()) {
                                    macro.setTriggerThatInvoked(next);
                                    if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                        arrayList.add(macro);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            f15336b = intValue;
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Macro macro2 = (Macro) it2.next();
                macro2.invokeActions(macro2.getTriggerContextInfo());
            }
        }
    }
}
