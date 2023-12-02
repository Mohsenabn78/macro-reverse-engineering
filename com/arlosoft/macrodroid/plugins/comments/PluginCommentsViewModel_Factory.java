package com.arlosoft.macrodroid.plugins.comments;

import com.arlosoft.macrodroid.plugins.api.PluginListApi;
import com.arlosoft.macrodroid.plugins.data.LocalPluginListOverrideStore;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class PluginCommentsViewModel_Factory implements Factory<PluginCommentsViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PluginListApi> f13138a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<UserProvider> f13139b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<LocalPluginListOverrideStore> f13140c;

    public PluginCommentsViewModel_Factory(Provider<PluginListApi> provider, Provider<UserProvider> provider2, Provider<LocalPluginListOverrideStore> provider3) {
        this.f13138a = provider;
        this.f13139b = provider2;
        this.f13140c = provider3;
    }

    public static PluginCommentsViewModel_Factory create(Provider<PluginListApi> provider, Provider<UserProvider> provider2, Provider<LocalPluginListOverrideStore> provider3) {
        return new PluginCommentsViewModel_Factory(provider, provider2, provider3);
    }

    public static PluginCommentsViewModel newPluginCommentsViewModel(PluginListApi pluginListApi, UserProvider userProvider, LocalPluginListOverrideStore localPluginListOverrideStore) {
        return new PluginCommentsViewModel(pluginListApi, userProvider, localPluginListOverrideStore);
    }

    public static PluginCommentsViewModel provideInstance(Provider<PluginListApi> provider, Provider<UserProvider> provider2, Provider<LocalPluginListOverrideStore> provider3) {
        return new PluginCommentsViewModel(provider.get(), provider2.get(), provider3.get());
    }

    @Override // javax.inject.Provider
    public PluginCommentsViewModel get() {
        return provideInstance(this.f13138a, this.f13139b, this.f13140c);
    }
}
