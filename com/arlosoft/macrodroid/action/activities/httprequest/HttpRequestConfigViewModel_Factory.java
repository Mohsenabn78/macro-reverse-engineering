package com.arlosoft.macrodroid.action.activities.httprequest;

import android.content.res.Resources;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class HttpRequestConfigViewModel_Factory implements Factory<HttpRequestConfigViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Resources> f3034a;

    public HttpRequestConfigViewModel_Factory(Provider<Resources> provider) {
        this.f3034a = provider;
    }

    public static HttpRequestConfigViewModel_Factory create(Provider<Resources> provider) {
        return new HttpRequestConfigViewModel_Factory(provider);
    }

    public static HttpRequestConfigViewModel newHttpRequestConfigViewModel(Resources resources) {
        return new HttpRequestConfigViewModel(resources);
    }

    public static HttpRequestConfigViewModel provideInstance(Provider<Resources> provider) {
        return new HttpRequestConfigViewModel(provider.get());
    }

    @Override // javax.inject.Provider
    public HttpRequestConfigViewModel get() {
        return provideInstance(this.f3034a);
    }
}
