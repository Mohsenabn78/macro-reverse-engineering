package com.arlosoft.macrodroid.app;

import android.app.Activity;
import com.arlosoft.macrodroid.accessibility.AccessibilityServiceMonitor;
import com.arlosoft.macrodroid.commercial.CommercialTools;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.confirmation.PurchaseValidator;
import com.arlosoft.macrodroid.extras.ui.management.ExtrasManager;
import com.arlosoft.macrodroid.freeversion.FreeVersionHelper;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import com.arlosoft.macrodroid.upgrade.billing.BillingDataSource;
import com.arlosoft.macrodroid.upgrade.flashsale.FlashSaleManager;
import com.arlosoft.macrodroid.utils.NotificationChannelUtil;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class MacroDroidApplication_MembersInjector implements MembersInjector<MacroDroidApplication> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Activity>> f5682a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<RemoteConfig> f5683b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<PurchaseValidator> f5684c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<UserProvider> f5685d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<FlashSaleManager> f5686e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<NotificationChannelUtil> f5687f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f5688g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<CommercialTools> f5689h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<AccessibilityServiceMonitor> f5690i;

    /* renamed from: j  reason: collision with root package name */
    private final Provider<BillingDataSource> f5691j;

    /* renamed from: k  reason: collision with root package name */
    private final Provider<ExtrasManager> f5692k;

    /* renamed from: l  reason: collision with root package name */
    private final Provider<FreeVersionHelper> f5693l;

    public MacroDroidApplication_MembersInjector(Provider<DispatchingAndroidInjector<Activity>> provider, Provider<RemoteConfig> provider2, Provider<PurchaseValidator> provider3, Provider<UserProvider> provider4, Provider<FlashSaleManager> provider5, Provider<NotificationChannelUtil> provider6, Provider<PremiumStatusHandler> provider7, Provider<CommercialTools> provider8, Provider<AccessibilityServiceMonitor> provider9, Provider<BillingDataSource> provider10, Provider<ExtrasManager> provider11, Provider<FreeVersionHelper> provider12) {
        this.f5682a = provider;
        this.f5683b = provider2;
        this.f5684c = provider3;
        this.f5685d = provider4;
        this.f5686e = provider5;
        this.f5687f = provider6;
        this.f5688g = provider7;
        this.f5689h = provider8;
        this.f5690i = provider9;
        this.f5691j = provider10;
        this.f5692k = provider11;
        this.f5693l = provider12;
    }

    public static MembersInjector<MacroDroidApplication> create(Provider<DispatchingAndroidInjector<Activity>> provider, Provider<RemoteConfig> provider2, Provider<PurchaseValidator> provider3, Provider<UserProvider> provider4, Provider<FlashSaleManager> provider5, Provider<NotificationChannelUtil> provider6, Provider<PremiumStatusHandler> provider7, Provider<CommercialTools> provider8, Provider<AccessibilityServiceMonitor> provider9, Provider<BillingDataSource> provider10, Provider<ExtrasManager> provider11, Provider<FreeVersionHelper> provider12) {
        return new MacroDroidApplication_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12);
    }

    public static void injectAccessibilityServiceMonitor(MacroDroidApplication macroDroidApplication, AccessibilityServiceMonitor accessibilityServiceMonitor) {
        macroDroidApplication.accessibilityServiceMonitor = accessibilityServiceMonitor;
    }

    public static void injectBillingDataSource(MacroDroidApplication macroDroidApplication, BillingDataSource billingDataSource) {
        macroDroidApplication.billingDataSource = billingDataSource;
    }

    public static void injectCommercialTools(MacroDroidApplication macroDroidApplication, CommercialTools commercialTools) {
        macroDroidApplication.commercialTools = commercialTools;
    }

    public static void injectDispatchingAndroidInjector(MacroDroidApplication macroDroidApplication, DispatchingAndroidInjector<Activity> dispatchingAndroidInjector) {
        macroDroidApplication.dispatchingAndroidInjector = dispatchingAndroidInjector;
    }

    public static void injectExtrasManager(MacroDroidApplication macroDroidApplication, ExtrasManager extrasManager) {
        macroDroidApplication.extrasManager = extrasManager;
    }

    public static void injectFlashSaleManager(MacroDroidApplication macroDroidApplication, FlashSaleManager flashSaleManager) {
        macroDroidApplication.flashSaleManager = flashSaleManager;
    }

    public static void injectFreeVersionHelper(MacroDroidApplication macroDroidApplication, FreeVersionHelper freeVersionHelper) {
        macroDroidApplication.freeVersionHelper = freeVersionHelper;
    }

    public static void injectNotificationChannelUtil(MacroDroidApplication macroDroidApplication, NotificationChannelUtil notificationChannelUtil) {
        macroDroidApplication.notificationChannelUtil = notificationChannelUtil;
    }

    public static void injectPremiumStatusHandler(MacroDroidApplication macroDroidApplication, PremiumStatusHandler premiumStatusHandler) {
        macroDroidApplication.premiumStatusHandler = premiumStatusHandler;
    }

    public static void injectPurchaseValidator(MacroDroidApplication macroDroidApplication, PurchaseValidator purchaseValidator) {
        macroDroidApplication.purchaseValidator = purchaseValidator;
    }

    public static void injectRemoteConfig(MacroDroidApplication macroDroidApplication, RemoteConfig remoteConfig) {
        macroDroidApplication.remoteConfig = remoteConfig;
    }

    public static void injectUserProvider(MacroDroidApplication macroDroidApplication, UserProvider userProvider) {
        macroDroidApplication.userProvider = userProvider;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MacroDroidApplication macroDroidApplication) {
        injectDispatchingAndroidInjector(macroDroidApplication, this.f5682a.get());
        injectRemoteConfig(macroDroidApplication, this.f5683b.get());
        injectPurchaseValidator(macroDroidApplication, this.f5684c.get());
        injectUserProvider(macroDroidApplication, this.f5685d.get());
        injectFlashSaleManager(macroDroidApplication, this.f5686e.get());
        injectNotificationChannelUtil(macroDroidApplication, this.f5687f.get());
        injectPremiumStatusHandler(macroDroidApplication, this.f5688g.get());
        injectCommercialTools(macroDroidApplication, this.f5689h.get());
        injectAccessibilityServiceMonitor(macroDroidApplication, this.f5690i.get());
        injectBillingDataSource(macroDroidApplication, this.f5691j.get());
        injectExtrasManager(macroDroidApplication, this.f5692k.get());
        injectFreeVersionHelper(macroDroidApplication, this.f5693l.get());
    }
}
