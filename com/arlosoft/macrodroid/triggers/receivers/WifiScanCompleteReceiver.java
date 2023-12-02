package com.arlosoft.macrodroid.triggers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.data.WifiCellInfo;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.WifiSSIDTrigger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class WifiScanCompleteReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static List<ScanResult> f15373a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private static long f15374b;

    private String a(String str) {
        if (str != null && str.length() > 0 && str.startsWith("\"") && str.endsWith("\"")) {
            return str.substring(1, str.length() - 1);
        }
        return str;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean z3;
        boolean z4;
        String str;
        WifiScanCompleteReceiver wifiScanCompleteReceiver = this;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < f15374b + 5000) {
            return;
        }
        f15374b = currentTimeMillis;
        try {
            List<ScanResult> scanResults = wifiManager.getScanResults();
            if (scanResults == null) {
                SystemLog.logError("Wifi scan results returned null");
                return;
            }
            List<Macro> enabledMacros = MacroStore.getInstance().getEnabledMacros();
            Iterator<Macro> it = enabledMacros.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Iterator<Trigger> it2 = it.next().getTriggerListWithAwaitingActions().iterator();
                while (it2.hasNext()) {
                    Trigger next = it2.next();
                    if ((next instanceof WifiSSIDTrigger) && next.isEnabled()) {
                        StringBuilder sb = new StringBuilder(400);
                        sb.append("WIFI SCAN: ");
                        int size = scanResults.size();
                        for (int i4 = 0; i4 < size; i4++) {
                            sb.append(scanResults.get(i4).SSID);
                            if (!TextUtils.isEmpty(scanResults.get(i4).BSSID)) {
                                str = "(" + scanResults.get(i4).BSSID + ")";
                            } else {
                                str = "";
                            }
                            sb.append(str);
                            sb.append(", ");
                        }
                        SystemLog.logVerbose(sb.toString());
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (Macro macro : enabledMacros) {
                Iterator<Trigger> it3 = macro.getTriggerListWithAwaitingActions().iterator();
                while (true) {
                    if (it3.hasNext()) {
                        Trigger next2 = it3.next();
                        if (next2 instanceof WifiSSIDTrigger) {
                            WifiSSIDTrigger wifiSSIDTrigger = (WifiSSIDTrigger) next2;
                            boolean wifiInRange = wifiSSIDTrigger.getWifiInRange();
                            List<WifiCellInfo> wifiCellInfoList = wifiSSIDTrigger.getWifiCellInfoList();
                            int size2 = f15373a.size();
                            for (int i5 = 0; i5 < size2; i5++) {
                                ScanResult scanResult = f15373a.get(i5);
                                String a4 = wifiScanCompleteReceiver.a(scanResult.SSID);
                                for (WifiCellInfo wifiCellInfo : wifiCellInfoList) {
                                    String a5 = wifiScanCompleteReceiver.a(wifiCellInfo.getSsid());
                                    if (a4 != null && a4.toLowerCase().equals(a5.toLowerCase()) && (wifiCellInfo.getBssid() == null || wifiCellInfo.getBssid().equals(scanResult.BSSID))) {
                                        z3 = true;
                                        break;
                                    }
                                }
                            }
                            z3 = false;
                            if (!z3 || !wifiInRange) {
                                int i6 = 0;
                                while (i6 < scanResults.size()) {
                                    ScanResult scanResult2 = scanResults.get(i6);
                                    String a6 = wifiScanCompleteReceiver.a(scanResult2.SSID);
                                    for (WifiCellInfo wifiCellInfo2 : wifiCellInfoList) {
                                        String bssid = wifiCellInfo2.getBssid();
                                        if (a6 != null && a6.toLowerCase().equals(wifiCellInfo2.getSsid().toLowerCase()) && (bssid == null || bssid.equals(scanResult2.BSSID))) {
                                            z4 = true;
                                            break;
                                        }
                                    }
                                    i6++;
                                    wifiScanCompleteReceiver = this;
                                }
                                z4 = false;
                                if (((wifiInRange && z4) || (!wifiInRange && !z4 && z3)) && next2.constraintsMet()) {
                                    macro.setTriggerThatInvoked(next2);
                                    if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                        arrayList.add(macro);
                                        break;
                                    }
                                }
                            }
                        }
                        wifiScanCompleteReceiver = this;
                    }
                }
                wifiScanCompleteReceiver = this;
            }
            Iterator it4 = arrayList.iterator();
            while (it4.hasNext()) {
                Macro macro2 = (Macro) it4.next();
                macro2.invokeActions(macro2.getTriggerContextInfo());
            }
            f15373a = scanResults;
        } catch (SecurityException unused) {
            PermissionsHelper.showNeedsPermission(context, "android.permission.ACCESS_COARSE_LOCATION", context.getString(R.string.trigger_wifi_SSID), true, false);
        } catch (Exception e4) {
            SystemLog.logError("Failed to get wifi scan results: " + e4.toString());
        }
    }
}
