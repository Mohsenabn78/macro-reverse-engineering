package com.google.android.datatransport.runtime;

import android.content.Context;
import com.google.android.datatransport.runtime.TransportRuntimeComponent;
import com.google.android.datatransport.runtime.backends.CreationContextFactory_Factory;
import com.google.android.datatransport.runtime.backends.MetadataBackendRegistry_Factory;
import com.google.android.datatransport.runtime.dagger.internal.DoubleCheck;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.dagger.internal.InstanceFactory;
import com.google.android.datatransport.runtime.dagger.internal.Preconditions;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler;
import com.google.android.datatransport.runtime.scheduling.DefaultScheduler_Factory;
import com.google.android.datatransport.runtime.scheduling.SchedulingConfigModule_ConfigFactory;
import com.google.android.datatransport.runtime.scheduling.SchedulingModule_WorkSchedulerFactory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.Uploader_Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkInitializer_Factory;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.WorkScheduler;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_DbNameFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_PackageNameFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_SchemaVersionFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.EventStoreModule_StoreConfigFactory;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore;
import com.google.android.datatransport.runtime.scheduling.persistence.SQLiteEventStore_Factory;
import com.google.android.datatransport.runtime.scheduling.persistence.SchemaManager_Factory;
import com.google.android.datatransport.runtime.time.TimeModule_EventClockFactory;
import com.google.android.datatransport.runtime.time.TimeModule_UptimeClockFactory;
import java.util.concurrent.Executor;
import javax.inject.Provider;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class DaggerTransportRuntimeComponent extends TransportRuntimeComponent {

    /* renamed from: a  reason: collision with root package name */
    private Provider<Executor> f18658a;

    /* renamed from: b  reason: collision with root package name */
    private Provider<Context> f18659b;

    /* renamed from: c  reason: collision with root package name */
    private Provider f18660c;

    /* renamed from: d  reason: collision with root package name */
    private Provider f18661d;

    /* renamed from: e  reason: collision with root package name */
    private Provider f18662e;

    /* renamed from: f  reason: collision with root package name */
    private Provider<String> f18663f;

    /* renamed from: g  reason: collision with root package name */
    private Provider<SQLiteEventStore> f18664g;

    /* renamed from: h  reason: collision with root package name */
    private Provider<SchedulerConfig> f18665h;

    /* renamed from: i  reason: collision with root package name */
    private Provider<WorkScheduler> f18666i;

    /* renamed from: j  reason: collision with root package name */
    private Provider<DefaultScheduler> f18667j;

    /* renamed from: k  reason: collision with root package name */
    private Provider<Uploader> f18668k;

    /* renamed from: l  reason: collision with root package name */
    private Provider<WorkInitializer> f18669l;

    /* renamed from: m  reason: collision with root package name */
    private Provider<TransportRuntime> f18670m;

    /* loaded from: classes.dex */
    private static final class Builder implements TransportRuntimeComponent.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Context f18671a;

        private Builder() {
        }

        @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent.Builder
        /* renamed from: a */
        public Builder setApplicationContext(Context context) {
            this.f18671a = (Context) Preconditions.checkNotNull(context);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent.Builder
        public TransportRuntimeComponent build() {
            Preconditions.checkBuilderRequirement(this.f18671a, Context.class);
            return new DaggerTransportRuntimeComponent(this.f18671a);
        }
    }

    public static TransportRuntimeComponent.Builder d() {
        return new Builder();
    }

    private void e(Context context) {
        this.f18658a = DoubleCheck.provider(ExecutionModule_ExecutorFactory.create());
        Factory create = InstanceFactory.create(context);
        this.f18659b = create;
        CreationContextFactory_Factory create2 = CreationContextFactory_Factory.create(create, TimeModule_EventClockFactory.create(), TimeModule_UptimeClockFactory.create());
        this.f18660c = create2;
        this.f18661d = DoubleCheck.provider(MetadataBackendRegistry_Factory.create(this.f18659b, create2));
        this.f18662e = SchemaManager_Factory.create(this.f18659b, EventStoreModule_DbNameFactory.create(), EventStoreModule_SchemaVersionFactory.create());
        this.f18663f = DoubleCheck.provider(EventStoreModule_PackageNameFactory.create(this.f18659b));
        this.f18664g = DoubleCheck.provider(SQLiteEventStore_Factory.create(TimeModule_EventClockFactory.create(), TimeModule_UptimeClockFactory.create(), EventStoreModule_StoreConfigFactory.create(), this.f18662e, this.f18663f));
        SchedulingConfigModule_ConfigFactory create3 = SchedulingConfigModule_ConfigFactory.create(TimeModule_EventClockFactory.create());
        this.f18665h = create3;
        SchedulingModule_WorkSchedulerFactory create4 = SchedulingModule_WorkSchedulerFactory.create(this.f18659b, this.f18664g, create3, TimeModule_UptimeClockFactory.create());
        this.f18666i = create4;
        Provider<Executor> provider = this.f18658a;
        Provider provider2 = this.f18661d;
        Provider<SQLiteEventStore> provider3 = this.f18664g;
        this.f18667j = DefaultScheduler_Factory.create(provider, provider2, create4, provider3, provider3);
        Provider<Context> provider4 = this.f18659b;
        Provider provider5 = this.f18661d;
        Provider<SQLiteEventStore> provider6 = this.f18664g;
        this.f18668k = Uploader_Factory.create(provider4, provider5, provider6, this.f18666i, this.f18658a, provider6, TimeModule_EventClockFactory.create(), TimeModule_UptimeClockFactory.create(), this.f18664g);
        Provider<Executor> provider7 = this.f18658a;
        Provider<SQLiteEventStore> provider8 = this.f18664g;
        this.f18669l = WorkInitializer_Factory.create(provider7, provider8, this.f18666i, provider8);
        this.f18670m = DoubleCheck.provider(TransportRuntime_Factory.create(TimeModule_EventClockFactory.create(), TimeModule_UptimeClockFactory.create(), this.f18667j, this.f18668k, this.f18669l));
    }

    @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent
    EventStore b() {
        return this.f18664g.get();
    }

    @Override // com.google.android.datatransport.runtime.TransportRuntimeComponent
    TransportRuntime c() {
        return this.f18670m.get();
    }

    private DaggerTransportRuntimeComponent(Context context) {
        e(context);
    }
}
