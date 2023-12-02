package com.arlosoft.macrodroid.triggers.services;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.core.util.Pair;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.taskerplugin.TaskerVariableHandler;
import com.arlosoft.macrodroid.taskerplugin.TaskerVariableHelper;
import com.arlosoft.macrodroid.triggers.LocalePluginTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.twofortyfouram.locale.sdk.host.api.Condition;
import com.twofortyfouram.locale.sdk.host.api.Event;
import com.twofortyfouram.locale.sdk.host.model.PluginType;
import java.util.ArrayList;
import java.util.Iterator;
import net.dinglisch.android.tasker.TaskerPlugin;

/* loaded from: classes3.dex */
public class LocalePluginCheckerService extends IntentService {
    public LocalePluginCheckerService() {
        super("LocalePluginCheckerService");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Macro macro = (Macro) it.next();
            macro.invokeActions(macro.getTriggerContextInfo());
        }
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        int intValue;
        boolean z3;
        Bundle bundle;
        final ArrayList arrayList = new ArrayList();
        String stringExtra = intent.getStringExtra(com.twofortyfouram.locale.api.Intent.EXTRA_STRING_ACTIVITY_CLASS_NAME);
        TaskerVariableHelper taskerVariableHelper = new TaskerVariableHelper();
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (it.hasNext()) {
                Trigger next = it.next();
                if (next instanceof LocalePluginTrigger) {
                    LocalePluginTrigger localePluginTrigger = (LocalePluginTrigger) next;
                    if (localePluginTrigger.getPlugin().getActivityClassName().equals(stringExtra)) {
                        if (localePluginTrigger.getPlugin().getType() == PluginType.CONDITION) {
                            Condition condition = new Condition(this, localePluginTrigger.getPlugin());
                            Pair<Integer, Bundle> query = condition.query(localePluginTrigger.getPluginInstanceData(), localePluginTrigger.getPreviousState());
                            intValue = query.first.intValue();
                            if ((intValue == 16 && !localePluginTrigger.isInvert()) || (intValue != 16 && localePluginTrigger.isInvert())) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            bundle = query.second;
                            condition.destroy();
                        } else {
                            Event event = new Event(this, localePluginTrigger.getPlugin());
                            Pair<Integer, Bundle> query2 = event.query(localePluginTrigger.getPluginInstanceData(), localePluginTrigger.getPreviousState(), TaskerPlugin.Event.retrievePassThroughData(intent));
                            intValue = query2.first.intValue();
                            if (intValue == 16) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            bundle = query2.second;
                            event.destroy();
                        }
                        localePluginTrigger.setPreviousState(intValue);
                        if (z3 && next.constraintsMet()) {
                            macro.setTriggerThatInvoked(next);
                            if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                arrayList.add(macro);
                                if (bundle != null) {
                                    taskerVariableHelper.setVariables(bundle, (TaskerVariableHandler) next, next, ((LocalePluginTrigger) next).getArrayHandlingOption());
                                }
                            }
                        }
                    }
                }
            }
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.arlosoft.macrodroid.triggers.services.f
            @Override // java.lang.Runnable
            public final void run() {
                LocalePluginCheckerService.b(arrayList);
            }
        });
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }
}
