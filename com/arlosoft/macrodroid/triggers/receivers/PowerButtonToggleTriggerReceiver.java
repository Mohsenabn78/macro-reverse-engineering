package com.arlosoft.macrodroid.triggers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.PowerButtonToggleTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class PowerButtonToggleTriggerReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private Date f15337a = null;

    /* renamed from: b  reason: collision with root package name */
    private int f15338b = 0;

    private int a(Context context) {
        if (this.f15337a == null) {
            this.f15337a = new Date();
            this.f15338b = 1;
        } else if (new Date().getTime() - this.f15337a.getTime() < Settings.getPowerButtonToggleTimeout(context)) {
            this.f15338b++;
        } else {
            this.f15337a = new Date();
            this.f15338b = 1;
        }
        return this.f15338b;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean z3;
        try {
            if (((TelephonyManager) context.getSystemService("phone")).getCallState() != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z3) {
                return;
            }
        } catch (Exception unused) {
        }
        int a4 = a(context);
        if (a4 >= 2) {
            ArrayList arrayList = new ArrayList();
            for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Trigger next = it.next();
                        if ((next instanceof PowerButtonToggleTrigger) && ((PowerButtonToggleTrigger) next).getNumToggles() == a4 && next.constraintsMet()) {
                            if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                arrayList.add(macro);
                                macro.setTriggerThatInvoked(next);
                            }
                            this.f15337a = null;
                            this.f15338b = 0;
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
