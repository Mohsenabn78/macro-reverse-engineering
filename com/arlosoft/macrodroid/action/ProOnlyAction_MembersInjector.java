package com.arlosoft.macrodroid.action;

import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ProOnlyAction_MembersInjector implements MembersInjector<ProOnlyAction> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f2416a;

    public ProOnlyAction_MembersInjector(Provider<PremiumStatusHandler> provider) {
        this.f2416a = provider;
    }

    public static MembersInjector<ProOnlyAction> create(Provider<PremiumStatusHandler> provider) {
        return new ProOnlyAction_MembersInjector(provider);
    }

    public static void injectPremiumStatusHandler(ProOnlyAction proOnlyAction, PremiumStatusHandler premiumStatusHandler) {
        proOnlyAction.premiumStatusHandler = premiumStatusHandler;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(ProOnlyAction proOnlyAction) {
        injectPremiumStatusHandler(proOnlyAction, this.f2416a.get());
    }
}
