package com.arlosoft.macrodroid.action.sms;

import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.PowerManager;
import android.telephony.SmsManager;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.Contact;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.utils.PendingIntentHelper;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class SMSOutputService2 extends IntentService {
    public static final String EXTRA_ATTEMPT_NUMBER = "attempt_number";
    public static final String EXTRA_DESTINATION = "destination";
    public static final String EXTRA_MESSAGE = "message";

    /* renamed from: b  reason: collision with root package name */
    private static int f5001b = 95000;

    /* renamed from: a  reason: collision with root package name */
    private PowerManager.WakeLock f5002a;

    public SMSOutputService2() {
        super("SMSOutputService2");
    }

    private SmsManager a(int i4) {
        SmsManager smsManagerForSubscriptionId;
        if (Build.VERSION.SDK_INT >= 22 && i4 != 0) {
            smsManagerForSubscriptionId = SmsManager.getSmsManagerForSubscriptionId(i4);
            if (smsManagerForSubscriptionId == null) {
                return SmsManager.getDefault();
            }
            return smsManagerForSubscriptionId;
        }
        return SmsManager.getDefault();
    }

    private void b() {
        if (this.f5002a == null) {
            PowerManager.WakeLock newWakeLock = ((PowerManager) getSystemService("power")).newWakeLock(1, "macrodroid:sms_output_service");
            this.f5002a = newWakeLock;
            newWakeLock.setReferenceCounted(true);
        }
    }

    private void c(SMSMessage sMSMessage, Intent intent) {
        try {
            this.f5002a.acquire(20000L);
            int intExtra = intent.getIntExtra(Constants.SIM_ID, 0);
            Intent intent2 = new Intent(this, SMSResultReceiver.class);
            intent2.putExtra("SMS_MESSAGE_ID", sMSMessage.getMsgId());
            intent2.putExtra("original_intent", intent);
            intent2.putExtra(EXTRA_ATTEMPT_NUMBER, intent.getIntExtra(EXTRA_ATTEMPT_NUMBER, 1));
            intent2.putExtra("message", intent.getStringExtra("message"));
            intent2.putExtra("destination", intent.getStringExtra("destination"));
            intent2.putExtra(SMSActivity.ADD_TO_MESSAGE_LOG_EXTRA, intent.getBooleanExtra(SMSActivity.ADD_TO_MESSAGE_LOG_EXTRA, false));
            intent2.putExtra(Constants.SIM_ID, intExtra);
            SystemLog.logInfo("Sending SMS to: " + sMSMessage.getNumber() + " Message = " + sMSMessage.getMessage());
            int i4 = f5001b;
            f5001b = i4 + 1;
            PendingIntent broadcast = PendingIntent.getBroadcast(this, i4, intent2, PendingIntentHelper.FLAG_MUTABLE | 134217728);
            ArrayList<String> divideMessage = SmsManager.getDefault().divideMessage(sMSMessage.getMessage());
            int size = divideMessage.size();
            if (size == 1) {
                try {
                    a(intExtra).sendTextMessage(sMSMessage.getNumber(), null, sMSMessage.getMessage(), broadcast, null);
                    return;
                } catch (Exception e4) {
                    Util.displayNotification(this, "MacroDroid Error", "SMS Sending Error", false);
                    SystemLog.logError("SMS Sending failed: " + e4.toString());
                    this.f5002a.release();
                    return;
                }
            }
            SystemLog.logInfo("SMS exceeds 160 char limit, sending multi-part message (" + size + " parts)");
            ArrayList<PendingIntent> arrayList = new ArrayList<>();
            for (int i5 = 0; i5 < size; i5++) {
                arrayList.add(PendingIntent.getBroadcast(this, i4, intent2, PendingIntentHelper.FLAG_MUTABLE | 1073741824));
            }
            try {
                a(intExtra).sendMultipartTextMessage(sMSMessage.getNumber(), null, divideMessage, arrayList, null);
                return;
            } catch (Exception e5) {
                Util.displayNotification(this, "MacroDroid Error", "SMS Sending Error", false);
                SystemLog.logError("SMS Sending failed: " + e5.toString());
                this.f5002a.release();
                return;
            }
        } catch (Exception e6) {
            SystemLog.logError("Failed to send SMS message: " + e6.toString());
        }
        SystemLog.logError("Failed to send SMS message: " + e6.toString());
    }

    public static void sendMessage(Context context, String str, Contact contact, String str2, boolean z3, int i4, int i5) {
        if (contact == null && str2 == null) {
            SystemLog.logError("SMSOutputService: destinationContact is null");
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SMSOutputService: Destination Contact is null"));
            Util.displayNotification(context, "SMS sending failed", "The destination was not set", false);
            return;
        }
        if (str2 == null) {
            if (contact.getNumber() != null) {
                str2 = contact.getNumber();
            } else {
                str2 = Util.getPreferredNumberForContact(context, contact);
            }
        }
        sendMessage(context, str, str2, z3, i4, i5);
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        b();
        String stringExtra = intent.getStringExtra("message");
        String stringExtra2 = intent.getStringExtra("destination");
        boolean z3 = intent.getExtras().getBoolean(SMSActivity.ADD_TO_MESSAGE_LOG_EXTRA);
        int intExtra = intent.getIntExtra(EXTRA_ATTEMPT_NUMBER, 1);
        int intExtra2 = intent.getIntExtra(Constants.SIM_ID, 0);
        if (stringExtra == null) {
            SystemLog.logError("SMSOutputService: message is null");
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SMSOutputService: message is null"));
            Util.displayNotification(this, "SMS sending failed", "The message was empty", false);
            return;
        }
        SMSMessage sMSMessage = new SMSMessage(stringExtra2, stringExtra, z3, intExtra2);
        intent.putExtra(EXTRA_ATTEMPT_NUMBER, intExtra);
        intent.putExtra("message", stringExtra);
        intent.putExtra("destination", stringExtra2);
        intent.putExtra(SMSActivity.ADD_TO_MESSAGE_LOG_EXTRA, z3);
        intent.putExtra(Constants.SIM_ID, intExtra2);
        c(sMSMessage, intent);
    }

    public static void sendMessage(Context context, String str, String str2, boolean z3, int i4, int i5) {
        if (str == null) {
            SystemLog.logError("SMSOutputService: message is null");
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("SMSOutputService: message is null"));
            return;
        }
        Intent intent = new Intent(context, SMSOutputService2.class);
        intent.putExtra("message", str);
        intent.putExtra("destination", str2);
        intent.putExtra(EXTRA_ATTEMPT_NUMBER, i4);
        intent.putExtra(SMSActivity.ADD_TO_MESSAGE_LOG_EXTRA, z3);
        intent.putExtra(Constants.SIM_ID, i5);
        try {
            context.startService(intent);
        } catch (IllegalStateException e4) {
            SystemLog.logError("Cannot start send SMS service: " + e4);
            FirebaseAnalyticsEventLogger.logHandledException(e4);
        }
    }
}
