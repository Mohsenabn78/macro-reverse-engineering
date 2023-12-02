package com.arlosoft.macrodroid.app.di.modules;

import android.view.LayoutInflater;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes3.dex */
public final class ActivityModule_ProvidesLayoutInflaterFactory implements Factory<LayoutInflater> {

    /* renamed from: a  reason: collision with root package name */
    private final ActivityModule f9283a;

    public ActivityModule_ProvidesLayoutInflaterFactory(ActivityModule activityModule) {
        this.f9283a = activityModule;
    }

    public static ActivityModule_ProvidesLayoutInflaterFactory create(ActivityModule activityModule) {
        return new ActivityModule_ProvidesLayoutInflaterFactory(activityModule);
    }

    public static LayoutInflater provideInstance(ActivityModule activityModule) {
        return proxyProvidesLayoutInflater(activityModule);
    }

    public static LayoutInflater proxyProvidesLayoutInflater(ActivityModule activityModule) {
        return (LayoutInflater) Preconditions.checkNotNull(activityModule.providesLayoutInflater(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public LayoutInflater get() {
        return provideInstance(this.f9283a);
    }
}
