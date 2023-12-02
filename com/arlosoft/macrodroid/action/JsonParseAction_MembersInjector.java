package com.arlosoft.macrodroid.action;

import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class JsonParseAction_MembersInjector implements MembersInjector<JsonParseAction> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f2269a;

    public JsonParseAction_MembersInjector(Provider<PremiumStatusHandler> provider) {
        this.f2269a = provider;
    }

    public static MembersInjector<JsonParseAction> create(Provider<PremiumStatusHandler> provider) {
        return new JsonParseAction_MembersInjector(provider);
    }

    public static void injectPremiumStatusHandler(JsonParseAction jsonParseAction, PremiumStatusHandler premiumStatusHandler) {
        jsonParseAction.premiumStatusHandler = premiumStatusHandler;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(JsonParseAction jsonParseAction) {
        injectPremiumStatusHandler(jsonParseAction, this.f2269a.get());
    }
}
