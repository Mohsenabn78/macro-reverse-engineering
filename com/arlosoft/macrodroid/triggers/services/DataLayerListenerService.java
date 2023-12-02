package com.arlosoft.macrodroid.triggers.services;

import android.content.Intent;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.AndroidWearTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.utils.AndroidWearConstants;
import com.arlosoft.macrodroid.utils.AndroidWearHelper;
import com.arlosoft.macrodroid.wizard.WizardActivity;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.ArrayList;
import java.util.Iterator;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class DataLayerListenerService extends WearableListenerService {

    /* renamed from: i  reason: collision with root package name */
    private static int f15419i = -1;

    private void g() {
        int freeMacros = Settings.getFreeMacros(this);
        if (!MacroDroidApplication.getInstance().premiumStatusHandler.getPremiumStatus().isPro() && MacroStore.getInstance().getAllCompletedMacros().size() >= freeMacros) {
            ToastCompat.makeText(MacroDroidApplication.getInstance(), (int) R.string.macro_limit_reached, 1).show();
            return;
        }
        Intent intent = new Intent(this, WizardActivity.class);
        intent.putExtra(Util.ADD_WEAR_TRIGGER_EXTRA, true);
        intent.addFlags(268435456);
        startActivity(intent);
    }

    private void h(boolean z3) {
        ArrayList arrayList = new ArrayList();
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerList().iterator();
            while (true) {
                if (it.hasNext()) {
                    Trigger next = it.next();
                    if (next instanceof AndroidWearTrigger) {
                        AndroidWearTrigger androidWearTrigger = (AndroidWearTrigger) next;
                        if ((androidWearTrigger.getOption() == 1 && z3) || (androidWearTrigger.getOption() == 2 && !z3)) {
                            if (next.constraintsMet()) {
                                macro.setTriggerThatInvoked(next);
                                if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                    arrayList.add(macro);
                                }
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

    private void i(String str) {
        ArrayList arrayList = new ArrayList();
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerList().iterator();
            while (true) {
                if (it.hasNext()) {
                    Trigger next = it.next();
                    if ((next instanceof AndroidWearTrigger) && ((AndroidWearTrigger) next).getOption() == 0 && macro.getName().equals(str) && next.constraintsMet()) {
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
    }

    @Override // com.google.android.gms.wearable.WearableListenerService, com.google.android.gms.wearable.CapabilityApi.CapabilityListener
    public void onCapabilityChanged(CapabilityInfo capabilityInfo) {
        super.onCapabilityChanged(capabilityInfo);
        if (capabilityInfo.getNodes().size() > 0 && f15419i != 1) {
            h(true);
            f15419i = 1;
        } else if (f15419i != 0) {
            h(false);
            f15419i = 0;
        }
    }

    @Override // com.google.android.gms.wearable.WearableListenerService, com.google.android.gms.wearable.MessageApi.MessageListener
    public void onMessageReceived(MessageEvent messageEvent) {
        StringBuilder sb = new StringBuilder();
        sb.append("onMessageReceived: ");
        sb.append(messageEvent);
        String path = messageEvent.getPath();
        if (path.startsWith(AndroidWearConstants.INVOKE_ANDROID_WEAR_MACRO)) {
            i(path.substring(path.lastIndexOf(RemoteSettings.FORWARD_SLASH_STRING) + 1));
        } else if (path.startsWith(AndroidWearConstants.INVOKE_ADD_NEW_MACRO)) {
            g();
        } else if (path.startsWith(AndroidWearConstants.REQUEST_MACRO_LIST)) {
            AndroidWearHelper.updateMacroList(this, true);
        }
    }
}
