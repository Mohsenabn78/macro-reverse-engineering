package com.arlosoft.macrodroid.plugins.pluginlist;

import com.arlosoft.macrodroid.plugins.PluginsViewModel;
import com.arlosoft.macrodroid.plugins.data.LocalPluginListOverrideStore;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import com.arlosoft.macrodroid.user.signin.SignInHelper;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class PluginListFragment_MembersInjector implements MembersInjector<PluginListFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<PluginListViewModel> f13214a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ProfileImageProvider> f13215b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<SignInHelper> f13216c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<LocalPluginListOverrideStore> f13217d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<PluginsViewModel> f13218e;

    public PluginListFragment_MembersInjector(Provider<PluginListViewModel> provider, Provider<ProfileImageProvider> provider2, Provider<SignInHelper> provider3, Provider<LocalPluginListOverrideStore> provider4, Provider<PluginsViewModel> provider5) {
        this.f13214a = provider;
        this.f13215b = provider2;
        this.f13216c = provider3;
        this.f13217d = provider4;
        this.f13218e = provider5;
    }

    public static MembersInjector<PluginListFragment> create(Provider<PluginListViewModel> provider, Provider<ProfileImageProvider> provider2, Provider<SignInHelper> provider3, Provider<LocalPluginListOverrideStore> provider4, Provider<PluginsViewModel> provider5) {
        return new PluginListFragment_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    public static void injectPluginListOverrideStore(PluginListFragment pluginListFragment, LocalPluginListOverrideStore localPluginListOverrideStore) {
        pluginListFragment.pluginListOverrideStore = localPluginListOverrideStore;
    }

    public static void injectPluginsViewModel(PluginListFragment pluginListFragment, PluginsViewModel pluginsViewModel) {
        pluginListFragment.pluginsViewModel = pluginsViewModel;
    }

    public static void injectProfileImageProvider(PluginListFragment pluginListFragment, ProfileImageProvider profileImageProvider) {
        pluginListFragment.profileImageProvider = profileImageProvider;
    }

    public static void injectSignInHelper(PluginListFragment pluginListFragment, SignInHelper signInHelper) {
        pluginListFragment.signInHelper = signInHelper;
    }

    public static void injectViewModel(PluginListFragment pluginListFragment, PluginListViewModel pluginListViewModel) {
        pluginListFragment.viewModel = pluginListViewModel;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(PluginListFragment pluginListFragment) {
        injectViewModel(pluginListFragment, this.f13214a.get());
        injectProfileImageProvider(pluginListFragment, this.f13215b.get());
        injectSignInHelper(pluginListFragment, this.f13216c.get());
        injectPluginListOverrideStore(pluginListFragment, this.f13217d.get());
        injectPluginsViewModel(pluginListFragment, this.f13218e.get());
    }
}
