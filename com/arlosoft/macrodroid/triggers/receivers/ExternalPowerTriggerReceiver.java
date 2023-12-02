package com.arlosoft.macrodroid.triggers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.ExternalPowerTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class ExternalPowerTriggerReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static int f15314a = -99;
    public static boolean hasIgnoredFirst = false;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        intent.getAction();
        int intExtra = intent.getIntExtra("plugged", -1);
        if (intExtra == f15314a) {
            return;
        }
        f15314a = intExtra;
        if (!hasIgnoredFirst) {
            hasIgnoredFirst = true;
            return;
        }
        if (intExtra != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (intExtra == 4) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (intExtra == 2) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (intExtra == 1) {
            z6 = true;
        } else {
            z6 = false;
        }
        if (z3) {
            SystemLog.logVerbose("Power connected - chargePlug = " + intExtra);
        } else {
            SystemLog.logVerbose("Power disconnected");
        }
        ArrayList arrayList = new ArrayList();
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (true) {
                if (it.hasNext()) {
                    Trigger next = it.next();
                    if (next instanceof ExternalPowerTrigger) {
                        ExternalPowerTrigger externalPowerTrigger = (ExternalPowerTrigger) next;
                        boolean[] powerConnectedOptions = externalPowerTrigger.getPowerConnectedOptions();
                        if (externalPowerTrigger.getPowerConnected() == z3 && (!z3 || (((z8 = powerConnectedOptions[0]) && z6) || (((z9 = powerConnectedOptions[1]) && z4) || (((z10 = powerConnectedOptions[2]) && z5) || (z8 && z9 && z10)))))) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        if (z7 && next.constraintsMet()) {
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
}
