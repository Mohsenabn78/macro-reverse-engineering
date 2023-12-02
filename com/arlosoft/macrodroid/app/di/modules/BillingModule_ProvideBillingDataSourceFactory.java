package com.arlosoft.macrodroid.app.di.modules;

import android.app.Application;
import com.arlosoft.macrodroid.confirmation.PurchaseValidator;
import com.arlosoft.macrodroid.upgrade.billing.BillingDataSource;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class BillingModule_ProvideBillingDataSourceFactory implements Factory<BillingDataSource> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Application> f9291a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PurchaseValidator> f9292b;

    public BillingModule_ProvideBillingDataSourceFactory(Provider<Application> provider, Provider<PurchaseValidator> provider2) {
        this.f9291a = provider;
        this.f9292b = provider2;
    }

    public static BillingModule_ProvideBillingDataSourceFactory create(Provider<Application> provider, Provider<PurchaseValidator> provider2) {
        return new BillingModule_ProvideBillingDataSourceFactory(provider, provider2);
    }

    public static BillingDataSource provideInstance(Provider<Application> provider, Provider<PurchaseValidator> provider2) {
        return proxyProvideBillingDataSource(provider.get(), provider2.get());
    }

    public static BillingDataSource proxyProvideBillingDataSource(Application application, PurchaseValidator purchaseValidator) {
        return (BillingDataSource) Preconditions.checkNotNull(BillingModule.provideBillingDataSource(application, purchaseValidator), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // javax.inject.Provider
    public BillingDataSource get() {
        return provideInstance(this.f9291a, this.f9292b);
    }
}
