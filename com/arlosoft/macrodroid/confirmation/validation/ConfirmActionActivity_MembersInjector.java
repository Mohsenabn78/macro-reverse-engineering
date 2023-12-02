package com.arlosoft.macrodroid.confirmation.validation;

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
public final class ConfirmActionActivity_MembersInjector implements MembersInjector<ConfirmActionActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f10124a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<BillingDataSource> f10125b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<FlashSaleManager> f10126c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f10127d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<RemoteConfig> f10128e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<FreeVersionHelper> f10129f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<ValidatePurchaseViewModel> f10130g;

    public ConfirmActionActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<BillingDataSource> provider2, Provider<FlashSaleManager> provider3, Provider<PremiumStatusHandler> provider4, Provider<RemoteConfig> provider5, Provider<FreeVersionHelper> provider6, Provider<ValidatePurchaseViewModel> provider7) {
        this.f10124a = provider;
        this.f10125b = provider2;
        this.f10126c = provider3;
        this.f10127d = provider4;
        this.f10128e = provider5;
        this.f10129f = provider6;
        this.f10130g = provider7;
    }

    public static MembersInjector<ConfirmActionActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<BillingDataSource> provider2, Provider<FlashSaleManager> provider3, Provider<PremiumStatusHandler> provider4, Provider<RemoteConfig> provider5, Provider<FreeVersionHelper> provider6, Provider<ValidatePurchaseViewModel> provider7) {
        return new ConfirmActionActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static void injectViewModel(ConfirmActionActivity confirmActionActivity, ValidatePurchaseViewModel validatePurchaseViewModel) {
        confirmActionActivity.viewModel = validatePurchaseViewModel;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(ConfirmActionActivity confirmActionActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(confirmActionActivity, this.f10124a.get());
        BasePurchaseActivity_MembersInjector.injectBillingDataSource(confirmActionActivity, this.f10125b.get());
        BasePurchaseActivity_MembersInjector.injectFlashSaleManager(confirmActionActivity, this.f10126c.get());
        BasePurchaseActivity_MembersInjector.injectPremiumStatusHandler(confirmActionActivity, this.f10127d.get());
        BasePurchaseActivity_MembersInjector.injectRemoteConfig(confirmActionActivity, this.f10128e.get());
        BasePurchaseActivity_MembersInjector.injectFreeVersionHelper(confirmActionActivity, this.f10129f.get());
        injectViewModel(confirmActionActivity, this.f10130g.get());
    }
}
