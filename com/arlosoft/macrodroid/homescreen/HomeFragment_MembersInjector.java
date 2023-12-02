package com.arlosoft.macrodroid.homescreen;

import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.freeversion.FreeVersionHelper;
import com.arlosoft.macrodroid.homescreen.infobar.InfoBarHandler;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import com.arlosoft.macrodroid.upgrade.flashsale.FlashSaleManager;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class HomeFragment_MembersInjector implements MembersInjector<HomeFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<RemoteConfig> f12310a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ProfileImageProvider> f12311b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<UserProvider> f12312c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<FlashSaleManager> f12313d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f12314e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<InfoBarHandler> f12315f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<FreeVersionHelper> f12316g;

    public HomeFragment_MembersInjector(Provider<RemoteConfig> provider, Provider<ProfileImageProvider> provider2, Provider<UserProvider> provider3, Provider<FlashSaleManager> provider4, Provider<PremiumStatusHandler> provider5, Provider<InfoBarHandler> provider6, Provider<FreeVersionHelper> provider7) {
        this.f12310a = provider;
        this.f12311b = provider2;
        this.f12312c = provider3;
        this.f12313d = provider4;
        this.f12314e = provider5;
        this.f12315f = provider6;
        this.f12316g = provider7;
    }

    public static MembersInjector<HomeFragment> create(Provider<RemoteConfig> provider, Provider<ProfileImageProvider> provider2, Provider<UserProvider> provider3, Provider<FlashSaleManager> provider4, Provider<PremiumStatusHandler> provider5, Provider<InfoBarHandler> provider6, Provider<FreeVersionHelper> provider7) {
        return new HomeFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static void injectFlashSaleManager(HomeFragment homeFragment, FlashSaleManager flashSaleManager) {
        homeFragment.flashSaleManager = flashSaleManager;
    }

    public static void injectFreeVersionHelper(HomeFragment homeFragment, FreeVersionHelper freeVersionHelper) {
        homeFragment.freeVersionHelper = freeVersionHelper;
    }

    public static void injectInfoBarHandler(HomeFragment homeFragment, InfoBarHandler infoBarHandler) {
        homeFragment.infoBarHandler = infoBarHandler;
    }

    public static void injectPremiumStatusHandler(HomeFragment homeFragment, PremiumStatusHandler premiumStatusHandler) {
        homeFragment.premiumStatusHandler = premiumStatusHandler;
    }

    public static void injectProfileImageProvider(HomeFragment homeFragment, ProfileImageProvider profileImageProvider) {
        homeFragment.profileImageProvider = profileImageProvider;
    }

    public static void injectRemoteConfig(HomeFragment homeFragment, RemoteConfig remoteConfig) {
        homeFragment.remoteConfig = remoteConfig;
    }

    public static void injectUserProvider(HomeFragment homeFragment, UserProvider userProvider) {
        homeFragment.userProvider = userProvider;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(HomeFragment homeFragment) {
        injectRemoteConfig(homeFragment, this.f12310a.get());
        injectProfileImageProvider(homeFragment, this.f12311b.get());
        injectUserProvider(homeFragment, this.f12312c.get());
        injectFlashSaleManager(homeFragment, this.f12313d.get());
        injectPremiumStatusHandler(homeFragment, this.f12314e.get());
        injectInfoBarHandler(homeFragment, this.f12315f.get());
        injectFreeVersionHelper(homeFragment, this.f12316g.get());
    }
}
