package com.arlosoft.macrodroid.app.di;

import com.arlosoft.macrodroid.videos.api.VideosApi;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* loaded from: classes3.dex */
public final class NetworkingModule_ProvidesVideosApiFactory implements Factory<VideosApi> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OkHttpClient> f9273a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Gson> f9274b;

    public NetworkingModule_ProvidesVideosApiFactory(Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        this.f9273a = provider;
        this.f9274b = provider2;
    }

    public static NetworkingModule_ProvidesVideosApiFactory create(Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        return new NetworkingModule_ProvidesVideosApiFactory(provider, provider2);
    }

    public static VideosApi provideInstance(Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        return proxyProvidesVideosApi(provider.get(), provider2.get());
    }

    public static VideosApi proxyProvidesVideosApi(OkHttpClient okHttpClient, Gson gson) {
        return (VideosApi) Preconditions.checkNotNull(NetworkingModule.providesVideosApi(okHttpClient, gson), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public VideosApi get() {
        return provideInstance(this.f9273a, this.f9274b);
    }
}
