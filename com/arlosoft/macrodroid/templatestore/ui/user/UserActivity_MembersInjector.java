package com.arlosoft.macrodroid.templatestore.ui.user;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import com.arlosoft.macrodroid.templatestore.ui.user.presenter.UserPresenter;
import com.arlosoft.macrodroid.user.signin.SignInHelper;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class UserActivity_MembersInjector implements MembersInjector<UserActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f14190a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<UserPresenter> f14191b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ProfileImageProvider> f14192c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<SignInHelper> f14193d;

    /* renamed from: e  reason: collision with root package name */
    private final Provider<UserProvider> f14194e;

    public UserActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<UserPresenter> provider2, Provider<ProfileImageProvider> provider3, Provider<SignInHelper> provider4, Provider<UserProvider> provider5) {
        this.f14190a = provider;
        this.f14191b = provider2;
        this.f14192c = provider3;
        this.f14193d = provider4;
        this.f14194e = provider5;
    }

    public static MembersInjector<UserActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<UserPresenter> provider2, Provider<ProfileImageProvider> provider3, Provider<SignInHelper> provider4, Provider<UserProvider> provider5) {
        return new UserActivity_MembersInjector(provider, provider2, provider3, provider4, provider5);
    }

    public static void injectPresenter(UserActivity userActivity, UserPresenter userPresenter) {
        userActivity.presenter = userPresenter;
    }

    public static void injectProfileImageProvider(UserActivity userActivity, ProfileImageProvider profileImageProvider) {
        userActivity.profileImageProvider = profileImageProvider;
    }

    public static void injectSignInHelper(UserActivity userActivity, SignInHelper signInHelper) {
        userActivity.signInHelper = signInHelper;
    }

    public static void injectUserProvider(UserActivity userActivity, UserProvider userProvider) {
        userActivity.userProvider = userProvider;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(UserActivity userActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(userActivity, this.f14190a.get());
        injectPresenter(userActivity, this.f14191b.get());
        injectProfileImageProvider(userActivity, this.f14192c.get());
        injectSignInHelper(userActivity, this.f14193d.get());
        injectUserProvider(userActivity, this.f14194e.get());
    }
}
