package com.arlosoft.macrodroid.action.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.Action;
import com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.toast.CustomToastHelper;
import com.arlosoft.macrodroid.utils.Vibrate;

/* loaded from: classes2.dex */
public class UiInteractionNotificationPressReceiver extends BroadcastReceiver {
    public static final String UI_NOTIFICATION_PRESS_RECEIVER = "com.arlosoft.macrodroid.action.receivers.UI_NOTIFICATION_PRESS_RECEIVER";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Macro macro = (Macro) intent.getParcelableExtra("Macro");
        Action action = (Action) intent.getParcelableExtra(Constants.EXTRA_CURRENT_ACTION);
        Vibrate.vibrateDevice(context, 0);
        CustomToastHelper.displayCustomToast(context, context.getString(R.string.ui_interaction_identify_touch_ui_control), -1, (int) R.drawable.launcher_no_border, ContextCompat.getColor(context, R.color.actions_primary_dark), 1, true, true);
        UIInteractionAccessibilityService.Companion.captureNextClick();
    }
}
