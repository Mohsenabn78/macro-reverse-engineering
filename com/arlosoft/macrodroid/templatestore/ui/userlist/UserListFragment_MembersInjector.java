package com.arlosoft.macrodroid.templatestore.ui.userlist;

import com.arlosoft.macrodroid.database.room.MacroDroidRoomDatabase;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import com.arlosoft.macrodroid.templatestore.ui.user.UserProvider;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class UserListFragment_MembersInjector implements MembersInjector<UserListFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<UserListPresenter> f14243a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ProfileImageProvider> f14244b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<UserProvider> f14245c;

    /* renamed from: d  reason: collision with root package name */
    private final Provider<MacroDroidRoomDatabase> f14246d;

    public UserListFragment_MembersInjector(Provider<UserListPresenter> provider, Provider<ProfileImageProvider> provider2, Provider<UserProvider> provider3, Provider<MacroDroidRoomDatabase> provider4) {
        this.f14243a = provider;
        this.f14244b = provider2;
        this.f14245c = provider3;
        this.f14246d = provider4;
    }

    public static MembersInjector<UserListFragment> create(Provider<UserListPresenter> provider, Provider<ProfileImageProvider> provider2, Provider<UserProvider> provider3, Provider<MacroDroidRoomDatabase> provider4) {
        return new UserListFragment_MembersInjector(provider, provider2, provider3, provider4);
    }

    public static void injectPresenter(UserListFragment userListFragment, UserListPresenter userListPresenter) {
        userListFragment.presenter = userListPresenter;
    }

    public static void injectProfileImageProvider(UserListFragment userListFragment, ProfileImageProvider profileImageProvider) {
        userListFragment.profileImageProvider = profileImageProvider;
    }

    public static void injectRoomDatabase(UserListFragment userListFragment, MacroDroidRoomDatabase macroDroidRoomDatabase) {
        userListFragment.roomDatabase = macroDroidRoomDatabase;
    }

    public static void injectUserProvider(UserListFragment userListFragment, UserProvider userProvider) {
        userListFragment.userProvider = userProvider;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(UserListFragment userListFragment) {
        injectPresenter(userListFragment, this.f14243a.get());
        injectProfileImageProvider(userListFragment, this.f14244b.get());
        injectUserProvider(userListFragment, this.f14245c.get());
        injectRoomDatabase(userListFragment, this.f14246d.get());
    }
}
