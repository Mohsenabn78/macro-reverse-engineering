package com.arlosoft.macrodroid.app.di.modules;

import android.content.res.Resources;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class ActivityModule_ProvidesResourcesFactory implements Factory<Resources> {

    /* renamed from: a  reason: collision with root package name */
    private final ActivityModule f9284a;

    public ActivityModule_ProvidesResourcesFactory(ActivityModule activityModule) {
        this.f9284a = activityModule;
    }

    public static ActivityModule_ProvidesResourcesFactory create(ActivityModule activityModule) {
        return new ActivityModule_ProvidesResourcesFactory(activityModule);
    }

    public static Resources provideInstance(ActivityModule activityModule) {
        return proxyProvidesResources(activityModule);
    }

    public static Resources proxyProvidesResources(ActivityModule activityModule) {
        return (Resources) Preconditions.checkNotNull(activityModule.providesResources(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public Resources get() {
        return provideInstance(this.f9284a);
    }
}
