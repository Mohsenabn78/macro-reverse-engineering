package com.arlosoft.macrodroid.app.di;

import com.arlosoft.macrodroid.triggers.webtrigger.api.TinyUrlApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* loaded from: classes3.dex */
public final class NetworkingModule_ProvidesTinyUrlApiFactory implements Factory<TinyUrlApi> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OkHttpClient> f9268a;

    public NetworkingModule_ProvidesTinyUrlApiFactory(Provider<OkHttpClient> provider) {
        this.f9268a = provider;
    }

    public static NetworkingModule_ProvidesTinyUrlApiFactory create(Provider<OkHttpClient> provider) {
        return new NetworkingModule_ProvidesTinyUrlApiFactory(provider);
    }

    public static TinyUrlApi provideInstance(Provider<OkHttpClient> provider) {
        return proxyProvidesTinyUrlApi(provider.get());
    }

    public static TinyUrlApi proxyProvidesTinyUrlApi(OkHttpClient okHttpClient) {
        return (TinyUrlApi) Preconditions.checkNotNull(NetworkingModule.providesTinyUrlApi(okHttpClient), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public TinyUrlApi get() {
        return provideInstance(this.f9268a);
    }
}
