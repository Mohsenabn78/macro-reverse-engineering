package com.arlosoft.macrodroid.app.di.modules;

import android.app.Application;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class ApplicationModule_ProvidesApplicationFactory implements Factory<Application> {

    /* renamed from: a  reason: collision with root package name */
    private final ApplicationModule f9288a;

    public ApplicationModule_ProvidesApplicationFactory(ApplicationModule applicationModule) {
        this.f9288a = applicationModule;
    }

    public static ApplicationModule_ProvidesApplicationFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesApplicationFactory(applicationModule);
    }

    public static Application provideInstance(ApplicationModule applicationModule) {
        return proxyProvidesApplication(applicationModule);
    }

    public static Application proxyProvidesApplication(ApplicationModule applicationModule) {
        return (Application) Preconditions.checkNotNull(applicationModule.providesApplication(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public Application get() {
        return provideInstance(this.f9288a);
    }
}
