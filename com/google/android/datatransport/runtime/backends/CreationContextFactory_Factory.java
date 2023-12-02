package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import com.google.android.datatransport.runtime.time.Clock;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class CreationContextFactory_Factory implements Factory<CreationContextFactory> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f18710a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Clock> f18711b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Clock> f18712c;

    public CreationContextFactory_Factory(Provider<Context> provider, Provider<Clock> provider2, Provider<Clock> provider3) {
        this.f18710a = provider;
        this.f18711b = provider2;
        this.f18712c = provider3;
    }

    public static CreationContextFactory_Factory create(Provider<Context> provider, Provider<Clock> provider2, Provider<Clock> provider3) {
        return new CreationContextFactory_Factory(provider, provider2, provider3);
    }

    public static CreationContextFactory newInstance(Context context, Clock clock, Clock clock2) {
        return new CreationContextFactory(context, clock, clock2);
    }

    @Override // javax.inject.Provider
    public CreationContextFactory get() {
        return newInstance(this.f18710a.get(), this.f18711b.get(), this.f18712c.get());
    }
}
