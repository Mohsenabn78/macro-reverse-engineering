package com.arlosoft.macrodroid.templatestore.ui.templateList;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class TemplateCategoryManager_Factory implements Factory<TemplateCategoryManager> {

    /* renamed from: a  reason: collision with root package name */
    private static final TemplateCategoryManager_Factory f13948a = new TemplateCategoryManager_Factory();

    public static TemplateCategoryManager_Factory create() {
        return f13948a;
    }

    public static TemplateCategoryManager newTemplateCategoryManager() {
        return new TemplateCategoryManager();
    }

    public static TemplateCategoryManager provideInstance() {
        return new TemplateCategoryManager();
    }

    @Override // javax.inject.Provider
    public TemplateCategoryManager get() {
        return provideInstance();
    }
}
