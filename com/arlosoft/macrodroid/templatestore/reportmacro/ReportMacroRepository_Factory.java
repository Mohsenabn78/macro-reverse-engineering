package com.arlosoft.macrodroid.templatestore.reportmacro;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class ReportMacroRepository_Factory implements Factory<ReportMacroRepository> {

    /* renamed from: a  reason: collision with root package name */
    private static final ReportMacroRepository_Factory f13669a = new ReportMacroRepository_Factory();

    public static ReportMacroRepository_Factory create() {
        return f13669a;
    }

    public static ReportMacroRepository newReportMacroRepository() {
        return new ReportMacroRepository();
    }

    public static ReportMacroRepository provideInstance() {
        return new ReportMacroRepository();
    }

    @Override // javax.inject.Provider
    public ReportMacroRepository get() {
        return provideInstance();
    }
}
