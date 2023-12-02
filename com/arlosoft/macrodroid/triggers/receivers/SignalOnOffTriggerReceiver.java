package com.arlosoft.macrodroid.triggers.receivers;

import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.CallActiveTrigger;
import com.arlosoft.macrodroid.triggers.SignalOnOffTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.services.CallStateOffHookService;
import com.arlosoft.macrodroid.triggers.services.SignalOnOffTriggerServiceKt;
import com.arlosoft.macrodroid.utils.LastCallHelper;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class SignalOnOffTriggerReceiver extends PhoneStateListener {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f15351a = false;

    @Override // android.telephony.PhoneStateListener
    public void onCallStateChanged(int i4, String str) {
        if (i4 == 2) {
            Intent intent = new Intent(MacroDroidApplication.getInstance(), CallStateOffHookService.class);
            intent.putExtra(SignalOnOffTriggerServiceKt.EXTRA_LAST_CALL_NUMBER_KEY, LastCallHelper.lastCallNumber);
            MacroDroidApplication.getInstance().startService(intent);
        }
    }

    @Override // android.telephony.PhoneStateListener
    public void onServiceStateChanged(ServiceState serviceState) {
        int state = serviceState.getState();
        boolean z3 = true;
        if (state != 0) {
            if (state != 1) {
            }
            z3 = false;
        }
        if (f15351a != z3) {
            f15351a = z3;
            ArrayList arrayList = new ArrayList();
            for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Trigger next = it.next();
                        if ((next instanceof SignalOnOffTrigger) && !(next instanceof CallActiveTrigger) && ((SignalOnOffTrigger) next).getSignalOn() == z3 && next.constraintsMet()) {
                            macro.setTriggerThatInvoked(next);
                            if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                arrayList.add(macro);
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
}
