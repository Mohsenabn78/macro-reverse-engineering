package com.arlosoft.macrodroid.advert;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class AdvertActivity_MembersInjector implements MembersInjector<AdvertActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f5642a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<RemoteConfig> f5643b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f5644c;

    public AdvertActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<RemoteConfig> provider2, Provider<PremiumStatusHandler> provider3) {
        this.f5642a = provider;
        this.f5643b = provider2;
        this.f5644c = provider3;
    }

    public static MembersInjector<AdvertActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<RemoteConfig> provider2, Provider<PremiumStatusHandler> provider3) {
        return new AdvertActivity_MembersInjector(provider, provider2, provider3);
    }

    public static void injectPremiumStatusHandler(AdvertActivity advertActivity, PremiumStatusHandler premiumStatusHandler) {
        advertActivity.premiumStatusHandler = premiumStatusHandler;
    }

    public static void injectRemoteConfig(AdvertActivity advertActivity, RemoteConfig remoteConfig) {
        advertActivity.remoteConfig = remoteConfig;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(AdvertActivity advertActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(advertActivity, this.f5642a.get());
        injectRemoteConfig(advertActivity, this.f5643b.get());
        injectPremiumStatusHandler(advertActivity, this.f5644c.get());
    }
}
