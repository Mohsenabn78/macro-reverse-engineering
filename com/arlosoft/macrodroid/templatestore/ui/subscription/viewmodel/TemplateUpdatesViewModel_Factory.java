package com.arlosoft.macrodroid.templatestore.ui.subscription.viewmodel;

import android.content.Context;
import com.arlosoft.macrodroid.app.navigation.ScreenLoader;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApi;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class TemplateUpdatesViewModel_Factory implements Factory<TemplateUpdatesViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f13938a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MacroDroidRoomDatabase> f13939b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ScreenLoader> f13940c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<TemplateStoreApi> f13941d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<UserProvider> f13942e;

    public TemplateUpdatesViewModel_Factory(Provider<Context> provider, Provider<MacroDroidRoomDatabase> provider2, Provider<ScreenLoader> provider3, Provider<TemplateStoreApi> provider4, Provider<UserProvider> provider5) {
        this.f13938a = provider;
        this.f13939b = provider2;
        this.f13940c = provider3;
        this.f13941d = provider4;
        this.f13942e = provider5;
    }

    public static TemplateUpdatesViewModel_Factory create(Provider<Context> provider, Provider<MacroDroidRoomDatabase> provider2, Provider<ScreenLoader> provider3, Provider<TemplateStoreApi> provider4, Provider<UserProvider> provider5) {
        return new TemplateUpdatesViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static TemplateUpdatesViewModel newTemplateUpdatesViewModel(Context context, MacroDroidRoomDatabase macroDroidRoomDatabase, ScreenLoader screenLoader, TemplateStoreApi templateStoreApi, UserProvider userProvider) {
        return new TemplateUpdatesViewModel(context, macroDroidRoomDatabase, screenLoader, templateStoreApi, userProvider);
    }

    public static TemplateUpdatesViewModel provideInstance(Provider<Context> provider, Provider<MacroDroidRoomDatabase> provider2, Provider<ScreenLoader> provider3, Provider<TemplateStoreApi> provider4, Provider<UserProvider> provider5) {
        return new TemplateUpdatesViewModel(provider.get(), provider2.get(), provider3.get(), provider4.get(), provider5.get());
    }

    @Override // javax.inject.Provider
    public TemplateUpdatesViewModel get() {
        return provideInstance(this.f13938a, this.f13939b, this.f13940c, this.f13941d, this.f13942e);
    }
}
