package com.arlosoft.macrodroid.templatestore.ui.subscription;

import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileImageProvider;
import com.arlosoft.macrodroid.templatestore.ui.subscription.viewmodel.TemplateUpdatesViewModel;
import dagger.MembersInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class TemplateUpdatesFragment_MembersInjector implements MembersInjector<TemplateUpdatesFragment> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<TemplateUpdatesViewModel> f13874a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<ProfileImageProvider> f13875b;

    public TemplateUpdatesFragment_MembersInjector(Provider<TemplateUpdatesViewModel> provider, Provider<ProfileImageProvider> provider2) {
        this.f13874a = provider;
        this.f13875b = provider2;
    }

    public static MembersInjector<TemplateUpdatesFragment> create(Provider<TemplateUpdatesViewModel> provider, Provider<ProfileImageProvider> provider2) {
        return new TemplateUpdatesFragment_MembersInjector(provider, provider2);
    }

    public static void injectProfileImageProvider(TemplateUpdatesFragment templateUpdatesFragment, ProfileImageProvider profileImageProvider) {
        templateUpdatesFragment.profileImageProvider = profileImageProvider;
    }

    public static void injectViewModel(TemplateUpdatesFragment templateUpdatesFragment, TemplateUpdatesViewModel templateUpdatesViewModel) {
        templateUpdatesFragment.viewModel = templateUpdatesViewModel;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(TemplateUpdatesFragment templateUpdatesFragment) {
        injectViewModel(templateUpdatesFragment, this.f13874a.get());
        injectProfileImageProvider(templateUpdatesFragment, this.f13875b.get());
    }
}
