package com.arlosoft.macrodroid.triggers.receivers.widget;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Vibrator;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.action.VibrateAction;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.WidgetPressedTrigger;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class WidgetPressedService extends Service {
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i4, int i5) {
        int i6;
        boolean z3;
        super.onStart(intent, i5);
        String action = intent.getAction();
        if (action == null) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("The action was null in WidgetPressedService"));
            return 3;
        }
        if (action.equals(WidgetPressedTrigger.getWidgetTypes()[1])) {
            i6 = 0;
        } else if (action.equals(WidgetPressedTrigger.getWidgetTypes()[2])) {
            i6 = 1;
        } else if (action.equals(WidgetPressedTrigger.getWidgetTypes()[3])) {
            i6 = 2;
        } else if (action.equals(WidgetPressedTrigger.getWidgetTypes()[4])) {
            i6 = 3;
        } else {
            i6 = 4;
        }
        ArrayList arrayList = new ArrayList();
        FirebaseAnalyticsEventLogger.log("Widget Pressed");
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (true) {
                if (it.hasNext()) {
                    Trigger next = it.next();
                    if ((next instanceof WidgetPressedTrigger) && ((WidgetPressedTrigger) next).getWidgetType() == i6) {
                        if (i6 == 4) {
                            try {
                                if (macro.getGUID() == MacroDroidWidgetConfigureActivity.y(this, Integer.valueOf(action.substring(action.indexOf(44) + 1)).intValue()) && next.constraintsMet()) {
                                    macro.setTriggerThatInvoked(next);
                                    if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                        arrayList.add(macro);
                                    }
                                }
                            } catch (Exception unused) {
                                SystemLog.logError("Failed to identify widget id from action: " + action);
                            }
                        } else if (next.constraintsMet()) {
                            macro.setTriggerThatInvoked(next);
                            if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                arrayList.add(macro);
                            }
                        }
                    }
                }
            }
        }
        boolean widgetButtonVibrateOnPress = Settings.getWidgetButtonVibrateOnPress(this);
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Macro macro2 = (Macro) it2.next();
            if (widgetButtonVibrateOnPress) {
                Iterator<Action> it3 = macro2.getActions().iterator();
                while (it3.hasNext()) {
                    if (it3.next() instanceof VibrateAction) {
                        z3 = false;
                        break;
                    }
                }
            }
            z3 = widgetButtonVibrateOnPress;
            if (z3) {
                ((Vibrator) getSystemService("vibrator")).vibrate(new long[]{0, 40}, -1);
            }
            macro2.invokeActions(macro2.getTriggerContextInfo());
        }
        stopSelf(i5);
        return 3;
    }
}
