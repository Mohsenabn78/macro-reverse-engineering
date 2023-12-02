package com.arlosoft.macrodroid.app.di;

import com.arlosoft.macrodroid.translations.api.LocaliseApi;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* loaded from: classes3.dex */
public final class NetworkingModule_ProvidesTranslationsApiFactory implements Factory<LocaliseApi> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OkHttpClient> f9269a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Gson> f9270b;

    public NetworkingModule_ProvidesTranslationsApiFactory(Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        this.f9269a = provider;
        this.f9270b = provider2;
    }

    public static NetworkingModule_ProvidesTranslationsApiFactory create(Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        return new NetworkingModule_ProvidesTranslationsApiFactory(provider, provider2);
    }

    public static LocaliseApi provideInstance(Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        return proxyProvidesTranslationsApi(provider.get(), provider2.get());
    }

    public static LocaliseApi proxyProvidesTranslationsApi(OkHttpClient okHttpClient, Gson gson) {
        return (LocaliseApi) Preconditions.checkNotNull(NetworkingModule.providesTranslationsApi(okHttpClient, gson), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public LocaliseApi get() {
        return provideInstance(this.f9269a, this.f9270b);
    }
}
