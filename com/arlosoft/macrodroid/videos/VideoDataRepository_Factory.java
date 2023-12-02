package com.arlosoft.macrodroid.videos;

import android.content.Context;
import com.arlosoft.macrodroid.videos.api.VideosApi;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class VideoDataRepository_Factory implements Factory<VideoDataRepository> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f16421a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<VideosApi> f16422b;

    public VideoDataRepository_Factory(Provider<Context> provider, Provider<VideosApi> provider2) {
        this.f16421a = provider;
        this.f16422b = provider2;
    }

    public static VideoDataRepository_Factory create(Provider<Context> provider, Provider<VideosApi> provider2) {
        return new VideoDataRepository_Factory(provider, provider2);
    }

    public static VideoDataRepository newVideoDataRepository(Context context, VideosApi videosApi) {
        return new VideoDataRepository(context, videosApi);
    }

    public static VideoDataRepository provideInstance(Provider<Context> provider, Provider<VideosApi> provider2) {
        return new VideoDataRepository(provider.get(), provider2.get());
    }

    @Override // javax.inject.Provider
    public VideoDataRepository get() {
        return provideInstance(this.f16421a, this.f16422b);
    }
}
