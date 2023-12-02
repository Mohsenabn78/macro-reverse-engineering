package com.arlosoft.macrodroid;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class LauncherActivity_MembersInjector implements MembersInjector<LauncherActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f2003a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f2004b;

    public LauncherActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<PremiumStatusHandler> provider2) {
        this.f2003a = provider;
        this.f2004b = provider2;
    }

    public static MembersInjector<LauncherActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<PremiumStatusHandler> provider2) {
        return new LauncherActivity_MembersInjector(provider, provider2);
    }

    public static void injectPremiumStatusHandler(LauncherActivity launcherActivity, PremiumStatusHandler premiumStatusHandler) {
        launcherActivity.f2002f = premiumStatusHandler;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(LauncherActivity launcherActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(launcherActivity, this.f2003a.get());
        injectPremiumStatusHandler(launcherActivity, this.f2004b.get());
    }
}
