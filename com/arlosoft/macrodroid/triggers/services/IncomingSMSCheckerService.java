package com.arlosoft.macrodroid.triggers.services;

import android.app.IntentService;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.SmsMessage;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;

/* loaded from: classes3.dex */
public class IncomingSMSCheckerService extends IntentService {

    /* renamed from: a  reason: collision with root package name */
    private static SmsMessage[] f15489a;

    public IncomingSMSCheckerService() {
        super("IncomingSMSCheckerService");
    }

    private SmsMessage[] a(Intent intent) {
        SmsMessage[] smsMessageArr = null;
        try {
            Object[] objArr = (Object[]) intent.getExtras().get("pdus");
            smsMessageArr = new SmsMessage[objArr.length];
            for (int i4 = 0; i4 < objArr.length; i4++) {
                smsMessageArr[i4] = SmsMessage.createFromPdu((byte[]) objArr[i4]);
            }
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("IncomingSMSTriggerReceiver: [ERROR] getMessagesFromIntent fail: " + e4.getMessage()));
        }
        return smsMessageArr;
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        String str;
        SmsMessage[] smsMessageArr;
        if (intent == null) {
            return;
        }
        Bundle extras = intent.getExtras();
        SmsMessage[] a4 = a(intent);
        int intExtra = intent.getIntExtra("subscription_id", intent.getIntExtra("subscription", intent.getIntExtra("android.telephony.extra.SUBSCRIPTION_INDEX", -1)));
        if (a4 != null) {
            if (a4[0] != null) {
                if (a4.length > 0 && (smsMessageArr = f15489a) != null && smsMessageArr.length > 0) {
                    try {
                        if (smsMessageArr[0].getMessageBody() != null && f15489a[0].getMessageBody().equals(a4[0].getMessageBody()) && f15489a[0].getDisplayOriginatingAddress() != null && f15489a[0].getDisplayOriginatingAddress().equals(a4[0].getDisplayOriginatingAddress())) {
                            if (f15489a[0].getTimestampMillis() == a4[0].getTimestampMillis()) {
                                return;
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
                f15489a = a4;
                if (extras != null) {
                    StringBuilder sb = new StringBuilder();
                    String str2 = null;
                    String str3 = "";
                    for (int i4 = 0; i4 < a4.length; i4++) {
                        SmsMessage smsMessage = a4[i4];
                        if (smsMessage != null) {
                            if (i4 == 0) {
                                try {
                                    str2 = smsMessage.getDisplayOriginatingAddress();
                                } catch (Exception unused2) {
                                }
                                if (str2 != null && str2.length() > 0) {
                                    try {
                                        Cursor query = MacroDroidApplication.getInstance().getContentResolver().query(Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, str2), new String[]{"display_name"}, null, null, null);
                                        if (query != null) {
                                            if (!query.moveToFirst() || (str = query.getString(query.getColumnIndex("display_name"))) == null || str.length() <= 0) {
                                                str = str2;
                                            }
                                            try {
                                                query.close();
                                            } catch (Exception unused3) {
                                            }
                                        }
                                    } catch (Exception unused4) {
                                    }
                                    str = str2;
                                    str3 = str;
                                } else {
                                    SystemLog.logWarning("Incoming SMS: The from number was null or empty");
                                    str3 = str2;
                                }
                            }
                            sb.append(smsMessage.getMessageBody());
                        }
                    }
                    IncomingSMSUtil.checkMessage(this, str2, sb.toString(), str3, intExtra);
                }
                WakefulBroadcastReceiver.completeWakefulIntent(intent);
                return;
            }
        }
        FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("IncomingSMSTriggerReceiver: getMessagesFromIntent returned null"));
    }
}
