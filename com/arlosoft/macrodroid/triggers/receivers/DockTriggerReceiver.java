package com.arlosoft.macrodroid.triggers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.DockTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class DockTriggerReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean z3;
        int intExtra = intent.getIntExtra("android.intent.extra.DOCK_STATE", -1);
        boolean z4 = false;
        if (intExtra == 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        z4 = (intExtra == 1 || intExtra == 3 || intExtra == 4) ? true : true;
        ArrayList arrayList = new ArrayList();
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (true) {
                if (it.hasNext()) {
                    Trigger next = it.next();
                    if (next instanceof DockTrigger) {
                        int dockType = ((DockTrigger) next).getDockType();
                        if ((intExtra == 0 && dockType == 3) || ((intExtra != 0 && dockType == 0) || ((z3 && dockType == 2) || (z4 && dockType == 1)))) {
                            if (next.constraintsMet()) {
                                macro.setTriggerThatInvoked(next);
                                if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                    arrayList.add(macro);
                                    break;
                                }
                            } else {
                                continue;
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
}
