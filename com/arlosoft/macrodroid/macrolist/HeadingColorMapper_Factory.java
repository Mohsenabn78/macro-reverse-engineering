package com.arlosoft.macrodroid.macrolist;

import android.app.Activity;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class HeadingColorMapper_Factory implements Factory<HeadingColorMapper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Activity> f12875a;

    public HeadingColorMapper_Factory(Provider<Activity> provider) {
        this.f12875a = provider;
    }

    public static HeadingColorMapper_Factory create(Provider<Activity> provider) {
        return new HeadingColorMapper_Factory(provider);
    }

    public static HeadingColorMapper newHeadingColorMapper(Activity activity) {
        return new HeadingColorMapper(activity);
    }

    public static HeadingColorMapper provideInstance(Provider<Activity> provider) {
        return new HeadingColorMapper(provider.get());
    }

    @Override // javax.inject.Provider
    public HeadingColorMapper get() {
        return provideInstance(this.f12875a);
    }
}
