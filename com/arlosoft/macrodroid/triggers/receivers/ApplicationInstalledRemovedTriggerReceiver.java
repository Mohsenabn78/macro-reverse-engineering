package com.arlosoft.macrodroid.triggers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.ApplicationInstalledRemovedTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class ApplicationInstalledRemovedTriggerReceiver extends BroadcastReceiver {
    private boolean a(ApplicationInstalledRemovedTrigger applicationInstalledRemovedTrigger, String str) {
        if (applicationInstalledRemovedTrigger.getAnyApplication()) {
            return true;
        }
        for (String str2 : applicationInstalledRemovedTrigger.getPackageNameList()) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean equals = intent.getAction().equals("android.intent.action.PACKAGE_ADDED");
        boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
        String dataString = intent.getDataString();
        if (dataString.startsWith("package:")) {
            dataString = dataString.substring(8);
        }
        ArrayList arrayList = new ArrayList();
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (true) {
                if (it.hasNext()) {
                    Trigger next = it.next();
                    if (next instanceof ApplicationInstalledRemovedTrigger) {
                        ApplicationInstalledRemovedTrigger applicationInstalledRemovedTrigger = (ApplicationInstalledRemovedTrigger) next;
                        if (applicationInstalledRemovedTrigger.getApplicationUpdated()) {
                            if (equals && booleanExtra && a(applicationInstalledRemovedTrigger, dataString) && next.constraintsMet()) {
                                macro.setTriggerThatInvoked(next);
                                macro.setTriggerContextInfo(new TriggerContextInfo(next, dataString));
                                if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                    arrayList.add(macro);
                                }
                            }
                        } else if (applicationInstalledRemovedTrigger.getApplicationInstalled() == equals && !booleanExtra && a(applicationInstalledRemovedTrigger, dataString) && next.constraintsMet()) {
                            macro.setTriggerThatInvoked(next);
                            macro.setTriggerContextInfo(new TriggerContextInfo(next, dataString));
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
}
