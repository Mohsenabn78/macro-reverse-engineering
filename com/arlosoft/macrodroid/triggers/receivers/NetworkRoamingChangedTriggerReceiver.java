package com.arlosoft.macrodroid.triggers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.TelephonyManager;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.NetworkRoamingChangedTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class NetworkRoamingChangedTriggerReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f15334a;

    public static void initialiseOldRoamingValue(Context context) {
        f15334a = ((TelephonyManager) context.getSystemService("phone")).isNetworkRoaming();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean isNetworkRoaming = ((TelephonyManager) context.getSystemService("phone")).isNetworkRoaming();
        if (isNetworkRoaming != f15334a) {
            ArrayList arrayList = new ArrayList();
            for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Trigger next = it.next();
                        if ((next instanceof NetworkRoamingChangedTrigger) && ((NetworkRoamingChangedTrigger) next).isRoamingEnabled() == isNetworkRoaming && next.constraintsMet()) {
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
        f15334a = isNetworkRoaming;
    }
}
