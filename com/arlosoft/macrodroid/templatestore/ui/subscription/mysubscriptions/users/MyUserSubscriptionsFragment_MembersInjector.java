package com.arlosoft.macrodroid.templatestore.ui.subscription.mysubscriptions.users;

import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import com.arlosoft.macrodroid.templatestore.ui.subscription.mysubscriptions.users.viewmodel.MyUserSubscriptionsViewModel;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class MyUserSubscriptionsFragment_MembersInjector implements MembersInjector<MyUserSubscriptionsFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MyUserSubscriptionsViewModel> f13911a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ProfileImageProvider> f13912b;

    public MyUserSubscriptionsFragment_MembersInjector(Provider<MyUserSubscriptionsViewModel> provider, Provider<ProfileImageProvider> provider2) {
        this.f13911a = provider;
        this.f13912b = provider2;
    }

    public static MembersInjector<MyUserSubscriptionsFragment> create(Provider<MyUserSubscriptionsViewModel> provider, Provider<ProfileImageProvider> provider2) {
        return new MyUserSubscriptionsFragment_MembersInjector(provider, provider2);
    }

    public static void injectProfileImageProvider(MyUserSubscriptionsFragment myUserSubscriptionsFragment, ProfileImageProvider profileImageProvider) {
        myUserSubscriptionsFragment.profileImageProvider = profileImageProvider;
    }

    public static void injectViewModel(MyUserSubscriptionsFragment myUserSubscriptionsFragment, MyUserSubscriptionsViewModel myUserSubscriptionsViewModel) {
        myUserSubscriptionsFragment.viewModel = myUserSubscriptionsViewModel;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MyUserSubscriptionsFragment myUserSubscriptionsFragment) {
        injectViewModel(myUserSubscriptionsFragment, this.f13911a.get());
        injectProfileImageProvider(myUserSubscriptionsFragment, this.f13912b.get());
    }
}
