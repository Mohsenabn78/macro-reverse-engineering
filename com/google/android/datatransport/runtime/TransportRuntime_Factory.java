package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.scheduling.Scheduler;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class TransportRuntime_Factory implements Factory<TransportRuntime> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Clock> f18691a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Clock> f18692b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Scheduler> f18693c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<Uploader> f18694d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<WorkInitializer> f18695e;

    public TransportRuntime_Factory(Provider<Clock> provider, Provider<Clock> provider2, Provider<Scheduler> provider3, Provider<Uploader> provider4, Provider<WorkInitializer> provider5) {
        this.f18691a = provider;
        this.f18692b = provider2;
        this.f18693c = provider3;
        this.f18694d = provider4;
        this.f18695e = provider5;
    }

    public static TransportRuntime_Factory create(Provider<Clock> provider, Provider<Clock> provider2, Provider<Scheduler> provider3, Provider<Uploader> provider4, Provider<WorkInitializer> provider5) {
        return new TransportRuntime_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static TransportRuntime newInstance(Clock clock, Clock clock2, Scheduler scheduler, Uploader uploader, WorkInitializer workInitializer) {
        return new TransportRuntime(clock, clock2, scheduler, uploader, workInitializer);
    }

    @Override // javax.inject.Provider
    public TransportRuntime get() {
        return newInstance(this.f18691a.get(), this.f18692b.get(), this.f18693c.get(), this.f18694d.get(), this.f18695e.get());
    }
}
