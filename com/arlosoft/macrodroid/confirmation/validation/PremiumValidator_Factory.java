package com.arlosoft.macrodroid.confirmation.validation;

import android.content.Context;
import com.arlosoft.macrodroid.action.email.api.UpgradeApi;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class PremiumValidator_Factory implements Factory<PremiumValidator> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f10133a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<UpgradeApi> f10134b;

    public PremiumValidator_Factory(Provider<Context> provider, Provider<UpgradeApi> provider2) {
        this.f10133a = provider;
        this.f10134b = provider2;
    }

    public static PremiumValidator_Factory create(Provider<Context> provider, Provider<UpgradeApi> provider2) {
        return new PremiumValidator_Factory(provider, provider2);
    }

    public static PremiumValidator newPremiumValidator(Context context, UpgradeApi upgradeApi) {
        return new PremiumValidator(context, upgradeApi);
    }

    public static PremiumValidator provideInstance(Provider<Context> provider, Provider<UpgradeApi> provider2) {
        return new PremiumValidator(provider.get(), provider2.get());
    }

    @Override // javax.inject.Provider
    public PremiumValidator get() {
        return provideInstance(this.f10133a, this.f10134b);
    }
}
