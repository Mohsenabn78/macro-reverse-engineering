package com.arlosoft.macrodroid.app.di.modules;

import android.app.Activity;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class ActivityModule_ProvidesActivityFactory implements Factory<Activity> {

    /* renamed from: a  reason: collision with root package name */
    private final ActivityModule f9279a;

    public ActivityModule_ProvidesActivityFactory(ActivityModule activityModule) {
        this.f9279a = activityModule;
    }

    public static ActivityModule_ProvidesActivityFactory create(ActivityModule activityModule) {
        return new ActivityModule_ProvidesActivityFactory(activityModule);
    }

    public static Activity provideInstance(ActivityModule activityModule) {
        return proxyProvidesActivity(activityModule);
    }

    public static Activity proxyProvidesActivity(ActivityModule activityModule) {
        return (Activity) Preconditions.checkNotNull(activityModule.providesActivity(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public Activity get() {
        return provideInstance(this.f9279a);
    }
}
