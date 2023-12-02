package com.arlosoft.macrodroid.celltowers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.arlosoft.macrodroid.celltowers.CellTowerUtils;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.data.CellTowerGroup;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class CellTowerBGScanReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String stringExtra = intent.getStringExtra(Constants.EXTRA_CELL_TOWER_GROUP_NAME);
        CellTowerGroup groupByName = CellTowerGroupStore.getInstance().getGroupByName(stringExtra);
        if (groupByName == null) {
            SystemLog.logError("BG Scan failed, cell tower group no longer exists (" + stringExtra + ")");
            CellTowerBackgroundScanService.cancelScanning(context);
            return;
        }
        List<CellTowerUtils.CellTowerInfo> cellTowersInRange = CellTowerUtils.getCellTowersInRange(context);
        if (cellTowersInRange.size() == 0) {
            SystemLog.logVerbose("BG Scan - No towers found");
        } else {
            SystemLog.logInfo("BG Scan - Cell towers found = " + cellTowersInRange.size());
            Iterator<CellTowerUtils.CellTowerInfo> it = cellTowersInRange.iterator();
            while (it.hasNext()) {
                SystemLog.logInfo("-> " + it.next().id);
            }
        }
        boolean z3 = false;
        for (CellTowerUtils.CellTowerInfo cellTowerInfo : cellTowersInRange) {
            if (groupByName.getCellTowerIds() != null && !groupByName.getCellTowerIds().contains(cellTowerInfo.id)) {
                groupByName.getCellTowerIds().add(cellTowerInfo.id);
                SystemLog.logInfo("BG Scan found new cell: " + cellTowerInfo.id + " adding to group " + stringExtra);
                z3 = true;
            }
        }
        if (!z3) {
            SystemLog.logVerbose("BG Cell Tower Scan - no new cell towers");
        }
        EventBusUtils.getEventBus().post(new CellTowerUpdateEvent());
        CellTowerGroupStore.getInstance().persistData();
        CellTowerBackgroundScanService.scheduleAlarm(context, stringExtra);
    }
}
