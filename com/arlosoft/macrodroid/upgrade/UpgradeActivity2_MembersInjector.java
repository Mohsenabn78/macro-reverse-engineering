package com.arlosoft.macrodroid.upgrade;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.freeversion.FreeVersionHelper;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.upgrade.base.BasePurchaseActivity_MembersInjector;
import com.arlosoft.macrodroid.upgrade.billing.BillingDataSource;
import com.arlosoft.macrodroid.upgrade.flashsale.FlashSaleManager;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class UpgradeActivity2_MembersInjector implements MembersInjector<UpgradeActivity2> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f15879a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<BillingDataSource> f15880b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<FlashSaleManager> f15881c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f15882d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<RemoteConfig> f15883e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<FreeVersionHelper> f15884f;

    public UpgradeActivity2_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<BillingDataSource> provider2, Provider<FlashSaleManager> provider3, Provider<PremiumStatusHandler> provider4, Provider<RemoteConfig> provider5, Provider<FreeVersionHelper> provider6) {
        this.f15879a = provider;
        this.f15880b = provider2;
        this.f15881c = provider3;
        this.f15882d = provider4;
        this.f15883e = provider5;
        this.f15884f = provider6;
    }

    public static MembersInjector<UpgradeActivity2> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<BillingDataSource> provider2, Provider<FlashSaleManager> provider3, Provider<PremiumStatusHandler> provider4, Provider<RemoteConfig> provider5, Provider<FreeVersionHelper> provider6) {
        return new UpgradeActivity2_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(UpgradeActivity2 upgradeActivity2) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(upgradeActivity2, this.f15879a.get());
        BasePurchaseActivity_MembersInjector.injectBillingDataSource(upgradeActivity2, this.f15880b.get());
        BasePurchaseActivity_MembersInjector.injectFlashSaleManager(upgradeActivity2, this.f15881c.get());
        BasePurchaseActivity_MembersInjector.injectPremiumStatusHandler(upgradeActivity2, this.f15882d.get());
        BasePurchaseActivity_MembersInjector.injectRemoteConfig(upgradeActivity2, this.f15883e.get());
        BasePurchaseActivity_MembersInjector.injectFreeVersionHelper(upgradeActivity2, this.f15884f.get());
    }
}
