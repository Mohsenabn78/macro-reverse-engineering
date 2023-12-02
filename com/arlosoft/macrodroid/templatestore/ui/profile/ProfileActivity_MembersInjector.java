package com.arlosoft.macrodroid.templatestore.ui.profile;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ProfileActivity_MembersInjector implements MembersInjector<ProfileActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f13811a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ProfilePresenter> f13812b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<ProfileImageProvider> f13813c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<UserProvider> f13814d;

    public ProfileActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ProfilePresenter> provider2, Provider<ProfileImageProvider> provider3, Provider<UserProvider> provider4) {
        this.f13811a = provider;
        this.f13812b = provider2;
        this.f13813c = provider3;
        this.f13814d = provider4;
    }

    public static MembersInjector<ProfileActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<ProfilePresenter> provider2, Provider<ProfileImageProvider> provider3, Provider<UserProvider> provider4) {
        return new ProfileActivity_MembersInjector(provider, provider2, provider3, provider4);
    }

    public static void injectPresenter(ProfileActivity profileActivity, ProfilePresenter profilePresenter) {
        profileActivity.presenter = profilePresenter;
    }

    public static void injectProfileImageProvider(ProfileActivity profileActivity, ProfileImageProvider profileImageProvider) {
        profileActivity.profileImageProvider = profileImageProvider;
    }

    public static void injectUserProvider(ProfileActivity profileActivity, UserProvider userProvider) {
        profileActivity.userProvider = userProvider;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(ProfileActivity profileActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(profileActivity, this.f13811a.get());
        injectPresenter(profileActivity, this.f13812b.get());
        injectProfileImageProvider(profileActivity, this.f13813c.get());
        injectUserProvider(profileActivity, this.f13814d.get());
    }
}
