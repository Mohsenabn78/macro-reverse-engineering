package com.arlosoft.macrodroid.homescreen;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.advert.AdvertActivity_MembersInjector;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import com.arlosoft.macrodroid.app.navigation.ScreenLoader;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.confirmation.PurchaseValidator;
import com.arlosoft.macrodroid.confirmation.validation.PremiumValidator;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.upgrade.billing.BillingDataSource;
import com.arlosoft.macrodroid.utils.NotificationChannelUtil;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class NewHomeScreenActivity_MembersInjector implements MembersInjector<NewHomeScreenActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f12320a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<RemoteConfig> f12321b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f12322c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ScreenLoader> f12323d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<PremiumValidator> f12324e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<BillingDataSource> f12325f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<NotificationChannelUtil> f12326g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<PurchaseValidator> f12327h;

    public NewHomeScreenActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<RemoteConfig> provider2, Provider<PremiumStatusHandler> provider3, Provider<ScreenLoader> provider4, Provider<PremiumValidator> provider5, Provider<BillingDataSource> provider6, Provider<NotificationChannelUtil> provider7, Provider<PurchaseValidator> provider8) {
        this.f12320a = provider;
        this.f12321b = provider2;
        this.f12322c = provider3;
        this.f12323d = provider4;
        this.f12324e = provider5;
        this.f12325f = provider6;
        this.f12326g = provider7;
        this.f12327h = provider8;
    }

    public static MembersInjector<NewHomeScreenActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<RemoteConfig> provider2, Provider<PremiumStatusHandler> provider3, Provider<ScreenLoader> provider4, Provider<PremiumValidator> provider5, Provider<BillingDataSource> provider6, Provider<NotificationChannelUtil> provider7, Provider<PurchaseValidator> provider8) {
        return new NewHomeScreenActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static void injectBillingDataSource(NewHomeScreenActivity newHomeScreenActivity, BillingDataSource billingDataSource) {
        newHomeScreenActivity.billingDataSource = billingDataSource;
    }

    public static void injectNotificationChannleUtil(NewHomeScreenActivity newHomeScreenActivity, NotificationChannelUtil notificationChannelUtil) {
        newHomeScreenActivity.notificationChannleUtil = notificationChannelUtil;
    }

    public static void injectPremiumValidator(NewHomeScreenActivity newHomeScreenActivity, PremiumValidator premiumValidator) {
        newHomeScreenActivity.premiumValidator = premiumValidator;
    }

    public static void injectPurchaseValidator(NewHomeScreenActivity newHomeScreenActivity, PurchaseValidator purchaseValidator) {
        newHomeScreenActivity.purchaseValidator = purchaseValidator;
    }

    public static void injectScreenLoader(NewHomeScreenActivity newHomeScreenActivity, ScreenLoader screenLoader) {
        newHomeScreenActivity.screenLoader = screenLoader;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(NewHomeScreenActivity newHomeScreenActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(newHomeScreenActivity, this.f12320a.get());
        AdvertActivity_MembersInjector.injectRemoteConfig(newHomeScreenActivity, this.f12321b.get());
        AdvertActivity_MembersInjector.injectPremiumStatusHandler(newHomeScreenActivity, this.f12322c.get());
        injectScreenLoader(newHomeScreenActivity, this.f12323d.get());
        injectPremiumValidator(newHomeScreenActivity, this.f12324e.get());
        injectBillingDataSource(newHomeScreenActivity, this.f12325f.get());
        injectNotificationChannleUtil(newHomeScreenActivity, this.f12326g.get());
        injectPurchaseValidator(newHomeScreenActivity, this.f12327h.get());
    }
}
