package com.arlosoft.macrodroid.logging.systemlog;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class SystemLogActivity_MembersInjector implements MembersInjector<SystemLogActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f12700a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<SystemLogViewModel> f12701b;

    public SystemLogActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<SystemLogViewModel> provider2) {
        this.f12700a = provider;
        this.f12701b = provider2;
    }

    public static MembersInjector<SystemLogActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<SystemLogViewModel> provider2) {
        return new SystemLogActivity_MembersInjector(provider, provider2);
    }

    public static void injectViewModel(SystemLogActivity systemLogActivity, SystemLogViewModel systemLogViewModel) {
        systemLogActivity.viewModel = systemLogViewModel;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(SystemLogActivity systemLogActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(systemLogActivity, this.f12700a.get());
        injectViewModel(systemLogActivity, this.f12701b.get());
    }
}
