package com.arlosoft.macrodroid.plugins.comments;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class PluginCommentsActivity_MembersInjector implements MembersInjector<PluginCommentsActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f13123a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<PluginCommentsViewModel> f13124b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<UserProvider> f13125c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<ProfileImageProvider> f13126d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f13127e;

    public PluginCommentsActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<PluginCommentsViewModel> provider2, Provider<UserProvider> provider3, Provider<ProfileImageProvider> provider4, Provider<PremiumStatusHandler> provider5) {
        this.f13123a = provider;
        this.f13124b = provider2;
        this.f13125c = provider3;
        this.f13126d = provider4;
        this.f13127e = provider5;
    }

    public static MembersInjector<PluginCommentsActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<PluginCommentsViewModel> provider2, Provider<UserProvider> provider3, Provider<ProfileImageProvider> provider4, Provider<PremiumStatusHandler> provider5) {
        return new PluginCommentsActivity_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    public static void injectPremiumStatusHandler(PluginCommentsActivity pluginCommentsActivity, PremiumStatusHandler premiumStatusHandler) {
        pluginCommentsActivity.premiumStatusHandler = premiumStatusHandler;
    }

    public static void injectProfileImageProvider(PluginCommentsActivity pluginCommentsActivity, ProfileImageProvider profileImageProvider) {
        pluginCommentsActivity.profileImageProvider = profileImageProvider;
    }

    public static void injectUserProvider(PluginCommentsActivity pluginCommentsActivity, UserProvider userProvider) {
        pluginCommentsActivity.userProvider = userProvider;
    }

    public static void injectViewModel(PluginCommentsActivity pluginCommentsActivity, PluginCommentsViewModel pluginCommentsViewModel) {
        pluginCommentsActivity.viewModel = pluginCommentsViewModel;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(PluginCommentsActivity pluginCommentsActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(pluginCommentsActivity, this.f13123a.get());
        injectViewModel(pluginCommentsActivity, this.f13124b.get());
        injectUserProvider(pluginCommentsActivity, this.f13125c.get());
        injectProfileImageProvider(pluginCommentsActivity, this.f13126d.get());
        injectPremiumStatusHandler(pluginCommentsActivity, this.f13127e.get());
    }
}
