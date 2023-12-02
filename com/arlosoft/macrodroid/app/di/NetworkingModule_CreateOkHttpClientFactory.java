package com.arlosoft.macrodroid.app.di;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import okhttp3.OkHttpClient;

/* loaded from: classes3.dex */
public final class NetworkingModule_CreateOkHttpClientFactory implements Factory<OkHttpClient> {

    /* renamed from: a  reason: collision with root package name */
    private static final NetworkingModule_CreateOkHttpClientFactory f9254a = new NetworkingModule_CreateOkHttpClientFactory();

    public static NetworkingModule_CreateOkHttpClientFactory create() {
        return f9254a;
    }

    public static OkHttpClient provideInstance() {
        return proxyCreateOkHttpClient();
    }

    public static OkHttpClient proxyCreateOkHttpClient() {
        return (OkHttpClient) Preconditions.checkNotNull(NetworkingModule.createOkHttpClient(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public OkHttpClient get() {
        return provideInstance();
    }
}
