package com.arlosoft.macrodroid.triggers.services;

import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class QueryUiService_MembersInjector implements MembersInjector<QueryUiService> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f15525a;

    public QueryUiService_MembersInjector(Provider<PremiumStatusHandler> provider) {
        this.f15525a = provider;
    }

    public static MembersInjector<QueryUiService> create(Provider<PremiumStatusHandler> provider) {
        return new QueryUiService_MembersInjector(provider);
    }

    public static void injectPremiumStatusHandler(QueryUiService queryUiService, PremiumStatusHandler premiumStatusHandler) {
        queryUiService.premiumStatusHandler = premiumStatusHandler;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(QueryUiService queryUiService) {
        injectPremiumStatusHandler(queryUiService, this.f15525a.get());
    }
}
