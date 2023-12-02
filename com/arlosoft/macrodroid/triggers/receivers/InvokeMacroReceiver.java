package com.arlosoft.macrodroid.triggers.receivers;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.arlosoft.macrodroid.actionblock.common.ActionBlockData;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.data.ResumeMacroInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.ActionBlockStore;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.EmptyTrigger;
import com.arlosoft.macrodroid.triggers.InvokedByNotificationTrigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.triggers.receivers.InvokeMacroReceiver;
import java.util.Collections;
import java.util.Map;
import java.util.Stack;

/* loaded from: classes3.dex */
public class InvokeMacroReceiver extends BroadcastReceiver {
    public static final String EXTRA_ACTION_BLOCK_DATA = "action_block_data";
    public static final String EXTRA_ACTION_BLOCK_ITEM_DIVIDER = "[{.}]";
    public static final String EXTRA_ACTION_BLOCK_PARAMS = "action_block_params";
    public static final String EXTRA_ACTION_BLOCK_VALUES = "action_block_values";

    private ActionBlockStore b() {
        return MacroStore.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c(Intent intent, Context context) {
        long j4;
        long j5 = 0;
        long longExtra = intent.getLongExtra(Constants.EXTRA_MACRO_GUID, 0L);
        int intExtra = intent.getIntExtra(Constants.CANCEL_NOTIFICATION_ID, -1);
        if (intExtra >= 0) {
            ((NotificationManager) context.getSystemService("notification")).cancel(String.valueOf(intExtra), intExtra);
        }
        for (Macro macro : MacroStore.getInstance().getEnabledMacrosAndActionBlocks()) {
            if (macro.getGUID() == longExtra) {
                long longExtra2 = intent.getLongExtra(Constants.EXTRA_PARENT_MACRO_ID, j5);
                if (macro.isActionBlock) {
                    ActionBlockData actionBlockData = (ActionBlockData) intent.getParcelableExtra(EXTRA_ACTION_BLOCK_DATA);
                    if (actionBlockData == null) {
                        SystemLog.logError("Action Block data was null in InvokeMacroReceiver for an action block");
                    } else {
                        Macro macroByGUID = MacroStore.getInstance().getMacroByGUID(longExtra2);
                        TriggerContextInfo triggerContextInfo = new TriggerContextInfo(new EmptyTrigger());
                        ActionBlock cloneActionBlock = b().getActionBlockByGuid(macro.getGUID()).cloneActionBlock(false, true);
                        cloneActionBlock.setIsClonedInstance(true);
                        b().addActionBlock(cloneActionBlock);
                        ResumeMacroInfo resumeMacroInfo = new ResumeMacroInfo(cloneActionBlock.getGUID(), -1, null, true, new Stack(), null, actionBlockData.getOutputVarsMap());
                        if (longExtra2 != j5) {
                            SystemLog.logVerbose("Received request to invoke action block: " + macro.getName(), longExtra2);
                        }
                        SystemLog.logInfo("Running action block: " + cloneActionBlock.getName(), macro.getGUID());
                        cloneActionBlock.invokeActions(triggerContextInfo, true, resumeMacroInfo, (Map<String, String>) actionBlockData.getInputVarsMap(), Collections.emptyMap(), macroByGUID);
                    }
                    j4 = 0;
                } else {
                    macro.getTriggerListWithAwaitingActions();
                    TriggerContextInfo triggerContextInfo2 = new TriggerContextInfo(InvokedByNotificationTrigger.getInstance());
                    macro.setTriggerThatInvoked(InvokedByNotificationTrigger.getInstance());
                    j4 = 0;
                    if (longExtra2 != 0) {
                        SystemLog.logVerbose("Received request to invoke macro: " + macro.getName(), longExtra2);
                    }
                    SystemLog.logInfo("Running macro: " + macro.getName(), macro.getGUID());
                    macro.invokeActions(triggerContextInfo2);
                }
            } else {
                j4 = j5;
            }
            j5 = j4;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(final Context context, final Intent intent) {
        new Handler().postDelayed(new Runnable() { // from class: q0.b
            @Override // java.lang.Runnable
            public final void run() {
                InvokeMacroReceiver.this.c(intent, context);
            }
        }, 500L);
    }
}
