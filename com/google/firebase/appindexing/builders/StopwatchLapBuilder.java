package com.google.firebase.appindexing.builders;

import androidx.annotation.NonNull;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public class StopwatchLapBuilder extends IndexableBuilder<StopwatchLapBuilder> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public StopwatchLapBuilder() {
        super("StopwatchLap");
    }

    @NonNull
    public StopwatchLapBuilder setAccumulatedTime(long j4) {
        return put("accumulatedTime", j4);
    }

    @NonNull
    public StopwatchLapBuilder setElapsedTime(long j4) {
        return put("elapsedTime", j4);
    }
}
