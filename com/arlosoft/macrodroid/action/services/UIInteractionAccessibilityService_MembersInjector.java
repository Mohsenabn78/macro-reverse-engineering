package com.arlosoft.macrodroid.action.services;

import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.screenread.ScreenContentsCache;
import com.arlosoft.macrodroid.uiinteraction.UIInteractionResultCache;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UIInteractionAccessibilityService_MembersInjector implements MembersInjector<UIInteractionAccessibilityService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ScreenContentsCache> f4924a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<UIInteractionResultCache> f4925b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<RemoteConfig> f4926c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f4927d;

    public UIInteractionAccessibilityService_MembersInjector(Provider<ScreenContentsCache> provider, Provider<UIInteractionResultCache> provider2, Provider<RemoteConfig> provider3, Provider<PremiumStatusHandler> provider4) {
        this.f4924a = provider;
        this.f4925b = provider2;
        this.f4926c = provider3;
        this.f4927d = provider4;
    }

    public static MembersInjector<UIInteractionAccessibilityService> create(Provider<ScreenContentsCache> provider, Provider<UIInteractionResultCache> provider2, Provider<RemoteConfig> provider3, Provider<PremiumStatusHandler> provider4) {
        return new UIInteractionAccessibilityService_MembersInjector(provider, provider2, provider3, provider4);
    }

    public static void injectPremiumStatusHandler(UIInteractionAccessibilityService uIInteractionAccessibilityService, PremiumStatusHandler premiumStatusHandler) {
        uIInteractionAccessibilityService.premiumStatusHandler = premiumStatusHandler;
    }

    public static void injectRemoteConfig(UIInteractionAccessibilityService uIInteractionAccessibilityService, RemoteConfig remoteConfig) {
        uIInteractionAccessibilityService.remoteConfig = remoteConfig;
    }

    public static void injectScreenContentsCache(UIInteractionAccessibilityService uIInteractionAccessibilityService, ScreenContentsCache screenContentsCache) {
        uIInteractionAccessibilityService.screenContentsCache = screenContentsCache;
    }

    public static void injectUIInteractionResultCache(UIInteractionAccessibilityService uIInteractionAccessibilityService, UIInteractionResultCache uIInteractionResultCache) {
        uIInteractionAccessibilityService.uIInteractionResultCache = uIInteractionResultCache;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(UIInteractionAccessibilityService uIInteractionAccessibilityService) {
        injectScreenContentsCache(uIInteractionAccessibilityService, this.f4924a.get());
        injectUIInteractionResultCache(uIInteractionAccessibilityService, this.f4925b.get());
        injectRemoteConfig(uIInteractionAccessibilityService, this.f4926c.get());
        injectPremiumStatusHandler(uIInteractionAccessibilityService, this.f4927d.get());
    }
}
