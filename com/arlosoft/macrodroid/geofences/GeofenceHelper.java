package com.arlosoft.macrodroid.geofences;

import androidx.annotation.NonNull;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.interfaces.HasGeofence;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class GeofenceHelper {
    public static void clearAllGeoTriggersWithId(@NonNull String str) {
        for (Macro macro : MacroStore.getInstance().getAllCompletedMacrosIncludingExtras()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (it.hasNext()) {
                Trigger next = it.next();
                if (next instanceof HasGeofence) {
                    HasGeofence hasGeofence = (HasGeofence) next;
                    if (str.equals(hasGeofence.getGeofenceId())) {
                        hasGeofence.clearGeofenceId();
                        next.disableTriggerThreadSafe();
                        next.setEnabled(false);
                    }
                }
            }
        }
    }
}
