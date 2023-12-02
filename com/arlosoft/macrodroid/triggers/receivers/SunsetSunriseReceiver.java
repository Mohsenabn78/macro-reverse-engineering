package com.arlosoft.macrodroid.triggers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.SunriseSunsetTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class SunsetSunriseReceiver extends BroadcastReceiver {
    public static final String EXTRA_IS_SUNRISE = "is_sunrise";
    public static final String EXTRA_TRIGGER_GUID = "trigger_guid";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Context context2;
        boolean booleanExtra = intent.getBooleanExtra(EXTRA_IS_SUNRISE, false);
        long longExtra = intent.getLongExtra(EXTRA_TRIGGER_GUID, 0L);
        Macro macro = null;
        for (Macro macro2 : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro2.getTriggerListWithAwaitingActions().iterator();
            while (it.hasNext()) {
                Trigger next = it.next();
                if (next.getSIGUID() == longExtra) {
                    SunriseSunsetTrigger sunriseSunsetTrigger = (SunriseSunsetTrigger) next;
                    if (((sunriseSunsetTrigger.getOption() == 0 && booleanExtra) || (sunriseSunsetTrigger.getOption() == 1 && !booleanExtra)) && macro2.canInvoke(macro2.getTriggerContextInfo())) {
                        long currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis > sunriseSunsetTrigger.getLastTriggered() + 5000 && next.constraintsMet()) {
                            macro2.setTriggerThatInvoked(next);
                            sunriseSunsetTrigger.setLastTriggered(currentTimeMillis);
                            context2 = context;
                            macro = macro2;
                            sunriseSunsetTrigger.scheduleWakeup(context2);
                        }
                    }
                    context2 = context;
                    sunriseSunsetTrigger.scheduleWakeup(context2);
                }
            }
        }
        if (macro != null) {
            macro.invokeActions(macro.getTriggerContextInfo());
        }
    }
}
