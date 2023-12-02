package com.arlosoft.macrodroid.triggers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;

/* loaded from: classes3.dex */
public class InitiateWifScanReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            ((WifiManager) context.getApplicationContext().getSystemService("wifi")).startScan();
        } catch (SecurityException e4) {
            FirebaseAnalyticsEventLogger.logHandledException(e4);
        }
    }
}
