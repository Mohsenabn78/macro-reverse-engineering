package com.arlosoft.macrodroid.confirmation;

import android.content.Context;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.upgrade.billing.BillingDataSource;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class PremiumStatusHandler_Factory implements Factory<PremiumStatusHandler> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f10113a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<RemoteConfig> f10114b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<BillingDataSource> f10115c;

    public PremiumStatusHandler_Factory(Provider<Context> provider, Provider<RemoteConfig> provider2, Provider<BillingDataSource> provider3) {
        this.f10113a = provider;
        this.f10114b = provider2;
        this.f10115c = provider3;
    }

    public static PremiumStatusHandler_Factory create(Provider<Context> provider, Provider<RemoteConfig> provider2, Provider<BillingDataSource> provider3) {
        return new PremiumStatusHandler_Factory(provider, provider2, provider3);
    }

    public static PremiumStatusHandler newPremiumStatusHandler(Context context, RemoteConfig remoteConfig, BillingDataSource billingDataSource) {
        return new PremiumStatusHandler(context, remoteConfig, billingDataSource);
    }

    public static PremiumStatusHandler provideInstance(Provider<Context> provider, Provider<RemoteConfig> provider2, Provider<BillingDataSource> provider3) {
        return new PremiumStatusHandler(provider.get(), provider2.get(), provider3.get());
    }

    @Override // javax.inject.Provider
    public PremiumStatusHandler get() {
        return provideInstance(this.f10113a, this.f10114b, this.f10115c);
    }
}
