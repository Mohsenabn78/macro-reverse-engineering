package com.arlosoft.macrodroid.triggers.mediabutton;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class MediaButtonDetection_Factory implements Factory<MediaButtonDetection> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f15198a;

    public MediaButtonDetection_Factory(Provider<Context> provider) {
        this.f15198a = provider;
    }

    public static MediaButtonDetection_Factory create(Provider<Context> provider) {
        return new MediaButtonDetection_Factory(provider);
    }

    public static MediaButtonDetection newMediaButtonDetection(Context context) {
        return new MediaButtonDetection(context);
    }

    public static MediaButtonDetection provideInstance(Provider<Context> provider) {
        return new MediaButtonDetection(provider.get());
    }

    @Override // javax.inject.Provider
    public MediaButtonDetection get() {
        return provideInstance(this.f15198a);
    }
}
