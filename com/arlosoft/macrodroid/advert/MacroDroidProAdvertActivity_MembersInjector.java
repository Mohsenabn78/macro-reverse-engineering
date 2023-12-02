package com.arlosoft.macrodroid.advert;

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

/* loaded from: classes.dex */
public final class MacroDroidProAdvertActivity_MembersInjector implements MembersInjector<MacroDroidProAdvertActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f5659a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<BillingDataSource> f5660b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<FlashSaleManager> f5661c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f5662d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<RemoteConfig> f5663e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<FreeVersionHelper> f5664f;

    public MacroDroidProAdvertActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<BillingDataSource> provider2, Provider<FlashSaleManager> provider3, Provider<PremiumStatusHandler> provider4, Provider<RemoteConfig> provider5, Provider<FreeVersionHelper> provider6) {
        this.f5659a = provider;
        this.f5660b = provider2;
        this.f5661c = provider3;
        this.f5662d = provider4;
        this.f5663e = provider5;
        this.f5664f = provider6;
    }

    public static MembersInjector<MacroDroidProAdvertActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<BillingDataSource> provider2, Provider<FlashSaleManager> provider3, Provider<PremiumStatusHandler> provider4, Provider<RemoteConfig> provider5, Provider<FreeVersionHelper> provider6) {
        return new MacroDroidProAdvertActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MacroDroidProAdvertActivity macroDroidProAdvertActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(macroDroidProAdvertActivity, this.f5659a.get());
        BasePurchaseActivity_MembersInjector.injectBillingDataSource(macroDroidProAdvertActivity, this.f5660b.get());
        BasePurchaseActivity_MembersInjector.injectFlashSaleManager(macroDroidProAdvertActivity, this.f5661c.get());
        BasePurchaseActivity_MembersInjector.injectPremiumStatusHandler(macroDroidProAdvertActivity, this.f5662d.get());
        BasePurchaseActivity_MembersInjector.injectRemoteConfig(macroDroidProAdvertActivity, this.f5663e.get());
        BasePurchaseActivity_MembersInjector.injectFreeVersionHelper(macroDroidProAdvertActivity, this.f5664f.get());
    }
}
