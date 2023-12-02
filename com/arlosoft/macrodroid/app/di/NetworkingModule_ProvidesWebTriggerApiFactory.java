package com.arlosoft.macrodroid.app.di;

import com.arlosoft.macrodroid.triggers.webtrigger.api.WebTriggerApi;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* loaded from: classes3.dex */
public final class NetworkingModule_ProvidesWebTriggerApiFactory implements Factory<WebTriggerApi> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OkHttpClient> f9275a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Gson> f9276b;

    public NetworkingModule_ProvidesWebTriggerApiFactory(Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        this.f9275a = provider;
        this.f9276b = provider2;
    }

    public static NetworkingModule_ProvidesWebTriggerApiFactory create(Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        return new NetworkingModule_ProvidesWebTriggerApiFactory(provider, provider2);
    }

    public static WebTriggerApi provideInstance(Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        return proxyProvidesWebTriggerApi(provider.get(), provider2.get());
    }

    public static WebTriggerApi proxyProvidesWebTriggerApi(OkHttpClient okHttpClient, Gson gson) {
        return (WebTriggerApi) Preconditions.checkNotNull(NetworkingModule.providesWebTriggerApi(okHttpClient, gson), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public WebTriggerApi get() {
        return provideInstance(this.f9275a, this.f9276b);
    }
}
