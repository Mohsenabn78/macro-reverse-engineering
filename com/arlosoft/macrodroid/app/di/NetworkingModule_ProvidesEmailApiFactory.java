package com.arlosoft.macrodroid.app.di;

import com.arlosoft.macrodroid.action.email.api.EmailApi;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* loaded from: classes3.dex */
public final class NetworkingModule_ProvidesEmailApiFactory implements Factory<EmailApi> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OkHttpClient> f9260a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Gson> f9261b;

    public NetworkingModule_ProvidesEmailApiFactory(Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        this.f9260a = provider;
        this.f9261b = provider2;
    }

    public static NetworkingModule_ProvidesEmailApiFactory create(Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        return new NetworkingModule_ProvidesEmailApiFactory(provider, provider2);
    }

    public static EmailApi provideInstance(Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        return proxyProvidesEmailApi(provider.get(), provider2.get());
    }

    public static EmailApi proxyProvidesEmailApi(OkHttpClient okHttpClient, Gson gson) {
        return (EmailApi) Preconditions.checkNotNull(NetworkingModule.providesEmailApi(okHttpClient, gson), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public EmailApi get() {
        return provideInstance(this.f9260a, this.f9261b);
    }
}
