package com.arlosoft.macrodroid.app.di;

import com.arlosoft.macrodroid.translations.api.MacroDroidTranslationsApi;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* loaded from: classes3.dex */
public final class NetworkingModule_ProvidesMacroDroidTranslationsApiFactory implements Factory<MacroDroidTranslationsApi> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OkHttpClient> f9262a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Gson> f9263b;

    public NetworkingModule_ProvidesMacroDroidTranslationsApiFactory(Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        this.f9262a = provider;
        this.f9263b = provider2;
    }

    public static NetworkingModule_ProvidesMacroDroidTranslationsApiFactory create(Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        return new NetworkingModule_ProvidesMacroDroidTranslationsApiFactory(provider, provider2);
    }

    public static MacroDroidTranslationsApi provideInstance(Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        return proxyProvidesMacroDroidTranslationsApi(provider.get(), provider2.get());
    }

    public static MacroDroidTranslationsApi proxyProvidesMacroDroidTranslationsApi(OkHttpClient okHttpClient, Gson gson) {
        return (MacroDroidTranslationsApi) Preconditions.checkNotNull(NetworkingModule.providesMacroDroidTranslationsApi(okHttpClient, gson), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public MacroDroidTranslationsApi get() {
        return provideInstance(this.f9262a, this.f9263b);
    }
}
