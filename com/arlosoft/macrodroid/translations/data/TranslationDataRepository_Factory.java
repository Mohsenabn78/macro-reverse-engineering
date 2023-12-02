package com.arlosoft.macrodroid.translations.data;

import android.content.Context;
import com.arlosoft.macrodroid.translations.api.MacroDroidTranslationsApi;
import dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class TranslationDataRepository_Factory implements Factory<TranslationDataRepository> {

    /* renamed from: a  reason: collision with root package name */
    private final Provider<Context> f14307a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<MacroDroidTranslationsApi> f14308b;

    public TranslationDataRepository_Factory(Provider<Context> provider, Provider<MacroDroidTranslationsApi> provider2) {
        this.f14307a = provider;
        this.f14308b = provider2;
    }

    public static TranslationDataRepository_Factory create(Provider<Context> provider, Provider<MacroDroidTranslationsApi> provider2) {
        return new TranslationDataRepository_Factory(provider, provider2);
    }

    public static TranslationDataRepository newTranslationDataRepository(Context context, MacroDroidTranslationsApi macroDroidTranslationsApi) {
        return new TranslationDataRepository(context, macroDroidTranslationsApi);
    }

    public static TranslationDataRepository provideInstance(Provider<Context> provider, Provider<MacroDroidTranslationsApi> provider2) {
        return new TranslationDataRepository(provider.get(), provider2.get());
    }

    @Override // javax.inject.Provider
    public TranslationDataRepository get() {
        return provideInstance(this.f14307a, this.f14308b);
    }
}
