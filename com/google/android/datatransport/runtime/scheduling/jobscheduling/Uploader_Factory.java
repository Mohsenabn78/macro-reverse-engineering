package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.Context;
import com.google.android.datatransport.runtime.backends.BackendRegistry;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.ClientHealthMetricsStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class Uploader_Factory implements Factory<Uploader> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f18819a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<BackendRegistry> f18820b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<EventStore> f18821c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<WorkScheduler> f18822d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<Executor> f18823e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<SynchronizationGuard> f18824f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<Clock> f18825g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<Clock> f18826h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<ClientHealthMetricsStore> f18827i;

    public Uploader_Factory(Provider<Context> provider, Provider<BackendRegistry> provider2, Provider<EventStore> provider3, Provider<WorkScheduler> provider4, Provider<Executor> provider5, Provider<SynchronizationGuard> provider6, Provider<Clock> provider7, Provider<Clock> provider8, Provider<ClientHealthMetricsStore> provider9) {
        this.f18819a = provider;
        this.f18820b = provider2;
        this.f18821c = provider3;
        this.f18822d = provider4;
        this.f18823e = provider5;
        this.f18824f = provider6;
        this.f18825g = provider7;
        this.f18826h = provider8;
        this.f18827i = provider9;
    }

    public static Uploader_Factory create(Provider<Context> provider, Provider<BackendRegistry> provider2, Provider<EventStore> provider3, Provider<WorkScheduler> provider4, Provider<Executor> provider5, Provider<SynchronizationGuard> provider6, Provider<Clock> provider7, Provider<Clock> provider8, Provider<ClientHealthMetricsStore> provider9) {
        return new Uploader_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9);
    }

    public static Uploader newInstance(Context context, BackendRegistry backendRegistry, EventStore eventStore, WorkScheduler workScheduler, Executor executor, SynchronizationGuard synchronizationGuard, Clock clock, Clock clock2, ClientHealthMetricsStore clientHealthMetricsStore) {
        return new Uploader(context, backendRegistry, eventStore, workScheduler, executor, synchronizationGuard, clock, clock2, clientHealthMetricsStore);
    }

    @Override // javax.inject.Provider
    public Uploader get() {
        return newInstance(this.f18819a.get(), this.f18820b.get(), this.f18821c.get(), this.f18822d.get(), this.f18823e.get(), this.f18824f.get(), this.f18825g.get(), this.f18826h.get(), this.f18827i.get());
    }
}
