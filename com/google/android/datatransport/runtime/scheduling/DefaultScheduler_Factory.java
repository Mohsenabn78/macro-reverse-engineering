package com.google.android.datatransport.runtime.scheduling;

import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class DefaultScheduler_Factory implements Factory<DefaultScheduler> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Executor> f18781a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<BackendRegistry> f18782b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<WorkScheduler> f18783c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<EventStore> f18784d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<SynchronizationGuard> f18785e;

    public DefaultScheduler_Factory(Provider<Executor> provider, Provider<BackendRegistry> provider2, Provider<WorkScheduler> provider3, Provider<EventStore> provider4, Provider<SynchronizationGuard> provider5) {
        this.f18781a = provider;
        this.f18782b = provider2;
        this.f18783c = provider3;
        this.f18784d = provider4;
        this.f18785e = provider5;
    }

    public static DefaultScheduler_Factory create(Provider<Executor> provider, Provider<BackendRegistry> provider2, Provider<WorkScheduler> provider3, Provider<EventStore> provider4, Provider<SynchronizationGuard> provider5) {
        return new DefaultScheduler_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static DefaultScheduler newInstance(Executor executor, BackendRegistry backendRegistry, WorkScheduler workScheduler, EventStore eventStore, SynchronizationGuard synchronizationGuard) {
        return new DefaultScheduler(executor, backendRegistry, workScheduler, eventStore, synchronizationGuard);
    }

    @Override // javax.inject.Provider
    public DefaultScheduler get() {
        return newInstance(this.f18781a.get(), this.f18782b.get(), this.f18783c.get(), this.f18784d.get(), this.f18785e.get());
    }
}
