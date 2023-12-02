package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;
import com.arlosoft.macrodroid.drawer.model.DrawerItemStopwatch;
import com.google.firebase.appindexing.internal.zzae;
import java.util.Calendar;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public final class StopwatchBuilder extends IndexableBuilder<StopwatchBuilder> {
    @NonNull
    public static final String PAUSED = "Paused";
    @NonNull
    public static final String STARTED = "Started";
    @NonNull
    public static final String UNKNOWN = "Unknown";

    /* JADX INFO: Access modifiers changed from: package-private */
    public StopwatchBuilder() {
        super(DrawerItemStopwatch.ITEM_TYPE);
    }

    @NonNull
    public StopwatchBuilder setElapsedTime(long j4) {
        put("elapsedTime", j4);
        return this;
    }

    @NonNull
    public StopwatchBuilder setLaps(@NonNull StopwatchLapBuilder... stopwatchLapBuilderArr) {
        a("laps", stopwatchLapBuilderArr);
        return this;
    }

    @NonNull
    public StopwatchBuilder setStartTime(@NonNull Calendar calendar) {
        put("startTime", zzae.zza(calendar));
        return this;
    }

    @NonNull
    public StopwatchBuilder setStopwatchStatus(@NonNull String str) {
        String str2;
        if (!"Started".equals(str) && !"Paused".equals(str) && !"Unknown".equals(str)) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2 = "Invalid stopwatch status ".concat(valueOf);
            } else {
                str2 = new String("Invalid stopwatch status ");
            }
            throw new IllegalArgumentException(str2);
        }
        put("stopwatchStatus", str);
        return this;
    }
}
