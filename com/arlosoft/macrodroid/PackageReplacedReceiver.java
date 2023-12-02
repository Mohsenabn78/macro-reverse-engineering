package com.arlosoft.macrodroid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;

/* loaded from: classes2.dex */
public class PackageReplacedReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        FirebaseAnalyticsEventLogger.log("PackageReplacedReceiver");
        SystemLog.logInfo("MacroDroid packaged replaced, now running v5.38.16 (53800019)");
    }
}
