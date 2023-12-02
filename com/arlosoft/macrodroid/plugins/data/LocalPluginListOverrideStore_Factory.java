package com.arlosoft.macrodroid.plugins.data;

import dagger.internal.Factory;

/* loaded from: classes3.dex */
public final class LocalPluginListOverrideStore_Factory implements Factory<LocalPluginListOverrideStore> {

    /* renamed from: a  reason: collision with root package name */
    private static final LocalPluginListOverrideStore_Factory f13172a = new LocalPluginListOverrideStore_Factory();

    public static LocalPluginListOverrideStore_Factory create() {
        return f13172a;
    }

    public static LocalPluginListOverrideStore newLocalPluginListOverrideStore() {
        return new LocalPluginListOverrideStore();
    }

    public static LocalPluginListOverrideStore provideInstance() {
        return new LocalPluginListOverrideStore();
    }

    @Override // javax.inject.Provider
    public LocalPluginListOverrideStore get() {
        return provideInstance();
    }
}
