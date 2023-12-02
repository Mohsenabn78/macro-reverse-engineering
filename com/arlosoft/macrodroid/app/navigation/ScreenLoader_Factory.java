package com.arlosoft.macrodroid.app.navigation;

import android.app.Activity;
import com.arlosoft.macrodroid.templatestore.reportmacro.ReportMacroRepository;
import com.arlosoft.macrodroid.templatestore.ui.comments.TemplateCommentsDataRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ScreenLoader_Factory implements Factory<ScreenLoader> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Activity> f9296a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ReportMacroRepository> f9297b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<TemplateCommentsDataRepository> f9298c;

    public ScreenLoader_Factory(Provider<Activity> provider, Provider<ReportMacroRepository> provider2, Provider<TemplateCommentsDataRepository> provider3) {
        this.f9296a = provider;
        this.f9297b = provider2;
        this.f9298c = provider3;
    }

    public static ScreenLoader_Factory create(Provider<Activity> provider, Provider<ReportMacroRepository> provider2, Provider<TemplateCommentsDataRepository> provider3) {
        return new ScreenLoader_Factory(provider, provider2, provider3);
    }

    public static ScreenLoader newScreenLoader(Activity activity, ReportMacroRepository reportMacroRepository) {
        return new ScreenLoader(activity, reportMacroRepository);
    }

    public static ScreenLoader provideInstance(Provider<Activity> provider, Provider<ReportMacroRepository> provider2, Provider<TemplateCommentsDataRepository> provider3) {
        ScreenLoader screenLoader = new ScreenLoader(provider.get(), provider2.get());
        ScreenLoader_MembersInjector.injectTemplateCommentsDataRepository(screenLoader, provider3.get());
        return screenLoader;
    }

    @Override // javax.inject.Provider
    public ScreenLoader get() {
        return provideInstance(this.f9296a, this.f9297b, this.f9298c);
    }
}
