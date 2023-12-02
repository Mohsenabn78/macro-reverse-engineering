package com.arlosoft.macrodroid.action.activities.httprequest;

import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class HttpRequestParamsFragment_MembersInjector implements MembersInjector<HttpRequestParamsFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<HttpRequestConfigViewModel> f3053a;

    public HttpRequestParamsFragment_MembersInjector(Provider<HttpRequestConfigViewModel> provider) {
        this.f3053a = provider;
    }

    public static MembersInjector<HttpRequestParamsFragment> create(Provider<HttpRequestConfigViewModel> provider) {
        return new HttpRequestParamsFragment_MembersInjector(provider);
    }

    public static void injectViewModel(HttpRequestParamsFragment httpRequestParamsFragment, HttpRequestConfigViewModel httpRequestConfigViewModel) {
        httpRequestParamsFragment.viewModel = httpRequestConfigViewModel;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(HttpRequestParamsFragment httpRequestParamsFragment) {
        injectViewModel(httpRequestParamsFragment, this.f3053a.get());
    }
}
