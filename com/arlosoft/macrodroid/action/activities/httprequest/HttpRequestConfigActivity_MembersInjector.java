package com.arlosoft.macrodroid.action.activities.httprequest;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class HttpRequestConfigActivity_MembersInjector implements MembersInjector<HttpRequestConfigActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f3021a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<HttpRequestConfigViewModel> f3022b;

    public HttpRequestConfigActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<HttpRequestConfigViewModel> provider2) {
        this.f3021a = provider;
        this.f3022b = provider2;
    }

    public static MembersInjector<HttpRequestConfigActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<HttpRequestConfigViewModel> provider2) {
        return new HttpRequestConfigActivity_MembersInjector(provider, provider2);
    }

    public static void injectViewModel(HttpRequestConfigActivity httpRequestConfigActivity, HttpRequestConfigViewModel httpRequestConfigViewModel) {
        httpRequestConfigActivity.viewModel = httpRequestConfigViewModel;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(HttpRequestConfigActivity httpRequestConfigActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(httpRequestConfigActivity, this.f3021a.get());
        injectViewModel(httpRequestConfigActivity, this.f3022b.get());
    }
}
