package com.arlosoft.macrodroid.templatestore.ui.upload;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class TemplateRefreshNotifier_Factory implements Factory<TemplateRefreshNotifier> {

    /* renamed from: a  reason: collision with root package name */
    private static final TemplateRefreshNotifier_Factory f14133a = new TemplateRefreshNotifier_Factory();

    public static TemplateRefreshNotifier_Factory create() {
        return f14133a;
    }

    public static TemplateRefreshNotifier newTemplateRefreshNotifier() {
        return new TemplateRefreshNotifier();
    }

    public static TemplateRefreshNotifier provideInstance() {
        return new TemplateRefreshNotifier();
    }

    @Override // javax.inject.Provider
    public TemplateRefreshNotifier get() {
        return provideInstance();
    }
}
