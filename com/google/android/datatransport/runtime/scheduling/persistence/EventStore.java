package com.google.android.datatransport.runtime.scheduling.persistence;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import java.io.Closeable;

@WorkerThread
/* loaded from: classes.dex */
public interface EventStore extends Closeable {
    int cleanUp();

    long getNextCallTime(TransportContext transportContext);

    boolean hasPendingEventsFor(TransportContext transportContext);

    Iterable<TransportContext> loadActiveContexts();

    Iterable<PersistedEvent> loadBatch(TransportContext transportContext);

    @Nullable
    PersistedEvent persist(TransportContext transportContext, EventInternal eventInternal);

    void recordFailure(Iterable<PersistedEvent> iterable);

    void recordNextCallTime(TransportContext transportContext, long j4);

    void recordSuccess(Iterable<PersistedEvent> iterable);
}
