package com.arlosoft.macrodroid.triggers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.TimerTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class AlarmReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ArrayList arrayList = new ArrayList();
        String stringExtra = intent.getStringExtra(TimerTrigger.EXTRA_ALARM_ID);
        SystemLog.logVerbose("Alarm fired: " + stringExtra);
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (true) {
                if (it.hasNext()) {
                    Trigger next = it.next();
                    if (next instanceof TimerTrigger) {
                        TimerTrigger timerTrigger = (TimerTrigger) next;
                        if (stringExtra != null && stringExtra.equals(timerTrigger.getRequestId())) {
                            if (next.constraintsMet()) {
                                macro.setTriggerThatInvoked(next);
                                if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                    arrayList.add(macro);
                                }
                            }
                            timerTrigger.scheduleNextAlarm(false);
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
