package com.arlosoft.macrodroid.geofences;

import android.app.IntentService;
import android.content.Intent;
import android.location.Location;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.cache.Cache;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.GeofenceTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.sens.app.extensions.LocationExtensionsKt;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: GeofenceTransitionService.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class GeofenceTransitionService extends IntentService {
    public static final int $stable = 0;

    public GeofenceTransitionService() {
        super("GeofenceTransitionService");
    }

    private final int a(GeofencingEvent geofencingEvent) {
        if (geofencingEvent.getGeofenceTransition() == 2) {
            return 2;
        }
        return 1;
    }

    private final String b(int i4) {
        if (i4 != 1) {
            if (i4 != 2) {
                return "Unknown";
            }
            return "Outside";
        }
        return "Inside";
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(@Nullable Intent intent) {
        GeofenceTransitionService geofenceTransitionService = this;
        if (intent == null) {
            return;
        }
        GeofencingEvent fromIntent = GeofencingEvent.fromIntent(intent);
        Integer num = null;
        if (fromIntent != null && !fromIntent.hasError()) {
            Cache cache = MacroDroidApplication.Companion.getInstance().getCache("GeofenceInfo");
            Object obj = cache.get("GeofenceInfo", GeofenceStore.class);
            boolean z3 = true;
            if (obj == null) {
                obj = new GeofenceStore(null, 1, null);
            }
            Location triggeringLocation = fromIntent.getTriggeringLocation();
            if (triggeringLocation == null) {
                SystemLog.logWarning("GeofenceInfo Error: location is null");
                return;
            }
            if (fromIntent.getGeofenceTransition() != 1) {
                z3 = false;
            }
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
            decimalFormatSymbols.setDecimalSeparator('.');
            DecimalFormat decimalFormat = new DecimalFormat("#.#######", decimalFormatSymbols);
            String format = decimalFormat.format(Double.valueOf(triggeringLocation.getLatitude()));
            String format2 = decimalFormat.format(Double.valueOf(triggeringLocation.getLongitude()));
            String format3 = decimalFormat.format(Double.valueOf(triggeringLocation.getLatitude()));
            String format4 = decimalFormat.format(triggeringLocation.getLongitude());
            StringBuilder sb = new StringBuilder();
            sb.append(Util.GOOGLE_MAPS_HEADING);
            sb.append(format);
            String str = ",";
            sb.append(",");
            sb.append(format2);
            sb.append("&center=");
            sb.append(format3);
            sb.append(",");
            sb.append(format4);
            String sb2 = sb.toString();
            Float valueOf = Float.valueOf(triggeringLocation.getAccuracy());
            SystemLog.logVerbose("Location: <a href=\"" + sb2 + "\">" + sb2 + " (Uncertainty=" + valueOf + "m)</a>", 0L, GeofenceInfo.GEOFENCE_GENERIC_ID);
            String prettyText = LocationExtensionsKt.prettyText(triggeringLocation);
            StringBuilder sb3 = new StringBuilder();
            sb3.append("Geofence Event: ");
            sb3.append(prettyText);
            SystemLog.logInfo(sb3.toString(), 0L, GeofenceInfo.GEOFENCE_GENERIC_ID);
            ArrayList arrayList = new ArrayList();
            List<Geofence> triggeringGeofences = fromIntent.getTriggeringGeofences();
            if (triggeringGeofences != null) {
                Iterator<Geofence> it = triggeringGeofences.iterator();
                while (it.hasNext()) {
                    Geofence next = it.next();
                    GeofenceStore geofenceStore = (GeofenceStore) obj;
                    GeofenceInfo geofenceInfo = geofenceStore.getGeofenceMap().get(next.getRequestId());
                    if (geofenceInfo != null) {
                        int a4 = geofenceTransitionService.a(fromIntent);
                        String name = geofenceInfo.getName();
                        Iterator<Geofence> it2 = it;
                        String b4 = geofenceTransitionService.b(a4);
                        String str2 = str;
                        ArrayList arrayList2 = arrayList;
                        long j4 = 0;
                        SystemLog.logInfo("Geofence Event: " + name + " Status = " + b4, 0L, next.getRequestId());
                        if (geofenceInfo.getInsideStatus() == a4) {
                            SystemLog.logInfo("Geofence status has not changed", 0L, next.getRequestId());
                            return;
                        }
                        String requestId = next.getRequestId();
                        Intrinsics.checkNotNullExpressionValue(requestId, "geofence.requestId");
                        geofenceStore.setGeofence(requestId, GeofenceInfo.copy$default(geofenceInfo, null, null, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, 0, a4, 31, null));
                        cache.put("GeofenceInfo", obj);
                        Iterator<Macro> it3 = MacroStore.getInstance().getEnabledMacros().iterator();
                        while (it3.hasNext()) {
                            Macro next2 = it3.next();
                            Iterator<Trigger> it4 = next2.getTriggerListWithAwaitingActions().iterator();
                            while (true) {
                                if (it4.hasNext()) {
                                    Trigger next3 = it4.next();
                                    if (next3 instanceof GeofenceTrigger) {
                                        GeofenceTrigger geofenceTrigger = (GeofenceTrigger) next3;
                                        if (Intrinsics.areEqual(geofenceTrigger.getGeofenceId(), geofenceInfo.getId()) && geofenceTrigger.isEnter() == z3 && next3.constraintsMet() && (geofenceInfo.getInsideStatus() != 0 || ((GeofenceTrigger) next3).isTriggerFromUnknown())) {
                                            next2.setTriggerThatInvoked(next3);
                                            Double valueOf2 = Double.valueOf(triggeringLocation.getLatitude());
                                            Double valueOf3 = Double.valueOf(triggeringLocation.getLongitude());
                                            Iterator<Macro> it5 = it3;
                                            StringBuilder sb4 = new StringBuilder();
                                            sb4.append(valueOf2);
                                            String str3 = str2;
                                            sb4.append(str3);
                                            sb4.append(valueOf3);
                                            next2.setTriggerContextInfo(new TriggerContextInfo(next3, sb4.toString()));
                                            if (next2.canInvoke(next2.getTriggerContextInfo())) {
                                                arrayList2.add(next2);
                                                str2 = str3;
                                                it3 = it5;
                                                j4 = 0;
                                                break;
                                            }
                                            str2 = str3;
                                            it3 = it5;
                                        }
                                        j4 = 0;
                                    }
                                }
                            }
                        }
                        geofenceTransitionService = this;
                        it = it2;
                        str = str2;
                        arrayList = arrayList2;
                    } else {
                        geofenceTransitionService = this;
                    }
                }
            }
            Iterator it6 = arrayList.iterator();
            while (it6.hasNext()) {
                Macro macro = (Macro) it6.next();
                macro.invokeActions(macro.getTriggerContextInfo());
            }
            return;
        }
        if (fromIntent != null) {
            num = Integer.valueOf(fromIntent.getErrorCode());
        }
        SystemLog.logWarning("GeofenceInfo Error: " + num);
    }
}
