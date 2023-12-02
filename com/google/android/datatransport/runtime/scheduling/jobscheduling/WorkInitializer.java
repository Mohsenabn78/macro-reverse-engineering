package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* loaded from: classes.dex */
public class WorkInitializer {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f18828a;

    /* renamed from: b  reason: collision with root package name */
    private final EventStore f18829b;

    /* renamed from: c  reason: collision with root package name */
    private final WorkScheduler f18830c;

    /* renamed from: d  reason: collision with root package name */
    private final SynchronizationGuard f18831d;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public WorkInitializer(Executor executor, EventStore eventStore, WorkScheduler workScheduler, SynchronizationGuard synchronizationGuard) {
        this.f18828a = executor;
        this.f18829b = eventStore;
        this.f18830c = workScheduler;
        this.f18831d = synchronizationGuard;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object c() {
        for (TransportContext transportContext : this.f18829b.loadActiveContexts()) {
            this.f18830c.schedule(transportContext, 1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        this.f18831d.runCriticalSection(new SynchronizationGuard.CriticalSection() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.o
            @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard.CriticalSection
            public final Object execute() {
                Object c4;
                c4 = WorkInitializer.this.c();
                return c4;
            }
        });
    }

    public void ensureContextsScheduled() {
        this.f18828a.execute(new Runnable() { // from class: com.google.android.datatransport.runtime.scheduling.jobscheduling.n
            @Override // java.lang.Runnable
            public final void run() {
                WorkInitializer.this.d();
            }
        });
    }
}
