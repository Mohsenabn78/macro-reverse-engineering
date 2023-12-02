package com.arlosoft.macrodroid.action.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.action.WaitUntilTriggerAction;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.util.ArrayList;
import java.util.Stack;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: WaitUntilTriggerTimeoutReceiver.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class WaitUntilTriggerTimeoutReceiver extends BroadcastReceiver {
    public static final int $stable = 0;

    private final void a(Macro macro, Intent intent) {
        Stack<Integer> stack;
        TriggerContextInfo triggerContextInfo = (TriggerContextInfo) intent.getParcelableExtra(Constants.EXTRA_TRIGGER_CONTEXT_INFO);
        if (intent.hasExtra(Constants.EXTRA_SKIP_TO_ENDIF_INDEX)) {
            try {
                stack = Util.deserializeStack((ArrayList) intent.getSerializableExtra(Constants.EXTRA_SKIP_TO_ENDIF_INDEX));
            } catch (Exception unused) {
                stack = new Stack<>();
            }
        } else {
            stack = new Stack<>();
        }
        int intExtra = intent.getIntExtra(Constants.EXTRA_NEXT_ACTION_INDEX, -1);
        macro.invokeActions(macro.getActions(), intExtra, triggerContextInfo, false, stack, (ResumeMacroInfo) intent.getParcelableExtra(Constants.EXTRA_RESUME_MACRO_INFO));
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@NotNull Context context, @NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        long longExtra = intent.getLongExtra(Constants.EXTRA_MACRO_GUID, -1L);
        long longExtra2 = intent.getLongExtra(Constants.EXTRA_SELECTABLE_ITEM_ID, -1L);
        Macro macroByGUID = MacroStore.getInstance().getMacroByGUID(longExtra);
        if (macroByGUID != null) {
            macroByGUID.setWaitForTriggerActive(null);
            SelectableItem findChildByGUID = macroByGUID.findChildByGUID(longExtra2);
            if (findChildByGUID != null) {
                WaitUntilTriggerAction waitUntilTriggerAction = (WaitUntilTriggerAction) findChildByGUID;
                waitUntilTriggerAction.disableTriggers();
                SystemLog.logVerbose("Wait until trigger timed out.", longExtra);
                if (waitUntilTriggerAction.getContinueOnTimeout()) {
                    a(macroByGUID, intent);
                    return;
                } else {
                    macroByGUID.terminateMacro();
                    return;
                }
            }
            SystemLog.logError("Wait until trigger timed out, but action could not be found.", longExtra);
            return;
        }
        SystemLog.logError("Wait until trigger timed out, but macro could not be found.", longExtra);
    }
}
