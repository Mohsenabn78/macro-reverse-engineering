package com.arlosoft.macrodroid.triggers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.common.MacroDroidVariable;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.IntentReceivedTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.WildCardHelper;
import com.arlosoft.macrodroid.variables.VariableValue;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: IntentReceivedTriggerReceiver.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class IntentReceivedTriggerReceiver extends BroadcastReceiver {
    public static final int $stable = 0;

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Iterable<IndexedValue> withIndex;
        TriggerContextInfo triggerContextInfo;
        MacroDroidVariable variableByName;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        ArrayList<Macro> arrayList = new ArrayList();
        Bundle extras = intent.getExtras();
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (true) {
                if (it.hasNext()) {
                    Trigger next = it.next();
                    if (next instanceof IntentReceivedTrigger) {
                        TriggerContextInfo triggerContextInfo2 = null;
                        if (next.constraintsMet(null)) {
                            IntentReceivedTrigger intentReceivedTrigger = (IntentReceivedTrigger) next;
                            if (Intrinsics.areEqual(intentReceivedTrigger.getAction(), intent.getAction())) {
                                withIndex = CollectionsKt___CollectionsKt.withIndex(intentReceivedTrigger.getExtraParams());
                                int i4 = 0;
                                for (IndexedValue indexedValue : withIndex) {
                                    if (extras != null && extras.containsKey((String) indexedValue.getValue())) {
                                        Object obj = extras.get((String) indexedValue.getValue());
                                        String str = (obj == null || (str = obj.toString()) == null) ? "" : "";
                                        if (WildCardHelper.matches(str, WildCardHelper.getRegexPattern(MagicText.replaceMagicText(context, intentReceivedTrigger.getExtraValuePatterns().get(indexedValue.getIndex()), triggerContextInfo2, next.getMacro()), intentReceivedTrigger.getEnableRegex(), true), intentReceivedTrigger.getEnableRegex(), true)) {
                                            i4++;
                                            String str2 = intentReceivedTrigger.getExtraVariables().get(indexedValue.getIndex());
                                            if (str2 != null && (variableByName = next.getVariableByName(str2)) != null) {
                                                triggerContextInfo = null;
                                                next.variableUpdate(variableByName, new VariableValue.StringValue(str, null, 2, null));
                                            }
                                        }
                                        triggerContextInfo = null;
                                    } else {
                                        triggerContextInfo = triggerContextInfo2;
                                    }
                                    triggerContextInfo2 = triggerContextInfo;
                                }
                                if (i4 == intentReceivedTrigger.getExtraParams().size()) {
                                    macro.setTriggerThatInvoked(next);
                                    if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                        Intrinsics.checkNotNullExpressionValue(macro, "macro");
                                        arrayList.add(macro);
                                        break;
                                    }
                                } else {
                                    continue;
                                }
                            } else {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
        }
        for (Macro macro2 : arrayList) {
            macro2.invokeActions(macro2.getTriggerContextInfo());
        }
    }
}
