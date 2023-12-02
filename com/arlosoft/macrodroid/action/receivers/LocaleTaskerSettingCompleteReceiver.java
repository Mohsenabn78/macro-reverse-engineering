package com.arlosoft.macrodroid.action.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.action.LocalePluginAction;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.taskerplugin.ArrayHandlingOption;
import com.arlosoft.macrodroid.taskerplugin.TaskerVariableHandler;
import com.arlosoft.macrodroid.taskerplugin.TaskerVariableHelper;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.dinglisch.android.tasker.TaskerPlugin;
import org.jetbrains.annotations.NotNull;

/* compiled from: LocaleTaskerSettingCompleteReceiver.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class LocaleTaskerSettingCompleteReceiver extends BroadcastReceiver {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String EXTRA_ACTION_ID = "action_id";

    /* compiled from: LocaleTaskerSettingCompleteReceiver.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        TaskerVariableHelper taskerVariableHelper = new TaskerVariableHelper();
        Bundle variablesBundle = TaskerPlugin.Host.getVariablesBundle(intent.getExtras());
        long longExtra = intent.getLongExtra(EXTRA_ACTION_ID, 0L);
        if (variablesBundle != null && !variablesBundle.isEmpty()) {
            for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                Iterator<Action> it = macro.getActions().iterator();
                while (it.hasNext()) {
                    Action next = it.next();
                    if (next instanceof LocalePluginAction) {
                        LocalePluginAction localePluginAction = (LocalePluginAction) next;
                        if (localePluginAction.getSIGUID() == longExtra) {
                            ArrayHandlingOption arrayHandlingOption = localePluginAction.getArrayHandlingOption();
                            Intrinsics.checkNotNullExpressionValue(arrayHandlingOption, "action.arrayHandlingOption");
                            taskerVariableHelper.setVariables(variablesBundle, (TaskerVariableHandler) next, next, arrayHandlingOption);
                            localePluginAction.resumeMacro();
                        }
                    }
                }
            }
            for (Macro macro2 : MacroStore.getInstance().getActiveActionBlockInstances()) {
                Iterator<Action> it2 = macro2.getActions().iterator();
                while (it2.hasNext()) {
                    Action next2 = it2.next();
                    if (next2 instanceof LocalePluginAction) {
                        LocalePluginAction localePluginAction2 = (LocalePluginAction) next2;
                        if (localePluginAction2.getSIGUID() == longExtra) {
                            ArrayHandlingOption arrayHandlingOption2 = localePluginAction2.getArrayHandlingOption();
                            Intrinsics.checkNotNullExpressionValue(arrayHandlingOption2, "action.arrayHandlingOption");
                            taskerVariableHelper.setVariables(variablesBundle, (TaskerVariableHandler) next2, next2, arrayHandlingOption2);
                            localePluginAction2.resumeMacro();
                        }
                    }
                }
            }
        }
    }
}
