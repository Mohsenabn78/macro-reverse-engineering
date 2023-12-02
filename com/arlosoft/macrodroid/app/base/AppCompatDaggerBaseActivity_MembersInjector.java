package com.arlosoft.macrodroid.app.base;

import androidx.fragment.app.Fragment;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class AppCompatDaggerBaseActivity_MembersInjector implements MembersInjector<AppCompatDaggerBaseActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f5697a;

    public AppCompatDaggerBaseActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        this.f5697a = provider;
    }

    public static MembersInjector<AppCompatDaggerBaseActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        return new AppCompatDaggerBaseActivity_MembersInjector(provider);
    }

    public static void injectDispatchingFragmentAndroidInjector(AppCompatDaggerBaseActivity appCompatDaggerBaseActivity, DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector) {
        appCompatDaggerBaseActivity.dispatchingFragmentAndroidInjector = dispatchingAndroidInjector;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(AppCompatDaggerBaseActivity appCompatDaggerBaseActivity) {
        injectDispatchingFragmentAndroidInjector(appCompatDaggerBaseActivity, this.f5697a.get());
    }
}
