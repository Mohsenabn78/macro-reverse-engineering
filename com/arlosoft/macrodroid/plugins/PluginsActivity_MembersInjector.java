package com.arlosoft.macrodroid.plugins;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import com.arlosoft.macrodroid.app.navigation.ScreenLoader;
import com.arlosoft.macrodroid.confirmation.PremiumStatusHandler;
import com.arlosoft.macrodroid.templatestore.common.FlagProvider;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import com.arlosoft.macrodroid.user.signin.SignInHelper;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class PluginsActivity_MembersInjector implements MembersInjector<PluginsActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f13082a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ScreenLoader> f13083b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<UserProvider> f13084c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<SignInHelper> f13085d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<FlagProvider> f13086e;

    /* renamed from: f  reason: collision with root package name */
    private final Provider<PluginsViewModel> f13087f;

    /* renamed from: g  reason: collision with root package name */
    private final Provider<ProfileImageProvider> f13088g;

    /* renamed from: h  reason: collision with root package name */
    private final Provider<PremiumStatusHandler> f13089h;

    public PluginsActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ScreenLoader> provider2, Provider<UserProvider> provider3, Provider<SignInHelper> provider4, Provider<FlagProvider> provider5, Provider<PluginsViewModel> provider6, Provider<ProfileImageProvider> provider7, Provider<PremiumStatusHandler> provider8) {
        this.f13082a = provider;
        this.f13083b = provider2;
        this.f13084c = provider3;
        this.f13085d = provider4;
        this.f13086e = provider5;
        this.f13087f = provider6;
        this.f13088g = provider7;
        this.f13089h = provider8;
    }

    public static MembersInjector<PluginsActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ScreenLoader> provider2, Provider<UserProvider> provider3, Provider<SignInHelper> provider4, Provider<FlagProvider> provider5, Provider<PluginsViewModel> provider6, Provider<ProfileImageProvider> provider7, Provider<PremiumStatusHandler> provider8) {
        return new PluginsActivity_MembersInjector(provider, provider2, provider3, provider4, provider5, provider6, provider7, provider8);
    }

    public static void injectFlagProvider(PluginsActivity pluginsActivity, FlagProvider flagProvider) {
        pluginsActivity.flagProvider = flagProvider;
    }

    public static void injectPremiumStatusHandler(PluginsActivity pluginsActivity, PremiumStatusHandler premiumStatusHandler) {
        pluginsActivity.premiumStatusHandler = premiumStatusHandler;
    }

    public static void injectProfileImageProvider(PluginsActivity pluginsActivity, ProfileImageProvider profileImageProvider) {
        pluginsActivity.profileImageProvider = profileImageProvider;
    }

    public static void injectScreenLoader(PluginsActivity pluginsActivity, ScreenLoader screenLoader) {
        pluginsActivity.screenLoader = screenLoader;
    }

    public static void injectSignInHelper(PluginsActivity pluginsActivity, SignInHelper signInHelper) {
        pluginsActivity.signInHelper = signInHelper;
    }

    public static void injectUserProvider(PluginsActivity pluginsActivity, UserProvider userProvider) {
        pluginsActivity.userProvider = userProvider;
    }

    public static void injectViewModel(PluginsActivity pluginsActivity, PluginsViewModel pluginsViewModel) {
        pluginsActivity.viewModel = pluginsViewModel;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(PluginsActivity pluginsActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(pluginsActivity, this.f13082a.get());
        injectScreenLoader(pluginsActivity, this.f13083b.get());
        injectUserProvider(pluginsActivity, this.f13084c.get());
        injectSignInHelper(pluginsActivity, this.f13085d.get());
        injectFlagProvider(pluginsActivity, this.f13086e.get());
        injectViewModel(pluginsActivity, this.f13087f.get());
        injectProfileImageProvider(pluginsActivity, this.f13088g.get());
        injectPremiumStatusHandler(pluginsActivity, this.f13089h.get());
    }
}
