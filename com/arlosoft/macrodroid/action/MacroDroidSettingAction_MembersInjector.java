package com.arlosoft.macrodroid.action;

import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class MacroDroidSettingAction_MembersInjector implements MembersInjector<MacroDroidSettingAction> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f2310a;

    public MacroDroidSettingAction_MembersInjector(Provider<PremiumStatusHandler> provider) {
        this.f2310a = provider;
    }

    public static MembersInjector<MacroDroidSettingAction> create(Provider<PremiumStatusHandler> provider) {
        return new MacroDroidSettingAction_MembersInjector(provider);
    }

    public static void injectPremiumStatusHandler(MacroDroidSettingAction macroDroidSettingAction, PremiumStatusHandler premiumStatusHandler) {
        macroDroidSettingAction.f2309c = premiumStatusHandler;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MacroDroidSettingAction macroDroidSettingAction) {
        injectPremiumStatusHandler(macroDroidSettingAction, this.f2310a.get());
    }
}
