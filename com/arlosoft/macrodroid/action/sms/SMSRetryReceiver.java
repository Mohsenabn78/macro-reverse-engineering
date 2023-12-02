package com.arlosoft.macrodroid.action.sms;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.arlosoft.macrodroid.common.Constants;

/* loaded from: classes2.dex */
public class SMSRetryReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        SMSOutputService2.sendMessage(context, intent.getStringExtra("message"), intent.getStringExtra("destination"), intent.getBooleanExtra(SMSActivity.ADD_TO_MESSAGE_LOG_EXTRA, false), 1 + intent.getIntExtra(SMSOutputService2.EXTRA_ATTEMPT_NUMBER, 1), intent.getIntExtra(Constants.SIM_ID, 0));
    }
}
