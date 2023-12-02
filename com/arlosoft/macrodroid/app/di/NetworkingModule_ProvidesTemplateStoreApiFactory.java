package com.arlosoft.macrodroid.app.di;

import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApi;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* loaded from: classes3.dex */
public final class NetworkingModule_ProvidesTemplateStoreApiFactory implements Factory<TemplateStoreApi> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OkHttpClient> f9266a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Gson> f9267b;

    public NetworkingModule_ProvidesTemplateStoreApiFactory(Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        this.f9266a = provider;
        this.f9267b = provider2;
    }

    public static NetworkingModule_ProvidesTemplateStoreApiFactory create(Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        return new NetworkingModule_ProvidesTemplateStoreApiFactory(provider, provider2);
    }

    public static TemplateStoreApi provideInstance(Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        return proxyProvidesTemplateStoreApi(provider.get(), provider2.get());
    }

    public static TemplateStoreApi proxyProvidesTemplateStoreApi(OkHttpClient okHttpClient, Gson gson) {
        return (TemplateStoreApi) Preconditions.checkNotNull(NetworkingModule.providesTemplateStoreApi(okHttpClient, gson), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public TemplateStoreApi get() {
        return provideInstance(this.f9266a, this.f9267b);
    }
}
