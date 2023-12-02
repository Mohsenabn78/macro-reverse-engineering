package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class WorkInitializer_Factory implements Factory<WorkInitializer> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Executor> f18832a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<EventStore> f18833b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<WorkScheduler> f18834c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<SynchronizationGuard> f18835d;

    public WorkInitializer_Factory(Provider<Executor> provider, Provider<EventStore> provider2, Provider<WorkScheduler> provider3, Provider<SynchronizationGuard> provider4) {
        this.f18832a = provider;
        this.f18833b = provider2;
        this.f18834c = provider3;
        this.f18835d = provider4;
    }

    public static WorkInitializer_Factory create(Provider<Executor> provider, Provider<EventStore> provider2, Provider<WorkScheduler> provider3, Provider<SynchronizationGuard> provider4) {
        return new WorkInitializer_Factory(provider, provider2, provider3, provider4);
    }

    public static WorkInitializer newInstance(Executor executor, EventStore eventStore, WorkScheduler workScheduler, SynchronizationGuard synchronizationGuard) {
        return new WorkInitializer(executor, eventStore, workScheduler, synchronizationGuard);
    }

    @Override // javax.inject.Provider
    public WorkInitializer get() {
        return newInstance(this.f18832a.get(), this.f18833b.get(), this.f18834c.get(), this.f18835d.get());
    }
}
