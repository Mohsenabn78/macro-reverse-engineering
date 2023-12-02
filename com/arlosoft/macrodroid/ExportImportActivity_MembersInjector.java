package com.arlosoft.macrodroid;

import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes2.dex */
public final class ExportImportActivity_MembersInjector implements MembersInjector<ExportImportActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f1997a;

    public ExportImportActivity_MembersInjector(Provider<PremiumStatusHandler> provider) {
        this.f1997a = provider;
    }

    public static MembersInjector<ExportImportActivity> create(Provider<PremiumStatusHandler> provider) {
        return new ExportImportActivity_MembersInjector(provider);
    }

    public static void injectPremiumStatusHandler(ExportImportActivity exportImportActivity, PremiumStatusHandler premiumStatusHandler) {
        exportImportActivity.f1961d = premiumStatusHandler;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(ExportImportActivity exportImportActivity) {
        injectPremiumStatusHandler(exportImportActivity, this.f1997a.get());
    }
}
