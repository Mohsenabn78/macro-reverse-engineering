package com.arlosoft.macrodroid.translations;

import com.arlosoft.macrodroid.translations.data.TranslationDataRepository;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class TranslationsViewModel_Factory implements Factory<TranslationsViewModel> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<TranslationDataRepository> f14300a;

    public TranslationsViewModel_Factory(Provider<TranslationDataRepository> provider) {
        this.f14300a = provider;
    }

    public static TranslationsViewModel_Factory create(Provider<TranslationDataRepository> provider) {
        return new TranslationsViewModel_Factory(provider);
    }

    public static TranslationsViewModel newTranslationsViewModel(TranslationDataRepository translationDataRepository) {
        return new TranslationsViewModel(translationDataRepository);
    }

    public static TranslationsViewModel provideInstance(Provider<TranslationDataRepository> provider) {
        return new TranslationsViewModel(provider.get());
    }

    @Override // javax.inject.Provider
    public TranslationsViewModel get() {
        return provideInstance(this.f14300a);
    }
}
