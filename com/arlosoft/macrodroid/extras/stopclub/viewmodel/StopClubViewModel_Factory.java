package com.arlosoft.macrodroid.extras.stopclub.viewmodel;

import android.content.Context;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.confirmation.PurchaseValidator;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.extras.ExtrasDownloader;
import com.arlosoft.macrodroid.extras.ui.management.ExtrasManager;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.upgrade.billing.BillingDataSource;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class StopClubViewModel_Factory implements Factory<StopClubViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f12076a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ExtrasManager> f12077b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<MacroDroidRoomDatabase> f12078c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<RemoteConfig> f12079d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<ExtrasDownloader> f12080e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<PurchaseValidator> f12081f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f12082g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<BillingDataSource> f12083h;

    public StopClubViewModel_Factory(Provider<Context> provider, Provider<ExtrasManager> provider2, Provider<MacroDroidRoomDatabase> provider3, Provider<RemoteConfig> provider4, Provider<ExtrasDownloader> provider5, Provider<PurchaseValidator> provider6, Provider<PremiumStatusHandler> provider7, Provider<BillingDataSource> provider8) {
        this.f12076a = provider;
        this.f12077b = provider2;
        this.f12078c = provider3;
        this.f12079d = provider4;
        this.f12080e = provider5;
        this.f12081f = provider6;
        this.f12082g = provider7;
        this.f12083h = provider8;
    }

    public static StopClubViewModel_Factory create(Provider<Context> provider, Provider<ExtrasManager> provider2, Provider<MacroDroidRoomDatabase> provider3, Provider<RemoteConfig> provider4, Provider<ExtrasDownloader> provider5, Provider<PurchaseValidator> provider6, Provider<PremiumStatusHandler> provider7, Provider<BillingDataSource> provider8) {
        return new StopClubViewModel_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static StopClubViewModel newStopClubViewModel(Context context, ExtrasManager extrasManager, MacroDroidRoomDatabase macroDroidRoomDatabase, RemoteConfig remoteConfig, ExtrasDownloader extrasDownloader, PurchaseValidator purchaseValidator, PremiumStatusHandler premiumStatusHandler, BillingDataSource billingDataSource) {
        return new StopClubViewModel(context, extrasManager, macroDroidRoomDatabase, remoteConfig, extrasDownloader, purchaseValidator, premiumStatusHandler, billingDataSource);
    }

    public static StopClubViewModel provideInstance(Provider<Context> provider, Provider<ExtrasManager> provider2, Provider<MacroDroidRoomDatabase> provider3, Provider<RemoteConfig> provider4, Provider<ExtrasDownloader> provider5, Provider<PurchaseValidator> provider6, Provider<PremiumStatusHandler> provider7, Provider<BillingDataSource> provider8) {
        return new StopClubViewModel(provider.get(), provider2.get(), provider3.get(), provider4.get(), provider5.get(), provider6.get(), provider7.get(), provider8.get());
    }

    @Override // javax.inject.Provider
    public StopClubViewModel get() {
        return provideInstance(this.f12076a, this.f12077b, this.f12078c, this.f12079d, this.f12080e, this.f12081f, this.f12082g, this.f12083h);
    }
}
