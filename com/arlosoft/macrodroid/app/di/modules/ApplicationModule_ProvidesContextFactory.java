package com.arlosoft.macrodroid.app.di.modules;

import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class ApplicationModule_ProvidesContextFactory implements Factory<Context> {

    /* renamed from: a  reason: collision with root package name */
    private final ApplicationModule f9289a;

    public ApplicationModule_ProvidesContextFactory(ApplicationModule applicationModule) {
        this.f9289a = applicationModule;
    }

    public static ApplicationModule_ProvidesContextFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesContextFactory(applicationModule);
    }

    public static Context provideInstance(ApplicationModule applicationModule) {
        return proxyProvidesContext(applicationModule);
    }

    public static Context proxyProvidesContext(ApplicationModule applicationModule) {
        return (Context) Preconditions.checkNotNull(applicationModule.providesContext(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public Context get() {
        return provideInstance(this.f9289a);
    }
}
