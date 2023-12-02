package com.arlosoft.macrodroid.celltowers;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import androidx.core.util.Pair;
import com.arlosoft.macrodroid.celltowers.CellTowerUtils;
import com.arlosoft.macrodroid.data.CellTowerGroup;
import com.arlosoft.macrodroid.database.Database;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.RecentCellTowersUpdate;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.CellTowerTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class CellTowerService extends IntentService {

    /* renamed from: a  reason: collision with root package name */
    private static List<String> f9664a;

    /* renamed from: b  reason: collision with root package name */
    private static List<CellTowerUtils.CellTowerInfo> f9665b;

    public CellTowerService() {
        super("CellTowerService");
    }

    private boolean b(String str, List<String> list) {
        for (String str2 : list) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void c(ArrayList arrayList, PowerManager.WakeLock wakeLock) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Macro macro = (Macro) it.next();
            macro.invokeActions(macro.getTriggerContextInfo());
        }
        if (wakeLock.isHeld()) {
            wakeLock.release();
        }
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        int i4;
        Iterator<Macro> it;
        boolean z3;
        boolean z4;
        Iterator<String> it2;
        CellTowerGroup groupByName;
        if (f9664a == null) {
            f9664a = new ArrayList();
            f9665b = new ArrayList();
        }
        final PowerManager.WakeLock newWakeLock = ((PowerManager) getSystemService("power")).newWakeLock(1, "macrodroid:celltowerservice");
        newWakeLock.setReferenceCounted(false);
        newWakeLock.acquire(5000L);
        Set<String> ignoreCellTowerSet = Database.getInstance().getIgnoreCellTowerSet();
        List<CellTowerUtils.CellTowerInfo> cellTowersInRange = CellTowerUtils.getCellTowersInRange(this);
        Database database = Database.getInstance(this);
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (CellTowerUtils.CellTowerInfo cellTowerInfo : cellTowersInRange) {
            if (!ignoreCellTowerSet.contains(cellTowerInfo.id)) {
                arrayList.add(cellTowerInfo.id);
            }
        }
        if (cellTowersInRange.size() == f9664a.size()) {
            i4 = 0;
            for (CellTowerUtils.CellTowerInfo cellTowerInfo2 : cellTowersInRange) {
                Iterator<CellTowerUtils.CellTowerInfo> it3 = f9665b.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        if (cellTowerInfo2.id.equals(it3.next().id)) {
                            i4++;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            i4 = 0;
        }
        if (cellTowersInRange.size() > 0 && i4 != cellTowersInRange.size()) {
            database.removeAllCellTowerRecordsBefore(currentTimeMillis - 604800000);
            for (CellTowerUtils.CellTowerInfo cellTowerInfo3 : cellTowersInRange) {
                database.addCellTowerRecord(cellTowerInfo3.id, currentTimeMillis);
            }
            EventBusUtils.getEventBus().post(new RecentCellTowersUpdate());
        }
        ArrayList arrayList2 = new ArrayList();
        f9665b = arrayList2;
        arrayList2.addAll(cellTowersInRange);
        if (arrayList.size() == 0) {
            SystemLog.logVerbose("No (non-ignored) towers found");
            if (newWakeLock.isHeld()) {
                newWakeLock.release();
                return;
            }
            return;
        }
        SystemLog.logVerbose("Cell towers found = " + arrayList.size());
        Iterator<String> it4 = arrayList.iterator();
        while (it4.hasNext()) {
            SystemLog.logVerbose("-> " + it4.next());
        }
        String currentScanGroup = CellTowerBackgroundScanService.getCurrentScanGroup();
        if (currentScanGroup != null && (groupByName = CellTowerGroupStore.getInstance().getGroupByName(currentScanGroup)) != null) {
            boolean z5 = false;
            for (String str : arrayList) {
                if (!groupByName.getCellTowerIds().contains(str)) {
                    groupByName.getCellTowerIds().add(str);
                    SystemLog.logInfo("BG Scan found new cell: " + str + " adding to group " + currentScanGroup);
                    z5 = true;
                }
            }
            if (z5) {
                CellTowerGroupStore.getInstance().persistData();
            }
        }
        HashMap hashMap = new HashMap();
        final ArrayList arrayList3 = new ArrayList();
        Iterator<Macro> it5 = MacroStore.getInstance().getEnabledMacros().iterator();
        while (it5.hasNext()) {
            Macro next = it5.next();
            Iterator<Trigger> it6 = next.getTriggerListWithAwaitingActions().iterator();
            while (true) {
                if (it6.hasNext()) {
                    Trigger next2 = it6.next();
                    if (next2 instanceof CellTowerTrigger) {
                        CellTowerTrigger cellTowerTrigger = (CellTowerTrigger) next2;
                        CellTowerGroup groupByName2 = CellTowerGroupStore.getInstance().getGroupByName(cellTowerTrigger.getCellGroupName());
                        if (groupByName2 != null) {
                            Pair pair = (Pair) hashMap.get(groupByName2.getName());
                            if (pair == null) {
                                SystemLog.logVerbose("Checking cell towers against group: " + groupByName2.getName());
                                Iterator<String> it7 = groupByName2.getCellTowerIds().iterator();
                                z3 = false;
                                z4 = false;
                                while (it7.hasNext()) {
                                    String next3 = it7.next();
                                    if (!groupByName2.isIgnore(next3)) {
                                        it2 = it7;
                                        if (b(next3, f9664a)) {
                                            z3 = true;
                                        }
                                        if (b(next3, arrayList)) {
                                            z4 = true;
                                        }
                                    } else {
                                        it2 = it7;
                                    }
                                    it7 = it2;
                                }
                                it = it5;
                                hashMap.put(groupByName2.getName(), new Pair(Boolean.valueOf(z3), Boolean.valueOf(z4)));
                                SystemLog.logVerbose("-> Previously in range = " + z3 + ", Currently in range = " + z4);
                            } else {
                                it = it5;
                                boolean booleanValue = ((Boolean) pair.first).booleanValue();
                                z4 = ((Boolean) pair.second).booleanValue();
                                z3 = booleanValue;
                            }
                        } else {
                            it = it5;
                            SystemLog.logVerbose("Checking cell towers against legacy group: " + cellTowerTrigger.getCellGroupName());
                            z3 = false;
                            for (String str2 : cellTowerTrigger.getCellIds()) {
                                if (b(str2, f9664a)) {
                                    z3 = true;
                                }
                                if (b(str2, arrayList)) {
                                    z3 = true;
                                }
                            }
                            SystemLog.logVerbose("-> Previously in range = " + z3 + ", Currently in range = false");
                            z4 = false;
                        }
                        if (cellTowerTrigger.getInRange()) {
                            if (z4 && !z3 && next2.constraintsMet()) {
                                SystemLog.logVerbose("[" + cellTowerTrigger.getCellGroupName() + "] Cell tower now in range");
                                next.setTriggerThatInvoked(next2);
                                if (next.canInvoke(next.getTriggerContextInfo())) {
                                    arrayList3.add(next);
                                }
                            }
                        } else if (z3 && !z4 && next2.constraintsMet()) {
                            SystemLog.logVerbose("[" + cellTowerTrigger.getCellGroupName() + "] All cell towers now out of range");
                            next.setTriggerThatInvoked(next2);
                            if (next.canInvoke(next.getTriggerContextInfo())) {
                                arrayList3.add(next);
                            }
                        }
                    } else {
                        it = it5;
                    }
                    it5 = it;
                } else {
                    it = it5;
                    break;
                }
            }
            it5 = it;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.arlosoft.macrodroid.celltowers.t
            @Override // java.lang.Runnable
            public final void run() {
                CellTowerService.c(arrayList3, newWakeLock);
            }
        });
        f9664a = arrayList;
    }
}
