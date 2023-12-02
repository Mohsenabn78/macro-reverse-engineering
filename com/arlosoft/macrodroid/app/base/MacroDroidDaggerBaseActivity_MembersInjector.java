package com.arlosoft.macrodroid.app.base;

import androidx.fragment.app.Fragment;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class MacroDroidDaggerBaseActivity_MembersInjector implements MembersInjector<MacroDroidDaggerBaseActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f5701a;

    public MacroDroidDaggerBaseActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        this.f5701a = provider;
    }

    public static MembersInjector<MacroDroidDaggerBaseActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider) {
        return new MacroDroidDaggerBaseActivity_MembersInjector(provider);
    }

    public static void injectDispatchingFragmentAndroidInjector(MacroDroidDaggerBaseActivity macroDroidDaggerBaseActivity, DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector) {
        macroDroidDaggerBaseActivity.dispatchingFragmentAndroidInjector = dispatchingAndroidInjector;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MacroDroidDaggerBaseActivity macroDroidDaggerBaseActivity) {
        injectDispatchingFragmentAndroidInjector(macroDroidDaggerBaseActivity, this.f5701a.get());
    }
}
