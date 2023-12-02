package com.arlosoft.macrodroid.app.di.modules;

import android.app.Activity;
import android.content.Context;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ActivityModule_ProvidesContextFactory implements Factory<Context> {

    /* renamed from: a  reason: collision with root package name */
    private final ActivityModule f9280a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Activity> f9281b;

    public ActivityModule_ProvidesContextFactory(ActivityModule activityModule, Provider<Activity> provider) {
        this.f9280a = activityModule;
        this.f9281b = provider;
    }

    public static ActivityModule_ProvidesContextFactory create(ActivityModule activityModule, Provider<Activity> provider) {
        return new ActivityModule_ProvidesContextFactory(activityModule, provider);
    }

    public static Context provideInstance(ActivityModule activityModule, Provider<Activity> provider) {
        return proxyProvidesContext(activityModule, provider.get());
    }

    public static Context proxyProvidesContext(ActivityModule activityModule, Activity activity) {
        return (Context) Preconditions.checkNotNull(activityModule.providesContext(activity), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public Context get() {
        return provideInstance(this.f9280a, this.f9281b);
    }
}
