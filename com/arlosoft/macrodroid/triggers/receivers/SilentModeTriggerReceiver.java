package com.arlosoft.macrodroid.triggers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.SilentModeTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class SilentModeTriggerReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static int f15352a = -1;

    /* renamed from: b  reason: collision with root package name */
    private static long f15353b;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (isInitialStickyBroadcast()) {
            return;
        }
        int intExtra = intent.getIntExtra("android.media.EXTRA_RINGER_MODE", -1);
        boolean z3 = true;
        if (intExtra != 0 && 1 != intExtra) {
            z3 = false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (intExtra == f15352a && f15353b + 1000 > currentTimeMillis) {
            SystemLog.logDebug("Ignoring duplicate SilentModeTriggerReceiver broadcast: " + intExtra);
            return;
        }
        f15353b = currentTimeMillis;
        f15352a = intExtra;
        ArrayList arrayList = new ArrayList();
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (true) {
                if (it.hasNext()) {
                    Trigger next = it.next();
                    if ((next instanceof SilentModeTrigger) && ((SilentModeTrigger) next).getSilentModeEnabled() == z3 && next.constraintsMet()) {
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
