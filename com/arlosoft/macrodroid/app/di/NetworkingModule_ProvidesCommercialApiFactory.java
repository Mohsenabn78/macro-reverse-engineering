package com.arlosoft.macrodroid.app.di;

import com.arlosoft.macrodroid.commercial.api.CommercialApi;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* loaded from: classes3.dex */
public final class NetworkingModule_ProvidesCommercialApiFactory implements Factory<CommercialApi> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OkHttpClient> f9258a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Gson> f9259b;

    public NetworkingModule_ProvidesCommercialApiFactory(Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        this.f9258a = provider;
        this.f9259b = provider2;
    }

    public static NetworkingModule_ProvidesCommercialApiFactory create(Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        return new NetworkingModule_ProvidesCommercialApiFactory(provider, provider2);
    }

    public static CommercialApi provideInstance(Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        return proxyProvidesCommercialApi(provider.get(), provider2.get());
    }

    public static CommercialApi proxyProvidesCommercialApi(OkHttpClient okHttpClient, Gson gson) {
        return (CommercialApi) Preconditions.checkNotNull(NetworkingModule.providesCommercialApi(okHttpClient, gson), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public CommercialApi get() {
        return provideInstance(this.f9258a, this.f9259b);
    }
}
