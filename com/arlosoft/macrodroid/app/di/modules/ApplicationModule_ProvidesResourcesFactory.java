package com.arlosoft.macrodroid.app.di.modules;

import android.content.res.Resources;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class ApplicationModule_ProvidesResourcesFactory implements Factory<Resources> {

    /* renamed from: a  reason: collision with root package name */
    private final ApplicationModule f9290a;

    public ApplicationModule_ProvidesResourcesFactory(ApplicationModule applicationModule) {
        this.f9290a = applicationModule;
    }

    public static ApplicationModule_ProvidesResourcesFactory create(ApplicationModule applicationModule) {
        return new ApplicationModule_ProvidesResourcesFactory(applicationModule);
    }

    public static Resources provideInstance(ApplicationModule applicationModule) {
        return proxyProvidesResources(applicationModule);
    }

    public static Resources proxyProvidesResources(ApplicationModule applicationModule) {
        return (Resources) Preconditions.checkNotNull(applicationModule.providesResources(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public Resources get() {
        return provideInstance(this.f9290a);
    }
}
