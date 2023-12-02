package com.arlosoft.macrodroid.triggers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.IpAddressChangeTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.ArrayList;
import java.util.Iterator;
import net.bytebuddy.description.type.TypeDescription;

/* loaded from: classes3.dex */
public class IpAddressChangeReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        ArrayList arrayList = new ArrayList();
        String localIpv4Address = Util.getLocalIpv4Address();
        String previousIpAddress = Settings.getPreviousIpAddress(context);
        if (!localIpv4Address.equals(TypeDescription.Generic.OfWildcardType.SYMBOL) && !localIpv4Address.equals(previousIpAddress)) {
            if (previousIpAddress == null) {
                Settings.setPreviousIpAddress(context, localIpv4Address);
                return;
            }
            for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Trigger next = it.next();
                        if ((next instanceof IpAddressChangeTrigger) && next.constraintsMet()) {
                            if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                arrayList.add(macro);
                                macro.setTriggerThatInvoked(next);
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
            Settings.setPreviousIpAddress(context, localIpv4Address);
        }
    }
}
