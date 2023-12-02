package com.arlosoft.macrodroid.templatestore.ui.upload;

import android.content.Context;
import com.arlosoft.macrodroid.categories.CategoriesHelper;
import com.arlosoft.macrodroid.macro.ActionBlockStore;
import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApi;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import com.google.gson.Gson;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class TemplateUploadPresenter_Factory implements Factory<TemplateUploadPresenter> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<TemplateStoreApi> f14159a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<UserProvider> f14160b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<Gson> f14161c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<Context> f14162d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<TemplateRefreshNotifier> f14163e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<CategoriesHelper> f14164f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<ActionBlockStore> f14165g;

    public TemplateUploadPresenter_Factory(Provider<TemplateStoreApi> provider, Provider<UserProvider> provider2, Provider<Gson> provider3, Provider<Context> provider4, Provider<TemplateRefreshNotifier> provider5, Provider<CategoriesHelper> provider6, Provider<ActionBlockStore> provider7) {
        this.f14159a = provider;
        this.f14160b = provider2;
        this.f14161c = provider3;
        this.f14162d = provider4;
        this.f14163e = provider5;
        this.f14164f = provider6;
        this.f14165g = provider7;
    }

    public static TemplateUploadPresenter_Factory create(Provider<TemplateStoreApi> provider, Provider<UserProvider> provider2, Provider<Gson> provider3, Provider<Context> provider4, Provider<TemplateRefreshNotifier> provider5, Provider<CategoriesHelper> provider6, Provider<ActionBlockStore> provider7) {
        return new TemplateUploadPresenter_Factory(provider, provider2, provider3, provider4, provider5, provider6, provider7);
    }

    public static TemplateUploadPresenter newTemplateUploadPresenter(TemplateStoreApi templateStoreApi, UserProvider userProvider, Gson gson, Context context, TemplateRefreshNotifier templateRefreshNotifier, CategoriesHelper categoriesHelper, ActionBlockStore actionBlockStore) {
        return new TemplateUploadPresenter(templateStoreApi, userProvider, gson, context, templateRefreshNotifier, categoriesHelper, actionBlockStore);
    }

    public static TemplateUploadPresenter provideInstance(Provider<TemplateStoreApi> provider, Provider<UserProvider> provider2, Provider<Gson> provider3, Provider<Context> provider4, Provider<TemplateRefreshNotifier> provider5, Provider<CategoriesHelper> provider6, Provider<ActionBlockStore> provider7) {
        return new TemplateUploadPresenter(provider.get(), provider2.get(), provider3.get(), provider4.get(), provider5.get(), provider6.get(), provider7.get());
    }

    @Override // javax.inject.Provider
    public TemplateUploadPresenter get() {
        return provideInstance(this.f14159a, this.f14160b, this.f14161c, this.f14162d, this.f14163e, this.f14164f, this.f14165g);
    }
}
