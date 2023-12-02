package com.arlosoft.macrodroid.translations;

import androidx.fragment.app.Fragment;
import com.arlosoft.macrodroid.app.base.MacroDroidDaggerBaseActivity_MembersInjector;
import com.arlosoft.macrodroid.templatestore.common.FlagProvider;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class TranslationsActivity_MembersInjector implements MembersInjector<TranslationsActivity> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<DispatchingAndroidInjector<Fragment>> f14287a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<TranslationsViewModel> f14288b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<FlagProvider> f14289c;

    public TranslationsActivity_MembersInjector(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<TranslationsViewModel> provider2, Provider<FlagProvider> provider3) {
        this.f14287a = provider;
        this.f14288b = provider2;
        this.f14289c = provider3;
    }

    public static MembersInjector<TranslationsActivity> create(Provider<DispatchingAndroidInjector<Fragment>> provider, Provider<TranslationsViewModel> provider2, Provider<FlagProvider> provider3) {
        return new TranslationsActivity_MembersInjector(provider, provider2, provider3);
    }

    public static void injectFlagProvider(TranslationsActivity translationsActivity, FlagProvider flagProvider) {
        translationsActivity.flagProvider = flagProvider;
    }

    public static void injectViewModel(TranslationsActivity translationsActivity, TranslationsViewModel translationsViewModel) {
        translationsActivity.viewModel = translationsViewModel;
    }

    @Override // dagger.MembersInjector
    public void injectMembers(TranslationsActivity translationsActivity) {
        MacroDroidDaggerBaseActivity_MembersInjector.injectDispatchingFragmentAndroidInjector(translationsActivity, this.f14287a.get());
        injectViewModel(translationsActivity, this.f14288b.get());
        injectFlagProvider(translationsActivity, this.f14289c.get());
    }
}
