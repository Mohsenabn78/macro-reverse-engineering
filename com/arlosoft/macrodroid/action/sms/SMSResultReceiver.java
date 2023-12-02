package com.arlosoft.macrodroid.action.sms;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.arlosoft.macrodroid.alarm.AlarmHelper;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;

/* loaded from: classes2.dex */
public class SMSResultReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static int f5003a = 950000;

    /* renamed from: b  reason: collision with root package name */
    private static final Uri f5004b = Uri.parse("content://sms/sent");

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        int resultCode = getResultCode();
        String stringExtra = intent.getStringExtra("destination");
        boolean booleanExtra = intent.getBooleanExtra(SMSActivity.ADD_TO_MESSAGE_LOG_EXTRA, false);
        String stringExtra2 = intent.getStringExtra("message");
        int intExtra = intent.getIntExtra(SMSOutputService2.EXTRA_ATTEMPT_NUMBER, 1);
        int intExtra2 = intent.getIntExtra(Constants.SIM_ID, 0);
        if (resultCode != -1) {
            int resultCode2 = getResultCode();
            if (resultCode2 != 1) {
                if (resultCode2 != 2) {
                    if (resultCode2 != 3) {
                        if (resultCode2 != 4) {
                            str = "Unknown";
                        } else {
                            str = "No service";
                        }
                    } else {
                        str = "Null PDU";
                    }
                } else {
                    str = "Radio off";
                }
            } else {
                str = "Generic failure";
            }
            SystemLog.logError("Send SMS Failed, result = " + str + " [" + stringExtra + ":" + stringExtra2 + "]");
            if (intExtra < 5) {
                Intent intent2 = new Intent(context, SMSRetryReceiver.class);
                intent2.putExtra(SMSOutputService2.EXTRA_ATTEMPT_NUMBER, intExtra);
                intent2.putExtra("message", stringExtra2);
                intent2.putExtra("destination", stringExtra);
                intent2.putExtra(SMSActivity.ADD_TO_MESSAGE_LOG_EXTRA, booleanExtra);
                intent2.putExtra(Constants.SIM_ID, intExtra2);
                int i4 = f5003a;
                f5003a = i4 + 1;
                AlarmHelper.scheduleExactRTCWithAlarmOption(true, System.currentTimeMillis() + 30000, PendingIntent.getBroadcast(context, i4, intent2, 134217728 | PendingIntentHelper.FLAG_MUTABLE));
                SystemLog.logInfo("Scheduling retry SMS (Retry " + intExtra + ") in around 30s");
                return;
            }
            SystemLog.logWarning("Giving up on SMS sending after " + intExtra + " attempts");
            Util.displayNotification(context, "SMS sending failed", "Message to: " + stringExtra + " failed", false);
            return;
        }
        SystemLog.logInfo("SMS Sent to: " + stringExtra);
    }
}
