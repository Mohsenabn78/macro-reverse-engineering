package com.arlosoft.macrodroid.templatestore.ui.userlist;

import com.arlosoft.macrodroid.app.navigation.ScreenLoader;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApi;
import com.arlosoft.macrodroid.templatestore.ui.upload.TemplateRefreshNotifier;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class UserListPresenter_Factory implements Factory<UserListPresenter> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ScreenLoader> f14256a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<TemplateStoreApi> f14257b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<TemplateRefreshNotifier> f14258c;

    public UserListPresenter_Factory(Provider<ScreenLoader> provider, Provider<TemplateStoreApi> provider2, Provider<TemplateRefreshNotifier> provider3) {
        this.f14256a = provider;
        this.f14257b = provider2;
        this.f14258c = provider3;
    }

    public static UserListPresenter_Factory create(Provider<ScreenLoader> provider, Provider<TemplateStoreApi> provider2, Provider<TemplateRefreshNotifier> provider3) {
        return new UserListPresenter_Factory(provider, provider2, provider3);
    }

    public static UserListPresenter newUserListPresenter(ScreenLoader screenLoader, TemplateStoreApi templateStoreApi, TemplateRefreshNotifier templateRefreshNotifier) {
        return new UserListPresenter(screenLoader, templateStoreApi, templateRefreshNotifier);
    }

    public static UserListPresenter provideInstance(Provider<ScreenLoader> provider, Provider<TemplateStoreApi> provider2, Provider<TemplateRefreshNotifier> provider3) {
        return new UserListPresenter(provider.get(), provider2.get(), provider3.get());
    }

    @Override // javax.inject.Provider
    public UserListPresenter get() {
        return provideInstance(this.f14256a, this.f14257b, this.f14258c);
    }
}
