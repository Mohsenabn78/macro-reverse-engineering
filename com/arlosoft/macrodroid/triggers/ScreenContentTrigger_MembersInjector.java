package com.arlosoft.macrodroid.triggers;

import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ScreenContentTrigger_MembersInjector implements MembersInjector<ScreenContentTrigger> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f14415a;

    public ScreenContentTrigger_MembersInjector(Provider<PremiumStatusHandler> provider) {
        this.f14415a = provider;
    }

    public static MembersInjector<ScreenContentTrigger> create(Provider<PremiumStatusHandler> provider) {
        return new ScreenContentTrigger_MembersInjector(provider);
    }

    public static void injectPremiumStatusHandler(ScreenContentTrigger screenContentTrigger, PremiumStatusHandler premiumStatusHandler) {
        screenContentTrigger.premiumStatusHandler = premiumStatusHandler;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(ScreenContentTrigger screenContentTrigger) {
        injectPremiumStatusHandler(screenContentTrigger, this.f14415a.get());
    }
}
