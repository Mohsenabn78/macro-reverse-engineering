package com.arlosoft.macrodroid.action;

import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.uiinteraction.UIInteractionResultCache;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class UIInteractionAction_MembersInjector implements MembersInjector<UIInteractionAction> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<UIInteractionResultCache> f2739a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f2740b;

    public UIInteractionAction_MembersInjector(Provider<UIInteractionResultCache> provider, Provider<PremiumStatusHandler> provider2) {
        this.f2739a = provider;
        this.f2740b = provider2;
    }

    public static MembersInjector<UIInteractionAction> create(Provider<UIInteractionResultCache> provider, Provider<PremiumStatusHandler> provider2) {
        return new UIInteractionAction_MembersInjector(provider, provider2);
    }

    public static void injectPremiumStatusHandler(UIInteractionAction uIInteractionAction, PremiumStatusHandler premiumStatusHandler) {
        uIInteractionAction.premiumStatusHandler = premiumStatusHandler;
    }

    public static void injectUiInteractionResultCache(UIInteractionAction uIInteractionAction, UIInteractionResultCache uIInteractionResultCache) {
        uIInteractionAction.uiInteractionResultCache = uIInteractionResultCache;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(UIInteractionAction uIInteractionAction) {
        injectUiInteractionResultCache(uIInteractionAction, this.f2739a.get());
        injectPremiumStatusHandler(uIInteractionAction, this.f2740b.get());
    }
}
