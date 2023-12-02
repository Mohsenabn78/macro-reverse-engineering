package com.arlosoft.macrodroid.triggers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.arlosoft.macrodroid.helper.HelperCommandsKt;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.HotspotTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class HotspotTriggerReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (isInitialStickyBroadcast()) {
            return;
        }
        int intExtra = intent.getIntExtra(HelperCommandsKt.HELPER_OPTION_SET_WIFI_STATE, 0);
        ArrayList arrayList = new ArrayList();
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (it.hasNext()) {
                Trigger next = it.next();
                if (next instanceof HotspotTrigger) {
                    HotspotTrigger hotspotTrigger = (HotspotTrigger) next;
                    if ((hotspotTrigger.getHotspotEnabled() && intExtra - 10 == 3) || (!hotspotTrigger.getHotspotEnabled() && intExtra - 10 == 1)) {
                        if (next.constraintsMet() && macro.canInvoke(macro.getTriggerContextInfo())) {
                            arrayList.add(macro);
                            macro.setTriggerThatInvoked(next);
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
