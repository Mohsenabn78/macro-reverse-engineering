package com.arlosoft.macrodroid.templatestore.ui.templateList.presenter;

import android.content.Context;
import com.arlosoft.macrodroid.app.navigation.ScreenLoader;
import com.arlosoft.macrodroid.categories.CategoriesHelper;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.macro.ActionBlockStore;
import com.arlosoft.macrodroid.settings.AppPreferences;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApi;
import com.arlosoft.macrodroid.templatestore.ui.templateList.LocalTemplateOverrideStore;
import com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateCategoryManager;
import com.arlosoft.macrodroid.templatestore.ui.upload.TemplateRefreshNotifier;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import com.google.gson.Gson;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class TemplateListPresenter_Factory implements Factory<TemplateListPresenter> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f14093a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ScreenLoader> f14094b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<TemplateStoreApi> f14095c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<UserProvider> f14096d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<LocalTemplateOverrideStore> f14097e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<Gson> f14098f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<TemplateCategoryManager> f14099g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<TemplateRefreshNotifier> f14100h;

    /* renamed from: i  reason: collision with root package name */
    private final Provider<AppPreferences> f14101i;

    /* renamed from: j  reason: collision with root package name */
    private final Provider<CategoriesHelper> f14102j;

    /* renamed from: k  reason: collision with root package name */
    private final Provider<ActionBlockStore> f14103k;

    /* renamed from: l  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f14104l;

    /* renamed from: m  reason: collision with root package name */
    private final Provider<MacroDroidRoomDatabase> f14105m;

    public TemplateListPresenter_Factory(Provider<Context> provider, Provider<ScreenLoader> provider2, Provider<TemplateStoreApi> provider3, Provider<UserProvider> provider4, Provider<LocalTemplateOverrideStore> provider5, Provider<Gson> provider6, Provider<TemplateCategoryManager> provider7, Provider<TemplateRefreshNotifier> provider8, Provider<AppPreferences> provider9, Provider<CategoriesHelper> provider10, Provider<ActionBlockStore> provider11, Provider<PremiumStatusHandler> provider12, Provider<MacroDroidRoomDatabase> provider13) {
        this.f14093a = provider;
        this.f14094b = provider2;
        this.f14095c = provider3;
        this.f14096d = provider4;
        this.f14097e = provider5;
        this.f14098f = provider6;
        this.f14099g = provider7;
        this.f14100h = provider8;
        this.f14101i = provider9;
        this.f14102j = provider10;
        this.f14103k = provider11;
        this.f14104l = provider12;
        this.f14105m = provider13;
    }

    public static TemplateListPresenter_Factory create(Provider<Context> provider, Provider<ScreenLoader> provider2, Provider<TemplateStoreApi> provider3, Provider<UserProvider> provider4, Provider<LocalTemplateOverrideStore> provider5, Provider<Gson> provider6, Provider<TemplateCategoryManager> provider7, Provider<TemplateRefreshNotifier> provider8, Provider<AppPreferences> provider9, Provider<CategoriesHelper> provider10, Provider<ActionBlockStore> provider11, Provider<PremiumStatusHandler> provider12, Provider<MacroDroidRoomDatabase> provider13) {
        return new TemplateListPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8, provider9, provider10, provider11, provider12, provider13);
    }

    public static TemplateListPresenter newTemplateListPresenter(Context context, ScreenLoader screenLoader, TemplateStoreApi templateStoreApi, UserProvider userProvider, LocalTemplateOverrideStore localTemplateOverrideStore, Gson gson, TemplateCategoryManager templateCategoryManager, TemplateRefreshNotifier templateRefreshNotifier, AppPreferences appPreferences, CategoriesHelper categoriesHelper, ActionBlockStore actionBlockStore, PremiumStatusHandler premiumStatusHandler, MacroDroidRoomDatabase macroDroidRoomDatabase) {
        return new TemplateListPresenter(context, screenLoader, templateStoreApi, userProvider, localTemplateOverrideStore, gson, templateCategoryManager, templateRefreshNotifier, appPreferences, categoriesHelper, actionBlockStore, premiumStatusHandler, macroDroidRoomDatabase);
    }

    public static TemplateListPresenter provideInstance(Provider<Context> provider, Provider<ScreenLoader> provider2, Provider<TemplateStoreApi> provider3, Provider<UserProvider> provider4, Provider<LocalTemplateOverrideStore> provider5, Provider<Gson> provider6, Provider<TemplateCategoryManager> provider7, Provider<TemplateRefreshNotifier> provider8, Provider<AppPreferences> provider9, Provider<CategoriesHelper> provider10, Provider<ActionBlockStore> provider11, Provider<PremiumStatusHandler> provider12, Provider<MacroDroidRoomDatabase> provider13) {
        return new TemplateListPresenter(provider.get(), provider2.get(), provider3.get(), provider4.get(), provider5.get(), provider6.get(), provider7.get(), provider8.get(), provider9.get(), provider10.get(), provider11.get(), provider12.get(), provider13.get());
    }

    @Override // javax.inject.Provider
    public TemplateListPresenter get() {
        return provideInstance(this.f14093a, this.f14094b, this.f14095c, this.f14096d, this.f14097e, this.f14098f, this.f14099g, this.f14100h, this.f14101i, this.f14102j, this.f14103k, this.f14104l, this.f14105m);
    }
}
