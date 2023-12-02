package com.arlosoft.macrodroid.app.di;

import com.arlosoft.macrodroid.action.email.api.UpgradeApi;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

/* loaded from: classes3.dex */
public final class NetworkingModule_ProvidesUpgradeApiFactory implements Factory<UpgradeApi> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<OkHttpClient> f9271a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<Gson> f9272b;

    public NetworkingModule_ProvidesUpgradeApiFactory(Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        this.f9271a = provider;
        this.f9272b = provider2;
    }

    public static NetworkingModule_ProvidesUpgradeApiFactory create(Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        return new NetworkingModule_ProvidesUpgradeApiFactory(provider, provider2);
    }

    public static UpgradeApi provideInstance(Provider<OkHttpClient> provider, Provider<Gson> provider2) {
        return proxyProvidesUpgradeApi(provider.get(), provider2.get());
    }

    public static UpgradeApi proxyProvidesUpgradeApi(OkHttpClient okHttpClient, Gson gson) {
        return (UpgradeApi) Preconditions.checkNotNull(NetworkingModule.providesUpgradeApi(okHttpClient, gson), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public UpgradeApi get() {
        return provideInstance(this.f9271a, this.f9272b);
    }
}
