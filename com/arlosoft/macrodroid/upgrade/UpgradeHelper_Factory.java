package com.arlosoft.macrodroid.upgrade;

import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class UpgradeHelper_Factory implements Factory<UpgradeHelper> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<RemoteConfig> f15892a;

    public UpgradeHelper_Factory(Provider<RemoteConfig> provider) {
        this.f15892a = provider;
    }

    public static UpgradeHelper_Factory create(Provider<RemoteConfig> provider) {
        return new UpgradeHelper_Factory(provider);
    }

    public static UpgradeHelper newUpgradeHelper(RemoteConfig remoteConfig) {
        return new UpgradeHelper(remoteConfig);
    }

    public static UpgradeHelper provideInstance(Provider<RemoteConfig> provider) {
        return new UpgradeHelper(provider.get());
    }

    @Override // javax.inject.Provider
    public UpgradeHelper get() {
        return provideInstance(this.f15892a);
    }
}
