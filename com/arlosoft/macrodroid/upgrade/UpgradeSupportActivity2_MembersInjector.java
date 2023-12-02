package com.arlosoft.macrodroid.upgrade;

import com.arlosoft.macrodroid.action.email.api.UpgradeApi;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class UpgradeSupportActivity2_MembersInjector implements MembersInjector<UpgradeSupportActivity2> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<UpgradeApi> f15901a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<UpgradeHelper> f15902b;

    public UpgradeSupportActivity2_MembersInjector(Provider<UpgradeApi> provider, Provider<UpgradeHelper> provider2) {
        this.f15901a = provider;
        this.f15902b = provider2;
    }

    public static MembersInjector<UpgradeSupportActivity2> create(Provider<UpgradeApi> provider, Provider<UpgradeHelper> provider2) {
        return new UpgradeSupportActivity2_MembersInjector(provider, provider2);
    }

    public static void injectUpgradeApi(UpgradeSupportActivity2 upgradeSupportActivity2, UpgradeApi upgradeApi) {
        upgradeSupportActivity2.upgradeApi = upgradeApi;
    }

    public static void injectUpgradeHelper(UpgradeSupportActivity2 upgradeSupportActivity2, UpgradeHelper upgradeHelper) {
        upgradeSupportActivity2.upgradeHelper = upgradeHelper;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(UpgradeSupportActivity2 upgradeSupportActivity2) {
        injectUpgradeApi(upgradeSupportActivity2, this.f15901a.get());
        injectUpgradeHelper(upgradeSupportActivity2, this.f15902b.get());
    }
}
