package com.arlosoft.macrodroid.templatestore.ui.templateList;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class LocalTemplateOverrideStore_Factory implements Factory<LocalTemplateOverrideStore> {

    /* renamed from: a  reason: collision with root package name */
    private static final LocalTemplateOverrideStore_Factory f13944a = new LocalTemplateOverrideStore_Factory();

    public static LocalTemplateOverrideStore_Factory create() {
        return f13944a;
    }

    public static LocalTemplateOverrideStore newLocalTemplateOverrideStore() {
        return new LocalTemplateOverrideStore();
    }

    public static LocalTemplateOverrideStore provideInstance() {
        return new LocalTemplateOverrideStore();
    }

    @Override // javax.inject.Provider
    public LocalTemplateOverrideStore get() {
        return provideInstance();
    }
}
