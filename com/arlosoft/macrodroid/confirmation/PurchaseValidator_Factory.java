package com.arlosoft.macrodroid.confirmation;

import android.content.Context;
import com.arlosoft.macrodroid.action.email.api.UpgradeApi;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class PurchaseValidator_Factory implements Factory<PurchaseValidator> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f10119a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<UpgradeApi> f10120b;

    public PurchaseValidator_Factory(Provider<Context> provider, Provider<UpgradeApi> provider2) {
        this.f10119a = provider;
        this.f10120b = provider2;
    }

    public static PurchaseValidator_Factory create(Provider<Context> provider, Provider<UpgradeApi> provider2) {
        return new PurchaseValidator_Factory(provider, provider2);
    }

    public static PurchaseValidator newPurchaseValidator(Context context, UpgradeApi upgradeApi) {
        return new PurchaseValidator(context, upgradeApi);
    }

    public static PurchaseValidator provideInstance(Provider<Context> provider, Provider<UpgradeApi> provider2) {
        return new PurchaseValidator(provider.get(), provider2.get());
    }

    @Override // javax.inject.Provider
    public PurchaseValidator get() {
        return provideInstance(this.f10119a, this.f10120b);
    }
}
