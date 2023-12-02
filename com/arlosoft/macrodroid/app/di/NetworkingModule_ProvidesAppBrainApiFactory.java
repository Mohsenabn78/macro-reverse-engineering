package com.arlosoft.macrodroid.app.di;

import com.arlosoft.macrodroid.plugins.api.AppBrainApi;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* loaded from: classes3.dex */
public final class NetworkingModule_ProvidesAppBrainApiFactory implements Factory<AppBrainApi> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OkHttpClient> f9256a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Gson> f9257b;

    public NetworkingModule_ProvidesAppBrainApiFactory(Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        this.f9256a = provider;
        this.f9257b = provider2;
    }

    public static NetworkingModule_ProvidesAppBrainApiFactory create(Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        return new NetworkingModule_ProvidesAppBrainApiFactory(provider, provider2);
    }

    public static AppBrainApi provideInstance(Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        return proxyProvidesAppBrainApi(provider.get(), provider2.get());
    }

    public static AppBrainApi proxyProvidesAppBrainApi(OkHttpClient okHttpClient, Gson gson) {
        return (AppBrainApi) Preconditions.checkNotNull(NetworkingModule.providesAppBrainApi(okHttpClient, gson), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public AppBrainApi get() {
        return provideInstance(this.f9256a, this.f9257b);
    }
}
