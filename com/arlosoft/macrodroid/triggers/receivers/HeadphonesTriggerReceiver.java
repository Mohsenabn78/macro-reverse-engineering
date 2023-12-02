package com.arlosoft.macrodroid.triggers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.HeadphonesTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class HeadphonesTriggerReceiver extends BroadcastReceiver {
    private boolean a(@NonNull HeadphonesTrigger headphonesTrigger, boolean z3) {
        if (!headphonesTrigger.getConnected() || headphonesTrigger.getMicOption() == 0) {
            return true;
        }
        if (headphonesTrigger.getMicOption() == 1) {
            return !z3;
        }
        return z3;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean z3;
        if (isInitialStickyBroadcast()) {
            return;
        }
        boolean z4 = true;
        if (intent.getIntExtra(RemoteConfigConstants.ResponseFieldKey.STATE, -1) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (intent.getIntExtra("microphone", -1) == 0) {
            z4 = false;
        }
        ArrayList arrayList = new ArrayList();
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (true) {
                if (it.hasNext()) {
                    Trigger next = it.next();
                    if (next instanceof HeadphonesTrigger) {
                        HeadphonesTrigger headphonesTrigger = (HeadphonesTrigger) next;
                        if (headphonesTrigger.getConnected() == z3 && a(headphonesTrigger, z4) && next.constraintsMet()) {
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
