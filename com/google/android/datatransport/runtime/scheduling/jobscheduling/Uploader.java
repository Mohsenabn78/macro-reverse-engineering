package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.runtime.EncodedPayload;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.BackendRequest;
import com.google.android.datatransport.runtime.backends.BackendResponse;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.firebase.transport.ClientMetrics;
import com.google.android.datatransport.runtime.firebase.transport.LogEventDropped;
import com.google.android.datatransport.runtime.logging.Logging;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.PersistedEvent;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.Monotonic;
import com.google.android.datatransport.runtime.time.WallTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* loaded from: classes.dex */
public class Uploader {

    /* renamed from: a  reason: collision with root package name */
    private final Context f18810a;

    /* renamed from: b  reason: collision with root package name */
    private final BackendRegistry f18811b;

    /* renamed from: c  reason: collision with root package name */
    private final EventStore f18812c;

    /* renamed from: d  reason: collision with root package name */
    private final WorkScheduler f18813d;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f18814e;

    /* renamed from: f  reason: collision with root package name */
    private final SynchronizationGuard f18815f;

    /* renamed from: g  reason: collision with root package name */
    private final Clock f18816g;

    /* renamed from: h  reason: collision with root package name */
    private final Clock f18817h;

    /* renamed from: i  reason: collision with root package name */
    private final ClientHealthMetricsStore f18818i;

    @Inject
    public Uploader(Context context, BackendRegistry backendRegistry, EventStore eventStore, WorkScheduler workScheduler, Executor executor, SynchronizationGuard synchronizationGuard, @WallTime Clock clock, @Monotonic Clock clock2, ClientHealthMetricsStore clientHealthMetricsStore) {
        this.f18810a = context;
        this.f18811b = backendRegistry;
        this.f18812c = eventStore;
        this.f18813d = workScheduler;
        this.f18814e = executor;
        this.f18815f = synchronizationGuard;
        this.f18816g = clock;
        this.f18817h = clock2;
        this.f18818i = clientHealthMetricsStore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Boolean k(TransportContext transportContext) {
        return Boolean.valueOf(this.f18812c.hasPendingEventsFor(transportContext));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Iterable l(TransportContext transportContext) {
        return this.f18812c.loadBatch(transportContext);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object m(Iterable iterable, TransportContext transportContext, long j4) {
        this.f18812c.recordFailure(iterable);
        this.f18812c.recordNextCallTime(transportContext, this.f18816g.getTime() + j4);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object n(Iterable iterable) {
        this.f18812c.recordSuccess(iterable);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object o() {
        this.f18818i.resetClientMetrics();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object p(Map map) {
        for (Map.Entry entry : map.entrySet()) {
            this.f18818i.recordLogEventDropped(((Integer) entry.getValue()).intValue(), LogEventDropped.Reason.INVALID_PAYLOD, (String) entry.getKey());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object q(TransportContext transportContext, long j4) {
        this.f18812c.recordNextCallTime(transportContext, this.f18816g.getTime() + j4);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object r(TransportContext transportContext, int i4) {
        this.f18813d.schedule(transportContext, i4 + 1);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(final TransportContext transportContext, final int i4, Runnable runnable) {
        try {
            try {
                SynchronizationGuard synchronizationGuard = this.f18815f;
                final EventStore eventStore = this.f18812c;
                Objects.requireNonNull(eventStore);
                synchronizationGuard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.m
                    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                    public final Object execute() {
                        return Integer.valueOf(EventStore.this.cleanUp());
                    }
                });
                if (!j()) {
                    this.f18815f.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.d
                        @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                        public final Object execute() {
                            Object r4;
                            r4 = Uploader.this.r(transportContext, i4);
                            return r4;
                        }
                    });
                } else {
                    logAndUpdateState(transportContext, i4);
                }
            } catch (SynchronizationException unused) {
                this.f18813d.schedule(transportContext, i4 + 1);
            }
        } finally {
            runnable.run();
        }
    }

    @VisibleForTesting
    public EventInternal createMetricsEvent(TransportBackend transportBackend) {
        SynchronizationGuard synchronizationGuard = this.f18815f;
        final ClientHealthMetricsStore clientHealthMetricsStore = this.f18818i;
        Objects.requireNonNull(clientHealthMetricsStore);
        return transportBackend.decorate(EventInternal.builder().setEventMillis(this.f18816g.getTime()).setUptimeMillis(this.f18817h.getTime()).setTransportName("GDT_CLIENT_METRICS").setEncodedPayload(new EncodedPayload(Encoding.of("proto"), ((ClientMetrics) synchronizationGuard.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.c
            @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
            public final Object execute() {
                return ClientHealthMetricsStore.this.loadClientMetrics();
            }
        })).toByteArray())).build());
    }

    boolean j() {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f18810a.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            return true;
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public BackendResponse logAndUpdateState(final TransportContext transportContext, int i4) {
        BackendResponse send;
        TransportBackend transportBackend = this.f18811b.get(transportContext.getBackendName());
        long j4 = 0;
        BackendResponse ok = BackendResponse.ok(0L);
        while (true) {
            final long j5 = j4;
            while (((Boolean) this.f18815f.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.f
                @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                public final Object execute() {
                    Boolean k4;
                    k4 = Uploader.this.k(transportContext);
                    return k4;
                }
            })).booleanValue()) {
                final Iterable<PersistedEvent> iterable = (Iterable) this.f18815f.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.g
                    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                    public final Object execute() {
                        Iterable l4;
                        l4 = Uploader.this.l(transportContext);
                        return l4;
                    }
                });
                if (!iterable.iterator().hasNext()) {
                    return ok;
                }
                if (transportBackend == null) {
                    Logging.d("Uploader", "Unknown backend for %s, deleting event batch for it...", transportContext);
                    send = BackendResponse.fatalError();
                } else {
                    ArrayList arrayList = new ArrayList();
                    for (PersistedEvent persistedEvent : iterable) {
                        arrayList.add(persistedEvent.getEvent());
                    }
                    if (transportContext.shouldUploadClientHealthMetrics()) {
                        arrayList.add(createMetricsEvent(transportBackend));
                    }
                    send = transportBackend.send(BackendRequest.builder().setEvents(arrayList).setExtras(transportContext.getExtras()).build());
                }
                ok = send;
                if (ok.getStatus() == BackendResponse.Status.TRANSIENT_ERROR) {
                    this.f18815f.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.h
                        @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                        public final Object execute() {
                            Object m4;
                            m4 = Uploader.this.m(iterable, transportContext, j5);
                            return m4;
                        }
                    });
                    this.f18813d.schedule(transportContext, i4 + 1, true);
                    return ok;
                }
                this.f18815f.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.i
                    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                    public final Object execute() {
                        Object n4;
                        n4 = Uploader.this.n(iterable);
                        return n4;
                    }
                });
                if (ok.getStatus() == BackendResponse.Status.OK) {
                    j4 = Math.max(j5, ok.getNextRequestWaitMillis());
                    if (transportContext.shouldUploadClientHealthMetrics()) {
                        this.f18815f.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.j
                            @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                            public final Object execute() {
                                Object o4;
                                o4 = Uploader.this.o();
                                return o4;
                            }
                        });
                    }
                } else if (ok.getStatus() == BackendResponse.Status.INVALID_PAYLOAD) {
                    final HashMap hashMap = new HashMap();
                    for (PersistedEvent persistedEvent2 : iterable) {
                        String transportName = persistedEvent2.getEvent().getTransportName();
                        if (!hashMap.containsKey(transportName)) {
                            hashMap.put(transportName, 1);
                        } else {
                            hashMap.put(transportName, Integer.valueOf(((Integer) hashMap.get(transportName)).intValue() + 1));
                        }
                    }
                    this.f18815f.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.k
                        @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                        public final Object execute() {
                            Object p4;
                            p4 = Uploader.this.p(hashMap);
                            return p4;
                        }
                    });
                }
            }
            this.f18815f.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.l
                @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
                public final Object execute() {
                    Object q4;
                    q4 = Uploader.this.q(transportContext, j5);
                    return q4;
                }
            });
            return ok;
        }
    }

    public void upload(final TransportContext transportContext, final int i4, final Runnable runnable) {
        this.f18814e.execute(new Runnable() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.e
            @Override // java.lang.Runnable
            public final void run() {
                Uploader.this.s(transportContext, i4, runnable);
            }
        });
    }
}
