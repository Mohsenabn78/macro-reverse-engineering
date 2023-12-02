package com.arlosoft.macrodroid.plugins;

import android.content.Context;
import com.arlosoft.macrodroid.plugins.api.AppBrainApi;
import com.arlosoft.macrodroid.plugins.api.PluginListApi;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class PluginsViewModel_Factory implements Factory<PluginsViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f13107a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PluginListApi> f13108b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<AppBrainApi> f13109c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<UserProvider> f13110d;

    public PluginsViewModel_Factory(Provider<Context> provider, Provider<PluginListApi> provider2, Provider<AppBrainApi> provider3, Provider<UserProvider> provider4) {
        this.f13107a = provider;
        this.f13108b = provider2;
        this.f13109c = provider3;
        this.f13110d = provider4;
    }

    public static PluginsViewModel_Factory create(Provider<Context> provider, Provider<PluginListApi> provider2, Provider<AppBrainApi> provider3, Provider<UserProvider> provider4) {
        return new PluginsViewModel_Factory(provider, provider2, provider3, provider4);
    }

    public static PluginsViewModel newPluginsViewModel(Context context, PluginListApi pluginListApi, AppBrainApi appBrainApi, UserProvider userProvider) {
        return new PluginsViewModel(context, pluginListApi, appBrainApi, userProvider);
    }

    public static PluginsViewModel provideInstance(Provider<Context> provider, Provider<PluginListApi> provider2, Provider<AppBrainApi> provider3, Provider<UserProvider> provider4) {
        return new PluginsViewModel(provider.get(), provider2.get(), provider3.get(), provider4.get());
    }

    @Override // javax.inject.Provider
    public PluginsViewModel get() {
        return provideInstance(this.f13107a, this.f13108b, this.f13109c, this.f13110d);
    }
}
