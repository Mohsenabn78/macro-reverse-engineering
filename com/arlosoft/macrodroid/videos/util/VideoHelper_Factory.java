package com.arlosoft.macrodroid.videos.util;

import android.content.Context;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class VideoHelper_Factory implements Factory<VideoHelper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f16440a;

    public VideoHelper_Factory(Provider<Context> provider) {
        this.f16440a = provider;
    }

    public static VideoHelper_Factory create(Provider<Context> provider) {
        return new VideoHelper_Factory(provider);
    }

    public static VideoHelper newVideoHelper(Context context) {
        return new VideoHelper(context);
    }

    public static VideoHelper provideInstance(Provider<Context> provider) {
        return new VideoHelper(provider.get());
    }

    @Override // javax.inject.Provider
    public VideoHelper get() {
        return provideInstance(this.f16440a);
    }
}
