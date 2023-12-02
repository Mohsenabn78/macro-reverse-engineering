package com.arlosoft.macrodroid.app.di;

import com.arlosoft.macrodroid.plugins.api.PluginListApi;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* loaded from: classes3.dex */
public final class NetworkingModule_ProvidesPluginListApiFactory implements Factory<PluginListApi> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OkHttpClient> f9264a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Gson> f9265b;

    public NetworkingModule_ProvidesPluginListApiFactory(Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        this.f9264a = provider;
        this.f9265b = provider2;
    }

    public static NetworkingModule_ProvidesPluginListApiFactory create(Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        return new NetworkingModule_ProvidesPluginListApiFactory(provider, provider2);
    }

    public static PluginListApi provideInstance(Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        return proxyProvidesPluginListApi(provider.get(), provider2.get());
    }

    public static PluginListApi proxyProvidesPluginListApi(OkHttpClient okHttpClient, Gson gson) {
        return (PluginListApi) Preconditions.checkNotNull(NetworkingModule.providesPluginListApi(okHttpClient, gson), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public PluginListApi get() {
        return provideInstance(this.f9264a, this.f9265b);
    }
}
