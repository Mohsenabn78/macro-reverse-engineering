package com.arlosoft.macrodroid.templatestore.ui.profile;

import android.content.Context;
import com.arlosoft.macrodroid.app.navigation.ScreenLoader;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApi;
import com.arlosoft.macrodroid.templatestore.ui.templateList.LocalTemplateOverrideStore;
import com.arlosoft.macrodroid.templatestore.ui.upload.TemplateRefreshNotifier;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ProfilePresenter_Factory implements Factory<ProfilePresenter> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<ScreenLoader> f13824a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<TemplateStoreApi> f13825b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<UserProvider> f13826c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<Context> f13827d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<TemplateRefreshNotifier> f13828e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<LocalTemplateOverrideStore> f13829f;

    public ProfilePresenter_Factory(Provider<ScreenLoader> provider, Provider<TemplateStoreApi> provider2, Provider<UserProvider> provider3, Provider<Context> provider4, Provider<TemplateRefreshNotifier> provider5, Provider<LocalTemplateOverrideStore> provider6) {
        this.f13824a = provider;
        this.f13825b = provider2;
        this.f13826c = provider3;
        this.f13827d = provider4;
        this.f13828e = provider5;
        this.f13829f = provider6;
    }

    public static ProfilePresenter_Factory create(Provider<ScreenLoader> provider, Provider<TemplateStoreApi> provider2, Provider<UserProvider> provider3, Provider<Context> provider4, Provider<TemplateRefreshNotifier> provider5, Provider<LocalTemplateOverrideStore> provider6) {
        return new ProfilePresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6);
    }

    public static ProfilePresenter newProfilePresenter(ScreenLoader screenLoader, TemplateStoreApi templateStoreApi, UserProvider userProvider, Context context, TemplateRefreshNotifier templateRefreshNotifier, LocalTemplateOverrideStore localTemplateOverrideStore) {
        return new ProfilePresenter(screenLoader, templateStoreApi, userProvider, context, templateRefreshNotifier, localTemplateOverrideStore);
    }

    public static ProfilePresenter provideInstance(Provider<ScreenLoader> provider, Provider<TemplateStoreApi> provider2, Provider<UserProvider> provider3, Provider<Context> provider4, Provider<TemplateRefreshNotifier> provider5, Provider<LocalTemplateOverrideStore> provider6) {
        return new ProfilePresenter(provider.get(), provider2.get(), provider3.get(), provider4.get(), provider5.get(), provider6.get());
    }

    @Override // javax.inject.Provider
    public ProfilePresenter get() {
        return provideInstance(this.f13824a, this.f13825b, this.f13826c, this.f13827d, this.f13828e, this.f13829f);
    }
}
