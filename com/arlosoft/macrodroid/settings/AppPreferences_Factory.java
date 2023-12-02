package com.arlosoft.macrodroid.settings;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class AppPreferences_Factory implements Factory<AppPreferences> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f13393a;

    public AppPreferences_Factory(Provider<Context> provider) {
        this.f13393a = provider;
    }

    public static AppPreferences_Factory create(Provider<Context> provider) {
        return new AppPreferences_Factory(provider);
    }

    public static AppPreferences newAppPreferences(Context context) {
        return new AppPreferences(context);
    }

    public static AppPreferences provideInstance(Provider<Context> provider) {
        return new AppPreferences(provider.get());
    }

    @Override // javax.inject.Provider
    public AppPreferences get() {
        return provideInstance(this.f13393a);
    }
}
