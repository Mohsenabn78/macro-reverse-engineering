package com.arlosoft.macrodroid.app.di.modules;

import com.arlosoft.macrodroid.templatestore.ui.SearchTermProvider;
import dagger.internal.Factory;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes3.dex */
public final class ActivityModule_ProvideSearchTermProviderFactory implements Factory<SearchTermProvider> {

    /* renamed from: a  reason: collision with root package name */
    private final ActivityModule f9278a;

    public ActivityModule_ProvideSearchTermProviderFactory(ActivityModule activityModule) {
        this.f9278a = activityModule;
    }

    public static ActivityModule_ProvideSearchTermProviderFactory create(ActivityModule activityModule) {
        return new ActivityModule_ProvideSearchTermProviderFactory(activityModule);
    }

    @Nullable
    public static SearchTermProvider provideInstance(ActivityModule activityModule) {
        return proxyProvideSearchTermProvider(activityModule);
    }

    @Nullable
    public static SearchTermProvider proxyProvideSearchTermProvider(ActivityModule activityModule) {
        return activityModule.provideSearchTermProvider();
    }

    @Override // javax.inject.Provider
    @Nullable
    public SearchTermProvider get() {
        return provideInstance(this.f9278a);
    }
}
