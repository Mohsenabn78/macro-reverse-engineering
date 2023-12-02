package com.arlosoft.macrodroid.upgrade.encouragemessage;

import android.content.Context;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class EncourageUpgradeMessageManager_Factory implements Factory<EncourageUpgradeMessageManager> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f15971a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<RemoteConfig> f15972b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f15973c;

    public EncourageUpgradeMessageManager_Factory(Provider<Context> provider, Provider<RemoteConfig> provider2, Provider<PremiumStatusHandler> provider3) {
        this.f15971a = provider;
        this.f15972b = provider2;
        this.f15973c = provider3;
    }

    public static EncourageUpgradeMessageManager_Factory create(Provider<Context> provider, Provider<RemoteConfig> provider2, Provider<PremiumStatusHandler> provider3) {
        return new EncourageUpgradeMessageManager_Factory(provider, provider2, provider3);
    }

    public static EncourageUpgradeMessageManager newEncourageUpgradeMessageManager(Context context, RemoteConfig remoteConfig, PremiumStatusHandler premiumStatusHandler) {
        return new EncourageUpgradeMessageManager(context, remoteConfig, premiumStatusHandler);
    }

    public static EncourageUpgradeMessageManager provideInstance(Provider<Context> provider, Provider<RemoteConfig> provider2, Provider<PremiumStatusHandler> provider3) {
        return new EncourageUpgradeMessageManager(provider.get(), provider2.get(), provider3.get());
    }

    @Override // javax.inject.Provider
    public EncourageUpgradeMessageManager get() {
        return provideInstance(this.f15971a, this.f15972b, this.f15973c);
    }
}
