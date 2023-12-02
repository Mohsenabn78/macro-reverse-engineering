package com.arlosoft.macrodroid.triggers.receivers;

import android.content.Context;
import android.content.Intent;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.WeatherTrigger;
import com.arlosoft.macrodroid.triggers.services.WeatherService;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class RequestWeatherReceiver extends WakefulBroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
                while (it.hasNext()) {
                    if (it.next() instanceof WeatherTrigger) {
                        WakefulBroadcastReceiver.startWakefulService(context, new Intent(context, WeatherService.class));
                        return;
                    }
                }
            }
        } catch (IllegalStateException e4) {
            SystemLog.logError("Could not request weather data - foreground service not enabled? " + e4.toString());
        }
    }
}
