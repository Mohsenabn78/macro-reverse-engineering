package com.arlosoft.macrodroid.triggers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.LocationTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.services.LocationTriggerService;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class RequestLocationReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (it.hasNext()) {
                Trigger next = it.next();
                if ((next instanceof LocationTrigger) && next.constraintsMet() && macro.canInvoke(null)) {
                    context.startService(new Intent(context, LocationTriggerService.class));
                    LocationTrigger.scheduleNextWakeup(context, false);
                    return;
                }
            }
        }
        LocationTrigger.scheduleNextWakeup(context, false);
    }
}
