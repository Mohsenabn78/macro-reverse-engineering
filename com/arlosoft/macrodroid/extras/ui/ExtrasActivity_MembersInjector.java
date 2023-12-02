package com.arlosoft.macrodroid.extras.ui;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.confirmation.PurchaseValidator;
import com.arlosoft.macrodroid.extras.ExtrasDownloader;
import com.arlosoft.macrodroid.extras.ui.management.ExtrasManager;
import com.arlosoft.macrodroid.extras.ui.viewmodel.ExtrasViewModel;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.upgrade.billing.BillingDataSource;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ExtrasActivity_MembersInjector implements MembersInjector<ExtrasActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f12097a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ExtrasViewModel> f12098b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<BillingDataSource> f12099c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f12100d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<PurchaseValidator> f12101e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<ExtrasDownloader> f12102f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<ExtrasManager> f12103g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<RemoteConfig> f12104h;

    public ExtrasActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ExtrasViewModel> provider2, Provider<BillingDataSource> provider3, Provider<PremiumStatusHandler> provider4, Provider<PurchaseValidator> provider5, Provider<ExtrasDownloader> provider6, Provider<ExtrasManager> provider7, Provider<RemoteConfig> provider8) {
        this.f12097a = provider;
        this.f12098b = provider2;
        this.f12099c = provider3;
        this.f12100d = provider4;
        this.f12101e = provider5;
        this.f12102f = provider6;
        this.f12103g = provider7;
        this.f12104h = provider8;
    }

    public static MembersInjector<ExtrasActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ExtrasViewModel> provider2, Provider<BillingDataSource> provider3, Provider<PremiumStatusHandler> provider4, Provider<PurchaseValidator> provider5, Provider<ExtrasDownloader> provider6, Provider<ExtrasManager> provider7, Provider<RemoteConfig> provider8) {
        return new ExtrasActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static void injectBillingDataSource(ExtrasActivity extrasActivity, BillingDataSource billingDataSource) {
        extrasActivity.billingDataSource = billingDataSource;
    }

    public static void injectExtrasDownloader(ExtrasActivity extrasActivity, ExtrasDownloader extrasDownloader) {
        extrasActivity.extrasDownloader = extrasDownloader;
    }

    public static void injectExtrasManager(ExtrasActivity extrasActivity, ExtrasManager extrasManager) {
        extrasActivity.extrasManager = extrasManager;
    }

    public static void injectPremiumStatusHandler(ExtrasActivity extrasActivity, PremiumStatusHandler premiumStatusHandler) {
        extrasActivity.premiumStatusHandler = premiumStatusHandler;
    }

    public static void injectPurchaseValidator(ExtrasActivity extrasActivity, PurchaseValidator purchaseValidator) {
        extrasActivity.purchaseValidator = purchaseValidator;
    }

    public static void injectRemoteConfig(ExtrasActivity extrasActivity, RemoteConfig remoteConfig) {
        extrasActivity.remoteConfig = remoteConfig;
    }

    public static void injectViewModel(ExtrasActivity extrasActivity, ExtrasViewModel extrasViewModel) {
        extrasActivity.viewModel = extrasViewModel;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(ExtrasActivity extrasActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(extrasActivity, this.f12097a.get());
        injectViewModel(extrasActivity, this.f12098b.get());
        injectBillingDataSource(extrasActivity, this.f12099c.get());
        injectPremiumStatusHandler(extrasActivity, this.f12100d.get());
        injectPurchaseValidator(extrasActivity, this.f12101e.get());
        injectExtrasDownloader(extrasActivity, this.f12102f.get());
        injectExtrasManager(extrasActivity, this.f12103g.get());
        injectRemoteConfig(extrasActivity, this.f12104h.get());
    }
}
