package com.arlosoft.macrodroid.templatestore.ui.user.presenter;

import com.arlosoft.macrodroid.app.navigation.ScreenLoader;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApi;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class UserPresenter_Factory implements Factory<UserPresenter> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ScreenLoader> f14218a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<TemplateStoreApi> f14219b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f14220c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<UserProvider> f14221d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<MacroDroidRoomDatabase> f14222e;

    public UserPresenter_Factory(Provider<ScreenLoader> provider, Provider<TemplateStoreApi> provider2, Provider<PremiumStatusHandler> provider3, Provider<UserProvider> provider4, Provider<MacroDroidRoomDatabase> provider5) {
        this.f14218a = provider;
        this.f14219b = provider2;
        this.f14220c = provider3;
        this.f14221d = provider4;
        this.f14222e = provider5;
    }

    public static UserPresenter_Factory create(Provider<ScreenLoader> provider, Provider<TemplateStoreApi> provider2, Provider<PremiumStatusHandler> provider3, Provider<UserProvider> provider4, Provider<MacroDroidRoomDatabase> provider5) {
        return new UserPresenter_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static UserPresenter newUserPresenter(ScreenLoader screenLoader, TemplateStoreApi templateStoreApi, PremiumStatusHandler premiumStatusHandler, UserProvider userProvider, MacroDroidRoomDatabase macroDroidRoomDatabase) {
        return new UserPresenter(screenLoader, templateStoreApi, premiumStatusHandler, userProvider, macroDroidRoomDatabase);
    }

    public static UserPresenter provideInstance(Provider<ScreenLoader> provider, Provider<TemplateStoreApi> provider2, Provider<PremiumStatusHandler> provider3, Provider<UserProvider> provider4, Provider<MacroDroidRoomDatabase> provider5) {
        return new UserPresenter(provider.get(), provider2.get(), provider3.get(), provider4.get(), provider5.get());
    }

    @Override // javax.inject.Provider
    public UserPresenter get() {
        return provideInstance(this.f14218a, this.f14219b, this.f14220c, this.f14221d, this.f14222e);
    }
}
