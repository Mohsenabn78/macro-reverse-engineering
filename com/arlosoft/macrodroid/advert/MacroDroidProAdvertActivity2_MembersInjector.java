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
public final class MacroDroidProAdvertActivity2_MembersInjector implements MembersInjector<MacroDroidProAdvertActivity2> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f5653a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<BillingDataSource> f5654b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<FlashSaleManager> f5655c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f5656d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<RemoteConfig> f5657e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<FreeVersionHelper> f5658f;

    public MacroDroidProAdvertActivity2_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<BillingDataSource> provider2, Provider<FlashSaleManager> provider3, Provider<PremiumStatusHandler> provider4, Provider<RemoteConfig> provider5, Provider<FreeVersionHelper> provider6) {
        this.f5653a = provider;
        this.f5654b = provider2;
        this.f5655c = provider3;
        this.f5656d = provider4;
        this.f5657e = provider5;
        this.f5658f = provider6;
    }

    public static MembersInjector<MacroDroidProAdvertActivity2> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<BillingDataSource> provider2, Provider<FlashSaleManager> provider3, Provider<PremiumStatusHandler> provider4, Provider<RemoteConfig> provider5, Provider<FreeVersionHelper> provider6) {
        return new MacroDroidProAdvertActivity2_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6);
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MacroDroidProAdvertActivity2 macroDroidProAdvertActivity2) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(macroDroidProAdvertActivity2, this.f5653a.get());
        BasePurchaseActivity_MembersInjector.injectBillingDataSource(macroDroidProAdvertActivity2, this.f5654b.get());
        BasePurchaseActivity_MembersInjector.injectFlashSaleManager(macroDroidProAdvertActivity2, this.f5655c.get());
        BasePurchaseActivity_MembersInjector.injectPremiumStatusHandler(macroDroidProAdvertActivity2, this.f5656d.get());
        BasePurchaseActivity_MembersInjector.injectRemoteConfig(macroDroidProAdvertActivity2, this.f5657e.get());
        BasePurchaseActivity_MembersInjector.injectFreeVersionHelper(macroDroidProAdvertActivity2, this.f5658f.get());
    }
}
