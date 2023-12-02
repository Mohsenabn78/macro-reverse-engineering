package com.arlosoft.macrodroid.triggers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.helper.HelperCommandsKt;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.WifiConnectionTrigger;
import com.arlosoft.macrodroid.utils.LocationUtils;
import com.google.firebase.firestore.util.ExponentialBackoff;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class WifiConnectionTriggerReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static long f15371a;

    /* renamed from: b  reason: collision with root package name */
    private static WifiInfo f15372b;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String str;
        String str2;
        Iterator<Macro> it;
        Iterator<Trigger> it2;
        String str3;
        String str4;
        Intent intent2 = intent;
        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
        String action = intent.getAction();
        String str5 = "android.net.wifi.STATE_CHANGE";
        if (isInitialStickyBroadcast()) {
            if (action.equals("android.net.wifi.STATE_CHANGE")) {
                f15372b = wifiManager.getConnectionInfo();
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        WifiInfo wifiInfo = f15372b;
        Iterator<Macro> it3 = MacroStore.getInstance().getEnabledMacros().iterator();
        while (it3.hasNext()) {
            Macro next = it3.next();
            Iterator<Trigger> it4 = next.getTriggerListWithAwaitingActions().iterator();
            while (true) {
                if (it4.hasNext()) {
                    Trigger next2 = it4.next();
                    if (next2 instanceof WifiConnectionTrigger) {
                        WifiConnectionTrigger wifiConnectionTrigger = (WifiConnectionTrigger) next2;
                        int intExtra = intent2.getIntExtra(HelperCommandsKt.HELPER_OPTION_SET_WIFI_STATE, 0);
                        if (intExtra == 1 && wifiConnectionTrigger.getWifiState() == 1 && next2.constraintsMet()) {
                            next.setTriggerThatInvoked(next2);
                            if (next.canInvoke(next.getTriggerContextInfo())) {
                                arrayList.add(next);
                            }
                        } else if (intExtra == 3 && wifiConnectionTrigger.getWifiState() == 0 && next2.constraintsMet()) {
                            next.setTriggerThatInvoked(next2);
                            if (next.canInvoke(next.getTriggerContextInfo())) {
                                arrayList.add(next);
                            }
                        } else {
                            for (String str6 : wifiConnectionTrigger.getSSIDList()) {
                                action.hashCode();
                                char c4 = 65535;
                                switch (action.hashCode()) {
                                    case -1875733435:
                                        if (action.equals("android.net.wifi.WIFI_STATE_CHANGED")) {
                                            c4 = 0;
                                            break;
                                        }
                                        break;
                                    case -343630553:
                                        if (action.equals(str5)) {
                                            c4 = 1;
                                            break;
                                        }
                                        break;
                                    case 68995823:
                                        if (action.equals("android.net.wifi.supplicant.CONNECTION_CHANGE")) {
                                            c4 = 2;
                                            break;
                                        }
                                        break;
                                }
                                switch (c4) {
                                    case 0:
                                        str = action;
                                        str2 = str5;
                                        it = it3;
                                        it2 = it4;
                                        if (intExtra == 1) {
                                            if (wifiConnectionTrigger.getWifiState() == 3 && wifiInfo != null && wifiInfo.getSSID() != null && ((wifiInfo.getSSID().equals(str6) || str6.equals(Util.ANY_WIFI_NETWORK_ENGLISH) || str6.equals(context.getString(R.string.any_network))) && next2.constraintsMet())) {
                                                next.setTriggerThatInvoked(next2);
                                                if (next.canInvoke(next.getTriggerContextInfo())) {
                                                    arrayList.add(next);
                                                    break;
                                                }
                                            }
                                            intent2 = intent;
                                            action = str;
                                            str5 = str2;
                                            it3 = it;
                                            it4 = it2;
                                        }
                                        intent2 = intent;
                                        action = str;
                                        str5 = str2;
                                        it3 = it;
                                        it4 = it2;
                                        break;
                                    case 1:
                                        NetworkInfo networkInfo = (NetworkInfo) intent2.getParcelableExtra("networkInfo");
                                        if (networkInfo == null) {
                                            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("WifiConnectionTriggerReceiver: No Networkinfo extra!"));
                                            str = action;
                                            str2 = str5;
                                            it = it3;
                                            it2 = it4;
                                        } else {
                                            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                                            if (connectionInfo != null) {
                                                str3 = connectionInfo.getSSID();
                                                str = action;
                                            } else {
                                                str = action;
                                                str3 = null;
                                            }
                                            str2 = str5;
                                            if (NetworkInfo.DetailedState.CONNECTED.equals(networkInfo.getDetailedState())) {
                                                if (str3 != null && !str3.equals("") && !str3.equals("<unknown ssid>")) {
                                                    it = it3;
                                                    it2 = it4;
                                                } else {
                                                    it = it3;
                                                    it2 = it4;
                                                    if (Build.VERSION.SDK_INT >= 27 && !LocationUtils.isLocationEnabled(context)) {
                                                        long currentTimeMillis = System.currentTimeMillis();
                                                        if (currentTimeMillis > f15371a + ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS && !str6.equals(context.getString(R.string.any_network))) {
                                                            f15371a = currentTimeMillis;
                                                            SystemLog.logError("Could not get SSID, location services must be enabled on Android 8.1+");
                                                        }
                                                    }
                                                }
                                                if (wifiInfo == null || wifiInfo.getSSID() == null || !wifiInfo.getSSID().equals(wifiManager.getConnectionInfo().getSSID())) {
                                                    if (str3 != null && !str3.equals("") && !str3.equals("<unknown ssid>") && !str3.equals("0x")) {
                                                        f15372b = wifiManager.getConnectionInfo();
                                                    }
                                                } else {
                                                    intent2 = intent;
                                                    action = str;
                                                    str5 = str2;
                                                    it3 = it;
                                                    it4 = it2;
                                                }
                                            } else {
                                                it = it3;
                                                it2 = it4;
                                            }
                                            if (NetworkInfo.DetailedState.CONNECTED.equals(networkInfo.getDetailedState()) && wifiConnectionTrigger.getWifiState() == 2) {
                                                String ssid = wifiManager.getConnectionInfo().getSSID();
                                                if (ssid != null && ssid.startsWith("\"") && ssid.endsWith("\"")) {
                                                    ssid = ssid.substring(1, ssid.length() - 1);
                                                }
                                                if ((str6.equals(Util.ANY_WIFI_NETWORK_ENGLISH) || str6.equals(context.getString(R.string.any_network))) && next2.constraintsMet()) {
                                                    next.setTriggerThatInvoked(next2);
                                                    if (next.canInvoke(next.getTriggerContextInfo())) {
                                                        arrayList.add(next);
                                                        break;
                                                    }
                                                }
                                                if (ssid != null && ssid.equals(str6) && next2.constraintsMet()) {
                                                    next.setTriggerThatInvoked(next2);
                                                    if (next.canInvoke(next.getTriggerContextInfo())) {
                                                        arrayList.add(next);
                                                        break;
                                                    }
                                                }
                                            } else if (NetworkInfo.DetailedState.DISCONNECTED.equals(networkInfo.getDetailedState())) {
                                                if (wifiConnectionTrigger.getWifiState() == 3) {
                                                    if (wifiInfo != null) {
                                                        str4 = wifiInfo.getSSID();
                                                    } else {
                                                        str4 = null;
                                                    }
                                                    if (str4 != null && str4.startsWith("\"") && str4.endsWith("\"")) {
                                                        str4 = str4.substring(1, str4.length() - 1);
                                                    }
                                                    if ((str6.equals(Util.ANY_WIFI_NETWORK_ENGLISH) || str6.equals(context.getString(R.string.any_network))) && str4 != null && str4.length() > 0 && !str4.equals("\"\"")) {
                                                        if (next2.constraintsMet()) {
                                                            next.setTriggerThatInvoked(next2);
                                                            if (next.canInvoke(next.getTriggerContextInfo())) {
                                                                arrayList.add(next);
                                                                break;
                                                            }
                                                        }
                                                    } else if (str4 != null && str4.equals(str6) && next2.constraintsMet()) {
                                                        next.setTriggerThatInvoked(next2);
                                                        if (next.canInvoke(next.getTriggerContextInfo())) {
                                                            arrayList.add(next);
                                                            break;
                                                        }
                                                    }
                                                }
                                                f15372b = null;
                                            }
                                            intent2 = intent;
                                            action = str;
                                            str5 = str2;
                                            it3 = it;
                                            it4 = it2;
                                        }
                                        intent2 = intent;
                                        action = str;
                                        str5 = str2;
                                        it3 = it;
                                        it4 = it2;
                                        break;
                                    case 2:
                                        intent2.getBooleanExtra("connected", false);
                                    default:
                                        str = action;
                                        str2 = str5;
                                        it = it3;
                                        it2 = it4;
                                        intent2 = intent;
                                        action = str;
                                        str5 = str2;
                                        it3 = it;
                                        it4 = it2;
                                }
                                intent2 = intent;
                                action = str;
                                str5 = str2;
                                it3 = it;
                                it4 = it2;
                            }
                        }
                    }
                    str = action;
                    str2 = str5;
                    it = it3;
                    it2 = it4;
                    intent2 = intent;
                    action = str;
                    str5 = str2;
                    it3 = it;
                    it4 = it2;
                }
            }
            intent2 = intent;
            action = action;
            str5 = str5;
            it3 = it3;
        }
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            Macro macro = (Macro) it5.next();
            macro.invokeActions(macro.getTriggerContextInfo());
        }
    }
}
