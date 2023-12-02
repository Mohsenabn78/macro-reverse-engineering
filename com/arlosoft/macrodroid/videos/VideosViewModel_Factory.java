package com.arlosoft.macrodroid.videos;

import com.arlosoft.macrodroid.videos.util.VideoHelper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class VideosViewModel_Factory implements Factory<VideosViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<VideoDataRepository> f16435a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<VideoHelper> f16436b;

    public VideosViewModel_Factory(Provider<VideoDataRepository> provider, Provider<VideoHelper> provider2) {
        this.f16435a = provider;
        this.f16436b = provider2;
    }

    public static VideosViewModel_Factory create(Provider<VideoDataRepository> provider, Provider<VideoHelper> provider2) {
        return new VideosViewModel_Factory(provider, provider2);
    }

    public static VideosViewModel newVideosViewModel(VideoDataRepository videoDataRepository, VideoHelper videoHelper) {
        return new VideosViewModel(videoDataRepository, videoHelper);
    }

    public static VideosViewModel provideInstance(Provider<VideoDataRepository> provider, Provider<VideoHelper> provider2) {
        return new VideosViewModel(provider.get(), provider2.get());
    }

    @Override // javax.inject.Provider
    public VideosViewModel get() {
        return provideInstance(this.f16435a, this.f16436b);
    }
}
