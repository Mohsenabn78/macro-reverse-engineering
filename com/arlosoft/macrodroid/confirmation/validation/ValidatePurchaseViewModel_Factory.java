package com.arlosoft.macrodroid.confirmation.validation;

import android.content.Context;
import com.arlosoft.macrodroid.action.email.api.UpgradeApi;
import com.arlosoft.macrodroid.upgrade.UpgradeHelper;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ValidatePurchaseViewModel_Factory implements Factory<ValidatePurchaseViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<UpgradeApi> f10141a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<UpgradeHelper> f10142b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Context> f10143c;

    public ValidatePurchaseViewModel_Factory(Provider<UpgradeApi> provider, Provider<UpgradeHelper> provider2, Provider<Context> provider3) {
        this.f10141a = provider;
        this.f10142b = provider2;
        this.f10143c = provider3;
    }

    public static ValidatePurchaseViewModel_Factory create(Provider<UpgradeApi> provider, Provider<UpgradeHelper> provider2, Provider<Context> provider3) {
        return new ValidatePurchaseViewModel_Factory(provider, provider2, provider3);
    }

    public static ValidatePurchaseViewModel newValidatePurchaseViewModel(UpgradeApi upgradeApi, UpgradeHelper upgradeHelper, Context context) {
        return new ValidatePurchaseViewModel(upgradeApi, upgradeHelper, context);
    }

    public static ValidatePurchaseViewModel provideInstance(Provider<UpgradeApi> provider, Provider<UpgradeHelper> provider2, Provider<Context> provider3) {
        return new ValidatePurchaseViewModel(provider.get(), provider2.get(), provider3.get());
    }

    @Override // javax.inject.Provider
    public ValidatePurchaseViewModel get() {
        return provideInstance(this.f10141a, this.f10142b, this.f10143c);
    }
}
