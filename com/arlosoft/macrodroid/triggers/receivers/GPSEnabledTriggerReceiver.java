package com.arlosoft.macrodroid.triggers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.LocationManager;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.GPSEnabledTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class GPSEnabledTriggerReceiver extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f15323a;

    public static void initEnabledState(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION);
        if (locationManager != null) {
            try {
                f15323a = locationManager.isProviderEnabled("gps");
            } catch (Exception unused) {
                f15323a = false;
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        boolean z3;
        if (intent.getAction().matches("android.location.PROVIDERS_CHANGED")) {
            try {
                z3 = ((LocationManager) context.getSystemService(FirebaseAnalytics.Param.LOCATION)).isProviderEnabled("gps");
            } catch (SecurityException unused) {
                z3 = false;
            }
            if (f15323a != z3) {
                f15323a = z3;
                ArrayList arrayList = new ArrayList();
                for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                    Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Trigger next = it.next();
                            if ((next instanceof GPSEnabledTrigger) && ((GPSEnabledTrigger) next).getGPSEnabled() == z3 && next.constraintsMet()) {
                                if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                    arrayList.add(macro);
                                    macro.setTriggerThatInvoked(next);
                                }
                            }
                        }
                    }
                }
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    Macro macro2 = (Macro) it2.next();
                    macro2.invokeActions(macro2.getTriggerContextInfo());
                }
            }
        }
    }
}
