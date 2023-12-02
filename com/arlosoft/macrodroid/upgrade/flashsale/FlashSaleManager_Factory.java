package com.arlosoft.macrodroid.upgrade.flashsale;

import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class FlashSaleManager_Factory implements Factory<FlashSaleManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<RemoteConfig> f15977a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f15978b;

    public FlashSaleManager_Factory(Provider<RemoteConfig> provider, Provider<PremiumStatusHandler> provider2) {
        this.f15977a = provider;
        this.f15978b = provider2;
    }

    public static FlashSaleManager_Factory create(Provider<RemoteConfig> provider, Provider<PremiumStatusHandler> provider2) {
        return new FlashSaleManager_Factory(provider, provider2);
    }

    public static FlashSaleManager newFlashSaleManager(RemoteConfig remoteConfig, PremiumStatusHandler premiumStatusHandler) {
        return new FlashSaleManager(remoteConfig, premiumStatusHandler);
    }

    public static FlashSaleManager provideInstance(Provider<RemoteConfig> provider, Provider<PremiumStatusHandler> provider2) {
        return new FlashSaleManager(provider.get(), provider2.get());
    }

    @Override // javax.inject.Provider
    public FlashSaleManager get() {
        return provideInstance(this.f15977a, this.f15978b);
    }
}
