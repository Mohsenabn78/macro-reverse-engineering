package com.arlosoft.macrodroid.templatestore.reportmacro;

import com.arlosoft.macrodroid.templatestore.api.TemplateStoreApi;
import com.arlosoft.macrodroid.templatestore.ui.templateList.LocalTemplateOverrideStore;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ReportMacroViewModel_Factory implements Factory<ReportMacroViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<TemplateStoreApi> f13678a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<LocalTemplateOverrideStore> f13679b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ReportMacroRepository> f13680c;

    public ReportMacroViewModel_Factory(Provider<TemplateStoreApi> provider, Provider<LocalTemplateOverrideStore> provider2, Provider<ReportMacroRepository> provider3) {
        this.f13678a = provider;
        this.f13679b = provider2;
        this.f13680c = provider3;
    }

    public static ReportMacroViewModel_Factory create(Provider<TemplateStoreApi> provider, Provider<LocalTemplateOverrideStore> provider2, Provider<ReportMacroRepository> provider3) {
        return new ReportMacroViewModel_Factory(provider, provider2, provider3);
    }

    public static ReportMacroViewModel newReportMacroViewModel(TemplateStoreApi templateStoreApi, LocalTemplateOverrideStore localTemplateOverrideStore, ReportMacroRepository reportMacroRepository) {
        return new ReportMacroViewModel(templateStoreApi, localTemplateOverrideStore, reportMacroRepository);
    }

    public static ReportMacroViewModel provideInstance(Provider<TemplateStoreApi> provider, Provider<LocalTemplateOverrideStore> provider2, Provider<ReportMacroRepository> provider3) {
        return new ReportMacroViewModel(provider.get(), provider2.get(), provider3.get());
    }

    @Override // javax.inject.Provider
    public ReportMacroViewModel get() {
        return provideInstance(this.f13678a, this.f13679b, this.f13680c);
    }
}
