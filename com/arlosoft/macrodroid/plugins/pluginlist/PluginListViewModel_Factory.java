package com.arlosoft.macrodroid.plugins.pluginlist;

import android.content.Context;
import com.arlosoft.macrodroid.app.navigation.ScreenLoader;
import com.arlosoft.macrodroid.plugins.api.PluginListApi;
import com.arlosoft.macrodroid.plugins.data.LocalPluginListOverrideStore;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class PluginListViewModel_Factory implements Factory<PluginListViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PluginListApi> f13231a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<UserProvider> f13232b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ScreenLoader> f13233c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<LocalPluginListOverrideStore> f13234d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<Context> f13235e;

    public PluginListViewModel_Factory(Provider<PluginListApi> provider, Provider<UserProvider> provider2, Provider<ScreenLoader> provider3, Provider<LocalPluginListOverrideStore> provider4, Provider<Context> provider5) {
        this.f13231a = provider;
        this.f13232b = provider2;
        this.f13233c = provider3;
        this.f13234d = provider4;
        this.f13235e = provider5;
    }

    public static PluginListViewModel_Factory create(Provider<PluginListApi> provider, Provider<UserProvider> provider2, Provider<ScreenLoader> provider3, Provider<LocalPluginListOverrideStore> provider4, Provider<Context> provider5) {
        return new PluginListViewModel_Factory(provider, provider2, provider3, provider4, provider5);
    }

    public static PluginListViewModel newPluginListViewModel(PluginListApi pluginListApi, UserProvider userProvider, ScreenLoader screenLoader, LocalPluginListOverrideStore localPluginListOverrideStore, Context context) {
        return new PluginListViewModel(pluginListApi, userProvider, screenLoader, localPluginListOverrideStore, context);
    }

    public static PluginListViewModel provideInstance(Provider<PluginListApi> provider, Provider<UserProvider> provider2, Provider<ScreenLoader> provider3, Provider<LocalPluginListOverrideStore> provider4, Provider<Context> provider5) {
        return new PluginListViewModel(provider.get(), provider2.get(), provider3.get(), provider4.get(), provider5.get());
    }

    @Override // javax.inject.Provider
    public PluginListViewModel get() {
        return provideInstance(this.f13231a, this.f13232b, this.f13233c, this.f13234d, this.f13235e);
    }
}
