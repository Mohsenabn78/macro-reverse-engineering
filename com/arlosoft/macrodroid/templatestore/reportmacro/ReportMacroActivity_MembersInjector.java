package com.arlosoft.macrodroid.templatestore.reportmacro;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ReportMacroActivity_MembersInjector implements MembersInjector<ReportMacroActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f13665a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ReportMacroViewModel> f13666b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ReportMacroRepository> f13667c;

    public ReportMacroActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ReportMacroViewModel> provider2, Provider<ReportMacroRepository> provider3) {
        this.f13665a = provider;
        this.f13666b = provider2;
        this.f13667c = provider3;
    }

    public static MembersInjector<ReportMacroActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ReportMacroViewModel> provider2, Provider<ReportMacroRepository> provider3) {
        return new ReportMacroActivity_MembersInjector(provider, provider2, provider3);
    }

    public static void injectReportMacroRepository(ReportMacroActivity reportMacroActivity, ReportMacroRepository reportMacroRepository) {
        reportMacroActivity.reportMacroRepository = reportMacroRepository;
    }

    public static void injectViewModel(ReportMacroActivity reportMacroActivity, ReportMacroViewModel reportMacroViewModel) {
        reportMacroActivity.viewModel = reportMacroViewModel;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(ReportMacroActivity reportMacroActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(reportMacroActivity, this.f13665a.get());
        injectViewModel(reportMacroActivity, this.f13666b.get());
        injectReportMacroRepository(reportMacroActivity, this.f13667c.get());
    }
}
