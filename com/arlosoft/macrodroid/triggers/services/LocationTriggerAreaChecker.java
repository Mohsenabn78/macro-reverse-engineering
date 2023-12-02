package com.arlosoft.macrodroid.triggers.services;

import android.location.Location;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.LocationTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class LocationTriggerAreaChecker {

    /* loaded from: classes3.dex */
    public enum LocationInfo {
        UNKNOWN,
        OUTSIDE_TRIGGER_AREA,
        PROBABLY_OUTSIDE_TRIGGER_AREA,
        POSSIBLY_INSIDE_TRIGGER_AREA,
        PROBABLY_INSIDE_TRIGGER_AREA,
        INSIDE_TRIGGER_AREA
    }

    private static LocationInfo a(Location location, Location location2) {
        float distanceTo = location.distanceTo(location2);
        float accuracy = location.getAccuracy();
        float accuracy2 = location2.getAccuracy();
        if (distanceTo < accuracy2 - accuracy) {
            return LocationInfo.INSIDE_TRIGGER_AREA;
        }
        double d4 = distanceTo;
        double d5 = accuracy2;
        double d6 = accuracy * 0.85d;
        if (d4 < d5 - d6) {
            return LocationInfo.PROBABLY_INSIDE_TRIGGER_AREA;
        }
        if (distanceTo > accuracy2 + accuracy) {
            return LocationInfo.OUTSIDE_TRIGGER_AREA;
        }
        if (d4 > d5 + d6) {
            return LocationInfo.PROBABLY_OUTSIDE_TRIGGER_AREA;
        }
        return LocationInfo.POSSIBLY_INSIDE_TRIGGER_AREA;
    }

    public static synchronized boolean checkLocationTriggers(Location location) {
        Iterator<Macro> it;
        LocationInfo locationInfo;
        synchronized (LocationTriggerAreaChecker.class) {
            if (location.getAccuracy() > 200.0f) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
            decimalFormatSymbols.setDecimalSeparator('.');
            DecimalFormat decimalFormat = new DecimalFormat("#.#######", decimalFormatSymbols);
            String str = Util.GOOGLE_MAPS_HEADING + location.getLatitude() + "," + location.getLongitude() + "&center=" + decimalFormat.format(location.getLatitude()) + "," + decimalFormat.format(location.getLongitude());
            SystemLog.logVerbose("Location: <a href=\"" + str + "\">" + str + " (Uncertainty=" + location.getAccuracy() + "m)</a>", 0L);
            HashMap hashMap = new HashMap();
            Iterator<Macro> it2 = MacroStore.getInstance().getEnabledMacros().iterator();
            boolean z3 = true;
            while (it2.hasNext()) {
                Macro next = it2.next();
                Iterator<Trigger> it3 = next.getTriggerListWithAwaitingActions().iterator();
                while (it3.hasNext()) {
                    Trigger next2 = it3.next();
                    if (next2 instanceof LocationTrigger) {
                        LocationTrigger locationTrigger = (LocationTrigger) next2;
                        LocationInfo locationInfo2 = Settings.getLocationInfo(MacroDroidApplication.getInstance(), locationTrigger);
                        LocationInfo a4 = a(location, locationTrigger.getLocation());
                        StringBuilder sb = new StringBuilder();
                        it = it2;
                        sb.append(location.getLatitude());
                        sb.append(",");
                        sb.append(location.getLongitude());
                        TriggerContextInfo triggerContextInfo = new TriggerContextInfo(locationTrigger, sb.toString());
                        LocationInfo locationInfo3 = LocationInfo.POSSIBLY_INSIDE_TRIGGER_AREA;
                        if (a4 == locationInfo3) {
                            z3 = false;
                        } else {
                            LocationInfo locationInfo4 = LocationInfo.OUTSIDE_TRIGGER_AREA;
                            if (a4 != locationInfo4 && a4 != (locationInfo = LocationInfo.PROBABLY_OUTSIDE_TRIGGER_AREA)) {
                                if ((a4 == LocationInfo.INSIDE_TRIGGER_AREA || a4 == LocationInfo.PROBABLY_INSIDE_TRIGGER_AREA) && locationTrigger.isEnterTrigger() && (((locationInfo2 == LocationInfo.UNKNOWN && locationTrigger.getTriggerFromUnknown()) || locationInfo2 == locationInfo4 || locationInfo2 == locationInfo) && next2.constraintsMet())) {
                                    next.setTriggerThatInvoked(next2);
                                    next.setTriggerContextInfo(triggerContextInfo);
                                    if (next.canInvoke(next.getTriggerContextInfo())) {
                                        arrayList.add(next);
                                    }
                                }
                            }
                            if (!locationTrigger.isEnterTrigger() && (((locationInfo2 == LocationInfo.UNKNOWN && locationTrigger.getTriggerFromUnknown()) || locationInfo2 == LocationInfo.INSIDE_TRIGGER_AREA || locationInfo2 == LocationInfo.PROBABLY_INSIDE_TRIGGER_AREA) && next2.constraintsMet())) {
                                next.setTriggerThatInvoked(next2);
                                next.setTriggerContextInfo(triggerContextInfo);
                                if (next.canInvoke(next.getTriggerContextInfo())) {
                                    arrayList.add(next);
                                }
                            }
                        }
                        if (a4 != locationInfo3) {
                            hashMap.put(locationTrigger, a4);
                        }
                    } else {
                        it = it2;
                    }
                    it2 = it;
                }
            }
            for (LocationTrigger locationTrigger2 : hashMap.keySet()) {
                Settings.setLocationInfo(MacroDroidApplication.getInstance(), locationTrigger2, (LocationInfo) hashMap.get(locationTrigger2));
            }
            if (z3) {
                FirebaseAnalyticsEventLogger.log("Location Trigger - running macros");
                for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                    Iterator<Trigger> it4 = macro.getTriggerListWithAwaitingActions().iterator();
                    while (it4.hasNext()) {
                        Trigger next3 = it4.next();
                        if (next3 instanceof LocationTrigger) {
                            SystemLog.logVerbose(Settings.getLocationInfo(MacroDroidApplication.getInstance(), (LocationTrigger) next3).toString(), macro.getGUID());
                        }
                    }
                }
            }
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                Macro macro2 = (Macro) it5.next();
                macro2.invokeActions(macro2.getTriggerContextInfo());
            }
            return z3;
        }
    }
}
