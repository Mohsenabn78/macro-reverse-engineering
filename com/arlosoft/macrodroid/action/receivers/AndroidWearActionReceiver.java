package com.arlosoft.macrodroid.action.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.AndroidWearTrigger;

/* loaded from: classes2.dex */
public class AndroidWearActionReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Macro macroByGUID = MacroStore.getInstance().getMacroByGUID(intent.getLongExtra(Constants.ANDROID_WEAR_ACTION_MACRO_ID, 0L));
        AndroidWearTrigger androidWearTrigger = new AndroidWearTrigger();
        if (macroByGUID != null) {
            macroByGUID.setTriggerThatInvoked(androidWearTrigger);
            if (macroByGUID.canInvoke(macroByGUID.getTriggerContextInfo())) {
                macroByGUID.invokeActions(macroByGUID.getTriggerContextInfo(), true);
            }
        }
    }
}
