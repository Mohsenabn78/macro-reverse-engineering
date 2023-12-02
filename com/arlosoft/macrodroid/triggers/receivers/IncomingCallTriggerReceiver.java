package com.arlosoft.macrodroid.triggers.receivers;

import android.content.Intent;
import android.telephony.PhoneStateListener;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.triggers.services.IncomingCallCheckerService;
import com.tencent.soter.core.model.ConstantsSoter;

/* loaded from: classes3.dex */
public class IncomingCallTriggerReceiver extends PhoneStateListener {

    /* renamed from: a  reason: collision with root package name */
    private static long f15328a;

    @Override // android.telephony.PhoneStateListener
    public void onCallStateChanged(int i4, String str) {
        if (i4 == 1) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - f15328a > ConstantsSoter.FACEID_AUTH_CHECK_TIME) {
                    f15328a = currentTimeMillis;
                    try {
                        Intent intent = new Intent(MacroDroidApplication.getInstance(), IncomingCallCheckerService.class);
                        intent.putExtra(Constants.EXTRA_PHONE_NUMBER, str);
                        MacroDroidApplication.getInstance().startService(intent);
                    } catch (Exception e4) {
                        SystemLog.logError("Cannot start call checker service: " + e4);
                        FirebaseAnalyticsEventLogger.logHandledException(e4);
                    }
                }
            } catch (Exception e5) {
                FirebaseAnalyticsEventLogger.logHandledException(e5);
            }
        }
    }
}
