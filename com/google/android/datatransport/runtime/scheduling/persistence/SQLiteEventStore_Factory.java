package com.google.android.datatransport.runtime.scheduling.persistence;

import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SQLiteEventStore_Factory implements Factory<SQLiteEventStore> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Clock> f18891a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Clock> f18892b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<EventStoreConfig> f18893c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<SchemaManager> f18894d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<String> f18895e;

    public SQLiteEventStore_Factory(Provider<Clock> provider, Provider<Clock> provider2, Provider<EventStoreConfig> provider3, Provider<SchemaManager> provider4, Provider<String> provider5) {
        this.f18891a = provider;
        this.f18892b = provider2;
        this.f18893c = provider3;
        this.f18894d = provider4;
        this.f18895e = provider5;
    }

    public static SQLiteEventStore_Factory create(Provider<Clock> provider, Provider<Clock> provider2, Provider<EventStoreConfig> provider3, Provider<SchemaManager> provider4, Provider<String> provider5) {
        return new SQLiteEventStore_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static SQLiteEventStore newInstance(Clock clock, Clock clock2, Object obj, Object obj2, Provider<String> provider) {
        return new SQLiteEventStore(clock, clock2, (EventStoreConfig) obj, (SchemaManager) obj2, provider);
    }

    @Override // javax.inject.Provider
    public SQLiteEventStore get() {
        return newInstance(this.f18891a.get(), this.f18892b.get(), this.f18893c.get(), this.f18894d.get(), this.f18895e);
    }
}
