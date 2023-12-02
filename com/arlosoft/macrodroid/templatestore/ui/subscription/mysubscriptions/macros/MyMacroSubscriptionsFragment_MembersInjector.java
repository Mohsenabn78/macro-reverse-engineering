package com.arlosoft.macrodroid.templatestore.ui.subscription.mysubscriptions.macros;

import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import com.arlosoft.macrodroid.templatestore.ui.subscription.mysubscriptions.macros.viewmodel.MyMacroSubscriptionsViewModel;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class MyMacroSubscriptionsFragment_MembersInjector implements MembersInjector<MyMacroSubscriptionsFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<MyMacroSubscriptionsViewModel> f13887a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ProfileImageProvider> f13888b;

    public MyMacroSubscriptionsFragment_MembersInjector(Provider<MyMacroSubscriptionsViewModel> provider, Provider<ProfileImageProvider> provider2) {
        this.f13887a = provider;
        this.f13888b = provider2;
    }

    public static MembersInjector<MyMacroSubscriptionsFragment> create(Provider<MyMacroSubscriptionsViewModel> provider, Provider<ProfileImageProvider> provider2) {
        return new MyMacroSubscriptionsFragment_MembersInjector(provider, provider2);
    }

    public static void injectProfileImageProvider(MyMacroSubscriptionsFragment myMacroSubscriptionsFragment, ProfileImageProvider profileImageProvider) {
        myMacroSubscriptionsFragment.profileImageProvider = profileImageProvider;
    }

    public static void injectViewModel(MyMacroSubscriptionsFragment myMacroSubscriptionsFragment, MyMacroSubscriptionsViewModel myMacroSubscriptionsViewModel) {
        myMacroSubscriptionsFragment.viewModel = myMacroSubscriptionsViewModel;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(MyMacroSubscriptionsFragment myMacroSubscriptionsFragment) {
        injectViewModel(myMacroSubscriptionsFragment, this.f13887a.get());
        injectProfileImageProvider(myMacroSubscriptionsFragment, this.f13888b.get());
    }
}
