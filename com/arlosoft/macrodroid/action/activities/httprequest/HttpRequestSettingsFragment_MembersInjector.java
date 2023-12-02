package com.arlosoft.macrodroid.action.activities.httprequest;

import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class HttpRequestSettingsFragment_MembersInjector implements MembersInjector<HttpRequestSettingsFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<HttpRequestConfigViewModel> f3071a;

    public HttpRequestSettingsFragment_MembersInjector(Provider<HttpRequestConfigViewModel> provider) {
        this.f3071a = provider;
    }

    public static MembersInjector<HttpRequestSettingsFragment> create(Provider<HttpRequestConfigViewModel> provider) {
        return new HttpRequestSettingsFragment_MembersInjector(provider);
    }

    public static void injectViewModel(HttpRequestSettingsFragment httpRequestSettingsFragment, HttpRequestConfigViewModel httpRequestConfigViewModel) {
        httpRequestSettingsFragment.viewModel = httpRequestConfigViewModel;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(HttpRequestSettingsFragment httpRequestSettingsFragment) {
        injectViewModel(httpRequestSettingsFragment, this.f3071a.get());
    }
}
