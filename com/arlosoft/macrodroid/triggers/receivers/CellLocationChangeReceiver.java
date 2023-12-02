package com.arlosoft.macrodroid.triggers.receivers;

import android.content.Intent;
import android.telephony.CellLocation;
import android.telephony.PhoneStateListener;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.celltowers.CellTowerService;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;

/* loaded from: classes3.dex */
public class CellLocationChangeReceiver extends PhoneStateListener {
    @Override // android.telephony.PhoneStateListener
    public void onCellLocationChanged(CellLocation cellLocation) {
        try {
            MacroDroidApplication macroDroidApplication = MacroDroidApplication.getInstance();
            SystemLog.logVerbose("++ Cell location changed ++");
            macroDroidApplication.startService(new Intent(macroDroidApplication, CellTowerService.class));
        } catch (IllegalStateException e4) {
            SystemLog.logError("Could not run cell tower service - foreground service not enabled? " + e4.toString());
        }
    }
}
