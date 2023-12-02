package com.arlosoft.macrodroid.templatestore.ui.comments;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class TemplateCommentsDataRepository_Factory implements Factory<TemplateCommentsDataRepository> {

    /* renamed from: a  reason: collision with root package name */
    private static final TemplateCommentsDataRepository_Factory f13750a = new TemplateCommentsDataRepository_Factory();

    public static TemplateCommentsDataRepository_Factory create() {
        return f13750a;
    }

    public static TemplateCommentsDataRepository newTemplateCommentsDataRepository() {
        return new TemplateCommentsDataRepository();
    }

    public static TemplateCommentsDataRepository provideInstance() {
        return new TemplateCommentsDataRepository();
    }

    @Override // javax.inject.Provider
    public TemplateCommentsDataRepository get() {
        return provideInstance();
    }
}
