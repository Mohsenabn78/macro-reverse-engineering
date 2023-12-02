package com.arlosoft.macrodroid.templatestore.ui.comments.presenter;

import com.arlosoft.macrodroid.app.navigation.ScreenLoader;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApi;
import com.arlosoft.macrodroid.templatestore.ui.templateList.LocalTemplateOverrideStore;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class TemplateCommentsPresenter_Factory implements Factory<TemplateCommentsPresenter> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ScreenLoader> f13791a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<TemplateStoreApi> f13792b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<UserProvider> f13793c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<LocalTemplateOverrideStore> f13794d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<MacroDroidRoomDatabase> f13795e;

    public TemplateCommentsPresenter_Factory(Provider<ScreenLoader> provider, Provider<TemplateStoreApi> provider2, Provider<UserProvider> provider3, Provider<LocalTemplateOverrideStore> provider4, Provider<MacroDroidRoomDatabase> provider5) {
        this.f13791a = provider;
        this.f13792b = provider2;
        this.f13793c = provider3;
        this.f13794d = provider4;
        this.f13795e = provider5;
    }

    public static TemplateCommentsPresenter_Factory create(Provider<ScreenLoader> provider, Provider<TemplateStoreApi> provider2, Provider<UserProvider> provider3, Provider<LocalTemplateOverrideStore> provider4, Provider<MacroDroidRoomDatabase> provider5) {
        return new TemplateCommentsPresenter_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static TemplateCommentsPresenter newTemplateCommentsPresenter(ScreenLoader screenLoader, TemplateStoreApi templateStoreApi, UserProvider userProvider, LocalTemplateOverrideStore localTemplateOverrideStore, MacroDroidRoomDatabase macroDroidRoomDatabase) {
        return new TemplateCommentsPresenter(screenLoader, templateStoreApi, userProvider, localTemplateOverrideStore, macroDroidRoomDatabase);
    }

    public static TemplateCommentsPresenter provideInstance(Provider<ScreenLoader> provider, Provider<TemplateStoreApi> provider2, Provider<UserProvider> provider3, Provider<LocalTemplateOverrideStore> provider4, Provider<MacroDroidRoomDatabase> provider5) {
        return new TemplateCommentsPresenter(provider.get(), provider2.get(), provider3.get(), provider4.get(), provider5.get());
    }

    @Override // javax.inject.Provider
    public TemplateCommentsPresenter get() {
        return provideInstance(this.f13791a, this.f13792b, this.f13793c, this.f13794d, this.f13795e);
    }
}
