package com.arlosoft.macrodroid.triggers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.celltowers.CellTowerService;
import com.arlosoft.macrodroid.triggers.CellTowerTrigger;

/* loaded from: classes3.dex */
public class CheckCellCoverageReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            context.startService(new Intent(context, CellTowerService.class));
        } catch (Exception e4) {
            FirebaseAnalyticsEventLogger.logHandledException(e4);
        }
        CellTowerTrigger.scheduleNextAlarm(context);
    }
}
