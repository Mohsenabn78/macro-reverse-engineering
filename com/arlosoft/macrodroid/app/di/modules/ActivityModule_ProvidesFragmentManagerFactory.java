package com.arlosoft.macrodroid.app.di.modules;

import androidx.fragment.app.FragmentManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class ActivityModule_ProvidesFragmentManagerFactory implements Factory<FragmentManager> {

    /* renamed from: a  reason: collision with root package name */
    private final ActivityModule f9282a;

    public ActivityModule_ProvidesFragmentManagerFactory(ActivityModule activityModule) {
        this.f9282a = activityModule;
    }

    public static ActivityModule_ProvidesFragmentManagerFactory create(ActivityModule activityModule) {
        return new ActivityModule_ProvidesFragmentManagerFactory(activityModule);
    }

    public static FragmentManager provideInstance(ActivityModule activityModule) {
        return proxyProvidesFragmentManager(activityModule);
    }

    public static FragmentManager proxyProvidesFragmentManager(ActivityModule activityModule) {
        return (FragmentManager) Preconditions.checkNotNull(activityModule.providesFragmentManager(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public FragmentManager get() {
        return provideInstance(this.f9282a);
    }
}
