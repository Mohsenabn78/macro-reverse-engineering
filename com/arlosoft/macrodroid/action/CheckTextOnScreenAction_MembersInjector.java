package com.arlosoft.macrodroid.action;

import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.screenread.ScreenContentsCache;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class CheckTextOnScreenAction_MembersInjector implements MembersInjector<CheckTextOnScreenAction> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ScreenContentsCache> f2118a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f2119b;

    public CheckTextOnScreenAction_MembersInjector(Provider<ScreenContentsCache> provider, Provider<PremiumStatusHandler> provider2) {
        this.f2118a = provider;
        this.f2119b = provider2;
    }

    public static MembersInjector<CheckTextOnScreenAction> create(Provider<ScreenContentsCache> provider, Provider<PremiumStatusHandler> provider2) {
        return new CheckTextOnScreenAction_MembersInjector(provider, provider2);
    }

    public static void injectPremiumStatusHandler(CheckTextOnScreenAction checkTextOnScreenAction, PremiumStatusHandler premiumStatusHandler) {
        checkTextOnScreenAction.premiumStatusHandler = premiumStatusHandler;
    }

    public static void injectScreenContentsCache(CheckTextOnScreenAction checkTextOnScreenAction, ScreenContentsCache screenContentsCache) {
        checkTextOnScreenAction.screenContentsCache = screenContentsCache;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(CheckTextOnScreenAction checkTextOnScreenAction) {
        injectScreenContentsCache(checkTextOnScreenAction, this.f2118a.get());
        injectPremiumStatusHandler(checkTextOnScreenAction, this.f2119b.get());
    }
}
