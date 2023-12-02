package com.arlosoft.macrodroid.templatestore.ui;

import com.arlosoft.macrodroid.app.navigation.ScreenLoader;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.remoteconfig.RemoteConfig;
import com.arlosoft.macrodroid.templatestore.translation.TemplatesTranslationHelper;
import com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateCategoryManager;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import com.arlosoft.macrodroid.user.signin.SignInHelper;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class TemplateStoreFragment_MembersInjector implements MembersInjector<TemplateStoreFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<TemplateCategoryManager> f13724a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<UserProvider> f13725b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ScreenLoader> f13726c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<SignInHelper> f13727d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<RemoteConfig> f13728e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f13729f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<TemplatesTranslationHelper> f13730g;

    public TemplateStoreFragment_MembersInjector(Provider<TemplateCategoryManager> provider, Provider<UserProvider> provider2, Provider<ScreenLoader> provider3, Provider<SignInHelper> provider4, Provider<RemoteConfig> provider5, Provider<PremiumStatusHandler> provider6, Provider<TemplatesTranslationHelper> provider7) {
        this.f13724a = provider;
        this.f13725b = provider2;
        this.f13726c = provider3;
        this.f13727d = provider4;
        this.f13728e = provider5;
        this.f13729f = provider6;
        this.f13730g = provider7;
    }

    public static MembersInjector<TemplateStoreFragment> create(Provider<TemplateCategoryManager> provider, Provider<UserProvider> provider2, Provider<ScreenLoader> provider3, Provider<SignInHelper> provider4, Provider<RemoteConfig> provider5, Provider<PremiumStatusHandler> provider6, Provider<TemplatesTranslationHelper> provider7) {
        return new TemplateStoreFragment_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static void injectCategoryManager(TemplateStoreFragment templateStoreFragment, TemplateCategoryManager templateCategoryManager) {
        templateStoreFragment.categoryManager = templateCategoryManager;
    }

    public static void injectPremiumStatusHandler(TemplateStoreFragment templateStoreFragment, PremiumStatusHandler premiumStatusHandler) {
        templateStoreFragment.premiumStatusHandler = premiumStatusHandler;
    }

    public static void injectRemoteConfig(TemplateStoreFragment templateStoreFragment, RemoteConfig remoteConfig) {
        templateStoreFragment.remoteConfig = remoteConfig;
    }

    public static void injectScreenLoader(TemplateStoreFragment templateStoreFragment, ScreenLoader screenLoader) {
        templateStoreFragment.screenLoader = screenLoader;
    }

    public static void injectSignInHelper(TemplateStoreFragment templateStoreFragment, SignInHelper signInHelper) {
        templateStoreFragment.signInHelper = signInHelper;
    }

    public static void injectTranslationHelper(TemplateStoreFragment templateStoreFragment, TemplatesTranslationHelper templatesTranslationHelper) {
        templateStoreFragment.translationHelper = templatesTranslationHelper;
    }

    public static void injectUserProvider(TemplateStoreFragment templateStoreFragment, UserProvider userProvider) {
        templateStoreFragment.userProvider = userProvider;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(TemplateStoreFragment templateStoreFragment) {
        injectCategoryManager(templateStoreFragment, this.f13724a.get());
        injectUserProvider(templateStoreFragment, this.f13725b.get());
        injectScreenLoader(templateStoreFragment, this.f13726c.get());
        injectSignInHelper(templateStoreFragment, this.f13727d.get());
        injectRemoteConfig(templateStoreFragment, this.f13728e.get());
        injectPremiumStatusHandler(templateStoreFragment, this.f13729f.get());
        injectTranslationHelper(templateStoreFragment, this.f13730g.get());
    }
}
