package com.arlosoft.macrodroid.action;

import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class SetVariableAction_MembersInjector implements MembersInjector<SetVariableAction> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f2550a;

    public SetVariableAction_MembersInjector(Provider<PremiumStatusHandler> provider) {
        this.f2550a = provider;
    }

    public static MembersInjector<SetVariableAction> create(Provider<PremiumStatusHandler> provider) {
        return new SetVariableAction_MembersInjector(provider);
    }

    public static void injectPremiumStatusHandler(SetVariableAction setVariableAction, PremiumStatusHandler premiumStatusHandler) {
        setVariableAction.f2497c = premiumStatusHandler;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(SetVariableAction setVariableAction) {
        injectPremiumStatusHandler(setVariableAction, this.f2550a.get());
    }
}
