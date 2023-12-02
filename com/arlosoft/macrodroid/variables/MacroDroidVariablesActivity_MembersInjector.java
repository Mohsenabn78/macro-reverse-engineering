package com.arlosoft.macrodroid.variables;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class MacroDroidVariablesActivity_MembersInjector implements MembersInjector<MacroDroidVariablesActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f16179a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f16180b;

    public MacroDroidVariablesActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<PremiumStatusHandler> provider2) {
        this.f16179a = provider;
        this.f16180b = provider2;
    }

    public static MembersInjector<MacroDroidVariablesActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<PremiumStatusHandler> provider2) {
        return new MacroDroidVariablesActivity_MembersInjector(provider, provider2);
    }

    public static void injectPremiumStatusHandler(MacroDroidVariablesActivity macroDroidVariablesActivity, PremiumStatusHandler premiumStatusHandler) {
        macroDroidVariablesActivity.f16172f = premiumStatusHandler;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MacroDroidVariablesActivity macroDroidVariablesActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(macroDroidVariablesActivity, this.f16179a.get());
        injectPremiumStatusHandler(macroDroidVariablesActivity, this.f16180b.get());
    }
}
