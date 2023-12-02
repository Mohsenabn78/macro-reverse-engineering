package com.arlosoft.macrodroid.action;

import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.screenread.ScreenContentsCache;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ReadScreenContentsAction_MembersInjector implements MembersInjector<ReadScreenContentsAction> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ScreenContentsCache> f2440a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f2441b;

    public ReadScreenContentsAction_MembersInjector(Provider<ScreenContentsCache> provider, Provider<PremiumStatusHandler> provider2) {
        this.f2440a = provider;
        this.f2441b = provider2;
    }

    public static MembersInjector<ReadScreenContentsAction> create(Provider<ScreenContentsCache> provider, Provider<PremiumStatusHandler> provider2) {
        return new ReadScreenContentsAction_MembersInjector(provider, provider2);
    }

    public static void injectPremiumStatusHandler(ReadScreenContentsAction readScreenContentsAction, PremiumStatusHandler premiumStatusHandler) {
        readScreenContentsAction.premiumStatusHandler = premiumStatusHandler;
    }

    public static void injectScreenContentsCache(ReadScreenContentsAction readScreenContentsAction, ScreenContentsCache screenContentsCache) {
        readScreenContentsAction.screenContentsCache = screenContentsCache;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(ReadScreenContentsAction readScreenContentsAction) {
        injectScreenContentsCache(readScreenContentsAction, this.f2440a.get());
        injectPremiumStatusHandler(readScreenContentsAction, this.f2441b.get());
    }
}
