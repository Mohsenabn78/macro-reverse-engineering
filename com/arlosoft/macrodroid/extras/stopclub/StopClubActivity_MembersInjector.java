package com.arlosoft.macrodroid.extras.stopclub;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.confirmation.PurchaseValidator;
import com.arlosoft.macrodroid.extras.ExtrasDownloader;
import com.arlosoft.macrodroid.extras.stopclub.viewmodel.StopClubViewModel;
import com.arlosoft.macrodroid.extras.ui.management.ExtrasManager;
import com.arlosoft.macrodroid.logging.systemlog.SystemLogHelper;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.troubleshooting.problem.PermissionChecker;
import com.arlosoft.macrodroid.upgrade.billing.BillingDataSource;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class StopClubActivity_MembersInjector implements MembersInjector<StopClubActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f12025a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<SystemLogHelper> f12026b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<StopClubViewModel> f12027c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<BillingDataSource> f12028d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f12029e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<PurchaseValidator> f12030f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<ExtrasDownloader> f12031g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<ExtrasManager> f12032h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<RemoteConfig> f12033i;

    /* renamed from: j  reason: collision with root package name */
    private final Provider<PermissionChecker> f12034j;

    public StopClubActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<SystemLogHelper> provider2, Provider<StopClubViewModel> provider3, Provider<BillingDataSource> provider4, Provider<PremiumStatusHandler> provider5, Provider<PurchaseValidator> provider6, Provider<ExtrasDownloader> provider7, Provider<ExtrasManager> provider8, Provider<RemoteConfig> provider9, Provider<PermissionChecker> provider10) {
        this.f12025a = provider;
        this.f12026b = provider2;
        this.f12027c = provider3;
        this.f12028d = provider4;
        this.f12029e = provider5;
        this.f12030f = provider6;
        this.f12031g = provider7;
        this.f12032h = provider8;
        this.f12033i = provider9;
        this.f12034j = provider10;
    }

    public static MembersInjector<StopClubActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<SystemLogHelper> provider2, Provider<StopClubViewModel> provider3, Provider<BillingDataSource> provider4, Provider<PremiumStatusHandler> provider5, Provider<PurchaseValidator> provider6, Provider<ExtrasDownloader> provider7, Provider<ExtrasManager> provider8, Provider<RemoteConfig> provider9, Provider<PermissionChecker> provider10) {
        return new StopClubActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10);
    }

    public static void injectBillingDataSource(StopClubActivity stopClubActivity, BillingDataSource billingDataSource) {
        stopClubActivity.billingDataSource = billingDataSource;
    }

    public static void injectExtrasDownloader(StopClubActivity stopClubActivity, ExtrasDownloader extrasDownloader) {
        stopClubActivity.extrasDownloader = extrasDownloader;
    }

    public static void injectExtrasManager(StopClubActivity stopClubActivity, ExtrasManager extrasManager) {
        stopClubActivity.extrasManager = extrasManager;
    }

    public static void injectPermissionChecker(StopClubActivity stopClubActivity, PermissionChecker permissionChecker) {
        stopClubActivity.permissionChecker = permissionChecker;
    }

    public static void injectPremiumStatusHandler(StopClubActivity stopClubActivity, PremiumStatusHandler premiumStatusHandler) {
        stopClubActivity.premiumStatusHandler = premiumStatusHandler;
    }

    public static void injectPurchaseValidator(StopClubActivity stopClubActivity, PurchaseValidator purchaseValidator) {
        stopClubActivity.purchaseValidator = purchaseValidator;
    }

    public static void injectRemoteConfig(StopClubActivity stopClubActivity, RemoteConfig remoteConfig) {
        stopClubActivity.remoteConfig = remoteConfig;
    }

    public static void injectSystemLogHelper(StopClubActivity stopClubActivity, SystemLogHelper systemLogHelper) {
        stopClubActivity.systemLogHelper = systemLogHelper;
    }

    public static void injectViewModel(StopClubActivity stopClubActivity, StopClubViewModel stopClubViewModel) {
        stopClubActivity.viewModel = stopClubViewModel;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(StopClubActivity stopClubActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(stopClubActivity, this.f12025a.get());
        injectSystemLogHelper(stopClubActivity, this.f12026b.get());
        injectViewModel(stopClubActivity, this.f12027c.get());
        injectBillingDataSource(stopClubActivity, this.f12028d.get());
        injectPremiumStatusHandler(stopClubActivity, this.f12029e.get());
        injectPurchaseValidator(stopClubActivity, this.f12030f.get());
        injectExtrasDownloader(stopClubActivity, this.f12031g.get());
        injectExtrasManager(stopClubActivity, this.f12032h.get());
        injectRemoteConfig(stopClubActivity, this.f12033i.get());
        injectPermissionChecker(stopClubActivity, this.f12034j.get());
    }
}
