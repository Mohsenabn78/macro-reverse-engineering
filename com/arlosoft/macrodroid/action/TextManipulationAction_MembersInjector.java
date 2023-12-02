package com.arlosoft.macrodroid.action;

import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class TextManipulationAction_MembersInjector implements MembersInjector<TextManipulationAction> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f2661a;

    public TextManipulationAction_MembersInjector(Provider<PremiumStatusHandler> provider) {
        this.f2661a = provider;
    }

    public static MembersInjector<TextManipulationAction> create(Provider<PremiumStatusHandler> provider) {
        return new TextManipulationAction_MembersInjector(provider);
    }

    public static void injectPremiumStatusHandler(TextManipulationAction textManipulationAction, PremiumStatusHandler premiumStatusHandler) {
        textManipulationAction.f2630c = premiumStatusHandler;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(TextManipulationAction textManipulationAction) {
        injectPremiumStatusHandler(textManipulationAction, this.f2661a.get());
    }
}
