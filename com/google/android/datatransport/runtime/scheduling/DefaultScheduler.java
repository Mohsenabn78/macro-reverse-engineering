package com.google.android.datatransport.runtime.scheduling;

import a1.a;
import a1.b;
import com.google.android.datatransport.TransportScheduleCallback;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.backends.TransportBackend;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import javax.inject.Inject;

/* loaded from: classes.dex */
public class DefaultScheduler implements Scheduler {

    /* renamed from: f */
    private static final Logger f18775f = Logger.getLogger(TransportRuntime.class.getName());

    /* renamed from: a */
    private final WorkScheduler f18776a;

    /* renamed from: b */
    private final Executor f18777b;

    /* renamed from: c */
    private final BackendRegistry f18778c;

    /* renamed from: d */
    private final EventStore f18779d;

    /* renamed from: e */
    private final SynchronizationGuard f18780e;

    @Inject
    public DefaultScheduler(Executor executor, BackendRegistry backendRegistry, WorkScheduler workScheduler, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        this.f18777b = executor;
        this.f18778c = backendRegistry;
        this.f18776a = workScheduler;
        this.f18779d = eventStore;
        this.f18780e = synchronizationGuard;
    }

    public /* synthetic */ Object c(TransportContext transportContext, EventInternal eventInternal) {
        this.f18779d.persist(transportContext, eventInternal);
        this.f18776a.schedule(transportContext, 1);
        return null;
    }

    public /* synthetic */ void d(TransportContext transportContext, TransportScheduleCallback transportScheduleCallback, EventInternal eventInternal) {
        try {
            TransportBackend transportBackend = this.f18778c.get(transportContext.getBackendName());
            if (transportBackend == null) {
                String format = String.format("Transport backend '%s' is not registered", transportContext.getBackendName());
                f18775f.warning(format);
                transportScheduleCallback.onSchedule(new IllegalArgumentException(format));
                return;
            }
            this.f18780e.runCriticalSection(new b(this, transportContext, transportBackend.decorate(eventInternal)));
            transportScheduleCallback.onSchedule(null);
        } catch (Exception e4) {
            Logger logger = f18775f;
            logger.warning("Error scheduling event " + e4.getMessage());
            transportScheduleCallback.onSchedule(e4);
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.Scheduler
    public void schedule(TransportContext transportContext, EventInternal eventInternal, TransportScheduleCallback transportScheduleCallback) {
        this.f18777b.execute(new a(this, transportContext, transportScheduleCallback, eventInternal));
    }
}
