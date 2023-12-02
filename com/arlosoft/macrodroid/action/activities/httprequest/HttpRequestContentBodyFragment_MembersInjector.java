package com.arlosoft.macrodroid.action.activities.httprequest;

import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class HttpRequestContentBodyFragment_MembersInjector implements MembersInjector<HttpRequestContentBodyFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<HttpRequestConfigViewModel> f3042a;

    public HttpRequestContentBodyFragment_MembersInjector(Provider<HttpRequestConfigViewModel> provider) {
        this.f3042a = provider;
    }

    public static MembersInjector<HttpRequestContentBodyFragment> create(Provider<HttpRequestConfigViewModel> provider) {
        return new HttpRequestContentBodyFragment_MembersInjector(provider);
    }

    public static void injectViewModel(HttpRequestContentBodyFragment httpRequestContentBodyFragment, HttpRequestConfigViewModel httpRequestConfigViewModel) {
        httpRequestContentBodyFragment.viewModel = httpRequestConfigViewModel;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(HttpRequestContentBodyFragment httpRequestContentBodyFragment) {
        injectViewModel(httpRequestContentBodyFragment, this.f3042a.get());
    }
}
