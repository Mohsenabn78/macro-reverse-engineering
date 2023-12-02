package com.arlosoft.macrodroid.app.di;

import android.content.Context;
import com.google.gson.Gson;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class NetworkingModule_ProvideGsonFactory implements Factory<Gson> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f9255a;

    public NetworkingModule_ProvideGsonFactory(Provider<Context> provider) {
        this.f9255a = provider;
    }

    public static NetworkingModule_ProvideGsonFactory create(Provider<Context> provider) {
        return new NetworkingModule_ProvideGsonFactory(provider);
    }

    public static Gson provideInstance(Provider<Context> provider) {
        return proxyProvideGson(provider.get());
    }

    public static Gson proxyProvideGson(Context context) {
        return (Gson) Preconditions.checkNotNull(NetworkingModule.provideGson(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public Gson get() {
        return provideInstance(this.f9255a);
    }
}
