package com.arlosoft.macrodroid.extras;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ExtrasDownloader_Factory implements Factory<ExtrasDownloader> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f12008a;

    public ExtrasDownloader_Factory(Provider<Context> provider) {
        this.f12008a = provider;
    }

    public static ExtrasDownloader_Factory create(Provider<Context> provider) {
        return new ExtrasDownloader_Factory(provider);
    }

    public static ExtrasDownloader newExtrasDownloader(Context context) {
        return new ExtrasDownloader(context);
    }

    public static ExtrasDownloader provideInstance(Provider<Context> provider) {
        return new ExtrasDownloader(provider.get());
    }

    @Override // javax.inject.Provider
    public ExtrasDownloader get() {
        return provideInstance(this.f12008a);
    }
}
