package com.arlosoft.macrodroid.upgrade.base;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.freeversion.FreeVersionHelper;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.upgrade.billing.BillingDataSource;
import com.arlosoft.macrodroid.upgrade.flashsale.FlashSaleManager;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class BasePurchaseActivity_MembersInjector implements MembersInjector<BasePurchaseActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f15910a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<BillingDataSource> f15911b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<FlashSaleManager> f15912c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f15913d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<RemoteConfig> f15914e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<FreeVersionHelper> f15915f;

    public BasePurchaseActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<BillingDataSource> provider2, Provider<FlashSaleManager> provider3, Provider<PremiumStatusHandler> provider4, Provider<RemoteConfig> provider5, Provider<FreeVersionHelper> provider6) {
        this.f15910a = provider;
        this.f15911b = provider2;
        this.f15912c = provider3;
        this.f15913d = provider4;
        this.f15914e = provider5;
        this.f15915f = provider6;
    }

    public static MembersInjector<BasePurchaseActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<BillingDataSource> provider2, Provider<FlashSaleManager> provider3, Provider<PremiumStatusHandler> provider4, Provider<RemoteConfig> provider5, Provider<FreeVersionHelper> provider6) {
        return new BasePurchaseActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static void injectBillingDataSource(BasePurchaseActivity basePurchaseActivity, BillingDataSource billingDataSource) {
        basePurchaseActivity.billingDataSource = billingDataSource;
    }

    public static void injectFlashSaleManager(BasePurchaseActivity basePurchaseActivity, FlashSaleManager flashSaleManager) {
        basePurchaseActivity.flashSaleManager = flashSaleManager;
    }

    public static void injectFreeVersionHelper(BasePurchaseActivity basePurchaseActivity, FreeVersionHelper freeVersionHelper) {
        basePurchaseActivity.freeVersionHelper = freeVersionHelper;
    }

    public static void injectPremiumStatusHandler(BasePurchaseActivity basePurchaseActivity, PremiumStatusHandler premiumStatusHandler) {
        basePurchaseActivity.premiumStatusHandler = premiumStatusHandler;
    }

    public static void injectRemoteConfig(BasePurchaseActivity basePurchaseActivity, RemoteConfig remoteConfig) {
        basePurchaseActivity.remoteConfig = remoteConfig;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(BasePurchaseActivity basePurchaseActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(basePurchaseActivity, this.f15910a.get());
        injectBillingDataSource(basePurchaseActivity, this.f15911b.get());
        injectFlashSaleManager(basePurchaseActivity, this.f15912c.get());
        injectPremiumStatusHandler(basePurchaseActivity, this.f15913d.get());
        injectRemoteConfig(basePurchaseActivity, this.f15914e.get());
        injectFreeVersionHelper(basePurchaseActivity, this.f15915f.get());
    }
}
